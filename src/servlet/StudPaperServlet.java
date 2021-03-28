package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import entity.ErrorExam;
import entity.StudPaper;
import service.StudPaperService;
import service.impl.StudPaperServiceImpl;

@WebServlet("/user/studPaper")
public class StudPaperServlet extends HttpServlet {
	
	StudPaperService sps = new StudPaperServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String cmd = req.getParameter("cmd");
		if(cmd.equals("studpaper")) {//实现交卷功能
			studpaper(req,resp);
		} else if(cmd.equals("score")) {//计算分数
			score(req,resp);
		} else if(cmd.equals("listpaper")) {//查看错题
			listpaper(req,resp);
		} else if(cmd.equals("answer")) {//录入试卷功能
			answer(req,resp);
		}
	}

	/**
	 * 提交答案时录入数据库
	 * @param req
	 * @param resp
	 */
	private void answer(HttpServletRequest req, HttpServletResponse resp) {
		StudPaper studpaper = new StudPaper();
		String uid = req.getParameter("uid");
		studpaper.setSid(uid);
		try {
			BeanUtils.populate(studpaper, req.getParameterMap());
			Integer rows = sps.addStudPaperService(studpaper);
			System.out.println(studpaper.toString());//输出当前用户试卷信息
			System.out.println(rows);//返回录入时影响的行数
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 计算考试得分
	 * @param req
	 * @param resp
	 */
	private void score(HttpServletRequest req, HttpServletResponse resp) {
		StudPaper studpaper = new StudPaper();
		String spid = req.getParameter("spid");//获取前端网页的用户交卷时间
		String uid = req.getParameter("uid");//获取前端网页的用户id
		studpaper.setSid(uid);
		studpaper.setSpid(spid);
//		System.out.println(studpaper.toString());
		Integer score = sps.listRightPaperService(studpaper).getRightcount();
//		System.out.println(score);
		HttpSession hs = req.getSession(true);
		hs.setAttribute("score", score);
		
		PrintWriter write = null;
		try {
			write = resp.getWriter();
			write.println("本次得分" + score * 2 + "分!");
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查看已做的试卷
	 * @param req
	 * @param resp
	 */
	private void studpaper(HttpServletRequest req, HttpServletResponse resp) {
		StudPaper studpaper = new StudPaper();
		String uid = (String) req.getSession().getAttribute("uid");
		studpaper.setSid(uid);
//		System.out.println(studpaper.getSid());
		List<StudPaper> papers = sps.listStudPaperService(studpaper);
		HttpSession hs = req.getSession(true);
		hs.setAttribute("papers", papers);
		try {
			resp.sendRedirect("/systest/user/paper/studentpaper.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查看错题
	 * @param req
	 * @param resp
	 */
	private void listpaper(HttpServletRequest req, HttpServletResponse resp) {
		StudPaper studpaper = new StudPaper();
		String spid = req.getParameter("spid");
		String uid = req.getParameter("uid");
		studpaper.setSid(uid);
		studpaper.setSpid(spid);
		List<ErrorExam> errorexam = sps.listExamPaperService(studpaper);
		for(ErrorExam e:errorexam) {
			System.out.println("响应层："+e.toString());
		}
		HttpSession hs = req.getSession(true);
		hs.setAttribute("errorexam", errorexam);
		hs.setAttribute("pname", errorexam.get(0).getPname());
		try {
			resp.sendRedirect("/systest/user/paper/studenterror.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
