package comm.example.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	File inputFile;
	@PostConstruct
	public void init() {
		 inputFile=new File("fortune.txt");
	}
		@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		
			String[] tokens = null;

		try {
		
		FileReader in=new FileReader(inputFile);
		
		BufferedReader inputStream=new BufferedReader(in);
		
		String l;
		
		while((l=inputStream.readLine()) != null)
			
				{
					
					 tokens = l.split(",");
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		int l=tokens.length;
		l=l-1;
		int i=(int) ((Math.random() * ((l- 0) + 1)) + 0);
		return tokens[i];
	}
		@PreDestroy
		public void destroy() {
			inputFile=null;
			System.out.println("File closed");
		}

}
