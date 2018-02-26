package com.example.joker.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private EditText writeText;
    private TextView showText;
    private String text ;
    private Toast toast;

    private static final String TAG = "myLogs" ;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        /*if (id == R.id.menu_settings){
            toast = Toast.makeText(MainActivity.this , "Вы выбрали в меню поле " + getString(R.string.menu_settings) , Toast.LENGTH_SHORT);
            toast.show();
        } else if (id == R.id.menu_list){
            toast = Toast.makeText(MainActivity.this , "Вы выбрали в меню поле " + getString(R.string.menu_list) , Toast.LENGTH_SHORT);
            toast.show();
        } else if (id == R.id.menu_sort){
            toast = Toast.makeText(MainActivity.this , "Вы выбрали в меню поле " + getString(R.string.menu_sort) , Toast.LENGTH_SHORT);
            toast.show();
        }*/
        switch (item.getItemId()){
            case R.id.menu_settings:
                Toast.makeText(MainActivity.this , "Вы выбрали в меню поле " + getString(R.string.menu_settings) , Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_list:
                Toast.makeText(MainActivity.this , "Вы выбрали в меню поле " + getString(R.string.menu_list) , Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_sort:
                Toast.makeText(MainActivity.this , "Вы выбрали в меню поле " + getString(R.string.menu_sort) , Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG , "Найден View элемент");

        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        showText = (TextView) findViewById(R.id.textView);
        writeText = (EditText) findViewById(R.id.editText2);



        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!writeText.getText().toString().isEmpty()) {
                    switch (view.getId()) {
                        case R.id.button1:
                            showText.setText(writeText.getText() + " Текст был отправлен кнопкой " + getString(R.string.button_new));
                            //----------------------------------------//
                            toast = Toast.makeText(MainActivity.this , "Нажата кнопка NEW" , Toast.LENGTH_SHORT);
                            LinearLayout toastImage = (LinearLayout) toast.getView();
                            ImageView imageView = new ImageView(MainActivity.this);
                            imageView.setImageResource(R.drawable.smile);
                            //toastImage.addView(imageView , 0);
                            toastImage.addView(imageView);
                            toast.show();
                            //---------------------------------------//
                            Log.d(TAG , "Нажатие кнопки NEW");
                            break;
                        case R.id.button2:
                            showText.setText(writeText.getText() + " Текст был отправлен кнопкой " + getString(R.string.button_send));
                            toast = Toast.makeText(MainActivity.this , "Нажата кнопка SEND" , Toast.LENGTH_SHORT);
                            toast.show();
                            Log.d(TAG , "Нажатие кнопки SEND");
                            break;
                        case R.id.button3:
                            showText.setText(writeText.getText() + " Текст был отправлен кнопкой " + getString(R.string.button3));
                            toast = Toast.makeText(MainActivity.this , "Нажата кнопка BUTTON3" , Toast.LENGTH_SHORT);
                            toast.show();
                            Log.d(TAG , "Нажатие кнопки BUTTON3");
                            break;
                    }
                    showText.setTextColor(getColor(R.color.mainTextColor));
                }
                else {
                    showText.setText(" Текст отсутствует ");
                    showText.setTextColor(getColor(R.color.errorTextColor));
                    toast = Toast.makeText(MainActivity.this , "Нажатие одной из кнопок без текста" , Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER , 100,200);
                    toast.show();
                    Log.d(TAG , "Нажатие одной из кнопок без текста");
                }
            }
        };

        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);





        /*
        btn1.setOnClickListener(Listener);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showText.setText(" Была нажата кнопка" +  getString(R.string.button_new));
            }
        });
        btn3.setOnClickListener(this);*/
    }
}

                    /*
                    showText.setTextColor(0xFFFF0000);
                    showText.getResources().getColor(R.color.errorTextColor);
                   .setTextColor(Color.rgb(200,0,0));
                    -----------------------------------
                   And of course, if you want to define your color in an XML file, you can do this:

                    <color name="errorColor">#f00</color>

                    because the getColor() function is deprecated1, you need to use it like so:

                    ContextCompat.getColor(context, R.color.your_color);
                    --------------------------------------------------------
                    TextView text = (TextView) findViewById(R.id.text);
                    text.setTextColor(Color.parseColor("#FFFFFF"));
                    ----------------------------------------------------
                   */