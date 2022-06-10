package shop.com.dao;

import java.sql.SQLException;
import java.util.List;

import shop.com.vo.ItemVo;

public interface ItemDaoAble {
	public List<ItemVo> list(int page) throws ClassNotFoundException, SQLException;
	public ItemVo detail(int item_num) throws ClassNotFoundException, SQLException;
	public boolean update(ItemVo item) throws ClassNotFoundException, SQLException;
	public boolean insert(ItemVo item) throws ClassNotFoundException, SQLException;
	public boolean delete(int item_num) throws ClassNotFoundException, SQLException;
}
