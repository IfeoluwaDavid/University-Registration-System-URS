package clientAppSide;
import java.awt.Font;
import java.util.ArrayList;

public class ViewStudentProfileUI extends javax.swing.JDialog {

	private static String firstname, lastname, email, memberid, address, dateofbirth, sinNumber, department, yearlevel, attendanceRole;
	
    public ViewStudentProfileUI() {
        initComponents();
    }

    /*******************************************************************/

    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Student Profile");

        jLabel2.setText("Fisrt Name:");
        jLabel3.setText("Last Name:");
        jLabel4.setText("Email Address:");
        jLabel5.setText("Date of Birth:");
        jLabel6.setText("SIN Number:");
        jLabel7.setText("Member ID:");
        jLabel8.setText("Home Address:");
        jLabel9.setText("Department:");
        jLabel10.setText("Year Level:");
        jLabel11.setText("Attendance:");
        
        jTextField1.setText(firstname);
        jTextField1.setEditable(false);
        jTextField1.setFont(new Font("Tahoma", Font.BOLD,14));

        jTextField2.setText(lastname);
        jTextField2.setEditable(false);
        jTextField2.setFont(new Font("Tahoma", Font.BOLD,14));

        jTextField3.setText(email);
        jTextField3.setEditable(false);
        jTextField3.setFont(new Font("Tahoma", Font.BOLD,14));

        jTextField4.setText(dateofbirth);
        jTextField4.setEditable(false);
        jTextField4.setFont(new Font("Tahoma", Font.BOLD,14));

        jTextField5.setText(sinNumber);
        jTextField5.setEditable(false);
        jTextField5.setFont(new Font("Tahoma", Font.BOLD,14));

        jTextField6.setText(memberid);
        jTextField6.setEditable(false);
        jTextField6.setFont(new Font("Tahoma", Font.BOLD,14));

        jTextField7.setText(address);
        jTextField7.setEditable(false);
        jTextField7.setFont(new Font("Tahoma", Font.BOLD,14));

        jTextField8.setText(department);
        jTextField8.setEditable(false);
        jTextField8.setFont(new Font("Tahoma", Font.BOLD,14));

        jTextField9.setText(yearlevel);
        jTextField9.setEditable(false);
        jTextField9.setFont(new Font("Tahoma", Font.BOLD,14));

        jTextField10.setText(attendanceRole);
        jTextField10.setEditable(false);
        jTextField10.setFont(new Font("Tahoma", Font.BOLD,14));

        /*******************************************************************/

        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	if(ClientUserInfo.user.getUserType().equals("staffmember"))
            	{
            		EditStudentMemberUI.prepareInfo(memberid, department, yearlevel, attendanceRole);
            	}
            	else if ((ClientUserInfo.user.getUserType().equals("studentmember")))
            	{
	                if(jTextField1.isEditable())
	                {
	                	jButton1.setText("Edit");
	                	
	                	jTextField1.setEditable(false);
	                	jTextField1.setFont(new Font("Tahoma", Font.BOLD,14));
	                	
	                	jTextField2.setEditable(false);
	                	jTextField2.setFont(new Font("Tahoma", Font.BOLD,14));
	                	
	                	jTextField3.setEditable(false);
	                	jTextField3.setFont(new Font("Tahoma", Font.BOLD,14));
	                	
	                	jTextField5.setEditable(false);
	                	jTextField5.setFont(new Font("Tahoma", Font.BOLD,14));
	                	
	                	jTextField7.setEditable(false);
	                	jTextField7.setFont(new Font("Tahoma", Font.BOLD,14));
	                	
	                	String operationName = "editUserProfile";
                    	String currentMemberID = ClientUserInfo.user.getMemberID();
                        String firstname = jTextField1.getText();
                        String lastname = jTextField2.getText();
                        String email = jTextField3.getText();
                        String sinNumber = jTextField5.getText();
                        String address = jTextField7.getText();
                        String usertype = ClientUserInfo.user.getUserType();
                        
                        ArrayList<String> serverInfo = new ArrayList<String>();
                        
                        serverInfo.add(operationName);
                        serverInfo.add(currentMemberID);
                        serverInfo.add(firstname);
                        serverInfo.add(lastname);
                        serverInfo.add(email);
                        serverInfo.add(sinNumber);
                        serverInfo.add(address);
                        serverInfo.add(usertype);
                        
                        //System.out.println(serverInfo);
                        ClientConsole.accept(serverInfo);
	                }
	                else
	                {
	                	jButton1.setText("Save");
	                	
	                	jTextField1.setEditable(true);
	                	jTextField1.setFont(new Font("Tahoma", Font.ITALIC,14));
	                	
	                	jTextField2.setEditable(true);
	                	jTextField2.setFont(new Font("Tahoma", Font.ITALIC,14));
	                	
	                	jTextField3.setEditable(true);
	                	jTextField3.setFont(new Font("Tahoma", Font.ITALIC,14));
	                	
	                	jTextField5.setEditable(true);
	                	jTextField5.setFont(new Font("Tahoma", Font.ITALIC,14));
	                	
	                	jTextField7.setEditable(true);
	                	jTextField7.setFont(new Font("Tahoma", Font.ITALIC,14));
	                }
            	}
            	else
            	{
            		
            	}
            }       
        });
        
        /*******************************************************************/

        jButton2.setVisible(false);
        jButton2.setText("Remove Student");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	String operationName = "removeMember";
            	String requestingUI = "ViewStudentProfileUI";
            	String memberID = jTextField6.getText();
            	ArrayList<String> serverInfo = new ArrayList<String>();
            	serverInfo.add(operationName);
            	serverInfo.add(requestingUI);
            	serverInfo.add(memberID);
                ClientConsole.accept(serverInfo);
            }
        });
        
        /*******************************************************************/

        jButton3.setText("View Registered Courses");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	String operationName = "viewRegisteredCourses";
            	String requestingUI = "displayObjectsList";
            	String memberID = jTextField6.getText();
            	ArrayList<String> serverInfo = new ArrayList<String>();
            	serverInfo.add(operationName);
            	serverInfo.add(requestingUI);
            	serverInfo.add(memberID);
                ClientConsole.accept(serverInfo);
            }
        });
        
        /*******************************************************************/

        if(!ClientUserInfo.user.getMemberID().equals(jTextField6.getText()))
        {
        	jButton1.setVisible(false);
        	jButton2.setVisible(false);
        	jTextField5.setText("******");
        }
        if(ClientUserInfo.user.getUserType().equals("staffmember"))
        {
        	jButton1.setVisible(true);
        	jButton2.setVisible(true);
        	jButton3.setVisible(true);
        }
  
        /*******************************************************************/
        //This section is auto generated by java swing Net-beans

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField3)
                            .addComponent(jTextField1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField10)
                            .addComponent(jTextField9)
                            .addComponent(jTextField8)
                            .addComponent(jTextField7)
                            .addComponent(jTextField6)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5)))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    /*******************************************************************/

    public static void displayInfo(ArrayList<String> list)
    {
    	list.subList(0, 2).clear();
    	
    	firstname = list.get(0);
    	lastname = list.get(1);
    	email = list.get(2);
    	dateofbirth = list.get(3);
    	sinNumber = list.get(4);
    	address = list.get(5);
    	department = list.get(6);
    	yearlevel = list.get(7);
    	attendanceRole = list.get(8);
    	memberid = list.get(9);
    	
    	ViewStudentProfileUI.display();
    }
  
    /*******************************************************************/
    //This section is auto generated by java swing Net-beans

    public static void display() {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) { javax.swing.UIManager.setLookAndFeel(info.getClassName()); break;}}}
        catch (ClassNotFoundException ex) {java.util.logging.Logger.getLogger(ViewStudentProfileUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (InstantiationException ex) {java.util.logging.Logger.getLogger(ViewStudentProfileUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (IllegalAccessException ex) {java.util.logging.Logger.getLogger(ViewStudentProfileUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (javax.swing.UnsupportedLookAndFeelException ex) {java.util.logging.Logger.getLogger(ViewStudentProfileUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewStudentProfileUI().setVisible(true);
            }
        });
    }
    
    /*******************************************************************/
    //This section is auto generated by java swing Net-beans

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;

    /*******************************************************************/

}