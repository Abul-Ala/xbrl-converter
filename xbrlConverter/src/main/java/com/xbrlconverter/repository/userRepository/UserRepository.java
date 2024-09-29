package com.xbrlconverter.repository.userRepository;


import com.xbrlconverter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

   @Query(value = "select * from user where email = :emailId", nativeQuery = true)
   User findByEmail(@Param("emailId") String emailId);
}
