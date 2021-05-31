package dao;

import java.util.List;

import model.NganhHoc;

public interface NganhHocDao {
	NganhHoc search1(String tenNganh);
	
	List<NganhHoc> search(String tenNganh);
}
