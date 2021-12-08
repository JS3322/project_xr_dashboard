
package kr.cleancode.dashboard.manager.ui.os;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;

public class XrManagerOsCommand {

	private Logger logger = LogManager.getLogger(XrManagerOsCommand.class);
	
	public void osCallEthernetConfig() {
		try {
			if(-1 < System.getProperty("os.name").indexOf("Windows")){
				final String[] cmd = new String[3];
				cmd[0] = "cmd";
				cmd[1] = "/c";
				cmd[2] = "ncpa.cpl";
				new ProcessBuilder(cmd).start();
			}else{
				final List<String> cmdList = new ArrayList<String>();
				cmdList.add("nm-connection-editor");
				new ProcessBuilder(cmdList).start();
			}
		} catch (IOException e) {
			logger.warn(String.format("[%s] O/S Ethernet Config Exception: %s", XrManagerProperties.moduleName, e.getMessage()), e);
		}
	}
	
	public void osCallShutdown() {
		try {
			if(-1 < System.getProperty("os.name").indexOf("Windows")){
				Runtime.getRuntime().exec("shutdown -s -t 0");
			}else{
				Runtime.getRuntime().exec("shutdown -h now");
			}
		} catch (IOException e) {
			logger.warn(String.format("[%s] O/S Shutdown Exception: %s", XrManagerProperties.moduleName, e.getMessage()), e);
		}
	}
	
	public void osCallReboot() {
		try {
			if(-1 < System.getProperty("os.name").indexOf("Windows")){
				Runtime.getRuntime().exec("shutdown -r -t 0");
			}else{
				Runtime.getRuntime().exec("shutdown -r now");
			}
		} catch (IOException e) {
			logger.warn(String.format("[%s] O/S Shutdown Exception: %s", XrManagerProperties.moduleName, e.getMessage()), e);
		}
	}
	
	public void osCallDateTimeConfig() {
		try {
			if(-1 < System.getProperty("os.name").indexOf("Windows")) {
				final String[] cmd = new String[3];
				cmd[0] = "cmd";
				cmd[1] = "/c";
				cmd[2] = "timedate.cpl";
				new ProcessBuilder(cmd).start();
			}else {
				final List<String> cmdList = new ArrayList<String>();
				cmdList.add("system-config-date");
				new ProcessBuilder(cmdList).start();
			}
		} catch (IOException e) {
			logger.warn(String.format("[%s] O/S Date & Time Exception: %s", XrManagerProperties.moduleName, e.getMessage()), e);
		}
	}
	
	public void osCallFirewall() {
		try {
			if(-1 < System.getProperty("os.name").indexOf("Windows")) {
				final String[] cmd = new String[3];
				cmd[0] = "cmd";
				cmd[1] = "/c";
				cmd[2] = "firewall.cpl";
				
				new ProcessBuilder(cmd).start();
			}else {
				List<String> cmdList = new ArrayList<String>();
				cmdList.add("firewall-config");
				new ProcessBuilder(cmdList).start();
			}
		} catch (IOException e) {
			logger.warn(String.format("[%s] O/S Firewall Exception: %s", XrManagerProperties.moduleName, e.getMessage()), e);
		}
	}
	
	public void osCallRemoveDrivesAndMedia() {
		try {
			if(-1 < System.getProperty("os.name").indexOf("Windows")) {
				
			}else {
				final List<String> cmdList = new ArrayList<String>();
				cmdList.add("thunar-volman-settings");
				new ProcessBuilder(cmdList).start();
			}
		} catch (IOException e) {
			logger.warn(String.format("[%s] O/S Remove Drives And Media Exception: %s", XrManagerProperties.moduleName, e.getMessage()), e);
		}
	}
}
