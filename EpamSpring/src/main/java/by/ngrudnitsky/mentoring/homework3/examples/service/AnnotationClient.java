package by.ngrudnitsky.mentoring.homework3.examples.service;

import by.ngrudnitsky.mentoring.homework3.examples.bean.Human;
import by.ngrudnitsky.mentoring.homework3.examples.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationClient {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Human humanBean = context.getBean(Human.class);
        humanBean.talk();
        System.out.println(humanBean.getName() + " iq is " + humanBean.getHead().getIq());
    }
}
