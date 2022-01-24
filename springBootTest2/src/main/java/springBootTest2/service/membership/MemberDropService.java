package springBootTest2.service.membership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.mapper.MembershipMapper;
@Component
@Service
public class MemberDropService {
	@Autowired
	MembershipMapper membershipMapper;
	public void execute(String memId) {
		membershipMapper.memberDrop(memId);
	}
}