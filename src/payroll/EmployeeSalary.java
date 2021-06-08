/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

/**
 *
 * @author mzohaib
 */
public class EmployeeSalary {
    private int workingTime; // total working time of the whole month
    private int employeeId;
    private int netSalary;
    private int earnedSalary;
    private String salaryDate;
    private String employeeName;

    public EmployeeSalary() {
        employeeName=null;
    }
    public EmployeeSalary(int wt,int eid,int n_salary,String ename) {
        workingTime=wt;
        employeeId=eid;
        netSalary=n_salary;
        employeeName=ename;
    }
    public void setEmployeeId(int id){
        employeeId=id;
    }
    public void setWorkTime(int wTime){
        workingTime=wTime;
    }
    public void setNetSalary(int sal){
        netSalary=sal;
    }
    public void setEarnedSalary(int sal){
        earnedSalary=sal;
    }
    public void setEmpName(String ename){
        employeeName=ename;
    }
    public void setSalaryDate(String date){
        salaryDate=date;
    }
    public String getSalaryDate(){
        return salaryDate;
    }
    public int getWorkTime(){
        return workingTime;
    }
    public int getEmployeeId(){
        return employeeId;
    }
    public int getNetSalary(){
        return netSalary;
    }
    public int getEarnedSalary(){
        return earnedSalary;
    }
    public void computeSalary(EmployeeInformation e,float paidHolidayCount,float unpaidHolidayCount){
        
        float gSalary=(float)e.getGrossSalary();
        String shift=e.getShift();
        float workTime=(float)workingTime;
        float esalary=0;
        float nsalary=0;
        
        float perMinuteSalary=gSalary/30;
        
        int deductions_sum=0;
        deductions_sum=deductions_sum+e.getPFund()+e.getItax()+e.getAdvSalary()+e.getPFLoan()+e.getPersonalLoan()+e.getMessDed()+e.getEOBI()+e.getOtherDed();
        float deductions=(float)deductions_sum;
        
        
        if(shift.equalsIgnoreCase("A")||shift.equalsIgnoreCase("C")){ // if per day working hours required = 8.5 hours, i.e 510 minutes
            perMinuteSalary=perMinuteSalary/510; 
            workTime=workTime+(510*paidHolidayCount);
            //workingTime=workingTime-(510*unpaidHolidayCount);
        }
        else{ // if per day working hours required = 9 hours, i.e 540 minutes
            perMinuteSalary=perMinuteSalary/540;
            workTime=workTime+(540*paidHolidayCount);
            //workingTime=workingTime-(540*unpaidHolidayCount);
        }
        esalary=perMinuteSalary*workTime;
        nsalary=esalary-deductions;
        
        earnedSalary=Math.round(esalary);
        netSalary=Math.round(nsalary);
        workingTime=(int)workTime;
    }
    public void printSalaryInfo(){
        System.out.println("ID: "+employeeId+"      Name: "+employeeName+"      Net_Salary: "+netSalary);
    }
}
