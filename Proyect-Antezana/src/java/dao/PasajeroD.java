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
            PreparedStatement st = this.getCn().prepareStatement("insert into Pasajero(nomPas,apePas,dniPas,edadPas) values(?,?,?,?)");
            st.setString(1, pasajero.getNomPas());
            st.setString(2, pasajero.getApePas());
            st.setString(3, pasajero.getDniPas());
            st.setString(4, pasajero.getEdadPas());
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
            PreparedStatement st = this.getCn().prepareStatement("update Pasajero set nomPas=?,apePas=? where idPas=?");
            st.setString(1, pasajero.getNomPas());
            st.setString(2, pasajero.getApePas());
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
                pasajero.setDniPas(rs.getString("DniPas"));
                pasajero.setEdadPas(rs.getString("EdadPas"));
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
