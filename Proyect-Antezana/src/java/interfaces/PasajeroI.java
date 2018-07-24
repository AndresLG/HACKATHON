package interfaces;

import java.util.List;
import model.PasajeroM;

public interface PasajeroI {
    public void agregar(PasajeroM pas) throws Exception;
    public void modificar(PasajeroM pas) throws Exception;
    public void eliminar(PasajeroM pas) throws Exception;
    public List<PasajeroM> listar() throws Exception;
}
