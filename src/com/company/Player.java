package com.company;

public abstract class Player {
    private String email;
    private int number;
    // абстракция – это процесс скрытия деталей реализации от пользователя,
    // предоставляя ему только функционал. Иными словами,
    // пользователь будет владеть информацией о том, что объект делает, а не как он это делает.
    //Класс, который во время объявления содержит в себе ключевое слово abstract, известен как абстрактный класс.
    //Абстрактные классы в Java могут содержать или не содержать абстрактные методы, т.е. методы без тела (public void get();)
    // Чтобы использовать абстрактный класс, нужно наследовать его из другого класса, обеспечить реализацию абстрактных методов в нём.
    public Player(String email, int number){
        System.out.println("Собираем данные о игроке");
        this.email = email;
        this.number = number;
    }
    public void mailConfirm(){
        System.out.println("Отправляем сообщение на " + this.email + " | " + this.number);
    }
    public String toString(){
        return email + " " + number;
    }
}
