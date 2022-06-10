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
@WebFilter("/category/*")
public class CategoryFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		Object login=session.getAttribute("login");
		Object grade=session.getAttribute("grade");
		String cate_msg="";
		if(login!=null&&(boolean)login) {
			if(grade!=null && (byte)grade<3) {
				chain.doFilter(request, response);
			}else {
				cate_msg="ī�װ��� ������ ����� �ƴմϴ�. �ٸ� ���̵�� �α��� ���ּ���.";
				session.setAttribute("cate_msg", cate_msg);
				resp.sendRedirect(req.getContextPath()+"/login/login.do");
			}
		}
	}
}
