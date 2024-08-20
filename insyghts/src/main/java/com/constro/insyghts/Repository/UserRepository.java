package com.constro.insyghts.Repository;

import com.constro.insyghts.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User , Long> {
    Optional<User> findByUsername(String Username);

    Optional<User> findByEmail(String Email);

    @Query("SELECT u FROM User u WHERE u.deleted = false")
    List<User> findAllActiveUsers();

    @Query("SELECT u FROM User u WHERE u.id = :id AND u.deleted = false")
    Optional<User> findByIdAndNotDeleted(@Param("id") Long id);
}
