package com.UMC.HackerTon.PJRHT.repository;

import com.UMC.HackerTon.PJRHT.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
