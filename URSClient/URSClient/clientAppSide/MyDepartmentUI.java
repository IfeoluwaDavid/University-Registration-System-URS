package clientAppSide;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MyDepartmentUI extends javax.swing.JDialog
{
	static String department = "";
	static String duration = "";
	static String faculty = "";
	static String chair = "";
	
	/****************************************************************************************/
    public MyDepartmentUI() {
        initComponents();
    }   
    
    /****************************************************************************************/    
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("My Department");
        jLabel2.setText("Department Name:");
        jLabel3.setText("Duration (Years):");
   
        jTextField1.setText(department);
        jTextField1.setEditable(false);
        jTextField1.setFont(new Font("Tahoma", Font.BOLD,14));
        
        jTextField2.setText(duration);
        jTextField2.setEditable(false);
        jTextField2.setFont(new Font("Tahoma", Font.BOLD,14));
        
        /****************************************************************************************/        
        
        jButton1.setText("View Department Students");
        jButton1.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
            	String serverOperationHandler = "viewDepartmentStudents";
            	String clientOperationHandler = "displayDepartmentStudents";
            	
            	ArrayList<String> serverInfo = new ArrayList<String>();
            	
            	serverInfo.add(serverOperationHandler);
            	serverInfo.add(clientOperationHandler);
            	serverInfo.add(ClientUserInfo.user.getDepartment());
            	
                ClientConsole.accept(serverInfo);
            }
        });
        
        /****************************************************************************************/
        
        jButton2.setText("Edit Department Info");
        jButton2.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
            	if(jTextField1.isEditable())
                {
                	jButton2.setText("Edit");
                	
                	jTextField1.setEditable(false);
                	jTextField1.setFont(new Font("Tahoma", Font.BOLD,14));
                	
                	jTextField2.setEditable(false);
                	jTextField2.setFont(new Font("Tahoma", Font.BOLD,14));
                	
                	String operationName = "editDepartmentInfo";
                	String departmentName = ClientUserInfo.user.getDepartment();
                    String newDepartmentName = jTextField1.getText();
                    String newDepartmentDuration = jTextField2.getText();
                    
                    ArrayList<String> serverInfo = new ArrayList<String>();
                    
                    serverInfo.add(operationName);
                    serverInfo.add(newDepartmentName);
                    serverInfo.add(newDepartmentDuration);
                    serverInfo.add(departmentName);
                    
                    if(Validation.validateCreateDepartment(serverInfo).equals("incomplete"))
                    {
                    	JOptionPane.showMessageDialog(null, "Incomplete form", "Incomplete form", JOptionPane.ERROR_MESSAGE);
                    }

                    else if(Validation.validateCreateDepartment(serverInfo).equals("departmentNameProblem"))
                    {
                    	JOptionPane.showMessageDialog(null, "Invalid Dapartment Name", "Invalid Dapartment Name", JOptionPane.ERROR_MESSAGE);
                    }

                    else if(Validation.validateCreateDepartment(serverInfo).equals("durationProblem"))
                    {
                    	JOptionPane.showMessageDialog(null, "Duration must be maximum of 5 years", "Invalid Duration", JOptionPane.ERROR_MESSAGE);
                    }

                    else if(Validation.validateCreateDepartment(serverInfo).equals("valid"))
                    {
                    	ClientConsole.accept(serverInfo);
                    }
                    else
                    {
                    	//do nothing
                    }
                }
                else
                {
                	jButton2.setText("Save");
                	
                	jTextField1.setEditable(true);
                	jTextField1.setFont(new Font("Tahoma", Font.ITALIC,14));
                	
                	jTextField2.setEditable(true);
                	jTextField2.setFont(new Font("Tahoma", Font.ITALIC,14));
                } 
        	}
        });

        /****************************************************************************************/
       

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }                        
/****************************************************************************************/
    
    public static void displayDepartmentInfo(ArrayList<String> departmentInfo)
    {
    	departmentInfo.subList(0, 2).clear();
    	
    	department = departmentInfo.get(0);
    	duration = departmentInfo.get(1);
    	faculty = departmentInfo.get(2);
    	chair = departmentInfo.get(3);
    	
    	MyDepartmentUI.display();
    }
    
/****************************************************************************************/
    //This section is auto generated by java swing Net-beans

    public static void display() 
    {
        try {for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) { javax.swing.UIManager.setLookAndFeel(info.getClassName());break;} }} 
       	catch (ClassNotFoundException ex) {java.util.logging.Logger.getLogger(MyDepartmentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);} 
    	catch (InstantiationException ex) {java.util.logging.Logger.getLogger(MyDepartmentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);} 
    	catch (IllegalAccessException ex) {java.util.logging.Logger.getLogger(MyDepartmentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
    	catch (javax.swing.UnsupportedLookAndFeelException ex) {java.util.logging.Logger.getLogger(MyDepartmentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        java.awt.EventQueue.invokeLater(new Runnable() {public void run() { new MyDepartmentUI().setVisible(true);} });
	}
    
/****************************************************************************************/

    //This section is auto generated by java swing Net-beans
                    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
                 
}