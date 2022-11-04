package com.psi.project.items.valueobjects;

public class PriceValidator {

    Double price;

    public PriceValidator(Double price) {
        this.price = price;
    }

    public double toDouble() {
        return this.price;
    }
}
