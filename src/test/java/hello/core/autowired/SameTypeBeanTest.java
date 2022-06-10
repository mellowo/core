package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class SameTypeBeanTest {

    @Test
    void sameTypeBeanTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        for (String key : beansOfType.keySet()) {
            System.out.println(key + " = " + beansOfType.get(key));
        }


    }
}
