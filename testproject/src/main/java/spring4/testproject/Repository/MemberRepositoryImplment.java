package spring4.testproject.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import spring4.testproject.Interface.RepositoryInterface.MemberRepository;
import spring4.testproject.Model.Member;

@Repository
public class MemberRepositoryImplment implements MemberRepository {

    private static Map<String, Member> dbMap = new HashMap<>();

    // 데이터베이스에 연결이 되어있지 않으므로 임시로 데이터를 생성하여 메소드 수행
    @Override
    public Optional<Member> select(Member member) {

        if (dbMap.containsKey(member.getUserId())) {
            Member dbMember = dbMap.get(member.getUserId());
            return Optional.of(dbMember);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void memberRegister(Member member) {

        dbMap.put(member.getUserId(), member);
    }

    @Override
    public void memberDelete(Member member) {

        dbMap.remove(member.getUserId());
    }
}
