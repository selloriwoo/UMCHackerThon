package com.UMC.HackerTon.PJRHT.converter;

import com.UMC.HackerTon.PJRHT.domain.Trainer;
import com.UMC.HackerTon.PJRHT.web.dto.TrainerResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TrainerConverter {


    public static TrainerResponseDTO.TrainerViewDTO trainerViewDTO(Trainer trainer){
        return TrainerResponseDTO.TrainerViewDTO.builder()
                .trainerId(trainer.getId())
                .name(trainer.getName())
                .money(trainer.getMoney())
                .createdAt(trainer.getCreatedAt().toLocalDate())
                .pTOneCost(trainer.getPTOneCost())
                .build();
    }
    public static TrainerResponseDTO.TrainerViewListDTO trainerViewListDTO(Page<Trainer> trainerList){
        List<TrainerResponseDTO.TrainerViewDTO> reviewPreViewDTOList = trainerList.stream()
                .map(TrainerConverter::trainerViewDTO).collect(Collectors.toList());

        return TrainerResponseDTO.TrainerViewListDTO.builder()
                .isLast(trainerList.isLast())
                .isFirst(trainerList.isFirst())
                .totalPage(trainerList.getTotalPages())
                .totalElements(trainerList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .trainerList(reviewPreViewDTOList)
                .build();
    }
}
