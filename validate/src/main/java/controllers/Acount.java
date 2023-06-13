package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CurrencyEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import entity.acountentity;

@Controller

public class Acount {
	@InitBinder
	public void initbinder(WebDataBinder data) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		s.setLenient(false);
		data.registerCustomEditor(Date.class , new CustomDateEditor(s,true));
	}
@GetMapping({"/","/insertAccount"})
public String addAcount(Model model)
  
{
	acountentity account = new acountentity();
	model.addAttribute("acc",account);
	return "add"; 
}
@PostMapping(value = "insertAccount")

public String createAccount(@Valid @ModelAttribute("acc") acountentity acc,BindingResult result,Model model,HttpSession session) {
  if(result.hasErrors())
  {
	  return "add";
  }
  else {
	  return "infor"; 
  }
	
}
}
