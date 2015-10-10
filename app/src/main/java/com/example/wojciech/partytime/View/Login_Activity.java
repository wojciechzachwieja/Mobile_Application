package com.example.wojciech.partytime.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wojciech.partytime.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


public class Login_Activity extends AppCompatActivity {

    public static final int REQUEST_CODE = 111;
    private EditText emailView;
    private EditText passView;
    public final String DESCRIBE = "Describe";
    public final String TIME = "Time";
    public final String PRICE = "Price";
    public final String TASTE = "Taste";
    public final String SIZE = "Size";
    public final String TITLE = "Title";
    public final String PHOTO = "Photo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        emailView = (EditText)findViewById(R.id.email);
        passView = (EditText)findViewById(R.id.pass);
//        Restaurants restaurants = new Restaurants();
//        restaurants.setID(2l);
//        restaurants.setRestaurantName("Burger King");
//        restaurants.setAmountDishes(6);
//
//        JSONObject jsonObject = new JSONObject();
//        JSONObject jsonObject2 = new JSONObject();
//        JSONObject jsonObject3 = new JSONObject();
//        JSONObject jsonObject4 = new JSONObject();
//        JSONObject jsonObject5 = new JSONObject();
//        JSONObject jsonObject6 = new JSONObject();
//        //JSONObject jsonObject7 = new JSONObject();
//        JSONObject size = new JSONObject();
//        JSONObject taste = new JSONObject();
//        JSONObject price = new JSONObject();
//        JSONObject price2 = new JSONObject();
//        JSONArray jsonArray = new JSONArray();
//        AssetManager assetManager = getAssets();
//        InputStream inputStream[] = new InputStream[6];
//        Bitmap bitmap[] = new Bitmap[6];
//        for(int i = 0;i < 6;++i) {
//            bitmap[i] = null;
//        }
//
//        try{
//            inputStream[0] = assetManager.open("crispychciken.jpg");
//            bitmap[0] = BitmapFactory.decodeStream(inputStream[0]);
//            inputStream[1] = assetManager.open("grilledchickenwrap.jpg");
//            bitmap[1] = BitmapFactory.decodeStream(inputStream[1]);
//            inputStream[2] = assetManager.open("lody.jpg");
//            bitmap[2] = BitmapFactory.decodeStream(inputStream[2]);
//            inputStream[3] = assetManager.open("onionrings.jpg");
//            bitmap[3] = BitmapFactory.decodeStream(inputStream[3]);
//            inputStream[4] = assetManager.open("smoothie.jpg");
//            bitmap[4] = BitmapFactory.decodeStream(inputStream[4]);
//            inputStream[5] = assetManager.open("whooper.jpg");
//            bitmap[5] = BitmapFactory.decodeStream(inputStream[5]);
////            inputStream[6] = assetManager.open("salatka.jpg");
////            bitmap[6] = BitmapFactory.decodeStream(inputStream[6]);
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//        ParseFile parseFile[] = new ParseFile[6];
//        ByteArrayOutputStream byteArrayOutputStream[] = new ByteArrayOutputStream[6];
//        byte[][] bytes = new byte[6][];
//        for(int i = 0;i < 6;++i){
//            byteArrayOutputStream[i] = new ByteArrayOutputStream();
//            bitmap[i].compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream[i]);
//            bytes[i] = byteArrayOutputStream[i].toByteArray();
//            parseFile[i] = new ParseFile(bytes[i]);
//            try {
//                parseFile[i].save();
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//
//        try {
//            jsonObject.put(TITLE,"Crispy Chicken");
//            jsonObject.put(SIZE,null);
//            jsonObject.put(TASTE,null);
//            jsonObject.put(DESCRIBE,"Z wierzchu chrupiący, w środku soczysty? Taki jest właśnie Crispy Chicken! Porcja pysznego kurczaka w panierce, świeża sałata, plasterki pomidora i majonez dla podkreślenia smaku. Obowiązkowo w sezamowej bułce.");
//            price.put("Price1",4.95);
//            jsonObject.put(PRICE,price);
//            size.put("Large","Large");
//            size.put("Small","Small");
//            jsonObject.put(SIZE,null);
//            jsonObject.put(TIME,5L);
//            jsonObject.put(PHOTO,parseFile[0]);
//            ////////////////
//            jsonObject2.put(TITLE,"Grilled Chicken Wrap");
//            jsonObject2.put(SIZE,null);
//            jsonObject2.put(TASTE,null);
//            jsonObject2.put(DESCRIBE,"Powiedzmy sobie szczerze – Grilled Chicken Wrap nie ma nic wspólnego z raperami. No, może poza tym, że jest zakręcony. Najważniejsze jednak, że ma bogate wnętrze..");
//            price2.put("Price1",4.95);
//            jsonObject2.put(PRICE,price2);
//            jsonObject2.put(TIME,4L);
//            jsonObject2.put(PHOTO,parseFile[1]);
//            ////////////////
//            jsonObject3.put(TITLE,"Deser Lodowy");
//            jsonObject3.put(SIZE,null);
//            taste.put("Taste1","Oreo");
//            taste.put("Taste2","KitKat");
//            taste.put("Taste3","Syrop Truskawkowy");
//            jsonObject3.put(TASTE,taste);
//            jsonObject3.put(DESCRIBE,"BK Fusions® to prawdziwa fuzja najbardziej znanych i lubianych smaków. Wybierz swoją ulubioną wersję – z pysznymi kawałkami ciasteczek OREO®, pokruszonym batonikiem KitKat® lub z syropem truskawkowym.");
//            JSONObject price3 = new JSONObject();
//            price3.put("Price1",8.60);
//            jsonObject3.put(PRICE,price3);
//            jsonObject3.put(TIME,5L);
//            jsonObject3.put(PHOTO,parseFile[2]);
//            //////////////
//            jsonObject4.put(TITLE,"Onion Rings");
//            jsonObject4.put(SIZE,size);
//            jsonObject4.put(DESCRIBE,"Są okrągłe. Są chrupiące. Są pyszne. Są gotowe na Twoje zamówienie! Zapraszamy na złociste krążki z cebuli..");
//            JSONObject price4 = new JSONObject();
//            price4.put("Price1",5.95);
//            jsonObject4.put(PRICE,price4);
//            jsonObject4.put(TIME,3L);
//            jsonObject4.put(PHOTO,parseFile[3]);
//            jsonObject4.put(TASTE,null);
//            //////////////
//            jsonObject5.put(TITLE,"Smoothie");
//            jsonObject5.put(SIZE,null);
//            jsonObject5.put(DESCRIBE,"Truskawkowo-bananowe smoothie - Prawdziwa uczta dla zmysłów! Soczysta truskawka w towarzystwie słodkiego banana, jogurtu i lodu to kompozycja niemalże doskonała. Zresztą, przekonaj się sam! \n" +
//                    "Mango smoothie - Uwaga: Mango smoothie orzeźwia – i to jak! Egzotyczny, świeży, rześki smak mango, zmiksowany z jogurtem i lodem, sprawia, że trudno mu się oprzeć. Spróbuj raz, a nabierzesz ochoty na więcej!");
//            JSONObject price5 = new JSONObject();
//            price5.put("Price1",10.5);
//            jsonObject5.put(PRICE,price5);
//            jsonObject5.put(TIME,3L);
//            jsonObject5.put(PHOTO,parseFile[4]);
//            JSONObject taste2 = new JSONObject();
//            taste2.put("Taste1","Strawberry-Banana");
//            taste2.put("Taste2","Mango");
//            jsonObject5.put(TASTE,taste2);
//            ////////////////
//            jsonObject6.put(TITLE,"Whopper");
//            jsonObject6.put(SIZE,null);
//            jsonObject6.put(DESCRIBE,"Grillowana na ogniu wołowina w najlepszym wydaniu. WHOPPER® skutecznie broni swojej dominującej pozycji na listach najlepszych burgerów od 1957 roku..");
//            JSONObject price6 = new JSONObject();
//            price6.put("Price1",7.25);
//            jsonObject6.put(PRICE,price6);
//            jsonObject6.put(TIME,3L);
//            jsonObject6.put(PHOTO,parseFile[5]);
//            jsonObject6.put(TASTE,null);
//
////            jsonObject7.put(TITLE,"Sałatka grecka");
////            jsonObject7.put(SIZE,null);
////            jsonObject7.put(DESCRIBE,"Tradycyjne greckie smaki na Twoim talerzu. Sałatkę grecką przyrządzamy wyłącznie z wyselekcjonowanych, świeżych składników. Pięć rożnych rodzajów sałat z najlepszych polskich upraw, do tego kostki słonego sera, dorodne czerwone pomidory, chrupiąca żółta papryka, świeży ogórek, [...].");
////            JSONObject price7 = new JSONObject();
////            price7.put("Price1",11.95);
////            jsonObject7.put(PRICE,price7);
////            jsonObject7.put(TIME,3L);
////            jsonObject7.put(PHOTO,parseFile[6]);
////            jsonObject7.put(TASTE,null);
//
//
//            jsonArray.put(jsonObject);
//            jsonArray.put(jsonObject2);
//            jsonArray.put(jsonObject3);
//            jsonArray.put(jsonObject4);
//            jsonArray.put(jsonObject5);
//            jsonArray.put(jsonObject6);
//            jsonArray.put(jsonObject7);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

//        restaurants.setDetailsOfRestaurant(jsonArray);
//        restaurants.saveInBackground();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == REQUEST_CODE){
            changeActivityToMain();
        }
    }

    private void changeActivityToMain() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void createAccount(View view) {
        Intent intent = new Intent(this,Sign_up_Activity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void loginClick(View view) {
        String email = emailView.getText().toString();
        String password = passView.getText().toString();
        boolean flagCorrectData = true;


        if(TextUtils.isEmpty(email)){
            emailView.setError("Please enter email.");
            flagCorrectData = false;
        }
        if(TextUtils.isEmpty(password)){
            passView.setError("Please enter password.");
            flagCorrectData = false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailView.setError("Email is incorrect.");
            flagCorrectData = false;
        }

        if(flagCorrectData) {
            logIn(email, password);
        }
    }

    private void logIn(String email, String password) {
        ParseUser.logInInBackground(email, password, new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (parseUser != null) {
                    changeActivityToMain();
                } else {
                    Toast.makeText(getApplicationContext(), e.getLocalizedMessage() , Toast.LENGTH_SHORT).show();
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });

    }
}
