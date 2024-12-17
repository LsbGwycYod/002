package cn.edu.nbpt.lilingyi.blogmanage.pojo.enums;

public enum ErrorCode {
    SUCCESS(20000, "成功"),
    ERROR(50000, "失败"),
    LIST_EMPTY(50001, "列表长度为0"),
    FORBIDDEN(50003, "未成年人禁止访问"),
    PARAMS_ERROR(50004,"参数不合法"),
    NULL(50002, "内容为空"),
    UPDATE_ERROR(50006, "更新失败"),
    FILE_STORAGE_ERROR(50007,"文件操作失败"),
    FILE_NOT_FOUND(50008,"文件未找到");

    private Integer code;
    private String msg;

    ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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
