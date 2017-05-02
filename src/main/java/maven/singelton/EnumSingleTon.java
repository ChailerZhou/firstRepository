package maven.singelton;

public class EnumSingleTon {

    private EnumSingleTon() {}

    public static EnumSingleTon getInstance() {
        return ActionEnum.INTERFACE.getInstance();
    }

    public void sayHello(String name) {
        System.out.println(name + ",Hello!");
    }

    private static enum ActionEnum {
        INTERFACE;

        private EnumSingleTon singleton = null;

        private ActionEnum() {
            singleton = new EnumSingleTon();
        }

        public EnumSingleTon getInstance() {
            return singleton;
        }
    }
}
