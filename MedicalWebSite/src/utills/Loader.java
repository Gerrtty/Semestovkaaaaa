package utills;

import interfaces.ImgUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import some_usefull_classes.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Loader {
    private static String filePath = "/home/yuliya/Desktop/imgs/";
    private static int maxFileSize = 5000 * 1024;
    private static int maxMemSize = 5000 * 1024;

    public void load(HttpServletRequest request) {

        File file;

        String contentType = request.getContentType();

        if ((contentType.indexOf("multipart/form-data") >= 0)) {

            DiskFileItemFactory factory = new DiskFileItemFactory();

            factory.setSizeThreshold(maxMemSize);

            factory.setRepository(new File(filePath));

            ServletFileUpload upload = new ServletFileUpload(factory);

            upload.setSizeMax(maxFileSize);

            try {

                List fileItems = upload.parseRequest(request);

                Iterator i = fileItems.iterator();

                while (i.hasNext ()) {

                    FileItem fi = (FileItem) i.next();

                    if ( !fi.isFormField () ) {

                        String fileName = fi.getName();

                        file = new File(filePath + fileName) ;

                        fi.write(file) ;

                        Logger.green_write("Путь загрузки: " + filePath + fileName);

                    }

                }

            }

            catch(Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public String getFileName(String origin, ImgUtil obj) {
        int id = obj.getId();

        String folder = obj.folderName();

        System.out.println(folder);

        String extension = origin.substring(origin.indexOf("."));
        System.out.println(extension);

        return folder + id + extension;
    }
}

