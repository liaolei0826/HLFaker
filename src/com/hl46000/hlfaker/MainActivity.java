package com.hl46000.hlfaker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.hl46000.hlfaker.FakeHardwareInfo;

@SuppressLint("ShowToast")
public class MainActivity extends Activity {
	private Context myContext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myContext = this;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@SuppressLint("ShowToast")
	private void createData(){
		
		try {
			new CreateBuilProp(myContext, new FakeBuilProp(myContext)).newBuild();
			FakeHardwareInfo.CreatDataCpu(myContext);
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(getApplicationContext(), "Create Data ERROR!", 1).show();
		}
		
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		//createData();
		try {
			createData();
    		startModule();
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Create SharePref ERROR!", 1).show();
		}
        	
	}
	
	@SuppressLint("ShowToast")
	public void startModule() {
		
        //MySharedPreferences sp = new MySharedPreferences(getApplicationContext());
        SharedPref mySP = new SharedPref(getApplicationContext());
        mySP.setSharedPref("AndroidVer", "4.4.2");
        mySP.setSharedPref("API", "19");
        mySP.setSharedPref("PhoneNumber", "84962439943");
        mySP.setSharedPref("WifiName", "MyWifi");
        mySP.setSharedPref("WifiMAC", "6C:C4:08:BB:B1:28");
        mySP.setSharedPref("BSSID", "6C:C4:08:BB:B1:28");
        mySP.setSharedPref("AndroidID", "6c0bb208c33b8c43");
        mySP.setSharedPref("GoogleAdsID", "f741b85f-fbab-4eb3-8e44-358e07c3bc50");
        mySP.setSharedPref("AndroidSerial", "6c0bb208c33b");
        mySP.setSharedPref("IMEI", "506066104722640");
        mySP.setSharedPref("SimSerial", "36066104722647215170");
        mySP.setSharedPref("Manufacture", "samsung");
        mySP.setSharedPref("MODEL", "GT-I9505");
        mySP.setSharedPref("BRAND", "samsung");
        mySP.setSharedPref("NAME", "jfltexx");
        mySP.setSharedPref("DEVICE", "jflte");
        mySP.setSharedPref("DISPLAY", "JSS15J.I9505XXUEML1");
        mySP.setSharedPref("ID", "JSS15J");
        mySP.setSharedPref("BOARD", "MSM8960");
        mySP.setSharedPref("ABI", "armeabi-v7a");
        mySP.setSharedPref("ABI2", "armeabi");
        mySP.setSharedPref("BOOTLOADER", "I9505XXUEML1");
        mySP.setSharedPref("DESCRIPTION", "jfltexx-user 4.3 JSS15J I9505XXUEML1 release-keys");
        mySP.setSharedPref("FINGERPRINT", "samsung/jfltexx/jflte:4.3/JSS15J/I9505XXUEML1:user/release-keys");
        mySP.setSharedPref("UserAgent", "Mozilla/5.0 (Linux; Android 4.4.2; GT-I9505 Build/16.0.A.0.36) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/51.0.2704 Mobile Safari/537.36");
        mySP.setSharedPref("Carrier", "Mobifone");
        mySP.setSharedPref("CarrierCode", "45201");
        mySP.setSharedPref("CountryCode", "VN");
        mySP.setSharedPref("OSName", "Linux");
        mySP.setSharedPref("OSArch", "armv7l");
        mySP.setSharedPref("OSVersion", "3.4.0-gd59db4e");
        mySP.setSharedPref("BaseBand", "eng.administrator.1373289311");
        mySP.setSharedPref("FakeEmailPackge", "com.alibaba.aliexpresshd");
        mySP.setSharedPref("HideRootPackge", "com.alibaba.aliexpresshd");
        mySP.setSharedPref("Email", "hl.46000@gmail.com");
        mySP.setSharedPref("Lat", "27.82516672");
        mySP.setSharedPref("Long", "125.06788613");
        mySP.setSharedPref("Alt", "125.06");
        mySP.setSharedPref("Speed", "3.7");
        mySP.setSharedPref("DPI", "320");
        mySP.setSharedPref("CPUId", "Qualcomm");
        mySP.setSharedPref("UId", "Qualcomm");
        mySP.setSharedPref("PId", "Qualcomm");
        mySP.setSharedPref("GLRenderer", "Adreno (TM) 330");
        mySP.setSharedPref("GLVendor", "Qualcomm");
        mySP.setSharedPref("Temp", "350");
        mySP.setSharedPref("Level", "35");
        mySP.setSharedPref("TimeZone", "Africa/Abidjan");
        Toast.makeText(getApplicationContext(), "Module Started!", 1).show();
        //finish();
    }
	
}
