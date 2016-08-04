package com.hl46000.hlfaker;


import java.util.Arrays;
import java.util.Dictionary;

import android.view.Display;
import android.accounts.Account;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XCallback;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import com.hl46000.hlfaker.SharedPref;
public class FakeOpenGL {


	public void FakeDisplay(LoadPackageParam loadPkgParam){
		try {
			XposedHelpers.findAndHookMethod("com.google.android.gles_jni.GLImpl", loadPkgParam.classLoader, "glGetString", Integer.TYPE, new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param)
						throws Throwable {
					// TODO Auto-generated method stub
					//super.beforeHookedMethod(param);
					if (param.args[0] != null) {
			            if (param.args[0].equals(Integer.valueOf(7936))) {
			            	param.setResult(SharedPref.getXValue("GLVendor"));
			            }
			            if (param.args[0].equals(Integer.valueOf(7937))) {
			            	param.setResult(SharedPref.getXValue("GLRenderer"));
			            }
			        }
				}
	        	
			});
		} catch (Exception e) {
			XposedBridge.log("Fake GLVendor|GLRenderer ERROR: " + e.getMessage());
		}
		
		try {
			XposedHelpers.findAndHookMethod("android.view.Display", loadPkgParam.classLoader, "getMetrics", DisplayMetrics.class, new XC_MethodHook(XCallback.PRIORITY_LOWEST) {

				@Override
				protected void afterHookedMethod(MethodHookParam param)
						throws Throwable {
					// TODO Auto-generated method stub
					super.afterHookedMethod(param);
					final int dpi = tryParseInt(SharedPref.getXValue("DPI"));
					DisplayMetrics metrics = (DisplayMetrics) param.args[0];
					metrics.densityDpi = dpi;
					metrics.density = dpi/160.f;
					XposedBridge.log("DPI: " + metrics.densityDpi);
				}
				
			});
		} catch (Exception e) {
			XposedBridge.log("Fake DPI ERROR: " + e.getMessage());
		}
		
		try {
			XposedHelpers.findAndHookMethod("android.view.Display", loadPkgParam.classLoader, "getRealMetrics", DisplayMetrics.class, new XC_MethodHook(XCallback.PRIORITY_LOWEST) {

				@Override
				protected void afterHookedMethod(MethodHookParam param)
						throws Throwable {
					// TODO Auto-generated method stub
					super.afterHookedMethod(param);
					final int dpi = tryParseInt(SharedPref.getXValue("DPI"));
					DisplayMetrics metrics = (DisplayMetrics) param.args[0];
					metrics.densityDpi = dpi;
					metrics.density = dpi/160.f;
					XposedBridge.log("DPI: " + metrics.densityDpi);
				}
				
			});
		} catch (Exception e) {
			XposedBridge.log("Fake Real DPI ERROR: " + e.getMessage());
		}
		
		
		try {
			XposedHelpers.findAndHookMethod("android.hardware.Sensor", loadPkgParam.classLoader, "getVendor", new XC_MethodHook() {

				@Override
				protected void afterHookedMethod(MethodHookParam param)
						throws Throwable {
					// TODO Auto-generated method stub
					super.afterHookedMethod(param);
					if (!param.getResult().toString().contains("Google") && !param.getResult().toString().contains("samsung")) {
			            return;
			        }
			        if (RandomNumber(0, 2) == 1) {
			            param.setResult("BOSCH");
			        } else {
			            param.setResult("AVAGO");
			        }
				}
	        	
			});
			
	        XposedHelpers.findAndHookMethod("android.hardware.Sensor", loadPkgParam.classLoader, "getName", new XC_MethodHook() {

				@Override
				protected void afterHookedMethod(MethodHookParam param)
						throws Throwable {
					// TODO Auto-generated method stub
					super.afterHookedMethod(param);
					if (param.getResult().toString().equals("Accelerometer Sensor")) {
			            param.setResult("Accelerometer/Temperature/Double-tap");
			        }
			        if (param.getResult().toString().equals("Gyroscope Sensor")) {
			            param.setResult("Gyroscope");
			        }
			        if (param.getResult().toString().equals("Megnetic Field Sensor")) {
			            param.setResult("Magnetometer");
			        }
			        if (param.getResult().toString().equals("Rotation Vector Sensor")) {
			            param.setResult("Rotation Vector");
			        }
			        if (param.getResult().toString().equals("Gravity Sensor")) {
			            param.setResult("Gravity");
			        }
			        if (param.getResult().toString().equals("Linear Acceleration Sensor")) {
			            param.setResult("Linear Acceleration");
			        }
			        if (param.getResult().toString().equals("Orientation Sensor")) {
			            param.setResult("Orientation");
			        }
			        if (param.getResult().toString().equals("Corrected Gyroscope Sensor")) {
			            param.setResult("APDS-9930/QPDS-T930 Proximity & Light||QTI@@Step Detector||QTI@@Gravity||QTI@@Linear Acceleration||QTI@@Rotation Vector||QTI@@Step Detector||QTI@@Step Counter||QTI@@Significant Motion Detector||QTI@@Game Rotation Vector||QTI@@GeoMagnetic Rotation Vector||QTI@@Orientation||QTI@@Tilt Detector");
			        }
					
				}
	        	
			});
		} catch (Exception e) {
			XposedBridge.log("Fake Sensor ERROR: " + e.getMessage());
		}
  
	}
	
	
	public static boolean getPackage(String lisPkg, String pkg) {
        if (TextUtils.isEmpty(lisPkg)) {
            return false;
        }
        return Arrays.asList(TextUtils.split(lisPkg.replace(" ", ""), ",")).contains(pkg);
    }
	
	
	public static int RandomNumber(int i, int i2) {
        return (int) (Math.random() * ((double) (i2 - i)));
    }
	
    private static int tryParseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 320;
        }
    }
}
