public class Day23EmpWageComputation{

	public static final int isPartTime = 1;
	public static final int isFullTime = 2;
	public static final int empRatePerHr=20;

	public static void main(String [] args){


		int empHrs = 0;
		int empWage = 0;

		int empCheck = (int) Math.floor(Math.random()*10) % 3;

		switch(empCheck){

			case isPartTime :
				empHrs = 4;
				break;
			case isFullTime :
				empHrs = 8;
				break;

			default :
				empHrs = 0;
		}
		empWage = empHrs * empRatePerHr;
		System.out.println("Emp Wage "+ empWage);
	}
}
