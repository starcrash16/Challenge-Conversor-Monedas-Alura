// Source code is decompiled from a .class file using FernFlower decompiler.
package Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConvierteDatos implements IConvierteDatos {
   private final ObjectMapper objectMapper = new ObjectMapper();

   public ConvierteDatos() {
   }

   public <T> T obtenerDatos(String json, Class<T> clase) {
      try {
         return this.objectMapper.readValue(json, clase);
      } catch (JsonProcessingException var4) {
         Logger.getLogger(ConvierteDatos.class.getName()).log(Level.SEVERE, (String)null, var4);
         return null;
      }
   }
}
