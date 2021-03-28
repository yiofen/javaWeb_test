package service.impl;

import dao.LoginDao;
import dao.impl.LoginDaoImpl;
import entity.Admin;
import entity.Student;
import entity.Teacher;
import service.LoginService;

public class LoginServiceImpl implements LoginService {

	LoginDao ld = new LoginDaoImpl();
	
	@Override
	public Admin adLoginService(Admin admin) {
		return ld.adLoginDao(admin);
	}

	@Override
	public Teacher teaLoginService(Teacher tch) {
		return ld.teaLoginDao(tch);
	}

	@Override
	public Student studLoginService(Student stud) {
		return ld.studLoginDao(stud);
	}
}
