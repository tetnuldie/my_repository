package org.example.task1;

import java.util.*;

public class Atm <C extends Card> {
    private final Map<String, Float> currencyRates;
    private C card;

    public Atm() {
        Random rand = new Random();
        this.card = null;
        this.currencyRates = new HashMap<>();
        currencyRates.put("USD", rand.nextFloat(0.1f, 99));
        currencyRates.put("EUR", rand.nextFloat(0.1f, 99));
        currencyRates.put("PLN", rand.nextFloat(0.1f, 99));
    }

    public String insertCard(C card) {
        if (this.card != null) {
            return "Card already inserted";
        }
        this.card = card;
        return String.format("Card inserted\nHello %s", this.card.getCardholderName());
    }

    public String removeCard() {
        if (this.card == null) {
            return "No card inside";
        }
        String response = String.format("Take your card, %s", this.card.getCardholderName());
        this.card = null;
        return response;
    }


    public Set<Map.Entry<String, Float>> getCurrencyRates() {
        return currencyRates.entrySet();
    }

    public void putCurrencyRate(String currency, float rate) {
        currencyRates.put(currency, rate);
    }

    public String getBalance() {
        return card == null ? "Insert card" : String.format("Your balance is %.2f", card.getBalance());
    }

    public String withdraw(float amount) {
        if (card == null) {
            return "Insert card";
        }

        String response;
        try {
            card.withdraw(amount);
            response = "Take your money";
        } catch (ErrorException e) {
            response = "Failed\n" + e.getMessage();
        }
        return response;
    }

    public String add(float amount) {
        if (card == null) {
            return "Insert card";
        }
        String response;

        try {
            card.add(amount);
            response = "Funds added to balance";
        } catch (ErrorException e) {
            response = "Failed\n" + e.getMessage();
        }
        return response;
    }

    public String getOtherCurrencyBalance(String currency) {
        if (card == null) {
            return "Insert card";
        }
        String response;
        try {
            response = "Current balance is " + (card.getBalance() * currencyRates.get(currency)) + " " + currency;
        } catch (NullPointerException e) {
            response = "Failed to get currency rate for " + currency + "\n" + e.getMessage();
        }
        return response;
    }
}
