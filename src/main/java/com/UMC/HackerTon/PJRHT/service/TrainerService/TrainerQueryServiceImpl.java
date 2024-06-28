package com.UMC.HackerTon.PJRHT.service.TrainerService;

import com.UMC.HackerTon.PJRHT.domain.Trainer;
import com.UMC.HackerTon.PJRHT.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TrainerQueryServiceImpl implements TrainerQueryService {

    private final TrainerRepository trainerRepository;
    @Override
    public Page<Trainer> getTrainerList(Integer page) {

        Page<Trainer> trainerPage = trainerRepository.findAll(PageRequest.of(page, 10));
        //Page<Trainer> trainerRepo = trainerRepository.findAll();s
        return trainerPage;
    }

    @Override
    public Trainer getTrainer(Long trainerId) {

        return trainerRepository.findById(trainerId).get();
    }
}
