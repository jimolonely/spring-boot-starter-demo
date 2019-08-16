package com.jimo.tool;

import com.jimo.tool.net.NetTool;
import com.jimo.tool.net.NetToolProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jimo
 * @date 19-8-16 下午3:37
 */
@Configuration
@EnableConfigurationProperties({NetToolProperties.class})
public class ToolConfiguration {

    private final NetToolProperties netToolProperties;

    public ToolConfiguration(NetToolProperties netToolProperties) {
        this.netToolProperties = netToolProperties;
    }

    @Bean
    public NetTool netTool() {
        return new NetTool(netToolProperties);
    }

}
