package jenerics;

public class TesterTask {
    public static void main(String[] args) {
//        NoReflection nr = new NoReflection();
        Fight<Orc> f = new Orc();
        f.duel(new Orc());
    }
}

interface Fight<T extends Unit<T>> {
    void duel(T t);
}

abstract class Unit<T extends Unit<T>> implements Fight<T> {
    int hp;
    int dmg;

    @Override
    public void duel(T t) {
        if(this.hp==t.hp&&this.dmg==t.dmg){
            subCompare(t);
        }

    }
   public abstract void subCompare(T x);
}

class Orc extends Unit<Orc>{
    boolean strong;

    @Override
    public void subCompare(Orc x) {

    }
}

class Undead extends Unit<Undead> {
    boolean dead;


    @Override
    public void subCompare(Undead x) {

    }
}
