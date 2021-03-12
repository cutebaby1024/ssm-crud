package com.zhang.crud.service;

import com.zhang.crud.bean.Department;
import com.zhang.crud.dao.DepartmentMapper;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepts() {
        // TODO Auto-generated method stub
        List<Department> list = departmentMapper.selectByExample(null);
        return list;
    }

}
