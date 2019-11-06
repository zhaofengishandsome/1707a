package com.bwei.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bwei.entity.Brand;
import com.bwei.entity.Goods;
import com.bwei.entity.GoodsKind;
import com.bwei.service.GoodsService;
import com.bwei.utils.FileUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class MyController {

	@Resource
	private GoodsService ser;
	
	@RequestMapping("/list")
	public String getGoodsList(@RequestParam(defaultValue="1")Integer pageNum,Model m){
		
		PageHelper.startPage(pageNum, 3);
		List<Goods> list = ser.getGoodsList();
		
		PageInfo<Goods> page = new PageInfo<Goods>(list);
		
		m.addAttribute("page", page);
		
		return "list";
	}
	
	@RequestMapping("/dels")
	@ResponseBody
	public int dels(String ids){
		return ser.dels(ids);
	}
	
	@RequestMapping("/toAdd")
	public String toAdd(Model m){
		m.addAttribute("goods", new Goods());
		
		return "add";
	}
	
	@RequestMapping("/getBrandList")
	@ResponseBody
	public List<Brand> getBrandList(){
		List<Brand> list = ser.getBrandList();
		
		return list;
	}
	
	@RequestMapping("/getGoodsKindList")
	@ResponseBody
	public List<GoodsKind> getGoodsKindList(Integer bid){
		System.out.println(bid);
		List<GoodsKind> list = ser.getGoodsKindList(bid);
		for (GoodsKind goodsKind : list) {
			System.out.println(goodsKind);
		}
		
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("/add")
	public String add(Goods g,MultipartFile file) throws IllegalStateException, IOException{
		String string = FileUtils.upload(file);
		
		g.setImg(string);
		
		int add = ser.add(g);
		
		if(add>0){
			return "redirect:/list";
		}
		
		return "add";
	}
	
	@RequestMapping("/lookingImg")
	public void looking(String path,HttpServletRequest request,HttpServletResponse response){
		FileUtils.lookImg(path, request, response);
	}
	
	@RequestMapping("/toUpdate")
	public String toUpdate(Model m,Integer gid){
		
		Goods goods = ser.getByIdList(gid);
		
		m.addAttribute("goods", goods);
		
		return "update";
	}
	
	@RequestMapping("/update")
	public String update(Goods g,MultipartFile file,String pa) throws IllegalStateException, IOException{
		
		try {
			g.setImg(pa);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String string = FileUtils.upload(file);
		
		g.setImg(string);

		
		
		int add = ser.update(g);
		
		if(add>0){
			return "redirect:/list";
		}
		
		return "update";
	}
}
