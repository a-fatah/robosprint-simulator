import java.io.*;
import java.util.Iterator;
import javax.imageio.*;
import javax.imageio.stream.*;
import java.awt.image.*;

public class ImageQualityReducer {
	public static void main(String[] args) throws Exception {

		File input = new File(args[0]);
		BufferedImage bufferedImage = ImageIO.read(input);

		ImageWriter writer = (ImageWriter)ImageIO.getImageWritersByFormatName("jpeg").next();
		ImageWriteParam iwp = writer.getDefaultWriteParam();
		iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		iwp.setCompressionQuality(0.7f);

		File file = new File("output.jpg");
		FileImageOutputStream output = new FileImageOutputStream(file);
		writer.setOutput(output);
		IIOImage image = new IIOImage(bufferedImage, null, null);
		writer.write(null, image, iwp);
		writer.dispose();
		System.out.println("DONE");
	}
}
