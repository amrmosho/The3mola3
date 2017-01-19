package escapes.ismail_pc.the3mola.lib;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


/**
 * Created by ismail-pc on 18 - 01 - 2017.
 */


public class db  {
    String TAG = "DBClass";
    private String thisTable = "";
    private String thisWhere = "";
    public Context thisContext;
    public ListView thisListview;
    public String ListTitle="title";
    public String ListDes="";
    public String ListID="";
    public String ListImage="";

    public db(String table) {
        thisTable = table;
    }

    public db(String table, String where) {
        thisTable = table;
        thisWhere = where;
    }

    public void get_data() {

        DownloadData d = new DownloadData();
        d.table = thisTable;
        d.where = thisWhere;
        d.v = thisListview;
        d.c = thisContext;
        d.desKey = ListDes;
        d.imagekey = ListImage;
        d.idKey = ListID;
        d.titleKey = ListTitle;
        d.execute(options.thisUrl);


    }


    private class DownloadData extends AsyncTask<String, Void, String>

    {
        String desKey = "";
        String imagekey = "";
        String idKey = "id";
        String titleKey = "title";
        String table = "sys_html";
        String where = "";
        ListView v;
        Context c;
        String sellKey = "sell";
        String buyKey = "buy";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            return getData(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.w(TAG, "onPostExecute:" + s);
            ArrayList<HashMap<String, String>> r = jsonToMapUpdate(s);

            fill_bank_table(r);

        }
        void fill_bank_table(ArrayList<HashMap<String, String>> listdata) {
            final List<bank_table_list_item> mydata = new ArrayList<>();
            for (HashMap<String, String> h : listdata) {
                bank_table_list_item c = new bank_table_list_item();
                c.setTitle(h.get(titleKey));

                if (desKey!=""){
                    c.setDes(h.get(desKey));
                }
                if (imagekey!=""){
                    c.setImage(h.get(imagekey));
                }
                if (idKey!=""){
                    c.setID(h.get(idKey));
                }

                if (sellKey!=""){
                    c.setSell(h.get(sellKey));
                }

                if (buyKey!=""){
                    c.setBuy(h.get(buyKey));
                }

                mydata.add(c);
            }

            bank_table_Adapte    adapter = new bank_table_Adapte(c, 0, mydata);
            v.setAdapter(adapter);
        }



        void fill_list(ArrayList<HashMap<String, String>> listdata) {
            final List<list_item> mydata = new ArrayList<>();
            for (HashMap<String, String> h : listdata) {
                list_item c = new list_item();
                c.setTitle(h.get(titleKey));

                if (desKey!=""){
                    c.setDes(h.get(desKey));
                }
                if (imagekey!=""){
                    c.setImage(h.get(imagekey));
                }
                if (idKey!=""){
                    c.setID(h.get(idKey));
                }

                mydata.add(c);
            }

            listArrayAdapte    adapter = new listArrayAdapte(c, 0, mydata);
            v.setAdapter(adapter);
        }




        /**
         * connect With server
         **/

        String getData(String u) {


            String r = "";


            try {

                //Create Url connection
                URL url = new URL(u);


                //Url openConnection
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();


                connection.setDoOutput(true);

                connection.setRequestMethod("POST");
                String data = URLEncoder.encode("table", "UTF-8") + "=" + URLEncoder.encode(table, "UTF-8");
                data += "&" + URLEncoder.encode("where", "UTF-8") + "=" + URLEncoder.encode(where, "UTF-8");
                OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
                wr.write(data);
                wr.flush();
                connection.connect();


                int response = connection.getResponseCode();
                Log.d(TAG, " The response code was " + response);
                //200 if Connection successed
                if (response == 200) {
                    InputStream s = connection.getInputStream();
                    InputStreamReader in = new InputStreamReader(s);
                    BufferedReader reader = new BufferedReader(in);
                    String line;

                    String mydata = "";
                    while ((line = reader.readLine()) != null) {
                        mydata += line;
                    }
                    r = mydata;

                    reader.close();


                }
            } catch (MalformedURLException e) {
                Log.e(TAG, "  Error" + e.getMessage());
            } catch (IOException e) {
                Log.e(TAG, "  Error" + e.getMessage());
            } catch (SecurityException e) {
                Log.e(TAG, "downloadXML: Security Exception.  Needs permisson? " + e.getMessage());

            }

            return r;

        }


        /**
         * connect With server
         **/

        ArrayList<HashMap<String, String>> jsonToMapUpdate(String data) {


            ArrayList<HashMap<String, String>> returndata = new ArrayList();

            try {

                JSONObject j = new JSONObject(data);
                JSONArray dataaaa = j.getJSONArray("data");





                for (int i = 0; i < dataaaa.length(); i++) {


                    JSONObject Row = dataaaa.getJSONObject(i);
                    Iterator<String> ir = Row.keys();

                    HashMap<String, String> r = new HashMap<String, String>();
                    while (ir.hasNext()) {
                        String currentKey = ir.next();
                        r.put(currentKey, Row.getString(currentKey));
                    }
                   returndata.add(r);

                }








            } catch (JSONException e) {
                Log.d(TAG, "  Error" + e.getMessage());
            }





            return returndata;
        }


    }


}
