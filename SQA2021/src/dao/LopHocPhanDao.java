package dao;

import java.util.List;

import model.LopHocPhan;

public interface LopHocPhanDao {
		
	LopHocPhan get(int id);

	List<LopHocPhan> search(String tenmonhoc);
	
	List<LopHocPhan> search1(String idMonHoc);
}
