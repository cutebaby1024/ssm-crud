package com.zhang.crud.test;

import com.zhang.crud.bean.Department;
import com.zhang.crud.bean.Employee;
import com.zhang.crud.dao.DepartmentMapper;
import com.zhang.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void testCURD(){
      /*  ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);*/
        System.out.println(departmentMapper);
       /* departmentMapper.insertSelective(new Department(null, "开发部"));
     	departmentMapper.insertSelective(new Department(null, "测试部"));*/

/*        employeeMapper.insertSelective(new Employee(null, "Jerry", "M", "Jerry@zhang.com", 1));*/



        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for(int i = 0;i<1000;i++){
            String uid = UUID.randomUUID().toString().substring(0,5)+i;
            mapper.insertSelective(new Employee(null,uid, "M", uid+"@zhang.com", 1));
        }
        System.out.println("批量完成");
    }
}
