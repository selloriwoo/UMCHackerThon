package com.UMC.HackerTon.PJRHT.service.TrainerService;

import com.UMC.HackerTon.PJRHT.domain.Trainer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TrainerQueryService {
    Page<Trainer> getTrainerList(Integer page);

    Trainer getTrainer(Long trainerId);
}
