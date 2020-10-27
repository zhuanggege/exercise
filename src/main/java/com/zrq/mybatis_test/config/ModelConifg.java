package com.zrq.mybatis_test.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zrq
 * @CreateDate: 2020/10/27
 * @Version: 类说明： modelMapper映射匹配器
 */
@Configuration
public class ModelConifg {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        //启用字段配置
        modelMapper.getConfiguration().setFieldMatchingEnabled(true);
        //匹配策略,完全匹配
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
