package com.alamousse.appmodules.shop.service;

import com.alamousse.appmodules.shop.domain.Member;
import com.alamousse.appmodules.shop.service.dto.MemberDTO;
import com.alamousse.appmodules.shop.service.dto.MemberQueryCriteria;
import org.springframework.data.domain.Pageable;

import java.util.List;

//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

/**
* @author mike
* @date 2019-07-20
*/
//@CacheConfig(cacheNames = "member")
public interface MemberService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(MemberQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(MemberQueryCriteria criteria);

    /**
     * findById
     * @param mid
     * @return
     */
    //@Cacheable(key = "#p0")
    MemberDTO findById(Integer mid);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    MemberDTO create(Member resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(Member resources);

    /**
     * delete
     * @param mid
     */
    //@CacheEvict(allEntries = true)
    void delete(Integer mid);

    List<Member> findMemberVoByInfo(Integer mid, String account) ;

    Member findMemberVoByAccount(String account);

    Member findMemberVoByUserEmail(String userEmail);

    Member findMemberVoByMobile(String mobile);

    Member findMember(String mobile);

}