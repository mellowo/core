package hello.core.studyreview;


import org.springframework.stereotype.Component;

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
}
