package com.alamousse.appmodules.market.service.impl;

import com.alamousse.appmodules.market.domain.PromoteSetting;
import com.alamousse.utils.ValidationUtil;
import com.alamousse.appmodules.market.repository.PromoteSettingRepository;
import com.alamousse.appmodules.market.service.PromoteSettingService;
import com.alamousse.appmodules.market.service.dto.PromoteSettingDTO;
import com.alamousse.appmodules.market.service.dto.PromoteSettingQueryCriteria;
import com.alamousse.appmodules.market.service.mapper.PromoteSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.alamousse.utils.PageUtil;
import com.alamousse.utils.QueryHelp;

/**
* @author mike
* @date 2019-08-01
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PromoteSettingServiceImpl implements PromoteSettingService {

    @Autowired
    private PromoteSettingRepository promoteSettingRepository;

    @Autowired
    private PromoteSettingMapper promoteSettingMapper;

    @Override
    public Object queryAll(PromoteSettingQueryCriteria criteria, Pageable pageable){
        Page<PromoteSetting> page = promoteSettingRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(promoteSettingMapper::toDto));
    }

    @Override
    public Object queryAll(PromoteSettingQueryCriteria criteria){
        return promoteSettingMapper.toDto(promoteSettingRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public PromoteSettingDTO findById(Integer id) {
        Optional<PromoteSetting> promoteSetting = promoteSettingRepository.findById(id);
        ValidationUtil.isNull(promoteSetting,"PromoteSetting","id",id);
        return promoteSettingMapper.toDto(promoteSetting.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PromoteSettingDTO create(PromoteSetting resources) {
        return promoteSettingMapper.toDto(promoteSettingRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(PromoteSetting resources) {
        Optional<PromoteSetting> optionalPromoteSetting = promoteSettingRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalPromoteSetting,"PromoteSetting","id",resources.getId());
        PromoteSetting promoteSetting = optionalPromoteSetting.get();
        promoteSetting.copy(resources);
        promoteSettingRepository.save(promoteSetting);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        promoteSettingRepository.deleteById(id);
    }
}
