package mistycalShop;

public class BankAccount {
    private final int id;
    private long moneyCount;
    public BankAccount(int id){
        this.id=id;
    }
    public long getMoneyCount() {
        return moneyCount;
    }

    public int getId() {
        return id;
    }

    public void setMoneyCount(long moneyCount) {
        this.moneyCount = moneyCount;
    }
}
