package springBootTest2.service.emplib;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springBootTest2.command.EmpLibCommand;
import springBootTest2.domain.EmpLibDTO;
import springBootTest2.mapper.EmpLibMapper;

@Component
@Service
public class EmpLibWriteService {
	@Autowired
	EmpLibMapper emplibMapper;

	public void execute(EmpLibCommand emplibCommand, HttpServletRequest request) {
		EmpLibDTO dto = new EmpLibDTO();
		dto.setEmpNum(emplibCommand.getEmpNum());
		dto.setLibNum(emplibCommand.getLibNum());
		dto.setLibWriter(emplibCommand.getLibWriter());
		dto.setLibSubject(emplibCommand.getLibSubject());
		dto.setLibContent(emplibCommand.getLibContent());
		dto.setLibPw(emplibCommand.getLibPw());
		dto.setIpAddr(request.getRemoteAddr());

		// 파일 정보를 입력하기 위한 변수
		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal = "";
		String fileDir = "/view/empLib";
		String filePath = request.getServletContext().getRealPath(fileDir);

		if (!emplibCommand.getReport()[0].getOriginalFilename().isEmpty()) {
			for (MultipartFile mf : emplibCommand.getReport()) {
				String originalFile = mf.getOriginalFilename();
				String extension = originalFile.substring(originalFile.lastIndexOf("."));
				String storeName = UUID.randomUUID().toString().replace("-", "");
				String storeFileName = storeName + extension;
				String fileSize = Long.toString(mf.getSize());

				originalTotal += originalFile + "`";
				storeTotal += storeFileName + "`";
				fileSizeTotal += fileSize + "`";
				File file = new File(filePath + "/" + storeFileName);
				try {
					mf.transferTo(file); // 파일을 저장
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		dto.setFileSize(fileSizeTotal);
		dto.setOriginalFileName(originalTotal);
		dto.setStoreFileName(storeTotal);

		Integer i = emplibMapper.emplibInsert(dto);
		System.out.println(i + "개 행이 생성되었습니다.");
	}

}
