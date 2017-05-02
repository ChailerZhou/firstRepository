package maven.activemq;

public class ActiveMqUtil {
    private static String borkerURL = "tcp://10.74.95.39:61616";

    public static String getBrokerURL() {
        return borkerURL;
    }
}
