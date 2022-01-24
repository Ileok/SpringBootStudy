package springBootTest2.service.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.QnACommand;
import springBootTest2.domain.QnADTO;
import springBootTest2.mapper.QnAMapper;

@Component
@Service
public class QnAModifyService {
	@Autowired
	QnAMapper qnaMapper;
	public void execute(QnACommand qnaCommand) {
		QnADTO  dto = new QnADTO();
		dto.setQnaNum(qnaCommand.getQnaNum());
		dto.setQnaSubject(qnaCommand.getQnaSubject());
		dto.setQnaContent(qnaCommand.getQnaContent());
		qnaMapper.qnaUpdate(dto);
	}
}
