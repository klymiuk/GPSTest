package com.example.user.gpstest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by User on 26.07.2017.
 */

public class TestClass extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test_activity);
        Toast toast = Toast.makeText(this,"Test Toast message",Toast.LENGTH_SHORT);
        toast.show();
    }
}
