package com.raolulu.coolweather.util;

import android.text.TextUtils;

import com.raolulu.coolweather.db.City;
import com.raolulu.coolweather.db.County;
import com.raolulu.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by m1126_000 on 2020/9/6.
 */

public class Utility {
    /*
      解析和处理服务器返回的省级数据
     */
    public static boolean HandleProvinceResponse(String response) {
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allprovinces = new JSONArray(response);
                for(int i = 0; i < allprovinces.length(); i++) {
                    Province province = new Province();
                    JSONObject object = allprovinces.getJSONObject(i);
                    province.setProvinceName(object.getString("name"));
                    province.setProvinceCode(object.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean HandleCityResponse(String response, int provinceId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCity = new JSONArray(response);
                for(int i = 0; i < allCity.length();i++){
                    JSONObject object = allCity.getJSONObject(i);
                    City city = new City();
                    city.setCityCode(object.getInt("id"));
                    city.setCityName(object.getString("name"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean HandleCountyResponse(String response, int cityId){
        if(TextUtils.isEmpty(response)){
            try {
                JSONArray allCounty = new JSONArray(response);
                for(int i = 0; i < allCounty.length(); i++){
                    JSONObject object = allCounty.getJSONObject(i);
                    County county = new County();
                    county.setCityId(cityId);
                    county.setCountyName(object.getString("name"));
                    county.setWeatherId(object.getString("weather_id"));
                    county.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
