package com.eshop.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshop.model.User;
import com.eshop.security.IAuthentication;
import com.eshop.service.IUserService;

@WebServlet(urlPatterns = { "/home", "/login", "/signup", "/logout" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private IUserService userService;

	@Inject
	private IAuthentication authentication;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		String msg = req.getParameter("msg");
		if (!authentication.isAuthenticated()) {
			if (path.equals("/login")) {
				if (msg != null) {
					if (msg.equals("login_failed")) {
						req.setAttribute("msg", "Invalid username or password!");
					} else if (msg.equals("register_successfully")) {
						req.setAttribute("msg", "Register successfully! Please log in.");
					}

				}
				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			} else if (path.equals("/signup")) {
				if (msg != null && msg.equals("email_existed")) {
					req.setAttribute("msg", "This email has already been registered in another account.");
				} else if (msg != null && msg.equals("username_existed")) {
					req.setAttribute("msg", "This username has already been registered in another account.");
				}
				req.getRequestDispatcher("/views/signup.jsp").forward(req, resp);
			} else if (path.equals("/logout")) {
				resp.sendRedirect("/login");
			} else {
				req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
			}
		} else {
			if (path.equals("/login") || path.equals("/signup")) {
				resp.sendRedirect("/my-account");
			} else if (path.equals("/logout")) {
				resp.sendRedirect("/login");
			} else {
				req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
			}

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = new User();
		if (path.equals("/signup") || path.equals("/login")) {
			if (path.equals("/login")) {
				if (!authentication.isAuthenticated() || username == null || password == null) {
					resp.sendRedirect("/login?msg=login_failed");
				} else {
					resp.sendRedirect("/home");
				}
			} else {
				user = authentication.getUser();
				if (user.getEmail().equals("")) {
					resp.sendRedirect("/signup?msg=email_existed");
				} else if (user.getUsername().equals("")) {
					resp.sendRedirect("/signup?msg=username_existed");
				} else {
					resp.sendRedirect("/login?msg=register_successfully");
				}
			}
		} else {
			resp.sendRedirect("/home");
		}
	}
}
