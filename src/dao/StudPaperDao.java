package dao;

import java.util.List;

import entity.ErrorExam;
import entity.StudPaper;
/**
 * 处理考试卷子
 * @author Mr.Yu
 *
 */
public interface StudPaperDao {
	/**
	 * 查询考试分数
	 * @param studpaper
	 * @return
	 */
	StudPaper listRightPaperDao(StudPaper studpaper);
	
	/**
	 * 查询已做过的试卷
	 * @param studpaper
	 * @return
	 */
	List<StudPaper> listStudPaperDao(StudPaper studpaper);

	/**
	 * 提交卷子并录入
	 * @param studpaper
	 * @return
	 */
	Integer addStudPaperDao(StudPaper studpaper);

	/**
	 * 查看错题
	 * @param studpaper
	 * @return
	 */
	List<ErrorExam> listExamPaperDao(StudPaper studpaper);
}
