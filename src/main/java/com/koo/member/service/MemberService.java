package com.koo.member.service;

import com.koo.member.dto.MemberDTO;
import com.koo.member.entity.MemberEntity;
import com.koo.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {

        //1. dto -> entity 변환
        //2. repository의 save메서드 호출(조건: entity객체를 넘겨줘야함)
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);

    }

    public MemberDTO login(MemberDTO memberDTO){
        //1. 회원이 입력한 이메일을 db에서 조회
        //2. db에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 확인
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if(byMemberEmail.isPresent()){
            //조회결과가 있다 (해당 이메일을 가진 회원이 있다)
            MemberEntity memberEntity = byMemberEmail.get();
            if(memberEntity.getMemberPassword().equals(memberDTO.getMemberName())){
                //비밀번호 일치
                // entity -> dto 로 변환후 controller에 리턴
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            }else{
                //비밀번호 불일치
                return null;
            }

        }else{
            //조회결과가 없다 (해당 이메일을 가진 회원이 없다)
            return null;
        }
    }

}
