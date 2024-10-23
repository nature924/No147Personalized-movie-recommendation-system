package com.entity.view;

import com.entity.DianyingpingfenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 电影评分
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-26 10:13:53
 */
@TableName("dianyingpingfen")
public class DianyingpingfenView  extends DianyingpingfenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DianyingpingfenView(){
	}
 
 	public DianyingpingfenView(DianyingpingfenEntity dianyingpingfenEntity){
 	try {
			BeanUtils.copyProperties(this, dianyingpingfenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
