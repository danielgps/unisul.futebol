package br.unisul.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@SuppressWarnings("unchecked")
public class EntityManagerUtil {

	private EntityManagerUtil() {

	}

	/**
	 * Returns a single result using a named query, providing zero or more query
	 * parameters
	 * 
	 * @param em
	 *            the entity manager
	 * @param hql
	 *            the query
	 * @param params
	 *            the query parameters
	 * @return the result or NULL if the query has no results
	 */
	public static Object oneByQuery(EntityManager em, String hql, Object... params) {

		Query query = em.createQuery(hql);

		if (params != null) {
			for (int i = 1; i <= params.length; i++) {
				query.setParameter(i, params[i - 1]);
			}
		}

		return getOneSingleResult(query);
	}

	/**
	 * Returns a list of results using a named query, providing zero or more
	 * query parameters
	 * 
	 * @param em
	 *            the entity manager
	 * @param hql
	 *            the query
	 * @param params
	 *            the query parameters
	 * @return a list of results
	 */
	public static List<? extends Object> listByQuery(EntityManager em, String hql, Object... params) {

		Query query = em.createQuery(hql);

		if (params != null) {
			for (int i = 1; i <= params.length; i++) {
				query.setParameter(i, params[i - 1]);
			}
		}

		return query.getResultList();
	}

	/**
	 * Return the first result of an already built query
	 * 
	 * @param query
	 *            the query
	 * @return the result or NULL if the query has no results
	 */
	public static Object getOneSingleResult(Query query) {

		query.setMaxResults(1);

		List<Object> result = query.getResultList();

		return result.isEmpty() ? null : result.get(0);
	}
}
