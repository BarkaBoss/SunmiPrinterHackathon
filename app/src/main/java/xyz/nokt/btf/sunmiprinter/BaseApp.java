package xyz.nokt.btf.sunmiprinter;

import android.app.Application;

import xyz.nokt.btf.sunmiprinter.utils.SunmiPrintHelper;

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    /**
     * Connect print service through interface library
     */
    private void init(){
        SunmiPrintHelper.getInstance().initSunmiPrinterService(this);
    }
}
