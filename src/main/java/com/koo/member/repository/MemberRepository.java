package com.koo.member.repository;

import com.koo.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//repository에서 받는 모든 정보는 Entity에서 가져옴
public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    // 이메일로 회원정보 조회 (=쿼리: select*from member(table이름) where member_email=?)
    Optional<MemberEntity> findByMemberEmail(String memberEmail);
}

