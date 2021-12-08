package kr.cleancode.dashboard.manager.ui.center.desktop.program.remove.cmd.ex;

import kr.cleancode.dashboard.manager.module.program.service.ProgramSqlService;
import kr.cleancode.dashboard.manager.module.program.service.ProgramSqlVo;
import kr.cleancode.dashboard.manager.spring.SpringInit;

import java.util.List;

public class UiProgramRemoveUtil {

	/**
	 * 교체 설치 인지 확인후
	 * 재부팅이 필요한 모듈에 대해서는 True 아닐시에는 False를 반환한다.
	 * @param PK_SW_DIV_SER
	 * @return
	 */
	public static final boolean deleteRebootCheck(final String PK_SW_DIV_SER) {
		final ProgramSqlService cmd = (ProgramSqlService)SpringInit.getBean("ProgramSqlService");
		
		final ProgramSqlVo lParamVo = new ProgramSqlVo();
		lParamVo.setUSE_YN("Y");
		
		final List<ProgramSqlVo> lModuleInstallVo = cmd.lTMngMiInfo(lParamVo);
		if(null != lModuleInstallVo && !lModuleInstallVo.isEmpty()) {
			for(ProgramSqlVo programSqlVo : lModuleInstallVo) {
				if(PK_SW_DIV_SER.equals(programSqlVo.getPK_SW_DIV_SER()) && rebootCheck(PK_SW_DIV_SER)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static final boolean rebootCheck(final String PK_SW_DIV_SER) {
		if("PSDS0000000000000013".equals(PK_SW_DIV_SER) // DIO
				|| "PSDS0000000000000015".equals(PK_SW_DIV_SER) // Shaker
				|| "PSDS0000000000000011".equals(PK_SW_DIV_SER) // Show
				|| "PSDS0000000000000009".equals(PK_SW_DIV_SER) // DMX
				) {
			
			return true;
		}else {
			return false;
		}
	}
	
}
