/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.Observable;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import static payroll.Payroll.fileFormatCheck;
import static payroll.Payroll.read_xls;
import static payroll.Payroll.read_xls_attend;
import static payroll.Payroll.read_xlsx;
import static payroll.Payroll.read_xlsx_attend;

/**
 *
 * @author mzohaib
 */
public class HomePage extends javax.swing.JFrame{

    /**
     * Creates new form HomePage
     */
    
    DB_CRUD db_crud;
    
    public HomePage() {
        initComponents();
        db_crud=DB_CRUD.getInstance();
        setTitle("Payroll Application");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel_filePath1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton_viewEmployeeInfo = new javax.swing.JButton();
        jButton_uploadEmpIoyeesInfoList = new javax.swing.JButton();
        jLabel_EmpInfosFilePath = new javax.swing.JLabel();
        jProgressBar_EmpInfosList = new javax.swing.JProgressBar();
        jButton_uploadAttendSheet = new javax.swing.JButton();
        jButton_viewSalarySheet = new javax.swing.JButton();
        jLabel_AttendSheetFilePath = new javax.swing.JLabel();
        jProgressBar_AttendSheet = new javax.swing.JProgressBar();
        jTextField_date = new javax.swing.JTextField();
        jButton_viewEmployeeSalaryList = new javax.swing.JButton();
        jLabel_EmpInfosFilePath1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel_minimize = new javax.swing.JLabel();
        jLabel_close = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        jPasswordField1.setText("jPasswordField1");

        jLabel_filePath1.setText("  No File Selected!");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jButton_viewEmployeeInfo.setText("VIEW/ADD EMPLOYEE INFORMATION");
        jButton_viewEmployeeInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton_viewEmployeeInfoMousePressed(evt);
            }
        });
        jButton_viewEmployeeInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_viewEmployeeInfoActionPerformed(evt);
            }
        });

        jButton_uploadEmpIoyeesInfoList.setBackground(new java.awt.Color(255, 255, 255));
        jButton_uploadEmpIoyeesInfoList.setText("UPLOAD EMPLOYEES INFORMATION LIST");
        jButton_uploadEmpIoyeesInfoList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_uploadEmpIoyeesInfoListActionPerformed(evt);
            }
        });

        jLabel_EmpInfosFilePath.setText("  No File Selected!");

        jProgressBar_EmpInfosList.setBackground(new java.awt.Color(51, 51, 255));
        jProgressBar_EmpInfosList.setStringPainted(true);

        jButton_uploadAttendSheet.setText("UPLOAD MONTHLY ATTENDANCE SHEET");
        jButton_uploadAttendSheet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton_uploadAttendSheetMousePressed(evt);
            }
        });
        jButton_uploadAttendSheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_uploadAttendSheetActionPerformed(evt);
            }
        });

        jButton_viewSalarySheet.setText("VIEW MONTHLY SALARY SHEET");
        jButton_viewSalarySheet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton_viewSalarySheetMousePressed(evt);
            }
        });
        jButton_viewSalarySheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_viewSalarySheetActionPerformed(evt);
            }
        });

        jLabel_AttendSheetFilePath.setText("  No File Selected!");

        jProgressBar_AttendSheet.setStringPainted(true);

        jTextField_date.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField_date.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_date.setText(" e.g July 2020");
        jTextField_date.setToolTipText("");
        jTextField_date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_dateMouseClicked(evt);
            }
        });
        jTextField_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_dateActionPerformed(evt);
            }
        });

        jButton_viewEmployeeSalaryList.setText("VIEW EMPLOYEE SALARY DATA");
        jButton_viewEmployeeSalaryList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton_viewEmployeeSalaryListMousePressed(evt);
            }
        });
        jButton_viewEmployeeSalaryList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_viewEmployeeSalaryListActionPerformed(evt);
            }
        });

        jLabel_EmpInfosFilePath1.setText("Enter Salary Pay Date to Upload Attendance Sheet:-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jProgressBar_EmpInfosList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel_AttendSheetFilePath, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jProgressBar_AttendSheet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_viewEmployeeInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_uploadEmpIoyeesInfoList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_EmpInfosFilePath, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_uploadAttendSheet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton_viewSalarySheet, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                        .addComponent(jTextField_date))
                    .addComponent(jButton_viewEmployeeSalaryList, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_EmpInfosFilePath1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_viewEmployeeInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_viewSalarySheet, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_viewEmployeeSalaryList, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_uploadEmpIoyeesInfoList, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_EmpInfosFilePath)
                        .addGap(4, 4, 4)
                        .addComponent(jProgressBar_EmpInfosList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel_EmpInfosFilePath1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_uploadAttendSheet, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_date, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_AttendSheetFilePath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar_AttendSheet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel3.setText("PAYROLL APPLICATION");

        jLabel_minimize.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel_minimize.setText(" -");
        jLabel_minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_minimizeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_minimizeMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_minimizeMouseEntered(evt);
            }
        });

        jLabel_close.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel_close.setText(" X");
        jLabel_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel_minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_close, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(247, 247, 247))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_minimize)
                    .addComponent(jLabel_close))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jLabel14.setForeground(new java.awt.Color(102, 102, 255));
        jLabel14.setText("Developed By Mohammad Zohaib Abbas ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(271, 271, 271))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel_minimizeMouseClicked

    private void jLabel_minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMouseExited
        Border label_border=BorderFactory.createMatteBorder(1,1,1,1, Color.black);
        jLabel_minimize.setBorder(label_border);
        jLabel_minimize.setForeground(Color.black);
    }//GEN-LAST:event_jLabel_minimizeMouseExited

    private void jLabel_minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMouseEntered
        Border label_border=BorderFactory.createMatteBorder(1,1,1,1, Color.white);
        jLabel_minimize.setBorder(label_border);
        jLabel_minimize.setForeground(Color.white);

    }//GEN-LAST:event_jLabel_minimizeMouseEntered

    private void jLabel_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel_closeMouseClicked

    private void jLabel_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseExited
        Border label_border=BorderFactory.createMatteBorder(1,1,1,1, Color.black);
        jLabel_close.setBorder(label_border);
        jLabel_close.setForeground(Color.black);
    }//GEN-LAST:event_jLabel_closeMouseExited

    private void jLabel_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseEntered
        Border label_border=BorderFactory.createMatteBorder(1,1,1,1, Color.white);
        jLabel_close.setBorder(label_border);
        jLabel_close.setForeground(Color.white);
    }//GEN-LAST:event_jLabel_closeMouseEntered

    private void jButton_viewEmployeeInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_viewEmployeeInfoActionPerformed
        EmployeeViewFrame employeeViewFrame=new EmployeeViewFrame();
        employeeViewFrame.setSize(1169, 725);
        employeeViewFrame.setVisible(true);
        employeeViewFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton_viewEmployeeInfoActionPerformed

    private void jButton_uploadEmpIoyeesInfoListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_uploadEmpIoyeesInfoListActionPerformed
       //if(db_crud.checkEmptyDB()){ // if database is empty
        String path = null;
        List<EmployeeInformation> employeeList=new ArrayList<>();
        JFileChooser chooser=new JFileChooser();
        
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter extension=new FileNameExtensionFilter("EXCEL File","xlsx","xls");
        chooser.addChoosableFileFilter(extension);
        
        int filestate=chooser.showSaveDialog(null);
        
        if(filestate==JFileChooser.APPROVE_OPTION){
            File selectedFile=chooser.getSelectedFile();
            path=selectedFile.getAbsolutePath();
            jLabel_EmpInfosFilePath.setText(path);
            int count=fileFormatCheck(path);
            
          if(count==3){
              
                read_xls(path,employeeList);
                db_crud.insertDB(employeeList,this);
                
                jLabel_EmpInfosFilePath.setForeground(Color.black);
                jLabel_EmpInfosFilePath.setText(path);
            
                List<EmployeeInformation> readAllList;
                readAllList=db_crud.readAllDB();
                for(EmployeeInformation e: employeeList){
                    e.printEmployeeInfo();
                }
          }
        
          else if(count==4) {
              
                read_xlsx(path,employeeList);
                db_crud.insertDB(employeeList,this);
                
                jLabel_EmpInfosFilePath.setForeground(Color.black);
                jLabel_EmpInfosFilePath.setText(path);
            
                List<EmployeeInformation> readAllList;
                readAllList=db_crud.readAllDB();
                for(EmployeeInformation e: employeeList){
                    e.printEmployeeInfo();
                }
            
          }
            
        }
      // }
        
    }//GEN-LAST:event_jButton_uploadEmpIoyeesInfoListActionPerformed

    private void jButton_viewEmployeeInfoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_viewEmployeeInfoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_viewEmployeeInfoMousePressed

    private void jButton_uploadAttendSheetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_uploadAttendSheetMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_uploadAttendSheetMousePressed

    private void jButton_uploadAttendSheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_uploadAttendSheetActionPerformed
        String path = null;
        //String path="/Users/mzohaib/Downloads/Book1.xlsx"
        String date=jTextField_date.getText();
        
       if(date.trim().length()==0||date.equals(" e.g July 2020")){
        JOptionPane.showMessageDialog(this, "Please Enter Valid Date!");
       }
       else{
             int opt= JOptionPane.showConfirmDialog(this,"Is this Date:  '"+date+"' Correct?","Confirm",JOptionPane.YES_NO_OPTION);
             if(opt==0){ // if Yes
                List<EmployeeSalary> salaryList=new ArrayList<>();
                List<EmployeeInformation> employeeInformations;
                employeeInformations=db_crud.readAllDB();

                JFileChooser chooser=new JFileChooser();

                chooser.setCurrentDirectory(new File(System.getProperty("user.home")));

                FileNameExtensionFilter extension=new FileNameExtensionFilter("EXCEL File","xlsx","xls");
                chooser.addChoosableFileFilter(extension);

                int filestate=chooser.showSaveDialog(null);

                if(filestate==JFileChooser.APPROVE_OPTION){
                    File selectedFile=chooser.getSelectedFile();
                    path=selectedFile.getAbsolutePath();
                    //jLabel_AttendSheetFilePath.setText(path);
                    int count=fileFormatCheck(path);

                  if(count==3){
                    read_xls_attend(path,employeeInformations,salaryList,date,db_crud);
                    jLabel_AttendSheetFilePath.setForeground(Color.black);
                    jLabel_AttendSheetFilePath.setText(path);
                  }

                // /Users/mzohaib/Downloads/file_example_XLS_10.xls

                  else if(count==4) {
                    read_xlsx_attend(path,employeeInformations,salaryList,date,db_crud);
                    jLabel_AttendSheetFilePath.setForeground(Color.black);
                    jLabel_AttendSheetFilePath.setText(path);
                  }

                }
             } 
       }
        
    }//GEN-LAST:event_jButton_uploadAttendSheetActionPerformed

    private void jButton_viewSalarySheetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_viewSalarySheetMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_viewSalarySheetMousePressed

    private void jButton_viewSalarySheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_viewSalarySheetActionPerformed

        Salary_Sheet_Table salary_Sheet_Table=new Salary_Sheet_Table();
        salary_Sheet_Table.setVisible(true);
        salary_Sheet_Table.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton_viewSalarySheetActionPerformed

    private void jTextField_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_dateActionPerformed

    private void jTextField_dateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_dateMouseClicked
        jTextField_date.setText("");
        jTextField_date.setForeground(Color.black);
    }//GEN-LAST:event_jTextField_dateMouseClicked

    private void jButton_viewEmployeeSalaryListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_viewEmployeeSalaryListMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_viewEmployeeSalaryListMousePressed

    private void jButton_viewEmployeeSalaryListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_viewEmployeeSalaryListActionPerformed
        // TODO add your handling code here:
        Emp_Salary_Table emp_Salary_Table=new Emp_Salary_Table();
        emp_Salary_Table.setVisible(true);
        emp_Salary_Table.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton_viewEmployeeSalaryListActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_uploadAttendSheet;
    private javax.swing.JButton jButton_uploadEmpIoyeesInfoList;
    private javax.swing.JButton jButton_viewEmployeeInfo;
    private javax.swing.JButton jButton_viewEmployeeSalaryList;
    private javax.swing.JButton jButton_viewSalarySheet;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_AttendSheetFilePath;
    private javax.swing.JLabel jLabel_EmpInfosFilePath;
    private javax.swing.JLabel jLabel_EmpInfosFilePath1;
    private javax.swing.JLabel jLabel_close;
    private javax.swing.JLabel jLabel_filePath1;
    private javax.swing.JLabel jLabel_minimize;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JProgressBar jProgressBar_AttendSheet;
    private javax.swing.JProgressBar jProgressBar_EmpInfosList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_date;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

    
    public JProgressBar getJProgressBar(){
        return jProgressBar_EmpInfosList;
    }
    public JProgressBar getJProgressBar2(){
        return jProgressBar_AttendSheet;
    }
    public JLabel getjLabel_AttendSheetFilePath(){
        return jLabel_AttendSheetFilePath;
    }
    public JLabel getjLabel_EmpInfosFilePath(){
        return jLabel_EmpInfosFilePath;
    }

}