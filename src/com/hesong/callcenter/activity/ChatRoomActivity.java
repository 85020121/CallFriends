package com.hesong.callcenter.activity;

import org.pjsip.pjsua2.CallInfo;
import org.pjsip.pjsua2.CallOpParam;
import org.pjsip.pjsua2.pjsip_status_code;

import com.hesong.callcenter.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.ImageView;

public class ChatRoomActivity extends Activity {


    public int height;
    public int width;
    //Bitmap mBitmap;
    //BitmapDrawable mDrawable;
    
    private static CallInfo lastCallInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_room);

        intializeScreenSize();
        
        Bundle bundle = getIntent().getExtras();
        ((ImageView) findViewById(R.id.friendPicture)).setImageResource(0x7f020019);//bundle.getInt("friendImage"));
                

        /*RelativeLayout layout = (RelativeLayout) findViewById(R.id.chartLayout);
        mBitmap = MainActivity.decodeSampledBitmapFromResource(getResources(),
                R.drawable.calling_freinds_bkgrd, width, height);
        mDrawable = new BitmapDrawable(getResources(), mBitmap);*/
        //layout.setBackgroundDrawable(mDrawable);

        // Set up the intent filter. This will be used to fire an
        // IncomingCallReceiver when someone calls the SIP address used by this
        // application.

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Button callButton = (Button) findViewById(R.id.button1);
        callButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // try {
                // sipCall.endCall();
                // } catch (SipException e) {
                Log.i("ChatRoomActivity/onClick", "Hung up");
                // "Error ending call.", e);
                // }
                onBackPressed();
//                Intent intent = new Intent(ChatRoomActivity.this, FriendsGridActivity.class);
//                startActivity(intent);
            }
        });

        if (FriendsGridActivity.currentCall != null) {
            try {
                acceptCall();
                lastCallInfo = FriendsGridActivity.currentCall.getInfo();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void acceptCall() {
        CallOpParam prm = new CallOpParam();
        prm.setStatusCode(pjsip_status_code.PJSIP_SC_OK);
        try {
            FriendsGridActivity.currentCall.answer(prm);
            Log.i("acceptCall", "acceptCall");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void onStart() {
        super.onStart();
        // When we get back from the preference setting Activity, assume
        // settings have changed, and re-login with new auth info.
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hangupCall();
    }

    /**
     * Updates the status box at the top of the UI with a messege of your
     * choice.
     * 
     * @param status
     *            The String to display in the status box.
     */
    public void updateStatus(final String status) {
        // Be a good citizen. Make sure UI changes fire on the UI thread.
        this.runOnUiThread(new Runnable() {
            public void run() {
            }
        });
    }



    public void updatePreferences() {
        Intent settingsActivity = new Intent(getBaseContext(),
                SipSettings.class);
        startActivity(settingsActivity);
    }

    public void intializeScreenSize() {

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        height = displaymetrics.heightPixels;
        width = displaymetrics.widthPixels;
    }
    
    public void hangupCall() {
        finish();
        
        if (FriendsGridActivity.currentCall != null) {
            CallOpParam prm = new CallOpParam();
            prm.setStatusCode(pjsip_status_code.PJSIP_SC_DECLINE);
            try {
                FriendsGridActivity.currentCall.hangup(prm);
            } catch (Exception e) {
                System.out.println(e);
            }

            FriendsGridActivity.currentCall = null;
        }
    }

}
