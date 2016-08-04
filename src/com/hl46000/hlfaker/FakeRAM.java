package com.hl46000.hlfaker;

import java.util.Random;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;
import de.robv.android.xposed.XposedHelpers.ClassNotFoundError;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class FakeRAM {
	public FakeRAM(LoadPackageParam sharePkgParam){
		totalRam(sharePkgParam);
	}
	
	public void totalRam(LoadPackageParam loadPkgParam){
		try {
			XposedHelpers.findAndHookMethod("com.blizzard.wtcg.hearthstone.MinSpecCheck", loadPkgParam.classLoader, "getTotalRAMMB", new XC_MethodHook() {

				@Override
				protected void afterHookedMethod(MethodHookParam param)
						throws Throwable {
					// TODO Auto-generated method stub
					super.afterHookedMethod(param);
					param.setResult(randomRam());
				}
				
			});
		} catch (ClassNotFoundError e) {
			XposedBridge.log("Fake totalRam ERROR: " + e.getMessage());
		}
		
	}
	private int randomRam() {
        int[] Array = new int[]{AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, ItemAnimator.FLAG_MOVED, 3027, ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT};
        return Array[new Random().nextInt(Array.length)];
    }
}
