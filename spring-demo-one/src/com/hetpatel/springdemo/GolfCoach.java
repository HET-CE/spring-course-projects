package com.hetpatel.springdemo;

public class GolfCoach implements Coach {

	private FortuneService fortuneService;
	public GolfCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice golf daily";
	}

//	@Override
//	public String getFortune() {
//		return fortuneService.getFortune();
//	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
