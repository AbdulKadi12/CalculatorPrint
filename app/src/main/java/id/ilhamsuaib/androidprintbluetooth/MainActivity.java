package id.ilhamsuaib.androidprintbluetooth;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zj.btsdk.BluetoothService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

@SuppressLint("SetTextI18n")
public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks, BluetoothHandler.HandlerInterface {

    @BindView(R.id.et_text)
    EditText etText;
    @BindView(R.id.size)
    EditText size;
    @BindView(R.id.size2)
    EditText size2;
    @BindView(R.id.size3)
    EditText size3;
    @BindView(R.id.et_text2)
    EditText etText2;
    @BindView(R.id.et_text3)
    EditText etText3;
    @BindView(R.id.et_text4)
    EditText etText4;
    @BindView(R.id.jumlah)
    EditText jumlah;
    @BindView(R.id.jumlah2)
    EditText jumlah2;
    @BindView(R.id.jumlah3)
    EditText jumlah3;
    @BindView(R.id.add)
    EditText add;
//    @BindView(R.id.total)
//    EditText total;
   @BindView(R.id.tv_status)
    TextView tvStatus;

    private final String TAG = MainActivity.class.getSimpleName();
    public static final int RC_BLUETOOTH = 0;
    public static final int RC_CONNECT_DEVICE = 1;
    public static final int RC_ENABLE_BLUETOOTH = 2;

    private BluetoothService mService = null;
    private boolean isPrinterReady = false;
    public String name= "KEBABMAN'S";
    public String ig= "KEBABMANMU";
    public int totall=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupBluetooth();
    }

    @AfterPermissionGranted(RC_BLUETOOTH)
    private void setupBluetooth() {
        String[] params = {Manifest.permission.BLUETOOTH, Manifest.permission.BLUETOOTH_ADMIN};
        if (!EasyPermissions.hasPermissions(this, params)) {
            EasyPermissions.requestPermissions(this, "You need bluetooth permission",
                    RC_BLUETOOTH, params);
            return;
        }
        mService = new BluetoothService(this, new BluetoothHandler(this));
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        // TODO: 10/11/17 do something
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        // TODO: 10/11/17 do something
    }

    @Override
    public void onDeviceConnected() {
        isPrinterReady = true;
        tvStatus.setText("Terhubung dengan perangkat");
    }

    @Override
    public void onDeviceConnecting() {
        tvStatus.setText("Sedang menghubungkan...");
    }

    @Override
    public void onDeviceConnectionLost() {
        isPrinterReady = false;
        tvStatus.setText("Koneksi perangkat terputus");
    }

    @Override
    public void onDeviceUnableToConnect() {
        tvStatus.setText("Tidak dapat terhubung ke perangkat");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case RC_ENABLE_BLUETOOTH:
                if (resultCode == RESULT_OK) {
                    Log.i(TAG, "onActivityResult: bluetooth aktif");
                } else
                    Log.i(TAG, "onActivityResult: bluetooth harus aktif untuk menggunakan fitur ini");
                break;
            case RC_CONNECT_DEVICE:
                if (resultCode == RESULT_OK) {
                    String address = data.getExtras().getString(DeviceActivity.EXTRA_DEVICE_ADDRESS);
                    BluetoothDevice mDevice = mService.getDevByMac(address);
                    mService.connect(mDevice);
                }
                break;
        }
    }



    @OnClick(R.id.btn_print_text)
    public void printText(@Nullable View view) {
        if (!mService.isAvailable()) {
            Log.i(TAG, "printText: perangkat tidak support bluetooth");
            return;
        }

        if (isPrinterReady) {
            totall=0;
//            if (etText.getText().toString().isEmpty()) {
//                Toast.makeText(this, "Cant print null text", Toast.LENGTH_SHORT).show();
//                return;
//            }
            mService.write(PrinterCommands.ESC_ALIGN_CENTER);
            mService.sendMessage(name, "");
            mService.sendMessage("IG : "+ig, "");
            mService.write(PrinterCommands.ESC_ENTER);

            if (jumlah.getText().length() != 0) {
                mService.write(PrinterCommands.ESC_ALIGN_LEFT);
                mService.sendMessage(jumlah.getText().toString()+" "+size.getText().toString()+"   KEBABMAN", "");
                mService.sendMessage(etText.getText().toString(), "");
                totall= totall+ Integer.parseInt(etText.getText().toString());
                mService.write(PrinterCommands.ESC_ENTER);
            }

            if (jumlah2.getText().length() != 0) {
                mService.write(PrinterCommands.ESC_ALIGN_LEFT);
                mService.sendMessage(jumlah2.getText().toString()+" "+size2.getText().toString()+"   BURGERMAN", "");
                mService.sendMessage(etText2.getText().toString(), "");
                totall= totall+ Integer.parseInt(etText2.getText().toString());
                mService.write(PrinterCommands.ESC_ENTER);
            }

            if (jumlah3.getText().length() != 0) {
                mService.write(PrinterCommands.ESC_ALIGN_LEFT);
                mService.sendMessage(jumlah3.getText().toString()+" "+size3.getText().toString()+"   KEBAB REGULAR", "");
                mService.sendMessage(etText3.getText().toString(), "");
                totall= totall+ Integer.parseInt(etText3.getText().toString());
                mService.write(PrinterCommands.ESC_ENTER);
            }

            if (add.getText().length() != 0) {
                mService.write(PrinterCommands.ESC_ALIGN_LEFT);
                mService.sendMessage(add.getText().toString(), "");
                mService.sendMessage(etText4.getText().toString(), "");
                totall= totall+ Integer.parseInt(etText4.getText().toString());
                mService.write(PrinterCommands.ESC_ENTER);
            }
            mService.write(PrinterCommands.ESC_ALIGN_CENTER);
            mService.sendMessage("-------", "");
            mService.write(PrinterCommands.ESC_ALIGN_RIGHT);
            mService.sendMessage("Total : "+totall, "");
            mService.write(PrinterCommands.ESC_ENTER);
        }

        else {
            if (mService.isBTopen())
                startActivityForResult(new Intent(this, DeviceActivity.class), RC_CONNECT_DEVICE);
            else
                requestBluetooth();
        }
   }

//    @OnClick(R.id.btn_print_image)
//    public void printImage(View view) {
//        if (isPrinterReady) {
//            PrintPic pg = new PrintPic();
//            pg.initCanvas(400);
//            pg.initPaint();
//            pg.drawImage(0, 0, Environment.getExternalStorageDirectory().getAbsolutePath() + "/Londree/struk_londree.png");
//            byte[] sendData = pg.printDraw();
//            mService.write(PrinterCommands.ESC_ALIGN_CENTER);
//            mService.write(sendData);
//        }
//    }

    private void requestBluetooth() {
        if (mService != null) {
            if (!mService.isBTopen()) {
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(intent, RC_ENABLE_BLUETOOTH);
            }
        }
    }
}
