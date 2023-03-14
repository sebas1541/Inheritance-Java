package model;

public class CheckingAccount extends Account {
    public CheckingAccount(float balance, float ratePerYear) {
        super(balance, ratePerYear);
    }

    public String retire(float quantity) {
        String result = "";
        this.balance -= quantity;
        this.withdrawalsNumber++;
        result = "Retiro realizado";

        return result;
    }
}

