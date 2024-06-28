package com.UMC.HackerTon.PJRHT.service.QnaService;

import com.UMC.HackerTon.PJRHT.converter.HeartConverter;
import com.UMC.HackerTon.PJRHT.converter.QnaConverter;
import com.UMC.HackerTon.PJRHT.domain.Trainer;
import com.UMC.HackerTon.PJRHT.domain.User;
import com.UMC.HackerTon.PJRHT.domain.mapping.Heart;
import com.UMC.HackerTon.PJRHT.domain.mapping.Qna;
import com.UMC.HackerTon.PJRHT.repository.QnaRepository;
import com.UMC.HackerTon.PJRHT.repository.TrainerRepository;
import com.UMC.HackerTon.PJRHT.repository.UserRepository;
import com.UMC.HackerTon.PJRHT.web.dto.QnaRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QnaCommandServiceImpl implements QnaCommandService{
    private final TrainerRepository trainerRepository;
    private final UserRepository userRepository;
    private final QnaRepository qnaRepository;
    @Override
    @Transactional
    public Qna AddQna(Long userId, Long trainerId, QnaRequestDTO.JoinDto request) {
            User user = userRepository.findById(userId).get();
            Trainer trainer = trainerRepository.findById(trainerId).get();

            Qna qna = QnaConverter.toQna(user, trainer, request);
            return qnaRepository.save(qna);
    }
    @Override
    @Transactional
    public Qna AddAnswer(Long qnaId, QnaRequestDTO.AddAnserDto request) {
        Qna newQna = qnaRepository.findById(qnaId).get();
        newQna.setAnswer(request.getAnswer());
        return qnaRepository.save(newQna);
    }

    @Override
    public Page<Qna> getQnaList(Integer page, Long userId) {
        User user = userRepository.findById(userId).get();
        Page<Qna> qnaPage = qnaRepository.findAllByUser(user, PageRequest.of(page, 10));
        return qnaPage;
    }

    @Override
    public Page<Qna> getTrainerQnaList(Integer page, Long trainerId) {
        Trainer trainer = trainerRepository.findById(trainerId).get();
        Page<Qna> qnaPage = qnaRepository.findAllByTrainer(trainer, PageRequest.of(page, 10));
        return qnaPage;
    }
}
