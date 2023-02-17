package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //회원을 찾기 위해
    private final MemberRepository memberRepository = new MemoryMemberRepository();


    @Override
    public void join(Member member) {
        memberRepository.save(member);  //join에서 save를 호출하면 다형성에 의해서 MemoryMemberRepository에 있는 save가 호출됨
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
