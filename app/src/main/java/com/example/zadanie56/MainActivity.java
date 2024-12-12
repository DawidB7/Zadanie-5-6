package com.example.zadanie56;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int licznikLike = 0;
    private TextView licznikLikeText;
    private Button polub;
    private Button usunPolub;
    private EditText ETemail;
    private EditText EThaslo;
    private EditText EThasloAgain;
    private Button wyslij;
    private Button uczestnik;
    private TextView komunikat;
    private String ostatnioZarejestrowany = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        licznikLikeText = findViewById(R.id.licznikPolub);
        polub = findViewById(R.id.likeButton);
        usunPolub = findViewById(R.id.deleteButton);
        ETemail = findViewById(R.id.ETEmail);
        EThaslo = findViewById(R.id.ETPassword);
        EThasloAgain = findViewById(R.id.ETPasswordAgain);
        wyslij = findViewById(R.id.saveButton);
        uczestnik = findViewById(R.id.showUserButton);
        komunikat = findViewById(R.id.komunikaty);

        polub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                licznikLike++;
                nowaLiczbaLike();
            }
        });

        usunPolub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (licznikLike > 0) {
                    licznikLike--;
                    nowaLiczbaLike();
                }
            }
        });

        wyslij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ETemail.getText().toString().trim();
                String haslo = EThaslo.getText().toString().trim();
                String hasloAgain = EThasloAgain.getText().toString().trim();

                if (!email.contains("@")) {
                    komunikat.setText("Nieprawidłowy adres e-mail");
                } else if (!hasloAgain.matches(haslo)) {
                    komunikat.setText("Hasła się różnią");
                } else {
                    ostatnioZarejestrowany = email;
                    komunikat.setText("Zarejestrowano " + email);
                }
            }

        });

        uczestnik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ostatnioZarejestrowany.isEmpty()){
                    komunikat.setText("Uczestnik: " + ostatnioZarejestrowany);
                } else {
                    komunikat.setText("Brak zarejestrowanego użytkownika");
                }
            }
        });
    }

    private void nowaLiczbaLike() {
        licznikLikeText.setText(licznikLike + " Polubień");
    }

}