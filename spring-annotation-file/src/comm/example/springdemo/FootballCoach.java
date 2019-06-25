package comm.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@PropertySource("classpath:sports.properties")
public class FootballCoach implements Coach{

	//@Value("nilay@gmail.com")
	@Value("${foo.emailAddress}")
	private String emailAddress;
	
	//@Value("chicago bulls")
	@Value("${foo.team}")
	private String team;
	
//	@Autowired
//	@Qualifier("fileFortuneService")
	FortuneService myFortune;
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "play for 2 hours";
	}
	
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public void setTeam(String team) {
		this.team = team;
	}


	@Autowired
	public void setMyFortune(@Qualifier("randomFortuneService")FortuneService myFortune) {
		this.myFortune = myFortune;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public String getTeam() {
		return team;
	}


	public String getFortune() {
		return myFortune.getFortune();
		
	}

}
