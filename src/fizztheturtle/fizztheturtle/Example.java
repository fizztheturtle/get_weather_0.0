package fizztheturtle;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("SiteRep")
    @Expose
    private fizztheturtle.SiteRep siteRep;

    public fizztheturtle.SiteRep getSiteRep() {
        return siteRep;
    }

    public void setSiteRep(fizztheturtle.SiteRep siteRep) {
        this.siteRep = siteRep;
    }

}
