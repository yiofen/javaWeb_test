package dao;

import java.util.List;

import entity.ExamOption;
import entity.Paper;
/**
 * 显示考试内容
 * @author Mr.Yu
 *
 */
public interface PaperDao {
	/**
	 * 查询全部试卷--首页
	 * @param paper
	 * @return
	 */
	List<Paper> listPaperDao(Paper paper);
	
	/**
	 * 查询试卷内容
	 * @param paper
	 * @return
	 */
	List<ExamOption> listExamDao(Paper paper);
}
