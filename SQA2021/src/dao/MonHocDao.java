package dao;

import java.util.List;

import model.MonHoc;

public interface MonHocDao {
	
	MonHoc search1(String idMonHoc);
	
//	List<MonHoc> search(String name);
	
	List<MonHoc> search2(String nganhhoc, String kihoc);
}