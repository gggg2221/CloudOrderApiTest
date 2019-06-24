package org.zt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.zt.service.OrderService;

@SpringBootApplication
@MapperScan("org.zt.dao")
@ComponentScan(basePackages = {"org.zt.*"})
public class ApplicationTest {

        public static void main(String[] args) {
            // 程序启动入口
            // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
            SpringApplication.run(ApplicationTest.class,args);
        }
    }
