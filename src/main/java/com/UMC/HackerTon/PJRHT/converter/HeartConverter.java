package com.UMC.HackerTon.PJRHT.converter;

import com.UMC.HackerTon.PJRHT.domain.Trainer;
import com.UMC.HackerTon.PJRHT.domain.User;
import com.UMC.HackerTon.PJRHT.domain.mapping.Heart;
import com.UMC.HackerTon.PJRHT.web.dto.HeartResponseDTO;

public class HeartConverter {

    public static Heart toHeart(User user, Trainer trainer) {
        return Heart.builder()
                .trainer(trainer)
                .user(user)
                .build();
    }

    public static HeartResponseDTO.AddHeartDTO toAddHeart(Heart heart){
        return HeartResponseDTO.AddHeartDTO.builder()
                .heartId(heart.getId())
                .createdAt(heart.getCreatedAt().toLocalDate())
                .build();
    }
}
