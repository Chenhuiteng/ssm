package com.ssm.controller;

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

@Controller
@RequestMapping("/test")
public class tblResidentController {
	@Autowired
	private tblResidentService residentService;
/**
 * ����json ��ʽ
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
 * ����ҳ��
 * @return http://localhost:8080/test/helloPage
 */
@RequestMapping(value="/helloPage")
public String helloPage() {
	return "hello";
}
/**
 *����json ��ǰ�˵���
 * return tblResident  http://localhost:8080/test/findId/1
 */
@RequestMapping(value="/findId/{sid}")
@ResponseBody
public tblResident findById(@PathVariable int sid){
	
	return residentService.findById(sid);
}

/**
 * ����json ��ǰ�˵��� �Զ���
 * return List http://localhost:8080/test/findByList?sid=1
 */
@RequestMapping(value="/findByList")
@ResponseBody
public List<tblResident> findByList(@RequestParam("sid")  int sid){
	
	return residentService.findByList(sid);
}
}