package cn.edu.gdmec.android.mobileguard.m4appmanager.entity;


import android.graphics.drawable.Drawable;

public class AppInfo {
    public boolean isUserApp;
    public String appName;
    public String packageName;
    public String apkPath;
    public Drawable icon;
    public long appSize;
    public boolean isInRoom;
    public boolean isSelected=false;

    public String getAppLocation(boolean isInRoom){
        if (isInRoom){
            return "手机内存";
        }else {
            return "外部存储";
        }
    }
}

