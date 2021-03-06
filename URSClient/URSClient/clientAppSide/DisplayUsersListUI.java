package clientAppSide;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DisplayUsersListUI extends javax.swing.JDialog {

	private static ArrayList<String> dataList;
	private static String operation, selection;

    public DisplayUsersListUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        /*****************************************************************************************************************/

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        jList1.setModel(new javax.swing.AbstractListModel<String>()
    	{
            public int getSize() 
            { 
            	return dataList.size(); 
            }
            public String getElementAt(int i) 
            { 
            	return dataList.get(i); 
            }
        });

        jScrollPane1.setViewportView(jList1);

        /*****************************************************************************************************************/

        jButton1.setText("View Student Info");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	if(jList1.isSelectionEmpty())
            	{
            		JOptionPane.showMessageDialog(null, "No Student Selected");
            	}
            	else
            	{
            		String operationName = "viewUserProfile";
                	String requestingUI = "studentUserViewProfile";
                	
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

        /*****************************************************************************************************************/

        jButton2.setText("Assign to "+ selection);
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	if(jList1.isSelectionEmpty())
            	{
            		JOptionPane.showMessageDialog(null, "No Instructor Selected");
            	}
            	else
            	{
            		if(operation.equals("getfacultyMembersforInstructor"))
            		{
            			String operationName = "assignInstructor";
                		String requestingUI = "displayUsersListUI";
                		String memberID = jList1.getSelectedValue();
                    	memberID = memberID.substring(memberID.length() - 6, memberID.length());
                		String course = selection;
                		
                    	ArrayList<String> serverInfo = new ArrayList<String>();
                    	
                    	serverInfo.add(operationName);
                    	serverInfo.add(requestingUI);
                    	serverInfo.add(memberID);
                    	serverInfo.add(course);
                    	
                    	System.out.println(operationName);
                    	System.out.println(requestingUI);
                    	System.out.println(memberID);
                    	System.out.println(course);
                    	
                        ClientConsole.accept(serverInfo);
            		}
            		else if (operation.equals("getfacultyMembersforChair"))
            		{
            			String operationName = "assignChair";
                		String requestingUI = "displayUsersListUI";
                		String memberID = jList1.getSelectedValue();
                    	memberID = memberID.substring(memberID.length() - 6, memberID.length());
                		String department = selection;
                		
                    	ArrayList<String> serverInfo = new ArrayList<String>();
                    	
                    	serverInfo.add(operationName);
                    	serverInfo.add(requestingUI);
                    	serverInfo.add(memberID);
                    	serverInfo.add(department);
                    	
                    	System.out.println(operationName);
                    	System.out.println(requestingUI);
                    	System.out.println(memberID);
                    	System.out.println(department);
                    	
                        ClientConsole.accept(serverInfo);
            		}
            		else
            		{

            		}
            	}
            }
        });
        
        /*****************************************************************************************************************/

        if(operation.equals("getfacultyMembersforInstructor") || operation.equals("getfacultyMembersforChair"))
    	{
        	jLabel1.setText("All Faculty Members");
        	jButton1.setVisible(false);
        }
        else
        {
        	jLabel1.setText("All Enrolled Students");
        	jButton2.setVisible(false);
        }

        /*****************************************************************************************************************/
        //This section is auto generated by java swing Net-beans

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        pack();
    }

    /*****************************************************************************************************************/

    public static void displayUsersList(ArrayList<String> list)
    {
    	operation = list.get(0);
    	selection = list.get(2);
    	
    	list.subList(0, 3).clear();
    	
    	dataList = list;
    	
    	DisplayUsersListUI.display();
    }
    
    /*****************************************************************************************************************/
    //This section is auto generated by java swing Net-beans

    public static void display() 
    {
        try {for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {javax.swing.UIManager.setLookAndFeel(info.getClassName());break;}}} 
        catch (ClassNotFoundException ex) {java.util.logging.Logger.getLogger(DisplayUsersListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (InstantiationException ex) {java.util.logging.Logger.getLogger(DisplayUsersListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (IllegalAccessException ex) {java.util.logging.Logger.getLogger(DisplayUsersListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (javax.swing.UnsupportedLookAndFeelException ex) {java.util.logging.Logger.getLogger(DisplayUsersListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        java.awt.EventQueue.invokeLater(new Runnable() {public void run() {new DisplayUsersListUI().setVisible(true);}});
    }

    /*****************************************************************************************************************/
    //This section is auto generated by java swing Net-beans

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    
    /*****************************************************************************************************************/
}