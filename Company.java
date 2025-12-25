import taxes.TaxSystem;
import deals.Deal;

public class Company {
    private String title;
    private int debit;
    private int credit;
    private TaxSystem taxSystem;

    Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
    }

    public void shiftMoney(int amount) {
        if (amount > 0) {
            this.debit += amount;
        } else if (amount < 0) {
            this.credit += Math.abs(amount);
        }
    }

    public void setTaxSystem(TaxSystem newTaxSystem) {
        this.taxSystem = newTaxSystem;
    }

    public void payTaxes() {
        int payedTaxes = taxSystem.calcTaxFor(this.debit, this.credit);
        this.debit = 0;
        this.credit = 0;
        System.out.println("Компания " + this.title + " уплатила налог в размере: " + payedTaxes + " руб.");
    }

    public int applyDeals(Deal[] deals) {
        for (Deal deal : deals) {
            this.debit += deal.getDebitChange();
            this.credit += deal.getCreditChange();
        }
        int diff = this.debit - this.credit;
        payTaxes();
        return diff;
    }
}
