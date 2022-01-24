package springBootTest2.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class LibraryCommand {
	String libNum;
	String libWriter;
	String libSubject;
	String libContent;
	String libPw;
	MultipartFile[] report;
}