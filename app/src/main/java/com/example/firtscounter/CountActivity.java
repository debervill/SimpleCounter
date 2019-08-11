package com.example.firtscounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class CountActivity extends AppCompatActivity {

    private int mCounterValue;
    private TextView mValueTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_counter);

        mValueTextView = findViewById(R.id.counter);

        final TextView valueText = findViewById(R.id.counter);
        mCounterValue = 0;
        valueText.setText(String.valueOf(mCounterValue));

        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                final int tmpCounterValue = mCounterValue;
                mCounterValue = 0;
                Snackbar.make(v, "счетчик обнулен",Snackbar.LENGTH_SHORT)
                        .setAction("Отмена", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                mCounterValue = tmpCounterValue;
                                updateValue();
                            }
                        })
                        .show();
                mCounterValue=0;
                updateValue();

            }
        });

        findViewById(R.id.plus).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCounterValue++;
                updateValue();
            }
        });

        findViewById(R.id.minus).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCounterValue--;
                if (mCounterValue <0){
                    mCounterValue=0;
                }
               updateValue();

            }
        });

    }

    private  void updateValue(){
        mValueTextView.setText(String.valueOf(mCounterValue));
    }
}
// TODO: 2019-08-11 Сделать главный экран на котором будут создаанные счетчики
// TODO: 2019-08-11 Прикрутить базу данных
// TODO: 2019-08-11 Залить в гитхаб
