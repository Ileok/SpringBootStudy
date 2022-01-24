package springBootTest2.service.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.mapper.QnAMapper;

@Component
@Service
public class QnADelService {
	@Autowired
	QnAMapper qnaMapper;
	public void execute(Integer qnaNum) {
		qnaMapper.qnaDel(qnaNum);
	}
}
