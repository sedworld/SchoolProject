package com.example.victor.less3110.activitys;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.victor.less3110.R;

public class EditNote extends AppCompatActivity {

    public static void start (Context context){
        Intent intent = new Intent(context, EditNote.class);
        context.startActivity(intent);
    }

    public static Intent newInstance (Context context){
        return new Intent(context, EditNote.class);
    }

    public static final String DATA_KEY = "DATA_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        String extraString = getIntent().getStringExtra(DATA_KEY);
        Toast.makeText(this, "extra is "+extraString, Toast.LENGTH_SHORT).show();
    }
}
