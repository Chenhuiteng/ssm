package com.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.entity.tblResident;
import com.ssm.service.tblResidentService;
import com.ssm.utils.Result;

@Controller
@RequestMapping("/test")
public class tblResidentController {
	@Autowired
	private tblResidentService residentService;
/**
 * 返回json 格式
 * @return http://localhost:8080/test/hello
 */
@RequestMapping(value="/hello")
@ResponseBody
public Map<String,Object> helloWorld() {
	Map<String,Object> map=new HashMap<String,Object>();
	map.put("code", "1");
	map.put("message", "success");
	return map;
	
}
/**
 * 返回页面
 * @return http://localhost:8080/test/helloPage
 */
@RequestMapping(value="/helloPage")
public String helloPage() {
	return "hello";
}
/**
 * 返回页面  动态加载表格数据
 * @return http://localhost:8080/test/testTablePage
 */
@RequestMapping(value="/testTablePage")
public String testTablePage() {
	return "testTable";
}
/**
 *返回json 给前端调用
 * return tblResident  http://localhost:8080/test/findId/1
 */
@RequestMapping(value="/findId/{sid}")
@ResponseBody
public tblResident findById(@PathVariable int sid){
	
	return residentService.findById(sid);
}

/**
 * 返回json 给前端调用  分页
 * return List http://localhost:8080/test/findByList?sid=1
 */
@RequestMapping(value="/findByList")
@ResponseBody
public Map<String,Object> findByList(@RequestParam("sid")  int sid,@RequestParam (value="page") String pageno, @RequestParam (value="limit") String pagesize){
	Map<String,Object> map=new HashMap<String,Object>();
	//当前页
    Integer page = Integer.parseInt(pageno.trim());
    //每页的数量
    Integer size = Integer.parseInt(pagesize.trim());
    int start=(page - 1) * size;  //当前页的数量
	List<tblResident> list=residentService.findByList(sid,start,size);
	int count=residentService.findBycount(sid);
	 map.put("code", -1);
	 map.put("msg", "error");
	 map.put("data", new ArrayList<tblResident>());
	 map.put("count",0);
	 if(!list.isEmpty()) {
		 map.put("code", 0);
		 map.put("msg", "success");
		 map.put("data", list);
		 map.put("count",count);
	    }
	
	return map;
}
}
