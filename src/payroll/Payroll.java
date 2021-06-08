/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

import java.awt.Color;
import java.sql.Connection;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 *
 * @author mzohaib
 */

public class Payroll {

    /**
     * @param args the command line arguments
     */
    
    static HomePage homePageJFrame=null;

    public static void main(String[] args) throws ParseException {
        
        DB_CRUD db_crud=DB_CRUD.getInstance();
        
        homePageJFrame=new HomePage();
        homePageJFrame.setVisible(true);
        homePageJFrame.setLocationRelativeTo(null);
        JProgressBar jProgressBar,jProgressBar2;
        
        jProgressBar=homePageJFrame.getJProgressBar();
        jProgressBar.setVisible(false);
        jProgressBar.setBackground(Color.blue);
        
        jProgressBar2=homePageJFrame.getJProgressBar2();
        jProgressBar2.setVisible(false);
        jProgressBar.setBackground(Color.blue);
        
        
       
    }
    
    
    static public void read_xls(String path,List<EmployeeInformation>employeeList){
        
        int count=0;
        
        try {
        FileInputStream fis=new FileInputStream(new File(path));  
        //creating workbook instance that refers to .xls file  
        HSSFWorkbook wb=new HSSFWorkbook(fis);   
        //creating a Sheet object to retrieve the object  
        HSSFSheet sheet=wb.getSheetAt(0);  
        //evaluating cell type   
        FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();  
        boolean flag=true;
        for(Row row: sheet)     //iteration over row using for each loop  
        {  
            EmployeeInformation employeeInformation = new EmployeeInformation();
            count=0;
            for(Cell cell: row)    //iteration over cell using for each loop  
            {  
                if(flag){
                    flag=false;
                    continue;
                }
                switch(formulaEvaluator.evaluateInCell(cell).getCellTypeEnum())  
                {  
                case NUMERIC:   //field that represents numeric cell type  
                //getting the value of the cell as a number  
                if(DateUtil.isCellDateFormatted(cell)){
                    SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
               //     System.out.print(dateFormat.format(cell.getDateCellValue())+ "\t\t");
                    Date hdate=cell.getDateCellValue();
                    String strDate=dateFormat.format(hdate);
                    employeeInformation.sethireDate(strDate);
                }
                else{
                    long cell_value=Math.round(cell.getNumericCellValue());
                    int value=(int)cell_value;
                    if(count==0){
                        employeeInformation.setEmployeeId(value);
                    }
                    else if(count==3){
                        employeeInformation.setGrossSalary(value);
                    }
                    else if(count==7){
                        employeeInformation.setBasicSalary(value);
                    }
                    else if(count==8){
                        employeeInformation.setRentAllow(value);
                    }
                    else if(count==9){
                        employeeInformation.setMedAllow(value);
                    }
                    else if(count==10){
                        employeeInformation.setConvAllow(value);
                    }
                    
             //       System.out.print(Math.round(cell.getNumericCellValue())+ "\t\t");  
                }
                break;  
                case STRING:    //field that represents string cell type  
                //getting the value of the cell as a string  
                    if(count==1){
                        employeeInformation.setEmployeeName(cell.getStringCellValue());
                    }
                    else if(count==2){ // if date has formatting issue in excel sheet
                        employeeInformation.sethireDate(cell.getStringCellValue());
                    }
                    else if(count==4){
                        employeeInformation.setDeptName(cell.getStringCellValue());
                    }
                    else if(count==5){
                        employeeInformation.setPC(cell.getStringCellValue());
                    }
                    else if(count==6){
                        employeeInformation.setShift(cell.getStringCellValue());
                    }
              //  System.out.print(cell.getStringCellValue()+ "\t\t");  
                break;  
                }
                count++;
            }  
         //   System.out.println();  
            employeeList.add(employeeInformation); 
            System.out.println();  
        }
       }
         catch(Exception e)  
        {  
        e.printStackTrace();  
        }
        
    }
    
    static public void read_xls_attend(String path,List<EmployeeInformation> employeeInformations,List<EmployeeSalary> salaryList,String date,DB_CRUD db_crud){
        
        
        try {
        boolean check=false;
        int count=0;        
        FileInputStream fis=new FileInputStream(new File(path));  
        //creating workbook instance that refers to .xls file  
        HSSFWorkbook wb=new HSSFWorkbook(fis);   
        //creating a Sheet object to retrieve the object  
        HSSFSheet sheet=wb.getSheetAt(0);  
        //evaluating cell type   
        FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator(); 
        int id_value=-1;
        int val=0;
        int currId=-1;
        EmployeeSalary employeeSalary=new EmployeeSalary();
        int totalWorkTime=0;
        EmployeeInformation e=null;
        float gSal=0;
        int countCL=0;
        float paidHolidayCount=0; // includes CL and Sunday
        float unpaidHolidayCount=0;
        System.out.printf("%-10s%-2s%-37s%-2s%-15s%-2s%-15s%-2s%-15s%n","ID","  ","Name","  ","Gross Salary","  ","Earned Salary","  ","Net Salary");
        System.out.println("");
        for(Row row: sheet)     //iteration over row using for each loop  
        {  
            count=0;
            for(Cell cell: row)    //iteration over cell using for each loop  
            {  
                switch(formulaEvaluator.evaluateInCell(cell).getCellTypeEnum())  
                {  
                case NUMERIC:   //field that represents numeric cell type  
                    
                    long cell_value=Math.round(cell.getNumericCellValue());
                    
                    if(count==0){
                        id_value=(int)cell_value;
                        if(currId!=id_value&&currId!=-1){
                                if(searchList(employeeInformations,0,employeeInformations.size(), id_value)!=-1){ // if employee exists in database
                                    employeeSalary.setWorkTime(totalWorkTime);
                                    e=employeeInformations.get(searchList(employeeInformations,0,employeeInformations.size(), currId));
                                    employeeSalary.setEmpName(e.getEmployeeName());
                                    employeeSalary.setSalaryDate(date);
                                    employeeSalary.computeSalary(e,paidHolidayCount,unpaidHolidayCount);
                                    salaryList.add(employeeSalary);
                                    //System.out.println("ID: "+e.getEmployeeId()+"           Name: "+e.getEmployeeName()+"           Net_Salary: "+employeeSalary.getNetSalary());

                                    System.out.printf("%-10d%-2s%-37s%-2s%-15d%-2s%-15d%-2s%-15d%-2s%-15s%n",e.getEmployeeId(),"  ",e.getEmployeeName(),"  ",e.getGrossSalary(),"  ",employeeSalary.getEarnedSalary(),"  ",employeeSalary.getNetSalary(),"  ",employeeSalary.getSalaryDate());
                                    
                                    totalWorkTime=0;
                                    paidHolidayCount=0;
                                    unpaidHolidayCount=0;
                                    employeeSalary=new EmployeeSalary();
                                    employeeSalary.setEmployeeId(id_value);
                                    currId=id_value;
                                }
                                else{
                                    check=true;
                                }
                        }
                        else if(currId==-1){
                            if(searchList(employeeInformations,0,employeeInformations.size(), id_value)==-1){
                                check=true;
                            }
                            else{
                                currId=id_value;
                                employeeSalary.setEmployeeId(id_value);
                            }
                        }
                    }
                    else if(count==5){
                       // if(cell!=null||cell.getCellTypeEnum()!=CellType.BLANK){
                        val=(int)cell_value;
                        totalWorkTime=totalWorkTime+val;
                       // }
                    }
                    
             //       System.out.print(Math.round(cell.getNumericCellValue())+ "\t\t");  
                break;  
                case STRING:    //field that represents string cell type
                    if(count>1){
                        String holiday=cell.getStringCellValue();
                        if("R".equalsIgnoreCase(holiday)||"CL".equalsIgnoreCase(holiday)||"G".equalsIgnoreCase(holiday)){ // if sunday
                           paidHolidayCount++;    
                        }
                        else if("A".equalsIgnoreCase(holiday)){
                            unpaidHolidayCount++;
                        }
                    }
                break; 
                
                }
                if(!check){
                    count++;
                }
                else{
                    check=false;
                    break;
                }
            }     
          }
        employeeSalary.setWorkTime(totalWorkTime);
        e=employeeInformations.get(searchList(employeeInformations,0,employeeInformations.size(), currId));
        employeeSalary.setEmpName(e.getEmployeeName());
        employeeSalary.setSalaryDate(date);
        employeeSalary.computeSalary(e,paidHolidayCount,unpaidHolidayCount);
        salaryList.add(employeeSalary);
        db_crud.insertSalaryDataInDB(salaryList, homePageJFrame,date);
        System.out.printf("%-10d%-2s%-37s%-2s%-15d%-2s%-15d%-2s%-15d%n",e.getEmployeeId(),"  ",e.getEmployeeName(),"  ",e.getGrossSalary(),"  ",employeeSalary.getEarnedSalary(),"  ",employeeSalary.getNetSalary());
       }
         catch(Exception e)  
        {
            JOptionPane.showMessageDialog(homePageJFrame, "Upload FAILED!");
            e.printStackTrace();  
        }
        
    }
    
    static public void read_xlsx(String path,List<EmployeeInformation>employeeList){
        
        int count=0;
        
        try  {  
        File file = new File(path);   //creating a new file instance  
        FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
        //creating Workbook instance that refers to .xlsx file  
        XSSFWorkbook wb = new XSSFWorkbook(fis);   
        XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
        FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();
        boolean flag=true;
        for(Row row: sheet)     //iteration over row using for each loop  
        {  
            EmployeeInformation employeeInformation = new EmployeeInformation();
            count=0;
            for(Cell cell: row)    //iteration over cell using for each loop  
            {  
                if(flag){
                    flag=false;
                    continue;
                }
                switch(formulaEvaluator.evaluateInCell(cell).getCellTypeEnum())  
                {  
                case NUMERIC:   //field that represents numeric cell type  
                //getting the value of the cell as a number  
                if(DateUtil.isCellDateFormatted(cell)){
                    SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
               //     System.out.print(dateFormat.format(cell.getDateCellValue())+ "\t\t");
                    Date hdate=cell.getDateCellValue();
                    String strDate=dateFormat.format(hdate);
                    employeeInformation.sethireDate(strDate);
                }
                else{
                    long cell_value=Math.round(cell.getNumericCellValue());
                    int value=(int)cell_value;
                    if(count==0){
                        employeeInformation.setEmployeeId(value);
                    }
                    else if(count==3){
                        employeeInformation.setGrossSalary(value);
                    }
                    else if(count==7){
                        employeeInformation.setBasicSalary(value);
                    }
                    else if(count==8){
                        employeeInformation.setRentAllow(value);
                    }
                    else if(count==9){
                        employeeInformation.setMedAllow(value);
                    }
                    else if(count==10){
                        employeeInformation.setConvAllow(value);
                    }
                    
             //       System.out.print(Math.round(cell.getNumericCellValue())+ "\t\t");  
                }
                break;  
                case STRING:    //field that represents string cell type  
                //getting the value of the cell as a string  
                    if(count==1){
                        employeeInformation.setEmployeeName(cell.getStringCellValue());
                    }
                    else if(count==2){ // if date has formatting issue in excel sheet
                        employeeInformation.sethireDate(cell.getStringCellValue());
                    }
                    else if(count==4){
                        employeeInformation.setDeptName(cell.getStringCellValue());
                    }
                    else if(count==5){
                        employeeInformation.setPC(cell.getStringCellValue());
                    }
                    else if(count==6){
                        employeeInformation.setShift(cell.getStringCellValue());
                    }
              //  System.out.print(cell.getStringCellValue()+ "\t\t");  
                break;  
                }
                count++;
            }  
         //   System.out.println();  
            employeeList.add(employeeInformation);
        }
        
        }  
        catch(Exception e)  
        {  
        e.printStackTrace();  
        }
        
    }
    
    
    static public void read_xlsx_attend(String path,List<EmployeeInformation> employeeInformations,List<EmployeeSalary> salaryList,String date,DB_CRUD db_crud){
        
        try  {  
         
        boolean check=false;    
        int count=0;    
        File file = new File(path);   //creating a new file instance  
        FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
        //creating Workbook instance that refers to .xlsx file  
        XSSFWorkbook wb = new XSSFWorkbook(fis);   
        XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
        FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();
        int id_value=-1;
        int val=0;
        int currId=-1;
        EmployeeSalary employeeSalary=new EmployeeSalary();
        int totalWorkTime=0;
        EmployeeInformation e=null;
        float gSal=0;
        int countCL=0;
        float paidHolidayCount=0; // includes CL and Sunday
        float unpaidHolidayCount=0;
        System.out.printf("%-10s%-2s%-37s%-2s%-15s%-2s%-15s%-2s%-15s%-2s%-15s%n","ID","  ","Name","  ","Gross Salary","  ","Earned Salary","  ","Net Salary","  ","Salary Date");
        System.out.println("");
        for(Row row: sheet)     //iteration over row using for each loop  
        {  
            count=0;
            for(Cell cell: row)    //iteration over cell using for each loop  
            {  
                switch(formulaEvaluator.evaluateInCell(cell).getCellTypeEnum())  
                {  
                case NUMERIC:   //field that represents numeric cell type  
                    
                    long cell_value=Math.round(cell.getNumericCellValue());
                    
                    if(count==0){
                        id_value=(int)cell_value;
                        if(currId!=id_value&&currId!=-1){
                                if(searchList(employeeInformations,0,employeeInformations.size(), id_value)!=-1){ // if employee exists in database
                                    employeeSalary.setWorkTime(totalWorkTime);
                                    e=employeeInformations.get(searchList(employeeInformations,0,employeeInformations.size(), currId));
                                    employeeSalary.setEmpName(e.getEmployeeName());
                                    employeeSalary.setSalaryDate(date);
                                    employeeSalary.computeSalary(e,paidHolidayCount,unpaidHolidayCount);
                                    salaryList.add(employeeSalary);
                                    //System.out.println("ID: "+e.getEmployeeId()+"           Name: "+e.getEmployeeName()+"           Net_Salary: "+employeeSalary.getNetSalary());

                                    System.out.printf("%-10d%-2s%-37s%-2s%-15d%-2s%-15d%-2s%-15d%-2s%-15s%n",e.getEmployeeId(),"  ",e.getEmployeeName(),"  ",e.getGrossSalary(),"  ",employeeSalary.getEarnedSalary(),"  ",employeeSalary.getNetSalary(),"  ",employeeSalary.getSalaryDate());
                                    
                                    totalWorkTime=0;
                                    paidHolidayCount=0;
                                    unpaidHolidayCount=0;
                                    employeeSalary=new EmployeeSalary();
                                    employeeSalary.setEmployeeId(id_value);
                                    currId=id_value;
                                }
                                else{
                                    check=true;
                                }
                        }
                        else if(currId==-1){
                            if(searchList(employeeInformations,0,employeeInformations.size(), id_value)==-1){
                                check=true;
                            }
                            else{
                                currId=id_value;
                                employeeSalary.setEmployeeId(id_value);
                            }
                        }
                    }
                    else if(count==5){
                       // if(cell!=null||cell.getCellTypeEnum()!=CellType.BLANK){
                        val=(int)cell_value;
                        totalWorkTime=totalWorkTime+val;
                       // }
                    }
                    
             //       System.out.print(Math.round(cell.getNumericCellValue())+ "\t\t");  
                break;  
                case STRING:    //field that represents string cell type
                    if(count>1){
                        String holiday=cell.getStringCellValue();
                        if("R".equalsIgnoreCase(holiday)||"CL".equalsIgnoreCase(holiday)||"G".equalsIgnoreCase(holiday)){ // if sunday
                           paidHolidayCount++;    
                        }
                        else if("A".equalsIgnoreCase(holiday)){
                            unpaidHolidayCount++;
                        }
                    }
                break; 
                
                }
                if(!check){
                    count++;
                }
                else{
                    check=false;
                    break;
                }
            }  
            
        }
        
        employeeSalary.setWorkTime(totalWorkTime);
        e=employeeInformations.get(searchList(employeeInformations,0,employeeInformations.size(), currId));
        employeeSalary.setEmpName(e.getEmployeeName());
        employeeSalary.setSalaryDate(date);
        employeeSalary.computeSalary(e,paidHolidayCount,unpaidHolidayCount);
        salaryList.add(employeeSalary);
        db_crud.insertSalaryDataInDB(salaryList, homePageJFrame,date);
        System.out.printf("%-10d%-2s%-37s%-2s%-15d%-2s%-15d%-2s%-15d%-2s%-15s%n",e.getEmployeeId(),"  ",e.getEmployeeName(),"  ",e.getGrossSalary(),"  ",employeeSalary.getEarnedSalary(),"  ",employeeSalary.getNetSalary(),"  ",employeeSalary.getSalaryDate());
        
        
        }  
        catch(Exception e)  
        {  
        JOptionPane.showMessageDialog(homePageJFrame, "Upload FAILED!");
        e.printStackTrace();
        }
        
    }
    
    
    
    static int fileFormatCheck(String path){
        StringBuffer str=new StringBuffer(path);
        str=str.reverse();
        int i=0; int count=0;
        while(str.charAt(i)!='.'){
            count++;
            i++;
        }
        return count; // if count==3 then xls format else if count ==4 then xlsx
    }
    
    static HomePage getHomePage(){
        return homePageJFrame;
    }
    
    static int searchList(List<EmployeeInformation> list,int l,int r,int id){
        for(int i=0;i<r;i++){
            if(list.get(i).getEmployeeId()==id){
                return i;
            }
        }
        return -1;
    }
    
}