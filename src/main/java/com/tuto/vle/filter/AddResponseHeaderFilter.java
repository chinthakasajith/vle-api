package com.tuto.vle.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.google.common.base.Optional;
import com.tuto.vle.domain.TokenValidity;
import com.tuto.vle.service.TokenService;

@WebFilter("/filter-response-header/*")
public class AddResponseHeaderFilter implements Filter {

  @Autowired
  private TokenService tokenService;

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    if (tokenService == null) {
      ServletContext servletContext = request.getServletContext();
      WebApplicationContext webApplicationContext =
          WebApplicationContextUtils.getWebApplicationContext(servletContext);
      tokenService = webApplicationContext.getBean(TokenService.class);
    }

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    Optional<String> hashToken =
        Optional.fromNullable(httpRequest.getHeader("bearer-access-token"));
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;

    if (hashToken.isPresent()) {
      TokenValidity tokenValidity = tokenService.isTokenExpired(hashToken.get());
      // httpServletResponse.addIntHeader("mobile-user-id", tokenValidity.getUserId());
      httpRequest.setAttribute("mobile-user-id", tokenValidity.getUserId());
    }

    chain.doFilter(request, response);
  }

  public void init(FilterConfig filterConfig) throws ServletException {
    // ...
  }

  public void destroy() {
    // ...
  }

}
