package dao;

import entity.Admin;
import entity.Student;
import entity.Teacher;
/**
 * 用户登录
 * @author Mr.Yu
 *
 */
public interface LoginDao {
	/**
	 * 管理员登陆
	 * @param admin
	 * @return
	 */
	Admin adLoginDao(Admin admin);
	/**
	 * 老师登陆
	 * @param tch
	 * @return
	 */
	Teacher teaLoginDao(Teacher tch);
	/**
	 * 学生登陆
	 * @param stud
	 * @return
	 */
	Student studLoginDao(Student stud);
}
