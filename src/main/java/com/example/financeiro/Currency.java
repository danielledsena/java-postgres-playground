package com.example.financeiro;

public class Currency {
    /**
     * Sigla da moeda de origem (com 3 letras).
     */
    private String from;
    private String to;
    private double quote;

    public Currency(String from, String to, double quote) {
        this.from = from;
        this.to = to;
        this.quote = quote;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getQuote() {
        return quote;
    }

}
