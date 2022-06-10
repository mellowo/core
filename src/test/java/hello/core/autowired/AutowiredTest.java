package hello.core.autowired;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void createOrder(){
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
        //orderService.createOrder(1L, "itemA", 10000);
    }


    @Test
    void autowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {

        @Autowired(required = false)
        public void setNoBean1(Member member){
            System.out.println("member = " + member);
        }
        @Autowired
        public void setNoBean2(@Nullable Member member){
            System.out.println("member = " + member);
        }
        @Autowired
        public void setNoBean3(Optional<Member> member){
            System.out.println("member = " + member);
        }
    }


}
