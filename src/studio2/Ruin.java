package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int startAmount = in.nextInt();
		int memory = startAmount;
		double winChance = in.nextDouble();
		int winLimit = in.nextInt();
		int totalSimulations = in.nextInt();
		boolean winLose;
		int gamesCount = 0;
		String strWinLose = "";
		double rand;
		int winNum = 0;
		int lossNum = 0;
		
		
		double a = (1-winChance)/winChance;
		double expectedRuin = ((Math.pow(a, startAmount)) - Math.pow(a,winLimit))/(1-Math.pow(a, winLimit));
		
		
		for (int i = 1; i<=totalSimulations; i++)
		{
			startAmount = memory;
			gamesCount = 0;
			while ((startAmount <winLimit) && (startAmount >0))
			{
				rand = Math.random();
				winLose = (rand <= winChance);
				if(winLose)
					startAmount+=1;
				else
					startAmount-=1;
				gamesCount++;
				if(startAmount >= winLimit)
					strWinLose = "Winner";
				else
					strWinLose = "Loser";
			}
			if(strWinLose == "Winner")
				winNum+=1;
			else
				lossNum+=1;
			System.out.println("Simulation "+ i + ": " + gamesCount + " " + strWinLose );
		}
		double ruinRate = ((double)lossNum/totalSimulations)*100;
		System.out.println( "Losses: "+ lossNum + " \\ Simulations: " + totalSimulations);
		System.out.println("Ruin rate: "+ ruinRate+"%");
		System.out.println(Math.round(expectedRuin*100) + "%");
	}

}
