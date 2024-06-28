package com.UMC.HackerTon.PJRHT.web.controller;

import com.UMC.HackerTon.PJRHT.apiPayload.ApiResponse;
import com.UMC.HackerTon.PJRHT.converter.HeartConverter;
import com.UMC.HackerTon.PJRHT.converter.QnaConverter;
import com.UMC.HackerTon.PJRHT.converter.TrainerConverter;
import com.UMC.HackerTon.PJRHT.converter.UserConverter;
import com.UMC.HackerTon.PJRHT.domain.Trainer;
import com.UMC.HackerTon.PJRHT.domain.User;
import com.UMC.HackerTon.PJRHT.domain.mapping.Heart;
import com.UMC.HackerTon.PJRHT.domain.mapping.Qna;
import com.UMC.HackerTon.PJRHT.repository.QnaRepository;
import com.UMC.HackerTon.PJRHT.service.HeartService.HeartCommandService;
import com.UMC.HackerTon.PJRHT.service.QnaService.QnaCommandService;
import com.UMC.HackerTon.PJRHT.service.TrainerService.TrainerQueryService;
import com.UMC.HackerTon.PJRHT.service.UserService.UserQueryService;
import com.UMC.HackerTon.PJRHT.web.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api")
public class UserRestController {

    private final TrainerQueryService trainerQueryService;
    private final HeartCommandService heartCommandService;
    private final QnaCommandService qnaCommandService;
    private final UserQueryService userQueryService;

    @GetMapping("/user/{userId}")
    public ApiResponse<UserResponseDTO.JoinResultDTO> getUser(@PathVariable(name = "userId") Long userId) {
        User user= userQueryService.getUser(userId);
        return ApiResponse.onSuccess(UserConverter.toResultUser(user));
    }
    @GetMapping("/trainers")
    public ApiResponse<TrainerResponseDTO.TrainerViewListDTO> getTrainerList(@RequestParam(name = "page") Integer page) {
        Page<Trainer> reviewPage = trainerQueryService.getTrainerList(page);
        return ApiResponse.onSuccess(TrainerConverter.trainerViewListDTO(reviewPage));
    }

    @GetMapping("/trainerProfile/{trainerId}")
    public ApiResponse<TrainerResponseDTO.TrainerViewDTO> getTrainer(@PathVariable(name = "trainerId") Long trainerId) {
        Trainer trainer = trainerQueryService.getTrainer(trainerId);
        return ApiResponse.onSuccess(TrainerConverter.trainerViewDTO(trainer));
    }

    @PostMapping("/favorites/{userId}/{trainerId}")
    public ApiResponse<HeartResponseDTO.AddHeartDTO> joinFavorite(@PathVariable(name = "userId") Long userId,
                                                          @PathVariable(name = "trainerId") Long trainerId){
        Heart heart =heartCommandService.AddHeart(userId, trainerId);

        return ApiResponse.onSuccess(HeartConverter.toAddHeart(heart));
    }

    @PostMapping("/user/qna/{userId}/{trainerId}")
    public ApiResponse<QnaResponseDTO.AddQnaDTO> joinQna(@RequestBody QnaRequestDTO.JoinDto request,
                                                         @PathVariable(name = "userId") Long userId,
                                                         @PathVariable(name = "trainerId") Long trainerId) {
        Qna qna = qnaCommandService.AddQna(userId, trainerId, request);
        return ApiResponse.onSuccess(QnaConverter.toAddQna(qna));
    }

    @PutMapping("/user/qna/{qnaId}")
    public ApiResponse<QnaResponseDTO.AddQnaDTO> AddAnswer (@RequestBody QnaRequestDTO.AddAnserDto request,
                                                            @PathVariable(name = "qnaId") Long qnaId) {

        Qna qna = qnaCommandService.AddAnswer(qnaId, request);
        return ApiResponse.onSuccess(QnaConverter.toAddQna(qna));
    }

    @GetMapping("/qnas/list/users/{userId}")
    public ApiResponse<QnaResponseDTO.ViewQnaListDTO> getUserQnaList (@RequestParam(name = "page") Integer page,
                                                                  @PathVariable(name = "userId") Long userId) {
        Page<Qna> qnaPage = qnaCommandService.getQnaList(page, userId);
        return ApiResponse.onSuccess(QnaConverter.QnaViewListDTO(qnaPage));
    }

    @GetMapping("/qnas/list/trainer/{trainerId}")
    public ApiResponse<QnaResponseDTO.ViewQnaListDTO> getTrainerQnaList (@RequestParam(name = "page") Integer page,
                                                                  @PathVariable(name = "trainerId") Long trainerId) {
        Page<Qna> qnaPage = qnaCommandService.getTrainerQnaList(page, trainerId);
        return ApiResponse.onSuccess(QnaConverter.QnaViewListDTO(qnaPage));
    }


}
