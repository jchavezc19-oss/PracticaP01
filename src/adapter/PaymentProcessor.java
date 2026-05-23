package adapter;

/**
 * Interfaz de pago utilizada por la tienda.
 * Define el método pay que recibe el monto a pagar.
 */
public interface PaymentProcessor {
    void pay(double amount);
}