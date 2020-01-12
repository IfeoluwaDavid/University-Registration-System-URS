package clientAppSide;

import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class FacultyMainMenuUI extends javax.swing.JDialog {

    public FacultyMainMenuUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

    	/*****************************************************************************************************************/

        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);
        
        jLabel1.setText("Faculty Member Logged In: " + ClientUserInfo.user.getfirstName() + " " + ClientUserInfo.user.getlastName());
        
        String operationName = "getFaculties";
    	String requestingUI = "facultyMenuDisplayFaculties";
    	ArrayList<String> serverInfo = new ArrayList<String>();
    	serverInfo.add(operationName);
    	serverInfo.add(requestingUI);
        ClientConsole.accept(serverInfo);
 
        /*****************************************************************************************************************/

        jButton2.setText("Search Course");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	SearchCourseUI.display("search");
            }
        });

        /*****************************************************************************************************************/

        jButton5.setText("Assigned Courses");
        jButton5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                String operationName = "viewAssignedCourses";
            	String requestingUI = "facultyAssignedCourses";
                String memberid = ClientUserInfo.user.getMemberID();

                ArrayList<String> serverInfo = new ArrayList<String>();

                serverInfo.add(operationName);
                serverInfo.add(requestingUI);
                serverInfo.add(memberid);
                
                ClientConsole.accept(serverInfo);
            }
        });
        
        jScrollPane1.setViewportView(jList1);

        /*****************************************************************************************************************/

        jButton8.setText("View Profile"); 
        jButton8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	String operationName = "viewUserProfile";
        		String requestingUI = "facultyUserViewProfile";
        		String memberID = ClientUserInfo.user.getMemberID();
            	ArrayList<String> serverInfo = new ArrayList<String>();
            	serverInfo.add(operationName);
            	serverInfo.add(requestingUI);
            	serverInfo.add(memberID);
                ClientConsole.accept(serverInfo);
            }
        });

        /*****************************************************************************************************************/

        jButton9.setText("Log Out");
        jButton9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	Window[] childwindows = Window.getWindows();
            	
            	for (Window window : childwindows)
                {
                    if (window instanceof JDialog)
                    {
                        window.dispose();
                        ClientUserInfo.user.setLoginStatus(false);
                    }
                }
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); 

        /*****************************************************************************************************************/

        jButton7.setText("Select");
        jButton7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	String operationName = "getFacultyDepartments";
            	String requestingUI = "facultyMenuDisplayDepartments";
            	String requestedFaculty = String.valueOf(jComboBox1.getSelectedItem());
            	ArrayList<String> serverInfo = new ArrayList<String>();
            	serverInfo.add(operationName);
            	serverInfo.add(requestingUI);
            	serverInfo.add(requestedFaculty);
                ClientConsole.accept(serverInfo);
            }
        });
        
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        /*****************************************************************************************************************/

        jButton1.setText("My Department");
        jButton1.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
            	String operationName = "getSpecificDepartmentInfo";
            	String requestingUI = "displayChairDepartmentInfo";
            	String requestedDepartment = ClientUserInfo.user.getDepartment();
            	ArrayList<String> serverInfo = new ArrayList<String>();
            	serverInfo.add(operationName);
            	serverInfo.add(requestingUI);
            	serverInfo.add(requestedDepartment);
                ClientConsole.accept(serverInfo);
            }
        });
        
        /*****************************************************************************************************************/

        jButton3.setText("Select");
        jButton3.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
            	if(jList1.isSelectionEmpty())
            	{
            		JOptionPane.showMessageDialog(null, "No Department Selected!");
            	}
            	else
            	{
            		String operationName = "getSpecificDepartmentInfo";
                	String requestingUI = "displayDepartmentInfo";
                	String requestedDepartment = jList1.getSelectedValue();
                	ArrayList<String> serverInfo = new ArrayList<String>();
                	serverInfo.add(operationName);
                	serverInfo.add(requestingUI);
                	serverInfo.add(requestedDepartment);
                    ClientConsole.accept(serverInfo);
            	}
            }
        });
        
        /*****************************************************************************************************************/

        if(ClientUserInfo.user.getUserType().equals("facultyInstructor") || ClientUserInfo.user.getUserType().equals("noRoleFaculty")) 
        {
        	jButton1.setVisible(false);
        }

        /*****************************************************************************************************************/
        //This section is auto generated by java swing Net-beans

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
        pack();
    }

    /*****************************************************************************************************************/

    public static void facultyMenuDisplayFaculties(ArrayList<String> facultyList)
    {
    	facultyList.subList(0, 2).clear();
    	
    	String[] programArray = new String[facultyList.size()];
    	programArray = facultyList.toArray(programArray);
    	
    	jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(programArray));
    }
    
    /*****************************************************************************************************************/

    public static void facultyMenuDisplayDepartments(ArrayList<String> list)
    {
    	list.subList(0, 2).clear();
    	
    	jList1.setModel(new javax.swing.AbstractListModel<String>() 
        {
            public int getSize() 
            { 
            	return list.size();
            }
            public String getElementAt(int i) 
            { 
            	return list.get(i); 
            }
        });
    }
    
    /*****************************************************************************************************************/
    //This section is auto generated by java swing Net-beans

    public static void display() 
    {
        try {for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {javax.swing.UIManager.setLookAndFeel(info.getClassName());break;}}} 
        catch (ClassNotFoundException ex) {java.util.logging.Logger.getLogger(FacultyMainMenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (InstantiationException ex) {java.util.logging.Logger.getLogger(FacultyMainMenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (IllegalAccessException ex) {java.util.logging.Logger.getLogger(FacultyMainMenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (javax.swing.UnsupportedLookAndFeelException ex) {java.util.logging.Logger.getLogger(FacultyMainMenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        java.awt.EventQueue.invokeLater(new Runnable() {public void run() {new FacultyMainMenuUI().setVisible(true);}});
    }

    /*****************************************************************************************************************/
    //This section is auto generated by java swing Net-beans

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private static javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    
    /*****************************************************************************************************************/
}
