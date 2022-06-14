package hello.core.scope;

import hello.core.AutoAppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest2 {

    @Test
    void prototyBeanlifeCycleTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        //PostConstruct는 실행되고, PreDestroy는 실행되지 않음 (빈 객체 생성, 의존관계주입까지만 관여함)
        PrototypeBean2 prototypeBean2 = ac.getBean(PrototypeBean2.class);
        PrototypeBean2 prototypeBean2_1 = ac.getBean(PrototypeBean2.class);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        System.out.println("prototypeBean2_1 = " + prototypeBean2_1);
        Assertions.assertThat(prototypeBean2).isNotSameAs(prototypeBean2_1);


    }





    @Component
    @Scope("prototype")
    static class PrototypeBean2{
        private final String name= "lee";

        @PostConstruct
        void init(){
            System.out.println("PrototypeBean2.init");
        }

        @PreDestroy
        void destroy(){
            System.out.println("PrototypeBean2.destroy");
        }

    }
}
