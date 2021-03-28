package dao.impl;

import java.util.List;

import dao.StudPaperDao;
import entity.ErrorExam;
import entity.StudPaper;
import util.DBHelper;

public class StudPaperDaoImpl implements StudPaperDao {

	@Override
	public StudPaper listRightPaperDao(StudPaper studpaper) {
		System.out.println("我是计分方法！");
		StudPaper studpapers = new StudPaper();
		String sql = "SELECT COUNT(*) rightcount FROM studpaper WHERE studstate = 1 AND studpaper.sid = ? AND spid = ?";
		List<StudPaper> list = DBHelper.executeQuery(sql,StudPaper.class,studpaper.getSid(),studpaper.getSpid());
		
		if(list != null && list.size() != 0) {
			studpapers = list.get(0);
		} else {
			studpapers = null;
		}
		return studpapers;
	}

	@Override
	public List<StudPaper> listStudPaperDao(StudPaper studpaper) {
		System.out.println("我是查询已做试卷方法！");
		String sql = "SELECT spid,sid,pname,COUNT(if(studstate=1,true,null)) AS rightcount,COUNT(if(studstate=0,true,null)) AS errorcount FROM studpaper WHERE sid = ? GROUP BY spid;";
		List<StudPaper> list = DBHelper.executeQuery(sql, StudPaper.class, studpaper.getSid());
		return list;
	}

	@Override
	public Integer addStudPaperDao(StudPaper studpaper) {
		System.out.println("我是录入学生试卷方法！");
		String sql = "INSERT INTO studpaper VALUES(?,?,?,?,?,?)";
		Integer rows = DBHelper.executeUpdate(sql, studpaper.getSid(),studpaper.getStudkey(),studpaper.getStudstate(),studpaper.getPname(),studpaper.getSpid(),studpaper.getEid());
		return rows;
	}

	@Override
	public List<ErrorExam> listExamPaperDao(StudPaper studpaper) {
		System.out.println("我是查看错题方法！");
		String sql = "SELECT examoption.eid,examoption.etitle,examoption.ea,examoption.eb,examoption.ec,examoption.ed,examoption.ekey,studpaper.studkey,studpaper.pname FROM studpaper,examoption WHERE studpaper.eid = examoption.eid AND studstate = 0 AND sid = ? AND spid = ?";
		List<ErrorExam> errorexam = DBHelper.executeQuery(sql, ErrorExam.class, studpaper.getSid(), studpaper.getSpid());
		for(ErrorExam e:errorexam) {
			System.out.println("业务层："+e.toString());
		}
		return errorexam;
	}
}
