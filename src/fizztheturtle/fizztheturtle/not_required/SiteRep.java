package fizztheturtle;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SiteRep {

    @SerializedName("Wx")
    @Expose
    private Wx wx;
    @SerializedName("DV")
    @Expose
    private DV dV;

    public Wx getWx() {
        return wx;
    }

    public void setWx(Wx wx) {
        this.wx = wx;
    }

    public DV getDV() {
        return dV;
    }

    public void setDV(DV dV) {
        this.dV = dV;
    }

}
