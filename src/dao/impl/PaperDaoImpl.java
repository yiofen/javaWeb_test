package dao.impl;

import java.util.List;

import dao.PaperDao;
import entity.ExamOption;
import entity.Paper;
import util.DBHelper;

public class PaperDaoImpl implements PaperDao {

	
	@Override
	public List<Paper> listPaperDao(Paper paper) {
		String sql = "SELECT pname,COUNT(*) ecount FROM paper GROUP BY pname";
		List<Paper> list = DBHelper.executeQuery(sql,Paper.class);
		return list;
	}

	@Override
	public List<ExamOption> listExamDao(Paper paper) {
		String sql = "SELECT examoption.eid,etitle,ea,eb,ec,ed,ekey FROM paper,examoption WHERE paper.eid=examoption.eid AND paper.pname=?";
		List<ExamOption> list = DBHelper.executeQuery(sql,ExamOption.class,paper.getPname());
		return list;
	}
}
