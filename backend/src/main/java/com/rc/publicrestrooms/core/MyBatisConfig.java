package com.rc.publicrestrooms.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.rc.publicrestrooms.repository")
public class MyBatisConfig {
}
