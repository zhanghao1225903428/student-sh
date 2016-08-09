package service.impl;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import entity.Students;
import junit.framework.Assert;
import service.StudentsDAO;

public class TestStudentDAOimpl {
	@Test
	public void testqueryAllStudents()
	{
	   StudentsDAO sdo=new StudentDAOimpl();
	   List<Students>list=sdo.queryAllStudents();
	   for(Students students:list)
		   System.out.println(students.toString());
	}
	@Test
	public void testgetmaxid()
	{
		StudentDAOimpl sDao=new StudentDAOimpl();
		System.out.println(sDao.getmaxid());
	}
	@Test
	public void testaddStudents()
	{
		Students students=new Students();
		students.setSname("zhangsan");
		students.setGender("ÄÐ");
		students.setBirthday(new Date());
		students.setAddress("±±¾©");
		StudentsDAO sDao=new StudentDAOimpl();
		Assert.assertEquals(true, sDao.addStudents(students));
	}
}
