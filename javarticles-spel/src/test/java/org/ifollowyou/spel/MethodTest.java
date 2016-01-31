package org.ifollowyou.spel;

import org.ifollowyou.spel.method.Training;
import org.ifollowyou.spel.property.SpringElPropertyBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spel-method.xml"})
public class MethodTest {
    @Autowired
    protected ApplicationContext context;

    @Test
    public void testMethod() {
        Training training = (Training) context.getBean("training");
        System.out.println(training);

        System.out.println(context.getBean("myTraining"));
    }
}
