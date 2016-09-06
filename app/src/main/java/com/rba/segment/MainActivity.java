package com.rba.segment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;

import com.rba.segment.model.CustomEntity;
import com.rba.segment.util.control.CustomItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rgControl = (RadioGroup) findViewById(R.id.rgControl);


        List<CustomEntity> customEntityList = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            customEntityList.add(new CustomEntity(i, "Text "+i));
        }

        CustomItem customItem = new CustomItem(this, customEntityList, rgControl);

        rgControl.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        Log.i("x- selected", ""+i);
    }

    /*
    private void addOperationType(RadioGroup group, int id, boolean isLast, int text) {

        CustomToggleButton customToggleButton;

        if(isLast){
            customToggleButton =
                    (CustomToggleButton) getLayoutInflater().inflate(R.layout.operation_type_last_item, null);
        }else{
            customToggleButton =
                    (CustomToggleButton) getLayoutInflater().inflate(R.layout.operation_type_item, null);
        }

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((sizeScreen -
                Utility.convertDPtoPX(this, 20))/3,
                LinearLayout.LayoutParams.MATCH_PARENT);

        customToggleButton.setLayoutParams(params);
        customToggleButton.setText(text);
        //customToggleButton.setCompoundDrawablesWithIntrinsicBounds(0, image, 0, 0);
        customToggleButton.setId(id);
        group.addView(customToggleButton);
    }
    */


}
