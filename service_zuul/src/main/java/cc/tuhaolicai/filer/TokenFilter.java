package cc.tuhaolicai.filer;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @version V1.0
 * @Title： TokenFiletr
 * @Package： cc.tuhaolicai.filer
 * @Description： 对token做校验
 * @author： nan
 * @date： 2017-06-16 10:28
 */
@Component
public class TokenFilter extends ZuulFilter {

    @Value("${token}")
    String token;

    private static Logger log = LoggerFactory.getLogger(TokenFilter.class);


    /**
     * @return 过滤器类型
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤顺序
     *
     * @return 排序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤逻辑判断
     *
     * @return 师傅需要过滤
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器逻辑
     *
     * @return
     */
    @Override
    public Object run() {
        String msg = null;
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        String accessToken = request.getParameter("token");
        if (StringUtils.isNotBlank(accessToken)) {
            if (token.equals(accessToken))
                log.info("token verify succeed");
            else {
                msg = "token is error";
            }
        } else
            msg = "token is empty";

        if (StringUtils.isNotBlank(msg)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write(msg);
            } catch (Exception ignored) {
            }
        }

        return null;
    }
}
