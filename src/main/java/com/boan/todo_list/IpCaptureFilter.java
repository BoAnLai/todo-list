package com.boan.todo_list;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class IpCaptureFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {

//		System.out.println("remote addr:" + req.getRemoteAddr());
//		System.out.println("local addr:" + req.getLocalAddr());

		String ipAddress = req.getRemoteAddr();

		if ("0:0:0:0:0:0:0:1".equals(ipAddress) || "::1".equals(ipAddress)) {
			ipAddress = "127.0.0.1"; // Convert to IPv4 loopback address
		}

		System.out.println(ipAddress);
		UserContext.setIpAddress(ipAddress);
		filterChain.doFilter(req, res);
	}

}
