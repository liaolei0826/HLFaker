package com.hl46000.hlfaker;

import android.content.Context;
import android.content.SharedPreferences;
import com.hl46000.hlfaker.Common;
import de.robv.android.xposed.XSharedPreferences;

public class SharedPref {
	private Context shareContext;
    private SharedPreferences mySharedPref;
    private static XSharedPreferences myXsharedPref;
    
    public SharedPref(Context appContext) {
    	shareContext = appContext;
    	mySharedPref = shareContext.getSharedPreferences(Common.PREFS_FILE, 1);
    }
    
    public void setSharedPref(String key, String value) {
    	try {
    		mySharedPref.edit().putString(key, value).commit();
        } catch (Exception e) {
        	System.out.println("setSharedPref ERROR: " + e.getMessage());
        }
    }
    
    public String getValue(String key) {
    	String value = "";
    	try {
    		value = mySharedPref.getString(key, null);
        } catch (Exception e) {
        	System.out.println("getSharedPref ERROR: " + e.getMessage());
        }
    	return value;
    }
    
    public static XSharedPreferences getMyXSharedPref() {
        if (myXsharedPref != null) {
        	myXsharedPref.reload();
            return myXsharedPref;
        }
        myXsharedPref = new XSharedPreferences(Common.PACKAGE_NAME, Common.PREFS_FILE);
        return myXsharedPref;
    }
    
    public static String getXValue(String key) {
    	String value = "";
    	try {
    		value = getMyXSharedPref().getString(key, null);
    	} catch (Exception e) {
        	System.out.println("getSharedPref ERROR: " + e.getMessage());
        }
    	return value;
    }
    
}
