package adapter;

/**
 * Adaptador que permite usar el servicio externo PayPal
 * con la interfaz PaymentProcessor de la tienda (patrón Adapter).
 */
public class PayPalAdapter implements PaymentProcessor {
    private ExternalPayPalService payPalService;

    public PayPalAdapter(ExternalPayPalService payPalService) {
        this.payPalService = payPalService;
    }

    @Override
    public void pay(double amount) {
        // Se adapta la llamada: se añade la moneda "PEN" por defecto
        payPalService.makePayment("PEN", amount);
    }
}