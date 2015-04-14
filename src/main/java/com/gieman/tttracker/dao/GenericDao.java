package com.gieman.tttracker.dao;

/**
 *
 * @author Благодатских С.
 * @param <T>
 * @param <ID>
 */
public interface GenericDao<T, ID> {

	T find(ID id);

	void persist(T obj);

	T merge(T obj);

	void remove(T obj);

}
