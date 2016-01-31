package org.ifollowyou.spel;

import org.ifollowyou.spel.literal.BooleanBean;
import org.ifollowyou.spel.property.SpringElPropertyBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spel-property.xml"})
public class PropertyTest {

    @Autowired
    protected ApplicationContext context;

    @Test
    public void testProperty() {
        System.out.println("SpringElPropertyBean configured using @Value");
        SpringElPropertyBean bean =
                (SpringElPropertyBean) context.getBean("springElPropertyBean");

        System.out.println("intProperty: " + bean.getIntProperty());
        System.out.println("programmingTutorial: " + bean.getProgrammingTutorial());
        System.out.println("topicsCount: " + bean.getTopicsCount());
        System.out.println("mainTopic: " + bean.getMainTopic());
        System.out.println("tutorial: " + bean.getTutorial());
    }

}
