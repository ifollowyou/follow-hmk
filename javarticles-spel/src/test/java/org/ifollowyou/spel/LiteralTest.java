package org.ifollowyou.spel;

import org.ifollowyou.spel.literal.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spel-literal.xml"})
public class LiteralTest {

    @Autowired
    protected ApplicationContext context;

    @Test
    public void testBooleanLiteral() {

        BooleanBean booleanBean = (BooleanBean) context.getBean("booleanBean");

        System.out.println("Boolean ('1')=" + booleanBean.isOneTrue());
        System.out.println("Boolean ('true')=" + booleanBean.isBooleanValueTrue());
        System.out.println("Boolean ('yes')=" + booleanBean.isYesTrue());
    }

    @Test
    public void testDateLiteral() {
        DateBean dateBean = (DateBean) context.getBean("dateBean");
        System.out.println("new java.text.SimpleDateFormat('yyyyMMdd').parse('20150616')=" + dateBean.getDateValue());
    }

    @Test
    public void testExponentLiteral() {
        ExponentBean exponentBean = (ExponentBean) context.getBean("exponentBean");

        System.out.println("2.1E-7=" + exponentBean.getExponentialValue());
        System.out.println("2.1E+1=" + exponentBean.getExponentialDoubleValue());
    }

    @Test
    public void testHexLiteral() {
        HexBean hexBean = (HexBean) context.getBean("hexBean");

        System.out.println("int 0x7FFFF=" + hexBean.getHexIntValue());
        System.out.println("0x35 * 3L=" + hexBean.getHexExpression());
        System.out.println("-0x20L=" + hexBean.getHexNegativeLongValue());
        System.out.println("long 0x4AFFF=" + hexBean.getHexLongValue());
    }

    @Test
    public void testNullLiteral() {
        NullVariableBean nullVariableBean = (NullVariableBean) context.getBean("nullVariableBean");

        System.out.println(nullVariableBean.getNullStringValue());
        System.out.println(nullVariableBean.getNullValue());
    }

    @Test
    public void testNumberLiteral() {
        NumberBean numberBean = (NumberBean) context.getBean("numberBean");

        System.out.println("Float=" + numberBean.getFloatValue());
        System.out.println("Integer=" + numberBean.getIntValue());
        System.out.println("Double=" + numberBean.getDoubleValue());
        System.out.println("Double expression '2.5d'=" + numberBean.getDoubleValueExpression());
        System.out.println("Double negative value=" + numberBean.getNegativeDoubleValue());
        System.out.println("new Integer(20)=" + numberBean.getNewInt());
        System.out.println("(2.5d * 2)=" + numberBean.getMultiplyDoubleValue());
    }

    @Test
    public void testStringLiteral() {
        StringBean stringBean = (StringBean) context.getBean("stringBean");

        System.out.println("name=" + stringBean.getName());
        System.out.println("'Hello World'.substring(6)=" + stringBean.getSubstringValue());
    }
}
