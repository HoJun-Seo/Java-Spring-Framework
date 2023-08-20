package spring4.testproject.Interface.RepositoryInterface;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import spring4.testproject.Model.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

    // 유저 검색
    public Optional<Member> select(Member member);

    // 유저 등록
    public void memberRegister(Member member);

    // 유저 삭제
    public void memberDelete(Member member);
}
