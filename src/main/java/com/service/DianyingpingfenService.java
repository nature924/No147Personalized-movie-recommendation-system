package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DianyingpingfenEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DianyingpingfenVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DianyingpingfenView;


/**
 * 电影评分
 *
 * @author 
 * @email 
 * @date 2023-04-26 10:13:53
 */
public interface DianyingpingfenService extends IService<DianyingpingfenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DianyingpingfenVO> selectListVO(Wrapper<DianyingpingfenEntity> wrapper);
   	
   	DianyingpingfenVO selectVO(@Param("ew") Wrapper<DianyingpingfenEntity> wrapper);
   	
   	List<DianyingpingfenView> selectListView(Wrapper<DianyingpingfenEntity> wrapper);
   	
   	DianyingpingfenView selectView(@Param("ew") Wrapper<DianyingpingfenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DianyingpingfenEntity> wrapper);
   	

}

