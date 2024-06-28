package com.UMC.HackerTon.PJRHT.service.HeartService;

import com.UMC.HackerTon.PJRHT.converter.HeartConverter;
import com.UMC.HackerTon.PJRHT.domain.Trainer;
import com.UMC.HackerTon.PJRHT.domain.User;
import com.UMC.HackerTon.PJRHT.domain.mapping.Heart;
import com.UMC.HackerTon.PJRHT.repository.HeartRepository;
import com.UMC.HackerTon.PJRHT.repository.TrainerRepository;
import com.UMC.HackerTon.PJRHT.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HeartCommandServiceImpl implements HeartCommandService{

    private final TrainerRepository trainerRepository;
    private final UserRepository userRepository;
    private final HeartRepository heartRepository;


    @Override
    @Transactional
    public Heart AddHeart(Long userId, Long trainerId) {
        User user = userRepository.findById(userId).get();
        Trainer trainer = trainerRepository.findById(trainerId).get();

        Heart heart = HeartConverter.toHeart(user,trainer);
        return heartRepository.save(heart);
    }
}
