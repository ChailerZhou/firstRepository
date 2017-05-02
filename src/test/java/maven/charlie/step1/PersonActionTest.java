package maven.charlie.step1;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonActionTest {
    ApplicationContext ctx;

    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("aop.xml");
    }

    @Test
    public void test() {
        PersonAction pa1 = (PersonAction) ctx.getBean("Farmer");

        pa1.go();
        pa1.work();

        System.out.println();
        PersonAction pa2 = (PersonAction) ctx.getBean("Doctor");
        pa2.go();
        pa2.work();
    }
}
