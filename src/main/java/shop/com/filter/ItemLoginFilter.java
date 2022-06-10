package shop.com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter("/item/*")
public class ItemLoginFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		Object login=session.getAttribute("login");
		Object grade=session.getAttribute("grade");
		String item_msg="";
		if(login!=null && (boolean)login) {
			if(grade!=null && (byte)grade<=2) {
				chain.doFilter(request, response);
			}else {
				item_msg="상품관리할 등급이 아닙니다. 다른아이디로 로그인하세요";
				session.setAttribute("item_msg",item_msg);
				resp.sendRedirect(req.getContextPath()+"/login/login.do");
			}
		}
	}
}
