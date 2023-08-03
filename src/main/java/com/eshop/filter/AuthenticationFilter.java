package com.eshop.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.eshop.security.IAuthentication;

@WebFilter(urlPatterns = { "/login", "/signup", "/logout", "/my-account" }, dispatcherTypes = DispatcherType.REQUEST)
public class AuthenticationFilter implements Filter {

	@Inject
	private IAuthentication authentication;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		String enteredUsername = httpRequest.getParameter("username");
		String enteredPassword = httpRequest.getParameter("password");
		String enteredEmail = httpRequest.getParameter("email");

		if (!authentication.isAuthenticated()) {
			if (httpRequest.getServletPath().equals("/login")) {
				if (httpRequest.getMethod().equals("GET")) {
					chain.doFilter(request, response);
				} else if (httpRequest.getMethod().equals("POST") && httpRequest.getParameter("username") != null
						&& httpRequest.getParameter("password") != null) {

					if (authentication.authenticate(enteredUsername, enteredPassword)) {
						session.setAttribute("authenticated", authentication.getUser());
						chain.doFilter(request, response);
					} else {
						chain.doFilter(request, response);
					}
				}
			} else if (httpRequest.getServletPath().equals("/signup")) {
				if (httpRequest.getMethod().equals("POST")) {
					authentication.register(enteredEmail, enteredUsername, enteredPassword);
				}
				chain.doFilter(request, response);
			}

		} else if (authentication.isAuthenticated()) {
			if (httpRequest.getServletPath().equals("/logout")) {
				authentication.logOut();
				session.removeAttribute("authenticated");
			}
			chain.doFilter(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}
}
