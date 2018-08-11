package dao;

import interfaces.RutaI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.RutaM;

public class RutaD extends Dao implements RutaI{

    @Override
    public void agregar(RutaM ruta) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into Ruta(origen,destino) values(?,?)");
            st.setString(1, ruta.getOrigen());
            st.setString(2, ruta.getDestino());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public void modificar(RutaM ruta) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("update Ruta set origen=?,destino=? where idRuta=?");
            st.setString(1, ruta.getOrigen());
            st.setString(2, ruta.getDestino());
            st.setInt(3, ruta.getIdRuta());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(RutaM ruta) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("delete from Ruta where idRuta=?");
            st.setInt(1, ruta.getIdRuta());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public List<RutaM> listar() throws Exception {
        List<RutaM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "select * from Ruta";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                RutaM ruta = new RutaM();
                ruta.setIdRuta(rs.getInt("IdRuta"));
                ruta.setOrigen(rs.getString("Origen"));
                ruta.setDestino(rs.getString("Destino"));
                lista.add(ruta);
            }
            return lista;
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
}
