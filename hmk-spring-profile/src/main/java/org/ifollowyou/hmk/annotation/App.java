package org.ifollowyou.hmk.annotation;

import org.ifollowyou.hmk.vo.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("production"); //or production
        ctx.scan("org.ifollowyou.hmk"); // register all @Configuration classes
        //ctx.register(SpringConfigDev.class);
        ctx.refresh();
        Person person = (Person) ctx.getBean("person");


        System.out.println("Person: " + person);
    }
}
