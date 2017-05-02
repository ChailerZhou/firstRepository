package maven.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.JedisCluster;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:redisCluster.xml"})
public class SpringRedisClusterTest {

    @Autowired
    private JedisCluster jedisClusterClient;

    @Test
    public void testSetString() {
        jedisClusterClient.set("cheng", "WWW_1");
    }

    @Test
    public void testGetString() {
        String c = jedisClusterClient.get("cheng");
        System.out.println(c);
    }
}
