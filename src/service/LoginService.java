package service;

import entity.Admin;
import entity.Student;
import entity.Teacher;
/**
 * 用户登录
 * @author Mr.Yu
 *
 */
public interface LoginService {
	
	/**
	 * 管理员登陆
	 * @param uid
	 * @param upwd
	 * @return
	 */
	Admin adLoginService(Admin admin);
	/**
	 * 教师登陆
	 * @param uid
	 * @param upwd
	 * @return
	 */
	Teacher teaLoginService(Teacher tch);
	/**
	 * 学生登陆
	 * @param stud
	 * @return
	 */
	Student studLoginService(Student stud);
}
