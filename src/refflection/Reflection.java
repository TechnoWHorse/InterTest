package refflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.regex.Pattern;

class Wtf{}
class ParserOutside {
    int id;
    public ParserOutside(int i){
        this.id=i;
    }
    public <T> void getParsing(Class<?> obj) {
        superParser(obj);
        Class<?> superClass = obj.getSuperclass();
        for (; ; ) {
            if (superClass == null || superClass.isAssignableFrom(Object.class)) {
                return;
            }
            superParser(superClass);
            superClass = superClass.getSuperclass();
        }
    }

    public void superParser(Class<?> obj) {
        System.out.println("Parameters from " + obj.getSimpleName());
        System.out.println("Classes");
        counter(obj.getDeclaredClasses());
        System.out.println("Constructors");
        counter(obj.getDeclaredConstructors());
        System.out.println("Fields");
        counter(obj.getDeclaredFields());
        System.out.println("Methods");
        counter(obj.getDeclaredMethods());
    }

    public <T> void counter(T[] arrArgs) {
        for (T x : arrArgs) {
            System.out.println(x);
            System.out.println();
        }
    }
}
public class Reflection {
    static class Parser {

        public <T> void getParsing(Class<?> obj) {
            parse(obj);
            Class<?> superClass = obj.getSuperclass();
            for (; ; ) {
                if (superClass == null || superClass.isAssignableFrom(Object.class)) {
                    return;
                }
                parse(superClass);
                superClass = superClass.getSuperclass();
            }
        }

        public void parse(Class<?> obj) {
            System.out.println("Parameters from " + obj.getSimpleName());
            System.out.println("Classes");
            counter(obj.getDeclaredClasses());
            System.out.println("Constructors");
            counter(obj.getDeclaredConstructors());
            System.out.println("Fields");
            counter(obj.getDeclaredFields());
            System.out.println("Methods");
            counter(obj.getDeclaredMethods());
        }

        public <T> void counter(T[] arrArgs) {
            for (T x : arrArgs) {
                System.out.println(x);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Parser pr = new Reflection.Parser();
        pr.getParsing(Child.class);
        System.out.println("DEMON MUST DIE".replace(' ','_'));
        String test = "No Gods No Kings only Man\nFor strength and honor!";
//        System.out.println(Pattern.compile("No").matcher(test).find());

    }



    public static String stringSeparator(String str){
        StringBuilder result = new StringBuilder("[[");
        for (char add:str.toCharArray()) {
            result.append(add+"  ");
        }
        result.delete(result.length()-2,result.length());
        result.append("]]");
        return result.toString();
    }
}

interface Young {
    boolean beYoung(boolean isYoung);
}

interface Father {
    void beStrong(boolean isStrong);
}

class Adult implements Father {
    private String name;
    public int age;

    public Adult() {
    }

    public Adult(String name) {
        this.name = name;
    }

    interface HardWork {
    }

    class Work implements HardWork {
    }

    @Override
    public void beStrong(boolean isStrong) {
    }

    public String getName() {
        return name;
    }
}

class Child extends Adult implements Young {
    int talent;

    public Child(String name) {
        super(name);
    }

    private Child(int i, String name) {
        this(name);
    }

    public Child(int in) {
    }

    interface ConsoleGame {
        void play();
    }

    class Game implements ConsoleGame {

        @Override
        public void play() {

        }
    }

    @Override
    public boolean beYoung(boolean isYoung) {
        System.out.println("Yes");
        return isYoung;
    }
}
