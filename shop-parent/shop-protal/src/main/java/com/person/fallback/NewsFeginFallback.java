package com.jiahua.fallback;

import org.springframework.stereotype.Component;

import com.github.pagehelper.PageInfo;
import com.jiahua.base.Response;
import com.jiahua.base.ResponseApi;
import com.jiahua.entity.News;
import com.jiahua.entity.NewsParams;
import com.jiahua.feign.NewsFegin;

/**
 * news 的熔断
 *
 */
@SuppressWarnings("rawtypes")
@Component
public class NewsFeginFallback extends ResponseApi implements NewsFegin{

	@Override
	public Response addNews(News news) throws Exception {
		return setWait();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Response<News> findNewsById(Integer id) throws Exception {
		return setWait();
	}

	@Override
	public Response deleteNews(Integer id) throws Exception {
		return setWait();
	}

	@Override
	public Response update(News news) throws Exception {
		return setWait();
	}

	@Override
	public Response<PageInfo<News>> queryNewsList(NewsParams param, Integer page, Integer limit) throws Exception {
		return setWait();
	}

}
