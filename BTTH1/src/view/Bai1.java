 
package view;
import java.util.Random;

public class Bai1 {

	public static void main(String[] args) {
		double r=1.0;
		int N=1000000;
		int M=0;
		Random rand=new Random();
		for(int i=0;i<N;i++) {
			double x= (2*r)*rand.nextDouble() -r;
			double y= (2*r)*rand.nextDouble() -r;
			if(x*x+y*y<=r*r)
				M++;
		}
		double approximateArea=(double)M/N * 4*r*r;
		System.out.println("Diện tích xấp xỉ: "+approximateArea );
		
		
	}

}