package pw_imageprocessing;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private BufferedImage image;

	public ImagePanel()
	{
		super();
		Dimension dimension = new Dimension(500, 500);
		setPreferredSize(dimension);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, this);
	}
	
	public void setImage(BufferedImage imageNew)
	{
		image = imageNew;
	}
        
        public void getImageFromFile(File File) throws IOException{
        
            image = ImageIO.read(File);
        }
        
        public void refresh(){
            this.repaint();
        }
}
