package com.UMC.HackerTon.PJRHT.converter;

import com.UMC.HackerTon.PJRHT.domain.Trainer;
import com.UMC.HackerTon.PJRHT.domain.User;
import com.UMC.HackerTon.PJRHT.domain.mapping.Heart;
import com.UMC.HackerTon.PJRHT.domain.mapping.Qna;
import com.UMC.HackerTon.PJRHT.web.dto.QnaRequestDTO;
import com.UMC.HackerTon.PJRHT.web.dto.QnaResponseDTO;
import com.UMC.HackerTon.PJRHT.web.dto.TrainerResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class QnaConverter {
    public static Qna toQna(User user, Trainer trainer, QnaRequestDTO.JoinDto request) {
        return Qna.builder()
                .trainer(trainer)
                .user(user)
                .question(request.getQuestion())
                .build();
    }
    public static QnaResponseDTO.AddQnaDTO toAddQna(Qna qna) {
        return QnaResponseDTO.AddQnaDTO.builder()
                .qnaId(qna.getId())
                .createdAt(LocalDate.now())
                .build();
    }

    public static QnaResponseDTO.ViewQnaDTO QnaViewDTO(Qna qna){
        return QnaResponseDTO.ViewQnaDTO.builder()
                .qnaId(qna.getId())
                .trainerId(qna.getTrainer().getId())
                .userId(qna.getUser().getId())
                .answer(qna.getAnswer())
                .question(qna.getQuestion())
                .updateAt(qna.getUpdatedAt())
                .build();
    }

    public static QnaResponseDTO.ViewQnaListDTO QnaViewListDTO(Page<Qna> qnaList){
        List<QnaResponseDTO.ViewQnaDTO> qnaPreViewDTOList = qnaList.stream()
                .map(QnaConverter::QnaViewDTO).collect(Collectors.toList());

        return QnaResponseDTO.ViewQnaListDTO.builder()
                .isLast(qnaList.isLast())
                .isFirst(qnaList.isFirst())
                .totalPage(qnaList.getTotalPages())
                .totalElements(qnaList.getTotalElements())
                .listSize(qnaPreViewDTOList.size())
                .viewQnaDTOList(qnaPreViewDTOList)
                .build();
    }

}
