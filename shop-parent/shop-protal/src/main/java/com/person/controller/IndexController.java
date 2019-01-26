package com.jiahua.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jiahua.entity.News;
import com.jiahua.entity.NewsParams;
import com.jiahua.entity.Product;
import com.jiahua.feign.NewsFegin;
import com.jiahua.feign.ProCateFeign;
import com.jiahua.feign.ProFeign;
import com.jiahua.utlis.ProductCategoryVo;

@Controller
public class IndexController {

	/**
	 * 調用新聞的Feign
	 */
	@Autowired
	private NewsFegin newsFeign;
	
	/**
	 * 調用產品的 feign
	 */
	@Autowired
	private ProCateFeign proCateFeign;
	@Autowired
	private ProFeign proFeign;
	
	
	@GetMapping("/")
	public String getIndexPage(@RequestParam(value="page",required=true,defaultValue="1") Integer page,
			@RequestParam(value="limit",required=true,defaultValue="10") Integer limit,
			Model model) throws Exception{
		 //查询商品分裂
        List<ProductCategoryVo> productCategoryVoList = proCateFeign.queryAllProductCategoryList().getDate();
        NewsParams params = new NewsParams();
       // params.openPage((pager.getCurrentPage() - 1) * pager.getRowPerPage(),pager.getRowPerPage());
        List<News> news = newsFeign.queryNewsList(params,page,limit).getDate().getList();
        Product product = new Product();
        //查询一楼
        for (ProductCategoryVo vo : productCategoryVoList) {
            List<Product> productList =  proFeign.getProductList(product,null,vo.getProductCategory().getId(),null,null).getDate().getList();
            vo.setProductList(productList);
        }
        //封装返回
        model.addAttribute("productCategoryVoList", productCategoryVoList);
        model.addAttribute("news", news);
		return "pre/index";
	}
}
