package example.di_springLifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemoSix_SpringLifecycle_Prototype {

	public static void main(String[] args) {
		
	
	//create the context object
	ClassPathXmlApplicationContext applicationContext = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	//get the bean from context
	CicketCoach coach = applicationContext.getBean("myCoach", CicketCoach.class);
	
	//call methods on the coach
	System.out.println(coach.dailydiet());
	System.out.println(coach.dailyWorkout());
	
	//let's create another object to check if 
	//init and destroy methods are called again
	
	CicketCoach coach2 = applicationContext.getBean("myCoach", CicketCoach.class);
	//it was observed that init and destroy methods are called only once. 
	System.out.println(coach2.dailyWorkout());
	//kill the context
	applicationContext.close();
	}
}
