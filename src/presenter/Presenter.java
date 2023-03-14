package presenter;

import view.View;
import model.Account;

public class Presenter {
    private View view;
    private Account account;
    private Account account2;

    public Presenter() {
        view = new View();
        account = new Account();
        account2 = new Account();
    }

    public void run() {
        int option = 0;
        view.showMessage("Esta es una versión de prueba, digite los montos de prueba de:");
        account.setComission(view.readFloat("La comisión (En por ciento): "));
        account.setRatePerYear(view.readFloat("Tasa Anual(En por ciento): "));
        while (option != 2) {
            option = menu();
            switch (option) {
                case 1:
                    this.ownAccount();
                    break;
                case 2:
                    view.showMessage("Adiós");
                    System.exit(0);
                    break;
                default:
                    view.showMessage("Digite una opción correcta");
                    break;
            }
        }
    }

    public void ownAccount() {
        int option = 0;
        while (option != 6) {
            option = this.accountMenu();
            switch (option) {
                case 1:
                    view.showMessage(account.consign(view.readFloat("Digite la cantidad de ingreso")));
                    view.showMessage("Su saldo es: " + account.getBalance());
                    break;
                case 2:
                    view.showMessage(account.retire(view.readFloat("Digite la cantidad de retiro")));
                    view.showMessage("Su saldo es: " + account.getBalance());
                    break;
                case 3:
                    view.showMessage("El interés de su cuenta es: " + account.calculateInterest());
                    break;
                case 4:
                    view.showMessage("El extracto mensual de su cuenta: " + account.monthlyAbstract());
                    break;
                case 5:
                    account.transfer(account2, view.readFloat("Ingrese el monto a transferir"));
                    view.showMessage("Transacción realizada, su saldo es: " + account.getBalance());
                    break;
                default:
                    view.showMessage("Digite una opción correcta");
                    break;
            }
        }
    }

    public int menu() {
        int option = 0;
        view.showMessage(view.menu());
        return option = view.readInt("Elija una opción");
    }

    public int accountMenu() {
        int option = 0;
        view.showMessage(view.accountMenu());
        return option = view.readInt("Elija una opción");
    }


    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        presenter.run();
    }
}