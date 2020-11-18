package com.hussain.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hussain.model.Sale;
import com.hussain.service.SaleService;

@Controller
public class SaleController {

	@Autowired
	SaleService saleService;
	
	@RequestMapping("/")
	public String hoem() {
		return "home.jsp";
	}
	
	@RequestMapping("/save")
	public String save(Sale sale) throws InterruptedException, ExecutionException {
		System.out.println("in save");

		System.out.println(saleService.saveSaleDetails(sale));
		
		return "home.jsp";
	}
	
	
	@RequestMapping("/show")
	public ModelAndView show(String billNo) throws InterruptedException, ExecutionException {
		System.out.println("in show");
		ModelAndView mv=new ModelAndView("show.jsp");
		Sale sale=saleService.getSaleDetails(billNo);
		mv.addObject("sale", sale);
		
		System.out.println(saleService.saveSaleDetails(sale));
		
		return mv;
	}
	
	@RequestMapping("/update")
	public String update(Sale sale) throws InterruptedException, ExecutionException {
		System.out.println("in update");
		
		System.out.println(saleService.updateSaleDetails(sale));
		
		return "home.jsp";
	}
	
	@RequestMapping("/delete")
	public String delete(String billNo) throws InterruptedException, ExecutionException {
		System.out.println("in update");
		
		System.out.println(saleService.deleteSale(billNo));
		
		return "home.jsp";
	}
	
	
	@RequestMapping("/getsales")
	public ModelAndView getSales(String billNo,double amount,String customerName) throws Exception{
		Sale sale=new Sale(billNo,amount,customerName);
		System.out.println(sale);
		List<Sale> sales= saleService.getSalesLike(sale);
		ModelAndView mv=new ModelAndView("showSales.jsp");
		mv.addObject("sales", sales);
		return mv;
	}
}
