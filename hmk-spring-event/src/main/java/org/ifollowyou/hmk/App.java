package org.ifollowyou.hmk;

import org.ifollowyou.hmk.beans.Login;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring-config.xml");

        Login login = (Login) ctx.getBean("login");
        login.login();
    }
}
