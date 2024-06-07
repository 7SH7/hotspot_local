package com.example.hotspot_local.repository;

import com.example.hotspot_local.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface OAuthRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);

	UserEntity findByUsername(String name);
}