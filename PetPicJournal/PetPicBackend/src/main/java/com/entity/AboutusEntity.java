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
 * @author 
 * @email 
 * @date 2023-08-26 17:38:30
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
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * title
	 */
					
	private String title;
	
	/**
	 * subtitle
	 */
					
	private String subtitle;
	
	/**
	 *   
	 */
					
	private String content;
	
	/**
	 * Img1
	 */
					
	private String picture1;
	
	/**
	 * Img2
	 */
					
	private String picture2;
	
	/**
	 * Img3
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
	 *   ：title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 *   ：title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 *   ：subtitle
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	/**
	 *   ：subtitle
	 */
	public String getSubtitle() {
		return subtitle;
	}
	/**
	 *   ：  
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 *   ：  
	 */
	public String getContent() {
		return content;
	}
	/**
	 *   ：Img1
	 */
	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}
	/**
	 *   ：Img1
	 */
	public String getPicture1() {
		return picture1;
	}
	/**
	 *   ：Img2
	 */
	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}
	/**
	 *   ：Img2
	 */
	public String getPicture2() {
		return picture2;
	}
	/**
	 *   ：Img3
	 */
	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}
	/**
	 *   ：Img3
	 */
	public String getPicture3() {
		return picture3;
	}

}
