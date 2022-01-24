package springBootTest2.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("emplibDTO")
public class EmpLibDTO {
	Integer libNum;
	String libWriter;
	String libSubject;
	String libContent;
	Integer empNum;
	String ipAddr;
	String libPw;
	String originalFileName;
	String storeFileName;
	String fileSize;
}
