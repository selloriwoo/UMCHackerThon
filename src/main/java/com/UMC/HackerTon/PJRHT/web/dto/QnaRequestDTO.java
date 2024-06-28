package com.UMC.HackerTon.PJRHT.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public class QnaRequestDTO {

    @Getter
    public static class JoinDto {

        String question;
    }

    @Getter
    public static class AddAnserDto {
        String answer;
    }
}
