package com.wework.platformservice.result;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回的Json数据封装
 */
@Data
@NoArgsConstructor
public class Result{
    private Integer code;
    private String msg;
    private Map<String, Object> data = new HashMap<String, Object>();

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static Result success() {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("处理成功");
        return result;
    }

    public static Result notfound() {
        Result result = new Result();
        result.setCode(404);
        result.setMsg("未查询到相关信息");
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setCode(500);
        result.setMsg(error().msg);
        return result;
    }

    public Result add(String key,Object value){
        this.data.put(key,value);
        return this;
    }

}
