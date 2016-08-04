package com.hl46000.hlfaker;

import java.util.Arrays;
import com.hl46000.hlfaker.SharedPref;
import android.accounts.Account;
import android.text.TextUtils;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class FakeEmail {

	public void fakeGmail(final LoadPackageParam loadPkgParam){
		try {
			XposedHelpers.findAndHookMethod("android.accounts.AccountManager", loadPkgParam.classLoader, "getAccounts", new XC_MethodHook() {

				@Override
				protected void afterHookedMethod(MethodHookParam param)
						throws Throwable {
					// TODO Auto-generated method stub
					super.afterHookedMethod(param);
					if (getPackage(SharedPref.getXValue("FakeEmailPackge"), loadPkgParam.packageName)) {
						param.setResult(new Account[]{new Account(SharedPref.getXValue("Email"), "com.google")});
			        }
				}
				
			});
			XposedHelpers.findAndHookMethod("android.accounts.AccountManager", loadPkgParam.classLoader, "getAccountsByType", String.class, new XC_MethodHook() {

				@Override
				protected void afterHookedMethod(MethodHookParam param)
						throws Throwable {
					// TODO Auto-generated method stub
					super.afterHookedMethod(param);
					if (getPackage(SharedPref.getXValue("FakeEmailPackge"), loadPkgParam.packageName)) {
						param.setResult(new Account[]{new Account(SharedPref.getXValue("Email"), "com.google")});
			        }
				}
				
			});
		} catch (Exception e) {
			XposedBridge.log("Fake Email ERROR: " + e.getMessage());
		}
		
	}
	
	public static boolean getPackage(String lisPkg, String pkg) {
        if (TextUtils.isEmpty(lisPkg)) {
            return false;
        }
        return Arrays.asList(TextUtils.split(lisPkg.replace(" ", ""), ",")).contains(pkg);
    }
	
}
