package com.bwei.service;

import java.util.List;

import com.bwei.entity.Brand;
import com.bwei.entity.Goods;
import com.bwei.entity.GoodsKind;

public interface GoodsService {

	List<Goods> getGoodsList();
	
	List<Brand> getBrandList();
	
	List<GoodsKind> getGoodsKindList(Integer bid);
	
	int dels(String dis);
	
	int add(Goods g);
	
	Goods getByIdList(Integer gid);
	
	int update(Goods g);
}
