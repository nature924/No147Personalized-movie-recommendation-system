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


import com.dao.DianyingfenleiDao;
import com.entity.DianyingfenleiEntity;
import com.service.DianyingfenleiService;
import com.entity.vo.DianyingfenleiVO;
import com.entity.view.DianyingfenleiView;

@Service("dianyingfenleiService")
public class DianyingfenleiServiceImpl extends ServiceImpl<DianyingfenleiDao, DianyingfenleiEntity> implements DianyingfenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DianyingfenleiEntity> page = this.selectPage(
                new Query<DianyingfenleiEntity>(params).getPage(),
                new EntityWrapper<DianyingfenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DianyingfenleiEntity> wrapper) {
		  Page<DianyingfenleiView> page =new Query<DianyingfenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DianyingfenleiVO> selectListVO(Wrapper<DianyingfenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DianyingfenleiVO selectVO(Wrapper<DianyingfenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DianyingfenleiView> selectListView(Wrapper<DianyingfenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DianyingfenleiView selectView(Wrapper<DianyingfenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
