package cs453final.lofipasswordgen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    // initialize variables
    EditText masterPassword;
    EditText serviceName;
    TextView generatedPass;
    Button generateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the user information for variables
        masterPassword = findViewById(R.id.masterPassword);
        serviceName = findViewById(R.id.serviceName);
        generateButton = findViewById(R.id.generateButton);
        generatedPass = findViewById(R.id.generatedPass);

        // action for when user clicks the generate password button
        generateButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                // initialize variables
                String masterPasswordString,serviceNameString;
                String generatedPassString="";
                StringBuilder builder;
                int index,maxSize,temp,passwordAscii[],serviceAscii[];


                //get the string for the master password/service name
                masterPasswordString = masterPassword.getText().toString();
                serviceNameString = serviceName.getText().toString();

                // set array length to the greatest string, set a maxSize for the loop
                if(masterPasswordString.length() > serviceNameString.length()) {
                    passwordAscii = new int[masterPasswordString.length()];
                    serviceAscii = new int[masterPasswordString.length()];
                    maxSize = masterPasswordString.length();
                }

                else {
                    passwordAscii = new int[serviceNameString.length()];
                    serviceAscii = new int[serviceNameString.length()];
                    maxSize = serviceNameString.length();
                }

                // make sure that the strings are the same size, if not repeat the less lengthy string until it is
                if(masterPasswordString.length() > serviceNameString.length()) {

                    // initialize builder array, builder will repeat the shortest string until it is of equal length
                    builder = new StringBuilder(masterPasswordString.length() + serviceNameString.length() - 1);

                    // loop until builder(serviceNameString) is longer than masterPasswordString
                    while(builder.length() < masterPasswordString.length()) {
                        builder.append(serviceNameString);
                    }

                    // cut off any excess on builder and set serviceNameString to the final repeated string
                    builder.setLength(masterPasswordString.length());
                    serviceNameString = builder.toString();
                }

                // do the same as above but for masterPasswordString being the shorter string, or equal
                else{

                    builder = new StringBuilder(masterPasswordString.length() + serviceNameString.length() - 1);

                    while(builder.length() < serviceNameString.length()) {
                        builder.append(masterPasswordString);
                    }

                    builder.setLength(serviceNameString.length());
                    masterPasswordString = builder.toString();
                }

                // loop
                for(index = 0; index<maxSize; index++) {

                    // convert password and service to ascii values, store in respective arrays
                    passwordAscii[index] = (int)masterPasswordString.charAt(index);
                    serviceAscii[index] = (int)serviceNameString.charAt(index);

                    // add the ascii values together and store in some temp
                    temp = passwordAscii[index] + serviceAscii[index];

                    // check if temp is > 126, if so subtract and assign new value
                    if(temp>126) {
                        temp = temp-126;

                        // check if temp's value is less than 32
                        if(temp<=32)
                            temp = temp+32;
                    }

                    // generate new password, append converted character onto string
                    generatedPassString = generatedPassString + (char)temp;
                }

                // set the generated password
                generatedPass.setText(generatedPassString);
            }

        });



    }

}
