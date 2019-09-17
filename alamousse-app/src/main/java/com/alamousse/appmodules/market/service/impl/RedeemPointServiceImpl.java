package com.alamousse.appmodules.market.service.impl;

import com.alamousse.appmodules.market.domain.RedeemPoint;
import com.alamousse.utils.ValidationUtil;
import com.alamousse.appmodules.market.repository.RedeemPointRepository;
import com.alamousse.appmodules.market.service.RedeemPointService;
import com.alamousse.appmodules.market.service.dto.RedeemPointDTO;
import com.alamousse.appmodules.market.service.dto.RedeemPointQueryCriteria;
import com.alamousse.appmodules.market.service.mapper.RedeemPointMapper;
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
public class RedeemPointServiceImpl implements RedeemPointService {

    @Autowired
    private RedeemPointRepository redeemPointRepository;

    @Autowired
    private RedeemPointMapper redeemPointMapper;

    @Override
    public Object queryAll(RedeemPointQueryCriteria criteria, Pageable pageable){
        Page<RedeemPoint> page = redeemPointRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(redeemPointMapper::toDto));
    }

    @Override
    public Object queryAll(RedeemPointQueryCriteria criteria){
        return redeemPointMapper.toDto(redeemPointRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public RedeemPointDTO findById(String code) {
        Optional<RedeemPoint> redeemPoint = redeemPointRepository.findById(code);
        ValidationUtil.isNull(redeemPoint,"RedeemPoint","code",code);
        return redeemPointMapper.toDto(redeemPoint.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RedeemPointDTO create(RedeemPoint resources) {
        resources.setCode(IdUtil.simpleUUID());
        return redeemPointMapper.toDto(redeemPointRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(RedeemPoint resources) {
        Optional<RedeemPoint> optionalRedeemPoint = redeemPointRepository.findById(resources.getCode());
        ValidationUtil.isNull( optionalRedeemPoint,"RedeemPoint","id",resources.getCode());
        RedeemPoint redeemPoint = optionalRedeemPoint.get();
        redeemPoint.copy(resources);
        redeemPointRepository.save(redeemPoint);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String code) {
        redeemPointRepository.deleteById(code);
    }
}
