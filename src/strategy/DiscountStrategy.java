package strategy;

/**
 * Estrategia de descuento (patrón Strategy).
 * Define el contrato para aplicar un descuento sobre un total.
 */
public interface DiscountStrategy {
    double applyDiscount(double total);
}