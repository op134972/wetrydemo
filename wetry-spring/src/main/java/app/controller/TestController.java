package app.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Speaker;

/**
 * Created by wch on 18-7-18.
 */
public class TestController {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        Speaker speaker = (Speaker) context.getBean("speaker");
        speaker.speak(" spring ");
    }
}
