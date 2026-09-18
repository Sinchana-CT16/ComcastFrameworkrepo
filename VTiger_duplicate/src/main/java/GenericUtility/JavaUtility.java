package GenericUtility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random r=new Random();
		int num=r.nextInt();
		return num;
	}
	public StringBuilder getRandomAlphaNumericValue(int size) {
		String alphanum="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdedghijklmnopqrstuvwxyz";
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<size;i++) {
			int index=(int)(alphanum.length()*Math.random());
			sb.append(alphanum.charAt(index));
		}
		return sb;
	}
	public String expDate(int num) {
		return LocalDate.now().plusDays(num).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	public String currentDate() {
		return LocalDate.now().toString();
	}
}
