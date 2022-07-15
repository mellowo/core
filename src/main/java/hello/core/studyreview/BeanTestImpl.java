package hello.core.studyreview;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Scope("prototype")
@Component
public class BeanTestImpl implements BeanTest {

    @Override
    public void impl1() {
        System.out.println("BeanTestImpl.impl1");
    }

    @Override
    public void impl2() {
        System.out.println("BeanTestImpl.impl2");
    }

    @PostConstruct
    void init(){
        System.out.println("BeanTestImpl.init");
    }

    @PreDestroy
    void destroy() {
        System.out.println("BeanTestImpl.destory");
    }
}
