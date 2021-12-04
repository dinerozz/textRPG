package com.company;
import java.util.Scanner;
import java.util.Random;

public class Avatar { // Основной класс с общими полями персонажа
    static Random random = new Random();
    public static String gender;
    String race;
    public static int age; // общие поля
    public static int height = 180;
    public static int experience = 0;
    public static  int heroLvl = 1;
    public static int health = 1200;
    public static int enemyHealth = 1120;
    public static float enemyDamage = 50;
    private static float damageWeap = 60;
    private static float damageMagic = 80;
    private static float damageBow = 95; // поскольку используем эти поля только здесь, то зададим им модификатор доступа private.
    static int cntToWin = 0;
    protected static String name; // protected: такой класс или член класса доступен из любого места в текущем классе или пакете или в производных классах, даже если они находятся в других пакетах
    public static int choiceGender;


    // Методы setName, и наподобие еще называют мьютейтерами (mutator), так как они изменяют значения поля.
    // А методы getName, getAge и наподобие называют аксессерами (accessor), так как с их помощью мы получаем значение поля.
    // Причем в эти методы мы можем вложить дополнительную логику. Например, в данном случае при изменении возраста производится проверка,
    // насколько соответствует новое значение допустимому диапазону.
    public  void battleCry() {};
    Avatar(String name, int enemyHealth, float enemyDamage) { // конструкторы создают экземпляры класса, конструкторов
        // может быть сколько угодно в классе. Конструкторы позволяют создавать объекты с параметрами
    }
    Avatar(String name, int age){ // конструктор
        setName(name);
    }
    static void setName(String n){ // метод, устанавливаем имя персонажа
        name = n;
    }
    String getName(){
        return name; // возвращаем имя
    }
    Avatar(String name, int age, int experience, int heroLvl, int height, int health, float damageWeap, float damageMagic, float damageBow){
    }

    public static void print_avatar() { // метод print_avatar для вывода меню и взаимодействия с пользователем
        Scanner scan = new Scanner(System.in);
        int choice;
        System.out.println("=======Добро пожаловать в мою пошаговую текстовую RPG игру!=======\nЗдесь вы сможете создать своего персонажа и противостоять врагам.");
        System.out.print("Придумайте имя для вашего персонажа: ");
        String n = scan.nextLine();
        Avatar nickname = new Avatar(n, age); // создаем экземпляр класса Avatar - nickname для записи никнейма игрока
        Enemy marci = new Enemy("Marci", 1150, 50);
        System.out.println("Рад знакомству, " + Avatar.name);
        System.out.println("Пожалуйста, выберите персонажа, за которого Вы будете играть: ");
        System.out.println("[1] Эльф - обитатель острова Ультуан, прародитель эльфийской расы.");
        System.out.println("[2] Дварф - Вы низкорослый, широкоплечий гуманоид, любящий пиво.");
        System.out.println("[3] Орк - В прошлом Вы Эльф, ставший одиночкой, которого утащили и испортили злые духи!");
        choice = scan.nextInt();
        System.out.println("Выберите пол персонажа: ");
        System.out.println("1 - M | 2 - Ж");
        choiceGender = scan.nextInt();
        if(choiceGender == 1){
            gender = "Муж";
        }else if(choiceGender == 2){
            gender = "Жен";
        }else{
            System.out.println("Нет такого гендера!");
            System.exit(1);
        }
        System.out.print("Введите возраст персонажа: ");
        age = scan.nextInt();
        System.out.println("-------------------------------------------------");
        System.out.println("Приветствую Вас, я Мирана - Ваш гид на острове Ультуан!");
        System.out.println("Информация о вашем персонаже: ");
        Balance bal = new Balance ("saddness@gmail.com", 7777, 3600.00);
        System.out.println("Вызываем подтверждение на почту, используя ссылку Balance --");
        bal.mailConfirm();
        switch (choice) {
            case 1 -> {
                Elf Elf = new Elf(n, age, heroLvl, experience, health, height, damageWeap, damageMagic, damageBow); // создаем объект-сущность героя с параметрами
                health += 150;
                height += 160;
                damageWeap += 65;
                damageMagic += 45;
                damageBow += 25;
                System.out.println("Вас зовут: " + Elf.name + "\nВаш возраст: " + Elf.age + " лет" + "\nПол: " + gender + "\nВы - Эльф, обитатель острова Ультуан.");
                Elf.battleCry();
                Elf.printElf_stats();
                ready_status();
            }
            case 2 -> {
                Dwarv Dwarv = new Dwarv(n, age, heroLvl, experience, health, height, damageWeap, damageMagic, damageBow);
                health += 120;
                height += 100;
                damageWeap += 35;
                damageMagic += 25;
                damageBow += 65;
                System.out.println("Вас зовут: " + Dwarv.name + "\nВаш возраст: " + Dwarv.age + " лет" + "\nПол: " + gender + "\nВы - Дварф, низкорослый, широкоплечий гуманоид, любящий пиво.");
                Dwarv.battleCry();
                Dwarv.printDwarv_stats();
                ready_status();
            }
            case 3 -> {
                Orc Orc = new Orc(n, age, heroLvl, experience, health, height, damageWeap, damageMagic, damageBow);
                health += 400;
                height += 180;
                damageWeap += 75;
                damageMagic += 25;
                damageBow += 35;
                System.out.println("Вас зовут: " + Orc.name + "\nВаш возраст: " + Orc.age + " лет" + "\nПол: " + gender + "\nВы - Орк, в прошлом - Эльф, ставший одиночкой, которого утащили и испортили злые духи!");
                Orc.battleCry();
                Orc.printOrc_stats();
                ready_status();
            }
            default -> {
                System.out.println("Нет такого аватара!");
                System.exit(1);
            }
        }

    }

    public static void ready_status(){
        int status;
        System.out.println("---------------------Готов показать себя в бою?-----------------------");
        System.out.println("1 - Да | 2 - Нет");
        Scanner scan = new Scanner(System.in);
        status = scan.nextInt();
        if (status == 1){
            System.out.println("Отлично, вперед к победам!");
            System.out.println("Твой первый противник, гроза местных лесов - Marci, будь осторожен, она быстра и жестока!");
            Enemy.printEnemyStats();
            startFighting();
        }else if(status == 2){
            System.out.println("Очень жаль, возвращайся, как будешь готов!");
        }else{
            System.out.println("Я тебя не понимаю");
            System.exit(1);
        }
    }
    public static void print_attackMenu(){
        System.out.println("Выберите тип атаки: ");
        System.out.println("1. Удар мечом.");
        System.out.println("2. Пустить огненный шар.");
        System.out.println("3. Выстрелить из лука.");
    }
    public static void startFighting(){
        Scanner scan = new Scanner(System.in);
        int attackType;
        print_attackMenu();

        while((enemyHealth > 0) || (health > 0)){
            attackType = scan.nextInt();
            cntToWin++;
            switch(attackType){
                case 1:
                    enemyDamage = 0;
                    enemyDamage += random.nextInt(300);
                    health -= enemyDamage;
                    enemyHealth -= damageWeap;
                    System.out.println("=========Твое текущее состояние=========" + "\n[" + name + "]\nHP(Здоровье): " + health + "\nНанесено урона: " + damageWeap + "\nПолучено урона: " + enemyDamage);
                    System.out.println("=========Текущее состояние врага=========" + "\n[Marci]" + "\nHP(Здоровье): " + enemyHealth);
                    print_attackMenu();
                    break;
                case 2:
                    enemyDamage = 0;
                    enemyDamage += random.nextInt(300);
                    health -= enemyDamage;
                    enemyHealth -= damageMagic;
                    System.out.println("=========Твое текущее состояние=========" + "\n[" + name + "]\nHP(Здоровье): " + health + "\nНанесено урона: " + damageMagic + "\nПолучено урона: " + enemyDamage);
                    System.out.println("=========Текущее состояние врага=========" + "\n[Marci]" + "\nHP(Здоровье): " + enemyHealth);
                    print_attackMenu();
                    break;
                case 3:
                    enemyDamage = 0;
                    enemyDamage += random.nextInt(300);
                    health -= enemyDamage;
                    enemyHealth -= damageBow;
                    System.out.println("=========Твое текущее состояние=========" + "\n[" + name + "]\nHP(Здоровье): " + health + "\nНанесено урона: " + damageBow + "\nПолучено урона: " + enemyDamage);
                    System.out.println("=========Текущее состояние врага=========" + "\n[Marci]" + "\nHP(Здоровье): " + enemyHealth);
                    print_attackMenu();
                    break;
                default:
                    System.out.println("Такого варианта нет!");
                    System.exit(1);
            }
            if(enemyHealth <= 0){
                experience += 100;
                heroLvl++;
                System.out.println("Поздравляем, " + name + " вы достигли " + heroLvl + " уровня!");
                System.out.println("Опыт: " + experience + "/500");
                print_victory();
                System.exit(1);
            }
            else if(health <= 0){
                print_lose();
            }
        }
    }
    public static void print_victory() {
        System.out.println("==============================\n\n\n\nВы одержали победу за " + cntToWin + " ходов, спасибо за игру!");
    }

    public static void print_lose() {
        System.out.println("==============================\n\n\n\n\n\nВЫ ПРОИГРАЛИ.");
        System.exit(1);
    }
}
