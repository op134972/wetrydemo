package zk.zkClient;

/**
 * @Author: tangwenchuan
 * @Date: 2020-09-09 19:48
 */
public class CrudTest {

    public static void main(String[] args) throws InterruptedException {
        Crud crud = new Crud(ZkUtils.path, ZkUtils.port);
        crud.subscribe("/root");
        crud.createEphemeral("/root");
        crud.createPersistent("/hello");

        Thread.sleep(1000);
    }
}
