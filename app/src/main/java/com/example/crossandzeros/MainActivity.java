package com.example.crossandzeros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     int ActiveImage=0,CurTag;

    int arr[][]=new int[3][3];


    public void dropIn(View view)
    {
        ImageView counter=(ImageView)view;

        if(counter.getDrawable()==null) {
            counter.setTranslationY(-2000);
            if (ActiveImage == 0) {
                counter.setImageResource(R.drawable.xx);
                counter.animate().translationYBy(2000).rotation(360).setDuration(100);
                ActiveImage=1;

            }
            else {

                counter.setImageResource(R.drawable.zero);
                counter.animate().translationYBy(2000).rotation(360).setDuration(100);
                ActiveImage=0;

            }



            CurTag = Integer.parseInt(counter.getTag().toString());
          arr[CurTag/3][CurTag%3]=ActiveImage+1;

           for(int i=0;i<3;i++)
           {
               if((arr[i][0]==arr[i][1]&&arr[i][1]==arr[i][2])&&arr[i][0]!=0)
               {
                   pop(arr[i][0]);
                   clear();

               }
               if((arr[0][i]==arr[1][i]&&arr[1][i]==arr[2][i])&&arr[0][i]!=0)
               {
                   pop(arr[0][i]);
                   clear();
               }
           }
           if((arr[0][0]==arr[1][1]&&arr[1][1]==arr[2][2])&&arr[0][0]!=0)
           {
               pop(arr[0][0]);
               clear();
           }
           if((arr[0][2]==arr[1][1]&&arr[1][1]==arr[2][0])&&arr[0][2]!=0)
           {
               pop(arr[0][2]);
               clear();
           }


        }
    }
    public void pop(int a)
    {
        if(a==1) {

            Toast.makeText(MainActivity.this, "zero wins", Toast.LENGTH_SHORT).show();

        }
        if(a==2)
        {
            Toast.makeText(MainActivity.this, "cross wins", Toast.LENGTH_SHORT).show();

        }
    }
    public void clear()
    {
        ImageView i1=(ImageView)findViewById(R.id.r1c1);
        i1.setImageResource(0);
        ImageView i2=(ImageView)findViewById(R.id.r1c2);
        i2.setImageResource(0);
        ImageView i3=(ImageView)findViewById(R.id.r1c3);
        i3.setImageResource(0);
        ImageView i4=(ImageView)findViewById(R.id.r2c1);
        i4.setImageResource(0);
        ImageView i5=(ImageView)findViewById(R.id.r2c2);
        i5.setImageResource(0);
        ImageView i6=(ImageView)findViewById(R.id.r2c3);
        i6.setImageResource(0);
        ImageView i7=(ImageView)findViewById(R.id.r3c1);
        i7.setImageResource(0);
        ImageView i8=(ImageView)findViewById(R.id.r3c2);
        i8.setImageResource(0);
        ImageView i9=(ImageView)findViewById(R.id.r3c3);
        i9.setImageResource(0);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
