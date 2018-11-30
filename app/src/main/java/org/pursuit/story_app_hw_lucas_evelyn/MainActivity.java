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


public class MainActivity extends AppCompatActivity {

    public static final String NAME = "name";
    private ConstraintLayout layout;
    private EditText editText;
    private Button button;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.mainLayout);
        Random random = new Random();
        int[] random_color_array = this.getResources().getIntArray(R.array.random_color);
        int random_color = random_color_array[random.nextInt(8)];
        layout.setBackgroundColor(random_color);

        extras = new Bundle();

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.firstButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameString = editText.getText().toString();
                nameString = nameString.trim();
                extras.putString(NAME, nameString);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtras(extras);

                if (!nameString.equals("") && nameString.matches("[a-zA-Z]+")) {
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid User Input", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
