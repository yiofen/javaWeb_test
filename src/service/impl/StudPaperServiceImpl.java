package service.impl;

import java.util.List;

import dao.StudPaperDao;
import dao.impl.StudPaperDaoImpl;
import entity.ErrorExam;
import entity.StudPaper;
import service.StudPaperService;

public class StudPaperServiceImpl implements StudPaperService {
	
	StudPaperDao spd = new StudPaperDaoImpl();
	
	@Override
	public StudPaper listRightPaperService(StudPaper studpaper) {
		return spd.listRightPaperDao(studpaper);
	}
	
	@Override
	public List<StudPaper> listStudPaperService(StudPaper studpaper) {
		return spd.listStudPaperDao(studpaper);
	}

	@Override
	public Integer addStudPaperService(StudPaper studpaper) {
		return spd.addStudPaperDao(studpaper);
	}

	@Override
	public List<ErrorExam> listExamPaperService(StudPaper studpaper) {
		return spd.listExamPaperDao(studpaper);
	}
	
}
