package model;

public class Account {
    protected float balance;
    protected int consignmentsNumber;
    protected int withdrawalsNumber;
    protected float ratePerYear;
    protected float comission;

    public Account() {
        this.withdrawalsNumber = 0;
        this.consignmentsNumber = 0;
    }

    public Account(float balance, float ratePerYear) {
        this.balance = balance;
        this.ratePerYear = ratePerYear;
        this.withdrawalsNumber = 0;
        this.consignmentsNumber = 0;
    }

    public void setComission(float comission) {
        this.comission = comission / 100;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getConsignmentsNumber() {
        return consignmentsNumber;
    }

    public void setConsignmentsNumber(int consignmentsNumber) {
        this.consignmentsNumber = consignmentsNumber;
    }

    public int getWithdrawalsNumber() {
        return withdrawalsNumber;
    }

    public void setWithdrawalsNumber(int withdrawalsNumber) {
        this.withdrawalsNumber = withdrawalsNumber;
    }

    public float getComission() {
        return comission;
    }

    public void setRatePerYear(float ratePerYear) {
        this.ratePerYear = ratePerYear;
    }

    public float getRatePerYear() {
        return ratePerYear;
    }

    public float getBalance() {
        return balance;
    }

    public String consign(float quatity) {
        String result = "";
        this.balance += quatity;
        this.consignmentsNumber++;
        result = "Transacción realizada";
        return result;
    }

    public String retire(float quantity) {
        String result = "";
        if (this.balance > quantity) {
            this.balance -= quantity;
            this.withdrawalsNumber++;
            result = "Retiro realizado";
        } else {
            result = "Su monto es mayor al saldo";
        }
        return result;
    }

    public float calculateInterest() {
        return (this.balance * this.ratePerYear) / 12;
    }

    public float monthlyAbstract() {
        float interest = 0;
        float monthlyComission = 0;
        interest = this.calculateInterest();
        monthlyComission = this.comission * (this.consignmentsNumber + this.withdrawalsNumber);
        return (this.balance + interest) - monthlyComission;
    }

    public void transfer(Account account, float quantity) {
        if (quantity < this.balance) {
            this.balance -= quantity;
            account.balance += quantity;
        }
    }
}