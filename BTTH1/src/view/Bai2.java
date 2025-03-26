package view;

import java.util.Random;

public class Bai2 {

	public static void main(String[] args) {
		int N=10000000;
		int M=0;
		Random rand=new Random();
		for(int i=0;i<N;i++) {
			double x= 2*rand.nextDouble()-1;
			double y= 2*rand.nextDouble()-1;
			if(x*x+y*y<=1)
				M++;
		}
		double approximatePi=(double)M/N * 4;
		System.out.println("Giá trị xấp xỉ của pi: "+approximatePi);
    }

}