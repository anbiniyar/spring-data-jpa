/*
 * Copyright 2008-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.jpa.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * JPA specific extension of {@link org.springframework.data.repository.Repository}.
 * 
 * @author Oliver Gierke
 */
public interface JpaRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.repository.Repository#findAll()
	 */
	List<T> findAll();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.PagingAndSortingRepository#findAll
	 * (org.springframework.data.domain.Sort)
	 */
	List<T> findAll(Sort sort);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.Repository#save(java.lang.Iterable)
	 */
	List<T> save(Iterable<? extends T> entities);

	/**
	 * Flushes all pending changes to the database.
	 */
	void flush();

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @param entity
	 * @return the saved entity
	 */
	T saveAndFlush(T entity);

	/**
	 * Deletes the given entities in a batch which means it will create a single {@link Query}. Assume that we will clear
	 * the {@link EntityManager} after the call.
	 * 
	 * @param entities
	 */
	void deleteInBatch(Iterable<T> entities);

	/**
	 * Deletes all entites in a batch call.
	 */
	void deleteAllInBatch();
}
