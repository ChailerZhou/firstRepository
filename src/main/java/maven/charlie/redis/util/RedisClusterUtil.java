package maven.charlie.redis.util;

import java.util.LinkedHashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClusterUtil {
    private static JedisPoolConfig poolConfig = null;
    private static JedisCluster cluster = null;

    static {
        poolConfig = new JedisPoolConfig();
        // 最大连接数
        poolConfig.setMaxTotal(20);
        // 最大空闲数
        poolConfig.setMaxIdle(10);
        // 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：
        // Could not get a resource from the pool
        poolConfig.setMaxWaitMillis(15000);
        Set<HostAndPort> nodes = new LinkedHashSet<HostAndPort>();
        nodes.add(new HostAndPort("10.74.95.39", 6379));
        nodes.add(new HostAndPort("10.74.95.39", 6382));
        nodes.add(new HostAndPort("10.74.95.39", 6383));
        nodes.add(new HostAndPort("10.74.95.39", 6384));
        nodes.add(new HostAndPort("10.74.95.39", 6385));
        nodes.add(new HostAndPort("10.74.95.39", 6386));
        cluster = new JedisCluster(nodes, poolConfig);
    }

    public static JedisCluster getCluster() {
        return cluster;
    }
}
