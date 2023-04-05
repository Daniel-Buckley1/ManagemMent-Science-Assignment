import static java.math.BigDecimal.ROUND_HALF_EVEN;

import java.math.BigDecimal;
import java.util.Random;

public class StockPriceSimulator {
	
	
	public static double priceIncreaser(double price) {
		Random rand=new Random();
		double probabilityForIncrease=rand.nextDouble(1);
		if(probabilityForIncrease<=0.4) {
			return price*=1.125;
			
		}
		if(probabilityForIncrease<=0.57) {
			return price*=1.25;
		}
		
		if(probabilityForIncrease<=0.69) {
			return price*=1.375;
		}
		
		if(probabilityForIncrease<=0.79) {
			return price*=1.5;
		}
		if(probabilityForIncrease<=0.87) {
			return price*=1.625;
			
		}
		if(probabilityForIncrease<=0.94) {
			return price*=1.75;
		}
		if(probabilityForIncrease<=0.98) {
			return price*=1.875;
		}
		
		return price*2;
		
		
	}
	
	public static double priceDecreaser(double price) {
		Random rand=new Random();
		double probForPriceDecrease=rand.nextDouble(1);
		if(probForPriceDecrease<=0.12) {
			return price*0.875;
		}
		if(probForPriceDecrease<=0.27) {
			return price*0.75;
		}
		if(probForPriceDecrease<=0.45) {
			return price*0.625;
		}
		if(probForPriceDecrease<=0.66) {
			return price*0.5;
		}
		if(probForPriceDecrease<=0.8) {
			return price*0.375;
		}
		if(probForPriceDecrease<=0.9) {
			return price*0.25;
		}
		if(probForPriceDecrease<=0.95) {
			return price*0.125;
		}
		return 0;
		
	}
	
	
	public static double priceSimulator(int days, double price) {
		int day=0;
		while(day<days) {
			Random rand=new Random();
			double priceDirection=rand.nextDouble(1);
			if(priceDirection<=0.45) {
				price=priceIncreaser(price);
				
			}
			
			else if(priceDirection<=0.75){
				continue;
			}
			
			else {
				price=priceDecreaser(price);
			}
			
			
			
			
			
			
			day++;
			}
		return price;
	}
	
	
	
	

	public static void main(String[] args) {
		double price=priceSimulator(30,62);
		BigDecimal roundedPrice= new BigDecimal(price);
		@SuppressWarnings("deprecation")
		BigDecimal roundOff=roundedPrice.setScale(2, ROUND_HALF_EVEN);
		System.out.println(roundOff);

		

	}

}