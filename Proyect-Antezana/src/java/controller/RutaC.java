package controller;

import dao.RutaD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import model.RutaM;

@Data
@Named(value = "rutaC")
@SessionScoped
public class RutaC implements Serializable {

    RutaM ruta = new RutaM();
    private List<RutaM> lstruta;
    
    @PostConstruct
    public void Iniciar(){
        try {
            list();
        } catch (Exception e) {
        }
    }
    
    public void preparRuta(){
        ruta = new RutaM();
    }
    
    public void add() throws Exception{
        RutaD dao;
        try {
            dao = new RutaD();
            dao.agregar(ruta);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Agregar"));
            throw e;
        }
    }
    
    public void update() throws Exception{
        RutaD dao;
        try {
            dao = new RutaD();
            dao.modificar(ruta);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Modificar"));
            throw e;
        }
    }
    
    public void delete() throws Exception{
        RutaD dao;
        try {
            dao = new RutaD();
            dao.eliminar(ruta);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Eliminar"));
            throw e;
        }
    }
    
    public void list() throws Exception{
        RutaD dao;
        try {
            dao = new RutaD();
            lstruta = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
