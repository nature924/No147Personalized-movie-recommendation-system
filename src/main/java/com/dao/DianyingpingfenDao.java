package com.dao;

import com.entity.DianyingpingfenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DianyingpingfenVO;
import com.entity.view.DianyingpingfenView;


/**
 * 电影评分
 * 
 * @author 
 * @email 
 * @date 2023-04-26 10:13:53
 */
public interface DianyingpingfenDao extends BaseMapper<DianyingpingfenEntity> {
	
	List<DianyingpingfenVO> selectListVO(@Param("ew") Wrapper<DianyingpingfenEntity> wrapper);
	
	DianyingpingfenVO selectVO(@Param("ew") Wrapper<DianyingpingfenEntity> wrapper);
	
	List<DianyingpingfenView> selectListView(@Param("ew") Wrapper<DianyingpingfenEntity> wrapper);

	List<DianyingpingfenView> selectListView(Pagination page,@Param("ew") Wrapper<DianyingpingfenEntity> wrapper);
	
	DianyingpingfenView selectView(@Param("ew") Wrapper<DianyingpingfenEntity> wrapper);
	

}
