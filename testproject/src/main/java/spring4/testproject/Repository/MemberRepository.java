package spring4.testproject.Repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import spring4.testproject.Model.Member;

@Repository
public class MemberRepository {

    // 데이터베이스에 연결이 되어있지 않으므로 임시로 데이터를 생성하여 메소드 수행
    public Optional<Member> select(Member member) {

        // 입력받은 Member 정보와 일치하는 데이터가 존재하는 경우 테스트
        // Optional<Member> optionalMember = Optional.of(member);
        // return optionalMember;

        // 그렇지 않은 경우 테스트
        Optional<Member> optionalMember = Optional.empty();
        return optionalMember;
    }
}
