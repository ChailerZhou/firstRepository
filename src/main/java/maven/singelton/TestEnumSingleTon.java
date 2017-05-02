package maven.singelton;

public class TestEnumSingleTon {

    public static void main(String[] args) {
        EnumSingleTon action1 = EnumSingleTon.getInstance();
        EnumSingleTon action2 = EnumSingleTon.getInstance();
        action1.sayHello("Jack");
        System.out.println("action1==action2?" + (action1 == action2));
    }
}
