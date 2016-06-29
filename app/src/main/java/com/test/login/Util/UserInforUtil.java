package com.test.login.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Huyanglin on 2016/6/27.
 */
public class UserInforUtil {

    public static boolean saveUserInfo(String username, String userpass) {

        try {

            String userinfo=username+"##"+userpass;
            String path="/data/data/com.test.login/";
            File file=new File(path,"userinfo.txt");
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write(userinfo.getBytes());
            fileOutputStream.close();
            return true;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static Map<String,String> getUserInfo(){
        BufferedReader bufferedReader = null;
        FileInputStream fileInputStream = null;

        try {

            String path="/data/data/com.test.login/";
            File file=new File(path,"userinfo.txt");
            fileInputStream = new FileInputStream(file);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String reader= bufferedReader.readLine();
            String[] split =reader.split("##");
            HashMap<String,String> hashMap=new HashMap<String,String>();
            hashMap.put("username",split[0]);
            hashMap.put("password",split[1]);
            return hashMap;


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        return null;

    }
}
