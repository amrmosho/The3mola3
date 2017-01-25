package escapes.ismail_pc.the3mola.lib;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        View view = inflater.inflate( R.layout.home_mybanks_list, null);


        TextView t = (TextView) view.findViewById(R.id.mybanks_txt_bank_title);
      final   my_banks_list_item cat = objects.get(position);



        TextView mybanks_txt_aed_buy = (TextView) view.findViewById(R.id.mybanks_txt_aed_buy);
        TextView mybanks_txt_aed_sell = (TextView) view.findViewById(R.id.mybanks_txt_aed_sell);

        TextView mybanks_txt_usd_buy = (TextView) view.findViewById(R.id.mybanks_txt_usd_buy);
        TextView mybanks_txt_usd_sell = (TextView) view.findViewById(R.id.mybanks_txt_usd_sell);

        TextView mybanks_txt_eur_buy = (TextView) view.findViewById(R.id.mybanks_txt_eur_buy);
        TextView mybanks_txt_eur_sell = (TextView) view.findViewById(R.id.mybanks_txt_eur_sell);

        TextView mybanks_txt_sar_buy = (TextView) view.findViewById(R.id.mybanks_txt_sar_buy);
        TextView mybanks_txt_sar_sell = (TextView) view.findViewById(R.id.mybanks_txt_sar_sell);

        TextView mybanks_txt_kwd_buy = (TextView) view.findViewById(R.id.mybanks_txt_kwd_buy);
        TextView mybanks_txt_kwd_sell = (TextView) view.findViewById(R.id.mybanks_txt_kwd_sell);


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


        ImageView bimage = (ImageView) view.findViewById(R.id.mybanks_image_bank_);


        t.setText(cat.getTitle());
        String name = cat.getID();
        int id = context.getApplicationContext().getResources().getIdentifier(name, "drawable", context.getPackageName());
        bimage.setImageResource(id);






        FloatingActionButton FloatingActionButton_remove_pank = (FloatingActionButton) view.findViewById(R.id.FloatingActionButton_remove_pank);


        FloatingActionButton_remove_pank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                db d=new db("banks");
                d.thisContext=view.getContext();
                d.sand_data.put("bank",cat.getID());
                d.sand_data.put("pushbots_is", Pushbots.sharedInstance().getGCMRegistrationId());
                d.sand_data.put("device_type","2");
                d.sand_data.put("status","remove");
                d.get_data();
                myparent.update_mybanks();

            }
        });



        return view;
    }







}
