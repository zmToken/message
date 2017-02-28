package com.message.system;

import com.message.entity.user.User;
import com.message.service.user.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * shiro 框架自定义Realm
 */
public class ShiroDbRealm extends AuthorizingRealm {

    protected UserService userService;

    public void setUserService(UserService userService){
        this.userService = userService;
    }

    /**
     * 授权回调
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        User user = userService.findByUserName(shiroUser.name);
        if (user != null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            addRole(user,info);
            return info;
        }
        return null;
    }

    /**
     * 认证回调
     * @param authcToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user = userService.findByUserName(token.getUsername());
        if (user != null) {
            ShiroUser shiroUser = new ShiroUser(user.getNickName(), user.getName(),token.getHost(),user.getId());
            String salt = user.getSalt();
            return new SimpleAuthenticationInfo(shiroUser,user.getPassword(), ByteSource.Util.bytes(salt),getName());
        } else {
            return null;
        }
    }

    /**
     * 添加用户角色
     * @param user
     * @param info
     */
    private void addRole(User user,SimpleAuthorizationInfo info){
        // FIXME 添加用户角色
    }


}
