package sab.ifunpas.org;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;

public class Session{
    public static SharedPreferences preferences;
    public static Editor editor;
    public static String PREF_NAME = "DataMahasiswa";

   public  static void createSignInSeassion(Context context, String username){
       preferences = context.getSharedPreferences(PREF_NAME, 0);
       editor = preferences.edit();
       editor.putString("username", username);
       editor.commit();
   }
   public static void logout(Context context) {
       preferences = context.getSharedPreferences(PREF_NAME, 0);
       editor.clear();
       editor.commit();
   }

    public static void createSignInSession(SignInActivity signInActivity, String user) {
    }
}
