package com.hesong.callcenter.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pjsip.pjsua2.AccountConfig;
import org.pjsip.pjsua2.AuthCredInfo;
import org.pjsip.pjsua2.AuthCredInfoVector;
import org.pjsip.pjsua2.BuddyConfig;
import org.pjsip.pjsua2.CallInfo;
import org.pjsip.pjsua2.CallOpParam;
import org.pjsip.pjsua2.StringVector;
import org.pjsip.pjsua2.pjsip_inv_state;
import org.pjsip.pjsua2.pjsip_status_code;

import com.hesong.callcenter.R;
import com.hesong.callcenter.util.MoveBg;
import com.hesong.callcenter.util.Util;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class FriendsGridActivity extends Activity implements Handler.Callback,
        MyAppObserver {

    private static List<Map<String, Object>> OnlineFriends;
    private static List<Map<String, Object>> OfflineFriends;

    public static PJSipApp sipApp = null;
    public static MyCall currentCall = null;
    public static MyAccount account = null;
    public static AccountConfig accCfg = null;

    private final static String SIP_HOST = "119.38.132.76";

    private final Handler handler = new Handler(this);

    public class MSG_TYPE {
        public final static int INCOMING_CALL = 1;
        public final static int CALL_STATE = 2;
        public final static int REG_STATE = 3;
        public final static int BUDDY_STATE = 4;
    }

    // Friends list
    static {
        OnlineFriends = new ArrayList<Map<String, Object>>();
        OfflineFriends = new ArrayList<Map<String, Object>>();

        Map<String, Object> onlineOne = new HashMap<String, Object>();
        onlineOne.put("friendImage", R.drawable.pic1);
        onlineOne.put("friendName", "老王");
        // onlineOne.put("state", 1);
        onlineOne.put("sipAddress", "sip:3888878866666@" + SIP_HOST);
        OnlineFriends.add(onlineOne);

        Map<String, Object> onlineTwo = new HashMap<String, Object>();
        onlineTwo.put("friendImage", R.drawable.pic5);
        onlineTwo.put("friendName", "明明");
        // offlineOne.put("state", 0);
        onlineTwo.put("sipAddress", "sip:3888878812345678@119.38.132.76");
        OnlineFriends.add(onlineTwo);

        Map<String, Object> onlineThree = new HashMap<String, Object>();
        onlineThree.put("friendImage", R.drawable.pic6);
        onlineThree.put("friendName", "表妹");
        // onlineOne.put("state", 1);
        onlineThree.put("sipAddress", "sip:38888788123123@119.38.132.76");
        OnlineFriends.add(onlineThree);

        Map<String, Object> offlineOne = new HashMap<String, Object>();
        offlineOne.put("friendImage", R.drawable.pic_gray2);
        offlineOne.put("friendName", "蒙蒙");
        // offlineOne.put("state", 0);
        offlineOne.put("sipAddress", "388887882638@119.38.132.76");
        OfflineFriends.add(offlineOne);

        Map<String, Object> offlineTwo = new HashMap<String, Object>();
        offlineTwo.put("friendImage", R.drawable.pic_gray_3);
        offlineTwo.put("friendName", "老张");
        // offlineOne.put("state", 0);
        offlineTwo.put("sipAddress", "388887882638@119.38.132.76");
        OfflineFriends.add(offlineTwo);

        Map<String, Object> offlineThree = new HashMap<String, Object>();
        offlineThree.put("friendImage", R.drawable.pic_gray_4);
        offlineThree.put("friendName", "舅舅");
        // offlineOne.put("state", 0);
        offlineThree.put("sipAddress", "388887882638@119.38.132.76");
        OfflineFriends.add(offlineThree);

    }

    public int height;
    public int width;
    Bitmap mBitmap;
    BitmapDrawable mDrawable;
    private TextView currentText;
    private int startX;// 移动的起始位置

    @SuppressWarnings("deprecation")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends_grid);
        GridView gridview = (GridView) findViewById(R.id.friendsGrid);

        intializeScreenSize();

        LinearLayout layout = (LinearLayout) findViewById(R.id.freindsGridLayout);
        mBitmap = Util.decodeSampledBitmapFromResource(getResources(),
                R.drawable.call_freinds_background, width, height);
        mDrawable = new BitmapDrawable(getResources(), mBitmap);
        layout.setBackgroundDrawable(mDrawable);

        // PJ sip begin
        if (sipApp == null) {
            sipApp = new PJSipApp();
            /* Wait for GDB to init */
            if ((getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
            }
            sipApp.init(this, getFilesDir().getAbsolutePath());
        }

        String acc_id = "sip:38888788123123@" + SIP_HOST;
        String username = "38888788123123";
        String registrar = "sip:" + SIP_HOST;
        String password = "hesong";

        accCfg = new AccountConfig();
        accCfg.setIdUri(acc_id);
        accCfg.getNatConfig().setIceEnabled(false);

        accCfg.setIdUri(acc_id);
        accCfg.getRegConfig().setRegistrarUri(registrar);
        accCfg.getRegConfig().setTimeoutSec(120);
        accCfg.getRegConfig().setRetryIntervalSec(60);

        AuthCredInfoVector creds = accCfg.getSipConfig().getAuthCreds();
        creds.clear();
        creds.add(new AuthCredInfo("Digest", "*", username, 0, password));
        StringVector proxies = accCfg.getSipConfig().getProxies();
        proxies.clear();
        account = sipApp.addAcc(accCfg);
        // PJ sip end

        final Button onlineButton = (Button) findViewById(R.id.onlineFriendsButton);
        final Button offlineButton = (Button) findViewById(R.id.offlineFriendsButton);

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                case R.id.onlineFriendsButton:
                    Log.i("buttonListener", "onlineFriendsButton");
                    SimpleAdapter olImageItems = new SimpleAdapter(
                            FriendsGridActivity.this, OnlineFriends,
                            R.layout.friend_item, new String[] { "friendImage",
                                    "friendName" }, new int[] {
                                    R.id.friendImage, R.id.friendName });
                    ((GridView) findViewById(R.id.friendsGrid))
                            .setAdapter(olImageItems);
                    onlineButton.setTextColor(Color.parseColor("#ea5404"));
                    offlineButton.setTextColor(Color.parseColor("#FFFFFF"));
                    moveFrontBg(FriendsGridActivity.this.getResources()
                            .getString(R.string.onlineFriends), 0);
                    break;
                case R.id.offlineFriendsButton:
                    Log.i("buttonListener", "offlineFriendsButton");
                    SimpleAdapter ofImageItems = new SimpleAdapter(
                            FriendsGridActivity.this, OfflineFriends,
                            R.layout.friend_item, new String[] { "friendImage",
                                    "friendName" }, new int[] {
                                    R.id.friendImage, R.id.friendName });
                    ((GridView) findViewById(R.id.friendsGrid))
                            .setAdapter(ofImageItems);
                    onlineButton.setTextColor(Color.parseColor("#FFFFFF"));
                    offlineButton.setTextColor(Color.parseColor("#ea5404"));
                    moveFrontBg(FriendsGridActivity.this.getResources()
                            .getString(R.string.offlineFriends), Util.dip2px(
                            FriendsGridActivity.this, 181));
                    break;
                default:
                    break;
                }

            }
        };

        onlineButton.setOnClickListener(buttonListener);
        offlineButton.setOnClickListener(buttonListener);

        SimpleAdapter saImageItems = new SimpleAdapter(this, OnlineFriends,
                R.layout.friend_item, new String[] { "friendImage",
                        "friendName" }, new int[] { R.id.friendImage,
                        R.id.friendName });
        gridview.setAdapter(saImageItems);
        gridview.setOnItemClickListener(new ItemClickListener());

        currentText = new TextView(this);
        currentText.setGravity(Gravity.CENTER);
        currentText.setText("亲人通讯录");
        currentText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        currentText.setTextColor(Color.parseColor("#FFFFFF"));
        currentText.setBackgroundColor(Color.parseColor("#faa800"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                Util.dip2px(this, 180), Util.dip2px(this, 50));
        ((RelativeLayout) findViewById(R.id.switchPanel)).addView(currentText,
                layoutParams);
        MoveBg.moveFrontBg(currentText, 0, 0, 0, 0);
        startX = 0;
    }

    class ItemClickListener implements OnItemClickListener {
        public void onItemClick(AdapterView<?> arg0,// The AdapterView where the
                                                    // click happened
                View arg1,// The view within the AdapterView that was clicked
                int arg2,// The position of the view in the adapter
                long arg3// The row id of the item that was clicked
        ) {
            @SuppressWarnings("unchecked")
            HashMap<String, Object> item = (HashMap<String, Object>) arg0
                    .getItemAtPosition(arg2);

            BuddyConfig cfg = new BuddyConfig();
            cfg.setUri((String) item.get("sipAddress"));
            cfg.setSubscribe(false);
            account.addBuddy(cfg);

            Intent callingIntent = new Intent(FriendsGridActivity.this,
                    CallingFriendActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("friendName", (String) item.get("friendName"));
            bundle.putInt("friendImage", (Integer) item.get("friendImage"));
            bundle.putString("sipAddress", (String) item.get("sipAddress"));
            callingIntent.putExtras(bundle);
            startActivity(callingIntent);
        }

    }

    private void moveFrontBg(final String text, int width) {
        MoveBg.moveFrontBg(currentText, startX, width, 0, 0);
        startX = width;
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                currentText.setText(text);
            }
        }, 200);
    }

    public void intializeScreenSize() {

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        height = displaymetrics.heightPixels;
        width = displaymetrics.widthPixels;
    }

    @Override
    public void notifyRegState(pjsip_status_code code, String reason,
            int expiration) {
        // TODO Auto-generated method stub

    }

    @Override
    public void notifyIncomingCall(MyCall call) {
        Log.i("notifyIncomingCall", "in");
        Message m = Message.obtain(handler, MSG_TYPE.INCOMING_CALL, call);
        m.sendToTarget();
    }

    @Override
    public void notifyCallState(MyCall call) {
        if (currentCall == null || call.getId() != currentCall.getId())
            return;
        
        CallInfo ci;
        try {
            ci = call.getInfo();
        } catch (Exception e) {
            ci = null;
        }
        Message m = Message.obtain(handler, MSG_TYPE.CALL_STATE, ci);
        m.sendToTarget();

    }

    @Override
    public void notifyBuddyState(MyBuddy buddy) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean handleMessage(Message m) {
        if (m.what == 0) {

            sipApp.deinit();
            finish();
            Runtime.getRuntime().gc();
            android.os.Process.killProcess(android.os.Process.myPid());

        } else if (m.what == MSG_TYPE.CALL_STATE) {

            CallInfo ci = (CallInfo) m.obj;

            /* Forward the message to CallActivity */
            if (CallingFriendActivity.handler_ != null) {
                Message m2 = Message.obtain(CallingFriendActivity.handler_,
                        MSG_TYPE.CALL_STATE, ci);
                m2.sendToTarget();
            }

            if (ci.getState() == pjsip_inv_state.PJSIP_INV_STATE_DISCONNECTED)
                currentCall = null;

        }  else if (m.what == MSG_TYPE.INCOMING_CALL) {

            /* Incoming call */
            Log.i("handleMessage", "Incoming call");
            final MyCall call = (MyCall) m.obj;
            CallOpParam prm = new CallOpParam();

            /* Only one call at anytime */
            if (currentCall != null) {
                Log.i("Busy call", "Busy");
                prm.setStatusCode(pjsip_status_code.PJSIP_SC_BUSY_HERE);
                try {
                    call.hangup(prm);
                } catch (Exception e) {
                }
                return true;
            }

            /* Answer with ringing */
            prm.setStatusCode(pjsip_status_code.PJSIP_SC_RINGING);
            try {
                call.answer(prm);
                Log.i("Answer call", "Answer");
            } catch (Exception e) {
            }

            currentCall = call;
            answerCall();
        } else {

            /* Message not handled */
            return false;

        }

        return true;
    }
    
    private void answerCall() {
        Intent intent = new Intent(this, ChatRoomActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
