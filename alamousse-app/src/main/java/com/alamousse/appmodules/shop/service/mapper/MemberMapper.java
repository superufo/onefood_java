package com.alamousse.appmodules.shop.service.mapper;

import com.alamousse.appmodules.shop.domain.Member;
import com.alamousse.appmodules.shop.service.dto.MemberDTO;
import com.alamousse.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author mike
* @date 2019-07-20
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper extends EntityMapper<MemberDTO, Member> {

}