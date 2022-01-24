package springBootTest2.mapper;

import java.util.List;

import springBootTest2.domain.QnADTO;

public interface QnAMapper {

	public Integer qnaInsert(QnADTO dto);

	public List<QnADTO> selectAll();

	public void visitCount(Integer qnaNum);

	public QnADTO selectOne(Integer qnaNum);

	public void qnaDel(Integer qnaNum);

	public void qnaUpdate(QnADTO dto);
}
