package dao;

import java.util.List;

import model.LichHoc;

public interface LichHocDao {
	void add ( LichHoc lichHoc );
	
	void add1 ( LichHoc lichHoc );
	
	List<LichHoc> searchLichHoc(String idUser);
	
}
