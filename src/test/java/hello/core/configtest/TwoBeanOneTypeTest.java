package hello.core.configtest;

import hello.core.AutoAppConfig;
import hello.core.TestInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

public class TwoBeanOneTypeTest {


    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    @Test
    void twoBeanOneTypeSearchAllBeanTest(){
        TestService bean = ac.getBean(TestService.class);
//        Map<String, TestInterface> testInterfaceMap = (Map<String, TestInterface>) bean;
//        System.out.println("testInterfaceMap = " + testInterfaceMap);
        TestService test1 = bean.targetBeanSeach("test1");
        TestService test2 = bean.targetBeanSeach("test2");

        System.out.println("test1 = " + test1);
        System.out.println("test2 = " + test2);

    }

    @Component
    static class TestService{
        private final Map<String,TestInterface> testInterfaceMap;

        @Autowired
        public TestService(Map<String,TestInterface> testInterface) {
            this.testInterfaceMap = testInterface;
        }

        TestService targetBeanSeach(String beanname){
            System.out.println(testInterfaceMap.get(beanname));
            return (TestService) testInterfaceMap.get(beanname);
        }
    }
}
