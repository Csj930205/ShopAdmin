package shop.com.checkController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.com.dao.MemberDao;
import shop.com.vo.MemberVo;
@WebServlet("/signup/email_check.do")
public class MemberEmailCheck extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		MemberDao memDao=new MemberDao();
		MemberVo memVo=null;
		resp.setContentType("json/application; charset=UTF-8");
		try {
			memVo=memDao.emailCheck(email);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(memVo.getEmail()==null) {
			resp.getWriter().append("{\"email_check\":true}");
		}else {
			resp.getWriter().append("{\"email_check\":false}");
		}
	}
}
