package com.jimo.tool.net;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * @author jimo
 * @date 19-8-16 下午3:41
 */
public class NetTool {

    public boolean empty(Object obj) {
        return obj == null || "".equals(obj);
    }

    private Logger logger = LoggerFactory.getLogger(NetTool.class);

    private int connectTimeout;
    private String userAgent;

    public NetTool(NetToolProperties properties) {
        connectTimeout = (int) properties.getConnectTimeout().getSeconds();
        userAgent = properties.getUserAgent();
    }

    /**
     * <p>
     * get请求
     * </p >
     *
     * @param url url
     * @return java.lang.String
     * @author jimo
     * @date 19-8-16 下午4:13
     */
    public String get(String url) {
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            if (!url.startsWith("http://")) {
                url = "http://" + url;
            }
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setConnectTimeout(connectTimeout);
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", userAgent);

            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            connection.getHeaderFields();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            logger.error("send get request fail！" + e);
            return e.toString();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                logger.error("close BufferedReader fail！" + e2);
            }
        }
        return result.toString();
    }
}
