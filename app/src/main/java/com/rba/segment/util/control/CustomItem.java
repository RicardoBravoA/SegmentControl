package com.rba.segment.util.control;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.rba.segment.R;
import com.rba.segment.model.CustomEntity;
import com.rba.segment.util.Util;

import java.util.List;

/**
 * Created by Ricardo Bravo on 26/08/16.
 */

public class CustomItem<T> {

    private List<T> list;
    private int sizeScreen;
    private LayoutInflater inflater;
    private Activity activity;
    private RadioGroup radioGroup;

    public CustomItem(Activity activity, List<T> list, RadioGroup radioGroup){
        this.list = list;
        this.activity = activity;
        this.radioGroup = radioGroup;
        inflater = LayoutInflater.from(activity);
        sizeScreen = Util.getWidthScreen(activity);

        showData();
    }

    @SuppressLint("InflateParams")
    private void showData(){

        CustomToggleButton customToggleButton;

        for(int i = 0; i < list.size(); i++){
            if(i+1 == list.size()){
                customToggleButton =
                        (CustomToggleButton) inflater.inflate(R.layout.control_item_last, null);
            }else{
                customToggleButton =
                        (CustomToggleButton) inflater.inflate(R.layout.control_item, null);
            }

            CustomEntity customEntity = (CustomEntity) list.get(i);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((sizeScreen -
                    Util.convertDPtoPX(activity, 20))/3,
                    LinearLayout.LayoutParams.MATCH_PARENT);

            customToggleButton.setLayoutParams(params);
            customToggleButton.setText(customEntity.toString());
            //customToggleButton.setCompoundDrawablesWithIntrinsicBounds(0, image, 0, 0);
            customToggleButton.setId(customEntity.getId());
            radioGroup.addView(customToggleButton);

        }


    }

}
