package interfaces;

import java.util.List;
import model.BusM;

public interface BusI {
    public void agregar(BusM bus) throws Exception;
    public void modificar(BusM bus) throws Exception;
    public void eliminar(BusM bus) throws Exception;
    public List<BusM> listar() throws Exception;
}
