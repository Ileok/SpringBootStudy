package springBootTest2.service.qna;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.domain.QnADTO;
import springBootTest2.mapper.QnAMapper;

@Component
@Service
public class QnAInfoService {
	@Autowired
	QnAMapper qnaMapper;
	public void execute(HttpServletRequest request ) {
		Integer num = Integer.parseInt(request.getParameter("num"));
		QnADTO dto = qnaMapper.selectOne(num); 
		request.setAttribute("dto", dto);
	}
}
