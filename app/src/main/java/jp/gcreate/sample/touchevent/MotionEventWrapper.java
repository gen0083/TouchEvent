package jp.gcreate.sample.touchevent;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.MotionEvent;

/**
 * Copyright 2016 G-CREATE
 */
public class MotionEventWrapper extends BaseObservable {
    private String text = "";

    @Bindable
    public String getText() {
        return text;
    }

    public void setEvent(MotionEvent event) {
        int count = event.getPointerCount();
        text = "pointer count:" + count
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
        notifyPropertyChanged(jp.gcreate.sample.touchevent.BR.text);
    }
}
