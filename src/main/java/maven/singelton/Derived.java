package maven.singelton;

class Base {
    int i = 99;

    public void action() {
        System.out.println("Base action.");// 1
    }

    public Base() {
        action();
    }

    public int getI() {
        return i;
    }
}


public class Derived extends Base {
    int i = -1;// 3

    public static void main(String[] args) {
        Base b = new Derived();
        System.out.println(b.i);
        System.out.println(((Derived) b).i);
        System.out.println(b.getI());
        b.action();
    }

    /**
     * 有没有这个方法，不影响最终结果
     */
    public Derived() {
        super();
    }

    @Override
    public void action() {
        System.out.println("Derived action.");// 2,4
    }

    public int getI() {
        return i;
    }


}
