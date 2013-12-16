import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class ImageCompressor {
    /*public void compress() throws IOException {
        File infile = new File("Y:\\img\\star.jpg");
        File outfile = new File("Y:\\img\\star_compressed.jpg");

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
                infile));
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(outfile));

        SeekableStream s = SeekableStream.wrapInputStream(bis, true);

        RenderedOp image = JAI.create("stream", s);
        ((OpImage) image.getRendering()).setTileCache(null);

        RenderingHints qualityHints = new RenderingHints(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        RenderedOp resizedImage = JAI.create("SubsampleAverage", image, 0.9,
                0.9, qualityHints);

        JAI.create("encode", resizedImage, bos, "JPEG", null);

    }*/
	public File compress(String src){
		System.out.println(getClass().getResource(src).getPath());
		File compressedImageFile = new File(getClass().getResource(src).getPath());

		try {
			InputStream is = new FileInputStream(src);
			OutputStream os = new FileOutputStream(compressedImageFile);
			float quality = 0.7f; // Change this as needed
			BufferedImage image = ImageIO.read(is);
			// get all image writers for JPG format
			Iterator<ImageWriter> writers = ImageIO
					.getImageWritersByFormatName("jpg");
			if (!writers.hasNext())
				throw new IllegalStateException("No writers found");
			ImageWriter writer = (ImageWriter) writers.next();
			ImageOutputStream ios = ImageIO.createImageOutputStream(os);
			writer.setOutput(ios);
			// set compression quality
			ImageWriteParam param = writer.getDefaultWriteParam();
			param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
			param.setCompressionQuality(quality);
			writer.write(null, new IIOImage(image, null, null), param);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Could not compress the image file");
		}
		return compressedImageFile;
		    // clean resources e.g. close streams
	}

  
    public static void main(String[] args) throws IOException {

    	
        new ImageCompressor().compress("android.jpg");
    }
}