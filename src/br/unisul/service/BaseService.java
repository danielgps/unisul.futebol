package br.unisul.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import br.unisul.entity.BaseEntity;
import br.unisul.util.EntityManagerUtil;
import br.unisul.util.PersistenceManager;

public class BaseService {

	@PersistenceContext
	private EntityManagerFactory emf;

	public BaseService() {

		this.emf = PersistenceManager.getInstance().getEntityManagerFactory();
	}

	protected EntityManager getEntityManager() {
		
		return emf.createEntityManager();
	}

	protected void update(BaseEntity entity) {

		EntityManager em = getEntityManager();

		em.getTransaction().begin();

		em.merge(entity);

		em.getTransaction().commit();
	}

	protected void delete(Long id, Class<? extends BaseEntity> klass) {

		EntityManager em = getEntityManager();

		BaseEntity entity = em.find(klass, id);

		em.getTransaction().begin();

		em.remove(entity);

		em.getTransaction().commit();

	}

	protected void save(BaseEntity entity) {

		EntityManager em = getEntityManager();

		em.getTransaction().begin();

		em.persist(entity);

		em.getTransaction().commit();
	}

	protected Object oneByQuery(String hql, Object... params) {

		return EntityManagerUtil.oneByQuery(getEntityManager(), hql, params);
	}

	protected List<? extends Object> listByQuery(String hql, Object... params) {

		return EntityManagerUtil.listByQuery(getEntityManager(), hql, params);
	}
}
