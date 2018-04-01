package demo.sso.reg;


public class RegResult {

    private boolean success;
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public RegResult(){}

    public RegResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }
}

