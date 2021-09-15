/**
 * projectName: chunjiang
 * fileName: MvcConfig.java
 * packageName: com.jiehui.chunjiang.config
 * date: 2021-04-07 21:53
 * copyright(c) 2017-2020 xxx公司
 */
package com.jiehui.chunjiang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        if(!registry.hasMappingForPattern("/static/**")){
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        }
        super.addResourceHandlers(registry);
    }

}
