package interfaces;

import java.util.List;
import model.RutaM;

public interface RutaI {
    public void agregar(RutaM ruta) throws Exception;
    public void modificar(RutaM ruta) throws Exception;
    public void eliminar(RutaM ruta) throws Exception;
    public List<RutaM> listar() throws Exception;
}
