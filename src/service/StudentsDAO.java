package service;

import java.util.List;

import entity.Students;

//学生业务逻辑接口
public interface StudentsDAO {

	//查询学生资料
	public List<Students> queryAllStudents();
	
	//g根据学生编号查询学生资料
	public Students queryStudentsById(String sid);
	
	//添加学生资料
	public boolean addStudents(Students students);
	
	//修改学生资料
	public boolean updateStudents(Students students);
	
	//删除学生资料
	public boolean deleteStudents(String sid);
}
