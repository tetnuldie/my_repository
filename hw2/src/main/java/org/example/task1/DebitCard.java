package org.example.task1;

import java.util.Objects;
import java.util.Random;

public class DebitCard extends Card{
    private final CardType cardType = CardType.DEBIT_CARD;

    public DebitCard(String name) {
        super(name);
    }

    public CardType getCardType() {
        return cardType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DebitCard debitCard)) return false;
        if (!super.equals(o)) return false;
        return cardType == debitCard.cardType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cardType);
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "cardType=" + cardType +
                "} " + super.toString();
    }
}
