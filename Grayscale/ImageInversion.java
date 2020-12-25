
import edu.duke.*;
import java.io.*;

public class ImageInversion {
public ImageResource makeInversion(ImageResource inImage){
    ImageResource outImage = new ImageResource(inImage.getWidth(), 
    inImage.getHeight());
    
    for(Pixel pixel: outImage.pixels()){
        Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
        int invertedRed = 255 -inPixel.getRed();
        int invertedBlue = 255 - inPixel.getBlue();
        int invertedGreen = 255 - inPixel.getGreen();
        pixel.setRed(invertedRed);
        pixel.setBlue(invertedBlue);
        pixel.setGreen(invertedGreen);
}   
return outImage;
}
public void testMakeInversion(){
    ImageResource ir = new ImageResource();
    ImageResource inversion = makeInversion(ir);
    inversion.draw();
}
public void selectAndConvert(){
    DirectoryResource dr = new DirectoryResource();
    for(File f: dr.selectedFiles()){
        ImageResource inImage = new ImageResource(f);
        ImageResource inversion = makeInversion(inImage);
        inversion.draw();
}
}

}