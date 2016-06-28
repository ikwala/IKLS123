package ikwala.com;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class NewUserActivity extends AppCompatActivity {

    EditText etFirstName;
    EditText etMiddleName;
    EditText etLastName;
    EditText etCity;
    EditText etEmail;
    EditText etPphoneNumber;
    EditText etStreet;
    EditText etPassword;
    String Emirates = "Abu Dhabi";

    IKLSModulator iklsModulator;

    Spinner spinner;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        iklsModulator = IKLSModulator.getsIKIklsModulator(getApplicationContext());

        etFirstName = (EditText)findViewById(R.id.etFirstName);
        etMiddleName = (EditText)findViewById(R.id.etMiddleName);
        etLastName = (EditText)findViewById(R.id.etLastName);
        etCity = (EditText)findViewById(R.id.etCity);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPphoneNumber = (EditText)findViewById(R.id.etPhonrNumber);
        etStreet = (EditText)findViewById(R.id.etStreet);
        etPassword = (EditText)findViewById(R.id.etPassword);
        spinner = (Spinner)findViewById(R.id.spEmirates);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Emirates = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String firstname = etFirstName.getText().toString();
                String middleName = etMiddleName.getText().toString();
                String lastName = etLastName.getText().toString();
                String city = etCity.getText().toString();
                String street = etStreet.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                int phoneNumber;


                if (firstname.isEmpty())
                {
                    etFirstName.setHintTextColor(Color.RED);
                    Snackbar.make(v,"Please fill the requirment",Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (middleName.isEmpty())
                {
                    etMiddleName.setHintTextColor(Color.RED);
                    Snackbar.make(v,"Please fill the requirment",Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (lastName.isEmpty())
                {
                    etLastName.setHintTextColor(Color.RED);
                    Snackbar.make(v,"Please fill the requirment",Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (city.isEmpty())
                {
                    etCity.setHintTextColor(Color.RED);
                    Snackbar.make(v,"Please fill the requirment",Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (street.isEmpty())
                {
                    etStreet.setHintTextColor(Color.RED);
                    Snackbar.make(v,"Please fill the requirment",Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (email.isEmpty())
                {
                    etEmail.setHintTextColor(Color.RED);
                    Snackbar.make(v,"Please fill the requirment",Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (password.isEmpty())
                {
                    etPassword.setHintTextColor(Color.RED);
                    Snackbar.make(v,"Please fill the requirment",Snackbar.LENGTH_LONG).show();
                    return;
                }

                try
                {
                    phoneNumber = Integer.parseInt(etPphoneNumber.getText().toString());
                }
                catch (NumberFormatException nfe)
                {
                    etPphoneNumber.setHintTextColor(Color.RED);
                    Snackbar.make(v,"Please fill the requirment",Snackbar.LENGTH_LONG).show();
                    return;
                }

                User user = new User(firstname,middleName,lastName,phoneNumber,city,Emirates,street,email,password);

                iklsModulator.addUser(user);

                Intent i = new Intent(NewUserActivity.this, MainActivity.class);
                startActivity(i);
                finish();





            }
        });

    }
}