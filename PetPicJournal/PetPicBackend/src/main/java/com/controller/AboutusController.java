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
import java.io.IOException;

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

import com.entity.AboutusEntity;
import com.entity.view.AboutusView;

import com.service.AboutusService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;

/**
 * About us
 * @author 
 * @email 
 * @date 2023-08-26 17:38:30
 */
@RestController
@RequestMapping("/aboutus")
public class AboutusController {
    @Autowired
    private AboutusService aboutusService;





    


    /**
     * page
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,AboutusEntity aboutus, 
		HttpServletRequest request){

        EntityWrapper<AboutusEntity> ew = new EntityWrapper<AboutusEntity>();


		PageUtils page = aboutusService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, aboutus), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * list
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,AboutusEntity aboutus, 
		HttpServletRequest request){
        EntityWrapper<AboutusEntity> ew = new EntityWrapper<AboutusEntity>();

		PageUtils page = aboutusService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, aboutus), params), params));
        return R.ok().put("data", page);
    }

	/**
     * list
     */
    @RequestMapping("/lists")
    public R list( AboutusEntity aboutus){
       	EntityWrapper<AboutusEntity> ew = new EntityWrapper<AboutusEntity>();
      	ew.allEq(MPUtil.allEQMapPre( aboutus, "aboutus")); 
        return R.ok().put("data", aboutusService.selectListView(ew));
    }

	 /**
     * Search
     */
    @RequestMapping("/query")
    public R query(AboutusEntity aboutus){
        EntityWrapper< AboutusEntity> ew = new EntityWrapper< AboutusEntity>();
 		ew.allEq(MPUtil.allEQMapPre( aboutus, "aboutus")); 
		AboutusView aboutusView =  aboutusService.selectView(ew);
		return R.ok("Query about our success").put("data", aboutusView);
    }
	
    /**
     * Details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        AboutusEntity aboutus = aboutusService.selectById(id);
        return R.ok().put("data", aboutus);
    }
    

    /**
     * Modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody AboutusEntity aboutus, HttpServletRequest request){
        //ValidatorUtils.validateEntity(aboutus);
        aboutusService.updateById(aboutus);//All  
        return R.ok();
    }

    /**
     * Details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        AboutusEntity aboutus = aboutusService.selectById(id);
        return R.ok().put("data", aboutus);
    }
    



    /**
     * save
     */
    @RequestMapping("/save")
    public R save(@RequestBody AboutusEntity aboutus, HttpServletRequest request){
    	aboutus.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(aboutus);

        aboutusService.insert(aboutus);
        return R.ok();
    }
    
    /**
     * save
     */
    @RequestMapping("/add")
    public R add(@RequestBody AboutusEntity aboutus, HttpServletRequest request){
    	aboutus.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(aboutus);

        aboutusService.insert(aboutus);
        return R.ok();
    }



    
    

    /**
     * Delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        aboutusService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
