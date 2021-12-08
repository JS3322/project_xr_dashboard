package kr.cleancode.dashboard.manager.ui.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class XrManagerLookAndFeel {

	private Logger logger = LogManager.getLogger(XrManagerLookAndFeel.class);
	
	public void perform(){
		setLookAndFeel(new NimbusLookAndFeel());
	}
	
	private void setLookAndFeel(final LookAndFeel lookAndFeel){
		try {
			System.setProperty("sun.java2d.opengl", "true");
			System.setProperty("sun.java2d.d3d", "true");
			System.setProperty("sun.java2d.noddraw", "true");
			System.setProperty("swing.aatext", "true");
			
//			System.setProperty("awt.nativeDoubleBuffering", "true");
			
			UIManager.setLookAndFeel(lookAndFeel);
			
			// 파일 탐색기 새폴더 못만들게 하기
			UIManager.getLookAndFeelDefaults().put("FileChooser.readOnly", Boolean.TRUE);
			
			// 화면 불할 색
			UIManager.getLookAndFeelDefaults().put("SplitPane:SplitPaneDivider[Enabled].backgroundPainter", new Painter<Object>() {
				@Override
				public void paint(Graphics2D graphics2d, Object object, int width, int height) {
					graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
					graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
					graphics2d.setColor(new Color(0, 0, 0));
					graphics2d.fillRect(0, 0, width, height);
				}
			});
			UIManager.put("SplitPane:SplitPaneDivider[Enabled].foregroundPainter", new Painter<Object>() {
				@Override
				public void paint(Graphics2D graphics2d, Object object, int width, int height) {
					graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
					graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
					graphics2d.setColor(Color.black);
					graphics2d.fillRect(0, 0, width, height);
				}
			});
			UIManager.getDefaults().put("Table.showGrid" , true);
			
			// 버튼 색 및 색깔 변경
			UIManager.getLookAndFeelDefaults().put("Button.background", Color.darkGray);
			UIManager.getLookAndFeelDefaults().put("Button.textForeground", Color.white);
			
			UIManager.getLookAndFeelDefaults().put("ScrollBar:ScrollBarTrack[Enabled].backgroundPainter", new Painter<Object>() {
				@Override
				public void paint(Graphics2D graphics2d, Object object, int width, int height) {
					graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
					graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
					graphics2d.setColor(Color.gray);
					graphics2d.fillRect(0, 0, width, height);
				}
			});
		} catch (UnsupportedLookAndFeelException e) {
			logger.error(String.format("[%s] Look And Feel Exception: %s", e.getMessage()), e);
		}
	}
}
