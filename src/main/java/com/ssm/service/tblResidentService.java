package com.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.tblResidentMapper;
import com.ssm.entity.tblResident;

@Service
public class tblResidentService {
	@Autowired
    private tblResidentMapper residentMapper;
	public tblResident findById(int sid) {
		// TODO Auto-generated method stub
		return  residentMapper.selectByPrimaryKey(sid);
	}
	public List<tblResident> findByList(int start,int size) {
		// TODO Auto-generated method stub
		return  residentMapper.findList(start,size);
	}
	public int findBycount() {
		// TODO Auto-generated method stub
		return residentMapper.findBycount();
	}

}
