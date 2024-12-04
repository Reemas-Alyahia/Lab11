package com.example.lab11.Repository;

import com.example.lab11.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {






    @Query("select u from User u where u.email=?1")
    User getEmail(String email);

    @Query("select u from User u where u.userId=?1")
    User getUserByUserId(Integer id);

/// /Login
    @Query("select  u from User u where  u.username=?1 and u.password=?2")
    User login (String username,String passwords);

    ///
    @Query("select u from User u where u.registrationDate = ?1")
    List<User> findByRegistrationDate(LocalDate registrationDate);
}
