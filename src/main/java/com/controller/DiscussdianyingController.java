package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussdianyingEntity;
import com.entity.view.DiscussdianyingView;

import com.service.DiscussdianyingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 电影评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-26 10:13:53
 */
@RestController
@RequestMapping("/discussdianying")
public class DiscussdianyingController {
    @Autowired
    private DiscussdianyingService discussdianyingService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussdianyingEntity discussdianying,
		HttpServletRequest request){
        EntityWrapper<DiscussdianyingEntity> ew = new EntityWrapper<DiscussdianyingEntity>();

		PageUtils page = discussdianyingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussdianying), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussdianyingEntity discussdianying, 
		HttpServletRequest request){
        EntityWrapper<DiscussdianyingEntity> ew = new EntityWrapper<DiscussdianyingEntity>();

		PageUtils page = discussdianyingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussdianying), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussdianyingEntity discussdianying){
       	EntityWrapper<DiscussdianyingEntity> ew = new EntityWrapper<DiscussdianyingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussdianying, "discussdianying")); 
        return R.ok().put("data", discussdianyingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussdianyingEntity discussdianying){
        EntityWrapper< DiscussdianyingEntity> ew = new EntityWrapper< DiscussdianyingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussdianying, "discussdianying")); 
		DiscussdianyingView discussdianyingView =  discussdianyingService.selectView(ew);
		return R.ok("查询电影评论表成功").put("data", discussdianyingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussdianyingEntity discussdianying = discussdianyingService.selectById(id);
        return R.ok().put("data", discussdianying);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussdianyingEntity discussdianying = discussdianyingService.selectById(id);
        return R.ok().put("data", discussdianying);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussdianyingEntity discussdianying, HttpServletRequest request){
    	discussdianying.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussdianying);
        discussdianyingService.insert(discussdianying);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussdianyingEntity discussdianying, HttpServletRequest request){
    	discussdianying.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussdianying);
        discussdianyingService.insert(discussdianying);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussdianyingEntity discussdianying, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussdianying);
        discussdianyingService.updateById(discussdianying);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussdianyingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
