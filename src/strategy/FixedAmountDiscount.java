package strategy;

public class FixedAmountDiscount implements DiscountStrategy {
    private double discount;
    public FixedAmountDiscount(double discount) {
        this.discount = discount;
    }
    public double applyDiscount(double total) {
        return Math.max(0, total - discount);
    }
}