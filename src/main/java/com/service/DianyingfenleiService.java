package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DianyingfenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DianyingfenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DianyingfenleiView;


/**
 * 电影分类
 *
 * @author 
 * @email 
 * @date 2023-04-26 10:13:53
 */
public interface DianyingfenleiService extends IService<DianyingfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DianyingfenleiVO> selectListVO(Wrapper<DianyingfenleiEntity> wrapper);
   	
   	DianyingfenleiVO selectVO(@Param("ew") Wrapper<DianyingfenleiEntity> wrapper);
   	
   	List<DianyingfenleiView> selectListView(Wrapper<DianyingfenleiEntity> wrapper);
   	
   	DianyingfenleiView selectView(@Param("ew") Wrapper<DianyingfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DianyingfenleiEntity> wrapper);
   	

}

