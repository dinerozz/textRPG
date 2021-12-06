package com.company;
import java.util.Scanner;

public class Dwarv extends Avatar {
    Dwarv(String name, int age) {
        super(name, age);
    } // конструктор с именем и возрастом
    Dwarv(String name, int age, int experience, int heroLvl, int height, int health, float damageWeap, float damageMagic, float damageBow){
        super(name, age, experience, heroLvl, height, health, damageWeap, damageMagic, damageBow);// Конструктор с множеством параметров, которые пригодятся при создании экземпляров класса
    }
    public void battleCry(){
        System.out.println("Клич: Кавабанга!");
    } // Боевой клич в методе battleCry()
    public static void printDwarv_stats(){
        System.out.println("---------------------STATS-----------------------"); // Вывод статистики героя
        System.out.println("Класс: Дварф");
        System.out.println("Уровень: " + Dwarv.heroLvl);
        System.out.println("Текущий опыт: " + Dwarv.experience + "/100");
        System.out.println("HP(Здоровье): " + ANSI_RED + Dwarv.health + ANSI_RESET);
        System.out.println("Рост: " + Dwarv.height);
        System.out.println("Вооружение: Меч, магия, арбалет");
    }
}
