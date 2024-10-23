package com.dao;

import com.entity.AboutusEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.AboutusVO;
import com.entity.view.AboutusView;


/**
 * 关于我们
 * 
 * @author 
 * @email 
 * @date 2023-04-26 10:13:53
 */
public interface AboutusDao extends BaseMapper<AboutusEntity> {
	
	List<AboutusVO> selectListVO(@Param("ew") Wrapper<AboutusEntity> wrapper);
	
	AboutusVO selectVO(@Param("ew") Wrapper<AboutusEntity> wrapper);
	
	List<AboutusView> selectListView(@Param("ew") Wrapper<AboutusEntity> wrapper);

	List<AboutusView> selectListView(Pagination page,@Param("ew") Wrapper<AboutusEntity> wrapper);
	
	AboutusView selectView(@Param("ew") Wrapper<AboutusEntity> wrapper);
	

}
