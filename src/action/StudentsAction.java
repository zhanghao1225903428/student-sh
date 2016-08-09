package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entity.Students;
import service.StudentsDAO;
import service.impl.StudentDAOimpl;

public class StudentsAction extends superAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String query()
	{
		StudentsDAO sDao=new StudentDAOimpl();
		List<Students> list=sDao.queryAllStudents();
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("student_list", list);
		}
		else
		{
			session.setAttribute("student_list", null);
		}
		return "query_success";
	}

	//删除操作
	public String delete()
	{
		StudentsDAO sDao=new StudentDAOimpl();
		String sid=request.getParameter("sid");
		sDao.deleteStudents(sid);  //调用删除方法
		return "delete_success";
		
		
	}
	//添加学生动作
	public String add()
	{
		Students students=new Students();
		students.setSname(this.request.getParameter("sname"));
		students.setGender(this.request.getParameter("gender"));
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = simpleDateFormat.parse(this.request.getParameter("birthday"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		students.setBirthday(date);
		students.setAddress(this.request.getParameter("address"));
		StudentsDAO studentsDAO = new StudentDAOimpl();
		studentsDAO.addStudents(students);//使用模型驱动获取从表单提交过来的信息
		return "add_success";
	}
	
	//修改学生资料
	public String modify()
	{
		String sid=request.getParameter("sid");
		StudentsDAO studentsDAO = new StudentDAOimpl();
		Students students=studentsDAO.queryStudentsById(sid);
		request.getSession().setAttribute("modify_students", students);
		return "modify_success";
	}
	
	//保存学生动作
	public String save()
	{
		Students students=new Students();
		students.setSid(request.getParameter("sid"));
		students.setSname(this.request.getParameter("sname"));
		students.setGender(this.request.getParameter("gender"));
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = simpleDateFormat.parse(this.request.getParameter("birthday"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		students.setBirthday(date);
		students.setAddress(this.request.getParameter("address"));
		StudentsDAO studentsDAO = new StudentDAOimpl();
		studentsDAO.updateStudents(students);//使用模型驱动获取从表单提交过来的信息
		return "save_success";
		
	}
}
