package dao;

import interfaces.PasajeroI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.PasajeroM;

public class PasajeroD extends Dao implements PasajeroI{

    @Override
    public void agregar(PasajeroM pasajero) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into Pasajero(nomPas, apePas, tipoDocPas, numDocPas, edadPas, origenPas, destPas) values(?,?,?,?,?,?,?)");
            st.setString(1, pasajero.getNomPas());
            st.setString(2, pasajero.getApePas());
            st.setString(3, pasajero.getTipoDocPas());
            st.setString(4, pasajero.getNumDocPas());
            st.setString(5, pasajero.getEdadPas());
            st.setString(6, pasajero.getOrigenPas());
            st.setString(7, pasajero.getDestPas());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public void modificar(PasajeroM pasajero) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("update Pasajero set origenPas=?,destPas=? where idPas=?");
            st.setString(1, pasajero.getOrigenPas());
            st.setString(2, pasajero.getDestPas());
            st.setInt(3, pasajero.getIdPas());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(PasajeroM pasajero) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("delete from Pasajero where idPas=?");
            st.setInt(1, pasajero.getIdPas());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public List<PasajeroM> listar() throws Exception {
        List<PasajeroM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "select * from Pasajero";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                PasajeroM pasajero = new PasajeroM();
                pasajero.setIdPas(rs.getInt("IdPas"));
                pasajero.setNomPas(rs.getString("NomPas"));
                pasajero.setApePas(rs.getString("ApePas"));
                pasajero.setTipoDocPas(rs.getString("TipoDocPas"));
                pasajero.setNumDocPas(rs.getString("NumDocPas"));
                pasajero.setEdadPas(rs.getString("EdadPas"));
                pasajero.setOrigenPas(rs.getString("OrigenPas"));
                pasajero.setDestPas(rs.getString("DestPas"));
                lista.add(pasajero);
            }
            return lista;
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
}
