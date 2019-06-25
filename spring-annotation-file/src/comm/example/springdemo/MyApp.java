package comm.example.springdemo;

//import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//FortuneService f=(FortuneService) context.getBean("randomFortuneService");
		//System.out.println(f.getFortune());
		
		FootballCoach c=(FootballCoach) context.getBean("footballCoach");
		System.out.println(c.getDailyWorkout());
		System.out.println(c.getFortune());
		System.out.println(c.getEmailAddress());
		System.out.println(c.getTeam());
		context.close();
	}

}
