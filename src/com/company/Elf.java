package com.company;

import java.util.Scanner;

public class Elf extends Avatar {

    Elf(String name, int age) {
        super(name, age);
    }
    Elf(String name, int age, int experience, int heroLvl, int height, int health, float damageWeap, float damageMagic, float damageBow){
        super(name, age, experience, heroLvl, height, health, damageWeap, damageMagic, damageBow);
    }
    public void battleCry(){
        System.out.println("Клич: Ен Таро Адун!");
    }
    public static void printElf_stats(){
        System.out.println("---------------------STATS-----------------------");
        System.out.println("Класс: Эльф");
        System.out.println("Уровень: " + Elf.heroLvl);
        System.out.println("Текущий опыт: " + Elf.experience + "/100");
        System.out.println("HP(Здоровье): " + Elf.health);
        System.out.println("Рост: " + Elf.height);
        System.out.println("Вооружение: Меч, магия, лук");
    }
}
