package action;

import org.apache.catalina.User;
import org.apache.catalina.deploy.LoginConfig;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
import service.UsersDAO;
import service.impl.UsersDAOimpl;

public class UsersAction extends superAction implements ModelDriven<Users>{

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Users user =new Users();
    
    
    //用户登录动作
    public String login()
    {
    	
    	UsersDAO usersDAO=new UsersDAOimpl();
    	System.out.println(user.getUsername()+","+user.getPassword());
    	if(usersDAO.usersLogin(user))
    	{
    		session.setAttribute("loginUserName", user.getUsername());
    		return "login_success";
    	}else
    	{
    		return "login_failure";
    	}
    }
    
    //注销功能
    @SkipValidation
    public String loginout()
    {
    	if(session.getAttribute("loginUserName")!=null)
    	{
    		session.removeAttribute("loginUserName");
    	}
    	return "loginout_success";
    }
    
	@Override
	public void validate() {
		if("".equals(user.getUsername().trim()))
		{
			this.addFieldError("usernameError","用户名不能为空");
		}
		
		if(user.getPassword().length()<6)
		{
			this.addFieldError("passwordError","密码不能小于6位");
		}
	}

	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
