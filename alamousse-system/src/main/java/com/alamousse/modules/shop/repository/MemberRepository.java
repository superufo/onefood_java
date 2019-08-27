package com.alamousse.modules.shop.repository;

import com.alamousse.modules.shop.domain.Member;
import com.alamousse.modules.shop.service.dto.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
* @author mike
* @date 2019-07-20
*/
public interface MemberRepository extends JpaRepository<Member, Integer>, JpaSpecificationExecutor {
    @Query(value = "select account  from member where mid = ?1 limit 1",nativeQuery = true)
    String findMbNameById(Integer id);

    @Query(value = "select  *  from member where mid like CONCAT('%',:mid,'%') or account like CONCAT('%',:account,'%') ", nativeQuery = true)
    List<Member> findMemberVoById(@Param("mid") Integer mid, @Param("account") String  account);

    @Query(value = "select  *  from member where  account = ?1 limit 1 ", nativeQuery = true)
    MemberDTO findMemberVoByAccount(String  account);

    @Query(value = "select  *  from member where  useremail = ?1 limit 1 ", nativeQuery = true)
    MemberDTO findMemberVoByUserEmail(String userEmail);

    @Query(value = "select  *  from member where  mobile = ?1 limit 1 ", nativeQuery = true)
    MemberDTO findMemberVoByMobile(String  mobile);
}