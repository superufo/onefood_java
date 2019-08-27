package com.alamousse.modules.shop.service.mapper;

import com.alamousse.mapper.EntityMapper;
import com.alamousse.modules.shop.domain.Member;
import com.alamousse.modules.shop.service.dto.MemberDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author mike
* @date 2019-07-20
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper extends EntityMapper<MemberDTO, Member> {

}