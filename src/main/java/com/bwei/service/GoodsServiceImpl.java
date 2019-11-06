package com.bwei.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bwei.entity.Brand;
import com.bwei.entity.Goods;
import com.bwei.entity.GoodsKind;
import com.bwei.mapper.GoodsDao;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Resource
	private GoodsDao dao;
	
	public List<Goods> getGoodsList() {
		// TODO Auto-generated method stub
		return dao.getGoodsList();
	}

	public List<Brand> getBrandList() {
		// TODO Auto-generated method stub
		return dao.getBrandList();
	}

	public List<GoodsKind> getGoodsKindList(Integer bid) {
		// TODO Auto-generated method stub
		return dao.getGoodsKindList(bid);
	}

	public int dels(String dis) {
		// TODO Auto-generated method stub
		return dao.dels(dis);
	}

	public int add(Goods g) {
		// TODO Auto-generated method stub
		return dao.add(g);
	}

	public Goods getByIdList(Integer gid) {
		// TODO Auto-generated method stub
		return dao.getByIdList(gid);
	}

	public int update(Goods g) {
		// TODO Auto-generated method stub
		return dao.update(g);
	}

}
