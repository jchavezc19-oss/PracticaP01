package models;

import observer.OrderObserver;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una orden de compra.
 * Al confirmarse, notifica a todos los observadores registrados.
 */
public class Order {
    private List<OrderObserver> observers = new ArrayList<>();
    private ShoppingCart cart;
    private double finalAmount;

    public Order(ShoppingCart cart) {
        this.cart = cart;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void confirm() {
        finalAmount = cart.getTotalAfterDiscount();
        String message = "Compra confirmada por S/ " + finalAmount;
        System.out.println(message);
        // Notificar a todos los observadores
        for (OrderObserver obs : observers) {
            obs.update(message);
        }
    }

    public double getFinalAmount() { return finalAmount; }
}