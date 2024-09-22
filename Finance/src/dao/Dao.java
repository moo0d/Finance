package dao;

import entity.Account;
import entity.Category;
import entity.Transaction;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public Dao() {
        emf = Persistence.createEntityManagerFactory("finance");
        em = emf.createEntityManager();
    }

    public void saveAccount(Account account) {
        em.getTransaction().begin();
        if (account.getAccountId() == null) {
            em.persist(account);
        } else {
            em.merge(account);
        }
        em.getTransaction().commit();
    }

    public void saveTransaction(Transaction transaction) {
        em.getTransaction().begin();
        em.persist(transaction);
        em.getTransaction().commit();
    }

    public void saveCategory(Category category) {
        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
    }
    public Account findAccountById(Long id) {
        return em.find(Account.class, id);
    }

    public void addBalance(Long accountId, double amount) {
        em.getTransaction().begin();
        Account account = em.find(Account.class, accountId);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
        }
        em.getTransaction().commit();
    }

    public void subtractBalance(Long accountId, double amount) {
        em.getTransaction().begin();
        Account account = em.find(Account.class, accountId);
        if (account != null) {
            account.setBalance(account.getBalance() - amount);
        }
        em.getTransaction().commit();
    }



        public void close() {
        em.close();
        emf.close();
    }
}

