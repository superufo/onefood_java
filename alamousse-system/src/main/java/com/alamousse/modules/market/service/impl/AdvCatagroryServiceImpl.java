package com.alamousse.modules.market.service.impl;

import com.alamousse.modules.market.domain.AdvCatagrory;
import com.alamousse.utils.ValidationUtil;
import com.alamousse.modules.market.repository.AdvCatagroryRepository;
import com.alamousse.modules.market.service.AdvCatagroryService;
import com.alamousse.modules.market.service.dto.AdvCatagroryDTO;
import com.alamousse.modules.market.service.dto.AdvCatagroryQueryCriteria;
import com.alamousse.modules.market.service.mapper.AdvCatagroryMapper;
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
public class AdvCatagroryServiceImpl implements AdvCatagroryService {

    @Autowired
    private AdvCatagroryRepository advCatagroryRepository;

    @Autowired
    private AdvCatagroryMapper advCatagroryMapper;

    @Override
    public Object queryAll(AdvCatagroryQueryCriteria criteria, Pageable pageable){
        Page<AdvCatagrory> page = advCatagroryRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(advCatagroryMapper::toDto));
    }

    @Override
    public Object queryAll(AdvCatagroryQueryCriteria criteria){
        return advCatagroryMapper.toDto(advCatagroryRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public AdvCatagroryDTO findById(Integer id) {
        Optional<AdvCatagrory> advCatagrory = advCatagroryRepository.findById(id);
        ValidationUtil.isNull(advCatagrory,"AdvCatagrory","id",id);
        return advCatagroryMapper.toDto(advCatagrory.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AdvCatagroryDTO create(AdvCatagrory resources) {
        return advCatagroryMapper.toDto(advCatagroryRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(AdvCatagrory resources) {
        Optional<AdvCatagrory> optionalAdvCatagrory = advCatagroryRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalAdvCatagrory,"AdvCatagrory","id",resources.getId());
        AdvCatagrory advCatagrory = optionalAdvCatagrory.get();
        advCatagrory.copy(resources);
        advCatagroryRepository.save(advCatagrory);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        advCatagroryRepository.deleteById(id);
    }
}