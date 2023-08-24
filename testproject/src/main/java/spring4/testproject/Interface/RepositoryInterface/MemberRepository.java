package spring4.testproject.Interface.RepositoryInterface;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring4.testproject.Model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    // 유저 검색
    @Query("select m from Member m where m.userId = :#{#member.userId}")
    public Optional<Member> findByUserId(@Param("member") Member member);

    // 유저 등록
    @Transactional
    @Query(value = "insert into Member values (:#{#member.userId}, :#{#member.userPwd})", nativeQuery = true)
    @Modifying
    public void memberRegister(@Param("member") Member member);

    // 유저 삭제
    @Transactional
    @Query("delete from Member m where m.userId = :#{#member.userId}")
    @Modifying
    public void memberDelete(@Param("member") Member member);

    @Transactional
    @Query("update Member m set m.userPwd = :#{#member.userPwd} where m.userId = :#{#member.userId}")
    @Modifying
    public void memberUpdate(@Param("member") Member updatMember);
}