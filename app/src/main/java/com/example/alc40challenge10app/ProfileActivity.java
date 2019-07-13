package com.example.alc40challenge10app;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private TextView mProfileDetail;
    private final String mHtmlResource = "<p><Strong>Track:   </strong>  Android</p></br>\n" +
            "            <p><Strong>Country:   </strong>  Chad</p></br>\n" +
            "            <p><Strong>Email:   </strong>  nourdiko@gmail.com</p></br>\n" +
            "            <p><Strong>Mobile number:   </strong>  +235-555-5555</p></br>\n" +
            "            <p><Strong>Slack Username:   </strong>  @Mahamat Ali</p>";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mProfileDetail = findViewById(R.id.tv_profile_details);
        mProfileDetail.setText(Html.fromHtml(mHtmlResource));
    }
}
