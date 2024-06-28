package com.UMC.HackerTon.PJRHT.converter;

import com.UMC.HackerTon.PJRHT.domain.Trainer;
import com.UMC.HackerTon.PJRHT.domain.User;
import com.UMC.HackerTon.PJRHT.domain.mapping.Heart;
import com.UMC.HackerTon.PJRHT.web.dto.UserResponseDTO;

public class UserConverter {

    public static UserResponseDTO.JoinResultDTO toResultUser(User user) {
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .name(user.getName())
                .money(user.getMoney())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
