package com.alamousse.modules.shop.service.impl;

import com.alamousse.modules.shop.service.dto.MemberQueryCriteria;
import com.alamousse.utils.PageUtil;
import com.alamousse.utils.QueryHelp;
import com.alamousse.utils.ValidationUtil;
import com.alamousse.modules.shop.domain.Member;

import com.alamousse.modules.shop.repository.MemberRepository;
import com.alamousse.modules.shop.service.MemberService;
import com.alamousse.modules.shop.service.dto.MemberDTO;
import com.alamousse.modules.shop.service.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
* @author mike
* @date 2019-07-20
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;


    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Object queryAll(MemberQueryCriteria criteria, Pageable pageable){
        Page<Member> page = memberRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(memberMapper::toDto));
    }

    @Override
    public Object queryAll(MemberQueryCriteria criteria){
        return memberMapper.toDto(memberRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public MemberDTO findById(Integer mid) {
        Optional<Member> member = memberRepository.findById(mid);
        ValidationUtil.isNull(member,"Member","mid",mid);
        return memberMapper.toDto(member.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MemberDTO create(Member resources) {
        return memberMapper.toDto(memberRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Member resources) {
        Optional<Member> optionalMember = memberRepository.findById(resources.getMid());
        ValidationUtil.isNull( optionalMember,"Member","id",resources.getMid());
        Member member = optionalMember.get();
        member.copy(resources);
        memberRepository.save(member);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer mid) {
        memberRepository.deleteById(mid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Member> findMemberVoByInfo(Integer mid, String account){
          return memberRepository.findMemberVoById( mid,  account);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MemberDTO findMemberVoByAccount(String account){
        return memberRepository.findMemberVoByAccount(account);
    }

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public MemberDTO findMemberVoByUserEmail(String userEmail){
//        return memberRepository.findMemberVoByUserEmail(userEmail);
//    }
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public MemberDTO findMemberVoByMobile(String mobile){
//        return memberRepository.findMemberVoByMobile(mobile);
//    }

}