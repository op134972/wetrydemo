package myrpc;

import java.util.List;

public class InvokeMessage {
    String clazz;
    String method;
    String protocol;
    List<String> params;

    public InvokeMessage() {
    }

    public InvokeMessage(String clazz, String method, String protocol, List<String> params) {
        this.clazz = clazz;
        this.method = method;
        this.protocol = protocol;
        this.params = params;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String message) {
        this.method = message;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }
}
