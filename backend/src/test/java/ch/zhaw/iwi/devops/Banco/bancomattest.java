package ch.zhaw.iwi.devops.Banco;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class bancomattest {

    private bancomat bancomat;

    @BeforeEach

    public void setUp() {

        bancomat = new bancomat(); // Erstellt ein neues Bancomat-Objekt vor jedem Testfall

    }

    @Test

    public void testInitialBalance() {

        assertEquals(0, bancomat.getBalance()); // Überprüft, ob die anfängliche Kontobalance 0 ist
    }

    @Test

    public void testDeposit() {

        bancomat.deposit(100); // Führt eine Einzahlung von 100 durch

        assertEquals(100, bancomat.getBalance()); // Überprüft, ob die Kontobalance nach der Einzahlung 100 ist
    }

    @Test

    public void testWithdrawSufficientFunds() {

        bancomat.deposit(100); // Führt eine Einzahlung von 100 durch

        bancomat.withdraw(50); // Führt eine Abhebung von 50 durch

        assertEquals(50, bancomat.getBalance()); // Überprüft, ob die Kontobalance nach der Abhebung 50 ist
    }

    @Test

    public void testWithdrawInsufficientFunds() {

        bancomat.deposit(100); // Führt eine Einzahlung von 100 durch

        bancomat.withdraw(150); // Führt eine Abhebung von 150 durch (mehr als der Kontostand)

        assertEquals(100, bancomat.getBalance()); // Überprüft, ob die Kontobalance unverändert bleibt (keine Abhebung
                                                  // erfolgt)

    }

    @Test
    public void testWithdrawNegativeAmount() {
        bancomat.deposit(100); // Führt eine Einzahlung von 100 durch
        bancomat.withdraw(-50); // Versucht eine negative Betrag abzuheben
        assertEquals(100, bancomat.getBalance()); // Überprüft, ob die Kontobalance unverändert bleibt (keine Abhebung
                                                  // erfolgt)
    }
}