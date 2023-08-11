package spring4.testproject.Interface.ServiceInterface;

import spring4.testproject.Model.Member;

public interface MemberService {

    // 유저 검색
    public String memberLogin(Member member);

    // 유저 등록
    public String memberRegister(Member member);

    public String memberUpdate(Member currentMember, Member updatMember);

    public String memberDelete(Member member);

}
