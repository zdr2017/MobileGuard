package cn.edu.gdmec.android.mobileguard.m2theftguard;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import cn.edu.gdmec.android.mobileguard.R;

/**
 * Created by asus on 2017/10/23.
 */

public class Setup2Activity extends BaseSetupActivity implements View.OnClickListener{
    private TelephonyManager mTelephonyManager;
    private Button mBindSIMBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_2);
        ((RadioButton) findViewById(R.id.rb_first)).setChecked(true);

        mTelephonyManager = (TelephonyManager) getSystemService(TELECOM_SERVICE);
        mBindSIMBtn = (Button) findViewById(R.id.btn_bind_sim);
        mBindSIMBtn.setOnClickListener(this);
        if(isBind()){
            mBindSIMBtn.setEnabled(false);
        }else{
            mBindSIMBtn.setEnabled(true);
        }
    }

    private boolean isBind(){
        String simString = sp.getString("sim",null);
        if(TextUtils.isEmpty(simString)){
            return false;
        }
        return true;
    }
    @Override
    public void showNext() {
        if (!isBind()) {
           Toast.makeText(this,"您还没有绑定SIM卡",Toast.LENGTH_LONG).show();
            return;
        }
        startActivitiyAndFinishSelf(Setup3Activity.class);
    }

    @Override
    public void showPre() {
        startActivitiyAndFinishSelf(Setup1Activty.class);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_bind_sim:
                bindSIM();
                break;
        }
    }

    private void bindSIM() {
        if(!isBind()){
            String simeSerinalNumbew = mTelephonyManager.getSimSerialNumber();
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("sim",simeSerinalNumbew);
            edit.commit();
            Toast.makeText(this,"SIM卡绑定成功！",Toast.LENGTH_LONG).show();
            mBindSIMBtn.setEnabled(false);
        }else{
            Toast.makeText(this,"SIM卡已经绑定！",Toast.LENGTH_LONG).show();
            mBindSIMBtn.setEnabled(false);
        }
    }


}
