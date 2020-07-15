public class Day23EmpWageComputation{
	
	
	public static final int isFullTime = 1;
	public static final int isPartTime = 2;
	public static final int empRatePerHr = 20;
	public static final int numOfWorkingDays = 2;
	public static final int maxHrsInMonth = 10;

	public void computeWage(){

		int  empHrs = 0;
		int totalEmpHrs = 0;
		int totalWorkingDays = 0;

		while (totalEmpHrs <= maxHrsInMonth && totalWorkingDays < numOfWorkingDays){

			totalWorkingDays++;

			int empCheck = (int) Math.floor(Math.random()*10)%3;

			switch (empCheck){

				case isFullTime :
					empHrs = 8;
					break;

				case isPartTime :
					empHrs = 4;
					break;

				default :
					empHrs = 0;

			}

			totalEmpHrs += empHrs;
			System.out.println("Day : "+totalWorkingDays + "Emp Hrs : "+empHrs);
		}

		int totalEmpWage = totalEmpHrs * empRatePerHr;

		System.out.println("Total Emp Wage : "+totalEmpWage);
	}

	public static void main(String [] args){


		UC7Refactor u7 = new UC7Refactor();
		u7.computeWage();

	}
}
