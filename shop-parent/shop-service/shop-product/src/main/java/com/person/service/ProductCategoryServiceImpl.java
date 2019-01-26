package com.jiahua.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiahua.base.Response;
import com.jiahua.base.ResponseApi;
import com.jiahua.entity.ProductCategory;
import com.jiahua.entity.ProductCategoryParam;
import com.jiahua.mapper.ProductCategoryMapper;
import com.jiahua.utlis.Constants;
import com.jiahua.utlis.ProductCategoryVo;

/**
 * 商品的分类
 */
@RestController
@Transactional
public class ProductCategoryServiceImpl<T> extends ResponseApi<T> implements ProductCategoryService{

	@Resource
	private ProductCategoryMapper proCatMapper;
	
	/**
     * 根据id查询商品分类
     * @param id
     * @return
     */
	@RequestMapping("/getById")
	public Response<ProductCategory> getById(Integer id) {
		ProductCategory category = proCatMapper.queryProductCategoryById(id);
		if(category != null){
			return setSuccess(category);
		}
		return setError();
	}

	/**
     * 查询商品分类列表
     * @param params
     * @return
     */
	@RequestMapping("/queryProCategoryList")
	public Response<PageInfo<ProductCategory>> queryProCategoryList(ProductCategoryParam params,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "limit", required = true, defaultValue = "10") Integer limit) {
		PageHelper.startPage(page-1, limit);
		List<ProductCategory> list = proCatMapper.queryCatelist(params);
		PageInfo<ProductCategory> pageInfo = new PageInfo<ProductCategory>();
		if(list.size()>0){
			return setSuccess(pageInfo);
		}else{
			return setError();
		}
	}

	/**
     * 查询数目
     * @param params
     * @return
     */
	@RequestMapping("/queryProductCategoryCount")
	public String queryProductCategoryCount(ProductCategoryParam params) {
		return  null;
	}

	/**
     * 修改商品分类
     * @param params
     */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/modifyProductCategory")
	public Response modifyProductCategory(ProductCategory productCategory) {
		Integer num = proCatMapper.modify(productCategory);
		if(num>0){
			return setSuccess();
		}else{
			return setError();
		}	
	}

	/**
     * 添加商品分类
     * @param params
     */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/addProductCategory")
	public Response addProductCategory(ProductCategory productCategory) {
		Integer num = proCatMapper.add(productCategory);
		if(num>0){
			return setSuccess();
		}else{
			return setError();
		}
	}

	/**
     * 根据id删除
     * @param id
     */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/deleteById")
	public Response deleteById(Integer id) {
		int num = proCatMapper.delete(id);
		if(num>0){
			return setSuccess();
		}else{
			return setError();
		}
	}

	/**
     * 查询全部的商品分类
     * @return
     */
	@RequestMapping("/queryAllProductCategoryList")
	public Response<List<ProductCategoryVo>> queryAllProductCategoryList() {
		//查询一级分类的列表
        List<ProductCategoryVo> productCategory1VoList = new ArrayList<ProductCategoryVo>();
        //查询一级分类
        List<ProductCategory> productCategory1List = queryCategorylist(null);
        //查询二级分类
        for (ProductCategory product1Category : productCategory1List) {
            //封装一级分类
            ProductCategoryVo productCategoryVo = new ProductCategoryVo();
            productCategoryVo.setProductCategory(product1Category);
            List<ProductCategoryVo> productCategoryVo1ChildList = new ArrayList<ProductCategoryVo>();
            //根据一级分类查询二级分类
            List<ProductCategory> productCategory2List = queryCategorylist(product1Category.getId());
            for (ProductCategory productCategory2 : productCategory2List) {
                ProductCategoryVo productCategoryVo2 = new ProductCategoryVo();
                productCategoryVo1ChildList.add(productCategoryVo2);
                productCategoryVo2.setProductCategory(productCategory2);
                List<ProductCategoryVo> productCategoryVo2ChildList = new ArrayList<ProductCategoryVo>();
                productCategoryVo2.setProductCategoryVoList(productCategoryVo2ChildList);
                //根据二级分类查询三级分类的列表
                List<ProductCategory> productCategory3List = queryCategorylist(productCategory2.getId());
                for (ProductCategory productCategory3 : productCategory3List) {
                    ProductCategoryVo productCategoryVo3 = new ProductCategoryVo();
                    productCategoryVo3.setProductCategory(productCategory3);
                    productCategoryVo2ChildList.add(productCategoryVo3);
                }
            }
            productCategoryVo.setProductCategoryVoList(productCategoryVo1ChildList);
            productCategory1VoList.add(productCategoryVo);
        }
        return setSuccess(productCategory1VoList);
	}

	 /**
     * 查询子分类
     * @param parentId
     * @return
     */
	@RequestMapping("/getProductCat")
    public List<ProductCategory> queryCategorylist(@RequestParam(value="parentId",required =true,defaultValue="0") Integer parentId) {//根据父ID查询所有子商品分类
        List<ProductCategory> productCategoryList = null;
        try {
            ProductCategoryParam params = new ProductCategoryParam();
            	if(parentId == null){
            		parentId = 0;
            	}
            	params.setParentId(parentId);
            productCategoryList = proCatMapper.queryCatelist(params);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
            return productCategoryList;
    }

}
