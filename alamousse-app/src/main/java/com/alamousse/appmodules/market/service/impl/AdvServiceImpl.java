package com.alamousse.appmodules.market.service.impl;

import com.alamousse.appmodules.market.domain.Adv;
import com.alamousse.utils.ValidationUtil;
import com.alamousse.appmodules.market.repository.AdvRepository;
import com.alamousse.appmodules.market.service.AdvService;
import com.alamousse.appmodules.market.service.dto.AdvDTO;
import com.alamousse.appmodules.market.service.dto.AdvQueryCriteria;
import com.alamousse.appmodules.market.service.mapper.AdvMapper;
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
public class AdvServiceImpl implements AdvService {

    @Autowired
    private AdvRepository advRepository;

    @Autowired
    private AdvMapper advMapper;

    @Override
    public Object queryAll(AdvQueryCriteria criteria, Pageable pageable){
        Page<Adv> page = advRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(advMapper::toDto));
    }

    @Override
    public Object queryAll(AdvQueryCriteria criteria){
        return advMapper.toDto(advRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public AdvDTO findById(Integer id) {
        Optional<Adv> adv = advRepository.findById(id);
        ValidationUtil.isNull(adv,"Adv","id",id);
        return advMapper.toDto(adv.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AdvDTO create(Adv resources) {
        return advMapper.toDto(advRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Adv resources) {
        Optional<Adv> optionalAdv = advRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalAdv,"Adv","id",resources.getId());
        Adv adv = optionalAdv.get();
        adv.copy(resources);
        advRepository.save(adv);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        advRepository.deleteById(id);
    }
}
