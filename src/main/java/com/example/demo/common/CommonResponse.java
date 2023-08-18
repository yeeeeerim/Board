package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private Integer status;
    private String message;
    private T data;


    @Builder
    public CommonResponse(CodeEnum codeEnum,T data){
        setData(data);
        setStatus(codeEnum.getCode());
        setMessage(codeEnum.getMessage());
    }


    public CommonResponse<?> data(T data){
        this.data = data;
        return this;
    }



    public CommonResponse(ErrorCode errorCode){
        setStatus(errorCode.getHttpStatus().value());
        setMessage(errorCode.getMessage());
    }

}