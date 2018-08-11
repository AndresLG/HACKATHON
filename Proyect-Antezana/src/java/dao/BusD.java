package dao;

import interfaces.BusI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.BusM;

public class BusD extends Dao implements BusI{

    @Override
    public void agregar(BusM bus) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into Bus(cantAs,fechaVj,Trabajador_idTrab) values(?,?,?)");
            st.setString(1, bus.getCantAs());
            st.setString(2, bus.getFechaVj());
            st.setString(3, bus.getTrabajador_idTrab());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public void modificar(BusM bus) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("update Bus set cantAs=?,fechaVj=? where idBus=?");
            st.setString(1, bus.getCantAs());
            st.setString(2, bus.getFechaVj());
            st.setString(3, bus.getTrabajador_idTrab());
            st.setInt(4, bus.getIdBus());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(BusM bus) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("delete from Bus where idBus=?");
            st.setInt(1, bus.getIdBus());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public List<BusM> listar() throws Exception {
        List<BusM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "select * from Bus";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                BusM bus = new BusM();
                bus.setIdBus(rs.getInt("IdBus"));
                bus.setCantAs(rs.getString("CantAs"));
                bus.setFechaVj(rs.getString("FechaVj"));
                bus.setTrabajador_idTrab(rs.getString("Trabajador_idTrab"));
                lista.add(bus);
            }
            return lista;
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
}
