package interfaces;

import java.util.List;
import model.TrabajadorM;

public interface TrabajadorI {
    public void agregar(TrabajadorM trabajador) throws Exception;
    public void modificar(TrabajadorM trabajador) throws Exception;
    public void eliminar(TrabajadorM trabajador) throws Exception;
    public List<TrabajadorM> listar() throws Exception;
}
