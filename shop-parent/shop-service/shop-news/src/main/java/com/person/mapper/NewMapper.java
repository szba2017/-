package com.jiahua.mapper;

import java.util.List;

import com.jiahua.entity.News;
import com.jiahua.entity.NewsParams;

public interface NewMapper {

	/**
	 * 添加新闻
	 * @param news
	 * @throws Exception
	 */
	 int add(News news) throws Exception;
	/**
	 * 修改新闻
	 * @param news
	 * @throws Exception
	 */
	 int update(News news) throws Exception;
	/**
	 * 根据id删除新闻
	 * @param id
	 * @throws Exception
	 */
	 int deleteById(Integer id) throws Exception;
	/**
	 * 根据id查询新闻
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public News getNewsById(Integer id)throws Exception; 
	/**
	 * 查询新闻列表
	 * @param params
	 * @return
	 * @throws Exception
	 */
	List<News> queryNewsList(NewsParams params)throws Exception; 
	/**
	 * 查询新闻的数目
	 * @param params
	 * @return
	 * @throws Exception
	 */
	Integer queryNewsCount(NewsParams params)throws Exception;

}
