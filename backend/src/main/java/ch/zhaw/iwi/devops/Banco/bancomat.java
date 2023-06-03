package ch.zhaw.iwi.devops.Banco;

public class bancomat {

    private int balance; // Variable zur Speicherung der Kontobalance

    public bancomat() {

        balance = 0; // Setzt die Kontobalance beim Erstellen eines Bancomat-Objekts auf 0

    }

    public int getBalance() {

        return balance; // Gibt die aktuelle Kontobalance zurück

    }

    public void deposit(int amount) {

        if (amount > 0) {

            balance += amount; // Führt eine Einzahlung durch, indem der Betrag zur Kontobalance hinzugefügt
                               // wird

        }

    }

    public void withdraw(int amount) {

        if (amount > 0 && amount <= balance) {

            balance -= amount; // Führt eine Abhebung durch, indem der Betrag von der Kontobalance abgezogen
                               // wird

        } else if (amount <= 0) {

            throw new IllegalArgumentException("not Null");

        }

    }

}