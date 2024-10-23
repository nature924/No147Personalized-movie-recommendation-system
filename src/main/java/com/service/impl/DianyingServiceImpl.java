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


import com.dao.DianyingDao;
import com.entity.DianyingEntity;
import com.service.DianyingService;
import com.entity.vo.DianyingVO;
import com.entity.view.DianyingView;

@Service("dianyingService")
public class DianyingServiceImpl extends ServiceImpl<DianyingDao, DianyingEntity> implements DianyingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DianyingEntity> page = this.selectPage(
                new Query<DianyingEntity>(params).getPage(),
                new EntityWrapper<DianyingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DianyingEntity> wrapper) {
		  Page<DianyingView> page =new Query<DianyingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DianyingVO> selectListVO(Wrapper<DianyingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DianyingVO selectVO(Wrapper<DianyingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DianyingView> selectListView(Wrapper<DianyingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DianyingView selectView(Wrapper<DianyingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
