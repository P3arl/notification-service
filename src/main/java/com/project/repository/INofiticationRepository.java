package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Notification;

@Repository
public interface INofiticationRepository extends JpaRepository<Notification, Short> {

	List<Notification> findAllByUserId(Short userId);

}