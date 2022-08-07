package com.intern.secondproject.dao.pojo;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class JsonResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> JsonResult<T> success(T data,String ...message){
        JsonResult<T> JsonResult=new JsonResult<>();
        JsonResult.setCode(HttpStatus.OK.value());
        if (message.length==1){
            JsonResult.setMsg(message[0]);
        }else {
            JsonResult.setMsg(HttpStatus.OK.getReasonPhrase());
        }

        JsonResult.setData(data);
        return JsonResult;
    }

    public static <T> JsonResult<T> fail(int code,String message){
        JsonResult<T> jsonResult=new JsonResult<>();
        jsonResult.setCode(code);
        jsonResult.setMsg(message);
        return jsonResult;
    }

}
