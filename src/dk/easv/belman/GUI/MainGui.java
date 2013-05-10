package dk.easv.belman.GUI;

import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ItemList;
import dk.easv.belman.BE.ProductOrder;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.BE.StockItem;
import dk.easv.belman.BE.StockItemList;
import dk.easv.belman.BLL.Filter;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SortOrder;
import org.jdesktop.swingx.JXTable;

public class MainGui extends javax.swing.JFrame {

    private SleeveTableModel sleeveModel;
    private StockTableModel stockModel;
    private Filter filter;
    private JXTable tblSleeves;
    private JXTable tblStock;
    private Item selectedItem;
    private StockItem selectedStockItem;

    /**
     * Creates new form Belman
     */
    public MainGui() {

        initComponents();
        init();

    }

    public void scheduledUpdate(boolean showUrgentPopup) {
        if (showUrgentPopup) {
            JOptionPane.showMessageDialog(null, "There is a new Ugent order!", "Ugent order", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void init() {
        //
        filter = new Filter();

        //DescriptionPane
        setVisibleTo(false, lblDescriptionText1,
                lblDescriptionText2,
                lblDescriptionText3,
                lblDescriptiontext4,
                lblDescriptionText5,
                lblDescriptionText6,
                lblDescriptionText7,
                txtDescription1,
                txtDescription2,
                txtDescription3,
                txtDescription4,
                txtDescription5,
                txtDescription6,
                txtDescription7);

        //Sleeve table
        tblSleeves = new JXTable();
        JScrollPane sp = new JScrollPane(tblSleeves);
        sleeveModel = new SleeveTableModel(Main.allOrderData);
        tblSleeves.setModel(sleeveModel);
        tblSleeves.setDragEnabled(false);
        tblSleeves.setColumnControlVisible(true);
        tblSleeves.packAll();
        tblSleeves.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblSleeves.setSortOrderCycle(SortOrder.ASCENDING, SortOrder.DESCENDING, SortOrder.UNSORTED);

        pnlCenter.setLayout(new BorderLayout());
        pnlCenter.add(sp);
        addListeners(tblSleeves);


        //Stock table
        tblStock = new JXTable();
        JScrollPane sf = new JScrollPane(tblStock);
        stockModel = new StockTableModel(Main.allStockData);
        tblStock.setModel(stockModel);
        tblStock.setColumnControlVisible(true);
        tblStock.packAll();
        tblStock.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblStock.setSortOrderCycle(SortOrder.ASCENDING, SortOrder.DESCENDING, SortOrder.UNSORTED);

        pnlWest.setLayout(new BorderLayout());
        pnlWest.add(sf);
        addListeners(tblStock);

    }

    private void addListeners(final Component c) {

        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource().equals(tblSleeves)) {
                    tblStock.clearSelection();
                    selectedItem = sleeveModel.getItemByRow(tblSleeves.getSelectedRow());

                } else {
                    tblSleeves.clearSelection();
                    selectedStockItem = stockModel.getStockByRow(tblStock.getSelectedRow());

                }

                if (e.getClickCount() != 2) {
                    if (e.getSource().equals(tblSleeves)) {
                        setItemDescriptionPane(selectedItem);
                    } else {
                        setStockDescriptionPane(selectedStockItem);
                    }
                } else {
                    if (e.getSource().equals(tblSleeves)) {
                        selectedItem = sleeveModel.getItemByRow(tblSleeves.getSelectedRow());

                        stockModel.setStockList(filter.filterBySleeve(Main.allStockData, selectedItem));
                        stockModel.fireTableDataChanged();

                        txtSleeve.setText(sleeveModel.getValueAt(tblSleeves.getSelectedRow(), 0).toString());
                        txtQuantity.setText(String.valueOf(selectedItem.getQuantity()));
                    } else {
                        selectedStockItem = stockModel.getStockByRow(tblStock.getSelectedRow());

                        sleeveModel.setItemList(filter.filterByStock(Main.allOrderData, selectedStockItem));
                        sleeveModel.fireTableDataChanged();

                        txtStockItem.setText(selectedStockItem.getCode());
                    }
                }
            }
        });
        c.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyUp = KeyEvent.VK_UP;
                int keyDown = KeyEvent.VK_DOWN;
                int keyEnter = KeyEvent.VK_ENTER;

                if (e.getKeyCode() == keyUp) {
                    if (e.getSource().equals(tblSleeves)) {
                        selectedItem = sleeveModel.getItemByRow(tblSleeves.getSelectedRow() - 1);
                        setItemDescriptionPane(selectedItem);
                    } else {
                        selectedStockItem = stockModel.getStockByRow(tblStock.getSelectedRow() - 1);
                        setStockDescriptionPane(selectedStockItem);
                    }
                } else if (e.getKeyCode() == keyDown) {
                    if (e.getSource().equals(tblSleeves)) {
                        selectedItem = sleeveModel.getItemByRow(tblSleeves.getSelectedRow() + 1);
                        setItemDescriptionPane(selectedItem);
                    } else {
                        selectedStockItem = stockModel.getStockByRow(tblStock.getSelectedRow() + 1);
                        setStockDescriptionPane(selectedStockItem);
                    }
                } else if (e.getKeyCode() == keyEnter) {
                    if (e.getSource().equals(tblSleeves)) {
                        txtSleeve.setText(sleeveModel.getValueAt(tblSleeves.getSelectedRow(), 0).toString());
                        txtQuantity.setText(String.valueOf(selectedItem.getQuantity()));
                    } else {
                        txtStockItem.setText(selectedStockItem.getCode());
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEast = new javax.swing.JSplitPane();
        jpDescription = new javax.swing.JPanel();
        lblDescription = new javax.swing.JLabel();
        lblDescriptionText1 = new javax.swing.JLabel();
        lblDescriptionText2 = new javax.swing.JLabel();
        lblDescriptionText3 = new javax.swing.JLabel();
        lblDescriptiontext4 = new javax.swing.JLabel();
        txtDescription1 = new javax.swing.JTextField();
        txtDescription2 = new javax.swing.JTextField();
        txtDescription3 = new javax.swing.JTextField();
        txtDescription4 = new javax.swing.JTextField();
        lblDescriptionText5 = new javax.swing.JLabel();
        txtDescription5 = new javax.swing.JTextField();
        lblDescriptionText6 = new javax.swing.JLabel();
        txtDescription6 = new javax.swing.JTextField();
        txtDescription7 = new javax.swing.JTextField();
        lblDescriptionText7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAction = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtSleeve = new javax.swing.JTextField();
        txtStockItem = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        txtAmount = new javax.swing.JTextField();
        cmbbxOperator = new javax.swing.JComboBox();
        pnlHeader = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        pnlWest = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1000, 650));
        setPreferredSize(new java.awt.Dimension(1000, 650));

        pnlEast.setDividerLocation(325);
        pnlEast.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        pnlEast.setPreferredSize(new java.awt.Dimension(325, 650));

        jpDescription.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        lblDescription.setText("Description");

        lblDescriptionText1.setText("Text");

        lblDescriptionText2.setText("Text");

        lblDescriptionText3.setText("Text");

        lblDescriptiontext4.setText("Text");

        lblDescriptionText5.setText("Text");

        lblDescriptionText6.setText("Text");

        lblDescriptionText7.setText("Text");

        javax.swing.GroupLayout jpDescriptionLayout = new javax.swing.GroupLayout(jpDescription);
        jpDescription.setLayout(jpDescriptionLayout);
        jpDescriptionLayout.setHorizontalGroup(
            jpDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDescriptionLayout.createSequentialGroup()
                        .addComponent(lblDescriptionText1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDescription1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpDescriptionLayout.createSequentialGroup()
                        .addComponent(lblDescriptionText2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(txtDescription2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpDescriptionLayout.createSequentialGroup()
                        .addComponent(lblDescriptionText3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDescription3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpDescriptionLayout.createSequentialGroup()
                        .addComponent(lblDescriptiontext4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDescription4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpDescriptionLayout.createSequentialGroup()
                        .addComponent(lblDescriptionText5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDescription5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpDescriptionLayout.createSequentialGroup()
                        .addComponent(lblDescription)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpDescriptionLayout.createSequentialGroup()
                        .addComponent(lblDescriptionText6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDescription6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpDescriptionLayout.createSequentialGroup()
                        .addComponent(lblDescriptionText7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(txtDescription7, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpDescriptionLayout.setVerticalGroup(
            jpDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDescription)
                .addGap(18, 18, 18)
                .addGroup(jpDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescriptionText1)
                    .addComponent(txtDescription1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescriptionText2)
                    .addComponent(txtDescription2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescriptionText3)
                    .addComponent(txtDescription3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescriptiontext4)
                    .addComponent(txtDescription4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescriptionText5)
                    .addComponent(txtDescription5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescriptionText6)
                    .addComponent(txtDescription6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescriptionText7)
                    .addComponent(txtDescription7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pnlEast.setTopComponent(jpDescription);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("Operator");

        jLabel3.setText("Selected Sleeve:");

        jLabel4.setText("Selected Stock Item: ");

        jLabel5.setText("Quantity");

        jLabel6.setText("Amount to cut");

        btnAction.setText("Start");

        jLabel7.setText("Cutting handler");

        txtSleeve.setEditable(false);

        txtStockItem.setEditable(false);

        txtQuantity.setEditable(false);

        cmbbxOperator.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GOD", "JFK", "MCD" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(txtStockItem, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSleeve, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                    .addComponent(cmbbxOperator, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbbxOperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSleeve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtStockItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(btnAction, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        pnlEast.setRightComponent(jPanel2);

        pnlHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        txtID.setText("ID / Description");
        txtID.setToolTipText("Enter an ID or Description and press enter");

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOK))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCenter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnlCenter.setPreferredSize(new java.awt.Dimension(400, 0));

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlWest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnlWest.setPreferredSize(new java.awt.Dimension(400, 862));

        javax.swing.GroupLayout pnlWestLayout = new javax.swing.GroupLayout(pnlWest);
        pnlWest.setLayout(pnlWestLayout);
        pnlWestLayout.setHorizontalGroup(
            pnlWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        pnlWestLayout.setVerticalGroup(
            pnlWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 868, Short.MAX_VALUE)
        );

        jPanel1.setPreferredSize(new java.awt.Dimension(25, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlWest, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCenter, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlEast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCenter, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                    .addComponent(pnlWest, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        if (txtID.getText().isEmpty()) {
            setSleeveTableModel(Main.allOrderData);
            setStockTableModel(Main.allStockData);
        } else {
            SalesOrderList sol = new SalesOrderList();
            StockItemList sil = new StockItemList();

            boolean hasFound = false;

            while (!hasFound) {
                if (txtID.getText().startsWith("RP")) {
                    for (StockItem s : Main.allStockData.getList()) {
                        if (s.getCode().contains(txtID.getText())) {
                            sil.add(s);
                        }
                        hasFound = true;
                    }
                } else {
                    for (SalesOrder s : Main.allOrderData.getList()) {
                        if (s.getDescription().contains(txtID.getText()) || String.valueOf(s.getId()).contains(txtID.getText())) {
                            if (!sol.hasId(s.getId())) {
                                sol.add(s);
                            }

                            hasFound = true;
                        }
                        for (ProductOrder p : s.getProductOrderList().getList()) {
                            if (p.getDescription().contains(txtID.getText()) || String.valueOf(p.getId()).contains(txtID.getText())) {
                                if (!sol.hasId(s.getId())) {
                                    sol.add(s);
                                }

                                hasFound = true;

                            }
                        }
                    }
                    if (!hasFound) {
                        JOptionPane.showMessageDialog(this, "Nothing was found from your query", "Nothing found", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
            }
            if (hasFound) {
                if (sol.size() > 0) {
                    setSleeveTableModel(sol);
                } else {
                    setStockTableModel(sil);
                }
            }
        }
    }//GEN-LAST:event_btnOKActionPerformed
    private void setSleeveTableModel(SalesOrderList sol) {
        sleeveModel.setItemList(sol);
        sleeveModel.fireTableDataChanged();
    }

    private void setStockTableModel(StockItemList sil) {
        stockModel.setStockList(sil);
        stockModel.fireTableDataChanged();
    }

    public void setItemDescriptionPane(Item item) {
        setVisibleTo(true, lblDescriptionText1,
                lblDescriptionText2,
                lblDescriptionText3,
                txtDescription1,
                txtDescription2,
                txtDescription3,
                lblDescriptiontext4,
                txtDescription4,
                lblDescriptionText5,
                txtDescription5,
                lblDescriptionText6,
                txtDescription6,
                lblDescriptionText7,
                txtDescription7);

        lblDescriptionText1.setText("SO ID / Description: ");
        txtDescription1.setText(item.getSalesOrderId() + " / " + Main.allOrderData.getById(item.getSalesOrderId()).getDescription());
        lblDescriptionText2.setText("PO ID / Description: ");
        txtDescription2.setText(item.getProductOrderId() + " / " + Main.allOrderData.getById(item.getSalesOrderId()).getProductOrderList().getById(item.getProductOrderId()).getDescription());
        lblDescriptionText3.setText("Material ID: ");
        txtDescription3.setText(String.valueOf(item.getMaterialId()));
        lblDescriptiontext4.setText("Width: ");
        txtDescription4.setText(String.valueOf(item.getWidth()));
        lblDescriptionText5.setText("Circumference: ");
        txtDescription5.setText(String.valueOf(item.getCircumference()));
        lblDescriptionText6.setText("Thickness: ");
        txtDescription6.setText(String.valueOf(item.getThickness()));
        lblDescriptionText7.setText("Quantity: ");
        txtDescription7.setText(String.valueOf(item.getQuantity()));

        setEditableTo(false, txtDescription1,
                txtDescription2,
                txtDescription3,
                txtDescription4,
                txtDescription5,
                txtDescription6,
                txtDescription7);

    }

    private void setStockDescriptionPane(StockItem item) {
        setVisibleTo(true, lblDescriptionText1,
                lblDescriptionText2,
                lblDescriptionText3,
                txtDescription1,
                txtDescription2,
                txtDescription3,
                lblDescriptiontext4,
                txtDescription4,
                lblDescriptionText5,
                txtDescription5,
                lblDescriptionText6,
                txtDescription6,
                lblDescriptionText7,
                txtDescription7);

        lblDescriptionText1.setText("Code:");
        txtDescription1.setText(item.getCode());
        lblDescriptionText2.setText("Material: ");
        txtDescription2.setText(String.valueOf(item.getMaterialId()) + " / " + item.getMaterialName());
        lblDescriptionText3.setText("Mat. Density");
        txtDescription3.setText(String.valueOf(item.getMaterialDensity()));
        lblDescriptiontext4.setText("Width: ");
        txtDescription4.setText(String.valueOf(item.getWidth()));
        lblDescriptionText5.setText("Length: ");
        txtDescription5.setText(String.valueOf(item.getLength()));
        lblDescriptionText6.setText("Thickness: ");
        txtDescription6.setText(String.valueOf(item.getThickness()));
        lblDescriptionText7.setText("Quantity(kg): ");
        txtDescription7.setText(String.valueOf(item.getQuantity()));

        setEditableTo(false, txtDescription1,
                txtDescription2,
                txtDescription3,
                txtDescription4,
                txtDescription5,
                txtDescription6,
                txtDescription7);

    }

    /**
     * Takes in multiple Components and sets the visibility option for all.
     *
     * @param visibility
     * @param comp All the components
     */
    public void setVisibleTo(boolean visibility, Component... comp) {
        for (Component c : comp) {
            c.setVisible(visibility);
        }
    }

    /**
     * Takes in multiple JTextFields and sets the editable attribute for all.
     *
     * @param visibility
     * @param comp
     */
    public void setEditableTo(boolean visibility, JTextField... comp) {
        for (JTextField c : comp) {
            c.setEditable(visibility);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAction;
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox cmbbxOperator;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpDescription;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblDescriptionText1;
    private javax.swing.JLabel lblDescriptionText2;
    private javax.swing.JLabel lblDescriptionText3;
    private javax.swing.JLabel lblDescriptionText5;
    private javax.swing.JLabel lblDescriptionText6;
    private javax.swing.JLabel lblDescriptionText7;
    private javax.swing.JLabel lblDescriptiontext4;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JSplitPane pnlEast;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlWest;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtDescription1;
    private javax.swing.JTextField txtDescription2;
    private javax.swing.JTextField txtDescription3;
    private javax.swing.JTextField txtDescription4;
    private javax.swing.JTextField txtDescription5;
    private javax.swing.JTextField txtDescription6;
    private javax.swing.JTextField txtDescription7;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSleeve;
    private javax.swing.JTextField txtStockItem;
    // End of variables declaration//GEN-END:variables
}
