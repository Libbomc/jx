package com.mall.shiro;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

public class SessionManager extends DefaultWebSessionManager {

    private static final Logger log = LoggerFactory.getLogger(DefaultWebSessionManager.class);

    private String authorization = "Authorization";
    /**
     //重写获取sessionId的方法调用当前Manager的获取方法
     @Override protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
     return this.getReferencedSessionId(request, response);
     }

     //获取sessionId从请求中
     private Serializable getReferencedSessionId(ServletRequest request, ServletResponse response) {
     String id = this.getSessionIdCookieValue(request,response);

     if (id != null) {
     request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "cookie");
     } else {
     id = this.getUriPathSegmentParamValue(request, "JSESSIONID");
     if (id == null) {
     // 获取请求头中的session
     id = WebUtils.toHttp(request).getHeader(this.authorization);
     if (id == null) {
     String name = this.getSessionIdName();
     id = request.getParameter(name);
     if (id == null) {
     id = request.getParameter(name.toLowerCase());
     }
     }
     }
     if (id != null) {
     request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "url");
     }
     }

     if (id != null) {
     request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
     request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
     }

     return id;

     }

     */

}
