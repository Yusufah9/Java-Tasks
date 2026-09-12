public class CheckOut { 
    private String[] items;
    private double[] prices;
    private int[] quantities;

    public CheckOut(String[] items, double[] prices, int[] quantities) {
        this.items = items;
        this.prices = prices;
        this.quantities = quantities;
    }

    public double calculateSubTotal() {
        double subTotal = 0.0;
        for (int count = 0; count < items.length; count++) {
            subTotal += prices[count] * quantities[count];
        }
        return subTotal;
    }

    public double calculateDiscount(double discountPercentage) {
        return (calculateSubTotal() * discountPercentage) / 100;
    }

    public double calculateVAT() {
        return (calculateSubTotal() * 7.5) / 100;
    }

    public double calculateBillTotal(double discountPercentage) {
        return calculateSubTotal() - calculateDiscount(discountPercentage) + calculateVAT();
    }
}