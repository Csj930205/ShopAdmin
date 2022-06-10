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
@WebServlet("/signup/pw_check.do")
public class MemberPwCheck extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pw=req.getParameter("pw");
		MemberDao memDao=new MemberDao();
		MemberVo memVo=new MemberVo();
		resp.setContentType("json/application; charset=UTF-8");
		try {
			memVo=memDao.pwCheck(pw);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(memVo.getPw()==null) {
			resp.getWriter().append("{\"pw_check\":true}");
		}else {
			resp.getWriter().append("{\"pw_check\":false}");
		}
	}
}
