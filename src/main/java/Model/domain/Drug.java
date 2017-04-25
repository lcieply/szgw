package Model.domain;

import org.hibernate.PropertyValueException;

import javax.persistence.*;
import java.util.List;

@Entity
public class Drug {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String application;
    @Column(nullable = false)
    private long number;
    @Column(nullable = false)
    private boolean need;

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", application='" + application + '\'' +
                ", number=" + number +
                ", need=" + need +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public boolean getNeed() {
        return need;
    }

    public void setNeed(boolean need) {
        this.need = need;
    }

    public Drug() {

    }

    public Drug(String name, String type, String application, long number, boolean need) {
        this.name = name;
        this.type = type;
        this.application = application;
        this.number = number;
        this.need = need;
    }

    public static boolean createDrug(String name, String type, String application, long number, boolean need) {
        Drug drug = new Drug(name, type, application, number, need);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        boolean res = true;

        try {
            entityManager.persist(drug);
            entityManager.getTransaction().commit();
        }
        catch (PersistenceException e) {
            System.out.print("Taki lek już istnieje.");
            entityManager.getTransaction().rollback();
            res = false;
        }
        catch (PropertyValueException e) {
            System.out.print("Niekompletne dane.");
            entityManager.getTransaction().rollback();
            res = false;
        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return res;
    }

    public static List<Drug> getAllDrugs() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            return entityManager.createQuery("SELECT d FROM Drug d", Drug.class).getResultList();
        }
        catch (NoResultException e) {
            System.out.print("Niczego nie znaleziono.");
            return null;
        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static List<String> getAllDrugsNames() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            return entityManager.createQuery("SELECT d.name FROM Drug d", String.class).getResultList();
        }
        catch (NoResultException e) {
            System.out.print("Niczego nie znaleziono.");
            return null;
        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static Drug getDrugById(long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            return entityManager.createQuery("SELECT d FROM Drug d WHERE d.id =:SEARCHED", Drug.class).setParameter("SEARCHED", id).getSingleResult();
        }
        catch (NoResultException e) {
            System.out.print("Niczego nie znaleziono.");
            return null;
        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static Drug getDrugByName(String name) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            return entityManager.createQuery("SELECT d FROM Drug d WHERE d.name =:SEARCHED", Drug.class).setParameter("SEARCHED", name).getSingleResult();
        }
        catch (NoResultException e) {
            System.out.print("Niczego nie znaleziono.");
            return null;
        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static List<Drug> getDrugsByType(String type) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            return entityManager.createQuery("SELECT d FROM Drug d WHERE d.type =:SEARCHED", Drug.class).setParameter("SEARCHED", type).getResultList();
        }
        catch (NoResultException e) {
            System.out.print("Niczego nie znaleziono.");
            return null;
        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static boolean updateType(Drug drug, String type) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            drug.setType(type);
            entityManager.merge(drug);
        }
        catch (NullPointerException e) {
            System.out.print("Próba zmiany typu nieistniejącego leku.");
            return false;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    public static boolean updateApplication(Drug drug, String application) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            drug.setApplication(application);
            entityManager.merge(drug);
        }
        catch (NullPointerException e) {
            System.out.print("Próba zmiany zastosowania nieistniejącego leku.");
            return false;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    public static boolean updateNumber(Drug drug, long number) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            drug.setNumber(number);
            entityManager.merge(drug);
        }
        catch (NullPointerException e) {
            System.out.print("Próba zmiany liczby sztuk nieistniejącego leku.");
            return false;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    public static boolean updateNeed(Drug drug, boolean need) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            drug.setNeed(need);
            entityManager.merge(drug);
        }
        catch (NullPointerException e) {
            System.out.print("Próba zmiany potrzeby zamówienia nieistniejącego leku.");
            return false;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    public static boolean removeDrug(Drug drug) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        boolean res = true;

        try {
            if (entityManager.contains(drug))
                entityManager.remove(drug);
            else
                entityManager.remove(entityManager.merge(drug));
            entityManager.getTransaction().commit();
        }
        catch (PersistenceException e) {
            System.out.print("Próba usunięcia niestniejącego leku.");
            res = false;
        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return res;
    }
}
