package utills;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@MultipartConfig(maxFileSize = 16177215)

public class ImgUtil {

    public InputStream getInputStream(HttpServletRequest request) {

        InputStream inputStream = null;

        // obtains the upload file part in this multipart request
        Part filePart = null;

        try {
            filePart = request.getPart("ava");

            if(filePart != null) {
                inputStream = filePart.getInputStream();
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());
            }

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }

        return inputStream;
    }
}
