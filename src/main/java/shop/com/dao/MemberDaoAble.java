package shop.com.dao;

import java.sql.SQLException;
import java.util.List;

import shop.com.vo.MemberVo;

public interface MemberDaoAble {
	// ȸ������Ʈ ���
	public List<MemberVo> list(int page) throws ClassNotFoundException, SQLException;
	// �����ڰ� ����, �������� ����, �������� �� �� ���� ������ ����
	public MemberVo detail(String id) throws ClassNotFoundException, SQLException;
	// ȸ�����, ȸ������ 
	public boolean insert(MemberVo mem) throws ClassNotFoundException, SQLException;
	// ȸ������ ����
	public boolean update(MemberVo mem) throws ClassNotFoundException, SQLException;
	// ȸ������
	public boolean delete(String id) throws ClassNotFoundException, SQLException;
}
