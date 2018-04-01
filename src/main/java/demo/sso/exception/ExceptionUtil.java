package demo.sso.exception;

import demo.sso.enums.ExceptionEnum;

public class ExceptionUtil extends RuntimeException {

    private Integer code;
    private String msg;

    public ExceptionUtil(Integer code ,String msg){
        super(msg);
        this.code = code;
        this.msg = msg;

    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ExceptionUtil(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();

    }
}
