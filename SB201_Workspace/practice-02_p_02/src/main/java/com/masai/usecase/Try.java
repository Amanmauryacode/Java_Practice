package com.masai.usecase;

public class Try {

}

//abstract  Job() {
//	public static void Jobs();
//}

class Collage{ 
	public void doJob(){
		System.out.println("Job is started");
		//here it needs the service of its Dependencies
		}
	public static void Jobs() {
		Collage c = new Collage();
		c.doJob();
	}

}





class Teacher{
	private Collage c;
	
		public void setC(Collage c) {
		this.c = c;
	}

		public void teaches(){
		      System.out.println("Teacher teaches");
		}
}


 
class Clerk{
		public void registerStudent(){
		    System.out.println("enroll the Student in Collage");
		}
 }