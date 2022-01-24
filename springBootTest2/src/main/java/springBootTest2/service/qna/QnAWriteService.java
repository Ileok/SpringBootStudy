package springBootTest2.service.qna;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.QnACommand;
import springBootTest2.domain.QnADTO;
import springBootTest2.mapper.QnAMapper;

@Component
@Service
public class QnAWriteService {
	@Autowired
	QnAMapper qnaMapper;
	public void execute(QnACommand qnaCommand, 
			HttpServletRequest req) {
//		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd");
//		Date date = new Date();
//		String regiDate = format.format(date);
		QnADTO dto = new QnADTO();
		dto.setQnaContent(qnaCommand.getQnaContent());
		dto.setQnaSubject(qnaCommand.getQnaSubject());
//		dto.setQnaRegiDate(regiDate);
		
		Integer i = qnaMapper.qnaInsert(dto);
		System.out.println(i +"개 행이(가) 삽입되었습니다.");
	}
}