package com.example.springbootapi.service;

import com.example.springbootapi.model.Member;
import com.example.springbootapi.model.MemberCreateRequest;
import com.example.springbootapi.model.MemberUpdateRequest;
import com.example.springbootapi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //MemberCreateRequest -> Member로 변환해주는 과정이 필요
    public Member createMember(MemberCreateRequest request) {
        Member member = Member.toEntity(request);
        return memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId).get();
    }

    public List<Member> findAllMember() {
//        List<Member> allMember = memberRepository.findAll();
//        return allMember;

        return memberRepository.findAll();
    }

    public void updateMember(Long memberId, MemberUpdateRequest request) {
        //1.회원을 찾는다
        Member member = memberRepository.findById(memberId).get();

        //2. 찾은 회원의 이름을 변경한다
        member.updateName(request.getName());

        //3. 변경된 내역을 데이터베이스에 저장한다
        //JPA에서 save()함수는, 데이터가 존재하면 업데이트하고, 존재하지 않으면 데이터 삽입
        memberRepository.save(member);
    }

    public void deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId).get();

        memberRepository.delete(member);
    }

    public void deleteAllMember() {
        memberRepository.deleteAll();
    }
}
