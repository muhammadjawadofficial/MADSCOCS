package pk.edu.scocs.madlecture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        calculateResult();
    }

    private void calculateResult() {
        Intent intent = getIntent();
        int a = intent.getIntExtra("parameter1",0);
        int b = intent.getIntExtra("parameter2",0);
        int c = intent.getIntExtra("parameter3",0);

        TextView v = findViewById(R.id.equation);
        v.setText(Html.fromHtml(a+"x<sup>2</sup> + "+b+"x +"+c+" = 0"));

        double x1,x2;
        int disc = (b*b)-(4*a*c);

        if(disc<0)
        {
            disc = disc*(-1);
            v = findViewById(R.id.x1);
            v.setText("(-"+b+"+ sqrt("+disc+"i))/"+2*a);
            v = findViewById(R.id.x2);
            v.setText("(-"+b+"- sqrt("+disc+"i))/"+2*a);
        }
        else if(disc>0)
        {
            x1 = ((-b) + Math.sqrt(disc))/(2*a);
            x2 = ((-b) - Math.sqrt(disc))/(2*a);
            v = findViewById(R.id.x1);
            v.setText(x1+"");
            v = findViewById(R.id.x2);
            v.setText(x2+"");
        }
        else
        {
            x1 = x2 = (-b)/(2*a);
            v = findViewById(R.id.root1Heading);
            v.setText("X");
            v = findViewById(R.id.x1);
            v.setText(x1+"");
            v = findViewById(R.id.root2Heading);
            v.setText(" ");
            v = findViewById(R.id.x2);
            v.setText(" ");
        }
    }
}
