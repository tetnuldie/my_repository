package org.example.task1;

import java.util.Objects;
import java.util.Random;

public class Card {
    private final String cardholderName;
    private final int cardNo;
    private float balance;

    public Card(String name) {
        Random rand = new Random();
        this.cardNo = rand.nextInt(100000, 1000000);
        this.cardholderName = name;
        this.balance = 0.0f;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public int getCardNo() {
        return cardNo;
    }

    public float getBalance() {
        return balance;
    }

    protected void setBalance(float balance) {
        this.balance = balance;
    }

    public void add(float amount) throws ErrorException {
        if (amount <= 0) {
            throw new ErrorException("Insufficient amount; Operation cant be performed");
        }

        this.setBalance(this.balance + amount);
    }

    public void withdraw(float amount) throws ErrorException {
        if (amount <= 0) {
            throw new ErrorException("Insufficient amount; Operation cant be performed");
        }

        float f = this.balance - amount;
        if (f < 0) {
            throw new ErrorException("Insufficient balance. Not enough funds to proceed");
        } else {
            setBalance(f);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return getCardNo() == card.getCardNo() && Float.compare(card.getBalance(), getBalance()) == 0 && Objects.equals(getCardholderName(), card.getCardholderName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardholderName(), getCardNo(), getBalance());
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardholderName='" + cardholderName + '\'' +
                ", cardNo=" + cardNo +
                ", balance=" + balance +
                '}';
    }
}
