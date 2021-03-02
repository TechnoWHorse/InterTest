package com.interTest.patterns.Factori;


interface Factory {
    <T extends RareWeapon> HumanInterface createHuman(String race, int age, T item);
}

interface HumanInterface {
    void fight();

    void setWeapon(Item weapon);
}

public class HumanFactory implements Factory {
    private HumanFactory(){

    }
    public static Factory getFact(){
        return new HumanFactory();
    }
    @Override
    public <T extends RareWeapon> HumanInterface createHuman(String race, int age1, T item) {
        class HumanFromFactory implements HumanInterface {
            final String race;
            final int age;
            Item weapon;

            HumanFromFactory(String race, T item) {
                this.race = race;
                this.age = age1;
                this.weapon = item;
                System.out.println(this + race + age + weapon);
            }

            @Override
            public void fight() {
                System.out.println(this + " FIGHTING LIKE BOSS");
            }

            @Override
            public void setWeapon(Item weapon) {
                System.out.println(weapon);
                this.weapon = weapon;
            }
            public void battleCRY(){
                System.out.println("AAAAAAAAAARRR");
            }
        }
        return new HumanFromFactory(race, item);
    }

    public static void main(String[] args) {
        HumanInterface humanInterface = HumanFactory.getFact().createHuman("Orc",25,new RareWeapon());
//        Human hum = (Human) Human.createFighter("Rigard", 25, new Item());
//        hum.gonnaSuicide();
//        System.out.println(hum.weapon);
    }


}

class Human<T extends Item> implements HumanInterface {
    String name;
    int str;
    T weapon;

    private Human(String n, int s, T weapon) {
        this.name = n;
        this.str = s;
        this.weapon = weapon;
    }

    public void gonnaSuicide() {
        System.out.println(this + " DIE... RIP");
    }

    public static <T extends Item> HumanInterface createFighter(String name, int str, T weapon) {
        return new Human<T>(name, str, weapon);
    }

    @Override
    public void fight() {
        System.out.println(this + " began fight");
        weapon.hitTheTarget();
    }

    @Override
    public void setWeapon(Item weapon) {
        this.weapon= (T) weapon;
    }
}

class Item {
    public void hitTheTarget() {
        System.out.println("target hated");
    }
}

class Weapon extends Item {

}

class RareWeapon extends Weapon {
    String rareOnly = "IM RARE ";
    public String toString(){
        return rareOnly;
    }
}
