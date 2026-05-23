package adapter;

/**
 * Servicio externo de PayPal (simulado).
 * No implementa nuestra interfaz PaymentProcessor.
 */
public class ExternalPayPalService {
    public void makePayment(String currency, double amount) {
        System.out.println("💰 Pago realizado con PayPal: " + currency + " " + amount);
    }
}