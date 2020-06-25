package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import com.mercadopago.resources.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Factura;
import ar.edu.unlam.tallerweb1.modelo.Item;
import ar.edu.unlam.tallerweb1.servicios.ServicioFactura;

@Controller
public class ControladorCompra {
	
	private ServicioFactura servicioFactura;

    @Autowired
    public ControladorCompra(ServicioFactura servicioFactura) {
        this.servicioFactura = servicioFactura;
    }
	
    @RequestMapping(value = "/generar-factura", method = RequestMethod.POST)
    public ModelAndView generarFactura(@RequestParam("idCarrito") Long idCarrito) throws Exception {
    	ModelMap modelo = new ModelMap();
    	Factura factura = this.servicioFactura.generarFactura(idCarrito);
    	modelo.put("factura", factura);
    	List<Item> items = this.servicioFactura.listarItems(factura);
    	modelo.put("itemsFactura", items);
    	return new ModelAndView("compra/generar-factura",modelo);
    }
    
    @RequestMapping(value = "/aplicar-descuento", method = RequestMethod.POST)
    public ModelAndView aplicararDescuento(@RequestParam("idFactura") Long idFactura,
    		 							@RequestParam("codigo") String codigo) {
    	
    	ModelMap modelo = new ModelMap();
    	Factura factura = this.servicioFactura.obtenerFactura(idFactura);
    	if(this.servicioFactura.cargarCodigoDeDescuento(factura, codigo)) {
    		modelo.put("msjCodigo","C&oacute;digo de descuento "+ codigo +" aplicado correctamente!");
    	}
    	else {
    		modelo.put("msjCodigo","C&oacute;digo de descuento "+ codigo +" inv&aacute;lido...");
    	}    	
    	List<Item> items = this.servicioFactura.listarItems(factura);    	
    	modelo.put("itemsFactura", items);
    	modelo.put("factura", factura);
    	return new ModelAndView("compra/generar-factura",modelo);
    }    
    

}