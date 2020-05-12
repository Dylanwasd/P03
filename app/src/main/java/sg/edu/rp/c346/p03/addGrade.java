package sg.edu.rp.c346.p03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class addGrade extends AppCompatActivity {
    TextView tvWeek;
    RadioGroup rg;
    Button submit;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grade);
        tvWeek = (TextView) findViewById(R.id.textViewWeek);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        submit = (Button) findViewById(R.id.buttonSubmit);

        Intent i = getIntent();
        int week = i.getIntExtra("week",0);
        String stringWeek = String.valueOf(week);
        tvWeek.setText("Week: "+stringWeek);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radio = rg.getCheckedRadioButtonId();
                rb = findViewById(radio);
                String rbText = rb.getText().toString();
                Intent i = new Intent();
                i.putExtra("grade", rbText);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}
