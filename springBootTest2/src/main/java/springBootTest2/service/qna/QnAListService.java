package springBootTest2.service.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.QnADTO;
import springBootTest2.mapper.QnAMapper;

@Component
@Service
public class QnAListService {
	@Autowired
	QnAMapper qnaMapper;
	public void execute(Model model) {
		List<QnADTO> list = qnaMapper.selectAll();
		model.addAttribute("list", list);
	}
}
