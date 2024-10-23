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


import com.dao.DianyingpingfenDao;
import com.entity.DianyingpingfenEntity;
import com.service.DianyingpingfenService;
import com.entity.vo.DianyingpingfenVO;
import com.entity.view.DianyingpingfenView;

@Service("dianyingpingfenService")
public class DianyingpingfenServiceImpl extends ServiceImpl<DianyingpingfenDao, DianyingpingfenEntity> implements DianyingpingfenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DianyingpingfenEntity> page = this.selectPage(
                new Query<DianyingpingfenEntity>(params).getPage(),
                new EntityWrapper<DianyingpingfenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DianyingpingfenEntity> wrapper) {
		  Page<DianyingpingfenView> page =new Query<DianyingpingfenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DianyingpingfenVO> selectListVO(Wrapper<DianyingpingfenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DianyingpingfenVO selectVO(Wrapper<DianyingpingfenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DianyingpingfenView> selectListView(Wrapper<DianyingpingfenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DianyingpingfenView selectView(Wrapper<DianyingpingfenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
