package pk.edu.scocs.madlecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean againPressed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpButton();
    }

    private void setUpButton() {
        Button btn = findViewById(R.id.calculateButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv;
                String data;
                int num;

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                tv = findViewById(R.id.num1);
                data = tv.getText().toString();
                num = Integer.parseInt(data);
                intent.putExtra("parameter1",num);

                tv = findViewById(R.id.num2);
                data = tv.getText().toString();
                num = Integer.parseInt(data);
                intent.putExtra("parameter2",num);

                tv = findViewById(R.id.num3);
                data = tv.getText().toString();
                num = Integer.parseInt(data);
                intent.putExtra("parameter3",num);

                startActivity(intent);
            }
        });
    }

//    public void calculate(View view) {
//        Intent i = new Intent(this, ResultActivity.class);
//
//        TextView num1 = findViewById(R.id.num1);
////        TextView num2 = findViewById(R.id.num2);
//        String strNum1 = num1.getText().toString();
//        i.putExtra("num1" , strNum1);
////        String strNum2 = num2.getText().toString();
////        i.putExtra("num2" , strNum2);
//        startActivity(i);
//    }

    public void onBackPressed() {
        if (!againPressed) {
            againPressed = true;
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_LONG).show();
        } else {
            finish();
        }
//            startActivity(new Intent(this,SecondActivity.class));
//            super.onBackPressed();
    }
}