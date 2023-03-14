package view;

import java.util.Scanner;

public class View {
    private Scanner console;

    public View() {
        console = new Scanner(System.in);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public int readInt(String message) {
        this.showMessage(message);
        return console.nextInt();
    }

    public String readString(String message) {
        this.showMessage(message);
        return console.next();
    }

    public float readFloat(String message) {
        this.showMessage(message);
        return console.nextFloat();
    }

    public double readDouble(String message) {
        this.showMessage(message);
        return console.nextDouble();
    }

    public String menu() {
        return "1. Realizar operaciones con su cuenta\n2. Salir\n";
    }

    public String accountMenu() {
        return "Elija una opción\n1. Ingresar monto  \n2. Sacar dinero de la cuenta\n3. Saber interés en la cuenta\n" +
                "4. Conocer extracto mensual\n5. Transferir a otra cuenta\n6. Atrás";
    }
}