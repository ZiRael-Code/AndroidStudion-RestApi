package com.example.connectingfrontend;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.connectingfrontend.ChatConnect.ApiClient;
import com.google.gson.JsonObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity {
        private Button button;
        private TextView textView;
        private EditText name;
        private EditText password;


            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ApiClient apiClient = new ApiClient();
        button = findViewById(R.id.submit);
        textView = findViewById(R.id.textView);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);

        /*
        Get Request Send

      ;

        button.setOnClickListener(view -> {
            apiClient.makeGetRequest(textView);

        });
*/


        button.setOnClickListener(view -> {
        if (name.getText().toString() != null && password.getText().toString() != null){
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", name.getText().toString());
            jsonObject.addProperty("password", password.getText().toString());

            String jsonBody = jsonObject.toString();
            RequestBody requestBody = RequestBody.create(jsonBody, MediaType.parse("application/json"));
            apiClient.makePostRequest(requestBody, textView);
        }
        });
            }
}