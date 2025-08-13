// Source code is decompiled from a .class file using FernFlower decompiler.
package Model;

public class CurrencyOption {
   String country;
   String code;
   Double rate;

   public CurrencyOption(String code, String country, Double rate) {
      this.country = country;
      this.code = code;
      this.rate = rate;
   }

   public String getCode() {
      return this.code;
   }

   public String getCountry() {
      return this.country;
   }

   public Double getRate() {
      return this.rate;
   }
}
