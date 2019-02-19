package com.yash.onlinetrainingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.onlinetrainingsystem.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("from User u where u.userName=:username")
	User findUserByUsername(String username);

}
