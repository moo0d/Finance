package application;

import dao.Dao;
import entity.Account;
import entity.Category;
import entity.Transaction;

import java.time.LocalDateTime;

public class FinanceTest {

    public static void main(String[] args) {
        Dao dao = new Dao();

        Category food = new Category("Food");
        Category leisure = new Category("Leisure");
        Category school = new Category("School");
        Category gifts = new Category("Gifts");
        Category internalTransfer = new Category("Internal Transfer");
        Category pub = new Category("Pub");

        dao.saveCategory(food);
        dao.saveCategory(leisure);
        dao.saveCategory(school);
        dao.saveCategory(gifts);
        dao.saveCategory(internalTransfer);
        dao.saveCategory(pub);

        Account savingsAcc = new Account("Savings", 400);
        dao.saveAccount(savingsAcc);

        Account walletAcc = new Account("Wallet", 400);
        dao.saveAccount(walletAcc);

        Transaction gift = new Transaction(100, "Gift from aunt Mary", LocalDateTime.now(), null, savingsAcc, gifts);
        dao.saveTransaction(gift);
        dao.addBalance(savingsAcc.getAccountId(), 100);

        Transaction transfer = new Transaction(40, "Transfer to savings", LocalDateTime.now(), savingsAcc, walletAcc, internalTransfer);
        dao.saveTransaction(transfer);
        dao.subtractBalance(savingsAcc.getAccountId(), 40);
        dao.addBalance(walletAcc.getAccountId(), 40);

        Transaction pubBill = new Transaction(8.40, "Pub bill", LocalDateTime.now(), walletAcc, null, pub);
        dao.saveTransaction(pubBill);
        dao.subtractBalance(walletAcc.getAccountId(), 8.40);

        dao.close();
    }
}
