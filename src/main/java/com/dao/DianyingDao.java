package com.dao;

import com.entity.DianyingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DianyingVO;
import com.entity.view.DianyingView;


/**
 * 电影
 * 
 * @author 
 * @email 
 * @date 2023-04-26 10:13:53
 */
public interface DianyingDao extends BaseMapper<DianyingEntity> {
	
	List<DianyingVO> selectListVO(@Param("ew") Wrapper<DianyingEntity> wrapper);
	
	DianyingVO selectVO(@Param("ew") Wrapper<DianyingEntity> wrapper);
	
	List<DianyingView> selectListView(@Param("ew") Wrapper<DianyingEntity> wrapper);

	List<DianyingView> selectListView(Pagination page,@Param("ew") Wrapper<DianyingEntity> wrapper);
	
	DianyingView selectView(@Param("ew") Wrapper<DianyingEntity> wrapper);
	

}
