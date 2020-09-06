package com.raolulu.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by m1126_000 on 2020/9/6.
 */

public class County extends DataSupport{
    private int id;
    private String countyName;
    private String weatherId;
    protected int cityId;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getCountyName(){
        return countyName;
    }
    public void setCountyName(String countyName){
        this.countyName = countyName;
    }
    public String getWeatherId(){
        return weatherId;
    }
    public void setWeatherId(String weatherId){
        this.weatherId = weatherId;
    }
    public int getCityId(){
        return cityId;
    }
    public void setCityId(int cityId){
        this.cityId = cityId;
    }
}
