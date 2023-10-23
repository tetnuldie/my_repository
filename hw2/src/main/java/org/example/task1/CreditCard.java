package org.example.task1;

import java.util.Objects;
import java.util.Random;

public class CreditCard extends Card {
    private final CardType cardType = CardType.CREDIT_CARD;

    public CreditCard(String name) {
        super(name);
    }

    public CardType getCardType() {
        return cardType;
    }

    public void withdraw(float amount) throws ErrorException {
        if (amount <= 0) {
            throw new ErrorException("Insufficient amount; Operation cant be performed");
        }

        float f = super.getBalance() - amount;
        setBalance(f);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCard that)) return false;
        if (!super.equals(o)) return false;
        return cardType == that.cardType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cardType);
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardType=" + cardType +
                "} " + super.toString();
    }
}
