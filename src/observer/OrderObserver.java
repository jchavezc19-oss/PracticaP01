package observer;

/**
 * Interfaz para los observadores de una orden de compra (patrón Observer).
 * Todos los observadores deben implementar update.
 */
public interface OrderObserver {
    void update(String message);
}