package org.pursuit.story_app_hw_lucas_evelyn;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;


public class SecondActivity extends AppCompatActivity {
    public static final String ADJECTIVE = "adjective";
    private ConstraintLayout layout;
    private EditText editText;
    private Button button;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        layout = findViewById(R.id.secondLayout);
        Random random = new Random();
        int[] random_color_array = this.getResources().getIntArray(R.array.random_color);
        int random_color = random_color_array[random.nextInt(8)];
        layout.setBackgroundColor(random_color);

        Intent intent = getIntent();
        extras = intent.getExtras();

        editText = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.secondButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adjectiveString = editText.getText().toString();
                adjectiveString = adjectiveString.trim();
                extras.putString(ADJECTIVE, adjectiveString);
                Intent intent2 = new Intent(SecondActivity.this, ThirdActivity.class);
                intent2.putExtras(extras);

                if (!adjectiveString.equals("") && adjectiveString.matches("[a-zA-Z]+")) {
                    startActivity(intent2);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid User Input", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
    }
}
