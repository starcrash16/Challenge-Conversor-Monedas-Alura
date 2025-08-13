// Source code is decompiled from a .class file using FernFlower decompiler.
package Principal;

import Model.CurrencyOption;
import Model.Model;
import Service.ConsumoAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Principal {
   private Scanner teclado;
   private ConsumoAPI consumoApi;
   private final String URL_BASE;
   private final String API_KEY;
   private Integer resp;
   private List<CurrencyOption> currencies;
   private Model model;
   private ObjectMapper mapper;
   private List<CurrencyOption> conversionesFiltradas;

   public Principal() {
      this.teclado = new Scanner(System.in);
      this.consumoApi = new ConsumoAPI();
      this.URL_BASE = "https://v6.exchangerate-api.com/v6/";
      this.API_KEY = "08ec9f1df7d0c5b3d5c93cf3";
      this.resp = 1;
      this.currencies = List.of(new CurrencyOption("USD", "Estados Unidos", 0.0), new CurrencyOption("EUR", "Union Europea", 0.0), new CurrencyOption("JPY", "Japon", 0.0), new CurrencyOption("GBP", "Reino Unido", 0.0), new CurrencyOption("AUD", "Australia", 0.0), new CurrencyOption("CAD", "Canada", 0.0), new CurrencyOption("CHF", "Suiza", 0.0), new CurrencyOption("CNY", "China", 0.0), new CurrencyOption("MXN", "Mexico", 0.0), new CurrencyOption("BRL", "Brasil", 0.0));
      this.mapper = new ObjectMapper();
      this.conversionesFiltradas = new ArrayList();
   }

   public void muestraElMenu() {
      while(true) {
         if (this.resp != 0) {
            System.out.println("Conversor de Monedas - AluraConversor - Realizado por René De Anda");
            AtomicInteger i = new AtomicInteger(1);
            this.currencies.forEach((m) -> {
               PrintStream var10000 = System.out;
               int var10001 = i.getAndIncrement();
               var10000.println("" + var10001 + "." + m.getCode() + " - " + m.getCountry());
            });
                        System.out.println("Selecciona tu moneda: ");

            this.resp = Integer.valueOf(this.teclado.nextLine());
            this.resp = this.resp - 1;
            if (this.resp >= 0 && this.resp <= 10) {
               String pais = ((CurrencyOption)this.currencies.get(this.resp)).getCountry();
               String code = ((CurrencyOption)this.currencies.get(this.resp)).getCode();
               System.out.println("Respuesta: " + pais);
               String json = this.consumoApi.obtenerDatos("https://v6.exchangerate-api.com/v6/08ec9f1df7d0c5b3d5c93cf3/latest/" + code);

               try {
                  this.model = (Model)this.mapper.readValue(json, Model.class);
               } catch (JsonProcessingException var11) {
                  Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String)null, var11);
                  return;
               }

               this.conversionesFiltradas = (List)this.currencies.stream().map((currency) -> {
                  return new CurrencyOption(currency.getCode(), currency.getCountry(), (Double)this.model.tasasCambio().getOrDefault(currency.getCode(), 0.0));
               }).collect(Collectors.toList());
               AtomicInteger aux = new AtomicInteger(1);
               this.conversionesFiltradas.stream().filter((m) -> {
                  return m.getRate() > 0.0;
               }).forEach((m) -> {
                  if (m.getCode().equals(code)) {
                     aux.getAndIncrement();
                  } else {
                     PrintStream var10000 = System.out;
                     int var10001 = aux.getAndIncrement();
                     var10000.println("" + var10001 + ". Pais: " + m.getCountry() + " - " + m.getCode() + " - Tasa:" + String.valueOf(m.getRate()));
                  }

               });
               System.out.println("Selecciona la moneda a la que deseas convertir: ");
               Integer resp2 = Integer.valueOf(this.teclado.nextLine());
               resp2 = resp2 - 1;
               System.out.println(code + "->" + ((CurrencyOption)this.conversionesFiltradas.get(resp2)).getCode() + " Cantidad a convertir: ");
               Double cantidad = Double.valueOf(this.teclado.nextLine());
               Double tasa = ((CurrencyOption)this.conversionesFiltradas.get(resp2)).getRate();
               double resultado = cantidad * tasa;
               System.out.println("Resultado: " + resultado + " " + ((CurrencyOption)this.conversionesFiltradas.get(resp2)).getCode() + "\n");
            } else {
               System.out.println("Incorrecto");
            }

            System.out.println("Desea continuar? (1.Si 0.No)");
            this.resp = Integer.valueOf(this.teclado.nextLine());
            if (this.resp != 0) {
               continue;
            }

            System.out.println("Gracias por usar el conversor de monedas");
         }

         return;
      }
   }
}
