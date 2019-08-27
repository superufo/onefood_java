package com.alamousse.modules.market.service.impl;

import com.alamousse.modules.market.domain.PromoteCode;
import com.alamousse.utils.ValidationUtil;
import com.alamousse.modules.market.repository.PromoteCodeRepository;
import com.alamousse.modules.market.service.PromoteCodeService;
import com.alamousse.modules.market.service.dto.PromoteCodeDTO;
import com.alamousse.modules.market.service.dto.PromoteCodeQueryCriteria;
import com.alamousse.modules.market.service.mapper.PromoteCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import cn.hutool.core.util.IdUtil;
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
public class PromoteCodeServiceImpl implements PromoteCodeService {

    @Autowired
    private PromoteCodeRepository promoteCodeRepository;

    @Autowired
    private PromoteCodeMapper promoteCodeMapper;

    @Override
    public Object queryAll(PromoteCodeQueryCriteria criteria, Pageable pageable){
        Page<PromoteCode> page = promoteCodeRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(promoteCodeMapper::toDto));
    }

    @Override
    public Object queryAll(PromoteCodeQueryCriteria criteria){
        return promoteCodeMapper.toDto(promoteCodeRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public PromoteCodeDTO findById(String code) {
        Optional<PromoteCode> promoteCode = promoteCodeRepository.findById(code);
        ValidationUtil.isNull(promoteCode,"PromoteCode","code",code);
        return promoteCodeMapper.toDto(promoteCode.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PromoteCodeDTO create(PromoteCode resources) {
        resources.setCode(IdUtil.simpleUUID()); 
        return promoteCodeMapper.toDto(promoteCodeRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(PromoteCode resources) {
        Optional<PromoteCode> optionalPromoteCode = promoteCodeRepository.findById(resources.getCode());
        ValidationUtil.isNull( optionalPromoteCode,"PromoteCode","id",resources.getCode());
        PromoteCode promoteCode = optionalPromoteCode.get();
        promoteCode.copy(resources);
        promoteCodeRepository.save(promoteCode);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String code) {
        promoteCodeRepository.deleteById(code);
    }
}