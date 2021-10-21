package com.vehicleManagement.vehicleInfo.Repository;

import com.vehicleManagement.vehicleInfo.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findById(Integer Id);

    Optional<User> findByName(String name);

    Page<User> searchAllByNameLike(String s, Pageable paging);
}
