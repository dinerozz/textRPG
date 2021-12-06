package com.company;
import java.util.Scanner; // импортируем сканнер
import java.util.Random; // импортируем класс рандом

public abstract class Avatar { // Основной абстрактный класс с общими полями
    static Scanner scan = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m"; // Для смены цвета выводимого текста в консоли
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    static Random random = new Random(); // создаем экземпляр класса Random
    public static String gender; // создаем статическую строковую переменную для записи гендера
    public static int age; // общие поля
    public static int height = 180; // дефолтное значение роста персонажа
    public static int experience = 0; // количество опыта изначально
    public static  int heroLvl = 1; // уровень героя при старте
    public static int health = 1200; // базовое здоровье
    public static int enemyHealth = 1120; // базовое здоровье врага
    public static float enemyDamage = 50; // Базовый урон врага
    private static float damageWeap = 60; // базовый урон с оружия
    private static float damageMagic = 80; // Базовый магический урон
    private static float damageBow = 95; // поскольку используем эти поля только здесь, то зададим им модификатор доступа private.
    static int cntToWin = 0; // Количество ходов для победы - счетчик, инициализируем сначала как 0
    private static String name; // protected: такой класс или член класса доступен из любого места в текущем классе или пакете или в производных классах, даже если они находятся в других пакетах
    public static int choiceGender; // Переменная для свича, где мы выбираем пол персонажа


    // Методы setName, и наподобие еще называют мьютейтерами (mutator), так как они изменяют значения поля.
    // А методы getName, getAge и наподобие называют аксессерами (accessor), так как с их помощью мы получаем значение поля.
    // Причем в эти методы мы можем вложить дополнительную логику. Например, в данном случае при изменении возраста производится проверка,
    // насколько соответствует новое значение допустимому диапазону.
    public abstract void battleCry();
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
        // конструктор с заданными параметрами (при создании объекта можно использовать их)
    }
    public static void print_avatar() { // метод print_avatar для вывода меню и взаимодействия с пользователем
        Scanner scan = new Scanner(System.in); // создаем экземпляр класса Scanner
        int choice; // инициализируем переменную - переключатель
        System.out.println(ANSI_CYAN + "=======Добро пожаловать в мою пошаговую текстовую RPG игру!=======\nЗдесь вы сможете создать своего персонажа и противостоять врагам.");
        System.out.print("Придумайте имя для вашего персонажа: ");
        String n = scan.nextLine(); // сканируем строку с клавиатуры - имя персонажа
        User nickname = new User(n, age); // создаем экземпляр класса User - nickname для записи никнейма игрока
        Enemy marci = new Enemy("Marci", 1150, 50); // создаем экземпляр класса Enemy - враг нашего персонажа
        System.out.println("Рад знакомству, " + ANSI_GREEN + Avatar.name + ANSI_RESET); // Приветствуем игрока
        System.out.println("Пожалуйста, выберите персонажа, за которого Вы будете играть: ");
        System.out.println("[1] Эльф - обитатель острова Ультуан, прародитель эльфийской расы.");
        System.out.println("[2] Дварф - Вы низкорослый, широкоплечий гуманоид, любящий пиво.");
        System.out.println("[3] Орк - В прошлом Вы Эльф, ставший одиночкой, которого утащили и испортили злые духи!");
        choice = scan.nextInt(); // считываем значение с клавиатуры
        System.out.println("Выберите пол персонажа: ");
        System.out.println("1 - M | 2 - Ж");
        choiceGender = scan.nextInt(); // выбор пола
        if(choiceGender == 1){ // простое условие, проверяем введенное значение
            gender = "Муж";
        }else if(choiceGender == 2){
            gender = "Жен";
        }else{
            System.out.println("Нет такого гендера!");
            System.exit(1);
        }
        System.out.print("Введите возраст персонажа: ");
        age = scan.nextInt(); // Вводим возраст
        System.out.println("-------------------------------------------------");
        System.out.println("Приветствую Вас, я Мирана - Ваш гид на острове Ультуан!");
        System.out.println("Информация о вашем персонаже: ");
        switch (choice) { // конструкция switch case
            case 1 -> {
                Elf Elf = new Elf(n, age, heroLvl, experience, health, height, damageWeap, damageMagic, damageBow); // создаем объект-сущность героя с параметрами
                health += 150; // увеличиваем базовое здоровье
                height += 160; // увеличиваем базовый рост
                damageWeap += 65; // увеличиваем базовый урон с оружия
                damageMagic += 45; // увеличиваем базовый магический урон
                damageBow += 25; // увеличиваем базовый урон с оружия дальнего боя
                System.out.println("Вас зовут: " + Elf.getName() + "\nВаш возраст: " + Elf.age + " лет" + "\nПол: " + gender + "\nВы - Эльф, обитатель острова Ультуан.");
                Elf.battleCry(); // вызываем метод, в котором прописан боевой клич героя
                Elf.printElf_stats(); // Выводим статистику персонажа
                ready_status(); // Проверяем готовность к бою, вызывая метод ready_status
            }
            case 2 -> {
                Dwarv Dwarv = new Dwarv(n, age, heroLvl, experience, health, height, damageWeap, damageMagic, damageBow);
                health += 120;
                height += 100;
                damageWeap += 35;
                damageMagic += 25;
                damageBow += 65;
                System.out.println("Вас зовут: " + Dwarv.getName() + "\nВаш возраст: " + Dwarv.age + " лет" + "\nПол: " + gender + "\nВы - Дварф, низкорослый, широкоплечий гуманоид, любящий пиво.");
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
                System.out.println("Вас зовут: " + Orc.getName() + "\nВаш возраст: " + Orc.age + " лет" + "\nПол: " + gender + "\nВы - Орк, в прошлом - Эльф, ставший одиночкой, которого утащили и испортили злые духи!");
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

    private static void ready_status(){ // инициализируем метод для проверки готовности игрока к поединку
        int status; // инициализируем переменную для проверки
        System.out.println("---------------------Готов показать себя в бою?-----------------------");
        System.out.println("1 - Да | 2 - Нет");
        Scanner scan = new Scanner(System.in);
        status = scan.nextInt(); // считываем ответ
        if (status == 1){ // проверяем в условии введенное значение
            System.out.println("Отлично, вперед к победам!");
            System.out.println("Твой первый противник, гроза местных лесов - " + ANSI_PURPLE + " Marci" + ANSI_RESET + ", будь осторожен, она быстра и жестока!");
            Enemy.printEnemyStats(); // если 1, то выводим врага
            startFighting(); // начинаем бой
        }else if(status == 2){ // если 2, то выводим сообщение
            System.out.println("Очень жаль, возвращайся, как будешь готов!");
        }else{
            System.out.println("Я тебя не понимаю");
            System.exit(1);
        }
    }
    private static void print_attackMenu(){ // метод для вывода типа атаки
        System.out.println("Выберите тип атаки: ");
        System.out.println("1. Удар мечом.");
        System.out.println("2. Пустить огненный шар.");
        System.out.println("3. Выстрелить из лука.");
    }
    private static void startFighting(){
        Scanner scan = new Scanner(System.in);
        int attackType;
        print_attackMenu();
 // Метод, в котором прописываем сам бой, проверяем условия и производим все расчеты
        while((enemyHealth > 0) || (health > 0)){ // цикл while, пока здоровье врага > 0 или наше здоровье > 0
            attackType = scan.nextInt();
            cntToWin++; // наращиваем счетчик ходов с каждой итерацией
            switch(attackType){
                case 1:
                    enemyDamage = 0;
                    enemyDamage += random.nextInt(300);
                    health -= enemyDamage;
                    enemyHealth -= damageWeap;
                    System.out.println("=========Твое текущее состояние=========" + "\n[" + ANSI_GREEN + name + ANSI_RESET + "]\nHP(Здоровье): " + ANSI_RED + health + ANSI_RESET + "\nНанесено урона: " + damageWeap + "\nПолучено урона: " + enemyDamage);
                    System.out.println("=========Текущее состояние врага=========" + ANSI_PURPLE + "\n[Marci]" + ANSI_RESET + "\nHP(Здоровье): " + ANSI_RED + enemyHealth + ANSI_RESET);
                    print_attackMenu();
                    break;
                case 2:
                    enemyDamage = 0;
                    enemyDamage += random.nextInt(300);
                    health -= enemyDamage;
                    enemyHealth -= damageMagic;
                    System.out.println("=========Твое текущее состояние=========" + "\n[" + ANSI_GREEN + name + ANSI_RESET + "]\nHP(Здоровье): " + ANSI_RED + health + ANSI_RESET + "\nНанесено урона: " + damageMagic + "\nПолучено урона: " + enemyDamage);
                    System.out.println("=========Текущее состояние врага=========" + ANSI_PURPLE + "\n[Marci]" + ANSI_RESET + "\nHP(Здоровье): " + ANSI_RED + enemyHealth + ANSI_RESET);
                    print_attackMenu();
                    break;
                case 3:
                    enemyDamage = 0;
                    enemyDamage += random.nextInt(300);
                    health -= enemyDamage;
                    enemyHealth -= damageBow;
                    System.out.println("=========Твое текущее состояние=========" + "\n[" + ANSI_GREEN + name + ANSI_RESET + "]\nHP(Здоровье): " + ANSI_RED + health + ANSI_RESET + "\nНанесено урона: " + damageBow + "\nПолучено урона: " + enemyDamage);
                    System.out.println("=========Текущее состояние врага=========" + ANSI_PURPLE + "\n[Marci]" + ANSI_RESET + "\nHP(Здоровье): " + ANSI_RED + enemyHealth + ANSI_RESET);
                    print_attackMenu();
                    break;
                default:
                    System.out.println("Такого варианта нет!");
                    System.exit(1);
            }
            if(enemyHealth <= 0){
                experience += 100; // Если здоровье врага на нуле, то засчитываем победу, следовательно начисляем опыт, а также повышаем уровень
                heroLvl++;
                System.out.println("Поздравляем, " + name + " вы достигли " + heroLvl + " уровня!");
                System.out.println("Опыт: " + experience + "/500");
                print_victory(); // вывод сообщения победителю
                System.exit(1); // выход из программы
            }
            else if(health <= 0){
                print_lose();
            }
        }
    }
    public static void print_victory() {
        System.out.println(ANSI_GREEN + "==============================\n\n\n\nВы одержали победу за " + cntToWin + " ходов, спасибо за игру!" + ANSI_RESET); // вывод для победителя
        System.out.println("Хотите сыграть еще?");
        System.out.println("1. Да\n2. Нет");
        int try_again;
        try_again = scan.nextInt();
        switch(try_again){
            case 1:
                print_avatar();
                break;
            case 2:
                System.out.println("Возвращайтесь, если захотите сыграть снова :)");
                System.exit(1);
            break;
            default:
                System.exit(1);
        }
    }

    public static void print_lose() {
        System.out.println(ANSI_RED + "==============================\n\n\n\n\n\nВЫ ПРОИГРАЛИ." + ANSI_RESET); // вывод для проигравшего
        System.exit(1);
    }
}
