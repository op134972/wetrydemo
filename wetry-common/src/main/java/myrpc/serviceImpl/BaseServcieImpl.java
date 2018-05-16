package myrpc.serviceImpl;

public class BaseServcieImpl implements RpcService {

    @Override
    public String getService() {
        return "service called";
    }
}
