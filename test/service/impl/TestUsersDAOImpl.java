package service.impl;


import org.junit.Test;

import entity.Users;
import junit.framework.Assert;
import service.UsersDAO;

public class TestUsersDAOImpl {
	@Test
	public void testUserLogin()
	{
		Users user=new Users(1,"zhangsan","123456") ;
		UsersDAO uDao=new UsersDAOimpl();
		Assert.assertEquals(true, uDao.usersLogin(user));
	}
}
