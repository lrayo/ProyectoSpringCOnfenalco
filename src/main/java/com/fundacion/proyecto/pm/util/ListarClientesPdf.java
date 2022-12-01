package com.fundacion.proyecto.pm.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.fundacion.proyecto.pm.model.entity.Cliente;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("/views/clientes/listar")
public class ListarClientesPdf extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<Cliente> listadoClientes = (List<Cliente>) model.get("clientes");
		/* Fuentes, tamaños y colores para cada seccion*/
		Font fuentetitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, Color.white);
		Font fuentetituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.white);
		Font fuenteDataCeldas = FontFactory.getFont(FontFactory.COURIER, 10, Color.BLACK);
		
//		rotar pagina
		document.setPageSize(PageSize.LETTER.rotate());
		document.setMargins(-20, -20, 40, 20);
		HeaderFooter footer = new HeaderFooter(false, new Phrase("Listado Clientes 2022"));
        footer.setAlignment(Element.ALIGN_CENTER);
        footer.setBorderWidthBottom(0);
        document.setFooter(footer);
		document.open();
		
		PdfPCell celda = null;
		
		/*Tabla para el titulo dle PDF*/
		PdfPTable tablaTitulo = new PdfPTable(1);
		
		celda = new PdfPCell(new Phrase("LISTADO GENERAL DE CLIENTES", fuentetitulo));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(0,0,0));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(30);
		
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);
		
		
		/*Tabal para mostrar Listado de Cliente*/
		PdfPTable tablaClientes = new PdfPTable(6);
		tablaClientes.setWidths(new float[] {0.8f, 2f, 2f, 1.5f, 3.5f, 1.5f});
		
		celda = new PdfPCell(new Phrase("ID", fuentetituloColumnas));
		celda.setBackgroundColor(Color.black);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		celda.setBorderColor(Color.white);
		tablaClientes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("NOMBRES", fuentetituloColumnas));
		celda.setBackgroundColor(Color.black);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		celda.setBorderColor(Color.white);
		tablaClientes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("APELLIDOS", fuentetituloColumnas));
		celda.setBackgroundColor(Color.black);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		celda.setBorderColor(Color.white);
		tablaClientes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("TELEFONO", fuentetituloColumnas));
		celda.setBackgroundColor(Color.black);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		celda.setBorderColor(Color.white);
		tablaClientes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("EMAIL", fuentetituloColumnas));
		celda.setBackgroundColor(Color.black);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		celda.setBorderColor(Color.white);
		tablaClientes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("CIUDAD", fuentetituloColumnas));
		celda.setBackgroundColor(Color.black);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		celda.setBorderColor(Color.white);
		tablaClientes.addCell(celda);
		
		
		/*Bucle For, mostrar todos los datos de los clientes*/
		
		for (Cliente cliente : listadoClientes) {
			celda = new PdfPCell(new Phrase(cliente.getId().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(cliente.getNombres(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(cliente.getApellidos(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(cliente.getTelefono(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(cliente.getEmail(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(cliente.getCiudad().getCiudad(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
		}
		
		/*
		 * listadoClientes.forEach(cliente ->{
		 * tablaclientes.addCell(cliente.getId().toString());
		 * tablaclientes.addCell(cliente.getNombres());
		 * tablaclientes.addCell(cliente.getApellidos());
		 * tablaclientes.addCell(cliente.getTelefono());
		 * tablaclientes.addCell(cliente.getEmail());
		 * tablaclientes.addCell(cliente.getCiudad().getCiudad()); });
		 */
		
		/*Anexamos las tablas al documento*/
		document.add(tablaTitulo);
		document.add(tablaClientes);
		
	}

}
