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


import com.dao.DiscussdianyingDao;
import com.entity.DiscussdianyingEntity;
import com.service.DiscussdianyingService;
import com.entity.vo.DiscussdianyingVO;
import com.entity.view.DiscussdianyingView;

@Service("discussdianyingService")
public class DiscussdianyingServiceImpl extends ServiceImpl<DiscussdianyingDao, DiscussdianyingEntity> implements DiscussdianyingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussdianyingEntity> page = this.selectPage(
                new Query<DiscussdianyingEntity>(params).getPage(),
                new EntityWrapper<DiscussdianyingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussdianyingEntity> wrapper) {
		  Page<DiscussdianyingView> page =new Query<DiscussdianyingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussdianyingVO> selectListVO(Wrapper<DiscussdianyingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussdianyingVO selectVO(Wrapper<DiscussdianyingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussdianyingView> selectListView(Wrapper<DiscussdianyingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussdianyingView selectView(Wrapper<DiscussdianyingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
