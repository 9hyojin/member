package com.koo.member.repository;

import com.koo.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
}
