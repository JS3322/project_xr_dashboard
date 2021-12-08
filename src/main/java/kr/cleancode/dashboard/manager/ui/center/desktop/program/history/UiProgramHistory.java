
package kr.cleancode.dashboard.manager.ui.center.desktop.program.history;

import kr.cleancode.dashboard.manager.module.program.service.ProgramSqlVo;
import kr.cleancode.dashboard.manager.ui.center.desktop.program.history.cmd.UiProgramHistoryCmd;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;

public class UiProgramHistory extends JPanel{

	private static final long serialVersionUID = 2784569983081471610L;

	private volatile static UiProgramHistory object = null;
	
	public static final UiProgramHistory getInstance(){
		if(object == null){
			synchronized (UiProgramHistory.class) {
				if(object == null){
					object = new UiProgramHistory();
				}
			}
		}
		return object;
	}
	
	private String viewName = "Program History";
	private static final String[] tableHeader = {"Object", "Manufacturer", "Module Name", "Version", "Developer", "Installation Time", "Uninstallation Time"};
	public static final DefaultTableModel defaultTableModel = new DefaultTableModel(tableHeader, 0);
	private static final JTable jTable = new JTable(defaultTableModel){
		private static final long serialVersionUID = 3227533588102677425L;

		@Override
		public boolean isCellEditable(int i, int c){
			return false;
		}
	};
	
	public UiProgramHistory(){
		setName(viewName);
		setBackground(Color.black);
		
		final JPanel jPanelLabel = new JPanel();
		jPanelLabel.setOpaque(false);
		jPanelLabel.setLayout(null);
		
		final JLabel lblTitle = new JLabel("Update History");
		lblTitle.setFont(lblTitle.getFont().deriveFont(lblTitle.getFont().getStyle() | Font.BOLD, lblTitle.getFont().getSize() + 10f));
		lblTitle.setBounds(12, 10, 208, 32);
		lblTitle.setForeground(Color.white);
		jPanelLabel.add(lblTitle);
		
		final JLabel lblDetail = new JLabel("You can check the update history in the list.");
		lblDetail.setBounds(12, 56, 402, 15);
		lblDetail.setForeground(Color.white);
		jPanelLabel.add(lblDetail);
		
		final JScrollPane jScrollPane = new JScrollPane(jTable);
		
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTable.getTableHeader().setReorderingAllowed(false);
		jTable.addMouseListener(new MouseAdapter() {
			private final JPopupMenu createJPopupMenu(final ProgramSqlVo programSqlVo){
				final JPopupMenu jPopupMenu = new JPopupMenu();
				final JMenuItem jMenuItem = new JMenuItem("Module Restore");
				jMenuItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new UiProgramHistoryCmd().restoreModule(programSqlVo);
					}
				});
				jPopupMenu.add(jMenuItem);
				
				return jPopupMenu;
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				final JTable jTable = (JTable)e.getSource();
				if(!SwingUtilities.isRightMouseButton(e)){
					return;
				}
				
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						final int selectIndex = jTable.rowAtPoint(e.getPoint());
						if(0 <= selectIndex && selectIndex < jTable.getRowCount()){
							jTable.setRowSelectionInterval(selectIndex, selectIndex);
						}else{
							jTable.clearSelection();
						}
						
						final int rowIndex = jTable.getSelectedRow();
						if(rowIndex < 0){
							return;
						}
						
						final ProgramSqlVo programSqlVo = (ProgramSqlVo)jTable.getValueAt(rowIndex, 0);
						if(null != programSqlVo.getMOD_DT()){
							final JPopupMenu jPopupMenu = createJPopupMenu(programSqlVo);
							jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
						}
					}
				});
			}
		});
		
		jTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
			private static final long serialVersionUID = -863028259463216946L;
			@Override
			public void setHorizontalAlignment(int alignment) {
				super.setHorizontalAlignment(SwingConstants.CENTER);
			}
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				final Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						component.setForeground(Color.gray);
						
						if(row < table.getRowCount()){
							final ProgramSqlVo programSqlVo = (ProgramSqlVo)table.getValueAt(row, 0);
							
							table.setValueAt(programSqlVo.getMANUFACTURER(), row, 1);
							table.setValueAt(programSqlVo.getMODULE_NM(), row, 2);
							table.setValueAt(programSqlVo.getVERSION(), row, 3);
							table.setValueAt(programSqlVo.getDEVELOPER(), row, 4);
							table.setValueAt(programSqlVo.getREG_DT(), row, 5);
							table.setValueAt(programSqlVo.getMOD_DT(), row, 6);
						}
					}
				});
				
				return component;
			}
		});
		jTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 6428642775811674024L;
			JLabel jLabel = new JLabel();
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				jLabel.setFont((Font)UIManager.get("TableHeader.font"));
				jLabel.setText(value.toString());
				jLabel.setHorizontalAlignment(SwingConstants.CENTER);
				jLabel.setBackground(Color.black);
				jLabel.setForeground(Color.white);
				jLabel.setOpaque(true);
				return jLabel;
			}
		});
		jTable.getParent().addComponentListener(new ComponentAdapter(){
			@Override
			public void componentResized(ComponentEvent e) {
				if(jTable.getPreferredSize().width < jTable.getParent().getWidth()){
		            jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		        }else{
		            jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		        }
			}
		});
		
		jTable.getColumnModel().getColumn(0).setMinWidth(0);
		jTable.getColumnModel().getColumn(0).setMaxWidth(0);
		jTable.getColumnModel().getColumn(0).setWidth(0);
		   
		jTable.setOpaque(false);
		((DefaultTableCellRenderer)jTable.getDefaultRenderer(Object.class)).setOpaque(false);
		jScrollPane.getViewport().setOpaque(false);
		
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(defaultTableModel);
		jTable.setRowSorter(sorter);
		jTable.setRowHeight(jTable.getFont().getSize() + 10);
		
		final GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jScrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addComponent(jPanelLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jPanelLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		setLayout(groupLayout);
	}
}
