package dao;

import java.util.List;

import model.KiHoc;

public interface KiHocDao {
	
	KiHoc search1(String tenKiHoc);

	List<KiHoc> search(String tenKiHoc);
}
