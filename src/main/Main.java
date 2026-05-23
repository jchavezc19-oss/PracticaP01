package main;

import models.Product;
import models.ShoppingCart;
import models.Order;
import strategy.PercentageDiscount;
import adapter.PayPalAdapter;
import adapter.ExternalPayPalService;
import observer.EmailNotificationObserver;
import observer.InventoryObserver;
import observer.AdminNotificationObserver;

/**
 * Punto de entrada de la tienda virtual.
 * Demuestra el uso de los patrones Strategy, Adapter y Observer.
 */
public class Main {
    public static void main(String[] args) {
        // 1. Crear productos
        Product laptop = new Product("Laptop", 1500.0);
        Product mouse = new Product("Mouse", 50.0);

        // 2. Agregar productos al carrito
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(laptop);
        cart.addProduct(mouse);
        System.out.println("Total sin descuento: S/ " + cart.getTotal());

        // 3. Aplicar estrategia de descuento (Strategy)
        cart.setDiscountStrategy(new PercentageDiscount(10)); // 10% de descuento
        double totalConDescuento = cart.getTotalAfterDiscount();
        System.out.println("Total con 10% descuento: S/ " + totalConDescuento);

        // 4. Procesar pago usando Adapter
        ExternalPayPalService paypalService = new ExternalPayPalService();
        PayPalAdapter paymentAdapter = new PayPalAdapter(paypalService);
        paymentAdapter.pay(totalConDescuento);

        // 5. Confirmar orden y notificar (Observer)
        Order order = new Order(cart);
        order.addObserver(new EmailNotificationObserver());
        order.addObserver(new InventoryObserver());
        order.addObserver(new AdminNotificationObserver());
        order.confirm();
    }
}