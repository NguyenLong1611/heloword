package crudspringmvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")

public class Product {

	@Id
	@Column(name = "PRODUCTID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer PRODUCTID;
	@Column(name = "PRODUCTNAME")
	private String PRODUCTNAME;
	@Column(name = "PRICE")
	private double PRICE;
	@Column(name = "IMAGE")
	private String IMAGE;
	@Column(name = "DESCRIPTION")
	private String DESCRIPTION;
	@ManyToOne
	@JoinColumn(name = "CATEGORYID",referencedColumnName = "categoryId")
	private Category category;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Integer pRODUCTID, String pRODUCTNAME, double pRICE, String iMAGE, String dESCRIPTION,
			Category category) {
		super();
		PRODUCTID = pRODUCTID;
		PRODUCTNAME = pRODUCTNAME;
		PRICE = pRICE;
		IMAGE = iMAGE;
		DESCRIPTION = dESCRIPTION;
		this.category = category;
	}
	public Integer getPRODUCTID() {
		return PRODUCTID;
	}
	public void setPRODUCTID(Integer pRODUCTID) {
		PRODUCTID = pRODUCTID;
	}
	public String getPRODUCTNAME() {
		return PRODUCTNAME;
	}
	public void setPRODUCTNAME(String pRODUCTNAME) {
		PRODUCTNAME = pRODUCTNAME;
	}
	public double getPRICE() {
		return PRICE;
	}
	public void setPRICE(double pRICE) {
		PRICE = pRICE;
	}
	public String getIMAGE() {
		return IMAGE;
	}
	public void setIMAGE(String iMAGE) {
		IMAGE = iMAGE;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
