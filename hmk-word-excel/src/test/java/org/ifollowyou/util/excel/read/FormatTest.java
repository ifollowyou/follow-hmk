package org.ifollowyou.util.excel.read;


import org.junit.Test;

public class FormatTest {

    @Test
    public void test() {
        String no = "1";

        String result = String.format("%04d", 4);
        System.out.println(result);
    }
}
