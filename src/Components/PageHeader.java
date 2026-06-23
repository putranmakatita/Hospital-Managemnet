package Components;

import DbConfig.DbSetup;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import config.DesignConstants;
import java.io.InputStream;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class PageHeader extends javax.swing.JPanel {

    private GridBagConstraints gridBagConstraints;
    private Table tablePanel;
    private String tableName;
    private String entity;
    private Object[][] formStructure;

    // NEW: Jasper report file path
    private String reportFile;

    private javax.swing.JButton reportBtn;

    public PageHeader(String entity, Object[][] formStructure, String reportFile) {
        this.entity = entity;
        this.formStructure = formStructure;
        this.reportFile = reportFile;

        initComponents();

        addBtn.setText("Add a " + entity);
        entityName.setText("Manage your " + entity + "s");

        // layout override
        setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();

        // SEARCH
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(10, 20, 10, 10);
        add(jLayeredPane1, gridBagConstraints);

        // TITLE
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.insets = new Insets(10, 0, 10, 10);
        add(entityName, gridBagConstraints);

        // REPORT BUTTON
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(reportBtn, gridBagConstraints);

        // ADD BUTTON
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(10, 10, 10, 40);
        add(addBtn, gridBagConstraints);
    }

    public void setTable(Table tablePanel, String tableName) {
        this.tablePanel = tablePanel;
        this.tableName = tableName;
    }

    // ================= INIT COMPONENTS =================
    @SuppressWarnings("unchecked")
    private void initComponents() {

        addBtn = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        searchFeild = new javax.swing.JTextField();
        entityName = new javax.swing.JLabel();
        reportBtn = new javax.swing.JButton();

        setBackground(DesignConstants.WHITE_COLOR);
        setMaximumSize(new java.awt.Dimension(950, 79));
        setMinimumSize(new java.awt.Dimension(1300, 60));
        setPreferredSize(new java.awt.Dimension(1300, 60));

        // ADD BUTTON
        addBtn.setForeground(DesignConstants.WHITE_COLOR);
        addBtn.setText("Add");
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        addBtn.addActionListener(evt -> addBtnActionPerformed(evt));
        addBtn.setBackground(DesignConstants.SECONDARY_COLOR);

        // SEARCH LABEL
        jLabel1.setText("Search");

        searchFeild.addActionListener(evt -> searchFeildActionPerformed(evt));

        // REPORT BUTTON
        reportBtn.setText("Report");
        reportBtn.setForeground(DesignConstants.WHITE_COLOR);
        reportBtn.setBackground(DesignConstants.PRIMARY_COLOR);
        reportBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        reportBtn.addActionListener(evt -> reportBtnActionPerformed(evt));

        // SEARCH LAYOUT
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(searchFeild, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);

        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(searchFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );

        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(searchFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
        );

        // TITLE LABEL
        entityName.setFont(DesignConstants.HEADING_FONT3);
        entityName.setForeground(DesignConstants.PRIMARY_COLOR);

        // MAIN LAYOUT (default NetBeans - replaced later in constructor)
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 1000, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 60, Short.MAX_VALUE)
        );
    }

    // ================= SEARCH =================
    private void searchFeildActionPerformed(java.awt.event.ActionEvent evt) {
        if (tablePanel != null) {
            tablePanel.search(searchFeild.getText());
        }
    }

    // ================= ADD =================
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
        if (tablePanel != null && tableName != null) {
            DynamicForm form = new DynamicForm(formStructure, tableName, entity, tablePanel);
            form.setVisible(true);
        } else {
            DynamicForm form = new DynamicForm(formStructure, entity, entity, null);
            form.setVisible(true);
        }
    }

  

    private void reportBtnActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // 1. Get the path, but remove the leading slash if it exists 
            // (ClassLoader expects paths without the leading slash)
            String path = this.reportFile;
            if (path.startsWith("/")) {
                path = path.substring(1); 
            }

            // 2. Use the Context ClassLoader
            java.io.InputStream reportStream = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream(path);

            if (reportStream == null) {
                throw new RuntimeException("Still cannot find file at path: " + path);
            }

            net.sf.jasperreports.engine.JasperReport report =
                    net.sf.jasperreports.engine.JasperCompileManager
                            .compileReport(reportStream);

            net.sf.jasperreports.engine.JasperPrint print =
                    net.sf.jasperreports.engine.JasperFillManager
                            .fillReport(report, null, DbSetup.getConnection());

            net.sf.jasperreports.view.JasperViewer.viewReport(print, false);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Failed to open report: " + e.getMessage());
        }
    }

    // VARIABLES
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel entityName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField searchFeild;
}