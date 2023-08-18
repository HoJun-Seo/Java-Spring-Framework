package spring4.testproject.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring4.testproject.Interface.ServiceInterface.MemberService;
import spring4.testproject.Model.Member;
import spring4.testproject.Repository.MemberRepositoryImplment;

@Service
@RequiredArgsConstructor
public class MemberServiceImplment implements MemberService {

    private final MemberRepositoryImplment memberRepository;

    @Override
    public String memberLogin(Member member) {

        // MemberRepository 와 연동하여 Member 객체에 대한 등록, 검색, 수정, 삭제 메소드를 여기서 구현
        // MemberService, MemberRepository 둘 다 인터페이스를 따로 만들어 준 다음, 해당 인테페이스를 구현하는 식으로
        // 만들어줄것

        Optional<Member> optionalMember = memberRepository.select(member);

        if (optionalMember.isPresent()) {
            Member getMember = optionalMember.get();

            // userId 를 기준으로 데이터베이스에서 검색할 것이기 때문에
            // 데이터베이스에서 정상적으로 데이터를 가져왔다면 비밀번호만 확인해줘도 된다.
            if (member.getUserPwd().equals(getMember.getUserPwd())) {
                return "loginSuccess";
            } else {
                return "pwdNotMatch";
            }
        } else {
            return "notExistId";
        }
    }

    @Override
    public String memberRegister(Member member) {

        Optional<Member> optionalMember = memberRepository.select(member);

        if (optionalMember.isPresent()) {
            return "existMember";
        } else {
            memberRepository.memberRegister(member);
            return "registerSuccess";
        }

    }

    @Override
    public String memberUpdate(Member currentMember, Member updatMember) {

        Optional<Member> optionalMember = memberRepository.select(currentMember);

        if (optionalMember.isPresent()) {

            Member getMember = optionalMember.get();
            if (currentMember.getUserPwd().equals(getMember.getUserPwd())) {
                // 입력한 패스워드 일치
                memberRepository.memberRegister(updatMember); // 어차피 userId 는 똑같음, 패스워드만 변경됨
                return "updateSuccess";
            } else {
                // 현재 패스워드가 일치하지 않는 경우
                return "notMatchCurrentPwd";
            }
        } else {
            return "updateFail";
        }
    }

    @Override
    public String memberDelete(Member member) {

        Optional<Member> optionalMember = memberRepository.select(member);

        if (optionalMember.isEmpty()) {
            return "deleteFail";
        } else {
            // hidden 으로 들어온 userId 계정이 존재할 경우 입력으로 들어온 비밀번호와 일치하는지 확인
            Member getMember = optionalMember.get();
            if (member.getUserPwd().equals(getMember.getUserPwd())) {
                memberRepository.memberDelete(member);
                return "deleteSucess";
            } else {
                return "notMatchPwd";
            }

        }
    }
}
