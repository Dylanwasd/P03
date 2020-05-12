package sg.edu.rp.c346.p03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        module = findViewById(R.id.textView);

        module.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, screen2.class);
                // Start activity with requestCodeForSupermanStats to 		//identify it was started by clicking on Superman
                startActivity(intent);
            }
        });
    }


}
