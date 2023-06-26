package com.petrushendryfebry202102254.cuaca;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import kotlin.jvm.internal.SerializedIr;

public class RootModel {
    @SerializedName("list")
    private List<ListModel> listModelList;

    public RootModel(){
    }
    public List<ListModel> getListModelList(){ return listModelList; }

    public void setListModelList(List<ListModel> listModelList) {
        this.listModelList = listModelList;
    }
}