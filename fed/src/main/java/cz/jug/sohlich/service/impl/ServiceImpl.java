package cz.jug.sohlich.service.impl;

import cz.jug.sohlich.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * Created by Radomir Sohlich on 22/10/2017.
 */
public class ServiceImpl implements Service {


    @Autowired
    FileDownloader downloader;

    @Override
    public byte[] readFileFromUrl(String url) {
        return downloader.download(url);
    }
}
