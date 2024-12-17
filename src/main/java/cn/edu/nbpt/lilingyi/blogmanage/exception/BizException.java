package cn.edu.nbpt.lilingyi.blogmanage.exception;

import cn.edu.nbpt.lilingyi.blogmanage.pojo.enums.ErrorCode;

public class BizException extends RuntimeException{
    private Integer code;
    private String msg;

    public BizException(String message, Integer code, String msg) {
        super(message);
        this.code = code;
        this.msg = msg;
    }
    public BizException(String message) {
        super(message);
        this.code = ErrorCode.ERROR.getCode();
        this.msg = message;
    }
    public BizException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
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
}
