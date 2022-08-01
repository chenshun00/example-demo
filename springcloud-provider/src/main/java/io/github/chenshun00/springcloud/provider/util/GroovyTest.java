package io.github.chenshun00.springcloud.provider.util;


import groovy.lang.Binding;
import groovy.lang.GroovyShell;

/**
 * @author chenshun00@gmail.com
 * @since 2022/7/29 11:12 PM
 */
public class GroovyTest {

    public static void main(String[] args) {
        Binding bind = new Binding();
        bind.setVariable("name", "iamzhongyong");
        bind.setVariable("age", "25");
        GroovyShell shell = new GroovyShell(bind);
        Object obj = shell.evaluate("str = namess+age;return str");
        System.out.println(obj);
    }

}
