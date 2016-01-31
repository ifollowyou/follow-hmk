package org.ifollowyou.spel;

import org.ifollowyou.spel.getstart.Topic;
import org.ifollowyou.spel.getstart.Training;
import org.ifollowyou.spel.literal.BooleanBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spel-getstart.xml"})
public class GetStartTest {

    @Autowired
    protected ApplicationContext context;

    @Test
    public void testParser() {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Just a string value'");
        String message = (String) exp.getValue();

        System.out.println(message);
        System.out.println(parser.parseExpression("'Just a string value'.substring(5)").getValue());
        System.out.println(parser.parseExpression("'Just a string value'.length()").getValue());
        System.out.println(parser.parseExpression("'Just a string value'.substring('Just '.length())").getValue());
        System.out.println(parser.parseExpression("'Just a string value'.class").getValue());
        System.out.println(parser.parseExpression("'Just a string value'.bytes").getValue());
        System.out.println(parser.parseExpression("new org.ifollowyou.spel.getstart.Topic('Java')").getValue(Topic.class).getClass());
    }

    @Test
    public void testBooleanLiteral() {
        Training training = (Training) context.getBean("training");

        System.out.println(training.getTopic());
        System.out.println(training.getDefaultTopic());
    }
}
