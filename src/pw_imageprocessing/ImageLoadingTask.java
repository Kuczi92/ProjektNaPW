/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw_imageprocessing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.Callable;
import javax.imageio.ImageIO;
/**
 *
 * @author Michal
 */
public class ImageLoadingTask implements Callable<BufferedImage>
{
	private File file;

	public ImageLoadingTask(File file)
	{
		this.file = file;
	}

	@Override
	public BufferedImage call() throws Exception
	{
		return ImageIO.read(file);
	}
}
