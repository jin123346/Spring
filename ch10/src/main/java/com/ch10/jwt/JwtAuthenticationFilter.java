package com.ch10.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.Filter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Log4j2
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    private static final String AUTH_HEADER="Authorization";
    private static final String TOKEN_PREFIX="Bearer";

    //하나의 요청마다 이 필터가 작동함
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //요청주소에서 마지막 문자열 추출
//        String uri = request.getRequestURI();
//        int i= uri.lastIndexOf("/");
//        String path=uri.substring(i);
//        log.info("here1 : "+path);


        //토큰 추출
        String header = request.getHeader(AUTH_HEADER);
        log.info("here2 : "+header);

        String token = null;
        if(header != null && header.startsWith(TOKEN_PREFIX)) {
            token = header.substring(TOKEN_PREFIX.length()).trim();
        }
        log.info("here3 : "+token);  //json토큰 출력

        //토큰 검사
        if(token != null) {
            try {
                jwtProvider.validateToken(token);

                //토큰이 이상없으면 시큐리티 인증처리  인증객체를 securityholder에 저장하는것
                Authentication auth = jwtProvider.getAuthentication(token);

                SecurityContextHolder.getContext().setAuthentication(auth);

                log.info("here4 : "+auth);

            } catch (Exception e) {

                //토큰에 이상이 있으면 실패응답
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().println(e.getMessage());
                log.info("here5 : "+e.getMessage());
                return;
                //필터에 걸러진거임

            }
        }

        log.info("here6 ..." );
        filterChain.doFilter(request, response);
    }
}
