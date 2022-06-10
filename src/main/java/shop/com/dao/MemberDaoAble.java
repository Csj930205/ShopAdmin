package shop.com.dao;

import java.sql.SQLException;
import java.util.List;

import shop.com.vo.MemberVo;

public interface MemberDaoAble {
	// 회원리스트 출력
	public List<MemberVo> list(int page) throws ClassNotFoundException, SQLException;
	// 관리자가 수정, 개인정보 수정, 개인정보 상세 및 삭제 페이지 구현
	public MemberVo detail(String id) throws ClassNotFoundException, SQLException;
	// 회원등록, 회원가입 
	public boolean insert(MemberVo mem) throws ClassNotFoundException, SQLException;
	// 회원정보 수정
	public boolean update(MemberVo mem) throws ClassNotFoundException, SQLException;
	// 회원삭제
	public boolean delete(String id) throws ClassNotFoundException, SQLException;
}
