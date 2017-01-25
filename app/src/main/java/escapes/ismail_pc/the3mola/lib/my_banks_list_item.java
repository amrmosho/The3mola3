package escapes.ismail_pc.the3mola.lib;

/**
 * Created by ismail on 10/22/2015.
 */
public class my_banks_list_item {

    private  String title="";
    private String id="";


    private String usd_sell="";
    private String usd_buy="";
    private String sar_sell="";
    private String sar_buy="";
    private String aed_sell="";
    private String aed_buy="";
    private String kwd_sell="";
    private String kwd_buy="";
    private String eur_sell="";
    private String eur_buy="";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.title;
    }


    public String getUsd_sell() {
        return usd_sell;
    }

    public void setUsd_sell(String usd_sell) {
        this.usd_sell = usd_sell;
    }

    public String getUsd_buy() {
        return usd_buy;
    }

    public void setUsd_buy(String usd_buy) {
        this.usd_buy = usd_buy;
    }

    public String getSar_sell() {
        return sar_sell;
    }

    public void setSar_sell(String sar_sell) {
        this.sar_sell = sar_sell;
    }

    public String getSar_buy() {
        return sar_buy;
    }

    public void setSar_buy(String sar_buy) {
        this.sar_buy = sar_buy;
    }

    public String getAed_sell() {
        return aed_sell;
    }

    public void setAed_sell(String aed_sell) {
        this.aed_sell = aed_sell;
    }

    public String getAed_buy() {
        return aed_buy;
    }

    public void setAed_buy(String aed_buy) {
        this.aed_buy = aed_buy;
    }

    public String getKwd_sell() {
        return kwd_sell;
    }

    public void setKwd_sell(String kwd_sell) {
        this.kwd_sell = kwd_sell;
    }

    public String getKwd_buy() {
        return kwd_buy;
    }

    public void setKwd_buy(String kwd_buy) {
        this.kwd_buy = kwd_buy;
    }

    public String getEur_sell() {
        return eur_sell;
    }

    public void setEur_sell(String eur_sell) {
        this.eur_sell = eur_sell;
    }

    public String getEur_buy() {
        return eur_buy;
    }

    public void setEur_buy(String eur_buy) {
        this.eur_buy = eur_buy;
    }
}
