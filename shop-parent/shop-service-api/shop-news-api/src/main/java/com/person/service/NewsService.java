package com.jiahua.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.jiahua.base.Response;
import com.jiahua.entity.News;
import com.jiahua.entity.NewsParams;

/**
 *  新闻的接口
 */
public interface NewsService{
	
	/**
	 * 保存新闻
	 * @param news
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/addNews")
	Response addNews(@RequestBody(required = false) News news) throws Exception;//保存新闻
	/**
	 * 根据id查询新闻
	 * @param parameter
	 * @return
	 */
	@RequestMapping("/findNewsById")
	Response<News> findNewsById(@RequestParam(value="id")Integer id) throws Exception;
	
	/**
	 * 删除新闻
	 * @param parameter
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/deleteNews")
	Response deleteNews(@RequestParam(value="id") Integer id) throws Exception;
	
	/**
	 * 修改新闻
	 * @param news
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/update")
	Response update(@RequestBody(required = false) News news) throws Exception;
	
	/**
	 * 查询新闻列表
	 * @param param
	 * @return
	 */
	@RequestMapping("/queryNewsList")
	Response<PageInfo<News>> queryNewsList(@RequestBody(required = false) NewsParams param,@RequestParam("page") Integer page,@RequestParam("limit") Integer limit) throws Exception;
	
}
