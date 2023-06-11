package baitaplon.data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import baitaplon.ipm.Categories;
import baitaplon.ipm.Product;

public class dataShopmanager {
	private static  List<Categories> listcg = new ArrayList<Categories>();
	private static List<Product> list = new ArrayList<Product>();
	Scanner sc = new Scanner(System.in);
	public static void dulieu() {
		Scanner sc = new Scanner(System.in);
		Product p = new Product();
		System.out.println("Moi ban nhap vao so danh muc muon khoi tao: ");
		int danh_muc = Integer.parseInt(sc.nextLine());
		for(int i=0;i<danh_muc;i++)
		{
			Categories cgr = new Categories();
			cgr.inputData(listcg);
			listcg.add(cgr);
			System.out.println("____________________________________________________");
		}
				
			
		System.out.println("Moi ban nhap vao so san pham muon khoi tao: ");
		int san_pham = Integer.parseInt(sc.nextLine());
		for(int i = 0;i<san_pham;i++)
		{
			Product prd = new Product();
			prd.inputData(list);
			list.add(prd);
			System.out.println("___________________________________________________");
			
			}
		
	}
		public void  main_menu_Catalogies(String tab)
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
					System.out.println("Nhap so danh muc muon them: ");
					int danh_muc = Integer.parseInt(sc.nextLine());
					for(int i=0;i<danh_muc;i++)
					{
						Categories ctn = new Categories();
						ctn.inputData(listcg);
						listcg.add(ctn);
						System.out.println("___________________________________________________");
					}
					break;
				case 3:
					System.out.println(tab+"Xoa danh muc");
					System.out.println("Nhap ma danh muc muon xoa: ");
					int xoa_danh_muc = Integer.parseInt(sc.nextLine());
					int check = 0;
					for (Categories categories : listcg) {
						if(xoa_danh_muc==categories.getCatalog_id())
						{
							listcg.remove(categories);
							check=-1;
							break;
						}
					}
					if(check==-1)
					{
						System.out.println("Da xoa danh muc: "+xoa_danh_muc);
					}
					else
					{
						System.out.println("Danh muc khong ton tai!");
					}
					break;
				case 4:
					System.out.println(tab+"Tim kiem danh muc");
					System.out.println("Nhap ma danh muc can tim: ");
					int check_ma_dm = Integer.parseInt(sc.nextLine());
					int check_dm = 0;
					for (Categories categories : listcg) {
						if(categories.getCatalog_id()==check_ma_dm)
						{
							categories.displayData();
							check_dm=-1;
							break;
						}
					}if(check_dm==0)
					{
						System.out.println("Ma danh muc khong ton tai!");
					}
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
						System.out.println("___________________________________");
					}
					break;
				case 3:
					return;
				default :
						System.out.println(tab+"Ban chon sai chuc nang moi ban chon lai");
				}
			}
		}
		public void menu_main_Product(String tab)
		{
			while(true)
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
				System.out.println("Nhap so san pham muon them: ");
				int san_phamnew=Integer.parseInt(sc.nextLine());
				for(int i=0;i<san_phamnew;i++)
				{
					Product prn = new Product();
					prn.inputData(list);
					list.add(prn);
					System.out.println("___________________________________________________");
				}
				break;
			case 2:
				System.out.println(tab+"Tinh loi nhuan san pham");
				    for (Product product : list) {
						product.calProfit();
						System.out.println("___________________________________________________");
					}
				break;
			case 3:
				System.out.println(tab+"Hien thi thong tin san pham");
				for (Product product : list) {
					product.displayData();
					System.out.println("___________________________________");
				}
				break;
			case 4:
				menu_sapxep(tab+"\t");
				break;
			case 5:
				System.out.println("Cap nhap thong tin san pham");
				System.out.println("Nhap vao ma san pham muon cap nhap: ");
				String update_masp = sc.nextLine();
				int check =0;
				for (Product product : list) {
					Product pr2 =new Product();
					if(product.getProduct_id().equals(update_masp))
					{
						System.out.println("Cap nhap ma san pham: ");
						pr2.setProduct_id(sc.nextLine());
						System.out.println("Cap nhap ten san pham: ");
						pr2.setProduct_name(sc.nextLine());
						System.out.println("Cap nhap tieu de san pham: ");
						pr2.setTitle(sc.nextLine());
						System.out.println("Cap nhap gia nhap san pham: ");
						pr2.setImport_price(Float.parseFloat(sc.nextLine()));
						System.out.println("Cap nhap gia ban san pham: ");
						pr2.setExport_price(Float.parseFloat(sc.nextLine()));
						list.add(pr2);
						check=-1;
						break;
					}
				}
				if(check==0)
				{
					System.out.println("Khong tim thay ma  san pham!");
				}
				break;
			case 6:
				System.out.println(tab+"Cap nhap trang thai san pham");
				break;
			case 7:
				return;
			default:
				System.out.println(tab+"Ban chon sai chuc nang moi ban chon lai");
			}
			
		}}
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


