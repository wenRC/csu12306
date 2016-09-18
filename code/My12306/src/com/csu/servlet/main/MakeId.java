package com.csu.servlet.main;

/**
 * Created by 温 睿诚 on 2016/9/18/0018.
 */
public class MakeId {
    public static int getUserId(String email){
        int result=0;
        for(char temp:email.toCharArray()){
            result+=result*7+temp;
        }

        return result;
    }
}
