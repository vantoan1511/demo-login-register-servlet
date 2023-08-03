package com.eshop.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshop.security.IAuthentication;

@WebServlet(urlPatterns = "/my-account")
public class AccountController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private IAuthentication authentication;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!authentication.isAuthenticated()) {
			resp.sendRedirect("/login");
		} else {
			req.getRequestDispatcher("/views/web/account.jsp").forward(req, resp);
		}
	}
}
