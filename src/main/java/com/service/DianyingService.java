package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DianyingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DianyingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DianyingView;


/**
 * 电影
 *
 * @author 
 * @email 
 * @date 2023-04-26 10:13:53
 */
public interface DianyingService extends IService<DianyingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DianyingVO> selectListVO(Wrapper<DianyingEntity> wrapper);
   	
   	DianyingVO selectVO(@Param("ew") Wrapper<DianyingEntity> wrapper);
   	
   	List<DianyingView> selectListView(Wrapper<DianyingEntity> wrapper);
   	
   	DianyingView selectView(@Param("ew") Wrapper<DianyingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DianyingEntity> wrapper);
   	

}

