package interfaces;

import java.util.List;
import model.SucursalM;

public interface SucursalI {
    public void agregar(SucursalM sucursal) throws Exception;
    public void modificar(SucursalM sucursal) throws Exception;
    public void eliminar(SucursalM sucursal) throws Exception;
    public List<SucursalM> listar() throws Exception;
}
