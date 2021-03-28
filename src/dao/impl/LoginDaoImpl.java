package dao.impl;

import java.util.List;

import dao.LoginDao;
import entity.Admin;
import entity.Student;
import entity.Teacher;
import util.DBHelper;

public class LoginDaoImpl implements LoginDao {

	@Override
	public Student studLoginDao(Student stud) {
		System.out.println("我是学生登陆方法！");
		String sql = "SELECT * FROM student WHERE sid = ? AND spwd = ?";
		List<Student> list = DBHelper.executeQuery(sql, Student.class, stud.getSid(), stud.getSpwd());
		
		if(list != null && list.size() != 0) {
			stud = list.get(0);
		} else {
			stud = null;
		}
		return stud;
	}

	@Override
	public Admin adLoginDao(Admin admin) {
		System.out.println("我是管理员登陆方法！");
		String sql = "SELECT * FROM admin,role WHERE uid = ? AND apwd = ? AND rid = 3";
		List<Admin> list = DBHelper.executeQuery(sql, Admin.class, admin.getUid(), admin.getApwd());
		
		if(list != null && list.size() != 0) {
			admin = list.get(0);
		} else {
			admin = null;
		}
		return admin;
	}

	@Override
	public Teacher teaLoginDao(Teacher tch) {
		System.out.println("我是教师登陆方法！");
		String sql = "SELECT * FROM teacher,role WHERE uid = ? AND tpwd = ? AND rid = 2";
		List<Teacher> list = DBHelper.executeQuery(sql, Teacher.class, tch.getUid(), tch.getTpwd());
		
		if(list != null && list.size() != 0) {
			tch = list.get(0);
		} else {
			tch = null;
		}
		return tch;
	}

}
