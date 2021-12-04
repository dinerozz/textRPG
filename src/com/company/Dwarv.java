package com.company;
import java.util.Scanner;

public class Dwarv extends Avatar {
    Dwarv(String name, int age) {
        super(name, age);
    }
    Dwarv(String name, int age, int experience, int heroLvl, int height, int health, float damageWeap, float damageMagic, float damageBow){
        super(name, age, experience, heroLvl, height, health, damageWeap, damageMagic, damageBow);
    }
    public void battleCry(){
        System.out.println("Клич: Кавабанга!");
    }
    public static void printDwarv_stats(){
        System.out.println("---------------------STATS-----------------------");
        System.out.println("Класс: Дварф");
        System.out.println("Уровень: " + Dwarv.heroLvl);
        System.out.println("Текущий опыт: " + Dwarv.experience + "/100");
        System.out.println("HP(Здоровье): " + Dwarv.health);
        System.out.println("Рост: " + Dwarv.height);
        System.out.println("Вооружение: Меч, магия, арбалет");
    }
}
