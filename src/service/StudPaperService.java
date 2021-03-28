package service;

import java.util.List;

import entity.ErrorExam;
import entity.StudPaper;
/**
 * 处理考试卷子
 * @author Mr.Yu
 *
 */
public interface StudPaperService {
	
	/**
	 * 计算分数
	 * @param studpaper
	 * @return
	 */
	StudPaper listRightPaperService(StudPaper studpaper);

	/**
	 * 查询已做的试卷
	 * @param studpaper
	 * @return
	 */
	List<StudPaper> listStudPaperService(StudPaper studpaper);
	
	/**
	 * 提交卷子并录入
	 * @param studpaper
	 * @return
	 */
	Integer addStudPaperService(StudPaper studpaper);

	/**
	 * 查看错题
	 * @param studpaper
	 * @return
	 */
	List<ErrorExam> listExamPaperService(StudPaper studpaper);
}
