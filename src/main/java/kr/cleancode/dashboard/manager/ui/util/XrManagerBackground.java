package kr.cleancode.dashboard.manager.ui.util;

import javax.swing.*;
import java.awt.*;

public class XrManagerBackground {

	public void changeBackground(final Graphics graphics, final ImageIcon imageIcon, final Component component){
		final Graphics2D graphics2d = (Graphics2D)graphics;
		graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
		graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		graphics2d.drawImage(imageIcon.getImage(), 0, 0, component.getWidth(), component.getHeight(), component);
	}
}
