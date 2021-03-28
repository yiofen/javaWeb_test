package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Admin;
import entity.ExamOption;
import entity.Paper;
import entity.Student;
import entity.Teacher;
import service.LoginService;
import service.PaperService;
import service.impl.LoginServiceImpl;
import service.impl.PaperServiceImpl;
import util.Tool;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	
	LoginService ls = new LoginServiceImpl();
	PaperService ps = new PaperServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String cmd = req.getParameter("cmd");
		if(cmd.equals("stulogin")) {
			stulogin(req,resp);
		} else if(cmd.equals("tealogin")) {
			tealogin(req,resp);
		} else if(cmd.equals("adlogin")) {
			adlogin(req,resp);
		} else if(cmd.equals("logout")) {
			logout(req,resp);
		} else if(cmd.equals("paperlist")) {
			stuindex(req,resp);
		} else if(cmd.equals("paper")) {
			paper(req,resp);
		}
	}
	
	/**
	 * 考生主页面
	 * @param req
	 * @param resp
	 */
	private void stuindex(HttpServletRequest req, HttpServletResponse resp) {
		Paper paper = new Paper();
		List<Paper> papers = ps.listPaperService(paper);
		HttpSession hs = req.getSession(true);
		hs.setAttribute("papers", papers);
		try {
			resp.sendRedirect("/systest/user/index.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 管理中心主界面
	 * @param req
	 * @param resp
	 */
	private void index(HttpServletRequest req, HttpServletResponse resp) {
		try {
			resp.sendRedirect("/systest/index.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 学生登陆
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void stulogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Student stud = new Student();
		stud.setSid(req.getParameter("uid"));
		stud.setSpwd(req.getParameter("upwd"));
		stud = ls.studLoginService(stud);
		
		if(stud == null) {
			req.setAttribute("msg", "账号或密码错误！");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		} else {
			HttpSession hs = req.getSession(true);
			hs.setAttribute("user", stud);
			hs.setAttribute("uid", stud.getSid());
			stuindex(req, resp);
			return;
		}
	}

	/**
	 * 管理员登陆
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void adlogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Admin admin = new Admin();
		admin.setUid(req.getParameter("uid"));
		admin.setApwd(req.getParameter("upwd"));
		admin = ls.adLoginService(admin);
		
		if(admin == null) {//用户名或者密码输入错误
			req.setAttribute("msg", "账号或密码错误！");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		} else {
			System.out.println(admin.toString());
			HttpSession hs = req.getSession(true);
			hs.setAttribute("user", admin);
			hs.setAttribute("uid", admin.getUid());
			index(req,resp);
			return;
		}
	}
	
	/**
	 * 教师登陆
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void tealogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Teacher tch = new Teacher();
		tch.setUid(req.getParameter("uid"));
		tch.setTpwd(req.getParameter("upwd"));
		tch = ls.teaLoginService(tch);
		
		if(tch == null) {
			req.setAttribute("msg", "账号或密码错误！");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		} else {
			System.out.println(tch.toString());
			HttpSession hs = req.getSession(true);
			hs.setAttribute("user", tch);
			hs.setAttribute("uid", tch.getUid());
			index(req,resp);
			return;
		}
	}
	
	/**
	 * 注销
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		hs.removeAttribute("user");
		hs.removeAttribute("uid");
		resp.sendRedirect(Tool.Basepath(req, resp)+"login.jsp");
		return;
	}
	
	/**
	 * 显示考试题目
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void paper(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Paper paper = new Paper();
		String pname = req.getParameter("pname");
		paper.setPname(pname);
		List<ExamOption> exams = ps.listExamService(paper);
		HttpSession hs = req.getSession();
		hs.setAttribute("exams", exams);
		hs.setAttribute("pname", pname);
		resp.sendRedirect("/systest/user/paper/paper.jsp");
	}
}
