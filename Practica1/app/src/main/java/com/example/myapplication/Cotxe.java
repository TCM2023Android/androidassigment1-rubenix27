package com.example.myapplication;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Cotxe implements Parcelable {


   private String alias;
   private String marca;
   private String model;
   private double cilindrada;
   private String telefon;
   private boolean automatic;
   private double longitud;
   private double latitud;


   public Cotxe(String alias, String marca, String model, double cilindrada, String telefon, boolean automatic, double longitud, double latitud){
      this.alias=alias;
      this.marca=marca;
      this.model=model;
      this.cilindrada=cilindrada;
      this.telefon=telefon;
      this.automatic=automatic;
      this.longitud=longitud;
      this.latitud=latitud;

   }
   public Cotxe(Parcel in) {
      super();
      readFromParcel(in);
   }

   public String getAlias() {
      return alias;
   }

   public void setAlias(String alias) {
      this.alias = alias;
   }

   public String getMarca() {
      return marca;
   }

   public void setMarca(String marca) {
      this.marca = marca;
   }

   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public double getCilindrada() {
      return cilindrada;
   }

   public void setCilindrada(double cilindrada) {
      this.cilindrada = cilindrada;
   }

   public String getTelefon() {
      return telefon;
   }

   public void setTelefon(String telefon) {
      this.telefon = telefon;
   }

   public boolean isAutomatic() {
      return automatic;
   }

   public void setAutomatic(boolean automatic) {
      this.automatic = automatic;
   }

   public double getLongitud() {
      return longitud;
   }

   public void setLongitud(double longitud) {
      this.longitud = longitud;
   }

   public double getLatitud() {
      return latitud;
   }

   public void setLatitud(double latitud) {
      this.latitud = latitud;
   }

   public static final Parcelable.Creator<Cotxe> CREATOR = new Parcelable.Creator<Cotxe>() {
      @Override
      public Cotxe createFromParcel(Parcel parcel) {
         return null;
      }

      @Override
      public Cotxe[] newArray(int i) {
         return new Cotxe[0];
      }
   };

   @Override
   public int describeContents() {
      return 0;
   }

   @Override
   public void writeToParcel(@NonNull Parcel parcel, int i) {
      parcel.writeString(alias);
      parcel.writeString(marca);
      parcel.writeString(model);
      parcel.writeDouble(cilindrada);
      parcel.writeString(telefon);
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
         parcel.writeBoolean(automatic);
      }
      parcel.writeDouble(longitud);
      parcel.writeDouble(latitud);

   }

   public void readFromParcel(Parcel in){
      alias=in.readString();
      marca=in.readString();
      model=in.readString();
      cilindrada=in.readDouble();
      telefon=in.readString();
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
         if (in.readBoolean()) automatic = true;
         else automatic = false;
      }
      longitud=in.readDouble();
      latitud=in.readDouble();




   }


}
