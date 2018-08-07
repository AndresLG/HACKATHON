package controller;

import dao.PasajeroD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import model.PasajeroM;

@Data
@Named(value = "PasajeroC")
@SessionScoped
public class PasajeroC implements Serializable {

    PasajeroM pas = new PasajeroM();
    private List<PasajeroM> lstpas;
    
    @PostConstruct
    public void Iniciar(){
        try {
            list();
        } catch (Exception e) {
        }
    }
    
    public void PreparPas(){
        pas = new PasajeroM();
    }
    
    public void add() throws Exception{
        PasajeroD dao;
        try {
            dao = new PasajeroD();
            dao.agregar(pas);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Agregar"));
            throw e;
        }
    }
    
    public void update() throws Exception{
        PasajeroD dao;
        try {
            dao = new PasajeroD();
            dao.modificar(pas);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Modificar"));
            throw e;
        }
    }
    
    public void delete() throws Exception{
        PasajeroD dao;
        try {
            dao = new PasajeroD();
            dao.eliminar(pas);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Eliminar"));
            throw e;
        }
    }
    
    public void list() throws Exception{
        PasajeroD dao;
        try {
            dao = new PasajeroD();
            lstpas = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
}
