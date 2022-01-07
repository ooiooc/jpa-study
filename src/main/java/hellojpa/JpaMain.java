package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        // 트랜잭션 호출
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Member member = new Member();

            member.setId(1L);
            member.setName("HelloA");

            em.persist(member); // jpa 저장

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close(); // 전체 애플리케이션이 종료되면 EntityManaerFactory 닫기
    }

}
