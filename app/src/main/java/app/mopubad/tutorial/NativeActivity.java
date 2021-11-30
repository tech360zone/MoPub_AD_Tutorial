package app.mopubad.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.nativeads.MoPubNative;
import com.mopub.nativeads.MoPubStaticNativeAdRenderer;
import com.mopub.nativeads.NativeAd;
import com.mopub.nativeads.NativeErrorCode;
import com.mopub.nativeads.ViewBinder;

import app.mopubad.tutorial.databinding.ActivityNativeBinding;

public class NativeActivity extends AppCompatActivity {

    private ActivityNativeBinding binding;
    private final String NATIVE_AD_UNIT_ID = "11a17b188668469fb0412708c3d16813";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNativeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SdkConfiguration.Builder builder = new SdkConfiguration.Builder(NATIVE_AD_UNIT_ID);
        builder.withLogLevel(MoPubLog.LogLevel.DEBUG);
        MoPub.initializeSdk(this, builder.build(), new SdkInitializationListener() {
            @Override
            public void onInitializationFinished() {
                loadNativeAd();
            }
        });
    }

    private void loadNativeAd() {
        ViewBinder viewBinder = new ViewBinder.Builder(R.layout.native_ad_layout)
                .mainImageId(R.id.native_main_image)
                .iconImageId(R.id.native_icon_image)
                .titleId(R.id.native_title)
                .textId(R.id.native_text)
                .callToActionId(R.id.native_cta)
                .privacyInformationIconImageId(R.id.native_privacy_information_icon_image)
                .build();
        MoPubStaticNativeAdRenderer adRenderer = new MoPubStaticNativeAdRenderer(viewBinder);
        MoPubNative moPubNative = new MoPubNative(this, NATIVE_AD_UNIT_ID, new MoPubNative.MoPubNativeNetworkListener() {
            @Override
            public void onNativeLoad(NativeAd nativeAd) {
                binding.nativeAdLayout.removeAllViews();
                binding.nativeAdLayout.addView(nativeAd.createAdView(NativeActivity.this, binding.getRoot()));
                nativeAd.getMoPubAdRenderer().renderAdView(binding.nativeAdLayout, nativeAd.getBaseNativeAd());
            }

            @Override
            public void onNativeFail(NativeErrorCode nativeErrorCode) {

            }
        });
        moPubNative.registerAdRenderer(adRenderer);
        moPubNative.makeRequest();
    }
}