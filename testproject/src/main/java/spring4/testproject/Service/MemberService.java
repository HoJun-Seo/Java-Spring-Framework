package spring4.testproject.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring4.testproject.Model.Member;
import spring4.testproject.Repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public boolean memberCrossCheck(Member member) {

        // MemberRepository 와 연동하여 Member 객체에 대한 등록, 검색, 수정, 삭제 메소드를 여기서 구현
        // MemberService, MemberRepository 둘 다 인터페이스를 따로 만들어 준 다음, 해당 인테페이스를 구현하는 식으로
        // 만들어줄것

        Optional<Member> optionalMember = memberRepository.select(member);

        if (optionalMember.isPresent()) {
            Member getMember = optionalMember.get();
            if (member.getUserId().equals(getMember.getUserId())
                    && member.getUserPwd().equals(getMember.getUserPwd())) {
                return true;
            } else {
                return false;
            }
        } else {
            // 존재하지 않는 Member 인 경우
            return false;
        }
    }
}
