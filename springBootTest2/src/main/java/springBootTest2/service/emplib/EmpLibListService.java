package springBootTest2.service.emplib;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.EmpLibDTO;
import springBootTest2.mapper.EmpLibMapper;

@Component
@Service
public class EmpLibListService {
	@Autowired
	EmpLibMapper emplibMapper;

	public void execute(Model model) {
		List<EmpLibDTO> list = emplibMapper.selectAll();
		model.addAttribute("list", list);
	}
}
