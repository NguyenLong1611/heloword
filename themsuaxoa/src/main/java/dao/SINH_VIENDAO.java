package dao;

import java.util.List;

import entities.SINH_VIEN;

public interface SINH_VIENDAO {
	public List<SINH_VIEN> getSINH_VIENs();

	public Boolean insertSINH_VIEN(SINH_VIEN s);

	public SINH_VIEN findStudentById(String MSV);

	public Boolean updateSINH_VIEN(SINH_VIEN s);

	public Boolean deleteSINH_VIEN(String MSV);
}
