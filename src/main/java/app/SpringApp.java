package app;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import imcs.trng.raghu.dao.EmployeeDAO;
import imcs.trng.raghu.dao.EmployeeDAOImpl;
import imcs.trng.raghu.dao.config.DbConfig;
import imcs.trng.raghu.dao.model.Employee;

public class SpringApp {

	private static ApplicationContext applicationContext;
	
	public static void main(String[] args) throws Exception{
		initAppContext();
		beanUsage();
	}

	static void initAppContext() {
		applicationContext = new AnnotationConfigApplicationContext(DbConfig.class);
	}
	
	static void beanUsage() throws Exception {
		EmployeeDAO dao=applicationContext.getBean(EmployeeDAOImpl.class);
		dao.addEmployee(new Employee(2,"hgfhgf",1,new Date(),new Date(),126,5));
	}
	
	
}
