package model;

public class SavingsAccount extends Account {
    private boolean active;

    public SavingsAccount(float balance, float ratePerYear) {
        super(balance, ratePerYear);
    }
}
