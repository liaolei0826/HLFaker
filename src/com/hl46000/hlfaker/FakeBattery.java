package com.hl46000.hlfaker;

import java.util.Random;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import android.support.v4.app.*;
import com.hl46000.hlfaker.SharedPref;
/*Lop thay doi trang thai cua Battery*/
public class FakeBattery {

	// Fake trang thai cua Pin
	public void fakePinStt(LoadPackageParam loadPkgParam) {
		try {
			XposedHelpers.findAndHookMethod("android.content.Intent", loadPkgParam.classLoader, "getIntExtra", String.class, Integer.TYPE, new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param)
						throws Throwable {
					// TODO Auto-generated method stub
					super.beforeHookedMethod(param);
					if (param.args[0] != null) {
			            if (param.args[0] == "temperature") {
			            	param.setResult(Integer.valueOf(SharedPref.getXValue("Temp")));
			            }
			            if (param.args[0] == "level") {
			            	param.setResult(Integer.valueOf(SharedPref.getXValue("Level")));
			            }
			            if (param.args[0] == "plugged") {
			            	param.setResult(Integer.valueOf(random02()));
			            }
			            if (param.args[0] == NotificationCompat.CATEGORY_STATUS) {
			            	param.setResult(Integer.valueOf(random24()));
			            }
			            if (param.args[0] == "health") {
			            	param.setResult(Integer.valueOf("2"));
			            }
			        }
				}
				
			});
		} catch (Exception e) {
			XposedBridge.log("Fake Pin ERROR: " + e.getMessage());
		}
		
	}
	private String random02() {
        String[] arrayValue = new String[]{"0", "1", "2"};
        return arrayValue[new Random().nextInt(arrayValue.length)];
    }

    private String random24() {
        String[] arrayValue = new String[]{"2", "3", "4"};
        return arrayValue[new Random().nextInt(arrayValue.length)];
    }
}

