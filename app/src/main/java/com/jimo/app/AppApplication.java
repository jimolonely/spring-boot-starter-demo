package com.jimo.app;

import com.jimo.tool.net.NetTool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimo
 * @date 19-8-16 下午3:19
 */
@SpringBootApplication
@RestController
public class AppApplication {

    private final NetTool tool;

    public AppApplication(NetTool tool) {
        this.tool = tool;
    }

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @GetMapping("/get/{url}")
    public String get(@PathVariable String url) {
        return tool.get(url);
    }

}
