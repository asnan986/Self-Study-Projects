package ajnas;

import java.util.regex.Pattern;

public class SelfFinance extends Student{
	
	private int creditPoint;
	private double gradePointSum;

	@Override
	public String function(String s) {
		
		String[] splitted = s.split(Pattern.quote("|"));
		
		
			String[] subjectMark =splitted[0].split(",");
		
			String[] sportsMark=splitted[1].split(",");
			
			for(String subjectTemp:subjectMark) {
			
				String[] indvidual= subjectTemp.split(" ");
				int i=0;
				for(String indvidualTemp: indvidual) {
			
					if(i%2==0) {
						this.gradePointSum+=(Double.parseDouble(indvidualTemp)/10)*
								Integer.parseInt(indvidual[i+1]);
					}
					else
						this.creditPoint+=5;
					
				i++;
				}
			}
			
			
			if (sportsMark[0].equals("1"))
			{
		      this.gradePointSum+=(Double.parseDouble(sportsMark[1])/100)*
						Integer.parseInt(sportsMark[3]);
		      this.creditPoint=5;
		      
			}
			
			String CGPA=Double.toString((this.gradePointSum)/(this.creditPoint));
			
		
		return CGPA;

}
}
