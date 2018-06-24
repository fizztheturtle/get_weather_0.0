package fizztheturtle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DV {

    @SerializedName("dataDate")
    @Expose
    private String dataDate;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("Location")
    @Expose
    public  fizztheturtle.Location location;

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public fizztheturtle.Location getLocation() {
        return location;
    }

    public void setLocation(fizztheturtle.Location location) {
        this.location = location;
    }

}
