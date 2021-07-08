package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        User userLuda = new User("luda 2009", "luda@mail.com", "12345abc","12345abc" , "Japan, Tokyo, Lano st, 12 44883", 12);
        User userMax = new User("max 1990", "Max@mail.com", "12345max","12345max" , "Ukraine, Zaporizhzhya, Sobornyi pr, 12 69000", 31);
        ArrayList<Object> users = new ArrayList<>();
        users.add(userLuda);
        users.add(userMax);
        ArrayList<String> loginList = new ArrayList<>();
        ArrayList<String> emailList = new ArrayList<>();
        ArrayList<String> passwordList = new ArrayList<>();
        ArrayList<String> confirmPasswordList = new ArrayList<>();
        ArrayList<String> addressList = new ArrayList<>();
        ArrayList<Integer> ageList = new ArrayList<>();
        ArrayList<Object> verifiedUser = new ArrayList<>();



        for (int i = 0; i <= users.size()-1; i++) {
            int happyInputCounter = 0;
            if (loginList.contains (((User)users.get(i)).getLogin())) Log.d("MyLog", "login is already in use");
            else   {loginList.add(((User)users.get(i)).getLogin());
                    happyInputCounter = happyInputCounter + 1;
            }

            if (emailList.contains(((User)users.get(i)).getEmail())) Log.d("MyLog", "email is already in use");
            else if (((User)users.get(i)).getEmail().contains("@") && (((User)users.get(i)).getEmail().contains("."))) {emailList.add(((User) users.get(i)).getEmail());
                happyInputCounter = happyInputCounter + 1;
            }
            else Log.d("MyLog", "enter email correctly");

            if (passwordList.contains (((User)users.get(i)).getPassword())) Log.d("MyLog", "password is already in use");
            else  { passwordList.add(((User)users.get(i)).getPassword());
                happyInputCounter = happyInputCounter + 1;
            }

            if (confirmPasswordList.contains (((User)users.get(i)).getConfirmPassword())) Log.d("MyLog", "password is already in use");
            else if (((User)users.get(i)).getConfirmPassword().equals(((User)users.get(i)).getPassword()))  {confirmPasswordList.add(((User)users.get(i)).getConfirmPassword());
                happyInputCounter = happyInputCounter + 1;
            }
            else Log.d("MyLog", "try again");

            if (addressList.contains (((User)users.get(i)).getAddress())) Log.d("MyLog", "address is already in use");
            else  if (((User)users.get(i)).getAddress().contains("Ukraine")) {addressList.add(((User)users.get(i)).getAddress());
                happyInputCounter = happyInputCounter + 1;
            }
            else Log.d("MyLog", "registration only for residents of Ukraine");

            if (((User)users.get(i)).getAge() < 18) Log.d("MyLog", "registration only for adults");
            else  { ageList.add(((User)users.get(i)).getAge());
                happyInputCounter = happyInputCounter + 1;
            }

            if (happyInputCounter == 6) verifiedUser.add((User)users.get(i));
            else Log.d("MyLog", "you " + (((User)users.get(i)).getLogin())+ " are not registered");
        }
        for (int j =0; j <= verifiedUser.size(); j++){
            Log.d("MyLog", "you " + (((User)verifiedUser.get(j)).getLogin()) + " registered successfully");
        }
    }
}