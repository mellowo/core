package hello.core.studyreview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Scope("singleton")
@Component
public class UseBeanImpl implements UseBean {

    private final BeanTest beanTest;

    @Autowired
    public UseBeanImpl(BeanTest beanTest) {
        this.beanTest = beanTest;
    }

    @Override
    public void use1() {
        System.out.println("UseBeanImpl.use1");
    }

    @Override
    public int addCount() {
        return beanTest.addCount();
    }


    @PostConstruct
    void init() {
        System.out.println("UseBeanImpl.init");
    }

    @PreDestroy
    void destroy() {
        System.out.println("UseBeanImpl.destroy");
    }
}
