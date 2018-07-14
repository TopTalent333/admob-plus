package admob.suite;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.ads.MobileAds;

import admob.suite.banner.BannerExecutor;
import admob.suite.interstitial.InterstitialExecutor;
import admob.suite.rewardvideo.RewardVideoExecutor;

public class AdMob extends CordovaPlugin {
    private CallbackContext readyCallbackContext = null;

    private BannerExecutor bannerExecutor = null;
    private InterstitialExecutor interstitialExecutor = null;
    private RewardVideoExecutor rewardVideoExecutor = null;

    private static final String TEST_APPLICATION_ID = "ca-app-pub-3940256099942544~3347511713";

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        String applicationID = cordova.getActivity().getIntent().getStringExtra("ADMOB_APPLICATOIN_ID");
        if (applicationID == null || "test".equals(applicationID)) {
            applicationID = TEST_APPLICATION_ID;
        }
        MobileAds.initialize(cordova.getActivity(), applicationID);

        interstitialExecutor = new InterstitialExecutor(this);
        bannerExecutor = new BannerExecutor(this);
        rewardVideoExecutor = new RewardVideoExecutor(this);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        if (Actions.READY.equals(action)) {
            readyCallbackContext = callbackContext;

            emit(Events.READY, "android");
            return true;
        } else if (Actions.BANNER_SHOW.equals(action)) {
            return bannerExecutor.show(args, callbackContext);
        } else if (Actions.INTERSTITIAL_LOAD.equals(action)) {
            return interstitialExecutor.load(args, callbackContext);
        } else if (Actions.INTERSTITIAL_SHOW.equals(action)) {
            return interstitialExecutor.show(args, callbackContext);
        }

        return false;
    }

    @Override
    public void onDestroy() {
        if (bannerExecutor != null) {
            bannerExecutor.destroy();
            bannerExecutor = null;
        }

        if (interstitialExecutor != null) {
            interstitialExecutor.destroy();
            interstitialExecutor = null;
        }

        readyCallbackContext = null;

        super.onDestroy();
    }

    public void emit(String eventType) {
        emit(eventType, false);
    }

    public void emit(String eventType, Object data) {
        JSONObject event = new JSONObject();
        try {
            event.put("type", eventType);
            event.put("data", data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        PluginResult result = new PluginResult(PluginResult.Status.OK, event);
        result.setKeepCallback(true);
        readyCallbackContext.sendPluginResult(result);
    }
}