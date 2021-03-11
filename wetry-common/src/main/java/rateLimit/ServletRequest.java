package rateLimit;

public class ServletRequest {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ServletRequest{" +
                "msg='" + msg + '\'' +
                '}';
    }

    public ServletRequest(String msg) {
        this.msg = msg;
    }
}
