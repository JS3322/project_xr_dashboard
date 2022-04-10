/**
 * Create Time: 2021-11-12
 * Made by: JS
 */
package kr.cleancode.dashboard.manager.check;

import java.util.Iterator;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import kr.cleancode.dashboard.manager.check.ex.CheckFileDatabaseGlobal;
import kr.cleancode.dashboard.manager.check.ex.CheckFileDatabaseModule;
import kr.cleancode.dashboard.manager.check.ex.CheckFileDatabaseWeb;
import kr.cleancode.dashboard.manager.common.XrManagerProperties;

@Component
public class XrManagerInitCheck {

	private final Logger logger = LogManager.getLogger(XrManagerInitCheck.class);

	@Resource(name = "CheckFileDatabaseWeb")
	private CheckFileDatabaseWeb checkFileDatabaseWeb;

	@Resource(name = "CheckFileDatabaseGlobal")
	private CheckFileDatabaseGlobal checkFileDatabaseGlobal;

	@Resource(name = "CheckFileDatabaseModule")
	private CheckFileDatabaseModule checkFileDatabaseModule;

	@PostConstruct
	public void check() {
		this.getSystemProperties();

		logger.info(String.format("[%s] Try to identify the essential elements required for the program.",
				XrManagerProperties.moduleName));
		checkFileDatabaseWeb.check();
		checkFileDatabaseGlobal.check();
		checkFileDatabaseModule.check();
		logger.info(String.format("[%s] All essential elements required for the program have been identified.",
				XrManagerProperties.moduleName));
	}

	private void getSystemProperties() {
		logger.info(String.format("[%s] Bring the environmental configuration of the system.",
				XrManagerProperties.moduleName));
		final Properties properties = System.getProperties();
		final Iterator<Object> iterator = properties.keySet().iterator();
		while (iterator.hasNext()) {
			final Object key = iterator.next();
			if (!"line.separator".equals(key)) {
				logger.info(String.format("[%s] Key: %s, Value: \\%s.", XrManagerProperties.moduleName, key,
						properties.get(key)));
			}
		}
	}
}
