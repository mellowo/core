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
        BeanTest bean1 = applicationContext.getBean(BeanTest.class);
        //System.out.println("bean = " + bean);
        //System.out.println("bean1 = " + bean1);

        System.out.println(bean.addCount());
        System.out.println(bean1.addCount());


        UseBean useBean1 = applicationContext.getBean(UseBean.class);
        UseBean useBean2 = applicationContext.getBean(UseBean.class);

        System.out.println(useBean1.addCount());
        System.out.println(useBean2.addCount());
        //System.out.println("useBean1 = " + useBean1);
        //System.out.println("useBean2 = " + useBean2);


        //applicationContext.close();
    }
}
