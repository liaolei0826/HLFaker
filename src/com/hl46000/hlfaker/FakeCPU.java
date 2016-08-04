package com.hl46000.hlfaker;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.XposedHelpers.ClassNotFoundError;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class FakeCPU {
	public FakeCPU(LoadPackageParam sharePkgParam){
		CPUFreg(sharePkgParam);
		CPUCore(sharePkgParam);
	}
	
	public void CPUFreg(LoadPackageParam loadPkgParam){
		try {
			XposedHelpers.findAndHookMethod("com.blizzard.wtcg.hearthstone.MinSpecCheck", loadPkgParam.classLoader, "getMaxCPUFreqMHz", new XC_MethodHook() {

				@Override
				protected void afterHookedMethod(MethodHookParam param)
						throws Throwable {
					// TODO Auto-generated method stub
					super.afterHookedMethod(param);
					param.setResult(Integer.valueOf(2));
				}
				
			});
		} catch (ClassNotFoundError e) {
			XposedBridge.log("Fake CPUFreg ERROR: " + e.getMessage());
		}
		
	}
	public void CPUCore(LoadPackageParam loadPkgParam){
		try {
			XposedHelpers.findAndHookMethod("com.blizzard.wtcg.hearthstone.MinSpecCheck", loadPkgParam.classLoader, "getCPUNumCores", new XC_MethodHook() {

				@Override
				protected void afterHookedMethod(MethodHookParam param)
						throws Throwable {
					// TODO Auto-generated method stub
					super.afterHookedMethod(param);
					param.setResult(Integer.valueOf(4));
				}
				
			});
		} catch (ClassNotFoundError e) {
			XposedBridge.log("Fake CPUCore ERROR: " + e.getMessage());
		}
		
	}
}
