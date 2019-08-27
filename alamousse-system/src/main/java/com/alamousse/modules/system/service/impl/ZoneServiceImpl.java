package com.alamousse.modules.system.service.impl;

import com.alamousse.modules.system.service.mapper.ZoneMapper;
import com.alamousse.modules.system.domain.Zone;
import com.alamousse.modules.system.domain.vo.ZoneVo;
import com.alamousse.utils.ValidationUtil;
import com.alamousse.modules.system.repository.ZoneRepository;
import com.alamousse.modules.system.service.ZoneService;
import com.alamousse.modules.system.service.dto.ZoneDTO;
import com.alamousse.modules.system.service.dto.ZoneQueryCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.alamousse.utils.PageUtil;
import com.alamousse.utils.QueryHelp;

/**
* @author mike
* @date 2019-07-21
*/
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;

    @Autowired
    private ZoneMapper zoneMapper;
    
    @Override
    public Object queryAll(ZoneQueryCriteria criteria, Pageable pageable){
//        Page<Zone> page = zoneRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
//        return PageUtil.toPage(page.map(zoneMapper::toDto));
        Page<Zone> page = zoneRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);

        List<Zone> zoneList = page.getContent();
        ArrayList<ZoneDTO> zones =  getPidZone(zoneList);
        return PageUtil.toPage(zones,page.getTotalElements());
    }

    @Override
    public Object queryAll(ZoneQueryCriteria criteria){
        List<Zone> zoneList = zoneRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder));

        ArrayList<ZoneDTO> zones =  getPidZone(zoneList);
        return     zones;
        //return zoneMapper.toDto(zoneRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public ZoneDTO findById(Integer id) {
        Optional<Zone> z = zoneRepository.findById(id);
        ValidationUtil.isNull(z,"Zone","id",id);

        Zone  zone = z.get();
        if ( z.filter( t -> t.getType()==4 ).isPresent()== true ){
            System.out.print("test--------------------");
        }

        ZoneVo vo =  new  ZoneVo();
        Zone zoneCity=new Zone() ,zoneProvice=new Zone(),zoneCountry=new Zone();
        System.out.print(zone.getType().toString()+"\n");

        if ( zone.getType() == 4) {
            zoneCity = zoneRepository.findById(zone.getParentId()).get();
            System.out.print(zone.getId().toString()+"\n");
            System.out.print(zoneCity);

            if (zoneCity!=null) {
                zoneProvice = zoneRepository.findById(zoneCity.getParentId()).get();
            }

            if (zoneProvice!=null) {
                zoneCountry = zoneRepository.findById(zoneProvice.getParentId()).get();
            }
        }else if (zone.getType() == 3  ) {
            zoneProvice =  zoneRepository.findById(zone.getParentId()).get();
            if (zoneProvice!=null) {
                zoneCountry = zoneRepository.findById(zoneProvice.getParentId()).get();
            }
        }else if (zone.getType() == 2 ){
            zoneCountry = zoneRepository.findById(zone.getParentId()).get();
        }

        //当前为省级 父级为国家
        if ( zoneCountry!=null ) {
            vo.setCountryId(zoneCountry.getId());
            vo.setCountryCname(zoneCountry.getCname());
            vo.setCountryName(zoneCountry.getEname());
        }

        if ( zoneProvice!=null ) {
            vo.setProviceId(zoneProvice.getId());
            vo.setProviceCname(zoneProvice.getCname());
            vo.setProviceName(zoneProvice.getEname());
        }

        if ( zoneCity!=null ) {
            vo.setCityId(zoneCity.getId());
            vo.setCityCname(zoneCity.getCname());
            vo.setCityName(zoneCity.getEname());
        }

        ZoneDTO zoneDto =  zoneMapper.toDto(zone,vo);
        zoneDto.setZonevo(vo);

        System.out.print(zoneDto);
        return zoneDto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ZoneDTO create(Zone resources) {
        return zoneMapper.toDto(zoneRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Zone resources) {
        Optional<Zone> optionalZone = zoneRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalZone,"Zone","id",resources.getId());
        Zone zone = optionalZone.get();
        zone.copy(resources);
        zoneRepository.save(zone);
    }

    //支持 两级 城市和 城区 的删除.
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        //Integer streetId =0;   Integer streetId =  Optional.ofNullable(zonedto).map(z->z.getZonevo()).map(s->s.getStreetId()).orElse(0);
        Optional<Zone> zn = zoneRepository.findById(id);

        Integer type = zn.map(z->z.getType()).orElse(0);
        //查找下级
        if ( type< 3  ) {
                 return ;
        } else {
            ZoneQueryCriteria criteria  = new ZoneQueryCriteria();

            criteria.setParentId(id);
            List<Zone> zoneList = zoneRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder));

            for (Zone znd : zoneList  ){
                zoneRepository.deleteById(znd.getId());
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Zone findByParentId(Integer parentId) {
        return zoneRepository.findByParentId(parentId);
    }

    @Transactional(rollbackFor = Exception.class)
    public ArrayList<ZoneDTO> getPidZone(List<Zone> zoneList) {
        ArrayList<ZoneDTO> zones = new ArrayList<>();

        for (Zone zone : zoneList) {
            ZoneDTO zoneDto = findById(zone.getId());
            zones.add(zoneDto);
        }

        return zones;
    }
    
}