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

import com.entity.DianyingfenleiEntity;
import com.entity.view.DianyingfenleiView;

import com.service.DianyingfenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 电影分类
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-26 10:13:53
 */
@RestController
@RequestMapping("/dianyingfenlei")
public class DianyingfenleiController {
    @Autowired
    private DianyingfenleiService dianyingfenleiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DianyingfenleiEntity dianyingfenlei,
		HttpServletRequest request){
        EntityWrapper<DianyingfenleiEntity> ew = new EntityWrapper<DianyingfenleiEntity>();

		PageUtils page = dianyingfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianyingfenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DianyingfenleiEntity dianyingfenlei, 
		HttpServletRequest request){
        EntityWrapper<DianyingfenleiEntity> ew = new EntityWrapper<DianyingfenleiEntity>();

		PageUtils page = dianyingfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianyingfenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DianyingfenleiEntity dianyingfenlei){
       	EntityWrapper<DianyingfenleiEntity> ew = new EntityWrapper<DianyingfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dianyingfenlei, "dianyingfenlei")); 
        return R.ok().put("data", dianyingfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DianyingfenleiEntity dianyingfenlei){
        EntityWrapper< DianyingfenleiEntity> ew = new EntityWrapper< DianyingfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dianyingfenlei, "dianyingfenlei")); 
		DianyingfenleiView dianyingfenleiView =  dianyingfenleiService.selectView(ew);
		return R.ok("查询电影分类成功").put("data", dianyingfenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DianyingfenleiEntity dianyingfenlei = dianyingfenleiService.selectById(id);
        return R.ok().put("data", dianyingfenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DianyingfenleiEntity dianyingfenlei = dianyingfenleiService.selectById(id);
        return R.ok().put("data", dianyingfenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DianyingfenleiEntity dianyingfenlei, HttpServletRequest request){
    	dianyingfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianyingfenlei);
        dianyingfenleiService.insert(dianyingfenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DianyingfenleiEntity dianyingfenlei, HttpServletRequest request){
    	dianyingfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianyingfenlei);
        dianyingfenleiService.insert(dianyingfenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DianyingfenleiEntity dianyingfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dianyingfenlei);
        dianyingfenleiService.updateById(dianyingfenlei);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dianyingfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
