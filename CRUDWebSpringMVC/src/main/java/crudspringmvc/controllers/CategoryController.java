package crudspringmvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import crudspringmvc.dao.CategoryDao;
import crudspringmvc.entities.Category;

@Controller
public class CategoryController {
    @Autowired
    private CategoryDao categoryDao; 
	@RequestMapping(value = "/category")
	public String index( Model model) {
		List<Category> list = categoryDao.getAll();
		model.addAttribute("category", list);
		return "category/index";
	}
	@RequestMapping(value = "/addCategory")
	public String add(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "category/add";
	}
	@RequestMapping(value = "/createCategory")
	public String save(@ModelAttribute ("category")Category category,Model model,RedirectAttributes redirectAttributes) {
		
		if(categoryDao.create(category)) {
			redirectAttributes.addFlashAttribute("success","Thêm mới thành công");
			return "redirect:/";
		}
		return "category/add";
	}
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		if(categoryDao.delete(id)) {
			redirectAttributes.addFlashAttribute("success","Xóa thành công");
			return "redirect:/";
		}
		return "redirect:/";
	}
	@RequestMapping(value = "/edit/{id}")
	public String edit(Model model,@PathVariable Integer id ) {
		Category category = categoryDao.find(id);
		model.addAttribute("category", category);
		return "category/edit";
	}
	@RequestMapping(value = "/updateCategory")
public String update(@ModelAttribute ("category")Category category,Model model,RedirectAttributes redirectAttributes) {
		
		if(categoryDao.update(category)) {
			redirectAttributes.addFlashAttribute("success","Cập nhập thành công");
			return "redirect:/";
		}
		redirectAttributes.addFlashAttribute("errors","Cập nhập thất bại");
		return "category/edit";
	
}}
