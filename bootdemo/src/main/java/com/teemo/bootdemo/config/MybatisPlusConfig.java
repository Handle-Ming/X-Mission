package com.teemo.bootdemo.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @ProjectName: bootdemo
 * @Package: com.teemo.bootdemo.config
 * @ClassName: MybatisPlusConfig
 * @Author: Teemo
 * @Description: ${description}
 * @Date: 2019/5/16 18:25
 * @Version: 1.0
 */
@Configuration
@MapperScan("com.teemo.bootdemo.dao.mapper*")
public class MybatisPlusConfig {

    /** 
     * @Description: 分页插件
     * @Param:  
     * @return:  
     * @Author: Teemo
     * @Date: 2019/5/16 
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    /** 
     * @Description: sql注入器  逻辑删除插件
     * @Param:  
     * @return:  
     * @Author: Teemo
     * @Date: 2019/5/16 
     */
    @Bean
    public ISqlInjector iSqlInjector(){
        return new LogicSqlInjector();
    }
    
    /**
     * @Description: sql性能分析插件, 输出sql语句及所需时间
     * @Param:
     * @return:
     * @Author: Teemo
     * @Date: 2019/5/16
     */
    @Bean
    @Profile({"dev"})// 设置 dev 环境开启
    public PerformanceInterceptor performanceInterceptor(){
        return new PerformanceInterceptor();
    }


    /** 
     * @Description: 乐观锁插件
     * @Param:  
     * @return:  
     * @Author: Teemo
     * @Date: 2019/5/16 
     */
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){ 
        return new OptimisticLockerInterceptor();
    }

    
}

