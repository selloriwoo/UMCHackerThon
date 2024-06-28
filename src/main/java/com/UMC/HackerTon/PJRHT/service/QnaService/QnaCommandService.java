package com.UMC.HackerTon.PJRHT.service.QnaService;

import com.UMC.HackerTon.PJRHT.domain.Trainer;
import com.UMC.HackerTon.PJRHT.domain.mapping.Qna;
import com.UMC.HackerTon.PJRHT.web.dto.QnaRequestDTO;
import org.springframework.data.domain.Page;

public interface QnaCommandService {

    Qna AddQna(Long userId, Long trainerId, QnaRequestDTO.JoinDto request);
    public Qna AddAnswer(Long qnaId, QnaRequestDTO.AddAnserDto request);

    public Page<Qna> getQnaList(Integer page, Long userId);
    public Page<Qna> getTrainerQnaList(Integer page, Long trainerId);
}
