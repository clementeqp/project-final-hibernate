package com.clemen.proyecto.dao;

import com.clemen.proyecto.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDAOImple implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAllActive(){
        //return entityManager.createQuery("SELECT u FROM User u WHERE u.active = true", User.class).getResultList();
       CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
       CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
       Root<User> root = criteria.from(User.class);
       Predicate isActive = criteriaBuilder.isTrue(root.get("active"));

       criteria.select(root).where(isActive);
       return entityManager.createQuery(criteria).getResultList();

       //criteria.select(root).where(criteriaBuilder.equal(root.get("active"), true));


    }

}
