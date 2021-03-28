package service;

import java.util.List;

import entity.ExamOption;
import entity.Paper;
/**
 * 显示考试内容
 * @author Mr.Yu
 *
 */
public interface PaperService {
	
	/**
	 * 查询全部试卷---首页
	 * @param paper
	 * @return
	 */
	List<Paper> listPaperService(Paper paper);
	
	/**
	 * 显示试题内容
	 * @param paper
	 * @return
	 */
	List<ExamOption> listExamService(Paper paper);
}
