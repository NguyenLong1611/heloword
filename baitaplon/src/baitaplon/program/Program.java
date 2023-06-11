package baitaplon.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import baitaplon.data.dataShopmanager;
import baitaplon.ipm.Categories;
import baitaplon.ipm.Product;

public class Program {

	public static void main(String[] args) {
		dataShopmanager dt = new dataShopmanager();
		Scanner sc = new Scanner(System.in);
		dt.dulieu();
		    while(true) {
			System.out.println("+_____________________MENU__________________________+");
			System.out.println("| 1.Quan li danh muc                                |");
			System.out.println("| 2.Quan li san pham                                |");
			System.out.println("| 3.Thoat                                           |");
			System.out.println("+___________________________________________________+");
			System.out.println("Moi ban chon chuc nang: ");
			int lua_chon = Integer.parseInt(sc.nextLine());
			switch(lua_chon)
			{
			case 1:
				dt.main_menu_Catalogies("\t");
				break;
			case 2:
				dt.menu_main_Product("\t");
				break;
			case 3:
				System.out.println("______END______");
				System.exit(0);
				break;
				default:
					System.out.println("Ban da chon sai chuc nang moi ban chon lai");
					
			}
		}
		}
	}


