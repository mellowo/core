package hello.core.configtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;


public class ConfigTest1 {

    @Test
    @DisplayName("@Configuration 에너테이션 유무에따른 자동 Bean객체 생성 테스트")
    void configTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoConfigTest.class);

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            if (beanDefinitionName.equals("configTest1.Config1")){
                Config1 bean = (Config1)ac.getBean(beanDefinitionName);
                System.out.println("Config1 = " + bean.getName());
            }
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("beaname = " + beanDefinitionName );

        }

//        String bean = ac.getBean(String.class);
//        System.out.println("bean = " + bean);


    }



    @Component
    static class Config1{
        final String name = "lee";

        public String getName() {
            return name;
        }
    }

    @Component
    static class Config2{
        private final Config1 config1;

        @Autowired
        public Config2(Config1 config1) {
            this.config1 = config1;
        }

    }



    @Configuration
    @ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
    static class AutoConfigTest{ }

}
