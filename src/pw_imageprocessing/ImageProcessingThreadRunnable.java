/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw_imageprocessing;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Quchi
 */
public class ImageProcessingThreadRunnable extends Thread {
	Semaphore progressLock;
	private BufferedImage image;
	private int startWidth, startHeight, width, height;
	private MainFrameRunnable mainFrame;
	
        
        
        
 public ImageProcessingThreadRunnable(BufferedImage image, MainFrameRunnable mainFrame, Semaphore progressLock, int startWidth, int startHeight, int width, int height)
	{
		this.image = image;
		this.startWidth = startWidth;
		this.startHeight = startHeight;
		this.width = width;
		this.height = height;
		this.mainFrame = mainFrame;
		this.progressLock = progressLock;
	}


	public void run()
	{
		desaturateImage();
	}
	
	public void desaturateImage()
	{
		for (int i = startWidth; i < startWidth + width; i++)
		{
			for (int j = startHeight; j < startHeight + height; j++)
			{
				Color c = new Color(image.getRGB(i, j));
				int red = (int) (c.getRed() * 0.299);
				int green = (int) (c.getGreen() * 0.587);
				int blue = (int) (c.getBlue() * 0.114);
				int color = red + green + blue;
				Color newColor = new Color(color, color, color);
				image.setRGB(i, j, newColor.getRGB());
			}
			try
			{
				progressLock.acquire();
				mainFrame.updateProgress(1);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			finally
			{
				progressLock.release();
			}
		}
	}
}
