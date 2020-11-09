package com.gt.training.util;

import com.gt.training.error.ErrorCode;
import com.gt.training.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by WeiHang on 2020/02/22.
 */
public class CreateTxtUtil {

    protected static Logger log = LoggerFactory.getLogger(CreateTxtUtil.class);

    public static void main(String[] args) throws BaseException {

        log.info("==="+"12345HELLO90HELLOsjsks".indexOf("HELLOP", 1));

        String srcContent = "12345HELLO90HELLOsjsks";

        List<Integer> helloList = new ArrayList<>();
        int size = srcContent.indexOf("HELLO");
        helloList.add(size);
        for(int i=0; i < srcContent.length(); i++){
            int newSize = srcContent.indexOf("HELLO",size + 1);
            log.info("newSize==="+newSize);
            if(newSize == -1){
                break;
            }
            size = newSize;
            helloList.add(size);
        }
        log.info("size==="+size);
        log.info("helloList==="+helloList);


//        String path= "/Users/weiheng.lei/";
//        String title= "roundOne10";
//        String content= "1234";
//        writeTXT( path, title, content);
    }

    /**
     * create file
     * @param path       path: /xxx/xxx/xxx/
     * @param title      title name：xxx
     * @param content    content
     * @return  File
     * @throws BaseException
     */
    public static String writeTXT(String path,String title,String content)  throws BaseException{

        log.info("create file start, path: "+path + title+".txt");
        try {
            File writeName = new File(path);//new path
            if(!writeName.exists()){
                writeName.mkdirs();
            }
            writeName = new File(path + title+".txt");// new path for txt file
            writeName.createNewFile(); // create new file
            BufferedWriter out = new BufferedWriter(new FileWriter(writeName));
            out.write(content); // write content
            out.flush();
            out.close();
            log.info("create file success");
            return path + title+".txt";
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error msg: "+ e.getMessage());
            throw new BaseException(ErrorCode.FILE_FAIL,"create file failed");
        }

    }


}