package com.bcb.conversaomoeda.infraestructure.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.bcb.conversaomoeda.domain.repository.CustomJpaRepository;

public class CustomJpaRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> 
	implements CustomJpaRepository<T, ID> {
	
	private EntityManager manager;
	
	public CustomJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		
		this.manager = entityManager;
	}

	@Override
	public Optional<T> buscarPrimeiro() {
		var jpql = "from " + getDomainClass().getName();
		T entity = manager.createQuery(jpql, getDomainClass())
				.setMaxResults(1).getSingleResult();
		return Optional.ofNullable(entity);
	}

	@Override
	public void desconectar(T t) {
		this.manager.detach(t);
	}

}
