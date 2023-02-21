package hello.core.member;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    //생성자를 통해서 MemberRepository 구현체에 뭐가 들어갈지 결정
    //MemoryMemberRepository에 대한 코드는 없음 추상화에만 의존(DIP 지킴)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);  //join에서 save를 호출하면 다형성에 의해서 MemoryMemberRepository에 있는 save가 호출됨
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
