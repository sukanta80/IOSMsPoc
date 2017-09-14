package example.di_springLifecycle;

import javax.annotation.PreDestroy;

public class CicketCoach implements Coach {

	private DietPlanner dietplan;
	public void setDietplan(DietPlanner dietplan) {
		this.dietplan = dietplan;
	}

	@Override
	public String dailyWorkout() {
		return "practice bowling";
	}

	@Override
	public String dailydiet() {
		return dietplan.dailyDietPlan();
	}
	
	/*init method to be called after constructor calling
	this is the first method to me called in the spring bean life-cycle
	this method should be public and void and should not take any argument as input*/
	public void cricketCoachInit(){
		System.out.println("i have played 100 test matches");
	}
	
	/*destroy method to be called for cleaup of bean
	this is the last method to be called in the spring bean life-cycle
	this method should be public and void nad should not take any argument as input*/
	
	public void cricketCoachDestroy(){
		System.out.println("I am leaving the job of cricket coach");
	}

}
