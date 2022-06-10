package shop.com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter("/member/*")
public class MemberLoginFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		Object login=session.getAttribute("login");
		Object grade=session.getAttribute("grade");
		String login_msg="";
		if(login!=null &&(boolean)login) {
			if(grade!=null && (byte)grade==0) {
				chain.doFilter(request, response);// 요청받았던 URL로 이동
			}else{
				login_msg="맴버관리를 관리할 수 있는 등급이 아닙니다. 다른아이디로 로그인 해주세요";
				session.setAttribute("login_msg", login_msg);
				resp.sendRedirect(req.getContextPath()+"/login/login.do");
			}
		}
	}
}
