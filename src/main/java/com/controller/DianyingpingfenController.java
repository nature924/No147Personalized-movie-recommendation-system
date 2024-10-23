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

import com.entity.DianyingpingfenEntity;
import com.entity.view.DianyingpingfenView;

import com.service.DianyingpingfenService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 电影评分
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-26 10:13:53
 */
@RestController
@RequestMapping("/dianyingpingfen")
public class DianyingpingfenController {
    @Autowired
    private DianyingpingfenService dianyingpingfenService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DianyingpingfenEntity dianyingpingfen,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			dianyingpingfen.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DianyingpingfenEntity> ew = new EntityWrapper<DianyingpingfenEntity>();

		PageUtils page = dianyingpingfenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianyingpingfen), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DianyingpingfenEntity dianyingpingfen, 
		HttpServletRequest request){
        EntityWrapper<DianyingpingfenEntity> ew = new EntityWrapper<DianyingpingfenEntity>();

		PageUtils page = dianyingpingfenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianyingpingfen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DianyingpingfenEntity dianyingpingfen){
       	EntityWrapper<DianyingpingfenEntity> ew = new EntityWrapper<DianyingpingfenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dianyingpingfen, "dianyingpingfen")); 
        return R.ok().put("data", dianyingpingfenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DianyingpingfenEntity dianyingpingfen){
        EntityWrapper< DianyingpingfenEntity> ew = new EntityWrapper< DianyingpingfenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dianyingpingfen, "dianyingpingfen")); 
		DianyingpingfenView dianyingpingfenView =  dianyingpingfenService.selectView(ew);
		return R.ok("查询电影评分成功").put("data", dianyingpingfenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DianyingpingfenEntity dianyingpingfen = dianyingpingfenService.selectById(id);
        return R.ok().put("data", dianyingpingfen);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DianyingpingfenEntity dianyingpingfen = dianyingpingfenService.selectById(id);
        return R.ok().put("data", dianyingpingfen);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DianyingpingfenEntity dianyingpingfen, HttpServletRequest request){
    	dianyingpingfen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianyingpingfen);
        dianyingpingfenService.insert(dianyingpingfen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DianyingpingfenEntity dianyingpingfen, HttpServletRequest request){
    	dianyingpingfen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianyingpingfen);
        dianyingpingfenService.insert(dianyingpingfen);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DianyingpingfenEntity dianyingpingfen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dianyingpingfen);
        dianyingpingfenService.updateById(dianyingpingfen);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dianyingpingfenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
