package hello.core.studyreview;

import hello.core.AppConfig;
import hello.core.AutoAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class MainTest1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        BeanTest bean = applicationContext.getBean(BeanTest.class);
        bean.impl1();
    }
}
