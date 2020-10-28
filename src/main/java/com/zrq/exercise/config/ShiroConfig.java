package com.zrq.exercise.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: zrq
 * @CreateDate: 2020/10/11
 * @Version: 类说明： shiro配置类，实现securityManager，shiroFilterFactoryBean，myRealm三个是方法
 */
@Configuration
public class ShiroConfig {

    //配置shiroFilterFactoryBean,拦截器
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(securityManager);
        bean.setLoginUrl("/person/login");
        bean.setSuccessUrl("/new/idnex");
        //添加shiro内置的过滤器
        /*
            参数：
            anon: 例子/admins/**=anon 没有参数，表示可以匿名使用。
            authc: 例如/admins/user/**=authc表示需要认证(登录)才能使用，没有参数
            roles：例子/admins/user/**=roles[admin],参数可以写多个，多个时必须加上引号，
                                并且参数之间用逗号分割，当有多个参数时，例如admins/user/**=roles["admin,guest"],
                                每个参数通过才算通过，相当于hasAllRoles()方法。
            perms：例子/admins/user/**=perms[user:add:*],参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，
                         例如/admins/user/**=perms["user:add:*,user:modify:*"]，当有多个参数时必须每个参数都通过才通过，
                         想当于isPermitedAll()方法。
            rest：例子/admins/user/**=rest[user],根据请求的方法，相当于/admins/user/**=perms[user:method] ,
                               其中method为post，get，delete等。
            port：  例子/admins/user/**=port[8081],当请求的url的端口不是8081是跳转到schemal://serverName:8081?queryString,
                               其中schmal是协议http或https等，serverName是你访问的host,8081是url配置里port的端口，queryString是你访问的url里的？后面的参数。
            authcBasic：例如/admins/user/**=authcBasic没有参数表示httpBasic认证
            ssl:  例子/admins/user/**=ssl没有参数，表示安全的url请求，协议为https
            user: 例如/admins/user/**=user没有参数表示必须存在用户，当登入操作时不做检查

            注：anon，authcBasic，auchc，user是认证过滤器，
                perms，roles，ssl，rest，port是授权过滤器
         */
        Map<String, String> map = new LinkedHashMap();
        map.put("/person/index","authc");
        map.put("/new/index","anon");
        map.put("/person/*","authc");
        map.put("/*/*","anon");             //全部放行
        bean.setFilterChainDefinitionMap(map);
        return bean;



    }

    //配置securityManager,shiro使用的中间件
    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //关联myRealm
        securityManager.setRealm(myRealm);

        return securityManager;



    }

    //配置myRealm
    @Bean
    public MyRealm myRealm() {
        return  new MyRealm();
    }

}
