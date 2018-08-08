package interfaces;

import java.util.List;
import model.PasajeroM;

public interface PasajeroI {
    public void agregar(PasajeroM pasajero) throws Exception;
    public void modificar(PasajeroM pasajero) throws Exception;
    public void eliminar(PasajeroM pasajero) throws Exception;
    public List<PasajeroM> listar() throws Exception;
}
