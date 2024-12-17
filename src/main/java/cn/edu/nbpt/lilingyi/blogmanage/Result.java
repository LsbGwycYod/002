package cn.edu.nbpt.lilingyi.blogmanage;

import cn.edu.nbpt.lilingyi.blogmanage.pojo.enums.ErrorCode;

public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(T data) {
        this.code = ErrorCode.ERROR.getCode();
        this.msg = ErrorCode.ERROR.getMsg();
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public static <T> Result success(T data){
        return new Result(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMsg(), data);
    }
    public static <T> Result error(){
        return new Result(ErrorCode.ERROR.getCode(),ErrorCode.ERROR.getMsg(), null);
    }
    public static <T> Result error(ErrorCode errorCode){
        return new Result(errorCode.getCode(),errorCode.getMsg(),null);
    }
    public static <T> Result error(ErrorCode errorCode,T data){
        return new Result(errorCode.getCode(),errorCode.getMsg(),data);
    }
    public static <T> Result error(Integer code,String msg){
        return new Result(code,msg, null);
    }

    public static <T> Result error(String msg){
        return new Result(ErrorCode.ERROR.getCode(),msg, null);
    }
    public static <T> Result error(Integer code,String msg,T data){
        return new Result(code,msg,data);
    }
}
