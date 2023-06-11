package baitaplon.itf;

import java.util.List;

import baitaplon.ipm.Categories;
import baitaplon.ipm.Product;

public interface IProduct {
	float Min_INTEREST_RATE=0.2f;
	void inputData(List<Product> list );
	void displayData();
	void calProfit();

}
