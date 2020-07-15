public class Day23EmpWageComputation{

	public static final int isPartTime = 1;
	public static final int isFullTime = 2;
	public static final int empRatePerHr=20;
	public static final int numOfWorkingDays=3;
	public static final int maxHrsInMonth=10;

	public static void main(String [] args){


		int empHrs = 0;
		int totalEmpHrs = 0;
		int totalWorkingDays = 0;

		while (totalEmpHrs <= maxHrsInMonth && totalWorkingDays < numOfWorkingDays){
			totalWorkingDays++;

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
			totalEmpHrs += empHrs;
			System.out.println("Day : "+totalWorkingDays + " Emp Hrs : "+empHrs);
		}

		int totalEmpWage = totalEmpHrs * empRatePerHr;
		System.out.println("Total Emp Wage "+ totalEmpWage);
	}
}	
