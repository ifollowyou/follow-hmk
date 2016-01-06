package org.ifollowyou.hmk;

import org.ifollowyou.hmk.spring.beans.AnotherBean;
import org.ifollowyou.hmk.spring.config.JavaConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) {

        ApplicationContext ctxXML =
                new ClassPathXmlApplicationContext("config/XMLConfig.xml");
        AnotherBean anotherBean = (AnotherBean) ctxXML.getBean("anotherBean");
        System.out.println(anotherBean);

        //---------------------------------------

        ApplicationContext ctxAnnotation =
                new ClassPathXmlApplicationContext("config/XMLConfig-Annotation.xml");
        anotherBean = (AnotherBean) ctxAnnotation.getBean("anotherBean");
        System.out.println(anotherBean);

        //---------------------------------------

        ApplicationContext ctxJavaConfig =
                new AnnotationConfigApplicationContext(JavaConfig.class);
        anotherBean = (AnotherBean) ctxJavaConfig.getBean("anotherBean2");
        System.out.println(anotherBean);
    }
}
