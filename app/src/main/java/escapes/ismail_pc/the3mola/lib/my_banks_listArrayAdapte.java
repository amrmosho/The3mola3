package escapes.ismail_pc.the3mola.lib;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.pushbots.push.Pushbots;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import escapes.ismail_pc.the3mola.R;
import escapes.ismail_pc.the3mola.data_home_tabs;


class my_banks_listArrayAdapte extends ArrayAdapter<my_banks_list_item>  {

    Context context;
    List<my_banks_list_item> objects;
    List<my_banks_list_item> fobjects;
 data_home_tabs.PlaceholderFragment myparent;

    public my_banks_listArrayAdapte(Context context, int resource, List<my_banks_list_item> objects, data_home_tabs.PlaceholderFragment myparent) {
        super(context, resource, objects);

        this.objects = new ArrayList<my_banks_list_item>();
        this.fobjects = new ArrayList<my_banks_list_item>();

        this.objects.addAll(objects) ;
        this.fobjects.addAll(objects);

        this.context = context;

this.myparent=myparent;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)  {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

      final   View lauview = inflater.inflate( R.layout.home_mybanks_list, null);




        TextView t = (TextView) lauview.findViewById(R.id.mybanks_txt_bank_title);
      final   my_banks_list_item cat = objects.get(position);



        TextView mybanks_txt_aed_buy = (TextView) lauview.findViewById(R.id.mybanks_txt_aed_buy);
        TextView mybanks_txt_aed_sell = (TextView) lauview.findViewById(R.id.mybanks_txt_aed_sell);

        TextView mybanks_txt_usd_buy = (TextView) lauview.findViewById(R.id.mybanks_txt_usd_buy);
        TextView mybanks_txt_usd_sell = (TextView) lauview.findViewById(R.id.mybanks_txt_usd_sell);

        TextView mybanks_txt_eur_buy = (TextView) lauview.findViewById(R.id.mybanks_txt_eur_buy);
        TextView mybanks_txt_eur_sell = (TextView) lauview.findViewById(R.id.mybanks_txt_eur_sell);

        TextView mybanks_txt_sar_buy = (TextView) lauview.findViewById(R.id.mybanks_txt_sar_buy);
        TextView mybanks_txt_sar_sell = (TextView) lauview.findViewById(R.id.mybanks_txt_sar_sell);

        TextView mybanks_txt_kwd_buy = (TextView) lauview.findViewById(R.id.mybanks_txt_kwd_buy);
        TextView mybanks_txt_kwd_sell = (TextView) lauview.findViewById(R.id.mybanks_txt_kwd_sell);


        mybanks_txt_aed_buy.setText(cat.getAed_buy());
        mybanks_txt_aed_sell.setText(cat.getAed_sell());

        mybanks_txt_usd_buy.setText(cat.getUsd_buy());
        mybanks_txt_usd_sell.setText(cat.getUsd_sell());

        mybanks_txt_eur_buy.setText(cat.getEur_buy());
        mybanks_txt_eur_sell.setText(cat.getEur_sell());


        mybanks_txt_sar_buy.setText(cat.getSar_buy());
        mybanks_txt_sar_sell.setText(cat.getSar_sell());

        mybanks_txt_kwd_buy.setText(cat.getKwd_buy());
        mybanks_txt_kwd_sell.setText(cat.getKwd_sell());


        ImageView bimage = (ImageView) lauview.findViewById(R.id.mybanks_image_bank_);


        t.setText(cat.getTitle());
        String name = cat.getID();
        int id = context.getApplicationContext().getResources().getIdentifier(name, "drawable", context.getPackageName());
        bimage.setImageResource(id);

      final   Animation FabOpen,FabClose,FabRotate,FabRotateBack;

        FabOpen= AnimationUtils.loadAnimation(lauview.getContext(),R.anim.fab_open);
        FabClose= AnimationUtils.loadAnimation(lauview.getContext(),R.anim.fab_close);





     final    FloatingActionButton FloatingActionButton_remove_pank = (FloatingActionButton) lauview.findViewById(R.id.FloatingActionButton_remove_pank);

        FloatingActionButton_remove_pank.setVisibility(View.INVISIBLE);

        lauview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




              if (FloatingActionButton_remove_pank.getVisibility() ==View.VISIBLE )  {

                  FloatingActionButton_remove_pank.setAnimation(FabClose);

                  FloatingActionButton_remove_pank.setVisibility(View.INVISIBLE);
              }else{
                  FloatingActionButton_remove_pank.setAnimation(FabOpen);
                  FloatingActionButton_remove_pank.setVisibility(View.VISIBLE);


              }


            }
        });


        FloatingActionButton_remove_pank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( final View view) {


                lauview.setAnimation(FabClose);


                myparent.update_mybanks();


                FabClose.setAnimationListener(new Animation.AnimationListener(){
                    @Override
                    public void onAnimationStart(Animation arg0) {
                    }
                    @Override
                    public void onAnimationRepeat(Animation arg0) {
                    }
                    @Override
                    public void onAnimationEnd(Animation arg0) {


                             db d=new db("banks");
                        d.thisContext=view.getContext();
                        d.sand_data.put("bank",cat.getID());
                        d.sand_data.put("pushbots_is", Pushbots.sharedInstance().getGCMRegistrationId());
                        d.sand_data.put("device_type","2");
                        d.sand_data.put("status","remove");
                        d.get_data();

                    }
                });
            /*

             */


            }
        });



        return lauview;
    }







}
