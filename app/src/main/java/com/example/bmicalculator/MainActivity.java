package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    String typeofuser="0";
    String mintprogress="170";
    String weight2="55";
    String age2="22";
    int intweight=55;
    int currentprogress=0;
    int intage=22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        RelativeLayout mmale=findViewById(R.id.male);
        RelativeLayout mfemale=findViewById(R.id.female);
        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="MALE";
            }
        });
        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="FEMALE";
            }
        });
        TextView mcurrentheight=findViewById(R.id.currentheight);
        SeekBar mseekbar=findViewById(R.id.seekbarforheight);
        mseekbar.setMax(300);
        mseekbar.setProgress(170);
        mseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress=progress;
                mintprogress=String.valueOf(currentprogress);
               mcurrentheight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        TextView mcurrentage=findViewById(R.id.currentage);
        ImageView mincrementage=findViewById(R.id.incrementage);
        mincrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage+1;
                mcurrentage.setText(String.valueOf(intage));
            }
        });

        TextView mcurrentweight=findViewById(R.id.currentweigth);
       
        ImageView mincrementweight=findViewById(R.id.incrementweight);
        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight++;
               mcurrentweight.setText(String.valueOf(intweight));
            }
        });

        ImageView mdecrementage=findViewById(R.id.decrementage);
        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage--;
                mcurrentage.setText(String.valueOf(intage));
            }
        });

        ImageView mderementweight=findViewById(R.id.decrementweight);
        mderementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight--;
                mcurrentweight.setText(String.valueOf(intweight));
            }
        });



        Button mcalculatebmi=findViewById(R.id.calculatebmi);
        mcalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(typeofuser.equals("0")){
                    Toast.makeText(getApplicationContext(),"Select your Gender first",Toast.LENGTH_SHORT).show();
                }else if(mintprogress.equals("0")){
                    Toast.makeText(getApplicationContext(),"Select your Height first",Toast.LENGTH_SHORT).show();
                }else if(intage<=0){
                    Toast.makeText(getApplicationContext(),"Age is Incorrect",Toast.LENGTH_SHORT).show();
                }else if(intweight<=0){
                    Toast.makeText(getApplicationContext(),"Weight is Incorrect",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, BmiActivity.class);
                       intent.putExtra("gender",typeofuser);
                       intent.putExtra("height",mintprogress);
                       intent.putExtra("age",age2);
                       intent.putExtra("weight",weight2);
                       startActivity(intent);
                }
            }
        });
    }
}