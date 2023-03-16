package com.midlaj.apiGatewayAdmin.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(RestAuthenticationEntryPoint.class);


    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException {
        logger.error("Responding with unauthorized error. Message - {}", e.getMessage());
        final String expiredMsg = (String) httpServletRequest.getAttribute("expired");
        final String msg = (expiredMsg != null) ? expiredMsg : "Unauthorized";
        final int responseCode = (expiredMsg != null) ? HttpServletResponse.SC_CONFLICT : HttpServletResponse.SC_UNAUTHORIZED;
        httpServletResponse.sendError(responseCode, msg);

//        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,
//                e.getLocalizedMessage());
    }
}
