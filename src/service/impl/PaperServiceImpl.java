package service.impl;

import java.util.List;

import dao.PaperDao;
import dao.impl.PaperDaoImpl;
import entity.ExamOption;
import entity.Paper;
import service.PaperService;

public class PaperServiceImpl implements PaperService {
	
	PaperDao pd = new PaperDaoImpl();
	
	@Override
	public List<Paper> listPaperService(Paper paper) {
		return pd.listPaperDao(paper);
	}

	@Override
	public List<ExamOption> listExamService(Paper paper) {
		return pd.listExamDao(paper);
	}
	
}
