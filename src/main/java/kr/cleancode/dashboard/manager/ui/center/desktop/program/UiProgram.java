
package kr.cleancode.dashboard.manager.ui.center.desktop.program;

import kr.cleancode.dashboard.manager.ui.center.desktop.program.cmd.UiProgramCmd;
import kr.cleancode.dashboard.manager.ui.center.desktop.program.history.UiProgramHistory;
import kr.cleancode.dashboard.manager.ui.center.desktop.program.remove.UiProgramRemove;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;

public class UiProgram extends JInternalFrame {

	private static final long serialVersionUID = 2454214289795964376L;

	private volatile static UiProgram object = null;
	
	public static final UiProgram getInstance(){
		if(object == null){
			synchronized (UiProgram.class) {
				if(object == null){
					object = new UiProgram();
				}
			}
		}
		return object;
	}
	
	private final JPanel contentPane = new JPanel();
	private final String viewName = "Program";
	
	private JPanel jPanelDetail = null;
	
	public UiProgram(){
		final UiProgramCmd uiProgramCmd = new UiProgramCmd();
		addComponentListener(uiProgramCmd.getComponentAdapter());
		
		setName(viewName);
		setTitle(viewName);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setResizable(true);
		setClosable(true);
		setBounds(0, 0, 658, 358);
		setMinimumSize(new Dimension(658, 358));
		
		this.contentPane.setBackground(Color.black);
		getContentPane().add(this.contentPane);
		
		final JPanel jPanelControl = new JPanel();
		jPanelControl.setBackground(Color.black);
		jPanelControl.setLayout(null);
		
		this.jPanelDetail = new JPanel();
		jPanelDetail.setLayout(new CardLayout(0, 0));
		jPanelDetail.add(UiProgramHistory.getInstance(), UiProgramHistory.getInstance().getName());
		jPanelDetail.add(UiProgramRemove.getInstance(), UiProgramRemove.getInstance().getName());
		
		final JToggleButton jToggleButton = new JToggleButton("Program Remove", true);
		jToggleButton.setBackground(Color.pink);
		jToggleButton.setBounds(12, 10, 135, 23);
		jToggleButton.addItemListener(uiProgramCmd.getItemListener(jPanelDetail));
		jPanelControl.add(jToggleButton);
		
		final JButton btnProgramInstall = new JButton("Program Install");
		btnProgramInstall.addActionListener(uiProgramCmd.getActionListener());
		btnProgramInstall.setBounds(14, 45, 135, 23);
		jPanelControl.add(btnProgramInstall);
		
		final GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addComponent(jPanelControl, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jPanelDetail, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(jPanelDetail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
						.addComponent(jPanelControl, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		contentPane.setLayout(gl_contentPane);
	}
}
