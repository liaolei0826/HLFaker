package com.hl46000.hlfaker;


import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.telephony.TelephonyManager;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.Random;

public class FakeBuilProp {
    private String ADID;
    private String abi1;
    private String abi2;
    private String androidid;
    private String board;
    private String brand;
    private String buildid;
    private String description;
    private String device;
    private String display;
    private String fingerprint;
    private String gmail;
    private String gsfid;
    private String hardware;
    private String height;
    private String host;
    private String imei;
    private String incremental;
    private String iso;
    private String latitude;
    private String longitude;
    private String macaddress;
    private String manufacturer;
    private String mcc;
    private String mnn;
    private String model;
    private String name;
    private String ppiX;
    private String ppiY;
    private String releases;
    private String sdk_int;
    private String serial;
    private String simserial;
    private String ssid;
    private String subscriberid;
    private String tags;
    private String time;
    private String type;
    private String user;
    private String useragent;
    private String width;

    public FakeBuilProp(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        this.mnn = telephonyManager.getNetworkOperatorName();
        this.mcc = telephonyManager.getNetworkOperator();
        this.iso = telephonyManager.getNetworkCountryIso();
        this.sdk_int = "19";
        this.releases = VERSION.RELEASE;
        this.tags = "release-keys";
        this.type = "user";
        this.display = Build.DISPLAY;
        this.incremental = VERSION.INCREMENTAL;
        this.buildid = Build.ID;
        this.user = "dpi";
        this.host = Build.HOST;
        this.model = Build.MODEL;
        this.brand = Build.BRAND;
        this.name = Build.PRODUCT;
        this.device = Build.DEVICE;
        this.board = Build.BOARD;
        this.manufacturer = Build.MANUFACTURER;
        this.abi1 = Build.CPU_ABI;
        this.abi2 = Build.CPU_ABI2;
        this.simserial = telephonyManager.getSimSerialNumber();
        this.fingerprint = Build.FINGERPRINT;
        this.description = returnDescription();
    }

    public final String returnDescription() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.build.description"});
        } catch (Exception e) {
            return "";
        }
    }

    public String getMNN() {
        if (this.mnn == null) {
            return "T-Mobile";
        }
        return this.mnn;
    }

    public String getMCC() {
        if (this.mcc == null) {
            return "31026";
        }
        return this.mcc;
    }

    public String getISO() {
        if (this.iso == null) {
            return "US";
        }
        return this.iso;
    }

    public String getSDK_INT() {
        return this.sdk_int;
    }

    public String getGSFID() {
        return this.gsfid;
    }

    public String getUseragent() {
        return this.useragent;
    }

    public int getIp() {
        int i = 1677895872;
        try {
            i = Util.inetAddressToInt(InetAddress.getByName("192.168." + Util.randInt(0, 5) + "." + Util.randInt(1, Callback.DEFAULT_SWIPE_ANIMATION_DURATION)));
        } catch (IllegalArgumentException e) {
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
        }
        return i;
    }

    public String getRelease() {
        return this.releases;
    }

    public String getTags() {
        return this.tags;
    }

    public String getType() {
        return this.type;
    }

    public String getincremental() {
        if (this.incremental == null) {
            return "9bt3zw";
        }
        return this.incremental;
    }

    public String gethost() {
        if (this.host == null) {
            return "BuildHost";
        }
        return this.host;
    }

    public String getdisplay() {
        if (this.display == null) {
            return "6.1.1.B.1.100";
        }
        return this.display;
    }

    public String gettime() {
        if (this.time == null) {
            return "1357642833000";
        }
        return this.time;
    }

    public String getID() {
        return this.buildid;
    }

    public String getUSER() {
        return this.user;
    }

    public String getHardware() {
        if (this.hardware == null) {
            return "st-sony";
        }
        return this.hardware;
    }

    public String getSSID() {
        if (this.ssid == null) {
            return "SonyCenter";
        }
        return this.ssid;
    }

    public String getAbi1() {
        return this.abi1;
    }

    public String getAbi2() {
        return this.abi2;
    }

    public String getGmail() {
        return this.gmail;
    }

    public String getAdid() {
        return this.ADID;
    }

    public String getModel() {
        return this.model;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getName() {
        return this.name;
    }

    public String getDevice() {
        return this.device;
    }

    public String getBoard() {
        return this.board;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFingerprint() {
        return this.fingerprint;
    }

    public String getIMEI() {
        return this.imei;
    }

    public String getSERIAL() {
        return this.serial;
    }

    public String getAndroidID() {
        return this.androidid;
    }

    public String getMAC() {
        return this.macaddress;
    }

    public String getSUB() {
        return this.subscriberid;
    }

    public String getSIM() {
        return this.simserial;
    }

    public String getHeight() {
        return this.height;
    }

    public String getWidth() {
        return this.width;
    }

    public String getppiX() {
        return this.ppiX;
    }

    public String getppiY() {
        return this.ppiY;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String b) {
        this.brand = b;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setDevice(String d) {
        this.device = d;
    }

    public void setBoard(String b) {
        this.board = b;
    }

    public void setManufacturer(String m) {
        this.manufacturer = m;
    }

    public void setDescription(String des) {
        this.description = des;
    }

    public void setFingerprint(String f) {
        this.fingerprint = f;
    }

    public void setIMEI(String imei) {
        this.imei = imei;
    }

    public void setSERIAL(String s) {
        this.serial = s;
    }

    public void setAndroidID(String aid) {
        this.androidid = aid;
    }

    public void setMAC(String mac) {
        this.macaddress = mac;
    }

    public void setSUB(String sub) {
        this.subscriberid = sub;
    }

    public void setSIM(String sim) {
        this.simserial = sim;
    }

    public void setHeight(String h) {
        this.height = h;
    }

    public void setWidth(String w) {
        this.width = w;
    }

    public void setppiX(String px) {
        this.ppiX = px;
    }

    public void setppiY(String py) {
        this.ppiY = py;
    }

    public void setGgmail(String email) {
        this.gmail = email;
    }

    public void setAdid(String adid) {
        this.ADID = adid;
    }

    public String phoneNumber() {
        Random rand = new Random();
        int num1 = (((rand.nextInt(7) + 1) * 100) + (rand.nextInt(8) * 10)) + rand.nextInt(8);
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);
        DecimalFormat df3 = new DecimalFormat("000");
        return df3.format((long) num1) + df3.format((long) num2) + new DecimalFormat("0000").format((long) num3);
    }

    public String getLAT() {
        if (this.latitude == null) {
            return "37.890678829757636";
        }
        return this.latitude;
    }

    public String getLONG() {
        if (this.longitude == null) {
            return "-120.76866568923656";
        }
        return this.longitude;
    }

    public static boolean isXposedEnabled() {
        return false;
    }

    public String toString() {
        if (this.imei.equals("") && !this.serial.equals("")) {
            return "\nSERIAL=" + getSERIAL() + "\nMAC=" + getMAC() + "\nSIM=" + getSIM() + "\nSUB=" + getSUB() + "\nBOARD=" + getBoard() + "\nBRAND=" + getBrand() + "\nDEVICE=" + getDevice() + "\nFINGERPRINT=" + getFingerprint() + "\nMANUFACTURER=" + getManufacturer() + "\nMODEL=" + getModel() + "\nNAME=" + getName() + "\nHEIGHT=" + getHeight() + "\nWIDTH=" + getWidth() + "\nPPIX=" + getppiX() + "\nPPIY=" + getppiY() + "\nGMAIL=" + getGmail() + "\nHARDWARE=" + getHardware() + "\nSSID=" + getSSID() + "\nADID=" + getAdid() + "\nID=" + getID() + "\nUSER=" + getUSER() + "\nHOST=" + gethost() + "\nDISPLAY=" + getdisplay() + "\nTIME=" + gettime() + "\nINCREMENTAL=" + getincremental() + "\nRELEASE=" + getRelease();
        }
        if (!this.serial.equals("") || this.imei.equals("")) {
            return "IMEI=" + getIMEI() + "\nSERIAL=" + getSERIAL() + "\nMAC=" + getMAC() + "\nSIM=" + getSIM() + "\nSUB=" + getSUB() + "\nBOARD=" + getBoard() + "\nBRAND=" + getBrand() + "\nDEVICE=" + getDevice() + "\nFINGERPRINT=" + getFingerprint() + "\nMANUFACTURER=" + getManufacturer() + "\nMODEL=" + getModel() + "\nNAME=" + getName() + "\nHEIGHT=" + getHeight() + "\nWIDTH=" + getWidth() + "\nPPIX=" + getppiX() + "\nPPIY=" + getppiY() + "\nGMAIL=" + getGmail() + "\nHARDWARE=" + getHardware() + "\nSSID=" + getSSID() + "\nADID=" + getAdid() + "\nID=" + getID() + "\nUSER=" + getUSER() + "\nHOST=" + gethost() + "\nDISPLAY=" + getdisplay() + "\nTIME=" + gettime() + "\nINCREMENTAL=" + getincremental() + "\nRELEASE=" + getRelease() + "\nTYPE=" + getType() + "\nTAGS=" + getTags() + "\nSDK_INT=" + getSDK_INT() + "\nGSFID=" + getGSFID() + "\nISO=" + getISO() + "\nMNN=" + getMNN() + "\nMCC=" + getMCC() + "\nUSERAGENT=" + getUseragent() + "\nPHONE=" + phoneNumber() + "\nLAT=" + getLAT() + "\nLONG=" + getLONG() + "\nIP=" + getIp();
        }
        return "IMEI=" + getIMEI() + "\nMAC=" + getMAC() + "\nSIM=" + getSIM() + "\nSUB=" + getSUB() + "\nBOARD=" + getBoard() + "\nBRAND=" + getBrand() + "\nDEVICE=" + getDevice() + "\nFINGERPRINT=" + getFingerprint() + "\nMANUFACTURER=" + getManufacturer() + "\nMODEL=" + getModel() + "\nNAME=" + getName() + "\nHEIGHT=" + getHeight() + "\nWIDTH=" + getWidth() + "\nPPIX=" + getppiX() + "\nPPIY=" + getppiY() + "\nGMAIL=" + getGmail() + "\nHARDWARE=" + getHardware() + "\nSSID=" + getSSID() + "\nADID=" + getAdid() + "\nID=" + getID() + "\nUSER=" + getUSER() + "\nHOST=" + gethost() + "\nDISPLAY=" + getdisplay() + "\nTIME=" + gettime() + "\nINCREMENTAL=" + getincremental() + "\nRELEASE=" + getRelease();
    }
}
