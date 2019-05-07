import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringMain {
    public static void main(String[] args) {
        ApplicationContext con = new FileSystemXmlApplicationContext("D:\\Code\\JavaLearn\\Spring\\aop.xml");
        Bird bird = (Bird)con.getBean("bird");
        Person person = (Person) con.getBean("person");
        bird.eat();
        person.eat();
    }
}
