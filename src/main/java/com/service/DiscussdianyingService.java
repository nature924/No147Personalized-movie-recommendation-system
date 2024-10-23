package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussdianyingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussdianyingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussdianyingView;


/**
 * 电影评论表
 *
 * @author 
 * @email 
 * @date 2023-04-26 10:13:53
 */
public interface DiscussdianyingService extends IService<DiscussdianyingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussdianyingVO> selectListVO(Wrapper<DiscussdianyingEntity> wrapper);
   	
   	DiscussdianyingVO selectVO(@Param("ew") Wrapper<DiscussdianyingEntity> wrapper);
   	
   	List<DiscussdianyingView> selectListView(Wrapper<DiscussdianyingEntity> wrapper);
   	
   	DiscussdianyingView selectView(@Param("ew") Wrapper<DiscussdianyingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussdianyingEntity> wrapper);
   	

}

