package kr.cleancode.dashboard.manager.ui.util;

import javax.swing.*;
import java.awt.*;

public class XrManagerImageUtil {

	public static final ImageIcon imageSizeChange(final Image image){
		return new ImageIcon(image.getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	}
	
	public static final ImageIcon imageSizeChange(final Image image, final int width, final int height){
		return new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}
	
}
