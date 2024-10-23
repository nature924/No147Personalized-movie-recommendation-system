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

import com.entity.DianyingEntity;
import com.entity.view.DianyingView;

import com.service.DianyingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 电影
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-26 10:13:53
 */
@RestController
@RequestMapping("/dianying")
public class DianyingController {
    @Autowired
    private DianyingService dianyingService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DianyingEntity dianying,
		HttpServletRequest request){
        EntityWrapper<DianyingEntity> ew = new EntityWrapper<DianyingEntity>();

		PageUtils page = dianyingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianying), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DianyingEntity dianying, 
		HttpServletRequest request){
        EntityWrapper<DianyingEntity> ew = new EntityWrapper<DianyingEntity>();

		PageUtils page = dianyingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianying), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DianyingEntity dianying){
       	EntityWrapper<DianyingEntity> ew = new EntityWrapper<DianyingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dianying, "dianying")); 
        return R.ok().put("data", dianyingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DianyingEntity dianying){
        EntityWrapper< DianyingEntity> ew = new EntityWrapper< DianyingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dianying, "dianying")); 
		DianyingView dianyingView =  dianyingService.selectView(ew);
		return R.ok("查询电影成功").put("data", dianyingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DianyingEntity dianying = dianyingService.selectById(id);
		dianying.setClicknum(dianying.getClicknum()+1);
		dianying.setClicktime(new Date());
		dianyingService.updateById(dianying);
        return R.ok().put("data", dianying);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DianyingEntity dianying = dianyingService.selectById(id);
		dianying.setClicknum(dianying.getClicknum()+1);
		dianying.setClicktime(new Date());
		dianyingService.updateById(dianying);
        return R.ok().put("data", dianying);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DianyingEntity dianying, HttpServletRequest request){
    	dianying.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianying);
        dianyingService.insert(dianying);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DianyingEntity dianying, HttpServletRequest request){
    	dianying.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianying);
        dianyingService.insert(dianying);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DianyingEntity dianying, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dianying);
        dianyingService.updateById(dianying);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dianyingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DianyingEntity dianying, HttpServletRequest request,String pre){
        EntityWrapper<DianyingEntity> ew = new EntityWrapper<DianyingEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = dianyingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianying), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,DianyingEntity dianying, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "dianyingfenlei";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "dianying").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<DianyingEntity> dianyingList = new ArrayList<DianyingEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                dianyingList.addAll(dianyingService.selectList(new EntityWrapper<DianyingEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<DianyingEntity> ew = new EntityWrapper<DianyingEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = dianyingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianying), params), params));
        List<DianyingEntity> pageList = (List<DianyingEntity>)page.getList();
        if(dianyingList.size()<limit) {
            int toAddNum = (limit-dianyingList.size())<=pageList.size()?(limit-dianyingList.size()):pageList.size();
            for(DianyingEntity o1 : pageList) {
                boolean addFlag = true;
                for(DianyingEntity o2 : dianyingList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    dianyingList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(dianyingList.size()>limit) {
            dianyingList = dianyingList.subList(0, limit);
        }
        page.setList(dianyingList);
        return R.ok().put("data", page);
    }







}
