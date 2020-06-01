/**
 * ZM J Code Metrics
 * 
 * file : The main window (work space)
 * src version: 01.06.2020
 * 
 * @author ZM (ZAGANE Mohammed)
 * @email : m_zagane@yahoo.fr
 */

package zmjcodemetrics;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;



/**
 *
 * @author ZM
 */
public class Main_JFrame extends javax.swing.JFrame {
    
    /**
     * Show the project source as a tree (files and functions)
     * @param A_Project : ZM J Code Metrics project (see Project class)
     */
    public void Show_As_Tree (Project A_Project)
    {
        
        Project_jTree.getSelectionModel().setSelectionMode
            (TreeSelectionModel.SINGLE_TREE_SELECTION);

        //Listen for when the selection changes.
        Project_jTree.addTreeSelectionListener
        ( new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) 
            {
                DefaultMutableTreeNode File_Node, Function_Node;
                int File_Index=-1, Function_Index=-1;
                
                TreePath path = Project_jTree.getSelectionPath();
                if (path == null) return;
                
                int Path_Count = path.getPathCount();
                
                if (Path_Count == 1) // The project is selected
                {
                    
                }
                else if (Path_Count == 2) // a file is selected
                {
                    File_Node = (DefaultMutableTreeNode) path.getPathComponent(1);
                    File_Index = File_Node.getParent().getIndex(File_Node);
                }
                else if (Path_Count == 3) // a function is selected
                {
                    File_Node = (DefaultMutableTreeNode) path.getPathComponent(1);
                    File_Index = File_Node.getParent().getIndex(File_Node);
                    Function_Node = (DefaultMutableTreeNode) path.getPathComponent(2);
                    Function_Index = Function_Node.getParent().getIndex(Function_Node);
                }
                // show results                         
                Results_jTextArea.setText(Show_Results.Show_Metrics(A_Project, File_Index, Function_Index)); 
                Results_2_jTextArea.setText(Show_Results.Show_Tokens(A_Project, File_Index, Function_Index));
            }
         }
        );
        
        //create the root node (Project node)
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(A_Project.Name);
        
        // create files and functions nodes
        DefaultMutableTreeNode File_Node;
        DefaultMutableTreeNode Function_Node;        
        for(int i=0; i<A_Project.Files.size(); i++)
        {
            File_Node = new DefaultMutableTreeNode(A_Project.Files.get(i).Name);
            
            for (int j=0; j<A_Project.Files.get(i).Functions.size();j++)
            {
                Function_Node = new DefaultMutableTreeNode(A_Project.Files.get(i).Functions.get(j).Name);
                
                File_Node.add(Function_Node);
            }
            root.add(File_Node);
        }
        
        // show the tree
        Project_jTree.setModel(new DefaultTreeModel(root));
        
    }
    
    
    /**
     * Creates new form Main_JFrame
     */
    public Main_JFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Project_Src_jFileChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        Project_Source_jTextField = new javax.swing.JTextField();
        Calculate_Metrics_jButton = new javax.swing.JButton();
        Close_jButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Project_jTree = new javax.swing.JTree();
        jLabel2 = new javax.swing.JLabel();
        Project_Name_jTextField = new javax.swing.JTextField();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Results_jTextArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Results_2_jTextArea = new javax.swing.JTextArea();
        Brows_For_Project_Src_jButton = new javax.swing.JButton();
        Help_jButton = new javax.swing.JButton();

        Project_Src_jFileChooser.setCurrentDirectory(new java.io.File("C:\\Program Files\\NetBeans 8.2"));
        Project_Src_jFileChooser.setDialogTitle("Please select the source file or folder");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Poject Source :");

        Calculate_Metrics_jButton.setText("Calculate Metrics");
        Calculate_Metrics_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Calculate_Metrics_jButtonActionPerformed(evt);
            }
        });

        Close_jButton.setText("Close");
        Close_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Close_jButtonActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        Project_jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(Project_jTree);

        jLabel2.setText("Project Name :");

        Project_Name_jTextField.setText("Project1");

        Results_jTextArea.setColumns(20);
        Results_jTextArea.setRows(5);
        jScrollPane5.setViewportView(Results_jTextArea);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Metrics", jPanel3);

        Results_2_jTextArea.setColumns(20);
        Results_2_jTextArea.setRows(5);
        jScrollPane3.setViewportView(Results_2_jTextArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        jTabbedPane3.addTab("Tokens", jPanel2);

        Brows_For_Project_Src_jButton.setText("Browse...");
        Brows_For_Project_Src_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Brows_For_Project_Src_jButtonActionPerformed(evt);
            }
        });

        Help_jButton.setText("Help");
        Help_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Help_jButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Project_Source_jTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Project_Name_jTextField)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Brows_For_Project_Src_jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Help_jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Calculate_Metrics_jButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Close_jButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Project_Name_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Help_jButton)
                    .addComponent(Calculate_Metrics_jButton))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Project_Source_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(Brows_For_Project_Src_jButton)
                    .addComponent(Close_jButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jTabbedPane3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Calculate_Metrics_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Calculate_Metrics_jButtonActionPerformed
                
        String srcML_EXE_Path = null;

        // Loading App settingd
        Config App_Settings = new Config(); 
        App_Settings.Load_App_Settings();
        srcML_EXE_Path = App_Settings.App_Settings_Props.getProperty("srcML_EXE_Path");
	
        // end : Load the app settings
        
        //checking inputs
        
        if ( "".equals(Project_Name_jTextField.getText() ))
        {
            JOptionPane.showMessageDialog(this, "Please give valid name for your project!");
            return;
        }
        // TODO: check if the entered path is a valid path
        if ( "".equals(Project_Source_jTextField.getText()))
        {
            JOptionPane.showMessageDialog(this, "Please indicate the full path of your project source (file, archive or containing folder)!");
            return;
        }
        // end : checking inputs
        
        // creating a new project and setting its parameters
        Project New_Project = new Project ();
        New_Project.Name     = Project_Name_jTextField.getText();
        New_Project.Source   = Project_Source_jTextField.getText();
        New_Project.XML_File = "srcML_xml_file.xml";/* the output xml file 
        generated by srcML*/
        
        // end project setup
        
        try
        { 
            // convert project source to XML using srcML
            ProcessBuilder processBuilder = new ProcessBuilder(srcML_EXE_Path, New_Project.Source, "-o"+ New_Project.XML_File,"--position" );
            Process Pros = processBuilder.start();
            
            Pros.waitFor(); // waiting for srcML to generate XML file
            
            New_Project.Init(); // processing (get files, function and their metrics)
            Show_As_Tree (New_Project); // show as a tree
       
        } 
        catch (Exception ex)
        {
        
            Logger.getLogger(Main_JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_Calculate_Metrics_jButtonActionPerformed

    private void Close_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Close_jButtonActionPerformed

        this.dispose();
        new Welcome_JFrame().setVisible(true);
    }//GEN-LAST:event_Close_jButtonActionPerformed

    private void Brows_For_Project_Src_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Brows_For_Project_Src_jButtonActionPerformed
               
        Project_Src_jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = Project_Src_jFileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        {
            File file = Project_Src_jFileChooser.getSelectedFile();
            Project_Source_jTextField.setText(file.getAbsolutePath());

        }
    }//GEN-LAST:event_Brows_For_Project_Src_jButtonActionPerformed

    private void Help_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Help_jButtonActionPerformed
        
        Help_JFrame H_JF = new Help_JFrame();
        H_JF.setVisible(true);
    }//GEN-LAST:event_Help_jButtonActionPerformed

    /**
     * @param args the command line arguments
     * TODO : write implement the use of the app via command line 
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
            java.util.logging.Logger.getLogger(Main_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Brows_For_Project_Src_jButton;
    private javax.swing.JButton Calculate_Metrics_jButton;
    private javax.swing.JButton Close_jButton;
    private javax.swing.JButton Help_jButton;
    private javax.swing.JTextField Project_Name_jTextField;
    private javax.swing.JTextField Project_Source_jTextField;
    private javax.swing.JFileChooser Project_Src_jFileChooser;
    private javax.swing.JTree Project_jTree;
    private javax.swing.JTextArea Results_2_jTextArea;
    private javax.swing.JTextArea Results_jTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane3;
    // End of variables declaration//GEN-END:variables
}