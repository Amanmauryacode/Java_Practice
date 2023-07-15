package coom.day09;

public class ScienceMathsStudent extends Science {
	final static String MATHS_PREFIX = "SM";
	  private float mathsMarks;

	  ScienceMathsStudent(float mathsMarks, float physicsTheoryMarks, float physicsPracticalMarks, float chemistryTheoryMarks, float chemistryPracticalMarks){
	    //write code to set instance variables
		  super("SM",  physicsTheoryMarks,  physicsPracticalMarks, chemistryTheoryMarks, chemistryPracticalMarks);
		  this.mathsMarks =mathsMarks;
	  }

//	  generate required setter and getter methods

	  public float getMathsMarks() {
		return mathsMarks;
	}

	public void setMathsMarks(float mathsMarks) {
		this.mathsMarks = mathsMarks;
	}

	public static String getMathsPrefix() {
		return MATHS_PREFIX;
	}

	@Override
	  public double getPercentage(){
	    //write code here to return percentage up to two decimal places
		double totalMarks = getMathsMarks()+getPhysicsTheoryMarks()+getPhysicsPracticalMarks()+getChemistryTheoryMarks()+getChemistryPracticalMarks();
		double percentage = totalMarks/3;
		
		return percentage;
	  }
}
