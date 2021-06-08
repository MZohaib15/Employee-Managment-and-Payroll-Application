/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author mzohaib
 */
public class DB_CRUD {
    private String jdbcURL;
    private String username;
    private String password;
    private static DB_CRUD db_instance = new DB_CRUD();

    private DB_CRUD() {
       try{
        jdbcURL="jdbc:mysql://localhost:3306/EmployeeInformationDB";
        username="root";
        password="arianagrande";
        Connection connection = DriverManager.getConnection(jdbcURL,username,password);
        } catch(Exception e){
            System.out.println("e");
       }
    }
    
   public static DB_CRUD getInstance(){
      return db_instance;
   }
   
   //Database code for the table employeeInfo :-
    
    public void insertDB(List<EmployeeInformation> employeeList,HomePage homePageJFrame){
        
            try{
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            
            if(connection!=null){
                JProgressBar jProgressBar=homePageJFrame.getJProgressBar();
                System.out.println("Connected to the Database");
                
                JOptionPane.showMessageDialog(homePageJFrame, "File Uploading...Press OK and Wait!.");
                
                JLabel jlabel=homePageJFrame.getjLabel_EmpInfosFilePath();
                jlabel.setForeground(Color.red);
                jlabel.setText("Loading...50%");
                
                // e.getEmployeeId(),e.getEmployeeName(),e.gethireDate(),e.getGrossSalary(), e.getDeptName(),e.getPC(),e.getShift(),e.getBasicSalary(),e.getRentAllow(),e.getMedAllow(),e.getConvAllow()
                float list_size=employeeList.size();
                float progress; float count=0;
                jProgressBar.setVisible(true);
                
                for(EmployeeInformation e: employeeList){ 
                  if(e.getEmployeeId()!=0){
                 //   e.printEmployeeInfo();
                    
                    int id=e.getEmployeeId();
                    
                    Statement stat= connection.createStatement();
                    String SQL="SELECT * FROM employeeInfo WHERE emp_id="+id;
                    ResultSet rs=stat.executeQuery(SQL);
                    
                   if(!rs.next()){ // if the employee is not already in the database , then insert

                        String sql="INSERT INTO employeeInfo (emp_id,emp_name,hire_date,gross_salary,emp_dept,emp_PC,emp_shift,basic_salary,rent_allow,med_allow,conv_allow)"
                                + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

                        PreparedStatement statement=connection.prepareStatement(sql);

                        statement.setInt(1,e.getEmployeeId());
                        statement.setString(2,e.getEmployeeName());
                        statement.setString(3,e.gethireDate());
                        statement.setInt(4,e.getGrossSalary());
                        statement.setString(5,e.getDeptName());
                        statement.setString(6,e.getPC());
                        statement.setString(7,e.getShift());
                        statement.setInt(8,e.getBasicSalary());
                        statement.setInt(9,e.getRentAllow());
                        statement.setInt(10,e.getMedAllow());
                        statement.setInt(11,e.getConvAllow());

                        int row = statement.executeUpdate();

                        if(row >0) {
                            System.out.println("A new row inserted in database Successfully");
                        }
                    } 
                  }
                    progress=(count/list_size);
                    progress=progress*100;
                    
                    jProgressBar.setValue(Math.round(progress));
                    count++;
                }
                jProgressBar.setVisible(false);
                if(count==list_size){
                    jlabel.setText("Loading...100%");
                    JOptionPane.showMessageDialog(homePageJFrame, "List Uploaded Successfully!.");
                }
                else{
                    JOptionPane.showMessageDialog(homePageJFrame, "Error!List Did Not Uploaded Successfully.");
                }
                connection.close();
            }
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(homePageJFrame, "List Upload FAILED!.");
            ex.printStackTrace();
        }
    }
    
    public boolean insertSingleEmployeeInDB(EmployeeInformation e){
        
        boolean flag=false;
        
            try{
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            
            if(connection!=null){
                System.out.println("Connected to the Database");
                
                  if(e.getEmployeeId()!=0){
                 //   e.printEmployeeInfo();
                    
                    int id=e.getEmployeeId();
                    
                    Statement stat= connection.createStatement();
                    String SQL="SELECT * FROM employeeInfo WHERE emp_id="+id;
                    ResultSet rs=stat.executeQuery(SQL);
                    
                   if(!rs.next()){ // if the employee is not already in the database , then insert

                        String sql="INSERT INTO employeeInfo (emp_id,emp_name,hire_date,gross_salary,emp_dept,emp_PC,emp_shift,"
                                + "basic_salary,rent_allow,med_allow,conv_allow,cnic,father_name,resign_date,p_fund,itax,adv_salary,pf_loan,personal_loan,"
                                + "mess_ded,eobi,other_ded)"
                                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                        PreparedStatement statement=connection.prepareStatement(sql);

                        statement.setInt(1,e.getEmployeeId());
                        statement.setString(2,e.getEmployeeName());
                        statement.setString(3,e.gethireDate());
                        statement.setInt(4,e.getGrossSalary());
                        statement.setString(5,e.getDeptName());
                        statement.setString(6,e.getPC());
                        statement.setString(7,e.getShift());
                        statement.setInt(8,e.getBasicSalary());
                        statement.setInt(9,e.getRentAllow());
                        statement.setInt(10,e.getMedAllow());
                        statement.setInt(11,e.getConvAllow());
                        
                        statement.setString(12,e.getCNIC());
                        statement.setString(13,e.getFatherName());
                        statement.setString(14,e.getResignDate());
                        
                        statement.setInt(15,e.getPFund());
                        statement.setInt(16,e.getItax());
                        statement.setInt(17,e.getAdvSalary());
                        statement.setInt(18,e.getPFLoan());
                        statement.setInt(19,e.getPersonalLoan());
                        statement.setInt(20,e.getMessDed());
                        statement.setInt(21,e.getEOBI());
                        statement.setInt(22,e.getOtherDed());
                        
                        

                        int row = statement.executeUpdate();

                        if(row >0) {
                            System.out.println("A new row inserted in database Successfully");
                            flag=true;
                        }
                    } 
                  }
                connection.close();
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return flag;
    }
    
    public List<EmployeeInformation> readAllDB(){
            List<EmployeeInformation> readAllList=new ArrayList<>();
                
        try{
            
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            
            if(connection!=null){
                System.out.println("Connected to the Database");
                
                // e.getEmployeeId(),e.getEmployeeName(),e.gethireDate(),e.getGrossSalary(), e.getDeptName(),e.getPC(),e.getShift(),e.getBasicSalary(),e.getRentAllow(),e.getMedAllow(),e.getConvAllow()
            
                    
                    Statement stat= connection.createStatement();
                    String SQL="SELECT * FROM employeeInfo";
                    ResultSet rs=stat.executeQuery(SQL);
                    
                   while(rs.next()){ 
                       
                       int emp_id=rs.getInt(1);
                       String emp_name=rs.getString(2);
                       String hire_date=rs.getString(3);
                       int gross_salary=rs.getInt(4);
                       String emp_dept=rs.getString(5);
                       String emp_PC=rs.getString(6);
                       String emp_shift=rs.getString(7);
                       int basic_salary=rs.getInt(8);
                       int rent_allow=rs.getInt(9);
                       int med_allow=rs.getInt(10);
                       int conv_allow=rs.getInt(11);
                       String cnic=rs.getString(12);
                       String fathername=rs.getString(13);
                       String resignDate=rs.getString(14);
                       int pfund=rs.getInt(15);
                       int itax=rs.getInt(16);
                       int advSal=rs.getInt(17);
                       int pfLoan=rs.getInt(18);
                       int perLoan=rs.getInt(19);
                       int mess_ded=rs.getInt(20);
                       int eobi=rs.getInt(21);
                       int other_ded=rs.getInt(22);
                       
                       
                       EmployeeInformation e=new EmployeeInformation(emp_id,emp_name,hire_date,gross_salary,emp_dept,emp_PC,emp_shift,basic_salary,rent_allow,med_allow,conv_allow);
                       //e.printEmployeeInfo();
                       e.setCnic(cnic);
                       e.setFatherName(fathername);
                       e.setResignDate(resignDate);
                       e.setP_Fund(pfund);
                       e.setItax(itax);
                       e.setAdvSal(advSal);
                       e.setPF_Loan(pfLoan);
                       e.setPersonalLoan(perLoan);
                       e.setMessDed(mess_ded);
                       e.setEOBI(eobi);
                       e.setOtherDed(other_ded);
                       readAllList.add(e);
                       

                    } 
                  }
                
                connection.close();
                
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return readAllList;
    }
    
    public boolean checkEmptyDB(){
        boolean flag=true;
            try{
            
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            
            if(connection!=null){
                System.out.println("Connected to the Database");
                
                // e.getEmployeeId(),e.getEmployeeName(),e.gethireDate(),e.getGrossSalary(), e.getDeptName(),e.getPC(),e.getShift(),e.getBasicSalary(),e.getRentAllow(),e.getMedAllow(),e.getConvAllow()
            
                    
                    Statement stat= connection.createStatement();
                    String SQL="SELECT * FROM EmployeeInformationDB.employeeInfo LIMIT 1";
                    ResultSet rs=stat.executeQuery(SQL);
                    
                   while(rs.next()){ 
                       flag=false;
                    } 
                  }
                
                connection.close();
                
        } catch(SQLException ex){
            ex.printStackTrace();
        }
       return flag; 
    }
    
    public boolean updateDB(EmployeeInformation e){
            boolean flag=true;
            try{
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            
            if(connection!=null){
                System.out.println("Connected to the Database");
                    
                        String sql="UPDATE employeeInfo SET emp_name=?, hire_date=?,gross_salary=?,emp_dept=?,emp_PC=?,emp_shift=?,basic_salary=?,rent_allow=?"
                                + ",med_allow=?,conv_allow=?,cnic=?,father_name=?,resign_date=?,p_fund=?,itax=?,adv_salary=?,pf_loan=?,personal_loan=?"
                                + ",mess_ded=?,eobi=?,other_ded=? WHERE emp_id=?";

                        PreparedStatement statement=connection.prepareStatement(sql);

                        statement.setString(1,e.getEmployeeName());
                        statement.setString(2,e.gethireDate());
                        statement.setInt(3,e.getGrossSalary());
                        statement.setString(4,e.getDeptName());
                        statement.setString(5,e.getPC());
                        statement.setString(6,e.getShift());
                        statement.setInt(7,e.getBasicSalary());
                        statement.setInt(8,e.getRentAllow());
                        statement.setInt(9,e.getMedAllow());
                        statement.setInt(10,e.getConvAllow());
                        statement.setString(11,e.getCNIC());
                        statement.setString(12,e.getFatherName());
                        statement.setString(13,e.getResignDate());
                        statement.setInt(14,e.getPFund());
                        statement.setInt(15,e.getItax());
                        statement.setInt(16,e.getAdvSalary());
                        statement.setInt(17,e.getPFLoan());
                        statement.setInt(18,e.getPersonalLoan());
                        statement.setInt(19,e.getMessDed());
                        statement.setInt(20,e.getEOBI());
                        statement.setInt(21,e.getOtherDed());
                        
                        statement.setInt(22,e.getEmployeeId());

                        int row = statement.executeUpdate();

                        if(row >0) {
                            System.out.println("Saved Successfully!");
                        }
                        else{
                            flag=false;
                        }
                  }
        
                connection.close();
            
        } catch(SQLException ex){
            flag=false;
            System.out.println("Update Failed!");
            ex.printStackTrace();
        }
      return flag;
    }
    
    public void deleteDB(EmployeeInformation e){
            try{
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            
            if(connection!=null){
                System.out.println("Connected to the Database");
                    
                        String sql="DELETE FROM employeeInfo WHERE emp_id=?";

                        PreparedStatement statement=connection.prepareStatement(sql);
                        
                        statement.setInt(1,e.getEmployeeId());

                        int row = statement.executeUpdate();

                        if(row >0) {
                            System.out.println("A row deleted from database Successfully");
                        }
                  }
        
                connection.close();
            
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void deleteAllDB(){
            try{
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            
            if(connection!=null){
                System.out.println("Connected to the Database");
                    
                        String sql="DELETE FROM employeeInfo ";

                        PreparedStatement statement=connection.prepareStatement(sql);

                        int row = statement.executeUpdate();

                        if(row >0) {
                            System.out.println("Table deleted from database Successfully");
                        }
                  }
        
                connection.close();
            
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public EmployeeInformation searchDB(int employee_id){
        
            try{
                
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            
            if(connection!=null){
                
                    EmployeeInformation e=null;
                
                    Statement stat= connection.createStatement();
                    String SQL="SELECT * FROM employeeInfo WHERE emp_id="+employee_id;
                    ResultSet rs=stat.executeQuery(SQL);
                    
                   while(rs.next()){ 
                       
                       int emp_id=rs.getInt(1);   
                       String emp_name=rs.getString(2);
                       String hire_date=rs.getString(3);
                       int gross_salary=rs.getInt(4);
                       String emp_dept=rs.getString(5);
                       String emp_PC=rs.getString(6);
                       String emp_shift=rs.getString(7);
                       int basic_salary=rs.getInt(8);
                       int rent_allow=rs.getInt(9);
                       int med_allow=rs.getInt(10);
                       int conv_allow=rs.getInt(11);
                       String cnic=rs.getString(12);
                       String fathername=rs.getString(13);
                       String resignDate=rs.getString(14);
                       int pfund=rs.getInt(15);
                       int itax=rs.getInt(16);
                       int advSal=rs.getInt(17);
                       int pfLoan=rs.getInt(18);
                       int perLoan=rs.getInt(19);
                       int mess_ded=rs.getInt(20);
                       int eobi=rs.getInt(21);
                       int other_ded=rs.getInt(22);
                       
                       e=new EmployeeInformation(emp_id,emp_name,hire_date,gross_salary,emp_dept,emp_PC,emp_shift,basic_salary,rent_allow,med_allow,conv_allow);
                       e.setCnic(cnic);
                       e.setFatherName(fathername);
                       e.setResignDate(resignDate);
                       e.setP_Fund(pfund);
                       e.setItax(itax);
                       e.setAdvSal(advSal);
                       e.setPF_Loan(pfLoan);
                       e.setPersonalLoan(perLoan);
                       e.setMessDed(mess_ded);
                       e.setEOBI(eobi);
                       e.setOtherDed(other_ded);
                       return e; // If Employee found, return his/her information

                    }
                  }
        
                connection.close();
            
        } catch(SQLException ex){
            ex.printStackTrace();
        }
       return null;
    }
    
    public boolean IsEmployeeInDB(int employee_id){
            try{
                
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            
            if(connection!=null){
                    Statement stat= connection.createStatement();
                    String SQL="SELECT * FROM employeeInfo WHERE emp_id="+employee_id;
                    ResultSet rs=stat.executeQuery(SQL);
                    if(rs.next()){ // if employee is present in database
                        return true;
                    }
            }
        
                connection.close();
            
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    
    
    // Database code for the table salarydata :-
    
    public void insertSalaryDataInDB(List<EmployeeSalary> salaryList,HomePage homePageJFrame,String date) throws InterruptedException{
        
            try{
                
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            
            if(connection!=null){
                JProgressBar jProgressBar=homePageJFrame.getJProgressBar2();
                System.out.println("Connected to the Database");
                
                
                JOptionPane.showMessageDialog(homePageJFrame, "System is Generating Salaries...Press OK and Wait!");
                
                JLabel jlabel=homePageJFrame.getjLabel_AttendSheetFilePath();
                jlabel.setForeground(Color.red);
                jlabel.setText("Loading...50%");
                
                // e.getEmployeeId(),e.getEmployeeName(),e.gethireDate(),e.getGrossSalary(), e.getDeptName(),e.getPC(),e.getShift(),e.getBasicSalary(),e.getRentAllow(),e.getMedAllow(),e.getConvAllow()
                float list_size=salaryList.size();
                float progress; float count=0;
                jProgressBar.setVisible(true);
                
                for(EmployeeSalary e: salaryList){ 
                  if(e.getEmployeeId()!=0){
                 //   e.printEmployeeInfo();
                    
                    int id=e.getEmployeeId();
                    
                    Statement stat= connection.createStatement();
                    String SQL="SELECT * FROM salarydata WHERE emp_id="+id+" AND salary_date='"+date+"'";
                    ResultSet rs=stat.executeQuery(SQL);
                    
                   if(!rs.next()){ // if the employee is not already in the database , then insert

                        String sql="INSERT INTO salarydata (emp_id,salary_date,total_mins,earned_salary,net_salary)"
                                + " VALUES (?,?,?,?,?)";

                        PreparedStatement statement=connection.prepareStatement(sql);

                        statement.setInt(1,e.getEmployeeId());
                        statement.setString(2,e.getSalaryDate());
                        statement.setInt(3,e.getWorkTime());
                        statement.setInt(4,e.getEarnedSalary());
                        statement.setInt(5,e.getNetSalary());

                        int row = statement.executeUpdate();

                        if(row >0) {
                            System.out.println("A new row inserted in database Successfully");
                            count++;
                        }
                    } 
                  }
                    progress=(count/list_size);
                    progress=progress*100;
                    jProgressBar.setValue(Math.round(progress));

                }
                if(count==list_size){
                    jlabel.setText("Loading...100%");
                    JOptionPane.showMessageDialog(homePageJFrame, "List Uploaded Successfully!.");
                    jProgressBar.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(homePageJFrame, "Error! List Did Not Uploaded Succesfully.");
                    jProgressBar.setVisible(false);
                }
                connection.close();
            }
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(homePageJFrame, "List Upload FAILED!.");
            ex.printStackTrace();
        }
    }
    
    public List<EmployeeSalary> readMonthSalaryDB(String date){
            List<EmployeeSalary> readAllMonthSalaryList=new ArrayList<>();
                
        try{
            
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            
            if(connection!=null){
                System.out.println("Connected to the Database");
                
                // e.getEmployeeId(),e.getEmployeeName(),e.gethireDate(),e.getGrossSalary(), e.getDeptName(),e.getPC(),e.getShift(),e.getBasicSalary(),e.getRentAllow(),e.getMedAllow(),e.getConvAllow()
            
                    
                    Statement stat= connection.createStatement();
                    String SQL="SELECT * FROM salarydata WHERE salary_date='"+date+"'";
                    ResultSet rs=stat.executeQuery(SQL);
                    
                   while(rs.next()){ 
                       
                       int emp_id=rs.getInt(1);
                       String dateString=rs.getString(2);
                       int total_mins=rs.getInt(3);
                       int earned_salary=rs.getInt(4);
                       int net_salary=rs.getInt(5);
                       
                       
                       EmployeeSalary e=new EmployeeSalary();
                       e.setEmployeeId(emp_id);
                       e.setSalaryDate(date);
                       e.setWorkTime(total_mins);
                       e.setEarnedSalary(earned_salary);
                       e.setNetSalary(net_salary);
                       
                       readAllMonthSalaryList.add(e);

                    } 
                  }
                
                connection.close();
                
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return readAllMonthSalaryList;
    }
    
    public List<EmployeeSalary> readEmployeeSalaryDB(int empID){
            List<EmployeeSalary> readEmployeeSalaryList=new ArrayList<>();
                
        try{
            
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            
            if(connection!=null){
                System.out.println("Connected to the Database");
                
                // e.getEmployeeId(),e.getEmployeeName(),e.gethireDate(),e.getGrossSalary(), e.getDeptName(),e.getPC(),e.getShift(),e.getBasicSalary(),e.getRentAllow(),e.getMedAllow(),e.getConvAllow()
            
                    
                    Statement stat= connection.createStatement();
                    String SQL="SELECT * FROM salarydata WHERE emp_id="+empID;
                    ResultSet rs=stat.executeQuery(SQL);
                    
                   while(rs.next()){ 
                       
                       int emp_id=rs.getInt(1);
                       String dateString=rs.getString(2);
                       int total_mins=rs.getInt(3);
                       int earned_salary=rs.getInt(4);
                       int net_salary=rs.getInt(5);
                       
                       
                       EmployeeSalary e=new EmployeeSalary();
                       e.setEmployeeId(emp_id);
                       e.setSalaryDate(dateString);
                       e.setWorkTime(total_mins);
                       e.setEarnedSalary(earned_salary);
                       e.setNetSalary(net_salary);
                       
                       readEmployeeSalaryList.add(e);

                    } 
                  }
                
                connection.close();
                
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return readEmployeeSalaryList;
    }
    
    public EmployeeSalary searchEmployeeSalaryDB(int employee_id,String date){
        
            try{
                
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            
            if(connection!=null){
                
                    Statement stat= connection.createStatement();
                    String SQL="SELECT * FROM salarydata WHERE emp_id="+employee_id+" AND salary_date='"+date+"'";
                    ResultSet rs=stat.executeQuery(SQL);
                    
                   while(rs.next()){ 
                       
                       int emp_id=rs.getInt(1);
                       String dateString=rs.getString(2);
                       int total_mins=rs.getInt(3);
                       int earned_salary=rs.getInt(4);
                       int net_salary=rs.getInt(5);
                       
                       EmployeeSalary e=new EmployeeSalary();
                       e.setEmployeeId(emp_id);
                       e.setSalaryDate(date);
                       e.setWorkTime(total_mins);
                       e.setEarnedSalary(earned_salary);
                       e.setNetSalary(net_salary);
                       return e; // If Employee found, return his/her information

                    }
                  }
        
                connection.close();
            
        } catch(SQLException ex){
            ex.printStackTrace();
        }
       return null;
    }
    
        public boolean updateEmployeeSalaryDB(EmployeeSalary e){
            boolean flag=true;
            try{
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            
            if(connection!=null){
                System.out.println("Connected to the Database");
                    
                        String sql="UPDATE salarydata SET net_salary=? WHERE emp_id=? and salary_date=?";

                        PreparedStatement statement=connection.prepareStatement(sql);

 
                        statement.setInt(1,e.getNetSalary());
                        statement.setInt(2,e.getEmployeeId());
                        statement.setString(3,e.getSalaryDate());
                        

                        int row = statement.executeUpdate();

                        if(row >0) {
                            System.out.println("Saved Successfully!");
                        }
                        else{
                            flag=false;
                        }
                  }
        
                connection.close();
            
        } catch(SQLException ex){
            flag=false;
            System.out.println("Update Failed!");
            ex.printStackTrace();
        }
      return flag;
    }
    
}
