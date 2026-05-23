package models;

import java.util.ArrayList;
import java.util.List;
import strategy.DiscountStrategy;

/**
 * Carrito de compras. Permite agregar productos,
 * calcular total y aplicar una estrategia de descuento (Strategy).
 */
public class ShoppingCart {
    private List<Product> items = new ArrayList<>();
    private DiscountStrategy discountStrategy;  // estrategia actual de descuento

    public void addProduct(Product p) {
        items.add(p);
    }

    public double getTotal() {
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }
        return total;
    }

    public double getTotalAfterDiscount() {
        double total = getTotal();
        if (discountStrategy != null) {
            return discountStrategy.applyDiscount(total);
        }
        return total;
    }

    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    public List<Product> getItems() { return items; }
}