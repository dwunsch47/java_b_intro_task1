package deals;

public class Deal {
    private String comment;
    private int creditsChange;
    private int debitChange;

    Deal(String comment, int creditsChange, int debitChange) {
        this.comment = comment;
        this.creditsChange = creditsChange;
        this.debitChange = debitChange;
    }

    public int getCreditChange() {
        return this.creditsChange;
    }

    public int getDebitChange() {
        return this.debitChange;
    }
}
