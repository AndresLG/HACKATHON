package controller;

import dao.TrabajadorD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import model.TrabajadorM;

@Data
@Named(value = "trabajadorC")
@SessionScoped
public class TrabajadorC implements Serializable {
    
    TrabajadorM trabajador = new TrabajadorM();
    private List<TrabajadorM> lsttrabajador;
    
    @PostConstruct
    public void Iniciar(){
        try {
            list();
        } catch (Exception e) {
        }
    }
    
    public void preprarTrabajador(){
        trabajador = new TrabajadorM();
    }
    
    public void add() throws Exception{
        TrabajadorD dao;
        try {
            dao = new TrabajadorD();
            dao.agregar(trabajador);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo agregar"));
            throw e;
        }
    }
    
    public void update() throws Exception{
        TrabajadorD dao;
        try {
            dao = new TrabajadorD();
            dao.modificar(trabajador);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo modificar"));
            throw e;
        }
    }
    
    public void delete() throws Exception{
        TrabajadorD dao;
        try {
            dao = new TrabajadorD();
            dao.eliminar(trabajador);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo eliminar"));
            throw e;
        }
    }
    
    public void list() throws Exception{
        TrabajadorD dao;
        try {
            dao = new TrabajadorD();
            lsttrabajador = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
}
