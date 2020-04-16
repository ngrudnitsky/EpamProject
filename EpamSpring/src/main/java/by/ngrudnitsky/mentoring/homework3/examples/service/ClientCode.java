package by.ngrudnitsky.mentoring.homework3.examples.service;

import by.ngrudnitsky.mentoring.homework3.examples.bean.Developer;
import by.ngrudnitsky.mentoring.homework3.examples.bean.Human;
import by.ngrudnitsky.mentoring.homework3.examples.bean.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientCode {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Developer dev = context.getBean("dev", Developer.class);
        Developer intern = context.getBean("intern", Developer.class);
        Developer net = context.getBean("dotNetDev", Developer.class);
        Developer anonymous = context.getBean("anonymous", Developer.class);

        intern.setLevel(1);
        intern.setSkill("Kotlin");

        System.out.println(dev);
        System.out.println(intern);
        System.out.println(net);
        System.out.println(anonymous);

        Project taxi = context.getBean("project", Project.class);

        System.out.println(taxi);

        Project java10 = context.getBean("Java 10", Project.class);
        System.out.println(java10);

        Human bob = context.getBean("human", Human.class);
        bob.talk();
        System.out.println(bob.getName() + " has iq: " + bob.getHead().getIq());
        System.out.println("Weight equals to " + bob.getWeight());

        Human john = context.getBean("bob", Human.class);
        System.out.println(john.getName() + " has iq: " + john.getHead().getIq());
        System.out.println("Weight equals to " + john.getWeight());
    }
}
