package com.company;

import java.util.Scanner;

public class Orc extends Avatar {
    Orc(String name, int age) {
        super(name, age);
    } // конструктор с именем и возрастом
    Orc(String name, int age, int experience, int heroLvl, int height, int health, float damageWeap, float damageMagic, float damageBow){
        super(name, age, experience, heroLvl, height, health, damageWeap, damageMagic, damageBow); // Конструктор с множеством параметров, которые пригодятся при создании экземпляров класса
    }
    public void battleCry(){
        System.out.println("Клич: Лок’тар огар!");
    } // Боевой клич в методе battleCry()
    public static void printOrc_stats(){ // Вывод статистики героя
        System.out.println("---------------------STATS-----------------------");
        System.out.println("Класс: Орк");
        System.out.println("Уровень: " + Orc.heroLvl);
        System.out.println("Текущий опыт: " + Orc.experience + "/100");
        System.out.println("HP(Здоровье): " + ANSI_RED + Orc.health + ANSI_RESET);
        System.out.println("Рост: " + Orc.height);
        System.out.println("Вооружение: Меч, магия, копье");
    }
}
