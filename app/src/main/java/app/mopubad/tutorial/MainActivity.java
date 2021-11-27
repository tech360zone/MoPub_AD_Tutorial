package app.mopubad.tutorial;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubView;

import app.mopubad.tutorial.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MoPubInterstitial.InterstitialAdListener {

    private final String BANNER_AD_ID = "b195f8dd8ded45fe847ad89ed1d016da";
    private final String INTERSTITIAL_AD_ID = "24534e1901884e398f1253216226017e";
    ActivityMainBinding binding;
    private MoPubView moPubView;
    private MoPubInterstitial mInterstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SdkConfiguration.Builder sdkConfig = new SdkConfiguration.Builder(BANNER_AD_ID);
        MoPub.initializeSdk(this, sdkConfig.build(), initSdkListener());
        mInterstitial = new MoPubInterstitial(this, INTERSTITIAL_AD_ID);
        mInterstitial.setInterstitialAdListener(this);

        binding.showInterstitialAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitial != null && mInterstitial.isReady()) {
                    mInterstitial.show();
                } else {
                    Toast.makeText(getApplicationContext(), "Not available.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private SdkInitializationListener initSdkListener() {
        return new SdkInitializationListener() {
            @Override
            public void onInitializationFinished() {
                loadBannerAd();
                mInterstitial.load();
            }
        };
    }

    private void loadBannerAd() {
        moPubView = (MoPubView) findViewById(R.id.moPubBannerView);
        moPubView.setAdUnitId(BANNER_AD_ID);
        moPubView.setAdSize(MoPubView.MoPubAdSize.HEIGHT_90);
        moPubView.loadAd();
    }

    @Override
    public void onInterstitialLoaded(MoPubInterstitial moPubInterstitial) {

    }

    @Override
    public void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode) {

    }

    @Override
    public void onInterstitialShown(MoPubInterstitial moPubInterstitial) {

    }

    @Override
    public void onInterstitialClicked(MoPubInterstitial moPubInterstitial) {

    }

    @Override
    public void onInterstitialDismissed(MoPubInterstitial moPubInterstitial) {
        moPubInterstitial.load();
    }
}