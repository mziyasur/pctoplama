/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.MonitorDAO;
import entity.Monitor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author mehme
 */
@FacesConverter(value = "monitorConverter")
//Yapmış olduğu görev nedir converterlerin 
//Bean sınıfları xthtm tarafayıla istek cevap üzrüne kurulu
//create anakart id gönderiyoduk kendisini gördermemiz lazm
public class MonitorConverter implements Converter {

    private MonitorDAO monitorDao;

    public MonitorDAO getMonitorDao() {
        if (monitorDao == null) {
            this.monitorDao = new MonitorDAO();
        }
        return monitorDao;
    }

    public void setMonitorDao(MonitorDAO monitorDao) {
        this.monitorDao = monitorDao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        return this.getMonitorDao().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object t) {
        Monitor a = (Monitor) t;
        return String.valueOf(a.getMonitor_id());

    }

}
