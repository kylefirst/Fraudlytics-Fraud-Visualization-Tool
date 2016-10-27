
public class Driver {
	
	public static void main(String[]  args) {
		
		WeightedDistanceCalc calc = new WeightedDistanceCalc("data.txt");
		calc.getDistance("input.txt");
	//	calc.minMax("weights.txt");
	}

}
