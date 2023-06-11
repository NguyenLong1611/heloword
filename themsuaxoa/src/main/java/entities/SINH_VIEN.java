package entities;

import java.sql.Date;

public class SINH_VIEN {
 private String MSV;
 private String HO_TEN;
 private Boolean GIOI_TINH;
 private Date NGAY_SINH;
 private String DIA_CHI;
 private String MA_LOP;
public SINH_VIEN() {
	super();
	// TODO Auto-generated constructor stub
}
public SINH_VIEN(String mSV, String hO_TEN, Boolean gIOI_TINH, Date nGAY_SINH, String dIA_CHI, String mA_LOP) {
	super();
	MSV = mSV;
	HO_TEN = hO_TEN;
	GIOI_TINH = gIOI_TINH;
	NGAY_SINH = nGAY_SINH;
	DIA_CHI = dIA_CHI;
	MA_LOP = mA_LOP;
}
public String getMSV() {
	return MSV;
}
public void setMSV(String mSV) {
	MSV = mSV;
}
public String getHO_TEN() {
	return HO_TEN;
}
public void setHO_TEN(String hO_TEN) {
	HO_TEN = hO_TEN;
}
public Boolean getGIOI_TINH() {
	return GIOI_TINH;
}
public void setGIOI_TINH(Boolean gIOI_TINH) {
	GIOI_TINH = gIOI_TINH;
}
public Date getNGAY_SINH() {
	return NGAY_SINH;
}
public void setNGAY_SINH(Date nGAY_SINH) {
	NGAY_SINH = nGAY_SINH;
}
public String getDIA_CHI() {
	return DIA_CHI;
}
public void setDIA_CHI(String dIA_CHI) {
	DIA_CHI = dIA_CHI;
}
public String getMA_LOP() {
	return MA_LOP;
}
public void setMA_LOP(String mA_LOP) {
	MA_LOP = mA_LOP;
}
 
}
