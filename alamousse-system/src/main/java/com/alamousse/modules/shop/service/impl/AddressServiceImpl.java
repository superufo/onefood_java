package com.alamousse.modules.shop.service.impl;

import com.alamousse.modules.shop.domain.Address;
import com.alamousse.modules.shop.repository.AddressRepository;
import com.alamousse.modules.shop.service.AddressService;
import com.alamousse.modules.shop.service.dto.AddressDTO;
import com.alamousse.modules.shop.service.dto.AddressQueryCriteria;
import com.alamousse.modules.shop.service.mapper.AddressMapper;
import com.alamousse.modules.system.domain.Zone;
import com.alamousse.modules.system.repository.ZoneRepository;
import com.alamousse.modules.shop.repository.MemberRepository;
import com.alamousse.modules.system.domain.vo.ZoneVo;
import com.alamousse.utils.PageUtil;
import com.alamousse.utils.QueryHelp;
import com.alamousse.utils.ValidationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* @author mike
* @date 2019-07-25
*/
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    public Object queryAll(AddressQueryCriteria criteria, Pageable pageable){
        Page<Address> page = addressRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);

        List<AddressDTO> addresses = new ArrayList<>();

        for (Address address : page.getContent()) {
            AddressDTO addressDto = findById(address.getId());
            addresses.add(addressDto);
        }

        return PageUtil.toPage(addresses,page.getTotalElements());
    }

    @Override
    public Object queryAll(AddressQueryCriteria criteria){
        List<Address> addressList = addressMapper.toDto(addressRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));

        ArrayList<AddressDTO> addresses =  new ArrayList<>();
        for (Address address : addressList) {
            AddressDTO addressDto = findById(address.getId());
            addresses.add(addressDto);
        }

        return addresses;
        //return addressMapper.toDto(addressRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AddressDTO findById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        ValidationUtil.isNull(address,"Address","id",id);

        Address item = address.get();

        String account = memberRepository.findMbNameById(item.getMid());
        ZoneVo vo =  new  ZoneVo();
        Zone zone = zoneRepository.findNameById(item.getCountry());

        if( zone!=null ) {
            vo.setCountryId(zone.getId());
            vo.setCountryCname(zone.getCname());
            vo.setCountryName(zone.getEname());
        }

        zone   = zoneRepository.findNameById(item.getProvince());
        if( zone!=null ) {
            vo.setProviceId(zone.getId());
            vo.setProviceCname(zone.getCname());
            vo.setProviceName(zone.getEname());
        }

        zone   = zoneRepository.findNameById(item.getCity());
        if( zone!=null ) {
            vo.setCityId(zone.getId());
            vo.setCityCname(zone.getCname());
            vo.setCityName(zone.getEname());
        }

        zone    = zoneRepository.findNameById(item.getStreet());
        if( zone!=null ) {
            vo.setStreetId(zone.getId());
            vo.setStreetCname(zone.getCname());
            vo.setStreetName(zone.getEname());
        }

        AddressDTO addressDTO  =  addressMapper.toDto(item,account,vo);

        System.out.print(vo);
        System.out.print(addressDTO);
        return addressDTO;
        //return addressMapper.toDto(address.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AddressDTO create(Address resources) {
        //resources.setId(IdUtil.simpleUUID());
        return addressMapper.toDto(addressRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Address resources) {
        Optional<Address> optionalAddress = addressRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalAddress,"Address","id",resources.getId());
        Address address = optionalAddress.get();
        address.copy(resources);
        addressRepository.save(address);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}