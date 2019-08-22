package com.yihuisoft.maintenancebiz.service.screen;

import com.thoughtworks.xstream.core.util.Base64Encoder;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;

/**
 * @author dim
 * @version V4.0.0
 * @Title:
 * @ProjectName yihui-maintenance
 * @Description:
 * @date 2019/7/8
 */
public class FileServerService {

    public static final Logger LOG = LoggerFactory.getLogger(FileServerService.class);

    /**
     * 生成文件名称的逻辑
     * @param originalFileName
     * @return
     */
    public static String generateFileName(String originalFileName){

        String generatedFiledName = null;

        if (originalFileName!= null){
            generatedFiledName = FilenameUtils.getBaseName(originalFileName)+ Instant.now() + FilenameUtils.EXTENSION_SEPARATOR+FilenameUtils.getExtension(originalFileName);

        }

        return generatedFiledName;
    }

    /**
     * @Description: 将MultipartFile转为byte
     * @Version: 1.0.0
     * @Author: laijindi
     * @Date: 2019/5/24
     */
    public static byte[] transferToByte(MultipartFile pic) throws IOException {
        //转为二进制代码
        byte[] data = null;
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        try{
            inputStream = pic.getInputStream();
            outputStream= new ByteArrayOutputStream();
            int tmp;
            while ((tmp = inputStream.read()) != -1) {
                outputStream.write(tmp);
            }
            data = outputStream.toByteArray();
            return data;
        }catch (IOException e){
            LOG.error(e.getMessage());
            return new byte[]{};
        }finally {
            if (inputStream!=null){
                inputStream.close();
            }
            if (outputStream!=null){
                outputStream.close();
            }
        }
    }

    public static final Base64Encoder ENCODER = new Base64Encoder();

    /**
     * 加密文件
     * @param picture
     * @return
     */
    public static String encode(byte[] picture) {
        if(picture == null || picture.length <= 0){
            return null;
        }
        return ENCODER.encode(picture);
    }

    private FileServerService(){

    }
}
