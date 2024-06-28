package com.UMC.HackerTon.PJRHT.service.HeartService;

import com.UMC.HackerTon.PJRHT.domain.mapping.Heart;

public interface HeartCommandService {

    Heart AddHeart(Long userId, Long trainerId);
}
