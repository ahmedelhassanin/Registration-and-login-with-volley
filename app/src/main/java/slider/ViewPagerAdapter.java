package slider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.example.engahmed.reg_login_volley.R;

import java.util.Calendar;
import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    Context context;
    private LayoutInflater layoutInflater;
    private List<SliderUtils> slidimg;
    private ImageLoader imageLoader;


    public ViewPagerAdapter(List slidimg,Context context){

        this.slidimg=slidimg;
        this.context=context;


    }



    @Override
    public int getCount() {
        return slidimg.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    public Object instantiateItem(ViewGroup countainer ,final int postion){

      layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      View view=layoutInflater.inflate(R.layout.custom_layout,null);
      SliderUtils utils=slidimg.get(postion);
        ImageView imageView=(ImageView) view.findViewById(R.id.imageView);
        imageLoader=CustomVolleyRequest.getinstance(context).getImageLoader();
        imageLoader.get(utils.getImgurl(),ImageLoader.getImageListener(imageView,R.mipmap.ic_launcher,android.R.drawable.ic_dialog_alert));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (postion == 0){

                    Toast.makeText(context,"Slide 1 Clicked",Toast.LENGTH_SHORT).show();
                }else if (postion ==1){

                    Toast.makeText(context,"Slide 2 Clicked",Toast.LENGTH_LONG).show();

                }else if (postion == 2){

                    Toast.makeText(context,"Slide 3 Clicked",Toast.LENGTH_SHORT).show();
                }


            }
        });

        ViewPager vp=(ViewPager) countainer;
        vp.addView(view,0);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        ViewPager viewPager=(ViewPager) container;
        View view=(ViewPager) object;
        viewPager.removeView(view);

    }
}
