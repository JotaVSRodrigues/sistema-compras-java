package org.example.Classes;

public class Purchase implements Comparable<Purchase> {
    private String description;
    private float value;

    public Purchase(String description, float value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Descrição: " + getDescription() + " | Valor: " + getValue();
    }

    @Override
    public int compareTo(Purchase o) {
        return Float.compare(this.getValue(), o.getValue());
    }
}