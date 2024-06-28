package com.UMC.HackerTon.PJRHT.repository;

import com.UMC.HackerTon.PJRHT.domain.Trainer;
import com.UMC.HackerTon.PJRHT.domain.User;
import com.UMC.HackerTon.PJRHT.domain.mapping.Qna;
import com.UMC.HackerTon.PJRHT.domain.mapping.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QnaRepository extends JpaRepository<Qna, Long> {
    Page<Qna> findAllByUser(User user, PageRequest pageRequest);
    Page<Qna> findAllByTrainer(Trainer trainer, PageRequest pageRequest);
}
