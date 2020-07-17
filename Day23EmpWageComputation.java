import java.util.*;

interface IComputeEmpWage{

	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursInMonth);
	public void computeEmpWage();
	public int getTotalWage(String company);
}

class CompanyEmpWage{

	public final String company;
	public final int empRatePerHour;
	public final int numOfWorkingDays;
	public final int maxHoursPerMonth;
	public int totalEmpWage;

	public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth){

		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;
		totalEmpWage = 0;
	}

	public void setTotalEmpWage(int totalEmpWage){

		this.totalEmpWage = totalEmpWage;
	}

	@Override
	public String toString(){

		return "Total Emp Wage For Company : "+company + " is : "+totalEmpWage;
	}
}


public class Day23EmpWageComputation implements IComputeEmpWage {

	public static final int isPartTime = 1;
	public static final int isFullTime = 2;


	private int numOfCompany = 0;

	private LinkedList<CompanyEmpWage> companyEmpWageList;
	private Map<String,CompanyEmpWage> companyToEmpWageMap;

	public Day23EmpWageComputation(){

		companyEmpWageList= new LinkedList<>();
		companyToEmpWageMap = new HashMap<>();
	}

	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth){

		CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
		companyEmpWageList.add(companyEmpWage);
		companyToEmpWageMap.put(company, companyEmpWage);
	}

	public void computeEmpWage(){

		for (int i= 0; i < companyEmpWageList.size(); i++){

			CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
			companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
			System.out.println(companyEmpWage);

		}
	}
	@Override
	public int getTotalWage(String company){

		return companyToEmpWageMap.get(company).totalEmpWage;

	}

	public int computeEmpWage(CompanyEmpWage companyEmpWage){
		int totalEmpHrs = 0, totalEmpWage = 0, totalWorkingDays = 0;
		while ( totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays )
		{
			totalWorkingDays++;
			int empHrs = 0, empWage = 0;
			int empCheck =(int) Math.floor(Math.random() * 10) % 3;
			switch (empCheck)
			{
				case isFullTime:
					empHrs = 8;
					break;
				case isPartTime:
					empHrs = 4;
					break;
				default:
					empHrs = 0;
			}
			totalEmpHrs += empHrs;
			empWage = empHrs * companyEmpWage.empRatePerHour;
			totalEmpWage += empWage;
			System.out.println("Employee Wage : "+companyEmpWage.company+" "+empWage);
		}
		System.out.println("Total Employee Wage: " + totalEmpWage);
		return totalEmpHrs*companyEmpWage.empRatePerHour;

	}

	public static void main(String [] args){

		IComputeEmpWage empWageBuilder = new Day23EmpWageComputation();
		empWageBuilder.addCompanyEmpWage("Dmart",20,2,10);
		empWageBuilder.computeEmpWage();
		
		empWageBuilder.addCompanyEmpWage("Relince",10,4,20);
		empWageBuilder.computeEmpWage();


		System.out.println("Total wage for dmart Company : "+empWageBuilder.getTotalWage("Dmart"));
	}

}
