package clientAppSide;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SearchCourseUI extends javax.swing.JDialog 
{
	private static String UIpurpose;
	
    public SearchCourseUI()
    {
        initComponents();
    }

    private void initComponents()
    {
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);

        String operationName = "getAllCourses";
    	String requestingUI = "displayAllCourses";
    	ArrayList<String> serverInfo = new ArrayList<String>();
    	serverInfo.add(operationName);
    	serverInfo.add(requestingUI);
        ClientConsole.accept(serverInfo);
        
        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Search Course");

        jLabel1.setText("Search Mode:");
        
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	if(jTextField2.getText().isEmpty())
            	{
                	JOptionPane.showMessageDialog(null, "Empty Entry", "Empty Entry", JOptionPane.ERROR_MESSAGE);
            	}
            	else
            	{
            		String operationName = "searchCourse";
            		String requestingUI = "displayAllCourses";
            		String searchMode = String.valueOf(jComboBox1.getSelectedItem()).substring(10);
            		String searchKey = jTextField2.getText();
            		ArrayList<String> serverInfo = new ArrayList<String>();
            		serverInfo.add(operationName);
            		serverInfo.add(requestingUI);
            		serverInfo.add(searchMode);
            		serverInfo.add(searchKey);
            		//System.out.println(serverInfo);
            		ClientConsole.accept(serverInfo);
            	}
            }
        });
        
        jButton2.setText("Select");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	if(jList1.isSelectionEmpty())
            	{
            		JOptionPane.showMessageDialog(null, "Course not Selected");
            	}
            	else
            	{
            		ViewCourseInfoUI.display(jList1.getSelectedValue());
            	}
            }
        });
        
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search by Course Subject", "Search by Course Code", "Search by Course Number", "Search by Semester", "Search by Department" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton3.setText("Register Course");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	if(jList1.isSelectionEmpty())
            	{
            		JOptionPane.showMessageDialog(null, "Course not Selected");
            	}
            	else
            	{
            		String operationName = "registerCourse";
                	String selectedCourse = jList1.getSelectedValue().substring(12);
                	String memberID = ClientUserInfo.user.getMemberID();
                	ArrayList<String> serverInfo = new ArrayList<String>();
                	serverInfo.add(operationName);
                	serverInfo.add(selectedCourse);
                	serverInfo.add(memberID);
                    ClientConsole.accept(serverInfo);
            	}
            }
        });
        
        if(UIpurpose.equals("search"))
        {
        	 jTextField1.setText("Search Course");
        }
        if(UIpurpose.equals("registration"))
        {
        	 jTextField1.setText("Register Course");
        }
        if(ClientUserInfo.user.getUserType().equals("staffmember") || ClientUserInfo.user.getUserType().equals("facultyChair")
        		|| ClientUserInfo.user.getUserType().equals("facultyInstructor") ||  ClientUserInfo.user.getUserType().equals("noRoleFaculty"))
        {
        	 jButton3.setVisible(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel5))
        );

        pack();
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    public static void displayAllCourses(ArrayList<String> list)
    {
    	list.subList(0, 2).clear();
    	
    	jList1.setModel(new javax.swing.AbstractListModel<String>() 
        {
			public int getSize() { return list.size(); }
            public String getElementAt(int i) { return list.get(i); }
        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void display(String purpose)
    {
    	UIpurpose = purpose;
        try {for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
             if ("Nimbus".equals(info.getName())) {javax.swing.UIManager.setLookAndFeel(info.getClassName());break;}}} 
        catch (ClassNotFoundException ex) {java.util.logging.Logger.getLogger(SearchCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (InstantiationException ex) {java.util.logging.Logger.getLogger(SearchCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (IllegalAccessException ex) {java.util.logging.Logger.getLogger(SearchCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (javax.swing.UnsupportedLookAndFeelException ex) {java.util.logging.Logger.getLogger(SearchCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {new SearchCourseUI().setVisible(true);}});}

   
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private static javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    
}