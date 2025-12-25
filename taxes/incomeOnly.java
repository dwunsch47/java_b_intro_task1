package taxes;

public class incomeOnly extends TaxSystem {
    private static final double TAX_AMOUNT = 0.06;

    @Override
    public int calcTaxFor(int debit, int credit) {
        return Math.max(0, (int)(debit * TAX_AMOUNT));
    }
}
