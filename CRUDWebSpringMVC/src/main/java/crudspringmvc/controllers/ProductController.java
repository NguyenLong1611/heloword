package crudspringmvc.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import crudspringmvc.dao.CategoryDao;
import crudspringmvc.dao.ProductDao;
import crudspringmvc.entities.Category;
import crudspringmvc.entities.Product;

@Controller
public class ProductController {
 
	
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProductDao productDao;
	@RequestMapping(value = "/product")
	public String index(Model model) {
		List<Product> list =  productDao.getAll();
		model.addAttribute("listProduct", list);
		return "product/index";
	}
	@RequestMapping(value = "/addproduct")
	public String add(Model model ) {
		List<Category> listCategory = categoryDao.getAll();
		Product product = new Product();
		model.addAttribute("product", product);
		model.addAttribute("listCategory", listCategory);
		return "product/add";
	}
	@RequestMapping(value = "/createProduct")
	public String save(@ModelAttribute("product")Product product, BindingResult result, @RequestParam("fileImage")MultipartFile fileImage,HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("uploads/images");
		File  f = new File(path);
		String fileName =  fileImage.getOriginalFilename();
		File distination = new File(f.getAbsolutePath()+"/"+fileName);
		if(!distination.exists()) {
			try {
				Files.write(distination.toPath(), fileImage.getBytes(), StandardOpenOption.CREATE);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		product.setIMAGE(fileName);
		if(productDao.create(product)) {
			return "redirect:/product";
		}
		return "product/add";
	}
}
