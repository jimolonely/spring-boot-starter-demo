package com.jimo.tool.net;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * 配置信息
 *
 * @author jimo
 * @date 19-8-16 下午4:20
 */
@ConfigurationProperties(prefix = "jimo.util.net")
public class NetToolProperties {

    /**
     * 连接超时时间,默认5s
     */
    private Duration connectTimeout = Duration.ofSeconds(5);

    private String userAgent = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)";

    public Duration getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Duration connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
