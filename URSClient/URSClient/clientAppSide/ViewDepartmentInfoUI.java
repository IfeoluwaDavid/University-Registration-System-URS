package clientAppSide;
import java.util.ArrayList;

public class ViewDepartmentInfoUI extends javax.swing.JDialog
{
	private static String duration, department, faculty, chair;
	
    public ViewDepartmentInfoUI()
    {
        initComponents();
    }

    /***********************************************************************************************************/

    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(department);
        jLabel2.setText("Chair:");
        jLabel3.setText("Duration:");
        jLabel4.setText("Faculty:");
        jTextField1.setText(chair);
        jTextField2.setText(duration);
    	jTextField3.setText(faculty);
    	jTextField3.setEditable(false);
        jTextField2.setEditable(false);
        jTextField1.setEditable(false);
    	
        /***********************************************************************************************************/

        jButton2.setText("Assign Program Chair");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	String operationName = "getfacultyMembersforChair";
            	String requestingUI = "displayUsersList";
            	String selectedDepartment = jLabel1.getText();
            	
            	ArrayList<String> serverInfo = new ArrayList<String>();
            	
            	serverInfo.add(operationName);
            	serverInfo.add(requestingUI);
            	serverInfo.add(selectedDepartment);
            	ClientConsole.accept(serverInfo);
            }
        });
        
        /***********************************************************************************************************/

        jButton1.setText("View Department Courses");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    	        String operationName = "getDepartmentCourses";
    	    	String requestingUI = "displayObjectsList";
    	    	ArrayList<String> serverInfo = new ArrayList<String>();
    	    	serverInfo.add(operationName);
    	    	serverInfo.add(requestingUI);
    	    	serverInfo.add(department);
    	        ClientConsole.accept(serverInfo);
            }
        });
        
        if(ClientUserInfo.user.getUserType().equals("studentmember") || ClientUserInfo.user.getUserType().equals("publicuser") ||
        		ClientUserInfo.user.getUserType().equals("facultyInstructor") || ClientUserInfo.user.getUserType().equals("facultyChair")
        		|| ClientUserInfo.user.getUserType().equals("noRoleFaculty"))
        {
        	jButton2.setVisible(false);
        }

        /***********************************************************************************************************/
        //This section is auto generated by java swing Net-beans

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(61, 61, 61)
                        .addComponent(jTextField2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3)
                            .addComponent(jTextField1))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        pack();
    }

    /***********************************************************************************************************/

    public static void displayDepartmentInfo(ArrayList<String> departmentInfo)
    {
    	departmentInfo.subList(0, 2).clear();
    	
    	department = departmentInfo.get(0);
    	duration = departmentInfo.get(1);
    	faculty = departmentInfo.get(2);
    	chair = departmentInfo.get(3);
    	
    	ViewDepartmentInfoUI.display();
    }
 
    /***********************************************************************************************************/
    //This section is auto generated by java swing Net-beans

    public static void display()
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName()))
                {javax.swing.UIManager.setLookAndFeel(info.getClassName());break;}}}
        catch (ClassNotFoundException ex) {java.util.logging.Logger.getLogger(ViewDepartmentInfoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (InstantiationException ex) {java.util.logging.Logger.getLogger(ViewDepartmentInfoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (IllegalAccessException ex) {java.util.logging.Logger.getLogger(ViewDepartmentInfoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (javax.swing.UnsupportedLookAndFeelException ex) {java.util.logging.Logger.getLogger(ViewDepartmentInfoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {new ViewDepartmentInfoUI().setVisible(true);}});}

    /***********************************************************************************************************/
    //This section is auto generated by java swing Net-beans

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;

    /***********************************************************************************************************/

}