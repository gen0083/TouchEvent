package jp.gcreate.sample.touchevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int count = event.getPointerCount();
        String text = "pointer count:" + count
                + " x:" + event.getX()
                + " y:" + event.getY() + "\n";
        for (int i = 0; i < count; i++) {
            try {
                int id = event.getPointerId(i);
                text += " pointer index:" + i + " pointer id:" + id
                        + " x:" + event.getX(id)
                        + " y:" + event.getY(id)
                        + "\n";
            }catch (IllegalArgumentException e){
                e.printStackTrace();
                text += " - pointer index:" + i + " out of range -\n";
            }
        }
        textView.setText(text);
        return true;
    }
}
