package com.alamousse.appmodules.security.service;

import com.alamousse.appmodules.shop.domain.Member;
import com.alamousse.exception.BadRequestException;
import com.alamousse.appmodules.shop.service.dto.MemberDTO;
import com.alamousse.appmodules.security.security.JwtMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alamousse.appmodules.shop.service.MemberService;
/**
 * @author mike
 * @date 2018-11-22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class JwtMemberDetailsService implements UserDetailsService {
    @Autowired
    private MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String account){
        System.out.print("account:"+account);

        memberService.findMemberVoByInfo(100001,"guest");
        Member member =  memberService.findMember(account);

        if (member == null) {
            throw new BadRequestException("MEMBER IS NOT EXIST");
        } else {
            return createJwtUser(member);
        }
    }

    public UserDetails createJwtUser(Member member) {
        Integer  shopId =  member.getShopId();

        return new JwtMember(
                member.getMid(),
                member.getAccount(),
                member.getUseremail(),
                member.getMobile(),
                shopId,
                member.getPassword(),
                member.getGoogle(),
                member.getFacebook(),
                member.getFirstname(),
                member.getLastname(),
                member.getImage(),
                member.getAddressId(),
                member.getState() == 0 ? true : false,
                member.getSex(),
                member.getUserpoint(),
                member.getLastLoginTime()
        );
    }
}
