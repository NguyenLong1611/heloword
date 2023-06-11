package baitaplon.ipm;

import java.util.List;
import java.util.Scanner;

import baitaplon.itf.IProduct;


public class Product implements IProduct {
	private String product_id;
	private String product_name;
	private String title;
	private float import_price;
	private float export_price;
	private float profit;
	private String descriptions;
	private boolean product_status;
	private Categories catalog ;
	Scanner sc = new Scanner(System.in);
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Product(String product_id, String product_name, String title, float import_price, float export_price,
			float profit, String descriptions, boolean product_status, Categories catalog) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.title = title;
		this.import_price = import_price;
		this.export_price = export_price;
		this.profit = profit;
		this.descriptions = descriptions;
		this.product_status = product_status;
		this.catalog = catalog;
	}
	


	public String getProduct_id() {
		return product_id;
	}


	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public float getImport_price() {
		return import_price;
	}


	public void setImport_price(float import_price) {
		this.import_price = import_price;
	}


	public float getExport_price() {
		return export_price;
	}


	public void setExport_price(float export_price) {
		this.export_price = export_price;
	}


	public float getProfit() {
		return profit;
	}


	public void setProfit(float profit) {
		this.profit = profit;
	}


	public String getDescriptions() {
		return descriptions;
	}


	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}


	public boolean isProduct_status() {
		return product_status;
	}


	public void setProduct_status(boolean product_status) {
		this.product_status = product_status;
	}


	public Categories getCatalog() {
		return catalog;
	}


	public void setCatalog(Categories catalog) {
		this.catalog = catalog;
	}
//thuc thi phuong thuc inputData cua interface IProduct
	@Override
	public void inputData(List<Product> list) {
	System.out.println("Moi ban nhap vao ma  san pham : ");
	while (true)
	{
		this.product_id=sc.nextLine();
		this.product_id=this.product_id.replaceAll(" ","" );
		if(this.product_id.length()!=4 )
		{
			System.err.println("Vui long nhap lai ma san pham = 4 ky tu ..");
		}
		else if(this.product_id.charAt(0)!='C')
		{
			System.err.println("Vui long nhap lai ma san pham bat dau = ky tu 'C' ");
		}
		else if(this.check_product(list, product_id))
		{
			System.err.println("Ma san pham da ton tai .");
		}
		else
		{
			break;
		}
		
	}
	System.out.println("Moi ban nhap vao ten san pham : ");
	while(true)
	{
		product_name=sc.nextLine();
		if(this.product_name.length()<6||this.product_name.length()>50)
		{
			System.err.println("Ten san pham phai tu 6-50 ky tu !");
		}
		else if(check_product_name(list, product_name))
		{
			System.err.println("Ten san pham da ton tai ! ");
		}
		else
		{
			break;
		}
	}
	System.out.println("Moi ban nhap vao tieu de san pham : ");
	while(true)
	{
		title=sc.nextLine();
		if(this.title.length()<6||this.title.length()>30)
		{
			System.err.println("Tieu de san pham 6-30 ky tu !");
		} 
		else 
		{
			break;
		}
	}
	System.out.println("Moi ban nhap vao gia nhap san pham : ");
	while(true)
	{
		
		try {
			this.import_price=Float.parseFloat(sc.nextLine());
			if(this.import_price<=0)
			{
				System.err.println("Gia nhap san pham phai > 0 moi ban nhap lai : ");
			}
			else
			{
				break;
			}
		} catch (Exception e) {
			System.err.println("Moi ban nhap lai gia nhap san pham ' so thuc ' : ");
		}
	}
	System.out.println("Moi ban nhap vao gia ban san pham : ");
	while(true)
	{
		try {
			this.export_price=Float.parseFloat(sc.nextLine());
			 if(this.export_price<=0)
			 {
				 System.err.println("Yeu cau nhap lai gia ban !");
			 }
			 else if(this.export_price<((this.import_price*Min_INTEREST_RATE)+this.import_price))
			 {
				 System.err.println("Gia ban san pham phai lon hon gia nhap it nhat la 0.2 lan , moi ban nhap lai : "); 
			 }
			 else
			 {
				 break;
			 }
		} catch (Exception e) {
			System.err.println("Moi ban nhap lai gia ban san pham ' so thuc'");
		}
	}
	System.out.println("Moi ban nhap vao mo ta san pham : ");
	while(true)
	{
		this.descriptions=sc.nextLine();
		if(this.descriptions.isEmpty())
		{
			System.err.println("Mo ta khong duoc de trong moi ban nhap lai . ");
		}
		else
		{
			break;
		}
	}
	System.out.println("Moi ban nhap vao trang thai cua san pham : ");
	while(true)
	{
		String str = sc.nextLine();
		if(str.equals("True")||str.equals("False"))
		{
			this.product_status=Boolean.parseBoolean(str);
			break;
		}
		else
		{
			System.err.println("Trang thai cua san pham chi nhan 'True' hoac 'False',moi ban nhap lai : ");
		}
	}
//	yeu cau nhap danh muc cua san pham
//	System.out.println("Moi ban nhap vao danh muc cua san pham : ");
//	this.catalog=g;
	}
// thuc thi phuong thuc displayData cua interface IProduct
	@Override
	public void displayData() {
		System.out.println("Ma san pham : "+this.product_id);
		System.out.println("Ten san pham : "+this.product_name);
		System.out.println("Tieu de san pham : "+this.title);
		System.out.println("Gia nhap san pham : "+this.import_price+" VND");
		System.out.println("Gia ban san pham : "+this.export_price+" VND");
		System.out.println("Mo ta san pham : "+this.descriptions);
		System.out.println("Trang thai san pham : "+(this.product_status?"Hoat Dong":"Khong Hoat Dong"));
		}

	@Override
	public void calProfit() {
		this.profit = this.export_price- this.import_price;
		System.out.println("Ma san pham: "+this.product_id);
		System.out.println("Loi nhuan san pham : "+this.profit+" VND");
		
		
	}
//	khoi tao phuong thuc check ma san pham da ton tai chua 
	public boolean check_product(List<Product>list,String product_id)
	{
		for (Product product : list) {
			if(product.getProduct_id().equals(product_id))
			{
				return true;
			}
			
			}return false;
		
		
	}
//	phuong thuc check ten san pham da ton tai chua .
	public boolean check_product_name(List<Product>list,String produc_name)
	{
		for (Product product : list) {
			if(product.getProduct_name().equals(produc_name))
			{
				return true;
			}
			
		}
		return false;
		
	}
	public void menu_main(String tab)
	{
		System.out.println(tab+"+___________Quan ly san pham___________+");
		System.out.println(tab+"| 1.Them san pham moi                  |");
		System.out.println(tab+"| 2.Tinh loi nhuan san pham            |");
		System.out.println(tab+"| 3.Hien thi thong tin san pham        |");
		System.out.println(tab+"| 4.Sap xep san pham                   |");
		System.out.println(tab+"| 5.Cap nhap thong tin san pham        |");
		System.out.println(tab+"| 6.Cap nhap trang thai san pham       |");
		System.out.println(tab+"| 7.Quay lai                           |");
		System.out.println(tab+"+______________________________________+");
		System.out.println(tab+"Moi ban chon chuc nang: ");
		int lua_chon=Integer.parseInt(sc.nextLine());
		switch(lua_chon)
		{
		case 1:
			System.out.println(tab+"Them san pham moi");
			break;
		case 2:
			System.out.println(tab+"Tinh loi nhuan san pham");
			break;
		case 3:
			System.out.println(tab+"Hien thi thong tin san pham");
			break;
		case 4:
			menu_sapxep(tab+"\t");
			break;
		case 5:
			System.out.println("Cap nhap thong tin san pham");
			break;
		case 6:
			System.out.println(tab+"Cap nhap trang thai san pham");
			break;
		case 7:
			return;
		default:
			System.out.println(tab+"Ban chon sai chuc nang moi ban chon lai");
		}
		
	}
	public void menu_sapxep(String tab) 
	{
		while(true)
		{
			System.out.println(tab+"1.Sap xep theo gia ban tang dan");
			System.out.println(tab+"2.Sap xep theo loi nhuan giam dan");
			System.out.println(tab+"3.Quay lai");
			System.out.println(tab+"Moi ban chon chuc nang: ");
			int lua_chon = Integer.parseInt(sc.nextLine());
			switch(lua_chon)
			{
			case 1:
				System.out.println(tab+"Sap xep theo gia ban tang dan");
				break;
			case 2:
				System.out.println("Sap xep theo loi nhuan giam dan");
				break;
			case 3:
				return;
			default:
				System.out.println(tab+"Ban chon sai chuc nang moi ban chon lai");
			}
		}
	}
	

}
