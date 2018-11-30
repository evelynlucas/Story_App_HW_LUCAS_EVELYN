package org.pursuit.story_app_hw_lucas_evelyn;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class FinalActivity extends AppCompatActivity {

    private TextView textView;
    private ConstraintLayout layout;
    private Button button;
    private EditText editText;
    private String story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        layout = findViewById(R.id.finalLayout);
        Random random = new Random();
        int[] random_color_array = this.getResources().getIntArray(R.array.random_color);
        int random_color = random_color_array[random.nextInt(8)];
        layout.setBackgroundColor(random_color);

        textView = (TextView)findViewById(R.id.finalView);

        Intent intent = getIntent();

        String name = intent.getStringExtra(MainActivity.NAME);
        String adjective = intent.getStringExtra(SecondActivity.ADJECTIVE);
        String city = intent.getStringExtra(ThirdActivity.CITY);
        String number = intent.getStringExtra(FourthActivity.NUMBER);
        String animal = intent.getStringExtra(FifthActivity.ANIMAL);
        String bodyPart = intent.getStringExtra(SixthActivity.BODY_PART);
        String noun = intent.getStringExtra(SeventhActivity.NOUN);

        story = getString(R.string.story, name, adjective, city, number, animal, bodyPart, noun);
        textView.setText(story);

    editText = findViewById(R.id.emailEntry);
    button = findViewById(R.id.button_send_email);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{editText.getText().toString()});
            i.putExtra(Intent.EXTRA_SUBJECT, "Mad Libs Story");
            i.putExtra(Intent.EXTRA_TEXT, story);
            try {
                startActivity(Intent.createChooser(i, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(FinalActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
        }
    });
    }
}
