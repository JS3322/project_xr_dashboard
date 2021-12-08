package kr.cleancode.dashboard.manager.ui.center.desktop.popup.cmd.ex;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

public class FileChooserImagePreview extends JPanel implements PropertyChangeListener{

	private static final long serialVersionUID = 5460174772583360835L;

	private int width = -1;
	private int height = -1;
    private ImageIcon imageIcon = null;
    private Image image = null;
    private static final int ACCSIZE = 155;
    private Color color = null;
    
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		final String propertyName = evt.getPropertyName();
        
        // Make sure we are responding to the right event.
        if(propertyName.equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)){
        	final File selection = (File)evt.getNewValue();
            String name;
            
            if (selection == null)
                return;
            else
                name = selection.getAbsolutePath();
            
            /*
             * Make reasonably sure we have an image format that AWT can
             * handle so we don't try to draw something silly.
             */
            if ((name != null) &&
                    name.toLowerCase().endsWith(".jpg") ||
                    name.toLowerCase().endsWith(".jpeg") ||
                    name.toLowerCase().endsWith(".gif") ||
                    name.toLowerCase().endsWith(".png")) {
                this.imageIcon = new ImageIcon(name);
                image = imageIcon.getImage();
                scaleImage();
                repaint();
            }
        }
	}

	private void scaleImage() {
        this.width = this.image.getWidth(this);
        this.height = image.getHeight(this);
        double ratio = 1.0;
       
        /* 
         * Determine how to scale the image. Since the accessory can expand
         * vertically make sure we don't go larger than 150 when scaling
         * vertically.
         */
        if (width >= height) {
            ratio = (double)(ACCSIZE - 5) / width;
            width = ACCSIZE - 5;
            height = (int)(height * ratio);
        }
        else {
            if (150 < getHeight()) {
                ratio = (double)(ACCSIZE - 5) / height;
                height = ACCSIZE-5;
                width = (int)(width * ratio);
            }
            else {
                ratio = (double)getHeight() / height;
                height = getHeight();
                width = (int)(width * ratio);
            }
        }
                
        image = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    }

	@Override
	protected void paintComponent(Graphics g) {
		final Graphics2D graphics2d = (Graphics2D)g;
		graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
		graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		
		graphics2d.setColor(color);
		graphics2d.fillRect(0, 0, ACCSIZE, getHeight());
		graphics2d.drawImage(image, getWidth() / 2 - width / 2 + 5, getHeight() / 2 - height / 2, this);
	}

	public FileChooserImagePreview(){
		setPreferredSize(new Dimension(ACCSIZE, -1));
		this.color = getBackground();
	}
}
