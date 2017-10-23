package cz.jug.sohlich.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

/**
 * Created by Radomir Sohlich on 22/10/2017.
 */
@Component
public class FileDownloader {

    @Autowired
    Base64DataDecoder decoder;

    public byte[] download(String url){
        return new byte[0];
    }

}
