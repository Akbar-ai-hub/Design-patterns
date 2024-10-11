package Praktika;

import java.util.ArrayList;
import java.util.List;

interface Cloneable<T> {
    T clone();
}

class Skill implements Cloneable<Skill> {
    private String name;
    private int power;

    public Skill(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    @Override
    public Skill clone() {
        return new Skill(name, power);
    }

    public void setPower(int i) {
        this.power = i;
    }
}

class Weapon implements Cloneable<Weapon> {
    private String name;
    private int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public Weapon clone() {
        return new Weapon(name, damage);
    }

    public void setDamage(int i) {
        this.damage = i;
    }
}

class Armor implements Cloneable<Armor> {
    private String name;
    private int defense;

    public Armor(String name, int defense) {
        this.name = name;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public Armor clone() {
        return new Armor(name, defense);
    }
}

class Character implements Cloneable<Character> {
    private int health;
    private int strength;
    private int agility;
    private int intelligence;
    private Weapon weapon;
    private Armor armor;
    private List<Skill> skills;

    public Character(int health, int strength, int agility, int intelligence, Weapon weapon, Armor armor, List<Skill> skills) {
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.weapon = weapon;
        this.armor = armor;
        this.skills = skills;
    }

    @Override
    public Character clone() {
        Weapon clonedWeapon = weapon.clone();
        Armor clonedArmor = armor.clone();

        List<Skill> clonedSkills = new ArrayList<>();
        for (Skill skill : skills) {
            clonedSkills.add(skill.clone());
        }

        return new Character(health, strength, agility, intelligence, clonedWeapon, clonedArmor, clonedSkills);
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public List<Skill> getSkills() {
        return skills;
    }
}


public class Praktika53 {
    public static void main(String[] args) {
        Weapon sword = new Weapon("Sword", 50);
        Armor shield = new Armor("Shield", 30);
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Fireball", 100));
        skills.add(new Skill("Slash", 75));

        Character originalCharacter = new Character(100, 20, 15, 10, sword, shield, skills);

        Character clonedCharacter = originalCharacter.clone();

        originalCharacter.getWeapon().setDamage(60);
        originalCharacter.getSkills().get(0).setPower(120);

        System.out.println("Original Weapon Damage: " + originalCharacter.getWeapon().getDamage());
        System.out.println("Cloned Weapon Damage: " + clonedCharacter.getWeapon().getDamage());
        System.out.println("Original Fireball Power: " + originalCharacter.getSkills().get(0).getPower());
        System.out.println("Cloned Fireball Power: " + clonedCharacter.getSkills().get(0).getPower());
    }
}
