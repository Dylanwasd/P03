package sg.edu.rp.c346.p03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class screen2 extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Grade> grade;
    Button info;
    Button add;
    Button email;

    int week;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        week = 4;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        info = findViewById(R.id.buttonInfo);
        add = findViewById(R.id.buttonAdd);
        email = findViewById(R.id.buttonEmail);
        lv = findViewById(R.id.listViewGrades);

        // Create a few food objects in Food array
        grade = new ArrayList<Grade>();
        grade.add(new Grade(1, "B", "DG"));
        grade.add(new Grade(2, "C", "DG"));
        grade.add(new Grade(3, "A", "DG"));

        // Link this Activity object, the row.xml layout for
        //  each row and the food String array together
        aa = new gradeAdapter(this, R.layout.row, grade);
        lv.setAdapter(aa);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(screen2.this, addGrade.class);


                intent.putExtra("week", week);
                startActivity(intent);


            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String grades = "";
                String base = "Hi faci,\n\n I am Dylan Lau   \n Please see my remarks so far, thank you! \n\n";
                for (int i = 0; i < grade.size(); i++) {
                    grades = grades + "Week" + grade.get(i).getWeek() + ":  " + grade.get(i).getModule() + ": " + grade.get(i).getGrade() + "\n";
                }
                String message = base + grades;
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_TEXT,
                        message);
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            String like = data.getStringExtra("submit");
            grade.add(new Grade(week, like, "DG"));
            week = week + 1;
            aa = new gradeAdapter(this, R.layout.row, grade);
            lv.setAdapter(aa);

    }
}
