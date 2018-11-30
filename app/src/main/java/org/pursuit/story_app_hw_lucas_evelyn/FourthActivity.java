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

public class FourthActivity extends AppCompatActivity {
    public static final String NUMBER = "number";
    private ConstraintLayout layout;
    private EditText editText;
    private Button button;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        layout = findViewById(R.id.fourthLayout);
        Random random = new Random();
        int[] random_color_array = this.getResources().getIntArray(R.array.random_color);
        int random_color = random_color_array[random.nextInt(8)];
        layout.setBackgroundColor(random_color);

        Intent intent = getIntent();
        extras = intent.getExtras();
        editText = (EditText)findViewById(R.id.editText4);
        button = (Button)findViewById(R.id.fourthButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberString = editText.getText().toString();
                numberString = numberString.trim();
                extras.putString(NUMBER, numberString);
                Intent intent2 = new Intent(FourthActivity.this, FifthActivity.class);
                intent2.putExtras(extras);

                if (!numberString.equals("")) {
                    startActivity(intent2);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "User input needed", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
    }
}
