package com.cfm.clientes.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cfm.clientes.jpa.entity.ClienteEntity;


public interface ClientesRepository extends JpaRepository<ClienteEntity, String> {
	List<ClienteEntity> findByStatus(Character status);
}
