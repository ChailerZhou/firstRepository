package maven.redis;

import java.io.IOException;

import maven.charlie.redis.util.RedisClusterUtil;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import redis.clients.jedis.JedisCluster;


public class RedisClusterTest {
    private static JedisCluster cluster = null;

    @BeforeClass
    public static void init() {
        cluster = RedisClusterUtil.getCluster();
    }

    @AfterClass
    public static void destroy() {
        try {
            cluster.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * public static void main(String[] args) { HashSet<HostAndPort> nodes = new HashSet<HostAndPort>(); nodes.add(new
     * HostAndPort("10.74.95.39", 6379)); nodes.add(new HostAndPort("10.74.95.39", 6382)); nodes.add(new HostAndPort("10.74.95.39", 6383));
     * nodes.add(new HostAndPort("10.74.95.39", 6384)); nodes.add(new HostAndPort("10.74.95.39", 6385)); nodes.add(new
     * HostAndPort("10.74.95.39", 6386));
     * 
     * JedisCluster cluster = new JedisCluster(nodes); cluster.set("jedisClusterKey", "Hello_world"); String str =
     * cluster.get("jedisClusterKey");
     * 
     * System.out.println("---:" + str); // 关闭连接 // cluster.quit(); }
     */

    @Test
    public void testSet() {
        cluster.set("age", "18");
        System.out.println(cluster.get("age"));
    }

}
