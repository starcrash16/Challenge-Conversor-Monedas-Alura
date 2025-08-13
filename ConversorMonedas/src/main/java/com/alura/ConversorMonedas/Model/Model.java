// Source code is decompiled from a .class file using FernFlower decompiler.
package Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

@JsonIgnoreProperties(
   ignoreUnknown = true
)
public record Model(Map<String, Double> tasasCambio) {
   @JsonAlias({"conversion_rates"})
   public Map<String, Double> tasasCambio() {
      return this.tasasCambio;
   }

   public Model(@JsonAlias({"conversion_rates"}) Map<String, Double> tasasCambio) {
      this.tasasCambio = tasasCambio;
   }
}
