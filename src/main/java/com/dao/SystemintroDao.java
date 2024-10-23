package com.dao;

import com.entity.SystemintroEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SystemintroVO;
import com.entity.view.SystemintroView;


/**
 * 关于我们
 * 
 * @author 
 * @email 
 * @date 2023-04-26 10:13:53
 */
public interface SystemintroDao extends BaseMapper<SystemintroEntity> {
	
	List<SystemintroVO> selectListVO(@Param("ew") Wrapper<SystemintroEntity> wrapper);
	
	SystemintroVO selectVO(@Param("ew") Wrapper<SystemintroEntity> wrapper);
	
	List<SystemintroView> selectListView(@Param("ew") Wrapper<SystemintroEntity> wrapper);

	List<SystemintroView> selectListView(Pagination page,@Param("ew") Wrapper<SystemintroEntity> wrapper);
	
	SystemintroView selectView(@Param("ew") Wrapper<SystemintroEntity> wrapper);
	

}
