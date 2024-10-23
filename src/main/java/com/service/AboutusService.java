package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.AboutusEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.AboutusVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.AboutusView;


/**
 * 关于我们
 *
 * @author 
 * @email 
 * @date 2023-04-26 10:13:53
 */
public interface AboutusService extends IService<AboutusEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<AboutusVO> selectListVO(Wrapper<AboutusEntity> wrapper);
   	
   	AboutusVO selectVO(@Param("ew") Wrapper<AboutusEntity> wrapper);
   	
   	List<AboutusView> selectListView(Wrapper<AboutusEntity> wrapper);
   	
   	AboutusView selectView(@Param("ew") Wrapper<AboutusEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<AboutusEntity> wrapper);
   	

}

