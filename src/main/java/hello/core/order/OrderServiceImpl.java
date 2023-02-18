package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository=new MemoryMemberRepository();   //회원 찾기 위함
    private final DiscountPolicy discountPolicy=new FixDiscountPolicy();    //할인 정책
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //order 서비스는 할인에 대해 관여X 단일책임원칙 잘 지킨 것

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
