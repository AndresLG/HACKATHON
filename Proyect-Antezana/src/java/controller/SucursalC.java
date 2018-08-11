package controller;

import dao.SucursalD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import model.SucursalM;

@Data
@Named(value = "sucursalC")
@SessionScoped
public class SucursalC implements Serializable {

    SucursalM sucursal = new SucursalM();
    private List<SucursalM> lstsucursal;
    
    @PostConstruct
    public void Iniciar(){
        try {
            list();
        } catch (Exception e) {
        }
    }
    
    public void preparSucursal(){
        sucursal = new SucursalM();
    }
    
    public void add() throws Exception{
        SucursalD dao;
        try {
            dao = new SucursalD();
            dao.agregar(sucursal);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Agregar"));
            throw e;
        }
    }
    
    public void update() throws Exception{
        SucursalD dao;
        try {
            dao = new SucursalD();
            dao.modificar(sucursal);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Modificar"));
            throw e;
        }
    }
    
    public void delete() throws Exception{
        SucursalD dao;
        try {
            dao = new SucursalD();
            dao.eliminar(sucursal);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Eliminar"));
            throw e;
        }
    }
    
    public void list() throws Exception{
        SucursalD dao;
        try {
            dao = new SucursalD();
            lstsucursal = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
