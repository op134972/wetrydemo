package zk;

import org.apache.zookeeper.*;

import java.util.List;

/**
 * @Author: tangwenchuan
 * @Date: 2020-09-03 20:08
 */
public class ZkTest {


    public static void main(String[] args) throws Exception {
        //1. 创建watcher
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent);
            }
        };

        //2. 创建连接
        ZooKeeper zk = new ZooKeeper("127.0.0.1", 3000, watcher);

        List<String> children = zk.getChildren("/", false);
        System.out.println(children.toString());

        //3. 创建节点
        /**
         *     PERSISTENT(0, false, false), 持久
         *     PERSISTENT_SEQUENTIAL(2, false, true), 持久+自增
         *     EPHEMERAL(1, true, false), 临时
         *     EPHEMERAL_SEQUENTIAL(3, true, true); 临时+自增
         */
        zk.create("/node1", "321".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);//持久节点，自增
        System.out.println(zk.getChildren("/", false).toString());


        zk.create("/node1", "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);//临时节点，自增
        System.out.println("临时节点创建后");
        System.out.println(zk.getChildren("/", false).toString());

        ZooKeeper zk2 = new ZooKeeper("127.0.0.1", 3000, watcher);
        System.out.println("另外的连接是否可见：");
        System.out.println(zk2.getChildren("/", false).toString());


        zk.close();
        System.out.println("重新连接后");
        zk = new ZooKeeper("127.0.0.1", 3000, watcher);
        System.out.println(zk.getChildren("/", false).toString());

        System.out.println(zk.exists("/node1", false));

        //4. 更新值
        zk.setData("/node1", "123".getBytes(), -1);

        System.out.println(zk.exists("/node1", false));

        //5. 获取值
        System.out.println(new String(zk.getData("/node1", false, null)));

        //6. 获取子节点
        System.out.println(zk.getChildren("/", false).toString());

        //7. 删除节点
        List<String> nodes = zk.getChildren("/", false);
        for (String node : nodes) {
            if ("zookeeper".equals(node)) {
                continue;
            }
            zk.delete("/"+node, -1);
        }
        System.out.println(zk.getChildren("/", false).toString());

        //8. 关闭连接
        zk.close();

    }
}
