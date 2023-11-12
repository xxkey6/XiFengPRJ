package com.xifeng.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private boolean success;
    private Integer code;
    private Object data;
    private String msg;


    public static Result success(Object data){
        return new Result(true, 20000, data, "成功");
    }

    public static Result fail(){
        return new Result(false, 20001, null, "失败");
    }

}
