package xyz.nokt.btf.sunmiprinter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.sunmi.peripheral.printer.SunmiPrinterService;

import xyz.nokt.btf.sunmiprinter.utils.BluetoothUtil;
import xyz.nokt.btf.sunmiprinter.utils.SunmiPrintHelper;

public class MainActivity extends AppCompatActivity {

    Button printButton;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        printButton = findViewById(R.id.btnPrint);
        imgView = findViewById(R.id.imgChick);
        //Drawable dr = imgView.getDrawable();
        final Bitmap bm = ((BitmapDrawable)imgView.getDrawable()).getBitmap();

        SunmiPrintHelper.getInstance().initSunmiPrinterService(this);
        printButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!BluetoothUtil.isBlueToothPrinter) {
                    SunmiPrintHelper.getInstance().printText("Graceland", 24, true, false);

                    SunmiPrintHelper.getInstance().printBitmap(bm, 90);
                    SunmiPrintHelper.getInstance().feedPaper();
                }
            }
        });
    }
}
