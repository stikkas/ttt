package com.gieman.tttracker.dao;

import com.gieman.tttracker.domain.EntityItem;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Благодатских С.
 * @param <T>
 * @param <ID>
 */
public class GenericDaoImpl<T extends EntityItem, ID extends Serializable> implements GenericDao<T, ID> {

	final protected Logger logger = LoggerFactory.getLogger(getClass());
	@PersistenceContext(unitName = "TTT_PU")
	protected EntityManager em;

	private Class<T> type;

	public GenericDaoImpl(Class<T> type) {
		this.type = type;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public T find(ID id) {
		return em.find(type, id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void persist(T obj) {
		em.persist(obj);
		logger.info("The " + getClass().getName() + " record with ID = "
				+ obj.getId() + " has been inserted");
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public T merge(T obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(T obj) {
		em.remove(em.merge(obj));
		logger.warn("The " + getClass().getName() + " record with ID = "
				+ obj.getId() + " has been deleted");
	}

}
