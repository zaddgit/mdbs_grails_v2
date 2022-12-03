package com.mbds.grails

import grails.util.Holders
import org.springframework.web.multipart.MultipartFile

class FileUtil {
    public static String getRootPath(){
        return Holders.servletContext?.getRealPath("")
    }


    public static File makeDirectory(String path){
        File file = new File(path)
        if (!file.exists()){
            file.mkdirs()
        }
        return file
    }


    public static String uploadAnnonceImage(Integer contactId, MultipartFile multipartFile){
        if (contactId && multipartFile){
            String annonceImagePath = "${getRootPath()}annonce-image/"
            makeDirectory(annonceImagePath)
            multipartFile.transferTo(new File(annonceImagePath, contactId + "-" + multipartFile.originalFilename))
            return multipartFile.originalFilename
        }
        return ""
    }
}
