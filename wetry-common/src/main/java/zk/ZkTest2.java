package zk;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

import java.util.List;

/**
 * @Author: tangwenchuan
 * @Date: 2020-09-04 17:21
 * ZkClient
 */
public class ZkTest2 {

    public static void main(String[] args) {
        // 1. 建立连接
        ZkClient zkClient = new ZkClient("127.0.0.1", 3000);
        List<String> children = zkClient.getChildren("/");
        System.out.println(children.toString());

        // 2. 持久化模式建立
        zkClient.create("/testNode1", "testNodeData-123", CreateMode.PERSISTENT);
        System.out.println(zkClient.getChildren("/"));


        zkClient.subscribeChildChanges("", new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {

            }
        });
        zkClient.exists("");


        //
        zkClient.close();

    }
}
