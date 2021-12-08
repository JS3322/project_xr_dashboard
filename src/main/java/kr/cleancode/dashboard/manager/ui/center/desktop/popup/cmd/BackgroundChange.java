package kr.cleancode.dashboard.manager.ui.center.desktop.popup.cmd;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.init.XrManagerWindowInit;
import kr.cleancode.dashboard.manager.module.background.service.BackgroundSqlService;
import kr.cleancode.dashboard.manager.module.background.service.BackgroundSqlVo;
import kr.cleancode.dashboard.manager.spring.SpringInit;
import kr.cleancode.dashboard.manager.ui.center.desktop.UiDeskTopPane;
import kr.cleancode.dashboard.manager.ui.center.desktop.popup.cmd.ex.FileChooserImagePreview;
import org.apache.commons.io.FileUtils;
import org.sqlite.date.DateFormatUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;

public class BackgroundChange {
	
	private final JFileChooser jFileChooser = this.createJFileChooser();
	
	public void change(){
		final UiDeskTopPane uiDeskTopPane = UiDeskTopPane.getInstance();
		
		final int numberOption = jFileChooser.showOpenDialog(uiDeskTopPane);
		
		final BackgroundSqlService cmd = (BackgroundSqlService)SpringInit.getBean("BackgroundSqlService");
		
		if(JFileChooser.APPROVE_OPTION == numberOption){
			// 이전 삭제
			{
				final BackgroundSqlVo backgroundSqlVo = cmd.sTMngBackgroundInfo();
				
				if(null != backgroundSqlVo) {
					final File deleteFile = new File(backgroundSqlVo.getBACKGROUND_FILE_PATH());
					if(deleteFile.exists() && deleteFile.isFile()) {
						try {
							FileUtils.forceDelete(deleteFile);
						} catch (IOException e) {
						}
					}
					
					cmd.dTMngBackgroundInfo(backgroundSqlVo.getPK_BACKGROUND_SER());
				}
			}
			
			final File file = jFileChooser.getSelectedFile();
			XrManagerWindowInit.getInstance().currentDirectory = file.getParentFile();
			
			final File tempFolder = new File(XrManagerProperties.getValueForJava("path.root"), XrManagerProperties.getValueForJava("name.folder.temp"));
			final File trgtFile = new File(tempFolder.getAbsolutePath(), String.format("backgroundImage_%s.ngsImg", DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHHmmssSSS")));
					
			try {
				FileUtils.copyFile(file, trgtFile);
			} catch (IOException e) {
				return;
			}
			
			final BackgroundSqlVo backgroundSqlVo = new BackgroundSqlVo();
			backgroundSqlVo.setBACKGROUND_FILE_NM(file.getName());
			backgroundSqlVo.setBACKGROUND_FILE_PATH(trgtFile.getAbsolutePath());
			
			if(null != cmd.iTMngBackgroundInfo(backgroundSqlVo)) {
				uiDeskTopPane.setImageIcon(new ImageIcon(trgtFile.getAbsolutePath()));
			}
		}else {
			final BackgroundSqlVo backgroundSqlVo = cmd.sTMngBackgroundInfo();
			
			if(null != backgroundSqlVo) {
				final File deleteFile = new File(backgroundSqlVo.getBACKGROUND_FILE_PATH());
				if(deleteFile.exists() && deleteFile.isFile()) {
					try {
						FileUtils.forceDelete(deleteFile);
					} catch (IOException e) {
					}
				}
				
				cmd.dTMngBackgroundInfo(backgroundSqlVo.getPK_BACKGROUND_SER());
			}
			
			uiDeskTopPane.setImageIcon(null);
		}
	}
	
	private final JFileChooser createJFileChooser(){
		final JFileChooser jFileChooser = new JFileChooser(){
			private static final long serialVersionUID = -1133414237298423711L;
			
			@Override
			protected JDialog createDialog(java.awt.Component parent) throws java.awt.HeadlessException {
				final UiDeskTopPane uiDeskTopPane = UiDeskTopPane.getInstance();
				
				final JDialog jDialog  = super.createDialog(parent);
				jDialog.setAlwaysOnTop(true);
				jDialog.setLocationByPlatform(true);
				jDialog.setLocationRelativeTo(uiDeskTopPane);
				return jDialog;
			};
		};
		
		jFileChooser.setAcceptAllFileFilterUsed(false);
		jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Image File", "jpg", "gif", "jpeg", "png"));
		jFileChooser.setMultiSelectionEnabled(false);
		jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		final FileChooserImagePreview fileChooserImagePreview = new FileChooserImagePreview();
		jFileChooser.setAccessory(fileChooserImagePreview);
		jFileChooser.addPropertyChangeListener(fileChooserImagePreview);
		
		return jFileChooser;
	}
	
}
