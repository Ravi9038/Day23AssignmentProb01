
class CompanyEmpWage{

	public final String company;
	public final int empRatePerHr;
	public final int numOfWorkingDays;
	public final int maxHrsPerMonth;
	public int totalEmpWage;

	public CompanyEmpWage(String company, int empRatePerHr, int numOfWorkingDays, int maxHrsPerMonth){

		this.company = company;
		this.empRatePerHr = empRatePerHr;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHrsPerMonth = maxHrsPerMonth;
	}

	public void setTotalEmpWage(int totalEmpWage){

		this.totalEmpWage = totalEmpWage;
	}

	public String toString(){

		return "Total Emp Wage for Company : "+company+ " is : "+totalEmpWage;
	}
}

class EmpWageBuilderArray{

	public static final int isPartTime = 1;
	public static final int isFullTime = 2;

	private int numOfCompany = 0;
	private CompanyEmpWage[] companyEmpWageArray;

	public EmpWageBuilderArray(){

		companyEmpWageArray = new CompanyEmpWage[5];
	}

	private void addCompanyEmpWage(String company, int empRatePerHr, int numOfWorkingDays, int maxHrPerMonth){

		companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHr, numOfWorkingDays, maxHrPerMonth);

		numOfCompany++;
	}

	private void computeEmpWage(){

		for (int i = 0;i < numOfCompany; i++){

			companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
		}
	}

	private int computeEmpWage(CompanyEmpWage companyEmpWage){

		int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;

		while (totalEmpHrs <= companyEmpWage.maxHrsPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays){

			totalWorkingDays++;
			int empCheck = (int) Math.floor(Math.random()*10)%3;

			switch (empCheck){

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
			System.out.println("Days : "+totalWorkingDays + " Emp Hr "+empHrs);
		}
		return totalEmpHrs * companyEmpWage.empRatePerHr;
	}

	public static void main(String [] args){

		EmpWageBuilderArray empWageBuilder = new EmpWageBuilderArray();

		empWageBuilder.addCompanyEmpWage("Dmart",20,2,10);
		empWageBuilder.computeEmpWage();
	}

}
