package com.zrq.exercise.config;

import com.zrq.exercise.entity.Person;
import com.zrq.exercise.server.PersonServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: zrq
 * @CreateDate: 2020/10/11
 * @Version: 类说明： Realm 是可以访问程序特定的安全数据如用户、角色、权限等的一个组件
 *                   类中有授权和认证的两个方法，实现
 */
@Slf4j
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private PersonServer personServerImpl;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("用户授权");
        //授权： 访问控制的过程，即确定“谁”可以访问“什么”，数据表中存储权限，这里就可以授权什么
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //认证有时也被称为登录，这是一种让什么用户能操作什么功能

        log.info("用户认证");
        UsernamePasswordToken user = (UsernamePasswordToken) authenticationToken;
        String user1 = authenticationToken.getPrincipal().toString();
        Person byName = personServerImpl.findByName(user.getUsername());
        if(byName == null) {
            return null;
        }else {
            return new SimpleAuthenticationInfo(byName,String.valueOf(byName.getAge()),"");
        }

    }
}
