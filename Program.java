
import java.util.Scanner;
import javax.swing.JFrame;

public class Program {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		Clock clock = new Clock();
		int h, m;
		Scanner s = new Scanner(System.in);
		boolean fcontinue=false;
		do {
			System.out.println("Please enter hour:");
			h=s.nextInt();
			if (h>12||h<0) {
				System.out.println("Out of range, Please enter number between 1-12:");
			}
			else {
				fcontinue=true;
				break;
			}
		}
		while (!fcontinue);

		do {
			System.out.println("Please enter minute:");
			m=s.nextInt();
			if(m>59||m<0) {
				System.out.println("Out of range, Please enter number between 0-59:");
			}
			else {
				fcontinue=false;
				break;
			}
		}
		while(fcontinue);
		s.close();
		clock.setHours(h);
		clock.setMinutes(m);
	
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(clock);
		f.setSize(500, 500);
		f.setLocation(200,100);
		f.setVisible(true);
	}

}
