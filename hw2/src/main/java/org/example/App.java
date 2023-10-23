package org.example;

import org.example.task1.Atm;
import org.example.task1.Card;
import org.example.task1.CreditCard;
import org.example.task1.DebitCard;


public class App {
    public static void main(String[] args) {

        CreditCard credit = new CreditCard("Credit");
        DebitCard debit = new DebitCard("Debit");

        Atm<Card> atm = new Atm<>();

        System.out.println(atm.getBalance());
        System.out.println(atm.withdraw(1000));

        System.out.println(atm.insertCard(debit));


        System.out.println(atm.getBalance());
        System.out.println(atm.add(100));
        System.out.println(atm.withdraw(1000));

        System.out.println(atm.getOtherCurrencyBalance("PLN"));

        System.out.println(atm.removeCard());
        System.out.println(atm.removeCard());

        System.out.println(atm.insertCard(credit));

        System.out.println(atm.getBalance());
        System.out.println(atm.withdraw(1000));
        System.out.println(atm.getBalance());







    }
}
