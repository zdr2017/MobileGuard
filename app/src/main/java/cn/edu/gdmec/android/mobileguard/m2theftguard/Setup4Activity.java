package cn.edu.gdmec.android.mobileguard.m2theftguard;

import android.os.Bundle;
import android.widget.RadioButton;

import cn.edu.gdmec.android.mobileguard.R;

/**
 * Created by asus on 2017/10/23.
 */

public class Setup4Activity extends BaseSetupActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_4);
        ((RadioButton) findViewById(R.id.rb_first)).setChecked(true);
    }

    @Override
    public void showNext() {
        startActivitiyAndFinishSelf(LostFindActivity.class);
    }

    @Override
    public void showPre() {
        startActivitiyAndFinishSelf(Setup3Activity.class);
    }
}
