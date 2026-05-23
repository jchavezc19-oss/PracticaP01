package strategy;

/**
 * Descuento porcentual.
 * Ejemplo: 10% de descuento.
 */
public class PercentageDiscount implements DiscountStrategy {
    private double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double applyDiscount(double total) {
        return total * (1 - percent / 100);
    }
}