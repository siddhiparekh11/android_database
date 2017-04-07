package com.example.siddhiparekh11.androiddatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onInsertPressed(View v)
    {
        Intent i = new Intent(this,InsertActivity.class);
        startActivity(i);

    }
    public void onSearchPressed(View v)
    {
        Intent i = new Intent(this,SearchActivity.class);
        startActivity(i);
    }
    public void onFinish(View v)
    {
        this.finish();
    }

}
