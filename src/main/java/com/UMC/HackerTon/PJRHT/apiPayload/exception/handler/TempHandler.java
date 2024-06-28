package com.UMC.HackerTon.PJRHT.apiPayload.exception.handler;

import com.UMC.HackerTon.PJRHT.apiPayload.code.BaseErrorCode;
import com.UMC.HackerTon.PJRHT.apiPayload.exception.GeneralException;
public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
