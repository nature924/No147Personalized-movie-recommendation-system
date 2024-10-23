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


import com.dao.SystemintroDao;
import com.entity.SystemintroEntity;
import com.service.SystemintroService;
import com.entity.vo.SystemintroVO;
import com.entity.view.SystemintroView;

@Service("systemintroService")
public class SystemintroServiceImpl extends ServiceImpl<SystemintroDao, SystemintroEntity> implements SystemintroService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SystemintroEntity> page = this.selectPage(
                new Query<SystemintroEntity>(params).getPage(),
                new EntityWrapper<SystemintroEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SystemintroEntity> wrapper) {
		  Page<SystemintroView> page =new Query<SystemintroView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<SystemintroVO> selectListVO(Wrapper<SystemintroEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SystemintroVO selectVO(Wrapper<SystemintroEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SystemintroView> selectListView(Wrapper<SystemintroEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SystemintroView selectView(Wrapper<SystemintroEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
