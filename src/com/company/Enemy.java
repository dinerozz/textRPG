package com.company;

public class Enemy extends Avatar{ // класс Enemy наследует доступные поля из Avatar

    Enemy(String name, int enemyHealth, float enemyDamage) {
        super(name, enemyHealth, enemyDamage); // Конструктор
    }
    public static void printEnemyStats(){
        System.out.println("---------------------Враг: Marci-----------------------");
        System.out.println("Класс: Человек");
        System.out.println("HP(Здоровье): " + enemyHealth); // вывод статистики врага
        System.out.println("Урон: динамический");
    }
}

