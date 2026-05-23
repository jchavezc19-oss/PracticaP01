package observer;

/**
 * Observador que simula el envío de un correo electrónico al cliente.
 */
public class EmailNotificationObserver implements OrderObserver {
    @Override
    public void update(String message) {
        System.out.println("📧 Enviando correo al cliente: " + message);
    }
}