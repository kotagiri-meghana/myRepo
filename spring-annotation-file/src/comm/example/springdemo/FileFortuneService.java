package comm.example.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Welcome to file fortune";
	}

}
