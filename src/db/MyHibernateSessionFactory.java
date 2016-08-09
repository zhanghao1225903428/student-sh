package db;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyHibernateSessionFactory {
    private static SessionFactory sessionFactory;  //会话工厂属性
    private MyHibernateSessionFactory()//  私有化构造方法  ，单例模式
    {
    	
    }
    
    //一个公有的静态化方法，获得会话工厂方法。
    public  static SessionFactory getsessionFactory()
    {
    	if(sessionFactory==null)
    		{
           Configuration configuration=new Configuration().configure();
           ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
           sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	}
			return sessionFactory;
    		
    }
}
