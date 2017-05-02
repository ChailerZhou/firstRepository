package maven.charlie.step1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HelloWorldTest {

    @Before
    public void setUp() throws Exception {}

    @Test
    public void testSayHello() {
        HelloWorld hw = new HelloWorld();
        assertEquals(0, hw.sayHello("Charlie.zhou"));
    }

}
