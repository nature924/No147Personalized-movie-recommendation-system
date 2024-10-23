package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SystemintroEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SystemintroVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SystemintroView;


/**
 * 关于我们
 *
 * @author 
 * @email 
 * @date 2023-04-26 10:13:53
 */
public interface SystemintroService extends IService<SystemintroEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SystemintroVO> selectListVO(Wrapper<SystemintroEntity> wrapper);
   	
   	SystemintroVO selectVO(@Param("ew") Wrapper<SystemintroEntity> wrapper);
   	
   	List<SystemintroView> selectListView(Wrapper<SystemintroEntity> wrapper);
   	
   	SystemintroView selectView(@Param("ew") Wrapper<SystemintroEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SystemintroEntity> wrapper);
   	

}

