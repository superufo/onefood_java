package com.alamousse.appmodules.market.service.impl;

import com.alamousse.appmodules.market.domain.PromoteGoods;
import com.alamousse.utils.ValidationUtil;
import com.alamousse.appmodules.market.repository.PromoteGoodsRepository;
import com.alamousse.appmodules.market.service.PromoteGoodsService;
import com.alamousse.appmodules.market.service.dto.PromoteGoodsDTO;
import com.alamousse.appmodules.market.service.dto.PromoteGoodsQueryCriteria;
import com.alamousse.appmodules.market.service.mapper.PromoteGoodsMapper;
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
public class PromoteGoodsServiceImpl implements PromoteGoodsService {

    @Autowired
    private PromoteGoodsRepository promoteGoodsRepository;

    @Autowired
    private PromoteGoodsMapper promoteGoodsMapper;

    @Override
    public Object queryAll(PromoteGoodsQueryCriteria criteria, Pageable pageable){
        Page<PromoteGoods> page = promoteGoodsRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(promoteGoodsMapper::toDto));
    }

    @Override
    public Object queryAll(PromoteGoodsQueryCriteria criteria){
        return promoteGoodsMapper.toDto(promoteGoodsRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public PromoteGoodsDTO findById(Integer id) {
        Optional<PromoteGoods> promoteGoods = promoteGoodsRepository.findById(id);
        ValidationUtil.isNull(promoteGoods,"PromoteGoods","id",id);
        return promoteGoodsMapper.toDto(promoteGoods.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PromoteGoodsDTO create(PromoteGoods resources) {
        return promoteGoodsMapper.toDto(promoteGoodsRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(PromoteGoods resources) {
        Optional<PromoteGoods> optionalPromoteGoods = promoteGoodsRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalPromoteGoods,"PromoteGoods","id",resources.getId());
        PromoteGoods promoteGoods = optionalPromoteGoods.get();
        promoteGoods.copy(resources);
        promoteGoodsRepository.save(promoteGoods);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        promoteGoodsRepository.deleteById(id);
    }
}
