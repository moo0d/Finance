package application;

import dao.Dao;
import entity.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class FinanceTest2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the transaction id: ");
        Long transactionId = scanner.nextLong();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("finance");
        EntityManager em = emf.createEntityManager();

        try {
            Transaction transaction = em.find(Transaction.class, transactionId);
            if (transaction != null) {
                System.out.println("Transaction ID: " + transaction.getTransactionId());
                System.out.println("Amount: " + transaction.getAmount());
                System.out.println("Description: " + transaction.getDescription());
                System.out.println("Timestamp: " + transaction.getTimestamp());
                System.out.println("Category: " + transaction.getCategory().getCategoryDescription());
                if (transaction.getSourceAccount() != null) {
                    System.out.println("Source account: " + transaction.getSourceAccount().getAccountName());
                }
                else {
                    System.out.println("Source account: null");
                }
                if (transaction.getDestinationAccount() != null) {
                    System.out.println("Destination account: " + transaction.getDestinationAccount().getAccountName());
                }
                else {
                    System.out.println("Destination account: null");
                }

            } else {
                System.out.println("Transaction not found.");
            }
        } finally {
            em.close();
            emf.close();
        }

    }
}
