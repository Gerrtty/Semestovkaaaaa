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
    private static String filePath = "/home/yuliya/Desktop/Smestrovka/MedicalWebSite/web/images";
    private static int maxFileSize = 5000 * 1024;
    private static int maxMemSize = 5000 * 1024;
    private ImgUtil obj;

    public Loader(ImgUtil obj) {
        this.obj = obj;
    }

    public String load(HttpServletRequest request) {
        String file_name = "";
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

                        String folder = getFolder(obj);
                        file_name = fileName(fileName, obj);

                        String realPath = filePath + folder + file_name;

                        file = new File(realPath) ;

                        System.out.println(file_name);

                        fi.write(file);
                        Logger.green_write("Путь загрузки: " + realPath);

                    }

                }

            }

            catch(Exception ex) {
                ex.printStackTrace();
            }
        }

        return file_name;

    }

    public String getFolder(ImgUtil obj) {
        return obj.folderName();
    }

    public String fileName(String origin, ImgUtil obj) {
        return obj.getId() + origin.substring(origin.indexOf("."));
    }
}

