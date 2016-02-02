package jp.gcreate.sample.touchevent;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import jp.gcreate.sample.touchevent.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{
    private ActivityMainBinding binding;
    private MotionEventWrapper wrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        wrapper = new MotionEventWrapper();
        binding.setWrapper(wrapper);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        wrapper.setEvent(event);
        return super.onTouchEvent(event);
    }
}
