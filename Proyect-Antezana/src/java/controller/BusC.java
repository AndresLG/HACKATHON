package controller;

import dao.BusD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import model.BusM;

@Data
@Named(value = "busC")
@SessionScoped
public class BusC implements Serializable {

    BusM bus = new BusM();
    private List<BusM> lstbus;
    
    @PostConstruct
    public void Iniciar(){
        try {
            list();
        } catch (Exception e) {
        }
    }
    
    public void preparBus(){
        bus = new BusM();
    }
    
    public void add() throws Exception{
        BusD dao;
        try {
            dao = new BusD();
            dao.agregar(bus);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Agregar"));
            throw e;
        }
    }
    
    public void update() throws Exception{
        BusD dao;
        try {
            dao = new BusD();
            dao.modificar(bus);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Modificar"));
            throw e;
        }
    }
    
    public void delete() throws Exception{
        BusD dao;
        try {
            dao = new BusD();
            dao.eliminar(bus);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Eliminar"));
            throw e;
        }
    }
    
    public void list() throws Exception{
        BusD dao;
        try {
            dao = new BusD();
            lstbus = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
