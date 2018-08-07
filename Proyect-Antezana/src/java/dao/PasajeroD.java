package dao;

import interfaces.PasajeroI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.PasajeroM;

public class PasajeroD extends Dao implements PasajeroI{

    @Override
    public void agregar(PasajeroM pas) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into Pasajero(nomPas, apePas, tipoDocPas, numDocPas, edadPas, origenPas, destPas) values(?,?,?,?,?,?,?)");
            st.setString(1, pas.getNomPas());
            st.setString(2, pas.getApePas());
            st.setString(3, pas.getTipoDocPas());
            st.setString(4, pas.getNumDocPas());
            st.setString(5, pas.getEdadPas());
            st.setString(6, pas.getOrigenPas());
            st.setString(7, pas.getDestPas());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public void modificar(PasajeroM pas) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("update Pasajero set origenPas=?,destPas=? where idPas=?");
            st.setString(1, pas.getOrigenPas());
            st.setString(2, pas.getDestPas());
            st.setInt(3, pas.getIdPas());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(PasajeroM pas) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("delete from Pasajero where idPas=?");
            st.setInt(1, pas.getIdPas());
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
                PasajeroM pas = new PasajeroM();
                pas.setIdPas(rs.getInt("IdPas"));
                pas.setNomPas(rs.getString("NomPas"));
                pas.setApePas(rs.getString("ApePas"));
                pas.setTipoDocPas(rs.getString("TipoDocPas"));
                pas.setNumDocPas(rs.getString("NumDocPas"));
                pas.setEdadPas(rs.getString("EdadPas"));
                pas.setOrigenPas(rs.getString("OrigenPas"));
                pas.setDestPas(rs.getString("DestPas"));
                lista.add(pas);
            }
            return lista;
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
}
