package io.cheonkyu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "io.cheonkyu.services", "io.cheonkyu.aop" })
public class ProjectConfig {

}
