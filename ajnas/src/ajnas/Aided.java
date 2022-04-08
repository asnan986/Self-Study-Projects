package ajnas;

import java.util.regex.Pattern;

public class Aided extends Student{
	
	private int creditPoint;
	private double gradePointSum;

	@Override
	public String function(String s) {
		
		String[] splitted = s.split(Pattern.quote("|"));
		
		
			String[] subjectMark =splitted[0].split(",");
			String[] nccMark=splitted[1].split(",");
			String[] sportsMark=splitted[2].split(",");
			for(String subjectTemp:subjectMark) {
				String[] indvidual= subjectTemp.split(" ");
				int i=0;
				for(String indvidualTemp: indvidual) {
					if(i%2==0)
						this.gradePointSum+=(Double.parseDouble(indvidualTemp)/10)*
								Integer.parseInt(indvidual[i+1]);
					else
						this.creditPoint+=5;
					
				i++;
				}
			}
			
			if (nccMark[0].equals("1"))
					{
				      this.gradePointSum+=(Double.parseDouble(nccMark[1])/10)*
								Integer.parseInt(nccMark[2]);
				      this.creditPoint+=5;
				      
					}
			if (sportsMark[0].equals("1"))
			{
		      this.gradePointSum+=(Double.parseDouble(sportsMark[1])/10)*
						Integer.parseInt(sportsMark[2]);
		      this.creditPoint+=5;
		      
			}
			
			String CGPA=Double.toString((this.gradePointSum)/(this.creditPoint));
			
		
		return CGPA;
	}

	
}
