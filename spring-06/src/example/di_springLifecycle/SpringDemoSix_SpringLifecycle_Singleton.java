package example.di_springLifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemoSix_SpringLifecycle_Singleton {

	public static void main(String[] args) {
		
	
	//create the context object
	ClassPathXmlApplicationContext applicationContext = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	//get the bean from context
	Coach coach = applicationContext.getBean("myCoach", Coach.class);
	
	//call methods on the coach
	System.out.println(coach.dailydiet());
	System.out.println(coach.dailyWorkout());
	
	//let's create another object to check if 
	//init and destroy methods are called again
	
	Coach coach2 = applicationContext.getBean("myCoach", Coach.class);
	//it was observed that init and destroy methods are called only once. 
	
	//kill the context
	applicationContext.close();
	}
}
