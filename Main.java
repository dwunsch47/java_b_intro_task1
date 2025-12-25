import deals.Deal;
import deals.Sale;
import deals.Expenditure;
import taxes.incomeMinusCredit;
import taxes.incomeOnly;

public class Main {
    public static void main(String[] args) {
        Company corpa = new Company("CORPA", new incomeOnly());
        corpa.shiftMoney(500);
        corpa.shiftMoney(-200);
        corpa.payTaxes();

        corpa.setTaxSystem(new incomeMinusCredit());
        corpa.shiftMoney(500);
        corpa.shiftMoney(-200);
        corpa.payTaxes();

        Deal[] deals = {
                new Sale("Молоко", 500),
                new Expenditure("Лампочка", 100)
        };
        corpa.applyDeals(deals);
    }
}