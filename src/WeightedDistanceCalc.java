import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WeightedDistanceCalc {

	private double[] dataLat;
	private double[] dataLon;

	public WeightedDistanceCalc(String fname) {

		dataLat = new double[2042];
		dataLon = new double[2042];
		String nextLine = null;
		int ctr = 0;

		try {
			BufferedReader br = new BufferedReader(new FileReader(fname));


			while ((nextLine = br.readLine()) != null) {

				dataLat[ctr] = Double.parseDouble(nextLine.substring(0, nextLine.indexOf(" ")));
				dataLon[ctr] = Double.parseDouble(nextLine.substring(nextLine.indexOf(" ")+1));

				ctr++;
			}

			br.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void getDistance(String fname) {

		String nextLine = null;;

		try{

			BufferedReader br = new BufferedReader(new FileReader(fname));
			BufferedWriter bw = new BufferedWriter(new FileWriter("normalizedWeights.txt",true)); //append

			while ((nextLine = br.readLine()) != null) {

				double distance = 0;

				for(int ctr = 0; ctr < dataLat.length; ctr++) {

					distance += Math.hypot(Double.parseDouble(nextLine.substring(0, nextLine.indexOf(" ")))-dataLat[ctr], Double.parseDouble(nextLine.substring(nextLine.indexOf(" ")+1))-dataLon[ctr]);
				}

				bw.write(100-(int)((distance-94.99978118135814)*100/88.6918148988587) + "\n");

			}

			bw.flush();
			br.close();
			bw.close();

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void minMax(String fname) {

		String nextLine = null;
		double max = Double.MIN_VALUE;
		double min = Double.MAX_VALUE;

		try{

			BufferedReader br = new BufferedReader(new FileReader(fname));

			while ((nextLine = br.readLine()) != null) {

				double value = Double.parseDouble(nextLine);
				
				if(value > max)
					max = value;
				if(value < min)
					min = value;
			}

			br.close();

		}catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Max: " + max + " Min: " + min);
		System.out.println("Factor: " + (max-min));
	}

}
