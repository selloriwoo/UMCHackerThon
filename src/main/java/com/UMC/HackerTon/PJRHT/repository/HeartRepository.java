package com.UMC.HackerTon.PJRHT.repository;

import com.UMC.HackerTon.PJRHT.domain.mapping.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartRepository extends JpaRepository<Heart, Long> {
}
