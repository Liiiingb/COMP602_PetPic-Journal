package com.dao;

import com.entity.PetImageEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PetImageVO;
import com.entity.view.PetImageView;


/**
 * Pet Album
 * 
 * @author Jingzhao PIAO 
 * @email hcb1764@autuni.ac.nz
 * @date 2023-09-17
 */
public interface PetImageDao extends BaseMapper<PetImageEntity> {
	
	List<PetImageVO> selectListVO(@Param("ew") Wrapper<PetImageEntity> wrapper);
	
	PetImageVO selectVO(@Param("ew") Wrapper<PetImageEntity> wrapper);
	
	List<PetImageView> selectListView(@Param("ew") Wrapper<PetImageEntity> wrapper);

	List<PetImageView> selectListView(Pagination page,@Param("ew") Wrapper<PetImageEntity> wrapper);
	
	PetImageView selectView(@Param("ew") Wrapper<PetImageEntity> wrapper);
	

}
