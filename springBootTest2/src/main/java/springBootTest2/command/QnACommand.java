package springBootTest2.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class QnACommand {
	Integer qnaNum;
	String qnaSubject;
	String qnaContent;
	Integer visitCount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date qnaRegiDate;
}
