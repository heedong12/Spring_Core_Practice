package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MemberServiceTest {
    MemberService memberService;
    @BeforeEach //테스트 실행하기 전에 무조건 실행됨
    public void beforeEach(){
        AppConfig appConfig=new AppConfig();
        memberService=appConfig.memberService();
    }
    @Test
    void join(){
        //given 주어졌을때
        Member member = new Member(1L, "memberA",Grade.VIP);

        //when 했을때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then 이렇게 된다
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
