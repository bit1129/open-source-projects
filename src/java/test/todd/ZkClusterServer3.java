package todd;

import org.apache.zookeeper.server.quorum.QuorumPeerMain;

/**
 * Created by yuzhitao on 11/18/2014.
 */
public class ZkClusterServer3 {
    public static void main(String[] args) {
        args = new String[1];
        args[0] = ""; //第三个Server的配置文件
        QuorumPeerMain.main(args);
    }
}

