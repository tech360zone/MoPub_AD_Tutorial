package app.mopubad.tutorial.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import com.mopub.nativeads.MoPubRecyclerAdapter;
import com.mopub.nativeads.MoPubStaticNativeAdRenderer;
import com.mopub.nativeads.ViewBinder;

import java.util.ArrayList;
import java.util.List;

import app.mopubad.tutorial.Adapter.MyAdapter;
import app.mopubad.tutorial.Model.Item;
import app.mopubad.tutorial.R;
import app.mopubad.tutorial.databinding.ActivityRecyclerViewNativeAdBinding;

public class RecyclerViewNativeAdActivity extends AppCompatActivity {
    
    private ActivityRecyclerViewNativeAdBinding binding;
    private List<Item> itemList;
    private String NATIVE_AD_IT = "11a17b188668469fb0412708c3d16813";
    private MoPubRecyclerAdapter myMoPubAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecyclerViewNativeAdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        itemList = new ArrayList<>();

        itemList.add(new Item(
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque",
                "https://cdn.pixabay.com/photo/2021/12/07/14/00/river-6853339_960_720.jpg",
                "Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni"
        ));

        itemList.add(new Item(
                "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque",
                "https://cdn.pixabay.com/photo/2019/12/28/22/06/pedalboard-4725871_960_720.jpg",
                "These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents"
        ));

        itemList.add(new Item(
                "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete",
                "https://cdn.pixabay.com/photo/2021/12/08/11/01/christmas-6855367_960_720.jpg",
                "On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire"
        ));

        itemList.add(new Item(
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque",
                "https://cdn.pixabay.com/photo/2021/12/02/17/50/bubbles-6841040_960_720.jpg",
                "Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni"
        ));

        itemList.add(new Item(
                "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque",
                "https://cdn.pixabay.com/photo/2020/04/11/20/46/netherlands-5032000_960_720.jpg",
                "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete"
        ));

        itemList.add(new Item(
                "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete",
                "https://cdn.pixabay.com/photo/2020/01/23/20/57/berlin-4788732_960_720.jpg",
                "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque"
        ));

        itemList.add(new Item(
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque",
                "https://cdn.pixabay.com/photo/2021/12/06/10/55/hamburg-6849995_960_720.jpg",
                "Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni"
        ));

        itemList.add(new Item(
                "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections",
                "https://cdn.pixabay.com/photo/2021/12/04/21/53/squirrel-6846096_960_720.jpg",
                "Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English"
        ));

        itemList.add(new Item(
                "Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English",
                "https://cdn.pixabay.com/photo/2017/12/11/18/13/christmas-3012862_960_720.jpg",
                "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections"
        ));

        itemList.add(new Item(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
                "https://cdn.pixabay.com/photo/2021/12/05/08/52/dried-hydrangeas-6846990_960_720.jpg",
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        ));

        itemList.add(new Item(
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium",
                "https://cdn.pixabay.com/photo/2021/12/07/23/09/cup-6854258_960_720.jpg",
                "Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni"
        ));

        itemList.add(new Item(
                "This book is a treatise on the theory of ethics, very popular during the Renaissance.",
                "https://cdn.pixabay.com/photo/2021/10/05/15/58/guitar-6683101_960_720.jpg",
                "This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32."
        ));

        itemList.add(new Item(
                "But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently",
                "https://cdn.pixabay.com/photo/2021/12/05/10/50/beach-6847276_960_720.jpg",
                "These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents"
        ));

        itemList.add(new Item(
                "Contrary to popular belief, Lorem Ipsum is not simply random text.",
                "https://cdn.pixabay.com/photo/2021/11/25/09/28/amsterdam-6823002_960_720.jpg",
                "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old."
        ));

        itemList.add(new Item(
                "Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words",
                "https://cdn.pixabay.com/photo/2021/12/07/19/07/red-fox-6853907_960_720.jpg",
                "Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC."
        ));

        itemList.add(new Item(
                "But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently",
                "https://cdn.pixabay.com/photo/2021/11/10/18/00/map-6784496_960_720.jpg",
                "Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus."
        ));

        itemList.add(new Item(
                "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages",
                "https://cdn.pixabay.com/photo/2021/12/04/10/58/nature-6844982_960_720.jpg",
                "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged."
        ));

        itemList.add(new Item(
                "Various versions have evolved over the years, sometimes by accident,",
                "https://cdn.pixabay.com/photo/2021/11/29/08/20/hands-6831944_960_720.jpg",
                "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy."
        ));

        itemList.add(new Item(
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                "https://cdn.pixabay.com/photo/2021/11/25/14/37/detail-6823782_960_720.jpg",
                "The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."
        ));

        itemList.add(new Item(
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                "https://cdn.pixabay.com/photo/2020/06/16/20/38/boy-5307219_960_720.jpg",
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        ));
        
        binding.rvNative.setHasFixedSize(true);
        binding.rvNative.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(this, itemList);
        myMoPubAdapter = new MoPubRecyclerAdapter(this, adapter);

        SdkConfiguration.Builder builder = new SdkConfiguration.Builder(NATIVE_AD_IT);
        MoPub.initializeSdk(this, builder.build(), onInitialization());
    }

    private SdkInitializationListener onInitialization() {
        return new SdkInitializationListener() {
            @Override
            public void onInitializationFinished() {
                loadNativeAd();
            }
        };
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
        MoPubStaticNativeAdRenderer myRenderer = new MoPubStaticNativeAdRenderer(viewBinder);
        myMoPubAdapter.registerAdRenderer(myRenderer);
        binding.rvNative.setAdapter(myMoPubAdapter);
        myMoPubAdapter.loadAds(NATIVE_AD_IT);
    }
}