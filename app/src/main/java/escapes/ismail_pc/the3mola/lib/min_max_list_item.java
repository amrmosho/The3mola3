package escapes.ismail_pc.the3mola.lib;

/**
 * Created by ismail on 10/22/2015.
 */
public class min_max_list_item {

    private  String title="";
    private  String buy="";
    private  String buyBankTitle="";
    private  String buyBankCode="";
    private  String buyBankImage="";

    private  String sell="";
    private  String sellBankTitle="";
    private  String sellBankCode="";
    private  String sellBankImage="";
    private String id="";


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

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getBuyBankTitle() {
        return buyBankTitle;
    }

    public void setBuyBankTitle(String buyBankTitle) {
        this.buyBankTitle = buyBankTitle;
    }

    public String getBuyBankCode() {
        return buyBankCode;
    }

    public void setBuyBankCode(String buyBankCode) {
        this.buyBankCode = buyBankCode;
    }

    public String getBuyBankImage() {
        return buyBankImage;
    }

    public void setBuyBankImage(String buyBankImage) {
        this.buyBankImage = buyBankImage;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getSellBankTitle() {
        return sellBankTitle;
    }

    public void setSellBankTitle(String sellBankTitle) {
        this.sellBankTitle = sellBankTitle;
    }

    public String getSellBankCode() {
        return sellBankCode;
    }

    public void setSellBankCode(String sellBankCode) {
        this.sellBankCode = sellBankCode;
    }

    public String getSellBankImage() {
        return sellBankImage;
    }

    public void setSellBankImage(String sellBankImage) {
        this.sellBankImage = sellBankImage;
    }
}
