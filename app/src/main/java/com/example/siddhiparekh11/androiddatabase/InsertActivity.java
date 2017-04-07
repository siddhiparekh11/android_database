package com.example.siddhiparekh11.androiddatabase;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.view.View;

/**
 * Created by siddhiparekh11 on 4/3/17.
 */

public class InsertActivity extends Activity {

    EditText itemname;
    EditText itemdes;
    EditText itemprice;
    EditText itemrev;
    myDBHandler h;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

    }

    @Override
    protected void onStart() {
        super.onStart();
        h=new myDBHandler(this,null,null,1);
        itemname = (EditText)findViewById(R.id.edit_name);
        itemdes=(EditText)findViewById(R.id.edit_description);
        itemprice=(EditText)findViewById(R.id.edit_price);
        itemrev=(EditText)findViewById(R.id.edit_review);


    }
    public void onAdd(View v)
    {
        Products p;
        p=new Products(itemname.getText().toString(),itemdes.getText().toString(),itemprice.getText().toString(),itemrev.getText().toString());
         h.addProduct(p);

    }
    public void onCancel(View v)
    {
        itemname.setText("");
        itemdes.setText("");
        itemprice.setText("");
        itemrev.setText("");

    }


}
