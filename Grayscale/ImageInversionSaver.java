
import edu.duke.*;
import java.io.File;

public class ImageInversionSaver {
public class ImageSaver {
    public void doSave(){
        DirectoryResource dr= new DirectoryResource();
        for(File f: dr.selectedFiles()){
            ImageResource image = new ImageResource(f);
            String fname =image.getFileName();
            String newName = "inverted-"+ fname;
            image.setFileName(newName);
            image.draw();
            image.save();
            
        
        }
    }
}
}
