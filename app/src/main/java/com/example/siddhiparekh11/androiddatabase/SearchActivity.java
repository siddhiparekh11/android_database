package com.example.siddhiparekh11.androiddatabase;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

/**
 * Created by siddhiparekh11 on 4/3/17.
 */

public class SearchActivity extends Activity {
    EditText searchitem;
    TextView display;
    myDBHandler h;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

    }

    @Override
    protected void onStart() {
        super.onStart();
        searchitem=(EditText)findViewById(R.id.edit_search);
        display=(TextView)findViewById(R.id.viewResultMultiline);
        h=new myDBHandler(this,null,null,1);

    }
    public void onSearchPressed(View v)
    {
        if(searchitem.getText().toString()!=null)
        display.setText(h.databaseToString(searchitem.getText().toString()));
    }
    public void onCancel(View v)
    {
        searchitem.setText("");
        display.setText("");
    }
}
