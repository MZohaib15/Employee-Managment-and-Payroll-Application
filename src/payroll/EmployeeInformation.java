/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mzohaib
 */
public class EmployeeInformation {
    private int employeeId;
    private String employeeName;
    private String hireDate;
    private int grossSalary;
    private String deptName;
    private String PC;
    private String shift;
    private int basicSalary;
    private int rentAllow;
    private int medAllow;
    private int convAllow;
    private String cnic;
    private String fatherName;
    private String resignDate;
    private int p_fund;
    private int itax;
    private int adv_salary;
    private int pfLoan;
    private int personal_loan;
    private int mess_ded;
    private int eobi;
    private int other_ded;
    
    EmployeeInformation(){
        cnic="Not Available";
        fatherName="Not Available";
        resignDate="Not Available";
        p_fund=0;
        itax=0;
        adv_salary=0;
        pfLoan=0;
        personal_loan=0;
        mess_ded=0;
        eobi=0;
        other_ded=0;
    }
    EmployeeInformation(int eid,String ename,String hDate,int gSalary,String dName, String pc,String shft,int bsalary,int rAllow,int mAllow,int cAllow){
        employeeId=eid;
        employeeName=ename;
        hireDate=hDate;
        grossSalary=gSalary;
        deptName=dName;
        PC=pc;
        shift=shft;
        basicSalary=bsalary;
        rentAllow=rAllow;
        medAllow=mAllow;
        convAllow=cAllow;
    }
    void setEmployeeId(int eid){
        employeeId=eid;
    }
    void setEmployeeName(String ename){
        employeeName=ename;
    }
    void sethireDate(String hDate){
        hireDate=hDate;
    }
    void setGrossSalary(int gSalary){
        grossSalary=gSalary;
    }
    void setDeptName(String dName){
        deptName=dName;
    }
    void setPC(String pc){
        PC=pc;
    }
    void setShift(String shft){
        shift=shft;
    }
    void setBasicSalary(int bsalary){
        basicSalary=bsalary;
    }
    void setRentAllow(int rAllow){
        rentAllow=rAllow;
    }
    void setMedAllow(int mAllow){
        medAllow=mAllow;
    }
    void setConvAllow(int cAllow){
        convAllow=cAllow;
    }
    void setCnic(String nic){
        cnic=nic;
    }
    void setFatherName(String fname){
        fatherName=fname;
    }
    void setResignDate(String rdate){
        resignDate=rdate;
    }
    void setP_Fund(int pfund){
        p_fund=pfund;
    }
    void setAdvSal(int advSal){
        adv_salary=advSal;
    }
    void setItax(int i_tax){
        itax=i_tax;
    }
    void setPF_Loan(int pf_Loan){
        pfLoan=pf_Loan;
    }
    void setPersonalLoan(int persLoan){
        personal_loan=persLoan;
    }
    void setMessDed(int mded){
        mess_ded=mded;
    }
    void setEOBI(int EOBI){
        eobi=EOBI;
    }
    void setOtherDed(int oded){
        other_ded=oded;
    }
    
    
    int getEmployeeId(){
        return employeeId;
    }
    String getEmployeeName(){
        return employeeName;
    }
    String gethireDate(){
        return hireDate;
    }
    int getGrossSalary(){
        return grossSalary;
    }
    String getDeptName(){
        return deptName;
    }
    String getPC(){
        return PC;
    }
    String getShift(){
        return shift;
    }
    int getBasicSalary(){
        return basicSalary;
    }
    int getRentAllow(){
        return rentAllow;
    }
    int getMedAllow(){
        return medAllow;
    }
    int getConvAllow(){
        return convAllow;
    }
    String getCNIC(){
        return cnic;
    }
    String getFatherName(){
        return fatherName;
    }
    String getResignDate(){
        return resignDate;
    }
    int getPFund(){
        return p_fund;
    }
    int getItax(){
        return itax;
    }
    int getAdvSalary(){
        return adv_salary;
    }
    int getPFLoan(){
        return pfLoan;
    }
    int getPersonalLoan(){
        return personal_loan;
    }
    int getMessDed(){
        return mess_ded;
    }
    int getEOBI(){
        return eobi;
    }
    int getOtherDed(){
        return other_ded;
    }
    
    void printEmployeeInfo(){
        if(employeeId!=0){
            System.out.printf("%-15d%-2s%-37s%-2s%-15s%-2s%-17d%-2s%-35s%-2s%-15s%-2s%-16s%-2s%-27d%-2s%-27d%-2s%-27d%-2s%-27d%n",employeeId,"  ",employeeName,"  ",hireDate,"  ",grossSalary,"  ",deptName,"  ",PC,"  ",shift,"  ",basicSalary,"  ",rentAllow,"  ",medAllow,"  ",convAllow);
        }
    }
}
