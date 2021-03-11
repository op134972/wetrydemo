package zk.zkClient;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.Watcher;

import java.util.List;

/**
 * @Author: tangwenchuan
 * @Date: 2020-09-09 15:13
 */
public class Crud {

    private ZkClient zkClient;

    public Crud(String path,int timeOut) {
        this.zkClient = new ZkClient(path, timeOut);
    }

    public void createPersistent(String path){
        zkClient.createPersistent(path);
    }

    public void createEphemeral(String path){
        zkClient.createEphemeral(path);
    }

    public void subscribe(String path){
        List<String> strings = zkClient.subscribeChildChanges(path, new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                System.out.println("子节点变化： parentPath:" + parentPath + ",currChilds:" + currentChilds);
            }
        });
        System.out.println("subscribeChildChanges return :" + strings);

        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println("数据变化：" + dataPath + ", data:" + data);
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println("数据删除：" + dataPath);
            }
        });

        zkClient.subscribeStateChanges(new IZkStateListener() {
            @Override
            public void handleStateChanged(Watcher.Event.KeeperState state) throws Exception {
                System.out.println("state changed" + state);
            }

            @Override
            public void handleNewSession() throws Exception {
                System.out.println("new session created");
            }

            @Override
            public void handleSessionEstablishmentError(Throwable error) throws Exception {
                System.out.println("error happened" + error);
            }
        });
    }

    public boolean exists(String path){
        return zkClient.exists(path);
    }

    public Object readData(String path){
        return zkClient.readData(path);
    }
}
