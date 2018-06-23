package fizztheturtle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Param {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("units")
    @Expose
    private String units;
    @SerializedName("$")
    @Expose
    private String $;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String get$() {
        return $;
    }

    public void set$(String $) {
        this.$ = $;
    }

}
