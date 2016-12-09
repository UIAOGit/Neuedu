package com.neusoft.neuedu.data;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/12/9.
 */

public class ParseJson {
    public static String parseLoginJson(String json){
        String flag = null;
        try{
            JSONObject jsonObject1 = new JSONObject(json);
            JSONArray jsonArray =jsonObject1.getJSONArray("loginReturn");
            for(int i = 0;i < jsonArray.length();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                flag = jsonObject.getString("loginFlag");
                String msg = jsonObject.getString("msg");
            }
        }catch (Exception e){e.printStackTrace();}
        return flag;
    }


}
