package coom.day09;

public class ScienceBioStudent extends Science {
	final static String BIO_PREFIX = "SB";
	  private float bioTheoryMarks;
	  private float bioPracticalMarks;

//	  constructor, setter and getter methods

	  ScienceBioStudent(float bioTheoryMarks, float bioPracticalMarks, float physicsTheoryMarks, float physicsPracticalMarks, float chemistryTheoryMarks, float chemistryPracticalMarks){
	    //write code to set instance variables
		  super("SB",  physicsTheoryMarks,  physicsPracticalMarks, chemistryTheoryMarks, chemistryPracticalMarks);
		  this.bioTheoryMarks = bioTheoryMarks;
		  this.bioPracticalMarks = bioPracticalMarks;
	  }

	  public float getBioTheoryMarks() {
		return bioTheoryMarks;
	}

	public void setBioTheoryMarks(float bioTheoryMarks) {
		this.bioTheoryMarks = bioTheoryMarks;
	}

	public float getBioPracticalMarks() {
		return bioPracticalMarks;
	}

	public void setBioPracticalMarks(float bioPracticalMarks) {
		this.bioPracticalMarks = bioPracticalMarks;
	}

	public static String getBioPrefix() {
		return BIO_PREFIX;
	}

	@Override
	  public double getPercentage(){
	    //write code here to return percentage up to two decimal places
		double totalMarks = getBioTheoryMarks()+getBioPracticalMarks()+getPhysicsTheoryMarks()+getPhysicsPracticalMarks()+getChemistryTheoryMarks()+getChemistryPracticalMarks();
		double percentage = totalMarks/3;
		
		return percentage;
	  }
}
