//package com.example.jmshw.HELLO.P;
//
//import com.example.jmshw.HELLO.Info;
//import com.example.jmshw.HELLO.Patient;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import java.util.List;
//
//public class InfoServiceEm implements InfoService {
//    @PersistenceContext
//    private EntityManager em;
//
////    @Override
////    @Transactional
////    public Info save(Info i) {
////        em.persist(i);
////        return i; }
//
//    @Override
//    public List<Info> findInfoByName(String name) {
//        TypedQuery<Info> query = (TypedQuery<Info>) em.createQuery("select i.condition from Info i where i.name =:name", Info.class);
//        query.setParameter("name",name);
//        return query.getResultList();
//    }
//}

