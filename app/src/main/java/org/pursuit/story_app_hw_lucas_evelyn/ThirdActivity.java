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

public class ThirdActivity extends AppCompatActivity {
    public static final String CITY = "city";
    private ConstraintLayout layout;
    private EditText editText;
    private Button button;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        layout = findViewById(R.id.thirdLayout);
        Random random = new Random();
        int[] random_color_array = this.getResources().getIntArray(R.array.random_color);
        int random_color = random_color_array[random.nextInt(8)];
        layout.setBackgroundColor(random_color);

        Intent intent = getIntent();
        extras = intent.getExtras();
        editText = (EditText)findViewById(R.id.editText3);
        button = (Button)findViewById(R.id.thirdButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityString = editText.getText().toString();
                cityString = cityString.trim();
                extras.putString(CITY, cityString);
                Intent intent2 = new Intent(ThirdActivity.this, FourthActivity.class);
                intent2.putExtras(extras);

                if (!cityString.equals("") && cityString.matches("[a-zA-Z]+")) {
                    startActivity(intent2);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid User Input", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
    }
}
