package springBootTest2.service.emplib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.EmpLibCommand;
import springBootTest2.domain.EmpLibDTO;
import springBootTest2.mapper.EmpLibMapper;

@Component
@Service
public class EmpLibUpdateService {
	@Autowired
	EmpLibMapper emplibMapper;

	public void execute(EmpLibCommand emplibCommand) {
		EmpLibDTO  dto = new EmpLibDTO();
		dto.setLibNum(emplibCommand.getLibNum());
		dto.setLibWriter(emplibCommand.getLibWriter());
		dto.setLibSubject(emplibCommand.getLibSubject());
		dto.setLibContent(emplibCommand.getLibContent());
		
		emplibMapper.emplibUpdate(dto);
	}

	
}
