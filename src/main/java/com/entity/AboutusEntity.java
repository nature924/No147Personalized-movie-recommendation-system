package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 关于我们
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-04-26 10:13:53
 */
@TableName("aboutus")
public class AboutusEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public AboutusEntity() {
		
	}
	
	public AboutusEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 标题
	 */
					
	private String title;
	
	/**
	 * 副标题
	 */
					
	private String subtitle;
	
	/**
	 * 内容
	 */
					
	private String content;
	
	/**
	 * 图片1
	 */
					
	private String picture1;
	
	/**
	 * 图片2
	 */
					
	private String picture2;
	
	/**
	 * 图片3
	 */
					
	private String picture3;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：副标题
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	/**
	 * 获取：副标题
	 */
	public String getSubtitle() {
		return subtitle;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：图片1
	 */
	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}
	/**
	 * 获取：图片1
	 */
	public String getPicture1() {
		return picture1;
	}
	/**
	 * 设置：图片2
	 */
	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}
	/**
	 * 获取：图片2
	 */
	public String getPicture2() {
		return picture2;
	}
	/**
	 * 设置：图片3
	 */
	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}
	/**
	 * 获取：图片3
	 */
	public String getPicture3() {
		return picture3;
	}

}
