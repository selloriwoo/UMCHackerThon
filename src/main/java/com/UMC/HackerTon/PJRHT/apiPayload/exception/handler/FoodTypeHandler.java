package com.UMC.HackerTon.PJRHT.apiPayload.exception.handler;


import com.UMC.HackerTon.PJRHT.apiPayload.code.BaseErrorCode;
import com.UMC.HackerTon.PJRHT.apiPayload.exception.GeneralException;

public class FoodTypeHandler extends GeneralException {
    public FoodTypeHandler(BaseErrorCode errorCode) { super(errorCode);}
}
