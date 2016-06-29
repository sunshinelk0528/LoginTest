package com.test.login.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
}
