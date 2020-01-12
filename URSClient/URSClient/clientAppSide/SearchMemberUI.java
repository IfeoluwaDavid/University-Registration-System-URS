package clientAppSide;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SearchMemberUI extends javax.swing.JDialog
{
    public SearchMemberUI()
    {
        initComponents();
    }
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);
        
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search Member");
        jScrollPane1.setViewportView(jList1);
        
        jButton2.setText("Select");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	if(jList1.isSelectionEmpty())
            	{
            		JOptionPane.showMessageDialog(null, "No selections made!", "Server Feedback", JOptionPane.INFORMATION_MESSAGE);
            	}
            	else
            	{
            		String operationName = "viewUserProfile";
                	String requestingUI = "displayMemberProfile";
                	String selection = jList1.getSelectedValue();
                	String memberID = selection.substring(selection.length() - 6, selection.length());
                	ArrayList<String> serverInfo = new ArrayList<String>();
                	
                	serverInfo.add(operationName);
                	serverInfo.add(requestingUI);
                	serverInfo.add(memberID);
                	
                	ClientConsole.accept(serverInfo);
            	}
            }
        });

        jLabel2.setText("Search Student:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search by ID", "Search by Department", "Search by Year Level" }));

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	if(jTextField1.getText().isEmpty())
            	{
                	JOptionPane.showMessageDialog(null, "Empty Entry", "Empty Entry", JOptionPane.ERROR_MESSAGE);
            	}
            	else
            	{
            		String operationName = "searchStudent";
                	String requestingUI = "displaySearchMemberResults";
                	String searchMode = String.valueOf(jComboBox1.getSelectedItem()).substring(10);
                	String searchKey = jTextField1.getText();
                	
                	ArrayList<String> serverInfo = new ArrayList<String>();
                	
                	serverInfo.add(operationName);
                	serverInfo.add(requestingUI);
                	serverInfo.add(searchMode);
                	serverInfo.add(searchKey);
                    ClientConsole.accept(serverInfo);
            	}
            	
            }
        });

        jLabel3.setText("Search Faculty:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search by ID", "Search by Faculty Roles", "Search by Faculty" }));

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	if(jTextField2.getText().isEmpty())
            	{
                	JOptionPane.showMessageDialog(null, "Empty Entry", "Empty Entry", JOptionPane.ERROR_MESSAGE);
            	}
            	else
            	{
            		String operationName = "searchFacultyMember";
                	String requestingUI = "displaySearchMemberResults";
                	String searchMode = String.valueOf(jComboBox2.getSelectedItem()).substring(10);
            		String searchKey = jTextField2.getText();
            		
            		ArrayList<String> serverInfo = new ArrayList<String>();
                	
                	serverInfo.add(operationName);
                	serverInfo.add(requestingUI);
                	serverInfo.add(searchMode);
                	serverInfo.add(searchKey);
                    ClientConsole.accept(serverInfo);
            	}
            }
        });

        jLabel4.setText("Search Staff:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search by ID", "Search by Email" }));

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	if(jTextField3.getText().isEmpty())
            	{
                	JOptionPane.showMessageDialog(null, "Empty Entry", "Empty Entry", JOptionPane.ERROR_MESSAGE);
            	}
            	else
            	{
	            	String operationName = "searchStaff";
	            	String requestingUI = "displaySearchMemberResults";
	            	String searchMode = String.valueOf(jComboBox3.getSelectedItem()).substring(10);
	            	String searchKey = jTextField3.getText();
	            	
	            	ArrayList<String> serverInfo = new ArrayList<String>();
	            	
	            	serverInfo.add(operationName);
	            	serverInfo.add(requestingUI);
	            	serverInfo.add(searchMode);
	            	serverInfo.add(searchKey);
	                ClientConsole.accept(serverInfo);
            	}
            }
        });

        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2, 0, 180, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        pack();
    }

    public static void displaySearchMemberResults(ArrayList<String> coursesList)
    {
    	coursesList.subList(0, 2).clear();
    	
    	jList1.setModel(new javax.swing.AbstractListModel<String>() 
        {
            public int getSize() { return coursesList.size(); }
            public String getElementAt(int i) { return coursesList.get(i); }
            
        });
    }
    
    public static void displayMemberProfile(ArrayList<String> memberInfo)
    {
    	if(memberInfo.get(memberInfo.size() - 1).equals("studentmember"))
    	{
    		ViewStudentProfileUI.displayInfo(memberInfo);
    	}
    	else if (memberInfo.get(memberInfo.size() - 1).equals("staffmember"))
    	{
    		ViewStaffProfileUI.displayInfo(memberInfo);
    	}
    	else if (memberInfo.get(memberInfo.size() - 1).equals("facultymember"))
    	{
    		ViewFacultyProfileUI.displayInfo(memberInfo);
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(null, "Something unknowns went wrong.", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    }
    
    
   
    public static void display() {
      
        try {for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {javax.swing.UIManager.setLookAndFeel(info.getClassName());break;}}} 
        	catch (ClassNotFoundException ex) {java.util.logging.Logger.getLogger(SearchMemberUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        	catch (InstantiationException ex) {java.util.logging.Logger.getLogger(SearchMemberUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        	catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchMemberUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        	catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchMemberUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchMemberUI().setVisible(true);
            }
        });
    }
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private static javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
}
