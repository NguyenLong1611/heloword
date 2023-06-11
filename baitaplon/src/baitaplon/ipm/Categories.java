package baitaplon.ipm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import baitaplon.itf.ICategories;

public class Categories implements ICategories {
	private int catalog_id;
	private String catalog_name;
	private String descriptions;
	private boolean catalog_status;
	private int parentld;
	private List<Categories> listcg = new ArrayList<Categories>();
	Scanner sc = new Scanner(System.in);
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categories(int catalog_id, String catalog_name, String descriptions, boolean catalog_status, int parentld) {
		super();
		this.catalog_id = catalog_id;
		this.catalog_name = catalog_name;
		this.descriptions = descriptions;
		this.catalog_status = catalog_status;
		this.parentld = parentld;
	}
	

	public int getCatalog_id() {
		return catalog_id;
	}

	public void setCatalog_id(int catalog_id) {
		this.catalog_id = catalog_id;
	}

	public String getCatalog_name() {
		return catalog_name;
	}

	public void setCatalog_name(String catalog_name) {
		this.catalog_name = catalog_name;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public boolean isCatalog_status() {
		return catalog_status;
	}

	public void setCatalog_status(boolean catalog_status) {
		this.catalog_status = catalog_status;
	}

	public int getParentld() {
		return parentld;
	}

	public void setParentld(int parentld) {
		this.parentld = parentld;
	}
//phuong thuc nhap danh sach cac danh muc san pham
	@Override
	public void inputData(List<Categories> listcg) {
		System.out.println("Moi ban nhap vao ma danh muc : ");
		while(true)
		{
			try {
				this.catalog_id=Integer.parseInt(sc.nextLine());
				if(this.catalog_id<=0)
				{
					System.err.println("Yeu cau ban nhap vao so nguyen duong : ");
				}
				else if (this.check_catalog_id(listcg, catalog_id))
				{
					System.err.println("Da ton tai ");
				}
				else {
					break;
				}
				
			} catch (Exception e) {
				System.err.println("Yeu cau ban nhap vao so nguyen :");
			}
		}
		System.out.println("Moi ban nhap vao ten danh muc : ");
		while(true)
		{
			
				this.catalog_name=sc.nextLine();
				if(this.catalog_name.length()>5&&this.catalog_name.length()<31)
				{
					break;
				}
				else
				{
					System.err.println("Yeu can ban nhap vao ten danh muc tu 6-30 ky tu : ");
				}
				
			
			}
//		van de : khi de chuoi = " " yeu cau nhap lai - chua lam duoc.
		System.out.println("Moi ban nhap vao mo ta danh muc : ");
		while(true)
		{
			String str=sc.nextLine();
			if(str.isEmpty())
			{
				System.err.println("Yeu cau ban nhap vao  mo ta danh muc : ");
			}
			else
			{
				this.descriptions=str;
				break;
			}
		}
		System.out.println("Moi ban nhap vao trang thai danh muc : ");
		while(true)
		{
			String str = sc.nextLine();
			if(str.equals("true") || str.equals("false"))
			{
				this.catalog_status=Boolean.parseBoolean(str);
				break;
			}
			else
			{
				System.err.println("Trang thai danh muc chi duoc phep nhap true hoac false yeu cau nhap lai.");
			}
		}
		boolean check=true;
	   while(check)
	{
			System.out.println("Moi ban nhap vao ma danh muc cha : ");
			try {
				int parenId = Integer.parseInt(sc.nextLine());
				int a=0;
				if(parenId==0)
				{
					parenId=this.parentld;
					check=false;
					a=1;
					break;
				}
				else if(parenId>0)
				{
					for(int i=0;i<listcg.size();i++)
                        {
						
						if(listcg.get(i).catalog_id==parenId)
						{
							if(listcg.get(i).parentld==0)
							{
								parentld=parenId;
								check= false;
								a=1;
								break;
							}
							else {
								for(int j=0;j<listcg.size();j++)
								{
									if(listcg.get(j).parentld==0)
									{
										parenId=parentld;
										check=false;
										a=1;
										break;
									}
									else {
										a=2;
									}
								}
							}
						}
							
                        }
				}
				if(parenId<0)
				{
					System.err.println("Danh muc cha phai la so nguyen! ");
				}
				else if(parenId==0)
				{
					System.err.println("Danh muc cha khong ton tai!");
				}
				else if(parenId==2)
				{
					System.err.println("Danh muc cha khong qua 3 cap danh muc!");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Danh muc cha phai la so nguyen!");
			}
	}
		
		
		
	}
//phuong thuc hien thi danh sach cac danh muc san pham
	@Override
	public void displayData() {
		System.out.println("Ma danh muc : "+this.catalog_id);
		System.out.println("Ten danh muc : "+this.catalog_name);
		System.out.println("Mo ta : "+this.descriptions);
		System.out.println("Trang thai danh muc : "+(this.catalog_status?"Hoat dong ":"Khong hoat dong"));
		System.out.println("Danh muc cha : "+this.parentld);
	}
//phuong thuc check catalog_id da ton tai chua 
	public boolean check_catalog_id(List<Categories> listcg,int check_id_catalog) {
		for (Categories categories : listcg) {
			if(categories.getCatalog_id()==check_id_catalog)
			{
				return true;
			}
			
		}
		return false;
		
		
	}
//	phuong thuc check parenId da ton tai chua 
	public boolean check_parenId(List<Categories> listcg,int check_parenId)
	{
		for (Categories categories : listcg) {
			if(categories.getParentld()==check_parenId)
			{
				return true;
			}
		}
		return false;
	}
	public void main_menu(String tab)
	{
		while(true)
		{
			System.out.println(tab+"+__________Quan li danh muc__________");
			System.out.println(tab+"| 1.Danh sach danh muc               |");
			System.out.println(tab+"| 2.Them danh muc                    |");
			System.out.println(tab+"| 3.Xoa danh muc                     |");
			System.out.println(tab+"| 4.Tim kiem danh muc                |");
			System.out.println(tab+"| 5.Quay lai                         |");
			System.out.println(tab+"+____________________________________+");
			System.out.println(tab+"Moi ban chon chuc nang: ");
			int lua_chon=Integer.parseInt(sc.nextLine());
			switch(lua_chon)
			{
			case 1:
				menu_list(tab+"\t");
				break;
			case 2:
				System.out.println(tab+"Them danh muc");
				break;
			case 3:
				System.out.println(tab+"Xoa danh muc");
				break;
			case 4:
				System.out.println(tab+"Tim kiem danh muc");
				break;
			case 5:
				return;
			default:
				System.out.println(tab+"Ban chon sai chuc nang moi ban chon lai:");	
			}
		}
	}
	public void menu_list(String tab)
	{
		while(true)
		{
			System.out.println(tab+"1.1 Danh sach cay danh muc");
			System.out.println(tab+"1.2 Chi tiet danh muc");
			System.out.println(tab+"1.3 Quay lai");
			System.out.println(tab+"Moi ban chon chuc nang: ");
			int lua_chon = Integer.parseInt(sc.nextLine());
			switch(lua_chon)
			{
			case 1:
				System.out.println(tab+"1.1.1 Danh sach cay danh muc");
				break;
			case 2:
				System.out.println(tab+"1.1.2 Chi tiet danh muc");
				for (Categories categories : listcg) {
					categories.displayData();
				}
				
			    break;
			case 3:
				return;
			default :
					System.out.println(tab+"Ban chon sai chuc nang moi ban chon lai");
			}
		}
	}


}
