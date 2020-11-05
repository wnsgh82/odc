package com.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	protected void forward(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
		//포워딩객체 생성하는 인터페이스
		RequestDispatcher rd=req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      req.setCharacterEncoding("utf-8");
	      String uri=req.getRequestURI();
	      
	      if(uri.indexOf("login.do")!= -1) {
	         loginForm(req, resp);
	      }else if(uri.indexOf("login_ok.do")!=-1) {
	    	  
	      }else if(uri.indexOf("member.do")!=-1) {
	         memberForm(req, resp);
	      }
		
	}
	protected void loginForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //로그인 폼
      String path="/WEB-INF/views/member/login.jsp";
      forward(req,resp,path);

	}
	
	protected void loginSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그인처리
		
	}
	protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그아웃  -> 세션에 저장된 정보를 지우면됨
	
		
	}
	protected void memberForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // 회원가입 폼 
      req.setAttribute("mode", "member");
      req.setAttribute("title", "회원 가입");
      String path="/WEB-INF/views/member/member.jsp";
      forward(req, resp, path);

	}
	protected void memberSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//회원가입 처리
	}

}
