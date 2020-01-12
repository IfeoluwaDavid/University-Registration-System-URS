/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientAppSide;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/****************************************************************************************/
public class LoginUI extends javax.swing.JDialog
{
    public LoginUI()
    {
        initComponents();
    }
/****************************************************************************************/
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);
        
        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Log In");
        jLabel2.setText("Member ID:");
        jLabel3.setText("Password:");
        jPasswordField.setText("password");
        jTextField2.setText("666207");
        
/****************************************************************************************/
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	if(jPasswordField.getPassword().length == 0|| jTextField2.getText().isEmpty())
            	{
            		JOptionPane.showMessageDialog(null, "Empty Login Input", "Feedback", JOptionPane.INFORMATION_MESSAGE);
            	}
            	else
            	{
            		if(ClientUserInfo.user.getLoginStatus().equals(true) && ClientUserInfo.user.getMemberID().equals(jTextField2.getText()))
                	{
                		JOptionPane.showMessageDialog(null, "You're already logged In!", "Feedback", JOptionPane.INFORMATION_MESSAGE);
                	}
                	else
                	{
                		String operationName = "Login";
                    	String memberID = jTextField2.getText();
                    	String password = String.valueOf(jPasswordField.getPassword());
                    	ArrayList<String> serverInfo = new ArrayList<String>();
                    	serverInfo.add(operationName);
                    	serverInfo.add(memberID);
                    	serverInfo.add(password);
                        ClientConsole.accept(serverInfo);
                	}
            	}
            }
        });
        
/****************************************************************************************/
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	dispose();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 179, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPasswordField)
                                    .addComponent(jTextField2))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }
/****************************************************************************************/
    
    public static void createClientUserInfo(ArrayList<String> feedback)
    {
    	if(feedback.get(0).equals("LoginSuccess"))
    	{
			String firstname = feedback.get(1);
			String lastname = feedback.get(2);
			String email = feedback.get(3);
			String memberID = feedback.get(4);
			String usertype = feedback.get(5);
			
			new ClientUserInfo(usertype, firstname, lastname, email, memberID);
			
    		if(feedback.get(5).equals("studentmember"))
    		{
    			StudentMainMenuUI.display();
    			ClientUserInfo.user.setLoginStatus(true);
    		}
    		else if(feedback.get(5).equals("facultyInstructor") || feedback.get(5).equals("noRoleFaculty"))
    		{
    			FacultyMainMenuUI.display();
    			ClientUserInfo.user.setLoginStatus(true);
    		}
    		else if(feedback.get(5).equals("facultyChair"))
    		{
    			FacultyMainMenuUI.display();
    			ClientUserInfo.user.setLoginStatus(true);
    			ClientUserInfo.user.setDepartment(feedback.get(6));
    		}
    		else if(feedback.get(5).equals("staffmember"))
    		{
    			StaffMainMenuUI.display();
    			ClientUserInfo.user.setLoginStatus(true);
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(null, "Unable to identify user type", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    		}
    	}
    	else if(feedback.get(0).equals("LoginFailure") || feedback.get(0).equals("LoginError"))
    	{
    		JOptionPane.showMessageDialog(null, "Incorrect MemberID/Password Combination", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(null, "Something went wrong. Sorry!", "Server Feedback", JOptionPane.INFORMATION_MESSAGE);
    	}
    }
/****************************************************************************************/
    
    public static void display() {
        try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) { javax.swing.UIManager.setLookAndFeel(info.getClassName()); break;}}}
        catch (ClassNotFoundException ex) { java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (InstantiationException ex) { java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (IllegalAccessException ex) { java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (javax.swing.UnsupportedLookAndFeelException ex) {java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}

        java.awt.EventQueue.invokeLater(new Runnable()
        { public void run() { new LoginUI().setVisible(true);} }); }
    
/****************************************************************************************/   
    private static javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPasswordField jPasswordField;
  
}
