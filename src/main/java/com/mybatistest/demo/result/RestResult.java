package com.mybatistest.demo.result;

import com.mybatistest.demo.constant.ResponseCode;
import java.io.Serializable;


/**
 * @desc: API 返回结果
 * @author: liuhongdi
 * @date: 2020-07-01 11:53
 * return :
 * 0:success
 * not 0: failed
 */
public class RestResult implements Serializable {

    //uuid,用作唯一标识符，供序列化和反序列化时检测是否一致
    private static final long serialVersionUID = 7498483649536881777L;
    //标识代码，0表示成功，非0表示出错
    private Integer code;
    //提示信息，通常供报错时使用
    private String msg;
    //正常返回时返回的数据
    private Object data;

    public RestResult(Integer status, String msg, Object data) {
        this.code = status;
        this.msg = msg;
        this.data = data;
    }

    //返回成功数据
    public static RestResult success(Object data) {
        return new RestResult(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), data);
    }

    public static RestResult success(Integer code,String msg) {
        return new RestResult(code, msg, null);
    }

    //返回出错数据
    public static RestResult error(ResponseCode code) {
        return new RestResult(code.getCode(), code.getMsg(), null);
    }
    public static RestResult error(Integer code,String msg) {
        return new RestResult(code, msg, null);
    }

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

}
