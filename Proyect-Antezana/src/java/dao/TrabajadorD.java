package dao;

import interfaces.TrabajadorI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.TrabajadorM;

public class TrabajadorD extends Dao implements TrabajadorI{

    @Override
    public void agregar(TrabajadorM trabajador) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into Trabajador(nomTrab,apeTrab,dniTrab,Sucursal_idSuc) values(?,?,?,?)");
            st.setString(1, trabajador.getNomTrab());
            st.setString(2, trabajador.getApeTrab());
            st.setString(3, trabajador.getDniTrab());
            st.setString(4, trabajador.getSucursal_idSuc());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public void modificar(TrabajadorM trabajador) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("update Trabajador set nomTrab=?,apeTrab=? where idTrab=?");
            st.setString(1, trabajador.getNomTrab());
            st.setString(2, trabajador.getApeTrab());
            st.setInt(3, trabajador.getIdTrab());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(TrabajadorM trabajador) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("delete from Trabajador where idTrab=?");
            st.setInt(1, trabajador.getIdTrab());
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public List<TrabajadorM> listar() throws Exception {
        List<TrabajadorM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "select * from Trabajador";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {                
                TrabajadorM trabajador = new TrabajadorM();
                trabajador.setIdTrab(rs.getInt("IdTrab"));
                trabajador.setNomTrab(rs.getString("NomTrab"));
                trabajador.setApeTrab(rs.getString("ApeTrab"));
                trabajador.setDniTrab(rs.getString("DniTrab"));
                trabajador.setSucursal_idSuc(rs.getString("Sucursal_idSuc"));
                lista.add(trabajador);
            }
            return lista;
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
}
