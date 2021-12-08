package kr.cleancode.dashboard.manager.module.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;

import java.io.File;
import java.net.URLClassLoader;
import java.util.Observable;
import java.util.Observer;

public class ModuleLoadVo implements Observer{

	private Logger logger = LogManager.getLogger(ModuleLoadVo.class);
	
	private String moduleName = null;
	private String lisUpperPk = null;
	private String version = null;
	private String manufacturer = null;
	private String developer = null; 
	private String releaseDate = null;
	private String description = null;
	private String installConfig = null;
	private String installMainGuiClass = null;
	private String installCommunicationClass = null;
	private String installMainClass = null;
	private String installMainClassPerformOn = null;
	private String installMainClassPerformOff = null;
	
	private File moduleFile = null;
	private URLClassLoader classLoader = null;
	private Object objectGui = null;
	private Object objectNgsCommunication = null;
	private Class<?> loadMainClass = null;
	private Object objectMainClass = null;
	
	public ModuleLoadVo(final Document document) throws ModuleLoadVoException{
		final Element eRoot = document.getRootElement();
		if(null == eRoot){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "ngs"));
		}
		
		final Element eModule = eRoot.getChild("module");
		if(null == eModule){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "module"));
		}
		
		this.moduleName = eModule.getChildText("name");
		if(null == moduleName){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "name value"));
		}
		
		this.lisUpperPk = eModule.getChild("name").getAttributeValue("lisUpperPk");
		if(null == lisUpperPk){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "lisUpperPk attribute value"));
		}
		
		this.version = eModule.getChildText("version");
		if(null == version){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "version value"));
		}
		
		this.manufacturer = eModule.getChildText("manufacturer");
		if(null == manufacturer){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "manufacturer value"));
		}
		
		this.developer = eModule.getChildText("developer");
		if(null == developer){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "developer value"));
		}
		
		this.releaseDate = eModule.getChildText("releaseDate");
		if(null == releaseDate){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "releaseDate value"));
		}
		
		this.description = eModule.getChildText("description");
		if(null == description){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "description value"));
		}
		
		final Element eInstall = eModule.getChild("install");
		if(null == eInstall){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "install"));
		}
		
		this.installConfig = eInstall.getChildText("config");
		if(null == installConfig){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "config value"));
		}
		
		final Element eMainGuiClass = eInstall.getChild("mainGuiClass");
		if(null == eMainGuiClass){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "mainGuiClass"));
		}
		
		this.installMainGuiClass = eMainGuiClass.getAttributeValue("class");
		if(null == installMainGuiClass){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "class attribute value"));
		}
		
		final Element eCommunicationClass = eInstall.getChild("communicationClass");
		if(null == eCommunicationClass){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "communicationClass"));
		}else if("Y".equals(eCommunicationClass.getAttributeValue("use"))){
			this.installCommunicationClass = eCommunicationClass.getAttributeValue("class");
		}
		 
		final Element eMainClass = eInstall.getChild("mainClass");
		if(null == eMainClass){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "mainClass"));
		}
		
		this.installMainClass = eMainClass.getAttributeValue("class");
		if(null == installMainClass){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "class attribute value"));
		}
		
		final Element ePerformOn = eMainClass.getChild("performOn");
		if(null == ePerformOn){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "performOn"));
		}
		
		this.installMainClassPerformOn = ePerformOn.getAttributeValue("methodName");
		if(null == installMainClassPerformOn){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "methodName attribute value"));
		}
		
		final Element ePerformOff = eMainClass.getChild("performOff");
		if(null == ePerformOff){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "performOff"));
		}
		
		this.installMainClassPerformOff = ePerformOff.getAttributeValue("methodName");
		if(null == installMainClassPerformOff){
			throw new ModuleLoadVoException(String.format("There are no required items[%s] in the NGS module.", "methodName attribute value"));
		}
		
	}
	
	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getLisUpperPk() {
		return lisUpperPk;
	}

	public void setLisUpperPk(String lisUpperPk) {
		this.lisUpperPk = lisUpperPk;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstallConfig() {
		return installConfig;
	}

	public void setInstallConfig(String installConfig) {
		this.installConfig = installConfig;
	}

	public String getInstallMainGuiClass() {
		return installMainGuiClass;
	}

	public void setInstallMainGuiClass(String installMainGuiClass) {
		this.installMainGuiClass = installMainGuiClass;
	}

	public String getInstallCommunicationClass() {
		return installCommunicationClass;
	}

	public void setInstallCommunicationClass(String installCommunicationClass) {
		this.installCommunicationClass = installCommunicationClass;
	}

	public String getInstallMainClass() {
		return installMainClass;
	}

	public void setInstallMainClass(String installMainClass) {
		this.installMainClass = installMainClass;
	}

	public String getInstallMainClassPerformOn() {
		return installMainClassPerformOn;
	}

	public void setInstallMainClassPerformOn(String installMainClassPerformOn) {
		this.installMainClassPerformOn = installMainClassPerformOn;
	}

	public String getInstallMainClassPerformOff() {
		return installMainClassPerformOff;
	}

	public void setInstallMainClassPerformOff(String installMainClassPerformOff) {
		this.installMainClassPerformOff = installMainClassPerformOff;
	}

	public URLClassLoader getClassLoader() {
		return classLoader;
	}

	public void setClassLoader(URLClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	public File getModuleFile() {
		return moduleFile;
	}

	public void setModuleFile(File moduleFile) {
		this.moduleFile = moduleFile;
	}

	public Object getObjectGui() {
		return objectGui;
	}

	public void setObjectGui(Object objectGui) {
		this.objectGui = objectGui;
	}

	public Object getObjectNgsCommunication() {
		return objectNgsCommunication;
	}

	public void setObjectNgsCommunication(Object objectNgsCommunication) {
		this.objectNgsCommunication = objectNgsCommunication;
	}

	public Class<?> getLoadMainClass() {
		return loadMainClass;
	}

	public void setLoadMainClass(Class<?> loadMainClass) {
		this.loadMainClass = loadMainClass;
	}

	public Object getObjectMainClass() {
		return objectMainClass;
	}

	public void setObjectMainClass(Object objectMainClass) {
		this.objectMainClass = objectMainClass;
	}

	@Override
	public String toString() {
		return this.moduleName;
	}

	@Override
	public void update(Observable o, Object arg) {
		logger.debug(String.format("[%s] NgsCommunication Requester: %s, Message: %s", this.moduleName, o.getClass().getName(), arg));
		
	}

}
