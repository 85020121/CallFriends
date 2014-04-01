package com.hesong.callcenter.activity;

import org.pjsip.pjsua2.CallInfo;
import org.pjsip.pjsua2.CallOpParam;
import org.pjsip.pjsua2.CallSetting;
import org.pjsip.pjsua2.pjsip_inv_state;
import org.pjsip.pjsua2.pjsip_role_e;
import org.pjsip.pjsua2.pjsip_status_code;

import com.hesong.callcenter.R;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;

public class CallingFriendActivity extends Activity implements Handler.Callback {

    public String sipAddress = null;
    
    public static Handler handler_;

    private final Handler handler = new Handler(this);
    
    private static CallInfo lastCallInfo;

    public int height;
    public int width;
    //Bitmap mBitmap;
    //BitmapDrawable mDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_layout);

        intializeScreenSize();

        /*RelativeLayout layout = (RelativeLayout) findViewById(R.id.chartLayout);
        mBitmap = MainActivity.decodeSampledBitmapFromResource(getResources(),
                R.drawable.calling_freinds, width, height);
        mDrawable = new BitmapDrawable(getResources(), mBitmap);*/
        //layout.setBackgroundDrawable(mDrawable);

        // Set up the intent filter. This will be used to fire an
        // IncomingCallReceiver when someone calls the SIP address used by this
        // application.

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Bundle bundle = getIntent().getExtras();
        sipAddress = bundle.getString("sipAddress");

        ((ImageView) findViewById(R.id.friendChatPhoto)).setImageResource(bundle
                .getInt("friendImage"));
        ((TextView) findViewById(R.id.callingToName)).setText(bundle
                .getString("friendName"));


        MyCall call = new MyCall(FriendsGridActivity.account, -1);
        CallOpParam prm = new CallOpParam();
        CallSetting opt = prm.getOpt();
        opt.setAudioCount(1);
        opt.setVideoCount(0);
        
        try {
            Log.i("CallingFriendActivity/MakeCall","Making call to "+sipAddress);
            call.makeCall(sipAddress, prm);
            
        } catch (Exception e) {
            call = null;
            return;
        }
        
        FriendsGridActivity.currentCall = call;
        
        if (FriendsGridActivity.currentCall != null) {
            try {
                lastCallInfo = FriendsGridActivity.currentCall.getInfo();
                updateCallState(lastCallInfo);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            updateCallState(lastCallInfo);
        }


    }

    @Override
    public void onStart() {
        super.onStart();
        // When we get back from the preference setting Activity, assume
        // settings have changed, and re-login with new auth info.
//        Handler handler = new Handler(); 
//        handler.postDelayed(new Runnable() { 
//             public void run() { 
//                 Intent i = new Intent(CallingFriendActivity.this, ChatRoomActivity.class);
//                 i.putExtras(bundle);
//                 startActivity(i);
//                 finish();
//             } 
//        }, 3000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hungUp();
    }

    private void updateCallState(CallInfo ci) {
        
        String call_state = "";
        Log.i("updateCallState", ci.getStateText());
        if (ci.getRole() == pjsip_role_e.PJSIP_ROLE_UAC) {
        }
                
        if (ci.getState().swigValue() < pjsip_inv_state.PJSIP_INV_STATE_CONFIRMED.swigValue())
        {
            if (ci.getRole() == pjsip_role_e.PJSIP_ROLE_UAS) {
                call_state = "Incoming call..";
                Log.i("updateCallState/incoming", call_state);
                /* Default button texts are already 'Accept' & 'Reject' */
            } else {
                call_state = ci.getStateText();
            }
        }
        else if (ci.getState().swigValue() >= pjsip_inv_state.PJSIP_INV_STATE_CONFIRMED.swigValue())
        {
            call_state = ci.getStateText();
            Log.i("updateCallState/comfirmed", call_state);
            if (ci.getState() == pjsip_inv_state.PJSIP_INV_STATE_CONFIRMED) {
            } else if (ci.getState() == pjsip_inv_state.PJSIP_INV_STATE_DISCONNECTED) {
                call_state = "Call disconnected: " + ci.getLastReason();
                Log.i("updateCallState/disconnected", call_state);
                FriendsGridActivity.currentCall = null;
            }
        }
        
    }


    public void intializeScreenSize() {

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        height = displaymetrics.heightPixels;
        width = displaymetrics.widthPixels;
    }

    @Override
    public boolean handleMessage(Message msg) {
        if (msg.what == FriendsGridActivity.MSG_TYPE.CALL_STATE) {

            lastCallInfo = (CallInfo) msg.obj;
            updateCallState(lastCallInfo);

        } else {

            /* Message not handled */
            return false;

        }

        return true;
    }
    
    public void hungUp() {
        if (FriendsGridActivity.currentCall != null) {
            CallOpParam prm = new CallOpParam();
            prm.setStatusCode(pjsip_status_code.PJSIP_SC_DECLINE);
            try {
                FriendsGridActivity.currentCall.hangup(prm);
                Log.i("CallingFriendsActivity", "Hangup call.");
            } catch (Exception e) {
                System.out.println(e);
            }
            
            FriendsGridActivity.currentCall.delete();

            FriendsGridActivity.currentCall = null;
            
        }
    }

}
