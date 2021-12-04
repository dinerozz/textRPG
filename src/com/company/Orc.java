package com.company;

import java.util.Scanner;

public class Orc extends Avatar {
    Orc(String name, int age) {
        super(name, age);
    }
    Orc(String name, int age, int experience, int heroLvl, int height, int health, float damageWeap, float damageMagic, float damageBow){
        super(name, age, experience, heroLvl, height, health, damageWeap, damageMagic, damageBow);
    }
    public void battleCry(){
        System.out.println("Клич: Лок’тар огар!");
    }
    public static void printOrc_stats(){
        System.out.println("---------------------STATS-----------------------");
        System.out.println("Класс: Орк");
        System.out.println("Уровень: " + Orc.heroLvl);
        System.out.println("Текущий опыт: " + Orc.experience + "/100");
        System.out.println("HP(Здоровье): " + Orc.health);
        System.out.println("Рост: " + Orc.height);
        System.out.println("Вооружение: Меч, магия, копье");
    }
}
