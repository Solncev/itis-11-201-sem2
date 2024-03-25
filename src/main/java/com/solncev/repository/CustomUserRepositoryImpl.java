package com.solncev.repository;

import com.solncev.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.List;

public class CustomUserRepositoryImpl implements CustomUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAllByNameMatch(String name, double factor) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);

        Root<User> root = query.from(User.class);

//        Join<Class1, User> join1 = root.join(Class1.class);
//        query.select(join1);

        query.select(root);
        query.distinct(true);

        Predicate predicate;

        predicate = criteriaBuilder.isNotNull(root.get("name"));

        query.where(predicate);
        query.orderBy(criteriaBuilder.asc(root.get("name")));
        return entityManager.createQuery(query).getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
