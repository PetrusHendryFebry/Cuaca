package com.petrushendryfebry202102254.cuaca;

public class WeatherModel {
    private String main;
    private String descripton;
    private String icon;

    public WeatherModel(){
    }

    public String getMain() { return main; }

    public void setMain(String main) { this.main = main; }

    public String getDescripton() { return descripton; }

    public void setDescripton(String descripton) { this.descripton = descripton; }

    public String getIcon() {return  icon; }

    public void setIcon(String icon) { this.icon = icon; }
}
