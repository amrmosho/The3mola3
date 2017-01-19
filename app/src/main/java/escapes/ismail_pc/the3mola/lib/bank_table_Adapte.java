package escapes.ismail_pc.the3mola.lib;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import escapes.ismail_pc.the3mola.R;


class bank_table_Adapte extends ArrayAdapter<bank_table_list_item>  {

    Context context;
    List<bank_table_list_item> objects;
    List<bank_table_list_item> fobjects;
    public bank_table_Adapte(Context context, int resource, List<bank_table_list_item> objects) {
        super(context, resource, objects);

        this.objects = new ArrayList<bank_table_list_item>();
        this.fobjects = new ArrayList<bank_table_list_item>();

        this.objects.addAll(objects) ;
        this.fobjects.addAll(objects);

        this.context = context;



    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)  {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate( R.layout.bank_table_list, null);
        TextView t = (TextView) view.findViewById(R.id.bank_table_title);
        ImageView i = (ImageView) view.findViewById(R.id.bank_table_image);
        TextView s = (TextView) view.findViewById(R.id.bank_table_txt_sell);
        TextView b = (TextView) view.findViewById(R.id.bank_table_txt_buy);

        bank_table_list_item cat = objects.get(position);
        t.setText(cat.getTitle());
        s.setText(cat.getSell());
        b.setText(cat.getBuy());


       /* try {
            URL url = new URL("http://currency.sys4me.com/ins_upload//banks/albaraka.png");
            Bitmap bmp = null;
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            i.setImageBitmap(bmp);
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        String name = cat.getID();

        Log.e("name" ,name);
        int id = context.getApplicationContext().getResources().getIdentifier(name, "drawable", context.getPackageName());
       // Drawable drawable = context.getResources().getDrawable(id);
        i.setImageResource(id);


        return view;
    }





    private  class  update_image extends AsyncTask<String,Void,String >{
String TAG="update_image Task";
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        ImageView i;

        @Override
        protected String doInBackground(String... strings) {



            update_my_image(strings[0]);
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }



        void update_my_image(String path){



            try {

                 URL url = new URL(path);


                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                if (connection.getResponseCode()==200){
                    Bitmap   bmp = BitmapFactory.decodeStream(connection.getInputStream());
                    i.setImageBitmap(bmp);
                }

            } catch (MalformedURLException e) {
                Log.e(TAG, "  Error" + e.getMessage());
            } catch (IOException e) {
                Log.e(TAG, "  Error" + e.getMessage());
            } catch (SecurityException e) {
                Log.e(TAG, " Security Exception.  Needs permisson? " + e.getMessage());

            }



        }
    }



}
