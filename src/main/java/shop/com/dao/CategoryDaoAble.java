package shop.com.dao;

import java.sql.SQLException;
import java.util.List;

import shop.com.vo.CategoryVo;

public interface CategoryDaoAble {
	public List<CategoryVo> list(int page) throws ClassNotFoundException, SQLException;
	public CategoryVo detail(int cateNum) throws ClassNotFoundException, SQLException;
	public boolean update(CategoryVo cate) throws ClassNotFoundException, SQLException;
	public boolean insert(CategoryVo cate) throws ClassNotFoundException, SQLException;
	public boolean delete(int cateNum) throws ClassNotFoundException, SQLException;
	
}
