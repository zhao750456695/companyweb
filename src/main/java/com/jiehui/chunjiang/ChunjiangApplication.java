package com.jiehui.chunjiang;

import com.jiehui.chunjiang.common.utils.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(SpringUtil.class)
@SpringBootApplication
public class ChunjiangApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChunjiangApplication.class, args);
    }

}
