package taxes;

public class incomeMinusCredit extends TaxSystem{
    private static final double TAX_AMOUNT = 0.15;

    @Override
    public int calcTaxFor(int debit, int credit) {
        return Math.max(0, (int)((debit - credit) * TAX_AMOUNT));
    }
}
