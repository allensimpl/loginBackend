package com.allen.login.repository;

import com.allen.login.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select * from user_tbl ut where ut.name = :name",nativeQuery = true)
    User findByName(String name);
}
