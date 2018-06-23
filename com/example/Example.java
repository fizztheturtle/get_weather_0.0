
package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("SiteRep")
    @Expose
    private SiteRep siteRep;

    public SiteRep getSiteRep() {
        return siteRep;
    }

    public void setSiteRep(SiteRep siteRep) {
        this.siteRep = siteRep;
    }

}
