package dao;

import interfaces.SucursalI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.SucursalM;

public class SucursalD extends Dao implements SucursalI{

    @Override
    public void agregar(SucursalM sucursal) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into Sucursal(nomSuc) values(?)");
            st.setString(1, sucursal.getNomSuc());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public void modificar(SucursalM sucursal) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("update Sucursal set nomSuc=? where idSuc=?");
            st.setString(1, sucursal.getNomSuc());
            st.setInt(2, sucursal.getIdSuc());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(SucursalM sucursal) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("delete from Sucursal where idSuc=?");
            st.setInt(1, sucursal.getIdSuc());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public List<SucursalM> listar() throws Exception {
        List<SucursalM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "select * from Sucursal";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                SucursalM sucursal = new SucursalM();
                sucursal.setIdSuc(rs.getInt("IdSuc"));
                sucursal.setNomSuc(rs.getString("NomSuc"));
                lista.add(sucursal);
            }
            return lista;
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
    
    
}
