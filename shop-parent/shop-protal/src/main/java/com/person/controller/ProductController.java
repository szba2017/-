package com.jiahua.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.jiahua.entity.Product;
import com.jiahua.feign.ProCateFeign;
import com.jiahua.feign.ProFeign;
import com.jiahua.utlis.EmptyUtils;
import com.jiahua.utlis.ProductCategoryVo;

@Controller
public class ProductController {

	@Autowired
	private ProFeign proFeign;

	@Autowired
	private ProCateFeign proCateFeign;

	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") Integer id, Model model, HttpServletRequest request)
			throws Exception {
		Product product = proFeign.getProductById(Integer.valueOf(id)).getDate();

		List<ProductCategoryVo> productCategoryVoList = proCateFeign.queryAllProductCategoryList().getDate();
		model.addAttribute("product", product);
		model.addAttribute("productCategoryVoList", productCategoryVoList);
		addRecentProduct(request, product);
		return "/pre/product/productDeatil";
	}

	@RequestMapping("/queryProductList")
	public String queryProductList(@RequestParam("category") Integer category,
			// @RequestParam("level") Integer level,
			Model model) {
		Product p = new Product();
		p.setCategoryLevel1Id(category);
		List<ProductCategoryVo> productCategoryVoList = proCateFeign.queryAllProductCategoryList().getDate();
		List<Product> productList = proFeign.getProductList(p, null, null, null, null).getDate().getList();
		
		model.addAttribute("productList", productList);
		//model.addAttribute("pager", pageInfo.getPages());
		//model.addAttribute("total", pageInfo.getTotal());
		//model.addAttribute("keyWord", keyWord);
		model.addAttribute("productCategoryVoList", productCategoryVoList);
		return "/pre/product/queryProductList";
	}

	/**
	 * 添加最近浏览商品
	 * 
	 * @param request
	 * @param product
	 */
	private void addRecentProduct(HttpServletRequest request, Product product) throws Exception {
		HttpSession session = request.getSession();
		List<Product> recentProducts = queryRecentProducts(request);
		// 判断是否满了
		if (recentProducts.size() > 0 && recentProducts.size() == 10) {
			recentProducts.remove(0);
		}
		recentProducts.add(recentProducts.size(), product);
		session.setAttribute("recentProducts", recentProducts);
	}

	/**
	 * 查询最近商品
	 * 
	 * @return
	 */
	private List<Product> queryRecentProducts(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		List<Product> recentProducts = (List<Product>) session.getAttribute("recentProducts");
		if (EmptyUtils.isEmpty(recentProducts)) {
			recentProducts = new ArrayList<Product>();
		}
		return recentProducts;
	}
}
