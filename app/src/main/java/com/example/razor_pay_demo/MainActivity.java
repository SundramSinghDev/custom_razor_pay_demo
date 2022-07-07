package com.example.razor_pay_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.razor_pay_demo.databinding.FragmentPaymentMethodCardBinding;
import com.example.razor_pay_demo.model.Example;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.razorpay.PaymentMethodsCallback;
import com.razorpay.PaymentResultListener;
import com.razorpay.Razorpay;
import com.razorpay.ValidationListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements PaymentResultListener {

    private FrameLayout frameLayout;
    private ListView listView;
    ArrayList<String> banksCodesList = new ArrayList<>();
    private ArrayList<String> banksList = new ArrayList<>();
    private ArrayList<String> walletsList = new ArrayList<>();
    private ArrayAdapter banksListAdapter;
    private ArrayAdapter walletsListAdapter;
    private Razorpay razorpay;
    private WebView webview;
    private ViewGroup outerBox;
    private static final String TAG = MainActivity.class.getSimpleName();
    private JSONObject payload;
    FragmentPaymentMethodCardBinding cardBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_options);
        findViewById(R.id.card).setOnClickListener(view -> onCardSelected());
        findViewById(R.id.upi).setOnClickListener(view -> onUPIButtonClicked());
        findViewById(R.id.netbanking).setOnClickListener(view -> onNetBankingClicked());
        findViewById(R.id.wallet).setOnClickListener(view -> onWalletClicked());

        webview = (WebView) findViewById(R.id.payment_webview);
        frameLayout = (FrameLayout) findViewById(R.id.frame);
        outerBox = (ViewGroup) findViewById(R.id.outerbox);

        LayoutInflater.from(MainActivity.this).inflate(R.layout.fragment_payment_method_card,
                frameLayout, true);
        banksListAdapter = new ArrayAdapter<String>(this, R.layout.text_view_list_banks_wallet, banksList);
        walletsListAdapter = new ArrayAdapter<String>(this, R.layout.text_view_list_banks_wallet, walletsList);
        initRazorPay();
        createWebView();
    }

    private void initRazorPay() {
        try {
            razorpay = new Razorpay(MainActivity.this, Constants.RZR_API_KEY);

            razorpay.getPaymentMethods(new PaymentMethodsCallback() {
                @Override
                public void onPaymentMethodsReceived(String result) {
                    inflateLists(result);
                }

                @Override
                public void onError(String error) {
                    Log.e(TAG, "onError: " + error);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inflateLists(String result) {
        try {
            JSONObject paymentMethods = new JSONObject(result);
            JSONObject banksListJSON = paymentMethods.getJSONObject("netbanking");
            JSONObject walletListJSON = paymentMethods.getJSONObject("wallet");

            Iterator<String> itr1 = banksListJSON.keys();
            while (itr1.hasNext()) {
                String key = itr1.next();
                banksCodesList.add(key);
                try {
                    banksList.add(banksListJSON.getString(key));
                } catch (JSONException e) {
                    Log.d("Reading Banks List", "" + e.getMessage());
                }
            }

            Iterator<String> itr2 = walletListJSON.keys();
            while (itr2.hasNext()) {
                String key = itr2.next();
                try {
                    if (walletListJSON.getBoolean(key)) {
                        walletsList.add(key);
                    }
                } catch (JSONException e) {
                    Log.d("Reading Wallets List", "" + e.getMessage());
                }
            }

            if (banksListAdapter != null) {
                banksListAdapter.notifyDataSetChanged();
            }

            if (walletsListAdapter != null) {
                walletsListAdapter.notifyDataSetChanged();
            }

        } catch (Exception e) {
            Log.e("Parsing Result", "" + e.getMessage());
        }
    }

    private void createWebView() {
        /**
         * You need to pass the webview to Razorpay
         */
        razorpay.setWebView(webview);

        /**
         * Override the RazorpayWebViewClient for your custom hooks
         */
        /*razorpay.setWebviewClient(new RazorpayWebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.d(TAG, "Custom client onPageStarted");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.d(TAG, "Custom client onPageFinished");
            }
        });*/
    }

    public void SubmitCardDetails() {
        String name = cardBinding.name.getText().toString();

        String cardNumber = cardBinding.cardNumber.getText().toString();

        String date = cardBinding.expiry.getText().toString();
        int index = date.indexOf('/');
        String month = date.substring(0, index);
        String year = date.substring(index + 1);

        String cvv = cardBinding.cvv.getText().toString();

        try {
            payload = new JSONObject("{currency: 'INR'}");
            payload.put("amount", "100");
            payload.put("contact", "9999999999");
            payload.put("email", "customer@name.com");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            payload.put("method", "card");
            payload.put("card[name]", name);
            payload.put("card[number]", cardNumber);
            payload.put("card[expiry_month]", month);
            payload.put("card[expiry_year]", year);
            payload.put("card[cvv]", cvv);
            sendRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public class SubmitUPICollectRequest implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText vpaET = (EditText) findViewById(R.id.vpa);
            String vpa = vpaET.getText().toString();

            try {
                payload = new JSONObject("{currency: 'INR'}");
                payload.put("amount", "100");
                payload.put("contact", "9999999999");
                payload.put("email", "customer@name.com");
            } catch (Exception e) {
                e.printStackTrace();
            }


            try {
                payload.put("method", "upi");
                payload.put("vpa", vpa);

                sendRequest();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class SubmitUPIIntentDetails implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText vpaET = (EditText) findViewById(R.id.vpa);
            String vpa = vpaET.getText().toString();

            try {
                payload = new JSONObject("{currency: 'INR'}");
                payload.put("amount", "111");
                payload.put("contact", "9999999999");
                payload.put("email", "customer@name.com");
                //payload.put("upi_app_package_name", "com.google.android.apps.nbu.paisa.user");
                payload.put("display_logo", true);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                JSONArray jArray = new JSONArray();
                jArray.put("in.org.npci.upiapp");
                jArray.put("com.snapwork.hdfc");
                payload.put("description", "Credits towards consultation");
                //payload.put("key_id","rzp_test_kEVtCVFWAjUQPG");
                payload.put("method", "upi");
                payload.put("_[flow]", "intent");
                payload.put("preferred_apps_order", jArray);
                payload.put("other_apps_order", jArray);
                sendRequest();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void submitNetbankingDetails(String bankName) {

        try {
            payload = new JSONObject("{currency: 'INR'}");
            payload.put("amount", "100");
            payload.put("contact", "9999999999");
            payload.put("email", "customer@name.com");
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            payload.put("method", "netbanking");
            payload.put("bank", bankName);
            sendRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void submitWalletDetails(String walletName) {


        try {
            payload = new JSONObject("{currency: 'INR'}");
            payload.put("amount", "100");
            payload.put("contact", "9999999999");
            payload.put("email", "customer@name.com");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            payload.put("method", "wallet");
            payload.put("wallet", walletName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sendRequest();
    }

    private void sendRequest() {
        razorpay.validateFields(payload, new ValidationListener() {
            @Override
            public void onValidationSuccess() {
                try {
                    webview.setVisibility(View.VISIBLE);
                    outerBox.setVisibility(View.GONE);
                    razorpay.submit(payload, MainActivity.this);
                } catch (Exception e) {
                    Log.e("com.example", "Exception: ", e);
                }
            }

            @Override
            public void onValidationError(Map<String, String> error) {
                Log.d("com.example", "Validation failed: " + error.get("field") + " " + error.get("description"));
                Toast.makeText(MainActivity.this, "Validation: " + error.get("field") + " " + error.get("description"), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        razorpay.onBackPressed();
        super.onBackPressed();
        webview.setVisibility(View.GONE);
        outerBox.setVisibility(View.VISIBLE);
    }

    /* callback for permission requested from android */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (razorpay != null) {
            razorpay.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    /**
     * Is called if the payment was successful
     * You can now destroy the webview
     */
    @Override
    public void onPaymentSuccess(String razorpayPaymentId) {
        webview.setVisibility(View.GONE);
        outerBox.setVisibility(View.VISIBLE);
        Toast.makeText(MainActivity.this, "Payment Successful: " + razorpayPaymentId, Toast.LENGTH_SHORT).show();
    }

    /**
     * Is called if the payment failed
     * possible values for code in this sdk are:
     * 2: in case of network error
     * 4: response parsing error
     * 5: This will contain meaningful message and can be shown to user
     * Format: {"error": {"description": "Expiry year should be greater than current year"}}
     */
    @Override
    public void onPaymentError(int errorCode, String errorDescription) {
        webview.setVisibility(View.GONE);
        outerBox.setVisibility(View.VISIBLE);
        Toast.makeText(MainActivity.this, "Error " + Integer.toString(errorCode) + ": " + errorDescription, Toast.LENGTH_SHORT).show();
        Log.d("com.example", "onError: " + Integer.toString(errorCode) + ": " + errorDescription);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        razorpay.onActivityResult(requestCode, resultCode, data);
    }

    private void onCardSelected() {
        frameLayout.removeAllViews();
        cardBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_payment_method_card, null, true);
        cardBinding.submitCardDetails.setOnClickListener(view1 -> {
            Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            SubmitCardDetails();
        });
        frameLayout.addView(cardBinding.getRoot());
    }

    private void onUPIButtonClicked() {
        frameLayout.removeAllViews();
        LayoutInflater.from(MainActivity.this).inflate(R.layout.fragment_payment_method_upi, frameLayout, true);
        findViewById(R.id.btn_upi_collect_req).setOnClickListener(new SubmitUPICollectRequest());
        findViewById(R.id.btn_upi_intent_flow).setOnClickListener(new SubmitUPIIntentDetails());
    }

    private void onNetBankingClicked() {
        frameLayout.removeAllViews();
        LayoutInflater.from(MainActivity.this).inflate(R.layout.fragment_method_netbanking_wallet_list, frameLayout, true);
        listView = (ListView) findViewById(R.id.method_available_options_list);
        listView.setAdapter(banksListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                submitNetbankingDetails(banksCodesList.get(position));
            }
        });
    }

    private void onWalletClicked() {
        frameLayout.removeAllViews();
        LayoutInflater.from(MainActivity.this).inflate(R.layout.fragment_method_netbanking_wallet_list, frameLayout, true);
        listView = (ListView) findViewById(R.id.method_available_options_list);
        listView.setAdapter(walletsListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                submitWalletDetails(walletsList.get(position));
            }
        });
    }
}