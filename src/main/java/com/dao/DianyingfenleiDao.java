package com.dao;

import com.entity.DianyingfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DianyingfenleiVO;
import com.entity.view.DianyingfenleiView;


/**
 * 电影分类
 * 
 * @author 
 * @email 
 * @date 2023-04-26 10:13:53
 */
public interface DianyingfenleiDao extends BaseMapper<DianyingfenleiEntity> {
	
	List<DianyingfenleiVO> selectListVO(@Param("ew") Wrapper<DianyingfenleiEntity> wrapper);
	
	DianyingfenleiVO selectVO(@Param("ew") Wrapper<DianyingfenleiEntity> wrapper);
	
	List<DianyingfenleiView> selectListView(@Param("ew") Wrapper<DianyingfenleiEntity> wrapper);

	List<DianyingfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<DianyingfenleiEntity> wrapper);
	
	DianyingfenleiView selectView(@Param("ew") Wrapper<DianyingfenleiEntity> wrapper);
	

}
