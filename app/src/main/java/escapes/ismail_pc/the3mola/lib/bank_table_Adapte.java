package escapes.ismail_pc.the3mola.lib;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
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


class bank_table_Adapte extends ArrayAdapter<bank_table_list_item>  {
   String TAG="bank_table_Adapte" ;
    Context context;
    List<bank_table_list_item> objects;
    List<bank_table_list_item> fobjects;
    data_home_tabs.PlaceholderFragment myparent;



    public bank_table_Adapte(Context context, int resource, List<bank_table_list_item> objects, data_home_tabs.PlaceholderFragment myparent) {
        super(context, resource, objects);

        this.objects = new ArrayList<bank_table_list_item>();
        this.fobjects = new ArrayList<bank_table_list_item>();

        this.objects.addAll(objects) ;
        this.fobjects.addAll(objects);

        this.context = context;
        this.myparent=myparent;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)  {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate( R.layout.bank_table_list, null);
        TextView t = (TextView) view.findViewById(R.id.bank_table_title);
        ImageView i = (ImageView) view.findViewById(R.id.bank_table_image);
        TextView s = (TextView) view.findViewById(R.id.max_min_txt_max);
        TextView b = (TextView) view.findViewById(R.id.max_min_txt_min);

     final    bank_table_list_item cat = objects.get(position);
        t.setText(cat.getTitle());
        s.setText(cat.getSell());
        b.setText(cat.getBuy());

        ImageButton addTofav = (ImageButton) view.findViewById(R.id.addTofav);


      if ( cat.getAllData().get("fav").equalsIgnoreCase("1")){

          addTofav.setImageResource(R.drawable.act_fav);
      }


        addTofav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                myparent.update_mybanks();
                db d=new db("banks");
                d.thisContext=view.getContext();
                d.sand_data.put("bank",cat.getID());
                d.sand_data.put("pushbots_is",Pushbots.sharedInstance().getGCMRegistrationId());
                d.sand_data.put("device_type","2");


                ImageButton v= (ImageButton)view;


                if ( cat.getAllData().get("fav").equalsIgnoreCase("1")){
                    d.sand_data.put("status","remove");
                    cat.getAllData().put("fav" ,"0");
                    v.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                }else{

                    cat.getAllData().put("fav" ,"1");
                    v.setImageResource(R.drawable.act_fav);

                }




                d.get_data();


            }
        });






        String name = cat.getID();

       // Log.e("name" ,name);
        int id = context.getApplicationContext().getResources().getIdentifier(name, "drawable", context.getPackageName());
       // Drawable drawable = context.getResources().getDrawable(id);
        i.setImageResource(id);

        return view;
    }






}
