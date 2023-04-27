package com.example.myapplication;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;

import androidx.annotation.NonNull;

public class Cotxe implements Parcelable{

   private String alias;
   private String marca;
   private String model;
   private double cilindrada;
   private long telefon;
   private boolean automatic;
   private double longitud;
   private double latitud;

   public Cotxe(String alias, String marca, String model, double cilindrada, long telefon, boolean automatic, double longitud, double latitud){
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

   }
}
