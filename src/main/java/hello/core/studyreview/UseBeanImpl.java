package hello.core.studyreview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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

}
