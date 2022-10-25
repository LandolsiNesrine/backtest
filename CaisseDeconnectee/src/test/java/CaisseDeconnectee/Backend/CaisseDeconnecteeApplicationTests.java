package CaisseDeconnectee.Backend;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import CaisseDeconnectee.Entities.HrPayCashDeskSession;
import CaisseDeconnectee.Service.HrPayCashDeskSessionService;

@SpringBootTest
class CaisseDeconnecteeApplicationTests {
	@Autowired
	private HrPayCashDeskSessionService sessionService;
	@Test
	void contextLoads() {
		List<HrPayCashDeskSession> allSessions = sessionService.retirerAll();
		System.out.println(allSessions);
	}

}
