package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonTest {

    @Test
    public void singletonBeanFind(){
        //매개변수로 들어가는 class가 설정정보가 됨 (@Configuration 안넣어줘도 적용)
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
        System.out.println("singletonBean1 = " + singletonBean1);
        System.out.println("singletonBean2 = " + singletonBean2);
        Assertions.assertThat(singletonBean1).isSameAs(singletonBean2);
        ac.close();
    }

    @Configuration
    @Scope("singleton")
    static class SingletonBean{

        @PostConstruct
        void init(){
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        void close(){
            System.out.println("SingletonBean.close");
        }
    }

}
