package cz.jug.sohlich.service.impl;

import org.springframework.stereotype.Component;

import java.util.Base64;

/**
 * Created by Radomir Sohlich on 22/10/2017.
 */
@Component
public class Base64DataDecoder {

    public byte[] transformData(byte[] data){
        return Base64.getDecoder().decode(data);
    }

}
