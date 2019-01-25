package com.jiahua.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiahua.base.Response;
import com.jiahua.base.ResponseApi;
import com.jiahua.entity.News;
import com.jiahua.entity.NewsParams;
import com.jiahua.mapper.NewMapper;
@RestController
@Transactional
//@RequestMapping("/news")
public class NewServiceimpl<T> extends ResponseApi<T> implements NewsService{

	@Resource
	private NewMapper newMapper;
	
	/**
	 * 保存新闻
	 * @param news
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/addNews")
	public Response addNews(News news) throws Exception {
		news.setCreateTime(new Date());
		int num = newMapper.add(news);
		if(num>0){
			return setSuccess();
		}else{
			return setError();
		}
	}

	/**
	 * 根据id查询新闻
	 * @param parameter
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/findNewsById")
	public Response<News> findNewsById(Integer id) throws Exception {
		 News news = newMapper.getNewsById(id);
		 if(news != null){
			 return setSuccess(news);
		 }else{
			 return setError();
		 }
	}

	/**
	 * 删除新闻
	 * @param parameter
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/deleteNews")
	public Response deleteNews(Integer id) throws Exception{
		  int num = newMapper.deleteById(id);
		  if(num>0){
				return setSuccess();
			}else{
				return setError();
			}
	}

	/**
	 * 查询新闻列表
	 * @param param
	 * @return
	 */
	@RequestMapping("/queryNewsList")
	public Response<PageInfo<News>> queryNewsList(NewsParams param,
				@RequestParam(value="page",required=true,defaultValue="1") Integer page,
				@RequestParam(value="limit",required=true,defaultValue="10") Integer limit) throws Exception{
		PageHelper.startPage(page-1, limit); 
		List<News> newsList = newMapper.queryNewsList(param);
		PageInfo<News> pageInfo =new PageInfo<>(newsList);
		 if(newsList != null){
			 return setSuccess(pageInfo);
		 }else{
			 return setError();
		 }
	}

	/**
	 * 修改新闻
	 * @param news
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/update")
	public Response update(News news) throws Exception {
		 int num = newMapper.update(news);
		 if(num>0){
				return setSuccess();
			}else{
				return setError();
			}
	}

}
