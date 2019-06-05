package com.dimedrol.lab2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tech {
    @SerializedName("graphic")
    @Expose
    private String graphicUrl;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("helptext")
    @Expose
    private String helptext;

    public static final String url = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/";

    public String getGraphicUrl() {
        return url + graphicUrl;
    }

    public void setGraphicUrl(String graphicUrl) {
        this.graphicUrl = graphicUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHelptext() {
        return helptext;
    }

    public void setHelptext(String helptext) {
        this.helptext = helptext;
    }
}
