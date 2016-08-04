package com.hl46000.hlfaker;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import com.hl46000.hlfaker.FakeBattery;
import com.hl46000.hlfaker.FakeBuildInfo;
import com.hl46000.hlfaker.FakeEmail;
import com.hl46000.hlfaker.FakeHardwareInfo;
import com.hl46000.hlfaker.FakeOpenGL;
import com.hl46000.hlfaker.FakeRAM;
import com.hl46000.hlfaker.RootCloak;
import com.hl46000.hlfaker.FakeCPU;

public class MainHook implements IXposedHookLoadPackage {


	@Override
	public void handleLoadPackage(LoadPackageParam sharePkgParam) throws Throwable {
		// TODO Auto-generated method stub
		new FakeBattery().fakePinStt(sharePkgParam);
		new FakeHardwareInfo(sharePkgParam);
		new FakeBuildInfo(sharePkgParam);
		new FakeOpenGL().FakeDisplay(sharePkgParam);
		new FakeEmail().fakeGmail(sharePkgParam);
		new RootCloak().handleLoadPackage(sharePkgParam);
		new FakeCPU(sharePkgParam);	
		new FakeRAM(sharePkgParam);
		
	}


}
