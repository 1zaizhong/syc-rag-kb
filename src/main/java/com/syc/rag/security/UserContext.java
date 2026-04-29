package com.syc.rag.security;

/**
 * @author 粟英朝
 * @version 0.0.3
 * @date 2026/4/29 下午2:18
 * @description
 **/

import lombok.Data;

/**
 * 存储当前请求的用户信息，通过 ThreadLocal 在请求链路中传递。
 * 由 Sa-Token 拦截器在请求进入时写入，无需每个方法手动传参。
 */
public class UserContext {
    private static final ThreadLocal<UserInfo> CONTEXT = new ThreadLocal<>();

    public  static  void set(UserInfo userInfo ){
        CONTEXT.set(userInfo);
    }

    public static UserInfo get(){
        UserInfo user = CONTEXT.get();
        if(user == null){
            throw  new IllegalStateException("UserContext 未初始化,请检查认证拦截器配置");
        }
        return  user;
    }

    public  static  Long getUserId(){
        return  get().getUserId();
    }
    public static String getUsername(){
        return  get().getUsername();
    }
    public static String getDepartmentId(){
        return  get().getDepartmentId();
    }
    public static  boolean isAdmin(){
        return  get().getRole().equals("ADMIN");
    }
    public static void clear(){
        CONTEXT.remove();
    }

    @Data
    public  static  class UserInfo{
        private Long userId;
        private String username;
        private String departmentId;
        private  String role;
    }
}
