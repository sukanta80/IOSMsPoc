package example.di_springLifecycle;

public class CricketDiet implements DietPlanner {

	@Override
	public String dailyDietPlan() {
		return "Cricketers don't eat oily food";
	}

}
