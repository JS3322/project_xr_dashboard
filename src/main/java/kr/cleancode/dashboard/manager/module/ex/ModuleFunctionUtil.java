
package kr.cleancode.dashboard.manager.module.ex;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.init.XrManagerWindowInit;
import kr.cleancode.dashboard.manager.module.service.ModuleLoadVo;
import kr.cleancode.dashboard.manager.module.coordinates.service.CoordinatesSqlVo;
import kr.cleancode.dashboard.manager.module.service.ModuleLoadVoException;
import kr.cleancode.dashboard.manager.ui.center.desktop.UiDeskTopPane;
import kr.cleancode.dashboard.manager.ui.center.menubar.UiMenubar;
import kr.cleancode.dashboard.manager.ui.center.menubar.ex.UiMenuIcon;
import kr.cleancode.dashboard.manager.ui.center.menubar.ex.UiMenuProgramIcon;
import kr.cleancode.dashboard.manager.util.ThreadSleep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Observable;
import java.util.Observer;

public class ModuleFunctionUtil {

	private Logger logger = LogManager.getLogger(ModuleFunctionUtil.class);
	
	/**
	 * <pre>
	 * Overview: 모듈이 사용될수 있는 모듈인지를 확인 한다.
	 * Processing contents: ngs.module.information.ModuleInformation 가 있는지 확인 한다. 
	 * </pre>
	 * @Method_Name: moduleValidation
	 * @param moduleFile
	 * @return
	 *
	 */
	public final boolean moduleValidation(final File moduleFile){
		URL url = null;
		URLClassLoader classLoader = null;
		try {
			url = new URL(String.format("jar:%s!/", moduleFile.toURI().toURL()));
			
			classLoader = new URLClassLoader(new URL [] {url});
			final Class<?> loadClass = classLoader.loadClass("ngs.module.information.ModuleInformation");
			final Object object = loadClass.newInstance();
			
			final Method method = loadClass.getDeclaredMethod("getInformation");
			
			final String strXml = (String)method.invoke(object);
			
			new SAXBuilder().build(new StringReader(strXml));
			logger.trace(new XMLOutputter(Format.getPrettyFormat()).outputString(new SAXBuilder().build(new StringReader(strXml))));
			
			return true;
		} catch (MalformedURLException e) {
			// Module File URL 없음
			logger.error(String.format("[%s] Module file is invalid.", XrManagerProperties.moduleName), e);
			return false;
		} catch (ClassNotFoundException e) {
			// 모듈 파일에 해당 클래스가 없습니다.
			logger.error(String.format("[%s] Module file does not contain this class.", XrManagerProperties.moduleName), e);
			return false;
		} catch (InstantiationException | IllegalAccessException e) {
			// 모듈 파일에 해당 클래스를 생성 할수 없습니다.
			logger.error(String.format("[%s] Unable to create class in module file.", XrManagerProperties.moduleName), e);
			return false;
		} catch (NoSuchMethodException | SecurityException e) {
			// 모듈 파일에 해당 Method가 없습니다.
			logger.error(String.format("[%s] Module file does not contain this method.", XrManagerProperties.moduleName), e);
			return false;
		} catch (IllegalArgumentException | InvocationTargetException e) {
			// 모듈 파일에 해당 method를 실행 할수 없습니다.
			logger.error(String.format("[%s] Unable to execute the method in the module file.", XrManagerProperties.moduleName), e);
			return false;
		} catch (JDOMException | IOException e) {
			// 모듈 파일이 XML을 제공 하지 않습니다.
			logger.error(String.format("[%s] Module file does not provide XML.", XrManagerProperties.moduleName), e);
			return false;
		} finally {
			this.classLoaderClose(classLoader);
		}
	}

	public final ModuleLoadVo xmlToModuleLoadvo(final File moduleFile){
		URL url = null;
		URLClassLoader classLoader = null;
		try {
			url = new URL(String.format("jar:%s!/", moduleFile.toURI().toURL()));
			
			classLoader = new URLClassLoader(new URL [] {url});
			final Class<?> loadClass = classLoader.loadClass("ngs.module.information.ModuleInformation");
			final Object object = loadClass.newInstance();
			
			final Method method = loadClass.getDeclaredMethod("getInformation");
			
			final String strXml = (String)method.invoke(object);
			
			final Document document = new SAXBuilder().build(new StringReader(strXml));
			System.out.println(new XMLOutputter(Format.getPrettyFormat()).outputString(document));
			
			return new ModuleLoadVo(document);
		} catch (MalformedURLException e) {
			// Module File URL 없음
			logger.error(String.format("[%s] Module file is invalid.", XrManagerProperties.moduleName), e);
			return null;
		} catch (ClassNotFoundException e) {
			// 모듈 파일에 해당 클래스가 없습니다.
			logger.error(String.format("[%s] Module file does not contain this class.", XrManagerProperties.moduleName), e);
			return null;
		} catch (InstantiationException | IllegalAccessException e) {
			// 모듈 파일에 해당 클래스를 생성 할수 없습니다.
			logger.error(String.format("[%s] Unable to create class in module file.", XrManagerProperties.moduleName), e);
			return null;
		} catch (NoSuchMethodException | SecurityException e) {
			// 모듈 파일에 해당 Method가 없습니다.
			logger.error(String.format("[%s] Module file does not contain this method.", XrManagerProperties.moduleName), e);
			return null;
		} catch (IllegalArgumentException | InvocationTargetException e) {
			// 모듈 파일에 해당 method를 실행 할수 없습니다.
			logger.error(String.format("[%s] Unable to execute the method in the module file.", XrManagerProperties.moduleName), e);
			return null;
		} catch (JDOMException | IOException e) {
			// 모듈 파일이 XML을 제공 하지 않습니다.
			logger.error(String.format("[%s] Module file does not provide XML.", XrManagerProperties.moduleName), e);
			return null;
		} catch (ModuleLoadVoException e) {
			logger.error(String.format("[%s] The XML provided by the module file is not for NGS.", XrManagerProperties.moduleName), e);
			return null;
		} finally {
			this.classLoaderClose(classLoader);
		}
	}
	

	public final boolean moduleStart(final File moduleFile, final ModuleLoadVo moduleLoadVo, final Point point){
		URL url = null;
		URLClassLoader classLoader = null;
		try {
			url = new URL(String.format("jar:%s!/", moduleFile.toURI().toURL()));
			
			classLoader = new URLClassLoader(new URL [] {url});
			// ClassLoader 기록
			moduleLoadVo.setClassLoader(classLoader);
			
			// Main Class 실행 
			final Class<?> loadMainClass = classLoader.loadClass(moduleLoadVo.getInstallMainClass());
			final Object objectMainClass = loadMainClass.newInstance();
			final Method methodOperateOn = loadMainClass.getDeclaredMethod("operateOn");
			System.out.println("objectMainClass: " + objectMainClass + " methodOperateOn: " + methodOperateOn);
			methodOperateOn.invoke(objectMainClass);
			
			// Main Class 기록
			moduleLoadVo.setLoadMainClass(loadMainClass);
			moduleLoadVo.setObjectMainClass(objectMainClass);
						
			final Class<?> loadGuiClass = classLoader.loadClass(moduleLoadVo.getInstallMainGuiClass());
//			final Object objectGui = loadGuiClass.newInstance();
			
			final Object objectGui = loadGuiClass.getDeclaredMethod("getInstance").invoke(loadGuiClass);
			
			// GUI 오픈
			final JInternalFrame jInternalFrame = (JInternalFrame)objectGui;
			ThreadSleep.sleep(10);
			
			final CoordinatesSqlVo coordinatesSqlVo = new ModuleGuiFunctionUtil().getCoordinates(moduleLoadVo.getLisUpperPk(), moduleLoadVo.getModuleName());
			
			if(null == coordinatesSqlVo){
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						try {
							UiDeskTopPane.getInstance().add(jInternalFrame);
							
							final Dimension desktopSize = UiDeskTopPane.getInstance().getSize();
							final Dimension jInternalFrameSize = jInternalFrame.getSize();
							jInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height- jInternalFrameSize.height)/2);
							
							if(jInternalFrame.getLocation().y + point.y < 0) {
								jInternalFrame.setLocation(jInternalFrame.getLocation().x + point.x, 0);
							}else {
								jInternalFrame.setLocation(jInternalFrame.getLocation().x + point.x, jInternalFrame.getLocation().y + point.y);
							}
							
							final UiMenuIcon uiMenuIcon = new UiMenuIcon(loadGuiClass, objectGui);
							UiMenubar.getInstance().jToolBar.add(uiMenuIcon);
							UiMenubar.getInstance().jToolBar.repaint();
							
							UiMenubar.getInstance().jMenuProgram.add(new UiMenuProgramIcon(loadGuiClass, objectGui));
						} catch (NullPointerException e) {
							logger.error(String.format("[%s] Module(%s) View Load Error.", XrManagerProperties.moduleName, moduleLoadVo.getModuleName()), e);
						}
					}
				});
			}else{
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						try {
							UiDeskTopPane.getInstance().add(jInternalFrame);
							
							jInternalFrame.setMaximum(true);
							
							if(coordinatesSqlVo.getAXIS_Y() < 0) {
								jInternalFrame.setBounds(coordinatesSqlVo.getAXIS_X(), 0, coordinatesSqlVo.getRTG_WIDTH(), coordinatesSqlVo.getRTG_HEIGHT());
							}else {
								jInternalFrame.setBounds(coordinatesSqlVo.getAXIS_X(), coordinatesSqlVo.getAXIS_Y(), coordinatesSqlVo.getRTG_WIDTH(), coordinatesSqlVo.getRTG_HEIGHT());
							}
							
							
							jInternalFrame.setIcon(true);
							jInternalFrame.getDesktopIcon().setBounds(coordinatesSqlVo.getICON_AXIS_X(), coordinatesSqlVo.getICON_AXIS_Y(), jInternalFrame.getDesktopIcon().getWidth(), jInternalFrame.getDesktopIcon().getHeight());
							
							jInternalFrame.setMaximum("Y".equals(coordinatesSqlVo.getMAXIMUM()));
							jInternalFrame.setIcon("Y".equals(coordinatesSqlVo.getMINIMUM()));
							
							final UiMenuIcon uiMenuIcon = new UiMenuIcon(loadGuiClass, objectGui);
							UiMenubar.getInstance().jToolBar.add(uiMenuIcon);
							UiMenubar.getInstance().jToolBar.repaint();
							
							UiMenubar.getInstance().jMenuProgram.add(new UiMenuProgramIcon(loadGuiClass, objectGui));
						} catch (PropertyVetoException e) {
							logger.error(String.format("[%s] Module(%s) View Load Error.", XrManagerProperties.moduleName, moduleLoadVo.getModuleName()), e);
						} catch (NullPointerException e) {
							logger.error(String.format("[%s] Module(%s) View Load Error.", XrManagerProperties.moduleName, moduleLoadVo.getModuleName()), e);
						}
					}
				});
			}
			
			// Gui 기록
			moduleLoadVo.setObjectGui(objectGui);
			
			// NgsCommunicationClass 가져온다.
			if(null != moduleLoadVo.getInstallCommunicationClass()){
				final Class<?> loadNgsCommunicationClass = classLoader.loadClass(moduleLoadVo.getInstallCommunicationClass());
				final Method methodGetInstance = loadNgsCommunicationClass.getDeclaredMethod("getInstance");
				final Object objectNgsCommunication = methodGetInstance.invoke(loadNgsCommunicationClass);
				
				// Observer 등록 (NGS Window -> Module)
				XrManagerWindowInit.getInstance().addObserver((Observer)objectNgsCommunication);
				
				// Observer 등록 (Module -> NGS Window)
				((Observable)objectNgsCommunication).addObserver(moduleLoadVo);
				
				// Communication 등록
				moduleLoadVo.setObjectNgsCommunication(objectNgsCommunication);
				
				// NgsWindowInit Class 연결
				final Method methodSetNgsWindonwInit = loadNgsCommunicationClass.getDeclaredMethod("setNgsWindonwInit", Object.class);
				methodSetNgsWindonwInit.invoke(objectNgsCommunication, XrManagerWindowInit.getInstance());
			}
			
			// 파일 기록
			moduleLoadVo.setModuleFile(moduleFile);
			
			XrManagerWindowInit.getInstance().modulesClasses.put(moduleLoadVo, classLoader);
			
			logger.info(String.format("[%s] Module[%s %s] Load Success", XrManagerProperties.moduleName, moduleLoadVo.getModuleName(), moduleLoadVo.getVersion()));
			
			return true;
		} catch (MalformedURLException e) {
			// Module File URL 없음
			logger.error(String.format("[%s] Module[%s] file is invalid.", XrManagerProperties.moduleName, moduleLoadVo.getModuleName()), e);
			this.classLoaderClose(classLoader);
			return false;
		} catch (ClassNotFoundException e) {
			// 모듈 파일에 해당 클래스가 없습니다.
			logger.error(String.format("[%s] Module[%s] file does not contain this class.", XrManagerProperties.moduleName, moduleLoadVo.getModuleName()), e);
			this.classLoaderClose(classLoader);
			return false;
		} catch (InstantiationException | IllegalAccessException e) {
			// 모듈 파일에 해당 클래스를 생성 할수 없습니다.
			logger.error(String.format("[%s] Unable to create class in module[%s] file.", XrManagerProperties.moduleName, moduleLoadVo.getModuleName()), e);
			this.classLoaderClose(classLoader);
			return false;
		} catch (NoSuchMethodException | SecurityException e) {
			// 모듈 파일에 해당 Method가 없습니다.
			logger.error(String.format("[%s] Module[%s] file does not contain this method.", XrManagerProperties.moduleName, moduleLoadVo.getModuleName()), e);
			this.classLoaderClose(classLoader);
			return false;
		} catch (IllegalArgumentException e) {
			// 모듈 파일에 해당 method를 시행 할수 없습니다.
			logger.error(String.format("[%s] Unable to execute the method in the module[%s] file.", XrManagerProperties.moduleName, moduleLoadVo.getModuleName()), e);
			this.classLoaderClose(classLoader);
			return false;
		} catch (InvocationTargetException e) {
			this.classLoaderClose(classLoader);
			e.getTargetException().printStackTrace();
			return false;
		}
	}
	
	public void moduleStop(final ModuleLoadVo moduleLoadVo){
		final URLClassLoader urlClassLoader = (URLClassLoader)XrManagerWindowInit.getInstance().modulesClasses.get(moduleLoadVo);
		
		// Main Thread 중지
		Method method;
		try {
			method = moduleLoadVo.getLoadMainClass().getMethod(moduleLoadVo.getInstallMainClassPerformOff());
			
			method.invoke(moduleLoadVo.getObjectMainClass());
			
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					// GUI 중지
					final JInternalFrame jInternalFrame = ((JInternalFrame)moduleLoadVo.getObjectGui());
					jInternalFrame.setVisible(false); 
					jInternalFrame.dispose();
				}
			});
			
			// Toolbar 삭제
			final JToolBar jToolBar = UiMenubar.getInstance().jToolBar;
			if(0 < jToolBar.getComponentCount()){
				for(int i = 0 ; i < jToolBar.getComponentCount() ; i++){
					final Component component = jToolBar.getComponent(i);
					if(component instanceof UiMenuIcon){
						final UiMenuIcon uiMenuIcon = (UiMenuIcon)component;
						if(moduleLoadVo.getModuleName().equals(uiMenuIcon.getIconName())){
							SwingUtilities.invokeLater(new Runnable() {
								@Override
								public void run() {
									jToolBar.remove(component);
									jToolBar.updateUI();
								}
							});
						}
					}
				}
			}
			
			// Main Menu Program 삭제
			final JMenu jMenuProgram = UiMenubar.getInstance().jMenuProgram;
			if(0 < jMenuProgram.getItemCount()){
				for(int i = 0 ; i < jMenuProgram.getItemCount() ; i++){
					final Component component = jMenuProgram.getItem(i);
					if(component instanceof UiMenuProgramIcon){
						final UiMenuProgramIcon uiMenuProgramIcon = (UiMenuProgramIcon)component;
						if(moduleLoadVo.getModuleName().equals(uiMenuProgramIcon.getIconName())){
							SwingUtilities.invokeLater(new Runnable() {
								@Override
								public void run() {
									jMenuProgram.remove(component);
									jMenuProgram.updateUI();
								}
							});
						}
					}
				}
			}
			
			// Observer 삭제 (NGS Window -> Module)
			XrManagerWindowInit.getInstance().deleteObserver((Observer)moduleLoadVo.getObjectNgsCommunication());
			
			// Observer 삭제 (Module -> NGS Window)
			((Observable)moduleLoadVo.getObjectNgsCommunication()).deleteObserver(moduleLoadVo);
			
			urlClassLoader.close();
			
			XrManagerWindowInit.getInstance().modulesClasses.remove(moduleLoadVo);
			
			//모듈을 중지 했습니다.
			logger.info(String.format("[%s] Module(%s) has been stopped.", XrManagerProperties.moduleName, moduleLoadVo.getModuleName()));
		} catch (NoSuchMethodException | SecurityException e) {
			// 모듈 중지시 해당 Method가 없습니다.
			logger.error(String.format("[%s] When a module(%s) is stopped, there is no corresponding method.", XrManagerProperties.moduleName, moduleLoadVo.getModuleName()), e);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// 모듈 중지시 해당 Method를 실행 할수 없습니다.
			logger.error(String.format("[%s] When a module(%s) is stopped, the method cannot be executed.", XrManagerProperties.moduleName, moduleLoadVo.getModuleName()), e);
		} catch (IOException e) {
			// 모듈 중지시 모듈을 닫을수 없습니다.
			logger.error(String.format("[%s] Unable to close module(%s) when module is stopped.", XrManagerProperties.moduleName, moduleLoadVo.getModuleName()), e);
		}
	}
	
	private void classLoaderClose(final URLClassLoader urlClassLoader){
		try {
			if(null != urlClassLoader){
				urlClassLoader.close();
			}
		} catch (IOException e) {
			logger.error(String.format("[%s] UrlClassLoader Close Exception", XrManagerProperties.moduleName), e);
		}
	}
	
}
