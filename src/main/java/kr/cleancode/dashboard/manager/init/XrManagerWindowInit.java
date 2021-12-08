
package kr.cleancode.dashboard.manager.init;

import java.io.File;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.cleancode.dashboard.manager.module.service.ModuleLoadVo;
import kr.cleancode.dashboard.manager.service.XrManagerEnum.UiUserLevel;
import kr.cleancode.dashboard.manager.ui.center.desktop.popup.service.UiUserLevelVo;

public class XrManagerWindowInit extends Observable {

	private Logger logger = LogManager.getLogger(XrManagerWindowInit.class);
	
	private volatile static XrManagerWindowInit object = null;
	
	public static final XrManagerWindowInit getInstance(){
		if(object == null){
			synchronized (XrManagerWindowInit.class) {
				if(object == null){
					object = new XrManagerWindowInit();
				}
			}
		}
		
		return object;
	}
	
	public final UiUserLevelVo[] uiUserLevelVos = {new UiUserLevelVo(UiUserLevel.Root, "manager123!")
											, new UiUserLevelVo(UiUserLevel.Manager, "manager123")
											, new UiUserLevelVo(UiUserLevel.User, "")};
	private UiUserLevelVo uiUserLevelVo = uiUserLevelVos[2];

	// 파일 탐색기 경로 기억용
	public File currentDirectory = null;
	
	public final Map<ModuleLoadVo, URLClassLoader> modulesClasses = new HashMap<ModuleLoadVo, URLClassLoader>(){
		private static final long serialVersionUID = 1801356983230583494L;

		@Override
		public URLClassLoader put(ModuleLoadVo key, URLClassLoader value) {
			final URLClassLoader urlClassLoader = super.put(key, value);
			
			communication("ngsModuleClasses");
			
			return urlClassLoader;
		}

		@Override
		public URLClassLoader remove(Object key) {
			final URLClassLoader urlClassLoader = super.remove(key);
			
			communication("ngsModuleClasses");
			
			return urlClassLoader;
		}
	};
	
	public UiUserLevelVo getUiUserLevelVo() {
		return uiUserLevelVo;
	}
	public void setUiUserLevelVo(UiUserLevelVo uiUserLevelVo) {
		this.uiUserLevelVo = uiUserLevelVo;
	}
	
	public void communication(final Object object){
		setChanged();
		notifyObservers(object);
	}
}
