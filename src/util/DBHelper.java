package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * 数据库工具类
 * @author Mr.Yu
 *
 */
public class DBHelper {
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;	
		try {
			DbUtils.loadDriver("com.mysql.jdbc.Driver");//打开JDBC驱动
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalexam", "root", "19990601");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 数据库更新操作
	 * @param sql
	 * @param objects
	 * @return
	 */
	public static int executeUpdate(String sql,Object ...objects){
		
		Connection conn = getConn();
		QueryRunner qr = new QueryRunner();
		int rtn = 0;
		try {
			if(objects == null) {
				rtn = qr.update(conn, sql);
//				System.out.println(rtn);
			} else {
				rtn = qr.update(conn, sql, objects);
//				System.out.println(rtn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		return rtn;
	}
	
	public static Integer executeUpdate(String sql){
		return executeUpdate(sql, null);
	}
	
	/**
	 * 数据库查询操作
	 * @param <T>
	 * @param <T>
	 * @param sql
	 * @param cls
	 * @param objects
	 * @return
	 */
	public static <T> List<T> executeQuery(String sql,Class<T> cls,Object ...objects){
		Connection conn = getConn();
		List<T> list = null;
		try{
			QueryRunner rq = new QueryRunner();
			if(objects == null) {
				list = rq.query(conn, sql, new BeanListHandler<T>(cls));
//				System.out.println(list);
			} else {
				list = rq.query(conn, sql, new BeanListHandler<T>(cls), objects);
//				System.out.println(list);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;//返回查询对象的所有数据
	}
	
	public static <T> List<T> executeQuery(String sql,Class<T> cls){
		return executeQuery(sql,cls,null);
	}
}
