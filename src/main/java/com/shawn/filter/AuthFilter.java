package com.shawn.filter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.shawn.constant.Response;
import com.shawn.model.entity.AuthEntity;
import com.shawn.repository.AuthRepository;

/**
 * 权限验证过滤器
 */
public class AuthFilter implements Filter {

    private final static Logger log = LoggerFactory.getLogger(AuthFilter.class);

    @Autowired
    private AuthRepository repository;

    private String[] includeUrls = new String[] {"/loginPage", "/login", "/loginfail"};

    @Override
    public void destroy() {
        // 顾名思义，在销毁时使用
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        String uri = req.getRequestURI();
        boolean needFilter = isNeedFilter(uri);
        if (!needFilter) {
            log.info("token filter不过滤!");
            chain.doFilter(request, response);
            return;
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String token = req.getHeader("token");
        Response res = new Response();
        boolean isFilter = false;
        if (null == token || token.isEmpty()) {
            res.setSuccess(false);
            res.setErrorCode("403");
            res.setErrorMessage("token没有认证通过!原因为：客户端请求参数中无token信息");
        } else {
            AuthEntity auth = repository.selectByToken(token);
            if (null == auth) {
                res.setSuccess(false);
                res.setErrorCode("403");
                res.setErrorMessage("token没有认证通过!原因为：客户端请求中认证的token信息无效，请查看申请流程中的正确token信息");
            }
            // else if((auth.getStatus() == 0)){
            // res.setSuccess(false);
            // res.setErrorCode("401");
            // res.setErrorMessage("该token目前已处于停用状态，请联系邮件系统管理员确认!");
            // }
            else {
                isFilter = true;
                res.setSuccess(true);
            }
        }

        if (!res.isSuccess()) {
            try (OutputStreamWriter osw = new OutputStreamWriter(response.getOutputStream(), "UTF-8");
                PrintWriter writer = new PrintWriter(osw, true)) {

                String jsonStr = res.getErrorMessage();
                writer.write(jsonStr);
                writer.flush();
                writer.close();
                osw.close();
            } catch (UnsupportedEncodingException e) {
                log.error("过滤器返回信息失败:" + e.getMessage(), e);
            } catch (IOException e) {
                log.error("过滤器返回信息失败:" + e.getMessage(), e);
            }
            return;
        }

        if (isFilter) {
            log.info("token filter过滤ok!");
            chain.doFilter(request, response);
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        // 初始化操作
    }

    /**
     * 判断是否需要登录
     * 
     * @param request
     * @return
     */
    private boolean needLogin(HttpServletRequest request) {
        // 进行是否需要登录的判断操作
        return false;
    }

    /**
     * 判断是否需要过滤
     *
     * @param uri
     * @return
     */
    private boolean isNeedFilter(String uri) {

        for (String includeUrl : includeUrls) {
            if (includeUrl.equals(uri)) {
                return false;
            }
        }
        return true;
    }

}
