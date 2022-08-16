package com.hcl.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcl.entity.User;

public interface UserDao extends JpaRepository<User, Long>{
	
	@Query(value="SELECT * FROM user a WHERE a.id = :id",nativeQuery = true)
    List<User> findAllByID(@Param("id") Long id);

}
