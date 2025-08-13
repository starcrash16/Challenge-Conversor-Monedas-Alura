// Source code is decompiled from a .class file using FernFlower decompiler.
package Model;

public enum Paises {
   ESTADOS_UNIDOS("USD"),
   UNION_EUROPEA("EUR"),
   JAPON("JPY"),
   REINO_UNIDO("GBP"),
   AUSTRALIA("AUD"),
   CANADA("CAD"),
   SUIZA("CHF"),
   CHINA("CNY"),
   MEXICO("MXN"),
   BRASIL("BRL");

   private final String codigoMoneda;

   private Paises(String codigoMoneda) {
      this.codigoMoneda = codigoMoneda;
   }

   public String getCodigoMoneda() {
      return this.codigoMoneda;
   }
}
