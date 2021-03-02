package String;

public class SkiledDragunov extends Dragunov{
    public static String who = "class";

    public static void main(String[] args) {
        SkiledDragunov.G();
    }

    public static void F() {
        who = "kido raq";
    }

    public static void G() {
        F();
        System.out.println(count);
    }
    public static void Z(){
        String who = "from Z";
        F();
        System.out.println(who);
        System.out.println(SkiledDragunov.who);
    }
    public static void doSomething(){
        System.out.println(count);
        System.out.println("lili players so weak");
        int count = 10;
        for (int i = 0; i < count; i++) {
            System.out.println(i);
        }
    }
}
