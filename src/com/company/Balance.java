package com.company;

public class Balance extends Player{
    private double balance;

    public Balance(String email, int number, double balance){
        super(email, number);
        setBalance(balance);
    }
    public void mailConfirm(){
        System.out.println("Отправляем данные " + Avatar.name + " с балансом " + balance);
    }

    public double getBalance(){
        return balance;
    }
    public void setBalance(double newBalance){
        if(newBalance >= 0.0){
            balance = newBalance;
        }
    }

}
