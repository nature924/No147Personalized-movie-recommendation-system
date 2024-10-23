package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.AboutusDao;
import com.entity.AboutusEntity;
import com.service.AboutusService;
import com.entity.vo.AboutusVO;
import com.entity.view.AboutusView;

@Service("aboutusService")
public class AboutusServiceImpl extends ServiceImpl<AboutusDao, AboutusEntity> implements AboutusService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AboutusEntity> page = this.selectPage(
                new Query<AboutusEntity>(params).getPage(),
                new EntityWrapper<AboutusEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<AboutusEntity> wrapper) {
		  Page<AboutusView> page =new Query<AboutusView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<AboutusVO> selectListVO(Wrapper<AboutusEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public AboutusVO selectVO(Wrapper<AboutusEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<AboutusView> selectListView(Wrapper<AboutusEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public AboutusView selectView(Wrapper<AboutusEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
