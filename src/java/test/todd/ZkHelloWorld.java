package todd;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

public class ZkHelloWorld {
    public static void main(String[] args) throws Exception{
        String conn = "127.0.0.1:2181";
        ZooKeeper zk = new ZooKeeper(conn, 3000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println(event);
            }
        });
        zk.create("/zoo3", "abc".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        Thread.sleep(10*1000);
        zk.close();

    }

    @Test
    public void testGetData() throws Exception {
        String conn = "127.0.0.1:2181";
        ZooKeeper zk = new ZooKeeper(conn, 3000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println(event);
            }
        });
        zk.getData("/zoo0000000000", new Watcher() {

            @Override
            public void process(WatchedEvent event) {
                System.out.println("testGetData: " + event);
            }
        }, null);

        Thread.sleep(30*1000);
        zk.close();
    }

    @Test
    public void testSetData() throws Exception {
        String conn = "127.0.0.1:2181";
        ZooKeeper zk = new ZooKeeper(conn, 3000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                event.getState();
                event.getType();
                System.out.println("testSetData-Watcher:" + event);
            }
        });
       Stat stat =  zk.setData("/zoo0000000000", "def".getBytes(), -1);
       System.out.println("testSetData-Stat:" + stat);

        Thread.sleep(30 * 1000);
        zk.close();
    }
}
