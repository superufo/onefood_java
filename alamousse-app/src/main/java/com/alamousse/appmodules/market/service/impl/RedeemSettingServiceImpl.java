package com.alamousse.appmodules.market.service.impl;

import com.alamousse.appmodules.market.domain.RedeemSetting;
import com.alamousse.appmodules.market.repository.RedeemSettingRepository;
import com.alamousse.appmodules.market.service.RedeemSettingService;
import com.alamousse.appmodules.market.service.dto.RedeemSettingDTO;
import com.alamousse.appmodules.market.service.dto.RedeemSettingQueryCriteria;
import com.alamousse.appmodules.market.service.mapper.RedeemSettingMapper;
import com.alamousse.utils.PageUtil;
import com.alamousse.utils.QueryHelp;
import com.alamousse.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
* @author mike
* @date 2019-08-01
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RedeemSettingServiceImpl implements RedeemSettingService {

    @Autowired
    private RedeemSettingRepository redeemSettingRepository;

    @Autowired
    private RedeemSettingMapper redeemSettingMapper;

    @Override
    public Object queryAll(RedeemSettingQueryCriteria criteria, Pageable pageable){
        Page<RedeemSetting> page = redeemSettingRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(redeemSettingMapper::toDto));
    }

    @Override
    public Object queryAll(RedeemSettingQueryCriteria criteria){
        return redeemSettingMapper.toDto(redeemSettingRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public RedeemSettingDTO findById(Integer id) {
        Optional<RedeemSetting> redeemSetting = redeemSettingRepository.findById(id);
        ValidationUtil.isNull(redeemSetting,"RedeemSetting","id",id);
        return redeemSettingMapper.toDto(redeemSetting.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RedeemSettingDTO create(RedeemSetting resources) {
        return redeemSettingMapper.toDto(redeemSettingRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(RedeemSetting resources) {
        Optional<RedeemSetting> optionalRedeemSetting = redeemSettingRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalRedeemSetting,"RedeemSetting","id",resources.getId());
        RedeemSetting redeemSetting = optionalRedeemSetting.get();
        redeemSetting.copy(resources);
        redeemSettingRepository.save(redeemSetting);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        redeemSettingRepository.deleteById(id);
    }
}
