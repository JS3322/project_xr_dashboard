/**
 * @Made_By: JS
 */
package kr.cleancode.dashboard.manager.check;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class CheckBrforePerform {

	private final Logger logger = LogManager.getLogger(CheckBrforePerform.class);
	
	public void check() {
		this.directoryCheck();
	}
	
	private void directoryCheck() {
		final File directoryRoot = new File(XrManagerProperties.getValueForJava("path.root"));
		this.folderCheck(directoryRoot);
		
		final File directoryModule = new File(directoryRoot, XrManagerProperties.getValueForJava("name.folder.module"));
		this.folderCheck(directoryModule);
		
		final File directoryOldModule = new File(directoryRoot, XrManagerProperties.getValueForJava("name.folder.module.old"));
		this.folderCheck(directoryOldModule);
		
		final File directoryTemp = new File(directoryRoot, XrManagerProperties.getValueForJava("name.folder.temp"));
		this.folderCheck(directoryTemp);
		
		final File directoryLib = new File(directoryRoot, XrManagerProperties.getValueForJava("name.folder.lib"));
		this.folderCheck(directoryLib);
		
		final File directoryDb = new File(directoryRoot, XrManagerProperties.getValueForJava("name.folder.db"));
		this.folderCheck(directoryDb);
		
		final File directoryLog = new File(directoryRoot, XrManagerProperties.getValueForJava("name.folder.log"));
		this.folderCheck(directoryLog);
		
		final File directoryCode = new File(directoryRoot, XrManagerProperties.getValueForJava("name.folder.code"));
		this.folderCheck(directoryCode);
	}
	
	private void folderCheck(final File trgtFolder) {
		logger.info(String.format("[%s] Confirmation of creating a required directory[%s].", XrManagerProperties.moduleName, trgtFolder.getPath()));
		if(trgtFolder.exists()) {
			logger.info(String.format("[%s] There is a required directory[%s].", XrManagerProperties.moduleName, trgtFolder.getPath()));
			return;
		}
		
		final boolean result = trgtFolder.mkdirs();
		logger.info(String.format("[%s] The result of creating a required directory[%s] is: %b.", XrManagerProperties.moduleName, trgtFolder.getPath(), result));
		if(!result) {
			System.exit(1);
		}
	}
}
