/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.export;

import adsanchez.informecacao.entity.Agricultor;
import adsanchez.informecacao.verificacion.SeccionesVerificacion;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import lombok.Data;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Javier
 */
@Data
public class ExcelVerificacion {
    
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    
    private Agricultor agricultor;
    
    private SeccionesVerificacion seccionesVerificacion;
    
    public ExcelVerificacion(Agricultor agricultor, SeccionesVerificacion seccionesVerificacion){
                
        this.agricultor = agricultor;
        this.seccionesVerificacion = seccionesVerificacion;
        
        InputStream excelMonitoreo =  getClass().getClassLoader().getResourceAsStream("Monitoreo.xlsx");
        
        try {
            workbook = (XSSFWorkbook) WorkbookFactory.create(excelMonitoreo);
        } catch (IOException | InvalidFormatException ex) {
            System.out.println("Formato Erroneo");
        } 
        sheet = workbook.getSheet("Monitoreo");
    }
    
    private void writeDataRow(){
        
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(false);
        font.setFontHeight(9);
        style.setFont(font);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
        
        CellStyle styleBordeAbajo = workbook.createCellStyle();
        styleBordeAbajo.setFont(font);
        styleBordeAbajo.setBorderBottom(CellStyle.BORDER_THIN);
        
        // Fila de Cedula y Nombres Completos
        Row row = sheet.getRow(7);
        Cell cell = row.createCell(18); //S
        cell.setCellValue(agricultor.getDatosPersonales().getCedula());
        cell.setCellStyle(style);
        
        cell = row.createCell(34); //AI
        cell.setCellValue(agricultor.getDatosPersonales().getNombre());
        cell.setCellStyle(style);
        
        //Fila Tecnico
        Row rowTecnico = sheet.getRow(4);
        Cell cellTecnico = rowTecnico.createCell(36); //AK
        cellTecnico.setCellValue(agricultor.getDatosPersonales().getTecnico());
        cellTecnico.setCellStyle(style);
        
        //Fila fecha
        String fecha = agricultor.getDatosPersonales().getFechaVisita();
        String[] fechaSplit = fecha.split("/");
        
//        Timestamp timestamp = Timestamp.valueOf(fecha);
//        Date date = new Date(timestamp.getTime());
//        System.out.println(date);
        
        System.out.println(fecha);
        System.out.println(fechaSplit);
        
        String dia = fechaSplit[0];
        String mes = fechaSplit[1];
        String anio = fechaSplit[2];
        
        Row rowFecha = sheet.getRow(2);
        Cell cellFecha = rowFecha.createCell(40); //AO
        cellFecha.setCellValue(dia);
        cellFecha.setCellStyle(style);
        
        cellFecha = rowFecha.createCell(42); //AQ
        cellFecha.setCellValue(mes);
        cellFecha.setCellStyle(style);
        
        cellFecha = rowFecha.createCell(44); //AS
        cellFecha.setCellValue(anio);
        cellFecha.setCellStyle(style);
        
        // Fila EstadoCivil
        Row rowEstadoCivil = sheet.getRow(11);
        Cell cellEstadoCivil;
        
        switch (agricultor.getDatosPersonales().getEstadoCivil()) {
            case "SOLTERO":
                cellEstadoCivil = rowEstadoCivil.createCell(16); // Q
                cellEstadoCivil.setCellValue("X");
                cellEstadoCivil.setCellStyle(style);
                break;
            case "UNION LIBRE":
                cellEstadoCivil = rowEstadoCivil.createCell(20); // U
                cellEstadoCivil.setCellValue("X");
                cellEstadoCivil.setCellStyle(style);
                break;
            case "SEPARADO/A":
                cellEstadoCivil = rowEstadoCivil.createCell(24); // Y
                cellEstadoCivil.setCellValue("X");
                cellEstadoCivil.setCellStyle(style);
                break;
            case "CASADO/A":
                cellEstadoCivil = rowEstadoCivil.createCell(29); // AD
                cellEstadoCivil.setCellValue("X");
                cellEstadoCivil.setCellStyle(style);
                break;
            case "DIVORCIADO/A":
                cellEstadoCivil = rowEstadoCivil.createCell(33); // AH
                cellEstadoCivil.setCellValue("X");
                cellEstadoCivil.setCellStyle(style);
                break;
            case "VIUDO/A":
                cellEstadoCivil = rowEstadoCivil.createCell(37); // AL
                cellEstadoCivil.setCellValue("X");
                cellEstadoCivil.setCellStyle(style);
                break;
            default:
                break;
        }
        
        // Fila NivelEducacion
        Row rowNivelEducacion = sheet.getRow(13);
        Cell cellNivelEducacion;
        
        switch (agricultor.getDatosPersonales().getNivelEducacion()) {
            case "ANALFABETO":
                cellNivelEducacion = rowNivelEducacion.createCell(16); // Q
                cellNivelEducacion.setCellValue("X");
                cellNivelEducacion.setCellStyle(style);
                break;
            case "PRIMARIA":
                cellNivelEducacion = rowNivelEducacion.createCell(20); // U
                cellNivelEducacion.setCellValue("X");
                cellNivelEducacion.setCellStyle(style);
                break;
            case "SECUNDARIA":
                cellNivelEducacion = rowNivelEducacion.createCell(24); // Y
                cellNivelEducacion.setCellValue("X");
                cellNivelEducacion.setCellStyle(style);
                break;
            case "SUPERIOR":
                cellNivelEducacion = rowNivelEducacion.createCell(29); // AD
                cellNivelEducacion.setCellValue("X");
                cellNivelEducacion.setCellStyle(style);
                break;
            default:
                break;
        }
        
        //Fila Celulares
        List<?> celulares = agricultor.getDatosPersonales().getCelulares();

        Row rowCelulares = sheet.getRow(15);
        
        for(int i=0;i<celulares.size()-1;i++){
            if(!celulares.get(i).equals("")){
                
                Cell cellCelular1 = rowCelulares.createCell(11); //L
                Cell cellCelular2 = rowCelulares.createCell(28); //AC
                
                cellCelular1.setCellValue(celulares.get(i).toString());
                cellCelular1.setCellStyle(style);

                cellCelular2.setCellValue(celulares.get(celulares.size()-1).toString());
                cellCelular2.setCellStyle(style);
                
            }
        }
        
        //Fila Incremento Hectareaje
        String incremento = seccionesVerificacion.getDatosFinca().getIncrementoHectareajeFinca().getRespuesta();
        
        Row rowIncremento = sheet.getRow(19);
        
        if(incremento.equals("NO")){
            
            Cell cellIncremento = rowIncremento.createCell(20); //U
            cellIncremento.setCellValue("X");
            cellIncremento.setCellStyle(style);
            
            Cell cellCuanto = rowIncremento.createCell(30); //AE
            cellCuanto.setCellValue("N/A");
            cellCuanto.setCellStyle(style);
            
            Row rowMes = sheet.getRow(21);
            
            Cell cellMes = rowMes.createCell(13); //N
            cellMes.setCellValue("N/A");
            cellMes.setCellStyle(style);
        }
        
        //Fila injertacion
        
        String injertacion = seccionesVerificacion.getInjertacion().getRealizoInjertosUltimos12Meses().getRespuesta();
        Row rowInjertacion = sheet.getRow(27);
        Cell cellInnjtertacion = rowInjertacion.createCell(27); //AB
        Cell cellInnjtertacionMes = rowInjertacion.createCell(38); //AM
        if(injertacion.equals("SI")){
            cellInnjtertacion.setCellValue("X");
            cellInnjtertacionMes.setCellValue(seccionesVerificacion.getInjertacion().getRealizoInjertosUltimos12Meses().getMesRealizoInjertos());
            cellInnjtertacionMes.setCellStyle(style);
        }
        else{
            cellInnjtertacion = rowInjertacion.createCell(29); //AD
            cellInnjtertacion.setCellValue("X");
            cellInnjtertacion.setCellStyle(style);
            cellInnjtertacionMes.setCellValue("N/A");
            cellInnjtertacionMes.setCellStyle(style);
        }
        
        // Fila Manejo de suelos tipos de suelo
        
        List<?> tipoSuelos = seccionesVerificacion.getManejoSuelo().getTipoSuelo();
        Row rowTipoDeSuelo = sheet.getRow(29);
        Cell cellTipoSuelo = rowTipoDeSuelo.createCell(22); //W
        for(int i = 0; i < tipoSuelos.size()-1; i++){
            if(tipoSuelos.get(i).equals("FRANCO")){
                cellTipoSuelo.setCellValue("X");
                cellTipoSuelo.setCellStyle(style);
            }
            else if(tipoSuelos.get(i).equals("ARENOSO")){
                cellTipoSuelo = rowTipoDeSuelo.createCell(27); //AB
                cellTipoSuelo.setCellValue("X");
                cellTipoSuelo.setCellStyle(style);
            }
            else if(tipoSuelos.get(i).equals("ARCILLOSO")){
                cellTipoSuelo = rowTipoDeSuelo.createCell(32); //AG
                cellTipoSuelo.setCellValue("X");
                cellTipoSuelo.setCellStyle(style);
            }
            else{
                cellTipoSuelo = rowTipoDeSuelo.createCell(36); //AK
                cellTipoSuelo.setCellValue("X");
                cellTipoSuelo.setCellStyle(style);
            }
        }
        
        // Fila capacitacion muestra de suelo
        
        Row rowCapacitacionMuestraSuelo = sheet.getRow(31);
        Cell cellCapacitacionMuestraSuelo = rowCapacitacionMuestraSuelo.createCell(27); //AB
        if(seccionesVerificacion.getManejoSuelo().getCapacitacionTomaMuestrasSuelo().equals("SI")){
            cellCapacitacionMuestraSuelo.setCellValue("X");
            cellCapacitacionMuestraSuelo.setCellStyle(style);
        }
        else{
            cellCapacitacionMuestraSuelo = rowCapacitacionMuestraSuelo.createCell(29); //AD
            cellCapacitacionMuestraSuelo.setCellValue("X");
            cellCapacitacionMuestraSuelo.setCellStyle(style);
        }
        
        // Fila Analisis de suelo
        
        Row rowAnalisisSuelo = sheet.getRow(33);
        Cell cellAnalisisSuelo = rowAnalisisSuelo.createCell(27); //AB
        Cell cellPhSuelo = rowAnalisisSuelo.createCell(38); //AM
        if(seccionesVerificacion.getManejoSuelo().getAnalisisSuelo().getRespuesta().equals("SI")){
            cellAnalisisSuelo.setCellValue("X");
            cellAnalisisSuelo.setCellStyle(style);
            
            cellPhSuelo.setCellValue(seccionesVerificacion.getManejoSuelo().getAnalisisSuelo().getSueloPH());
            cellPhSuelo.setCellStyle(style);
        }
        else{
            cellAnalisisSuelo = rowAnalisisSuelo.createCell(29); //AD
            cellAnalisisSuelo.setCellValue("X");
            cellAnalisisSuelo.setCellStyle(style);
            
            cellPhSuelo.setCellValue("N/A");
            cellPhSuelo.setCellStyle(style);
        }
        
        // Fila Niveles altos de acidez
        
        Row rowAltosNivelesDeAcidez = sheet.getRow(35);
        Cell cellAltosNivelesDeAcidez = rowAltosNivelesDeAcidez.createCell(27); //AB
        Cell cellCorregidoPhSuelo = rowAltosNivelesDeAcidez.createCell(43); //AR
        if(seccionesVerificacion.getManejoSuelo().getSuelosNivelesAltosAcidez().getRespuesta().equals("SI")){
            cellAltosNivelesDeAcidez.setCellValue("X");
            cellAltosNivelesDeAcidez.setCellStyle(style);
        }
        else{
            cellAltosNivelesDeAcidez = rowAltosNivelesDeAcidez.createCell(29); //AD
            cellAltosNivelesDeAcidez.setCellValue("X");
            cellAltosNivelesDeAcidez.setCellStyle(style);
        }
        
        if(seccionesVerificacion.getManejoSuelo().getSuelosNivelesAltosAcidez().getCorregidoPHSueloFinca().equals("SI")){
            cellCorregidoPhSuelo.setCellValue("X");
            cellCorregidoPhSuelo.setCellStyle(style);
        }
        else{
            cellCorregidoPhSuelo = rowAltosNivelesDeAcidez.createCell(45); //AT
            cellCorregidoPhSuelo.setCellValue("X");
            cellCorregidoPhSuelo.setCellStyle(style);
        }
        
        // Filas Corregido ph del suelo
        Row rowQuimico = sheet.getRow(37);
        Row rowNatural = sheet.getRow(39);
        Cell cellQuimico = rowQuimico.createCell(20); //U
        Cell cellNatural = rowNatural.createCell(20); //U 
        List<?> tipoCorregidoSuelo = seccionesVerificacion.getManejoSuelo().getManeraCorregidoPHSuelo().getRespuesta();
        if(tipoCorregidoSuelo.contains("QUIMICO")){
            cellQuimico.setCellValue("X");
            cellQuimico.setCellStyle(style);
            List<?> tipoProductoQuimico = seccionesVerificacion.getManejoSuelo().getManeraCorregidoPHSuelo().getTipoProductoQuimico();
            if(tipoProductoQuimico.contains("CAL AGRICOLA")){
                cellQuimico = rowQuimico.createCell(33); // AH
                cellQuimico.setCellValue("X");
                cellQuimico.setCellStyle(style);
            }
            else if(tipoProductoQuimico.contains("YESO")){
                cellQuimico = rowQuimico.createCell(37); // AL
                cellQuimico.setCellValue("X");
                cellQuimico.setCellStyle(style);
            }
            else if(tipoProductoQuimico.contains("CAL VIVA")){
                cellQuimico = rowQuimico.createCell(41); // AP
                cellQuimico.setCellValue("X");
                cellQuimico.setCellStyle(style);
            }
            else if(tipoProductoQuimico.contains("OTROS")){
                cellQuimico = rowQuimico.createCell(45); // AT
                cellQuimico.setCellValue("X");
                cellQuimico.setCellStyle(style);
            }
        }
        
        if(tipoCorregidoSuelo.contains("NATURAL")){
            cellNatural.setCellValue("X");
            cellNatural.setCellStyle(style);
            List<?> tipoProductoNatural = seccionesVerificacion.getManejoSuelo().getManeraCorregidoPHSuelo().getTipoProductoNatural();
            if(tipoProductoNatural.contains("ACIDOS HUMICOS")){
                cellNatural = rowNatural.createCell(33); // AH
                cellNatural.setCellValue("X");
                cellNatural.setCellStyle(style);
            }
            else if(tipoProductoNatural.contains("ENMIENDAS ORGANICAS")){
                cellNatural = rowNatural.createCell(41); // AP
                cellNatural.setCellValue("X");
                cellNatural.setCellStyle(style);
            }
            else if(tipoProductoNatural.contains("OTROS")){
                cellNatural = rowNatural.createCell(45); // AT
                cellNatural.setCellValue("X");
                cellNatural.setCellStyle(style);
            }
        }
        
        // Filas Cacaotales
        Row rowCacaotales = sheet.getRow(41);
        Cell cellCacaotal = rowCacaotales.createCell(18); // S
        if(seccionesVerificacion.getFertilizacion().getFertilizaCacaotales().getRespuesta().equals("SI")){
            cellCacaotal.setCellValue("X");
            cellCacaotal.setCellStyle(style);
            switch (seccionesVerificacion.getFertilizacion().getFertilizaCacaotales().getTipoProductoUsado()) {
                case "QUIMICO":
                    cellCacaotal = rowCacaotales.createCell(37); // AL
                    cellCacaotal.setCellValue("X");
                    cellCacaotal.setCellStyle(style);
                    break;
                case "NATURAL":
                    cellCacaotal = rowCacaotales.createCell(41); // AP
                    cellCacaotal.setCellValue("X");
                    cellCacaotal.setCellStyle(style);
                    break;
                case "AMBOS":
                    cellCacaotal = rowCacaotales.createCell(45); // AT
                    cellCacaotal.setCellValue("X");
                    cellCacaotal.setCellStyle(style);
                    break;
                default:
                    break;
            }
        }
        else{
            cellCacaotal = rowCacaotales.createCell(20); // U
            cellCacaotal.setCellValue("X");
            cellCacaotal.setCellStyle(style);
        }
        
        // Filas Fertilizante Edafico
        Row rowFertilizanteEfatico = sheet.getRow(43);
        Cell cellFertilizanteEdafico = rowFertilizanteEfatico.createCell(18); // S
        if(seccionesVerificacion.getFertilizacion().getUsaFertilizanteEdafico().getRespuesta().equals("SI")){
            cellFertilizanteEdafico.setCellValue("X");
            cellFertilizanteEdafico.setCellStyle(style);
            switch (seccionesVerificacion.getFertilizacion().getUsaFertilizanteEdafico().getVecesUsadoAlAnioFertilizanteEdafico()) {
                case "1 A 2 VECES":
                    cellFertilizanteEdafico = rowFertilizanteEfatico.createCell(33); // AH
                    cellFertilizanteEdafico.setCellValue("X");
                    cellFertilizanteEdafico.setCellStyle(style);
                    break;
                case "3 A 4 VECES":
                    cellFertilizanteEdafico = rowFertilizanteEfatico.createCell(37); // AL
                    cellFertilizanteEdafico.setCellValue("X");
                    cellFertilizanteEdafico.setCellStyle(style);
                    break;
                case "4 A 5 VECES":
                    cellFertilizanteEdafico = rowFertilizanteEfatico.createCell(41); // AP
                    cellFertilizanteEdafico.setCellValue("X");
                    cellFertilizanteEdafico.setCellStyle(style);
                    break;
                default:
                    break;
            }
        }
        else{
            cellFertilizanteEdafico = rowFertilizanteEfatico.createCell(20); // U
            cellFertilizanteEdafico.setCellValue("X");
            cellFertilizanteEdafico.setCellStyle(style);
            
            cellFertilizanteEdafico = rowFertilizanteEfatico.createCell(45); // AT
            cellFertilizanteEdafico.setCellValue("X");
            cellFertilizanteEdafico.setCellStyle(style);
        }
        
        // Filas Fertilizante Foliar
        Row rowFertilizanteFoliar = sheet.getRow(45);
        Cell cellFertilizanteFoliar = rowFertilizanteFoliar.createCell(18); // S
        if(seccionesVerificacion.getFertilizacion().getUsaFertilizanteFoliar().getRespuesta().equals("SI")){
            cellFertilizanteFoliar.setCellValue("X");
            cellFertilizanteFoliar.setCellStyle(style);
            switch (seccionesVerificacion.getFertilizacion().getUsaFertilizanteFoliar().getVecesUsadoAlAnioFertilizanteFoliar()) {
                case "1 A 2 VECES":
                    cellFertilizanteFoliar = rowFertilizanteFoliar.createCell(33); // AH
                    cellFertilizanteFoliar.setCellValue("X");
                    cellFertilizanteFoliar.setCellStyle(style);
                    break;
                case "3 A 4 VECES":
                    cellFertilizanteFoliar = rowFertilizanteFoliar.createCell(37); // AL
                    cellFertilizanteFoliar.setCellValue("X");
                    cellFertilizanteFoliar.setCellStyle(style);
                    break;
                case "4 A 5 VECES":
                    cellFertilizanteFoliar = rowFertilizanteFoliar.createCell(41); // AP
                    cellFertilizanteFoliar.setCellValue("X");
                    cellFertilizanteFoliar.setCellStyle(style);
                    break;
                default:
                    break;
            }
        }
        else{
            cellFertilizanteFoliar = rowFertilizanteFoliar.createCell(20); // U
            cellFertilizanteFoliar.setCellValue("X");
            cellFertilizanteFoliar.setCellStyle(style);
            
            cellFertilizanteEdafico = rowFertilizanteFoliar.createCell(45); // AT
            cellFertilizanteEdafico.setCellValue("X");
            cellFertilizanteEdafico.setCellStyle(style);
        }
        
        // Filas Recibidos
        Row rowRecibido = sheet.getRow(49);
        Cell cellRecibido = rowRecibido.createCell(18); // S
        if(seccionesVerificacion.getFertilizacion().getRecibidoFertilizanteKits().getRespuesta().equals("SI")){
            cellRecibido.setCellValue("X");
            cellRecibido.setCellStyle(style);
            switch (seccionesVerificacion.getFertilizacion().getRecibidoFertilizanteKits().getTipoFertilizanteRecibido()) {
                case "EDAFICO":
                    rowRecibido = sheet.getRow(47);
                    cellRecibido = rowRecibido.createCell(29); // AD
                    cellRecibido.setCellValue("X");
                    cellRecibido.setCellStyle(style);
                    break;
                case "FOLIAR":
                    rowRecibido = sheet.getRow(47);
                    cellRecibido = rowRecibido.createCell(37); // AL
                    cellRecibido.setCellValue("X");
                    cellRecibido.setCellStyle(style);
                    break;
                case "BIOLES":
                    rowRecibido = sheet.getRow(47);
                    cellRecibido = rowRecibido.createCell(45); // AT
                    cellRecibido.setCellValue("X");
                    cellRecibido.setCellStyle(style);
                    break;
                case "BIOESTIMULANTES":
                    rowRecibido = sheet.getRow(49);
                    cellRecibido = rowRecibido.createCell(29); // AD
                    cellRecibido.setCellValue("X");
                    cellRecibido.setCellStyle(style);
                    break;
                case "CORRECTORES DE PH":
                    rowRecibido = sheet.getRow(49);
                    cellRecibido = rowRecibido.createCell(37); // AL
                    cellRecibido.setCellValue("X");
                    cellRecibido.setCellStyle(style);
                    break;
                case "FUNGICIDAS":
                    rowRecibido = sheet.getRow(49);
                    cellRecibido = rowRecibido.createCell(45); // AT
                    cellRecibido.setCellValue("X");
                    cellRecibido.setCellStyle(style);
                    break;
                case "INSECTICIDAS":
                    rowRecibido = sheet.getRow(51);
                    cellRecibido = rowRecibido.createCell(29); // AD
                    cellRecibido.setCellValue("X");
                    cellRecibido.setCellStyle(style);
                    break;
                default:
                    break;
            }
        }
        else{
            cellRecibido = rowRecibido.createCell(20); // U
            cellRecibido.setCellValue("X");
            cellRecibido.setCellStyle(style);
        }
        
        // Filas Opinion Fertilizante
        Row rowOpinionFertilizante = sheet.getRow(53);
        Cell cellOpinionFertilizante = rowOpinionFertilizante.createCell(29); // AD
        switch (seccionesVerificacion.getFertilizacion().getOpinionEfectividadFertilizante()) {
            case "AUMENTA PRODUCCION":
                cellOpinionFertilizante.setCellValue("X");
                cellOpinionFertilizante.setCellStyle(style);
                break;
            case "SE MANTIENE IGUAL":
                cellOpinionFertilizante = rowOpinionFertilizante.createCell(37); // AL
                cellOpinionFertilizante.setCellValue("X");
                cellOpinionFertilizante.setCellStyle(style);
                break;
            case "DISMINUYE PRODUCCION":
                cellOpinionFertilizante = rowOpinionFertilizante.createCell(45); // AT
                cellOpinionFertilizante.setCellValue("X");
                cellOpinionFertilizante.setCellStyle(style);
                break;
            default:
                break;
        }
        
        // Filas RepetirCompra
        Row rowRepetirCompra = sheet.getRow(55);
        Cell cellRepetirCompra = rowRepetirCompra.createCell(22); // W
        if(seccionesVerificacion.getFertilizacion().getRepetirCompraConDescuento().equals("SI")){
            cellRepetirCompra.setCellValue("X");
            cellRepetirCompra.setCellStyle(style);
        }
        else{
            cellRepetirCompra = rowRepetirCompra.createCell(24); // Y
            cellRepetirCompra.setCellValue("X");
            cellRepetirCompra.setCellStyle(style);
        }
        // Filas DismuidoUsoProductosQuimico
        Row rowDismuidoUsoProductosQuimicos = sheet.getRow(57);
        Cell cellDismuidoUsoProductosQuimico = rowDismuidoUsoProductosQuimicos.createCell(22); // W
        if(seccionesVerificacion.getFertilizacion().getDisminuidoProductosQuimicosPorOrganicos().equals("SI")){
            cellDismuidoUsoProductosQuimico.setCellValue("X");
            cellDismuidoUsoProductosQuimico.setCellStyle(style);
        }
        else{
            cellDismuidoUsoProductosQuimico = rowDismuidoUsoProductosQuimicos.createCell(24); // Y
            cellDismuidoUsoProductosQuimico.setCellValue("X");
            cellDismuidoUsoProductosQuimico.setCellStyle(style);
        }
        
        // Filas BodegaParaAlmacenar
        Row rowBodegaParaAlmacenar = sheet.getRow(59);
        Cell cellBodegaParaAlmacenar = rowBodegaParaAlmacenar.createCell(27); // AB
        if(seccionesVerificacion.getBodega().getPoseeBodega().equals("SI")){
            cellBodegaParaAlmacenar.setCellValue("X");
            cellBodegaParaAlmacenar.setCellStyle(style);
        }
        else{
            cellBodegaParaAlmacenar = rowBodegaParaAlmacenar.createCell(29); // AD
            cellBodegaParaAlmacenar.setCellValue("X");
            cellBodegaParaAlmacenar.setCellStyle(style);
        }
        
        // Filas Bodega Segura
        Row rowBodegaSegura = sheet.getRow(61);
        Cell cellBodegaSegura = rowBodegaSegura.createCell(18); // S
        if(seccionesVerificacion.getBodega().getBodegaSegura().equals("SI")){
            cellBodegaSegura.setCellValue("X");
            cellBodegaSegura.setCellStyle(style);
        }
        else{
            cellBodegaSegura = rowBodegaSegura.createCell(20); // U
            cellBodegaSegura.setCellValue("X");
            cellBodegaSegura.setCellStyle(style);
        }
        
        // Filas Bodega Ordenada
        Row rowBodegaOrdenada = sheet.getRow(61);
        Cell cellBodegaOrdenada = rowBodegaOrdenada.createCell(33); // AH
        if(seccionesVerificacion.getBodega().getPoseeBodega().equals("SI")){
            cellBodegaOrdenada.setCellValue("X");
            cellBodegaOrdenada.setCellStyle(style);
        }
        else{
            rowBodegaOrdenada = sheet.getRow(63);
            cellBodegaOrdenada = rowBodegaOrdenada.createCell(33); // AH
            cellBodegaOrdenada.setCellValue("X");
            cellBodegaOrdenada.setCellStyle(style);
        }
        
        // Filas Bodega Clasificada
        Row rowBodegaClasificada = sheet.getRow(61);
        Cell cellBodegaClasificada = rowBodegaClasificada.createCell(45); // AT
        if(seccionesVerificacion.getBodega().getPoseeBodega().equals("SI")){
            cellBodegaClasificada.setCellValue("X");
            cellBodegaClasificada.setCellStyle(style);
        }
        else{
            rowBodegaClasificada = sheet.getRow(63);
            cellBodegaClasificada = rowBodegaClasificada.createCell(45); // AT
            cellBodegaClasificada.setCellValue("X");
            cellBodegaClasificada.setCellStyle(style);
        }
        
        // Filas Registro de lo que almacena
        Row rowRegistroAlmacena = sheet.getRow(65);
        Cell cellRegistroAlmacena = rowRegistroAlmacena.createCell(18); // S
        if(seccionesVerificacion.getBodega().getTieneRegistroAlmacena().equals("SI")){
            cellRegistroAlmacena.setCellValue("X");
            cellRegistroAlmacena.setCellStyle(style);
        }
        else{
            cellRegistroAlmacena = rowRegistroAlmacena.createCell(20); // U
            cellRegistroAlmacena.setCellValue("X");
            cellRegistroAlmacena.setCellStyle(style);
        }
        
        // Filas Ducha Emergencia
        Row rowDuchaEmergencia = sheet.getRow(65);
        Cell cellDuchaEmergencia = rowDuchaEmergencia.createCell(35); // AJ
        if(seccionesVerificacion.getBodega().getCuentaDuchaEmergencia().equals("SI")){
            cellDuchaEmergencia.setCellValue("X");
            cellDuchaEmergencia.setCellStyle(style);
        }
        else{
            cellDuchaEmergencia = rowDuchaEmergencia.createCell(37); // AL
            cellDuchaEmergencia.setCellValue("X");
            cellDuchaEmergencia.setCellStyle(style);
        }
        
        // Filas Conocimientos Lista Productos
        Row rowConocimientosListaProductos = sheet.getRow(67);
        Cell cellConocimientosListaProductos = rowConocimientosListaProductos.createCell(33); // AH
        if(seccionesVerificacion.getBodega().getConocimientoProductosPermitidosLINDT().equals("SI")){
            cellConocimientosListaProductos.setCellValue("X");
            cellConocimientosListaProductos.setCellStyle(style);
        }
        else{
            cellConocimientosListaProductos = rowConocimientosListaProductos.createCell(35); // AJ
            cellConocimientosListaProductos.setCellValue("X");
            cellConocimientosListaProductos.setCellStyle(style);
        }
        
        // Filas Controla Malezas
        Row rowControlaMalezas = sheet.getRow(72);
        Cell cellControlaMalezas = rowControlaMalezas.createCell(18); // S
        if(seccionesVerificacion.getControlMalezas().getControlaMalezas().getRespuesta().equals("SI")){
            cellControlaMalezas.setCellValue("X");
            cellControlaMalezas.setCellStyle(style);
        }
        else{
            cellControlaMalezas = rowControlaMalezas.createCell(20); // U
            cellControlaMalezas.setCellValue("X");
            cellControlaMalezas.setCellStyle(style);
        }
        
        // Filas Tipo Malezas
        Row rowTipoMalezas = sheet.getRow(72);
        Cell cellTipoMalezas = rowTipoMalezas.createCell(41); // AP
        switch (seccionesVerificacion.getControlMalezas().getControlaMalezas().getTiposMalezaEncontrada()) {
            case "HOJA ANCHA":
                cellTipoMalezas.setCellValue("X");
                cellTipoMalezas.setCellStyle(style);
                break;
            case "HOJA ANGOSTA":
                cellTipoMalezas = rowTipoMalezas.createCell(45); // AT
                cellTipoMalezas.setCellValue("X");
                cellTipoMalezas.setCellStyle(style);
                break;
            case "AMBAS":
                cellTipoMalezas.setCellValue("X");
                cellTipoMalezas.setCellStyle(style);
                cellTipoMalezas = rowTipoMalezas.createCell(45); // AT
                cellTipoMalezas.setCellValue("X");
                cellTipoMalezas.setCellStyle(style);
                break;
            default:
                break;
        }
        
        // Filas Control Malezas
        Row rowControlMalezas = sheet.getRow(74);
        Cell cellControlMalezas = rowControlMalezas.createCell(24); // Y
        List<?> comoControlMalezas = seccionesVerificacion.getControlMalezas().getControlaMalezas().getComoControlaMaleza().getRespuesta();
        if(comoControlMalezas.contains("QUIMICO")){
            cellControlMalezas.setCellValue("X");
            cellControlMalezas.setCellStyle(style);
        }
        if(comoControlMalezas.contains("MECANICO/MANUAL")){
            cellControlMalezas = rowControlMalezas.createCell(33); // AH
            cellControlMalezas.setCellValue("X");
            cellControlMalezas.setCellStyle(style);
        }
        if(comoControlMalezas.contains("NATURAL/ORGANICO")){
            cellControlMalezas = rowControlMalezas.createCell(41); // AP
            cellControlMalezas.setCellValue("X");
            cellControlMalezas.setCellStyle(style);
        }
        
        // Filas Control Mecanico
        Row rowControlMecanico = sheet.getRow(76);
        Cell cellControlMecanico = rowControlMecanico.createCell(20); // U
        if(seccionesVerificacion.getControlMalezas().getConocimientoDisposicionMaquinariaAgricola().getRespuesta().equals("SI")){
            cellControlMecanico.setCellValue("X");
            cellControlMecanico.setCellStyle(style);
        }
        else{
            rowControlMecanico = sheet.getRow(78);
            cellControlMecanico = rowControlMecanico.createCell(20); // U
            cellControlMecanico.setCellValue("X");
            cellControlMecanico.setCellStyle(style);
        }
        
        // Filas Uso de la misma
        Row rowUso = sheet.getRow(76);
        Cell cellUso = rowUso.createCell(33); // AH
        switch (seccionesVerificacion.getControlMalezas().getConocimientoDisposicionMaquinariaAgricola().getHaceUsoMisma()) {
            case "1 A 2 VECES":
                cellUso.setCellValue("X");
                cellUso.setCellStyle(style);
                break;
            case "3 A 4 VECES":
                cellUso = rowUso.createCell(37); // AL
                cellUso.setCellValue("X");
                cellUso.setCellStyle(style);
                break;
            case "5 O MAS VECES":
                cellUso = rowUso.createCell(41); // AP
                cellUso.setCellValue("X");
                cellUso.setCellStyle(style);
                break;
            default:
                cellUso = rowUso.createCell(45); // AT
                cellUso.setCellValue("X");
                cellUso.setCellStyle(style);
                break;
        }
        // Filas TiempoPromedio
        Row rowTiempoPromedio = sheet.getRow(78);
        Cell cellTiempoPromedio = rowTiempoPromedio.createCell(35); // AJ
        cellTiempoPromedio.setCellValue(seccionesVerificacion.getControlMalezas().getConocimientoDisposicionMaquinariaAgricola().getTiempoPromedioUso());
        cellTiempoPromedio.setCellStyle(style);
        
        // Filas ControlQuimico
        Row rowControlQuimico = sheet.getRow(80);
        Cell cellControlQuimico = rowControlQuimico.createCell(21); // V
        cellControlQuimico.setCellValue(seccionesVerificacion.getControlMalezas().getControlaMalezas().getComoControlaMaleza().getProductoQuimicoUsado());
        cellControlQuimico.setCellStyle(style);
        
        // Filas Regularidad
        Row rowRegularidad = sheet.getRow(82);
        Cell cellRegularidad = rowRegularidad.createCell(24); // Y
        switch (seccionesVerificacion.getControlMalezas().getControlaMalezas().getComoControlaMaleza().getRegularidadProductoQuimicoUsado()) {
            case "1 VEZ":
                cellRegularidad.setCellValue("X");
                cellRegularidad.setCellStyle(style);
                break;
            case "2 VECES":
                cellRegularidad = rowRegularidad.createCell(29); // AD
                cellRegularidad.setCellValue("X");
                cellRegularidad.setCellStyle(style);
                break;
            case "3 VECES":
                cellRegularidad = rowRegularidad.createCell(33); // AH
                cellRegularidad.setCellValue("X");
                cellRegularidad.setCellStyle(style);
                break;
            case "MAS VECES":
                cellRegularidad = rowRegularidad.createCell(37); // AL
                cellRegularidad.setCellValue("X");
                cellRegularidad.setCellStyle(style);
                break;
            default:
                cellRegularidad = rowRegularidad.createCell(41); // AP
                cellRegularidad.setCellValue("X");
                cellRegularidad.setCellStyle(style);
                break;
        }
        
        // Filas Recomendacion
        Row rowRecomendacion = sheet.getRow(84);
        Cell cellRecomendacion = rowRecomendacion.createCell(29); // AD
        switch (seccionesVerificacion.getControlMalezas().getControlaMalezas().getComoControlaMaleza().getRecomendacionSeguidaAplicandoProductoQuimico()) {
            case "SI":
                cellRecomendacion.setCellValue("X");
                cellRecomendacion.setCellStyle(style);
                break;
            case "TECNICO":
                cellRecomendacion = rowRecomendacion.createCell(33); // AH
                cellRecomendacion.setCellValue("X");
                cellRecomendacion.setCellStyle(style);
                break;
            case "EMPIRICO":
                cellRecomendacion = rowRecomendacion.createCell(37); // AL
                cellRecomendacion.setCellValue("X");
                cellRecomendacion.setCellStyle(style);
                break;
            default:
                break;
        }
        
        // Filas RealizaPoda
        Row rowRealizaPoda = sheet.getRow(86);
        Cell cellRealizaPoda = rowRealizaPoda.createCell(18); // S
        if(seccionesVerificacion.getPoda().getRealizaPoda().getRespuesta().equals("SI")){
            cellRealizaPoda.setCellValue("X");
            cellRealizaPoda.setCellStyle(style);
        }
        else{
            cellRealizaPoda = rowRealizaPoda.createCell(20); // U
            cellRealizaPoda.setCellValue("X");
            cellRealizaPoda.setCellStyle(style);
        }
        
        // Filas TipoPoda
        Row rowTipoPoda = sheet.getRow(88);
        Cell cellTipoPoda = rowTipoPoda.createCell(33); // AH
        if(seccionesVerificacion.getPoda().getRealizaPoda().getTipoPoda().contains("FORMACION")){
            cellTipoPoda.setCellValue("X");
            cellTipoPoda.setCellStyle(style);
        }
        if(seccionesVerificacion.getPoda().getRealizaPoda().getTipoPoda().contains("MANTENIMIENTO")){
            rowTipoPoda.createCell(37); // AL
            cellTipoPoda.setCellValue("X");
            cellTipoPoda.setCellStyle(style);
        }
        if(seccionesVerificacion.getPoda().getRealizaPoda().getTipoPoda().contains("FITOSANITARIA")){
            rowTipoPoda.createCell(41); // AP
            cellTipoPoda.setCellValue("X");
            cellTipoPoda.setCellStyle(style);
        }
        if(seccionesVerificacion.getPoda().getRealizaPoda().getTipoPoda().contains("REHABILITACION")){
            rowTipoPoda.createCell(45); // AT
            cellTipoPoda.setCellValue("X");
            cellTipoPoda.setCellStyle(style);
        }
        
        // Filas PodaCorrecta
        Row rowPodaCorrecta = sheet.getRow(92);
        Cell cellPodaCorrecta = rowPodaCorrecta.createCell(31); // AF
        if(seccionesVerificacion.getPoda().getRealizaPoda().getRealizaPodaFormacion().getRespuesta().equals("SI")){
            cellPodaCorrecta.setCellValue("X");
            cellPodaCorrecta.setCellStyle(style);
        }
        else{
            cellPodaCorrecta = rowPodaCorrecta.createCell(33); // AH
            cellPodaCorrecta.setCellValue("X");
            cellPodaCorrecta.setCellStyle(style);
        }
        
        if(seccionesVerificacion.getPoda().getRealizaPoda().getRealizaPodaMantenimiento().getRespuesta().equals("SI")){
            cellPodaCorrecta = rowPodaCorrecta.createCell(35); // AJ
            cellPodaCorrecta.setCellValue("X");
            cellPodaCorrecta.setCellStyle(style);
        }
        else{
            cellPodaCorrecta = rowPodaCorrecta.createCell(37); // AL
            cellPodaCorrecta.setCellValue("X");
            cellPodaCorrecta.setCellStyle(style);
        }
        if(seccionesVerificacion.getPoda().getRealizaPoda().getRealizaPodaFitosanitaria().getRespuesta().equals("SI")){
            cellPodaCorrecta = rowPodaCorrecta.createCell(39); // AN
            cellPodaCorrecta.setCellValue("X");
            cellPodaCorrecta.setCellStyle(style);
        }
        else{
            cellPodaCorrecta = rowPodaCorrecta.createCell(41); // AP
            cellPodaCorrecta.setCellValue("X");
            cellPodaCorrecta.setCellStyle(style);
        }
        if(seccionesVerificacion.getPoda().getRealizaPoda().getRealizaPodaRehabilitacion().getRespuesta().equals("SI")){
            cellPodaCorrecta = rowPodaCorrecta.createCell(43); // AR
            cellPodaCorrecta.setCellValue("X");
            cellPodaCorrecta.setCellStyle(style);
        }
        else{
            cellPodaCorrecta = rowPodaCorrecta.createCell(45); // AT
            cellPodaCorrecta.setCellValue("X");
            cellPodaCorrecta.setCellStyle(style);
        }
        
        // Filas Observa
        Row rowObserva = sheet.getRow(94);
        Cell cellObserva = rowObserva.createCell(22); // W
        if(seccionesVerificacion.getPoda().getCortesLaceracionesPlantaMalaPoda().equals("SI")){
            cellObserva.setCellValue("X");
            cellObserva.setCellStyle(style);
        }
        else{
            cellObserva = rowObserva.createCell(24); // Y
            cellObserva.setCellValue("X");
            cellObserva.setCellStyle(style);
        }
        if(seccionesVerificacion.getPoda().getMazorcasEstadoPudricion().equals("SI")){
            cellObserva = rowObserva.createCell(43); // AR
            cellObserva.setCellValue("X");
            cellObserva.setCellStyle(style);
        }
        else{
            cellObserva = rowObserva.createCell(45); // AT
            cellObserva.setCellValue("X");
            cellObserva.setCellStyle(style);
        }
        
        // Filas AlbergaPlagasEnfermedades
        Row rowAlbergaPlagasEnfermedades = sheet.getRow(96);
        Cell cellAlbergaPlagasEnfermedades = rowAlbergaPlagasEnfermedades.createCell(20); // U
        if(seccionesVerificacion.getPoda().getMalaPodaAlbergaPlagasEnfermedades().getRespuesta().equals("SI")){
            cellAlbergaPlagasEnfermedades.setCellValue("X");
            cellAlbergaPlagasEnfermedades.setCellStyle(style);
        }
        else{
            rowAlbergaPlagasEnfermedades = sheet.getRow(98);
            cellAlbergaPlagasEnfermedades = rowAlbergaPlagasEnfermedades.createCell(20); // U
            cellAlbergaPlagasEnfermedades.setCellValue("X");
            cellAlbergaPlagasEnfermedades.setCellStyle(style);
        }
        
        // Filas Plagas
        Row rowPlagas = sheet.getRow(98);
        Cell cellPlagas = rowPlagas.createCell(29); // AD
        if(seccionesVerificacion.getPoda().getMalaPodaAlbergaPlagasEnfermedades().getPlagasMalaPoda().contains("XILEBORUS")){
            cellPlagas.setCellValue("X");
            cellPlagas.setCellStyle(style);
        }
        if(seccionesVerificacion.getPoda().getMalaPodaAlbergaPlagasEnfermedades().getPlagasMalaPoda().contains("CHINCHORRO")){
            cellPlagas = rowPlagas.createCell(33); // AH
            cellPlagas.setCellValue("X");
            cellPlagas.setCellStyle(style);
        }
        if(seccionesVerificacion.getPoda().getMalaPodaAlbergaPlagasEnfermedades().getPlagasMalaPoda().contains("HORMIGA")){
            cellPlagas = rowPlagas.createCell(37); // AL
            cellPlagas.setCellValue("X");
            cellPlagas.setCellStyle(style);
        }
        if(seccionesVerificacion.getPoda().getMalaPodaAlbergaPlagasEnfermedades().getPlagasMalaPoda().contains("OTROS")){
            cellPlagas = rowPlagas.createCell(41); // AP
            cellPlagas.setCellValue("X");
            cellPlagas.setCellStyle(style);
        }
        
        // Filas Enfermedades
        Row rowEnfermedades = sheet.getRow(98);
        Cell cellEnfermedades = rowEnfermedades.createCell(29); // AD
        if(seccionesVerificacion.getPoda().getMalaPodaAlbergaPlagasEnfermedades().getEnfermedadesMalaPoda().contains("PHYTOPHTORA")){
            cellEnfermedades.setCellValue("X");
            cellEnfermedades.setCellStyle(style);
        }
        if(seccionesVerificacion.getPoda().getMalaPodaAlbergaPlagasEnfermedades().getEnfermedadesMalaPoda().contains("MAL DE MACHETE")){
            cellEnfermedades = rowEnfermedades.createCell(33); // AH
            cellEnfermedades.setCellValue("X");
            cellEnfermedades.setCellStyle(style);
        }
        if(seccionesVerificacion.getPoda().getMalaPodaAlbergaPlagasEnfermedades().getEnfermedadesMalaPoda().contains("ROSELLINIA")){
            cellEnfermedades = rowEnfermedades.createCell(37); // AL
            cellEnfermedades.setCellValue("X");
            cellEnfermedades.setCellStyle(style);
        }
        if(seccionesVerificacion.getPoda().getMalaPodaAlbergaPlagasEnfermedades().getEnfermedadesMalaPoda().contains("OTROS")){
            cellEnfermedades = rowEnfermedades.createCell(41); // AP
            cellEnfermedades.setCellValue("X");
            cellEnfermedades.setCellStyle(style);
        }
        
        // Filas MIPE
        Row rowPracticasMIPE = sheet.getRow(104);
        Cell cellPracticasMIPE = rowPracticasMIPE.createCell(18); // S
        if(seccionesVerificacion.getMipe().getRealizaPracticasMPE().getRespuesta().equals("SI")){
            cellPracticasMIPE.setCellValue("X");
            cellPracticasMIPE.setCellStyle(style);
        }
        else{
            cellPracticasMIPE = rowPracticasMIPE.createCell(20); // U
            cellPracticasMIPE.setCellValue("X");
            cellPracticasMIPE.setCellStyle(style);
        }
        
        // Filas TipoControl
        Row rowTipoControl = sheet.getRow(106);
        Cell cellTipoControl = rowTipoControl.createCell(29); // AD
        if(seccionesVerificacion.getMipe().getRealizaPracticasMPE().getTipoControlMPE().contains("QUIMICO")){
            cellTipoControl.setCellValue("X");
            cellTipoControl.setCellStyle(style);
        }
        if(seccionesVerificacion.getMipe().getRealizaPracticasMPE().getTipoControlMPE().contains("MECANICO/MANUAL")){
            cellTipoControl = rowTipoControl.createCell(33); // AH
            cellTipoControl.setCellValue("X");
            cellTipoControl.setCellStyle(style);
        }
        if(seccionesVerificacion.getMipe().getRealizaPracticasMPE().getTipoControlMPE().contains("BIOLOGICO")){
            cellTipoControl = rowTipoControl.createCell(37); // AL
            cellTipoControl.setCellValue("X");
            cellTipoControl.setCellStyle(style);
        }
        
        // Filas AplicacionRealizada
        Row rowAplicacionRealizada = sheet.getRow(108);
        Cell cellAplicacionRealizada = rowAplicacionRealizada.createCell(27); // AB
        if(seccionesVerificacion.getMipe().getCorrigioProblemasMPE().equals("SI")){
            cellAplicacionRealizada.setCellValue("X");
            cellAplicacionRealizada.setCellStyle(style);
        }
        else{
            cellAplicacionRealizada = rowAplicacionRealizada.createCell(29); // AD
            cellAplicacionRealizada.setCellValue("X");
            cellAplicacionRealizada.setCellStyle(style);
        }
        
        // Filas LibreAplicacionQuimica
        Row rowLibreAplicacionQuimica = sheet.getRow(110);
        Cell cellLibreAplicacionQuimica = rowLibreAplicacionQuimica.createCell(27); // AB
        if(seccionesVerificacion.getMipe().getFincaLibreAplicacionQuimica().equals("SI")){
            cellLibreAplicacionQuimica.setCellValue("X");
            cellLibreAplicacionQuimica.setCellStyle(style);
        }
        else{
            cellLibreAplicacionQuimica = rowLibreAplicacionQuimica.createCell(29); // AD
            cellLibreAplicacionQuimica.setCellValue("X");
            cellLibreAplicacionQuimica.setCellStyle(style);
        }
        
        // Filas ControlarEnfermedades
        Row rowControlarEnfermedades = sheet.getRow(112);
        Cell cellControlarEnfermedades = rowControlarEnfermedades.createCell(27); // AB
        if(seccionesVerificacion.getMipe().getControlaEnfermedades().equals("SI")){
            cellControlarEnfermedades.setCellValue("X");
            cellControlarEnfermedades.setCellStyle(style);
        }
        else{
            cellControlarEnfermedades = rowControlarEnfermedades.createCell(29); // AD
            cellControlarEnfermedades.setCellValue("X");
            cellControlarEnfermedades.setCellStyle(style);
        }
        
        // Filas AplicaCriterios
//        Row rowAplicaCriterios = sheet.getRow(112);
//        Cell cellAplicaCriterios = rowAplicaCriterios.createCell(27); // AB
//        if(seccionesVerificacion.getMipe().get.equals("SI")){
//            cellAplicaCriterios.setCellValue("X");
//            cellAplicaCriterios.setCellStyle(style);
//        }
//        else{
//            cellAplicaCriterios = rowAplicaCriterios.createCell(29); // AD
//            cellAplicaCriterios.setCellValue("X");
//            cellAplicaCriterios.setCellStyle(style);
//        }

        // Filas CapacitacionesSSO
        Row rowCapacitacionesSSO = sheet.getRow(116);
        Cell cellCapacitacionesSSO = rowCapacitacionesSSO.createCell(18); // S
        if(seccionesVerificacion.getSaludSeguridad().getTrabajadoresLlevadosCapacitacionesSSO().equals("SI")){
            cellCapacitacionesSSO.setCellValue("X");
            cellCapacitacionesSSO.setCellStyle(style);
        }
        else{
            rowCapacitacionesSSO = sheet.getRow(118);
            cellCapacitacionesSSO = rowCapacitacionesSSO.createCell(18); // S
            cellCapacitacionesSSO.setCellValue("X");
            cellCapacitacionesSSO.setCellStyle(style);
        }
        
        // Filas BuenasPracticasFinca
        Row rowBuenasPracticasFinca = sheet.getRow(116);
        Cell cellBuenasPracticasFinca = rowBuenasPracticasFinca.createCell(31); // AF
        if(seccionesVerificacion.getSaludSeguridad().getBuenasPracticasFincaTrabajadores().equals("SI")){
            cellBuenasPracticasFinca.setCellValue("X");
            cellBuenasPracticasFinca.setCellStyle(style);
        }
        else{
            rowBuenasPracticasFinca = sheet.getRow(118);
            cellBuenasPracticasFinca = rowBuenasPracticasFinca.createCell(31); // AF
            cellBuenasPracticasFinca.setCellValue("X");
            cellBuenasPracticasFinca.setCellStyle(style);
        }
        
        // Filas EPP
        Row rowEPP = sheet.getRow(116);
        Cell cellEPP = rowEPP.createCell(45); // AT
        if(seccionesVerificacion.getSaludSeguridad().getEppAntesPlaguicida().equals("SI")){
            cellEPP.setCellValue("X");
            cellEPP.setCellStyle(style);
        }
        else{
            rowEPP = sheet.getRow(119);
            cellEPP = rowEPP.createCell(45); // AT
            cellEPP.setCellValue("X");
            cellEPP.setCellStyle(style);
        }
        
        // Filas Pictograma
        Row rowPictograma = sheet.getRow(120);
        Cell cellPictograma = rowPictograma.createCell(18); // S
        if(seccionesVerificacion.getSaludSeguridad().getUsoPictograma().equals("SI")){
            cellPictograma.setCellValue("X");
            cellPictograma.setCellStyle(style);
        }
        else{
            rowPictograma = sheet.getRow(122);
            cellPictograma = rowPictograma.createCell(18); // S
            cellPictograma.setCellValue("X");
            cellPictograma.setCellStyle(style);
        }
        
        // Filas Botiquin
        Row rowBotiquin = sheet.getRow(120);
        Cell cellBotiquin = rowBotiquin.createCell(31); // AF
        if(seccionesVerificacion.getSaludSeguridad().getBotiquin().equals("SI")){
            cellBotiquin.setCellValue("X");
            cellBotiquin.setCellStyle(style);
        }
        else{
            rowBotiquin = sheet.getRow(122);
            cellBotiquin = rowBotiquin.createCell(31); // AF
            cellBotiquin.setCellValue("X");
            cellBotiquin.setCellStyle(style);
        }
        
        // Filas PrimerosAuxilios
        Row rowPrimerosAuxilios = sheet.getRow(120);
        Cell cellPrimerosAuxilios = rowPrimerosAuxilios.createCell(45); // AT
        if(seccionesVerificacion.getSaludSeguridad().getInstruccionesPrimerosAuxilios().equals("SI")){
            cellPrimerosAuxilios.setCellValue("X");
            cellPrimerosAuxilios.setCellStyle(style);
        }
        else{
            rowPrimerosAuxilios = sheet.getRow(122);
            cellPrimerosAuxilios = rowPrimerosAuxilios.createCell(45); // AT
            cellPrimerosAuxilios.setCellValue("X");
            cellPrimerosAuxilios.setCellStyle(style);
        }
        
        // Filas CantidadesAnualCacao
        Row rowCantidadesAnualCacao = sheet.getRow(124);
        Cell cellCantidadesAnualCacao = rowCantidadesAnualCacao.createCell(22); // W
        cellCantidadesAnualCacao.setCellValue(seccionesVerificacion.getRegistrosProductor().getVentaAnualCacaoQuintales());
        cellCantidadesAnualCacao.setCellStyle(style);
        
        // Filas IngresoVentasAnual
        Row rowIngresoVentasAnual = sheet.getRow(124);
        Cell cellIngresoVentasAnual = rowIngresoVentasAnual.createCell(43); // AR
        cellIngresoVentasAnual.setCellValue(seccionesVerificacion.getRegistrosProductor().getVentaAnualCacaoUSD());
        cellIngresoVentasAnual.setCellStyle(style);
        
        // Filas EgresoCompraMateriales
        Row rowEgresoCompraMateriales = sheet.getRow(126);
        Cell cellEgresoCompraMateriales = rowEgresoCompraMateriales.createCell(22); // W
        cellEgresoCompraMateriales.setCellValue(seccionesVerificacion.getRegistrosProductor().getEgresoCompraMateriales());
        cellEgresoCompraMateriales.setCellStyle(style);
        
        // Filas EgresoManoObra
        Row rowEgresoManoObra = sheet.getRow(126);
        Cell cellEgresoManoObra = rowEgresoManoObra.createCell(43); // AR
        cellEgresoManoObra.setCellValue(seccionesVerificacion.getRegistrosProductor().getEgresoManoObra());
        cellEgresoManoObra.setCellStyle(style);
        
        // Filas ManejoCuadernillo
        Row rowManejoCuadernillo = sheet.getRow(128);
        Cell cellManejoCuadernillo = rowManejoCuadernillo.createCell(22); // W
        if(seccionesVerificacion.getRegistrosProductor().getManejoCuadernilloRegistros().equals("SI")){
            cellManejoCuadernillo.setCellValue("X");
            cellManejoCuadernillo.setCellStyle(style);
        }
        else{
            cellManejoCuadernillo = rowManejoCuadernillo.createCell(24); // Y
            cellManejoCuadernillo.setCellValue("X");
            cellManejoCuadernillo.setCellStyle(style);  
        }
        
        // Filas ManejoCostosPlanificacion
        Row rowManejoCostosPlanificacion = sheet.getRow(128);
        Cell cellManejoCostosPlanificacion = rowManejoCostosPlanificacion.createCell(43); // AR
        if(seccionesVerificacion.getRegistrosProductor().getManejoCostosPlanificacionFinanciera().equals("SI")){
            cellManejoCostosPlanificacion.setCellValue("X");
            cellManejoCostosPlanificacion.setCellStyle(style);
        }
        else{
            cellManejoCostosPlanificacion = rowManejoCostosPlanificacion.createCell(45); // AT
            cellManejoCostosPlanificacion.setCellValue("X");
            cellManejoCostosPlanificacion.setCellStyle(style);  
        }
        
        // Filas DisponibilidadAhorro
        Row rowDisponibilidadAhorro = sheet.getRow(130);
        Cell cellDisponibilidadAhorro = rowDisponibilidadAhorro.createCell(20); // U
        if(seccionesVerificacion.getRegistrosProductor().getDisponibilidadAhorrarEnCuenta().getRespuesta().equals("SI")){
            cellDisponibilidadAhorro.setCellValue("X");
            cellDisponibilidadAhorro.setCellStyle(style);

            // Filas AhorroEspecifico
            Row rowAhorroEspecifico = sheet.getRow(130);
            Cell cellAhorroEspecifico = rowAhorroEspecifico.createCell(29); // AD
            switch (seccionesVerificacion.getRegistrosProductor().getDisponibilidadAhorrarEnCuenta().getTipoInstitucionAhorroCuenta()) {
                case "BANCO FORMAL":
                    cellAhorroEspecifico.setCellValue("X");
                    cellAhorroEspecifico.setCellStyle(style);
                    break;
                case "COOPERATIVA AHORRO Y CRÉDITO":
                    cellAhorroEspecifico = rowAhorroEspecifico.createCell(33); // AH
                    cellAhorroEspecifico.setCellValue("X");
                    cellAhorroEspecifico.setCellStyle(style);
                    break;
                case "BANCOS COMUNALES":
                    cellAhorroEspecifico = rowAhorroEspecifico.createCell(37); // AL
                    cellAhorroEspecifico.setCellValue("X");
                    cellAhorroEspecifico.setCellStyle(style);
                    break;
                default:
                    cellAhorroEspecifico = rowAhorroEspecifico.createCell(41); // AP
                    cellAhorroEspecifico.setCellValue("X");
                    cellAhorroEspecifico.setCellStyle(style);
                    cellAhorroEspecifico = rowAhorroEspecifico.createCell(42); // AQ
                    cellAhorroEspecifico.setCellValue(seccionesVerificacion.getRegistrosProductor().getDisponibilidadAhorrarEnCuenta().getTipoInstitucionAhorroCuenta());
                    cellAhorroEspecifico.setCellStyle(style);
                    break;
            }
        }
        else{
            rowDisponibilidadAhorro = sheet.getRow(132);
            cellDisponibilidadAhorro = rowDisponibilidadAhorro.createCell(20); // U
            cellDisponibilidadAhorro.setCellValue("X");
            cellDisponibilidadAhorro.setCellStyle(style);
        }
        
        
        // Filas CosechaPorSeparado
        Row rowCosechaPorSeparado = sheet.getRow(136);
        Cell cellCosechaPorSeparado = rowCosechaPorSeparado.createCell(22); // W
        if(seccionesVerificacion.getCosecha().getCosechaSeparadoCacaoNacionalCCN51().equals("SI")){
            cellCosechaPorSeparado.setCellValue("X");
            cellCosechaPorSeparado.setCellStyle(style);
        }
        else{
            cellCosechaPorSeparado = rowCosechaPorSeparado.createCell(24); // Y
            cellCosechaPorSeparado.setCellValue("X");
            cellCosechaPorSeparado.setCellStyle(style);
        }
        
        // Filas PlantasConLaceraciones
        Row rowPlantasConLaceraciones = sheet.getRow(138);
        Cell cellPlantasConLaceraciones = rowPlantasConLaceraciones.createCell(31); // AF
        if(seccionesVerificacion.getCosecha().getCosechaSeparadoCacaoNacionalCCN51().equals("SI")){
            cellPlantasConLaceraciones.setCellValue("X");
            cellPlantasConLaceraciones.setCellStyle(style);
        }
        else{
            cellPlantasConLaceraciones = rowPlantasConLaceraciones.createCell(33); // AH
            cellPlantasConLaceraciones.setCellValue("X");
            cellPlantasConLaceraciones.setCellStyle(style);
        }
        
        // Filas FermentaSuCacao
        boolean fermenta = false;
        Row rowFermentaSuCacao = sheet.getRow(144);
        Cell cellFermentaSuCacao = rowFermentaSuCacao.createCell(20); // U
        switch (seccionesVerificacion.getFermentacion().getFermentaCacao().getRespuesta()) {
            case "SIEMPRE":
                cellFermentaSuCacao.setCellValue("X");
                cellFermentaSuCacao.setCellStyle(style);
                fermenta = true;
                break;
            case "A VECES":
                rowFermentaSuCacao = sheet.getRow(145);
                cellFermentaSuCacao = rowFermentaSuCacao.createCell(20); // U
                cellFermentaSuCacao.setCellValue("X");
                cellFermentaSuCacao.setCellStyle(style);
                fermenta = true;
                break;
            case "NUNCA":
                rowFermentaSuCacao = sheet.getRow(146);
                cellFermentaSuCacao = rowFermentaSuCacao.createCell(20); // U
                cellFermentaSuCacao.setCellValue("X");
                cellFermentaSuCacao.setCellStyle(style);
                // Filas Razon
                Row rowRazon = sheet.getRow(145);
                Cell cellRazon = rowRazon.createCell(29); // AD
                if(seccionesVerificacion.getFermentacion().getFermentaCacao().getRazonNoFermenta().equals("LIMITANTE DE CLIMA")){
                    cellRazon.setCellValue("X");
                    cellRazon.setCellStyle(style);
                }
                else if(seccionesVerificacion.getFermentacion().getFermentaCacao().getRazonNoFermenta().equals("CARECE DE  INFRAESTRUCTURA")){
                    cellRazon = rowRazon.createCell(33); // AH
                    cellRazon.setCellValue("X");
                    cellRazon.setCellStyle(style);
                }
                else if(seccionesVerificacion.getFermentacion().getFermentaCacao().getRazonNoFermenta().equals("DESCONOCIMIENTO DEL TEMA")){
                    cellRazon = rowRazon.createCell(37); // AL
                    cellRazon.setCellValue("X");
                    cellRazon.setCellStyle(style);
                }
                else if(seccionesVerificacion.getFermentacion().getFermentaCacao().getRazonNoFermenta().equals("NECESIDAD DE LIQUIDEZ")){
                    cellRazon = rowRazon.createCell(41); // AP
                    cellRazon.setCellValue("X");
                    cellRazon.setCellStyle(style);
                }
                
                break;
            default:
                break;
        }
        
        if(fermenta){
            // Filas CuandoFermenta1
            Row rowCuandoFermenta1 = sheet.getRow(148);
            Cell cellCuandoFermenta1 = rowCuandoFermenta1.createCell(20); // U
            switch (seccionesVerificacion.getFermentacion().getFermentaCacao().getModoFermentacion()) {
                case "SACOS PLASTICO":
                    cellCuandoFermenta1.setCellValue("X");
                    cellCuandoFermenta1.setCellStyle(style);
                    break;
                case "TIPO LAGARTO":
                    cellCuandoFermenta1 = rowCuandoFermenta1.createCell(24); // Y
                    cellCuandoFermenta1.setCellValue("X");
                    cellCuandoFermenta1.setCellStyle(style);
                    break;
                case "SACOS DE YUTE":
                    cellCuandoFermenta1 = rowCuandoFermenta1.createCell(29); // AD
                    cellCuandoFermenta1.setCellValue("X");
                    cellCuandoFermenta1.setCellStyle(style);
                    break;
                case "CAJON DE MADERA":
                    cellCuandoFermenta1 = rowCuandoFermenta1.createCell(33); // AH
                    cellCuandoFermenta1.setCellValue("X");
                    cellCuandoFermenta1.setCellStyle(style);
                    break;
                case "CAÑA PICADA":
                    cellCuandoFermenta1 = rowCuandoFermenta1.createCell(37); // AL
                    cellCuandoFermenta1.setCellValue("X");
                    cellCuandoFermenta1.setCellStyle(style);
                    break;
                default:
                    cellCuandoFermenta1 = rowCuandoFermenta1.createCell(41); // AP
                    cellCuandoFermenta1.setCellValue("X");
                    cellCuandoFermenta1.setCellStyle(style);
                    
                    cellCuandoFermenta1 = rowCuandoFermenta1.createCell(42); // AQ
                    cellCuandoFermenta1.setCellValue(seccionesVerificacion.getFermentacion().getFermentaCacao().getModoFermentacion());
                    cellCuandoFermenta1.setCellStyle(style);
                    break;
            }
            
            // Filas CuandoFermenta2
            Row rowCuandoFermenta2 = sheet.getRow(150);
            Cell cellCuandoFermenta2 = rowCuandoFermenta2.createCell(24); // Y
            if(seccionesVerificacion.getFermentacion().getFermentaCacao().getMedidasHigieneFermentacion().equals("CON MEDIDAS DE HIGIENE")){
                cellCuandoFermenta2.setCellValue("X");
                cellCuandoFermenta2.setCellStyle(style);
            }
            else{
                cellCuandoFermenta2 = rowCuandoFermenta2.createCell(33); // AH
                cellCuandoFermenta2.setCellValue("X");
                cellCuandoFermenta2.setCellStyle(style);
            }
        }
        
        // Filas NivelHumedad
        Row rowNivelHumedad = sheet.getRow(154);
        Cell cellNivelHumedad = rowNivelHumedad.createCell(20); // U
        switch (seccionesVerificacion.getSecado().getNivelHumedadCacaoVendido()) {
            case "BABA":
                cellNivelHumedad.setCellValue("X");
                cellNivelHumedad.setCellStyle(style);
                break;
            case "1 SOL":
                cellNivelHumedad = rowNivelHumedad.createCell(24); // Y
                cellNivelHumedad.setCellValue("X");
                cellNivelHumedad.setCellStyle(style);
                break;
            case "2 SOLES":
                cellNivelHumedad = rowNivelHumedad.createCell(24); // AD
                cellNivelHumedad.setCellValue("X");
                cellNivelHumedad.setCellStyle(style);
                break;
            case "3 SOLES":
                cellNivelHumedad = rowNivelHumedad.createCell(33); // AH
                cellNivelHumedad.setCellValue("X");
                cellNivelHumedad.setCellStyle(style);
                break;
            case "4 SOLES":
                cellNivelHumedad = rowNivelHumedad.createCell(37); // AL
                cellNivelHumedad.setCellValue("X");
                cellNivelHumedad.setCellStyle(style);
                break;
            default:
                cellNivelHumedad = rowNivelHumedad.createCell(41); // AP
                cellNivelHumedad.setCellValue("X");
                cellNivelHumedad.setCellStyle(style);
                
                cellNivelHumedad = rowNivelHumedad.createCell(42); // AQ
                cellNivelHumedad.setCellValue(seccionesVerificacion.getSecado().getNivelHumedadCacaoVendido());
                cellNivelHumedad.setCellStyle(style);
                break;
        }
        
        // Filas RealizaSecado
        Row rowRealizaSecado = sheet.getRow(159);
        Cell cellRealizaSecado = rowRealizaSecado.createCell(12); // M
        if(seccionesVerificacion.getSecado().getManeraRealzarSecado().contains("ASFALTO")){
            cellRealizaSecado.setCellValue("X");
            cellRealizaSecado.setCellStyle(style);
        }
        if(seccionesVerificacion.getSecado().getManeraRealzarSecado().contains("TENDAL CAÑA")){
            cellRealizaSecado = rowRealizaSecado.createCell(16); // Q
            cellRealizaSecado.setCellValue("X");
            cellRealizaSecado.setCellStyle(style);
        }
        if(seccionesVerificacion.getSecado().getManeraRealzarSecado().contains("TENDAL DE CEMENTO")){
            cellRealizaSecado = rowRealizaSecado.createCell(20); // U
            cellRealizaSecado.setCellValue("X");
            cellRealizaSecado.setCellStyle(style);
        }
        if(seccionesVerificacion.getSecado().getManeraRealzarSecado().contains("MARQUESINA")){
            cellRealizaSecado = rowRealizaSecado.createCell(24); // Y
            cellRealizaSecado.setCellValue("X");
            cellRealizaSecado.setCellStyle(style);
        }
        if(seccionesVerificacion.getSecado().getManeraRealzarSecado().contains("SECADORA")){
            cellRealizaSecado = rowRealizaSecado.createCell(29); // AD
            cellRealizaSecado.setCellValue("X");
            cellRealizaSecado.setCellStyle(style);
        }
        if(seccionesVerificacion.getSecado().getManeraRealzarSecado().contains("PLÁSTICO NEGRO")){
            cellRealizaSecado = rowRealizaSecado.createCell(33); // AH
            cellRealizaSecado.setCellValue("X");
            cellRealizaSecado.setCellStyle(style);
        }
        if(seccionesVerificacion.getSecado().getManeraRealzarSecado().contains("PLÁSTICO BLANCO")){
            cellRealizaSecado = rowRealizaSecado.createCell(37); // AL
            cellRealizaSecado.setCellValue("X");
            cellRealizaSecado.setCellStyle(style);
        }
        if(seccionesVerificacion.getSecado().getManeraRealzarSecado().contains("OTRO")){
            cellRealizaSecado = rowRealizaSecado.createCell(41); // AP
            cellRealizaSecado.setCellValue("X");
            cellRealizaSecado.setCellStyle(style);
            
            cellRealizaSecado = rowRealizaSecado.createCell(43); // AR
            cellRealizaSecado.setCellValue("X");
            cellRealizaSecado.setCellStyle(style);
        }
        
        // Filas IncrementadoIngresos
        Row rowIncrementadoIngresos = sheet.getRow(161);
        Cell cellIncrementadoIngresos = rowIncrementadoIngresos.createCell(31); // AF
        if(seccionesVerificacion.getSecado().getMejoraIngresoMejorTratamientoSecadoCacao().equals("SI")){
            cellIncrementadoIngresos.setCellValue("X");
            cellIncrementadoIngresos.setCellStyle(style);
        }
        else{
            cellIncrementadoIngresos = rowIncrementadoIngresos.createCell(33); // AH
            cellIncrementadoIngresos.setCellValue("X");
            cellIncrementadoIngresos.setCellStyle(style);
        }
        
        // Filas VendeCacao
        Row rowVendeCacao = sheet.getRow(163);
        Cell cellVendeCacao = rowVendeCacao.createCell(21); // V
        cellVendeCacao.setCellValue(seccionesVerificacion.getVenta().getPersonaVenderCacao().getRespuesta());
        cellVendeCacao.setCellStyle(style);
        
        // Filas Razon1
        Row rowRazon1 = sheet.getRow(165);
        Cell cellRazon = rowRazon1.createCell(13); // N
        cellRazon.setCellValue(seccionesVerificacion.getVenta().getPersonaVenderCacao().getRazon1());
        cellRazon.setCellStyle(style);
        
        // Filas Razon2
        cellRazon = rowRazon1.createCell(34); // AI
        cellRazon.setCellValue(seccionesVerificacion.getVenta().getPersonaVenderCacao().getRazon2());
        cellRazon.setCellStyle(style);
        
        // Filas RecibidoBonos
        Row rowRecibidoBonos = sheet.getRow(167);
        Cell cellRecibidoBonos = rowRecibidoBonos.createCell(22); // W
        if(seccionesVerificacion.getVenta().getRecibeBonosEmpresaProgramaLINDT().getRespuesta().equals("SI")){
            cellRecibidoBonos.setCellValue("X");
            cellRecibidoBonos.setCellStyle(style);
            switch (seccionesVerificacion.getVenta().getRecibeBonosEmpresaProgramaLINDT().getFrecuenciaRecibeBono()) {
                case "UNA VEZ":
                    cellRecibidoBonos = rowRecibidoBonos.createCell(37); // AL
                    cellRecibidoBonos.setCellValue("X");
                    cellRecibidoBonos.setCellStyle(style);
                    break;
                case "DOS VECES":
                    cellRecibidoBonos = rowRecibidoBonos.createCell(41); // AP
                    cellRecibidoBonos.setCellValue("X");
                    cellRecibidoBonos.setCellStyle(style);
                    break;
                default:
                    cellRecibidoBonos = rowRecibidoBonos.createCell(45); // AT
                    cellRecibidoBonos.setCellValue("X");
                    cellRecibidoBonos.setCellStyle(style);
                    break;
            }
        }
        else{
            cellRecibidoBonos = rowRecibidoBonos.createCell(24); // Y
            cellRecibidoBonos.setCellValue("X");
            cellRecibidoBonos.setCellStyle(style);
        }
        
        // Filas CondicionesLaborales
        Row rowCondicionesLaborales = sheet.getRow(174);
        Cell cellCondicionesLaborales = rowCondicionesLaborales.createCell(9); // J
        if(seccionesVerificacion.getCondicionesLaborales().getDiscriminacion().equals("SI")){
            cellCondicionesLaborales.setCellValue("X");
            cellCondicionesLaborales.setCellStyle(style);
        }
        else{
            cellCondicionesLaborales = rowCondicionesLaborales.createCell(11); // L
            cellCondicionesLaborales.setCellValue("X");
            cellCondicionesLaborales.setCellStyle(style);
        }
        if(seccionesVerificacion.getCondicionesLaborales().getExplotacion().equals("SI")){
            cellCondicionesLaborales = rowCondicionesLaborales.createCell(16); // Q
            cellCondicionesLaborales.setCellValue("X");
            cellCondicionesLaborales.setCellStyle(style);
        }
        else{
            cellCondicionesLaborales = rowCondicionesLaborales.createCell(18); // S
            cellCondicionesLaborales.setCellValue("X");
            cellCondicionesLaborales.setCellStyle(style);
        }
        if(seccionesVerificacion.getCondicionesLaborales().getTrabajoInfantil().equals("SI")){
            cellCondicionesLaborales = rowCondicionesLaborales.createCell(25); // Z
            cellCondicionesLaborales.setCellValue("X");
            cellCondicionesLaborales.setCellStyle(style);
        }
        else{
            cellCondicionesLaborales = rowCondicionesLaborales.createCell(27); // AB
            cellCondicionesLaborales.setCellValue("X");
            cellCondicionesLaborales.setCellStyle(style);
        }
        if(seccionesVerificacion.getCondicionesLaborales().getDocumentosSoporte().equals("SI")){
            cellCondicionesLaborales = rowCondicionesLaborales.createCell(34); // AI
            cellCondicionesLaborales.setCellValue("X");
            cellCondicionesLaborales.setCellStyle(style);
        }
        else{
            cellCondicionesLaborales = rowCondicionesLaborales.createCell(36); // AK
            cellCondicionesLaborales.setCellValue("X");
            cellCondicionesLaborales.setCellStyle(style);
        }
        if(seccionesVerificacion.getCondicionesLaborales().getMontoAcuerdoContratoAgricola().equals("SI")){
            cellCondicionesLaborales = rowCondicionesLaborales.createCell(43); // AR
            cellCondicionesLaborales.setCellValue("X");
            cellCondicionesLaborales.setCellStyle(style);
        }
        else{
            cellCondicionesLaborales = rowCondicionesLaborales.createCell(45); // AT
            cellCondicionesLaborales.setCellValue("X");
            cellCondicionesLaborales.setCellStyle(style);
        }
        // Filas CuentaConRiego
        Row rowCuentaConRiego = sheet.getRow(180);
        Cell cellCuentaConRiego = rowCuentaConRiego.createCell(9); // J
//        if(seccionesVerificacion.getConservacionAgua().getFincaCuentaConRiego().equals("SI")){
//            cellCuentaConRiego.setCellValue("X");
//            cellCuentaConRiego.setCellStyle(style);
//            
//            // Filas TipoExtraccion
//            Row rowTipoExtraccion = sheet.getRow(176);
//            Cell cellTipoExtraccion = rowTipoExtraccion.createCell(27); // AB
//            switch (seccionesVerificacion.getConservacionAgua().getTipoExtraccion()) {
//                case "GRAVEDAD":
//                    cellTipoExtraccion.setCellValue("X");
//                    cellTipoExtraccion.setCellStyle(style);
//                    break;
//                case "MECANIZADO":
//                    cellTipoExtraccion = rowTipoExtraccion.createCell(31); // AF
//                    cellTipoExtraccion.setCellValue("X");
//                    cellTipoExtraccion.setCellStyle(style);
//                    break;
//                case "PLANTA A PLANTA":
//                    cellTipoExtraccion = rowTipoExtraccion.createCell(36); // AK
//                    cellTipoExtraccion.setCellValue("X");
//                    cellTipoExtraccion.setCellStyle(style);
//                    break;
//                default:
//                    cellTipoExtraccion = rowTipoExtraccion.createCell(40); // AO
//                    cellTipoExtraccion.setCellValue("X");
//                    cellTipoExtraccion.setCellStyle(style);
//                    break;
//            }
//
//            // Filas InfraestructuraRiego
//            Row rowInfraestructuraRiego = sheet.getRow(178);
//            Cell cellInfraestructuraRiego = rowInfraestructuraRiego.createCell(27); // AB
//            switch (seccionesVerificacion.getConservacionAgua().getInfraestructuraRiego()) {
//                case "SUB-FOLIAR":
//                    cellInfraestructuraRiego.setCellValue("X");
//                    cellInfraestructuraRiego.setCellStyle(style);
//                    break;
//                case "GOTEO":
//                    cellInfraestructuraRiego = rowInfraestructuraRiego.createCell(31); // AF
//                    cellInfraestructuraRiego.setCellValue("X");
//                    cellInfraestructuraRiego.setCellStyle(style);
//                    break;
//                default:
//                    cellInfraestructuraRiego = rowInfraestructuraRiego.createCell(36); // AK
//                    cellInfraestructuraRiego.setCellValue("X");
//                    cellInfraestructuraRiego.setCellStyle(style);
//                    break;
//            }
//
//            // Filas ImpactoRiego
//            Row rowImpactoRiego = sheet.getRow(178);
//            Cell cellImpactoRiego = rowImpactoRiego.createCell(27); // AB
//            switch (seccionesVerificacion.getConservacionAgua().getImpactoRiego()) {
//                case "ALTO":
//                    cellImpactoRiego.setCellValue("X");
//                    cellImpactoRiego.setCellStyle(style);
//                    break;
//                case "MEDIO":
//                    cellImpactoRiego = rowImpactoRiego.createCell(31); // AF
//                    cellImpactoRiego.setCellValue("X");
//                    cellImpactoRiego.setCellStyle(style);
//                    break;
//                default:
//                    cellImpactoRiego = rowImpactoRiego.createCell(36); // AK
//                    cellImpactoRiego.setCellValue("X");
//                    cellImpactoRiego.setCellStyle(style);
//                    break;
//            }
//            // Filas DisenioRiego
//            Row rowDisenioRiego = sheet.getRow(182);
//            Cell cellDisenioRiego = rowDisenioRiego.createCell(18); // S
//            if(seccionesVerificacion.getConservacionAgua().getTieneDisenoFijo().getRespuesta().equals("SI")){
//                cellDisenioRiego.setCellValue("X");
//                cellDisenioRiego.setCellStyle(style);
//                cellDisenioRiego = rowDisenioRiego.createCell(28); // AC
//                cellDisenioRiego.setCellValue(seccionesVerificacion.getConservacionAgua().getTieneDisenoFijo().getHectareasDisenioRiegoFijo());
//                cellDisenioRiego.setCellStyle(style);
//            }
//            // Filas DisenioMovible
//            Row rowDisenioMovible = sheet.getRow(182);
//            Cell cellDisenioMovible = rowDisenioMovible.createCell(18); // S
//            if(seccionesVerificacion.getConservacionAgua().getTieneDisenoMovible().getRespuesta().equals("SI")){
//                cellDisenioMovible.setCellValue("X");
//                cellDisenioMovible.setCellStyle(style);
//                cellDisenioMovible = rowDisenioMovible.createCell(28); // AC
//                cellDisenioMovible.setCellValue(seccionesVerificacion.getConservacionAgua().getTieneDisenoMovible().getHectareasDisenioRiegoMovible());
//                cellDisenioMovible.setCellStyle(style);
//            }
//            
//            // Filas PermisoExtraer
//            Row rowPermisoExtraer = sheet.getRow(189);
//            Cell cellPermisoExtraer = rowPermisoExtraer.createCell(9); // J
//            if(seccionesVerificacion.getConservacionAgua().getPermisoExtraerAguaRiego().equals("SI")){
//                cellPermisoExtraer.setCellValue("X");
//                cellPermisoExtraer.setCellStyle(style);
//            }
//            else{
//                cellPermisoExtraer = rowPermisoExtraer.createCell(11); // L
//                cellPermisoExtraer.setCellValue("X");
//                cellPermisoExtraer.setCellStyle(style);
//            }
//            
//            // Filas RealizaAnalisis
//            Row rowRealizaAnalisis = sheet.getRow(189);
//            Cell cellRealizaAnalisis = rowRealizaAnalisis.createCell(16); // Q
//            if(seccionesVerificacion.getConservacionAgua().getAnalisisAguaRiego().equals("SI")){
//                cellRealizaAnalisis.setCellValue("X");
//                cellRealizaAnalisis.setCellStyle(style);
//            }
//            else{
//                cellRealizaAnalisis = rowRealizaAnalisis.createCell(18); // S
//                cellRealizaAnalisis.setCellValue("X");
//                cellRealizaAnalisis.setCellStyle(style);
//            }
//            
//            // Filas PresentaAnexos
//            Row rowPresentaAnexos = sheet.getRow(189);
//            Cell cellPresentaAnexos = rowPresentaAnexos.createCell(25); // Z
//            if(seccionesVerificacion.getConservacionAgua().getPresentaAnexos().equals("SI")){
//                cellPresentaAnexos.setCellValue("X");
//                cellPresentaAnexos.setCellStyle(style);
//            }
//            else{
//                cellPresentaAnexos = rowPresentaAnexos.createCell(27); // AB
//                cellPresentaAnexos.setCellValue("X");
//                cellPresentaAnexos.setCellStyle(style);
//            }
//            
//        }
//        else{
//            cellCuentaConRiego = rowCuentaConRiego.createCell(11); // L
//            cellCuentaConRiego.setCellValue("X");
//            cellCuentaConRiego.setCellStyle(style);
//        }
        
        // Filas UtilizaFiltroEcologico
        Row rowUtilizaFiltroEcologico = sheet.getRow(195);
        Cell cellUtilizaFiltroEcologico = rowUtilizaFiltroEcologico.createCell(9); // J
        if(seccionesVerificacion.getConservacionAgua().getUtilizaFiltroEcologico().getRespuesta().equals("SI")){
            cellUtilizaFiltroEcologico.setCellValue("X");
            cellUtilizaFiltroEcologico.setCellStyle(style);

            switch (seccionesVerificacion.getConservacionAgua().getUtilizaFiltroEcologico().getRazonUsoFiltroEcologico()) {
                case "LIXIVIADO DE CACAO":
                    rowUtilizaFiltroEcologico = sheet.getRow(191);
                    cellUtilizaFiltroEcologico = rowUtilizaFiltroEcologico.createCell(27); // AB
                    cellUtilizaFiltroEcologico.setCellValue("X");
                    cellUtilizaFiltroEcologico.setCellStyle(style);
                    break;
                case "AGUAS RESIDUALES":
                    rowUtilizaFiltroEcologico = sheet.getRow(193);
                    cellUtilizaFiltroEcologico = rowUtilizaFiltroEcologico.createCell(27); // AB
                    cellUtilizaFiltroEcologico.setCellValue("X");
                    cellUtilizaFiltroEcologico.setCellStyle(style);
                    break;
                case "RESIDUOS DE PRODUCTOS":
                    rowUtilizaFiltroEcologico = sheet.getRow(195);
                    cellUtilizaFiltroEcologico = rowUtilizaFiltroEcologico.createCell(27); // AB
                    cellUtilizaFiltroEcologico.setCellValue("X");
                    cellUtilizaFiltroEcologico.setCellStyle(style);
                    break;
                default:
                    break;
            }
        }
        else{
            cellUtilizaFiltroEcologico = rowUtilizaFiltroEcologico.createCell(11); // L
            cellUtilizaFiltroEcologico.setCellValue("X");
            cellUtilizaFiltroEcologico.setCellStyle(style);
        }
        
        // Filas AreaDesechosPlasticos
        Row rowAreaDesechosPlasticos = sheet.getRow(195);
        Cell cellAreaDesechosPlasticos = rowAreaDesechosPlasticos.createCell(34); // AI
        if(seccionesVerificacion.getConservacionAgua().getAreaDeschPlasticos().equals("SI")){
            cellAreaDesechosPlasticos.setCellValue("X");
            cellAreaDesechosPlasticos.setCellStyle(style);
        }
        else{
            cellAreaDesechosPlasticos = rowAreaDesechosPlasticos.createCell(36); // AK
            cellAreaDesechosPlasticos.setCellValue("X");
            cellAreaDesechosPlasticos.setCellStyle(style);
        }
        
        // Filas FincaLibrePlasticos
    //        Row rowFincaLibrePlasticos = sheet.getRow(195);
    //        Cell cellFincaLibrePlasticos = rowFincaLibrePlasticos.createCell(34); // AI
    //        if(seccionesVerificacion.getConservacionAgua().getFinca.equals("SI")){
    //            cellFincaLibrePlasticos.setCellValue("X");
    //            cellFincaLibrePlasticos.setCellStyle(style);
    //        }
    //        else{
    //            cellFincaLibrePlasticos = rowFincaLibrePlasticos.createCell(36); // AK
    //            cellFincaLibrePlasticos.setCellValue("X");
    //            cellFincaLibrePlasticos.setCellStyle(style);
    //        }
    
        // Filas ClasificaBasuraDomestica
        Row rowClasificaBasuraDomestica = sheet.getRow(201);
        Cell cellClasificaBasuraDomestica = rowClasificaBasuraDomestica.createCell(9); // J
        if(seccionesVerificacion.getConservacionAgua().getAreaDeschPlasticos().equals("SI")){
            cellClasificaBasuraDomestica.setCellValue("X");
            cellClasificaBasuraDomestica.setCellStyle(style);
            // Filas Criterio
            Row rowCriterio = sheet.getRow(197);
            Cell cellCriterio = rowCriterio.createCell(27); // AB
            if(seccionesVerificacion.getConservacionAgua().getCriterioClasificaBasuraDomestica().contains("PELIGROSO Y NO PELIGROSO")){
                cellCriterio.setCellValue("X");
                cellCriterio.setCellStyle(style);
            }
            else if(seccionesVerificacion.getConservacionAgua().getCriterioClasificaBasuraDomestica().contains("BIOLOGICO, PLASTICO Y VIDRIO")){
                rowCriterio = sheet.getRow(199);
                cellCriterio = rowCriterio.createCell(27); // AB
                cellCriterio.setCellValue("X");
                cellCriterio.setCellStyle(style);
            }
            else{
                rowCriterio = sheet.getRow(201);
                cellCriterio = rowCriterio.createCell(27); // AB
                cellCriterio.setCellValue("X");
                cellCriterio.setCellStyle(style);
            }
        }
        else{
            cellClasificaBasuraDomestica = rowClasificaBasuraDomestica.createCell(11); // L
            cellClasificaBasuraDomestica.setCellValue("X");
            cellClasificaBasuraDomestica.setCellStyle(style);
        }
        // Filas ReciclajeComposta
        Row rowReciclajeComposta = sheet.getRow(201);
        Cell cellReciclajeComposta = rowReciclajeComposta.createCell(34); // AI
        if(seccionesVerificacion.getConservacionAgua().getPracticaReciclajeCompostaje().equals("SI")){
            cellReciclajeComposta.setCellValue("X");
            cellReciclajeComposta.setCellStyle(style);
        }
        else{
            cellReciclajeComposta = rowReciclajeComposta.createCell(36); // AK
            cellReciclajeComposta.setCellValue("X");
            cellReciclajeComposta.setCellStyle(style);
        }
        
        // Filas TratamientoBasura
        Row rowTratamientoBasura = sheet.getRow(203);
        Cell cellTratamientoBasura = rowTratamientoBasura.createCell(22); // W
        switch (seccionesVerificacion.getConservacionAgua().getTratamientoBasura()) {
            case "VENDE":
                cellTratamientoBasura.setCellValue("X");
                cellTratamientoBasura.setCellStyle(style);
                break;
            case "RECOLECTA":
                cellTratamientoBasura = rowTratamientoBasura.createCell(27); // AB
                cellTratamientoBasura.setCellValue("X");
                cellTratamientoBasura.setCellStyle(style);
                break;
            case "REUTILIZA":
                cellTratamientoBasura = rowTratamientoBasura.createCell(32); // AG
                cellTratamientoBasura.setCellValue("X");
                cellTratamientoBasura.setCellStyle(style);
                break;
            case "ENTIERRA":
                cellTratamientoBasura = rowTratamientoBasura.createCell(36); // AK
                cellTratamientoBasura.setCellValue("X");
                cellTratamientoBasura.setCellStyle(style);
                break;
            default:
                cellTratamientoBasura = rowTratamientoBasura.createCell(40); // AO
                cellTratamientoBasura.setCellValue("X");
                cellTratamientoBasura.setCellStyle(style);
                break;
        }
        // Filas AreaRecepcionEnvases
        Row rowAreaRecepcionEnvases = sheet.getRow(205);
        Cell cellAreaRecepcionEnvases; 
        if(seccionesVerificacion.getConservacionAgua().getConocimientoAreaRecepcioEnvasesProductosQuimicos().getRespuesta().equals("SI")){
            cellAreaRecepcionEnvases = rowAreaRecepcionEnvases.createCell(34); // AI
            cellAreaRecepcionEnvases.setCellValue("X");
            cellAreaRecepcionEnvases.setCellStyle(style);
        }
        else{
            cellAreaRecepcionEnvases = rowAreaRecepcionEnvases.createCell(36); // AK
            cellAreaRecepcionEnvases.setCellValue("X");
            cellAreaRecepcionEnvases.setCellStyle(style);
        }
        // Filas UsoDeServicio
        Row rowUsoDeServicio = sheet.getRow(207);
        Cell cellUsoDeServicio; 
        if(seccionesVerificacion.getConservacionAgua().getConocimientoAreaRecepcioEnvasesProductosQuimicos().getUsoServicioAreaRecepcionEnvasesProductosQuimicos().equals("SI")){
            cellUsoDeServicio = rowUsoDeServicio.createCell(16); // Q
            cellUsoDeServicio.setCellValue("X");
            cellUsoDeServicio.setCellStyle(style);
            
            // Frecuencia
            Cell cellFrecuencia;
            switch (seccionesVerificacion.getConservacionAgua().getConocimientoAreaRecepcioEnvasesProductosQuimicos().getFrecuenciaUsoServicioAreaRecepcionEnvasesProductosQuimicos()) {
                case "UNA VEZ":
                    cellFrecuencia = rowUsoDeServicio.createCell(32); // AG
                    cellFrecuencia.setCellValue("X");
                    cellFrecuencia.setCellStyle(style);
                    break;
                case "DOS VECES":
                    cellFrecuencia = rowUsoDeServicio.createCell(36); // AK
                    cellFrecuencia.setCellValue("X");
                    cellFrecuencia.setCellStyle(style);
                    break;
                default:
                    cellFrecuencia = rowUsoDeServicio.createCell(40); // AO
                    cellFrecuencia.setCellValue("X");
                    cellFrecuencia.setCellStyle(style);
                    break;
            }
        }
        else{
            cellUsoDeServicio = rowUsoDeServicio.createCell(18); // S
            cellUsoDeServicio.setCellValue("X");
            cellUsoDeServicio.setCellStyle(style);
        }
        
        // Filas AlmacenaConSeguridad
        Row rowAlmacenaConSeguridad = sheet.getRow(209);
        Cell cellAlmacenaConSeguridad;
        if(seccionesVerificacion.getConservacionAgua().getConocimientoAreaRecepcioEnvasesProductosQuimicos().getAlmacenaSeguridadEnvasesPrevioTraslado().getRespuesta().equals("SI")){
            cellAlmacenaConSeguridad = rowAlmacenaConSeguridad.createCell(18); // S
            cellAlmacenaConSeguridad.setCellValue("X");
            cellAlmacenaConSeguridad.setCellStyle(style);
            switch (seccionesVerificacion.getConservacionAgua().getConocimientoAreaRecepcioEnvasesProductosQuimicos().getAlmacenaSeguridadEnvasesPrevioTraslado().getLugarAlmacena()) {
                case "BODEGA":
                    cellAlmacenaConSeguridad = rowAlmacenaConSeguridad.createCell(32); // AG
                    cellAlmacenaConSeguridad.setCellValue("X");
                    cellAlmacenaConSeguridad.setCellStyle(style);
                    break;
                case "AMBIENTE":
                    cellAlmacenaConSeguridad = rowAlmacenaConSeguridad.createCell(36); // AK
                    cellAlmacenaConSeguridad.setCellValue("X");
                    cellAlmacenaConSeguridad.setCellStyle(style);
                    break;
                case "CASA":
                    rowAlmacenaConSeguridad = sheet.getRow(210);
                    cellAlmacenaConSeguridad = rowAlmacenaConSeguridad.createCell(32); // AG
                    cellAlmacenaConSeguridad.setCellValue("X");
                    cellAlmacenaConSeguridad.setCellStyle(style);
                    break;
                default:
                    rowAlmacenaConSeguridad = sheet.getRow(210);
                    cellAlmacenaConSeguridad = rowAlmacenaConSeguridad.createCell(36); // AK
                    cellAlmacenaConSeguridad.setCellValue("X");
                    cellAlmacenaConSeguridad.setCellStyle(style);
                    break;
            }
        }
        else{
            rowAlmacenaConSeguridad = sheet.getRow(210);
            cellAlmacenaConSeguridad = rowAlmacenaConSeguridad.createCell(18); // S
            cellAlmacenaConSeguridad.setCellValue("X");
            cellAlmacenaConSeguridad.setCellStyle(style);
        }
        
        // Filas TratamientoAguasNegras
        Row rowTratamientoAguasNegras = sheet.getRow(210);
        Cell cellTratamientoAguasNegras;
        if(seccionesVerificacion.getConservacionAgua().getTratamientoAguasNegras().equals("SI")){
            cellTratamientoAguasNegras = rowTratamientoAguasNegras.createCell(43); // AR
            cellTratamientoAguasNegras.setCellValue("X");
            cellTratamientoAguasNegras.setCellStyle(style);
        }
        else{
            cellTratamientoAguasNegras = rowTratamientoAguasNegras.createCell(45); // AT
            cellTratamientoAguasNegras.setCellValue("X");
            cellTratamientoAguasNegras.setCellStyle(style);
        }
        
        // Filas PracticasConservacionSuelos
        Row rowPracticasConservacionSuelos = sheet.getRow(215);
        Cell cellPracticasConservacionSuelos;
        switch (seccionesVerificacion.getConservacionSuelos().getPracticasConservacionSuelos()) {
            case "NO":
                cellPracticasConservacionSuelos = rowPracticasConservacionSuelos.createCell(22); // W
                cellPracticasConservacionSuelos.setCellValue("X");
                cellPracticasConservacionSuelos.setCellStyle(style);
                break;
            case "COBERTURA VEGETAL":
                cellPracticasConservacionSuelos = rowPracticasConservacionSuelos.createCell(27); // AB
                cellPracticasConservacionSuelos.setCellValue("X");
                cellPracticasConservacionSuelos.setCellStyle(style);
                break;
            case "BARRERAS VIVAS":
                cellPracticasConservacionSuelos = rowPracticasConservacionSuelos.createCell(32); // AG
                cellPracticasConservacionSuelos.setCellValue("X");
                cellPracticasConservacionSuelos.setCellStyle(style);
                break;
            default:
                cellPracticasConservacionSuelos = rowPracticasConservacionSuelos.createCell(36); // AK
                cellPracticasConservacionSuelos.setCellValue("X");
                cellPracticasConservacionSuelos.setCellStyle(style);
                break;
        }
        
        // Filas ProductorPracticaDeforestacion
        Row rowProductorPracticaDeforestacion = sheet.getRow(217);
        Cell cellProductorPracticaDeforestacion;
        if(seccionesVerificacion.getConservacionSuelos().getPracticaDeforestacion().equals("SI")){
            cellProductorPracticaDeforestacion = rowProductorPracticaDeforestacion.createCell(20); // U
            cellProductorPracticaDeforestacion.setCellValue("X");
            cellProductorPracticaDeforestacion.setCellStyle(style);
        }
        else{
            cellProductorPracticaDeforestacion = rowProductorPracticaDeforestacion.createCell(22); // W
            cellProductorPracticaDeforestacion.setCellValue("X");
            cellProductorPracticaDeforestacion.setCellStyle(style);
        }
        
        // Filas PlantarArbolesSombrio
        Row rowPlantarArbolesSombrio = sheet.getRow(219);
        Cell cellPlantarArbolesSombrio;
        if(seccionesVerificacion.getConservacionSuelos().getPlantadoArbolesSombrioReciente().getRespuesta().equals("SI")){
            cellPlantarArbolesSombrio = rowPlantarArbolesSombrio.createCell(18); // S
            cellPlantarArbolesSombrio.setCellValue("X");
            cellPlantarArbolesSombrio.setCellStyle(style);
            
            // Filas Cantidades
            Row rowCantidades = sheet.getRow(222);
            Cell cellCantidades = rowCantidades.createCell(20); // U
            cellCantidades.setCellValue(seccionesVerificacion.getConservacionSuelos().getPlantadoArbolesSombrioReciente().getCuantosArbolesSombrio());
            cellCantidades.setCellStyle(style);
            
            cellCantidades = rowCantidades.createCell(29); // AD
            cellCantidades.setCellValue(seccionesVerificacion.getConservacionSuelos().getPlantadoArbolesSombrioReciente().getPromedioArbolesXHectarea());
            cellCantidades.setCellStyle(style);
            
            if(seccionesVerificacion.getConservacionSuelos().getPlantadoArbolesSombrioReciente().getReforestadoOrillas().equals("SI")){
                cellCantidades = rowCantidades.createCell(43); // AR
                cellCantidades.setCellValue("X");
                cellCantidades.setCellStyle(style);
            }
            else{
                cellCantidades = rowCantidades.createCell(45); // AT
                cellCantidades.setCellValue("X");
                cellCantidades.setCellStyle(style);
            }
        }
        else{
            rowPlantarArbolesSombrio = sheet.getRow(220);
            cellPlantarArbolesSombrio = rowPlantarArbolesSombrio.createCell(18); // S
            cellPlantarArbolesSombrio.setCellValue("X");
            cellPlantarArbolesSombrio.setCellStyle(style);
        }
        
        // Filas PromedioArboles12Metros
        Row rowPromedioArboles12Metros = sheet.getRow(224);
        Cell cellPromedioArboles12Metros = rowPromedioArboles12Metros.createCell(23); // X
        cellPromedioArboles12Metros.setCellValue(seccionesVerificacion.getConservacionSuelos().getPromedioArbolXHectarea12MAltura());
        
        // Filas EspecieArboles
        Row rowEspecieArboles = sheet.getRow(224);
        Cell cellEspecieArboles = rowEspecieArboles.createCell(42); // AQ
        cellEspecieArboles.setCellValue(seccionesVerificacion.getConservacionSuelos().getEspeciesDiferentesArbolesXHectarea());
        
        // Filas EspeciesDeArboles
        Row rowEspeciesDeArboles = sheet.getRow(228);
        Cell cellEspeciesDeArboles;
        if(seccionesVerificacion.getConservacionSuelos().getEspeciesArbolesEnCultivo().contains("LAUREL")){
            cellEspeciesDeArboles = rowEspeciesDeArboles.createCell(22); // W
            cellEspeciesDeArboles.setCellValue("X");
            cellEspeciesDeArboles.setCellStyle(style);
        }
        if(seccionesVerificacion.getConservacionSuelos().getEspeciesArbolesEnCultivo().contains("FERNANSANCHEZ")){
            cellEspeciesDeArboles = rowEspeciesDeArboles.createCell(27); // AB
            cellEspeciesDeArboles.setCellValue("X");
            cellEspeciesDeArboles.setCellStyle(style);
        }
        if(seccionesVerificacion.getConservacionSuelos().getEspeciesArbolesEnCultivo().contains("TECA")){
            cellEspeciesDeArboles = rowEspeciesDeArboles.createCell(32); // AG
            cellEspeciesDeArboles.setCellValue("X");
            cellEspeciesDeArboles.setCellStyle(style);
        }
        if(seccionesVerificacion.getConservacionSuelos().getEspeciesArbolesEnCultivo().contains("GUAYACAN")){
            cellEspeciesDeArboles = rowEspeciesDeArboles.createCell(36); // AK
            cellEspeciesDeArboles.setCellValue("X");
            cellEspeciesDeArboles.setCellStyle(style);
        }
        if(seccionesVerificacion.getConservacionSuelos().getEspeciesArbolesEnCultivo().contains("OTRAS")){
            
            cellEspeciesDeArboles = rowEspeciesDeArboles.createCell(40); // AO
            cellEspeciesDeArboles.setCellValue("X");
            cellEspeciesDeArboles.setCellStyle(style);
            
//            cellEspeciesDeArboles = rowEspeciesDeArboles.createCell(42); // AQ
//            cellEspeciesDeArboles.setCellValue(seccionesVerificacion.getConservacionSuelos().getEspecifiqueOtrosEspeciesArboles());
//            cellEspeciesDeArboles.setCellStyle(style);
        }
        
        // Filas FuenteHidrica
        Row rowFuenteHidrica = sheet.getRow(232);
        Cell cellFuenteHidrica;
        if(seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getRespuesta().equals("SI")){
            cellFuenteHidrica = rowFuenteHidrica.createCell(13); // N
            cellFuenteHidrica.setCellValue("X");
            cellFuenteHidrica.setCellStyle(style);
            
            // Filas NombresFuentes
            if(seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getNombreFuenteHidrica().getRespuesta().contains("VERTIENTE")){
                cellFuenteHidrica = rowFuenteHidrica.createCell(20); // U
                cellFuenteHidrica.setCellValue("X");
                cellFuenteHidrica.setCellStyle(style);
            }
            if(seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getNombreFuenteHidrica().getRespuesta().contains("ESTERO")){
                cellFuenteHidrica = rowFuenteHidrica.createCell(25); // Z
                cellFuenteHidrica.setCellValue("X");
                cellFuenteHidrica.setCellStyle(style);
            }
            if(seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getNombreFuenteHidrica().getRespuesta().contains("RIO")){
                cellFuenteHidrica = rowFuenteHidrica.createCell(30); // AE
                cellFuenteHidrica.setCellValue("X");
                cellFuenteHidrica.setCellStyle(style);
            }
            if(seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getNombreFuenteHidrica().getRespuesta().contains("POZO")){
                cellFuenteHidrica = rowFuenteHidrica.createCell(35); // AJ
                cellFuenteHidrica.setCellValue("X");
                cellFuenteHidrica.setCellStyle(style);
            }
            if(seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getNombreFuenteHidrica().getRespuesta().contains("OTRO")){
                cellFuenteHidrica = rowFuenteHidrica.createCell(40); // AO
                cellFuenteHidrica.setCellValue("X");
                cellFuenteHidrica.setCellStyle(style);
                
                cellFuenteHidrica = rowFuenteHidrica.createCell(44); // AS
                cellFuenteHidrica.setCellValue(seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getNombreFuenteHidrica().getEspecifiqueOtros());
                cellFuenteHidrica.setCellStyle(style);
                
            }
            
            // Filas ComoSonConsideradasFuentes
            Row rowComoSonConsideradasFuentes = sheet.getRow(237);
            Cell cellComoSonConsideradasFuentes;
            switch (seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getConsideradaFuenteHidrica()) {
                case "PRIMARIA":
                    cellComoSonConsideradasFuentes = rowComoSonConsideradasFuentes.createCell(11); // L
                    cellComoSonConsideradasFuentes.setCellValue("X");
                    cellComoSonConsideradasFuentes.setCellStyle(style);
                    break;
                case "SECUNDARIA":
                    cellComoSonConsideradasFuentes = rowComoSonConsideradasFuentes.createCell(16); // Q
                    cellComoSonConsideradasFuentes.setCellValue("X");
                    cellComoSonConsideradasFuentes.setCellStyle(style);
                    break;
                default:
                    cellComoSonConsideradasFuentes = rowComoSonConsideradasFuentes.createCell(20); // U
                    cellComoSonConsideradasFuentes.setCellValue("X");
                    cellComoSonConsideradasFuentes.setCellStyle(style);
                    break;
            }
            
            // Filas TipoFuenteHibrida
            Row rowTipoFuenteHibrida = sheet.getRow(235);
            Cell cellTipoFuenteHibrida;
            if(seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getTipoFuenteHidrica().contains("SUPERFICIAL")){
                cellTipoFuenteHibrida = rowTipoFuenteHibrida.createCell(35); // AJ
                cellTipoFuenteHibrida.setCellValue("X");
                cellTipoFuenteHibrida.setCellStyle(style);
            }
            if(seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getTipoFuenteHidrica().contains("SUBTERRÁNEA") || 
               seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getTipoFuenteHidrica().contains("SUBTERRÁNEA")){
                cellTipoFuenteHibrida = rowTipoFuenteHibrida.createCell(45); // AT
                cellTipoFuenteHibrida.setCellValue("X");
                cellTipoFuenteHibrida.setCellStyle(style);
            }
            if(seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getTipoFuenteHidrica().contains("TEMPORAL")){
                rowTipoFuenteHibrida = sheet.getRow(237);
                cellTipoFuenteHibrida = rowTipoFuenteHibrida.createCell(35); // AJ
                cellTipoFuenteHibrida.setCellValue("X");
                cellTipoFuenteHibrida.setCellStyle(style);
            }
            if(seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getTipoFuenteHidrica().contains("PERMANENTE")){
                rowTipoFuenteHibrida = sheet.getRow(237);
                cellTipoFuenteHibrida = rowTipoFuenteHibrida.createCell(45); // AT
                cellTipoFuenteHibrida.setCellValue("X");
                cellTipoFuenteHibrida.setCellStyle(style);
            }
            if(seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getTipoFuenteHidrica().contains("ARTIFICIAL")){
                rowTipoFuenteHibrida = sheet.getRow(239);
                cellTipoFuenteHibrida = rowTipoFuenteHibrida.createCell(35); // AJ
                cellTipoFuenteHibrida.setCellValue("X");
                cellTipoFuenteHibrida.setCellStyle(style);
            }
            if(seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getTipoFuenteHidrica().contains("NATURAL")){
                rowTipoFuenteHibrida = sheet.getRow(239);
                cellTipoFuenteHibrida = rowTipoFuenteHibrida.createCell(45); // AT
                cellTipoFuenteHibrida.setCellValue("X");
                cellTipoFuenteHibrida.setCellStyle(style);
            }
            
            // Filas ProteccionFuentesHidricas
            Row rowProteccionFuentesHidricas = sheet.getRow(243);
            Cell cellProteccionFuentesHidricas;
            if(seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getBrindaProteccionFuenteHidrica().getRespuesta().equals("SI")){
                cellProteccionFuentesHidricas = rowProteccionFuentesHidricas.createCell(18); // S
                cellProteccionFuentesHidricas.setCellValue("X");
                cellProteccionFuentesHidricas.setCellStyle(style);
                
                // Filas Como
                switch (seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getBrindaProteccionFuenteHidrica().getComoBrindaProtFuentHidr()) {
                    case "CON MALEZA":
                        cellProteccionFuentesHidricas = rowProteccionFuentesHidricas.createCell(35); // AJ
                        cellProteccionFuentesHidricas.setCellValue("X");
                        cellProteccionFuentesHidricas.setCellStyle(style);
                        break;
                    case "CON ARBUSTOS":
                        cellProteccionFuentesHidricas = rowProteccionFuentesHidricas.createCell(45); // AT
                        cellProteccionFuentesHidricas.setCellValue("X");
                        cellProteccionFuentesHidricas.setCellStyle(style);
                        break;
                    default:
                        cellProteccionFuentesHidricas = rowProteccionFuentesHidricas.createCell(40); // 40
                        cellProteccionFuentesHidricas.setCellValue("X");
                        cellProteccionFuentesHidricas.setCellStyle(style);
                        break;
                }
            }
            else{
                cellProteccionFuentesHidricas = rowProteccionFuentesHidricas.createCell(20); // U
                cellProteccionFuentesHidricas.setCellValue("X");
                cellProteccionFuentesHidricas.setCellStyle(style);
            }
            
            // Filas DistanciasRequeridas
            Row rowDistanciasRequeridas = sheet.getRow(245);
            Cell cellDistanciasRequeridas;
            switch (seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getDistanciaRequerida()) {
                case "15 MTRS":
                    cellDistanciasRequeridas = rowDistanciasRequeridas.createCell(20); // U
                    cellDistanciasRequeridas.setCellValue("X");
                    cellDistanciasRequeridas.setCellStyle(style);
                    break;
                case "8 MTRS":
                    cellDistanciasRequeridas = rowDistanciasRequeridas.createCell(23); // X
                    cellDistanciasRequeridas.setCellValue("X");
                    cellDistanciasRequeridas.setCellStyle(style);
                    break;
                case "5 MTRS":
                    cellDistanciasRequeridas = rowDistanciasRequeridas.createCell(27); // AB
                    cellDistanciasRequeridas.setCellValue("X");
                    cellDistanciasRequeridas.setCellStyle(style);
                    break;
                default:
                    cellDistanciasRequeridas = rowDistanciasRequeridas.createCell(30); // AE
                    cellDistanciasRequeridas.setCellValue("X");
                    cellDistanciasRequeridas.setCellStyle(style);
                    break;
            }
            
        }
        else{
            cellFuenteHidrica = rowFuenteHidrica.createCell(15); // P
            cellFuenteHidrica.setCellValue("X");
            cellFuenteHidrica.setCellStyle(style);
        }
        
        // Filas PoseeNacientes
        Row rowPoseeNacientes = sheet.getRow(241);
        Cell cellPoseeNacientes;
        if(seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getPoseeNacientes().getRespuesta().equals("SI")){
            cellPoseeNacientes = rowPoseeNacientes.createCell(18); // S
            cellPoseeNacientes.setCellValue("X");
            cellPoseeNacientes.setCellStyle(style);
            
            // Filas Cuantas
            cellPoseeNacientes = rowPoseeNacientes.createCell(31); // AF
            cellPoseeNacientes.setCellValue(seccionesVerificacion.getProteccionAreasRiberenias().getPoseeFuenteHidrica().getPoseeNacientes().getCuantasNacientes());
            cellPoseeNacientes.setCellStyle(style);
        }
        else{
            cellPoseeNacientes = rowPoseeNacientes.createCell(20); // U
            cellPoseeNacientes.setCellValue("X");
            cellPoseeNacientes.setCellStyle(style);
        }
        
        // Filas SueloProblemasErosion
        Row rowSueloProblemasErosion = sheet.getRow(247);
        Cell cellSueloProblemasErosion;
        if(seccionesVerificacion.getProteccionAreasAltoValor().getSueloPresentaProblemaErosion().getRespuesta().equals("SI")){
            cellSueloProblemasErosion = rowSueloProblemasErosion.createCell(18); // S
            cellSueloProblemasErosion.setCellValue("X");
            cellSueloProblemasErosion.setCellStyle(style);
            
            // Filas ProblemasDeErosion
            Row rowProblemasDeErosion = sheet.getRow(247);
            Cell cellProblemasDeErosion;
            switch (seccionesVerificacion.getProteccionAreasAltoValor().getSueloPresentaProblemaErosion().getTipoProblemaErosion()) {
                case "DESLIZAMIENTO LADERAS":
                    cellProblemasDeErosion = rowProblemasDeErosion.createCell(40); // AO
                    cellProblemasDeErosion.setCellValue("X");
                    cellProblemasDeErosion.setCellStyle(style);
                    break;
                case "HÍDRICA":
                case "HIDRICA":
                    cellProblemasDeErosion = rowProblemasDeErosion.createCell(45); // AT
                    cellProblemasDeErosion.setCellValue("X");
                    cellProblemasDeErosion.setCellStyle(style);
                    break;
                case "PENDIENTES VULNERABLES":
                    rowProblemasDeErosion = sheet.getRow(249);
                    cellProblemasDeErosion = rowProblemasDeErosion.createCell(40); // AO
                    cellProblemasDeErosion.setCellValue("X");
                    cellProblemasDeErosion.setCellStyle(style);
                    break;
                case "EÓLICAS":
                case "EOLICAS":
                    rowProblemasDeErosion = sheet.getRow(249);
                    cellProblemasDeErosion = rowProblemasDeErosion.createCell(45); // AT
                    cellProblemasDeErosion.setCellValue("X");
                    cellProblemasDeErosion.setCellStyle(style);
                    break;
                default:
                    break;
            }
        }
        else{
            cellSueloProblemasErosion = rowSueloProblemasErosion.createCell(20); // U
            cellSueloProblemasErosion.setCellValue("X");
            cellSueloProblemasErosion.setCellStyle(style);
        }
        
        // Filas PracticaMejoraSuelos
        Row rowPracticaMejoraSuelos = sheet.getRow(251);
        Cell cellPracticaMejoraSuelos;
        if(seccionesVerificacion.getProteccionAreasAltoValor().getNecesitaImplementarPracticasMejoraSuelo().getRespuesta().equals("SI")){
            cellPracticaMejoraSuelos = rowPracticaMejoraSuelos.createCell(18); // S
            cellPracticaMejoraSuelos.setCellValue("X");
            cellPracticaMejoraSuelos.setCellStyle(style);
            
            // Filas Como
            Row rowComo = sheet.getRow(251);
            Cell cellComo;
            switch (seccionesVerificacion.getProteccionAreasAltoValor().getNecesitaImplementarPracticasMejoraSuelo().getComoQuePracticas()) {
                case "OXIGENACIÓN":
                case "OXIGENACION":
                    cellComo = rowComo.createCell(40); // AO
                    cellComo.setCellValue("X");
                    cellComo.setCellStyle(style);
                    break;
                case "OTRAS":
                    cellComo = rowComo.createCell(45); // AT
                    cellComo.setCellValue("X");
                    cellComo.setCellStyle(style);
                    break;
                case "INCREMENTO DE SOMBRAS":
                    rowComo = sheet.getRow(249);
                    cellComo = rowComo.createCell(40); // AO
                    cellComo.setCellValue("X");
                    cellComo.setCellStyle(style);
                    break;
                default:
                    break;
            }
        }
        else{
            cellPracticaMejoraSuelos = rowPracticaMejoraSuelos.createCell(20); // U
            cellPracticaMejoraSuelos.setCellValue("X");
            cellPracticaMejoraSuelos.setCellStyle(style);
        }
        
        // Filas GradoPresentanPendientes
        Row rowGradoPresentanPendientes = sheet.getRow(255);
        Cell cellGradoPresentanPendientes;
        switch (seccionesVerificacion.getProteccionAreasAltoValor().getGradoPresentanPendientes()) {
            case "0 A 25":
                cellGradoPresentanPendientes = rowGradoPresentanPendientes.createCell(20); // U
                cellGradoPresentanPendientes.setCellValue("X");
                cellGradoPresentanPendientes.setCellStyle(style);
                break;
            case "26 A 50":
                cellGradoPresentanPendientes = rowGradoPresentanPendientes.createCell(25); // Z
                cellGradoPresentanPendientes.setCellValue("X");
                cellGradoPresentanPendientes.setCellStyle(style);
                break;
            case "51 A 75":
                cellGradoPresentanPendientes = rowGradoPresentanPendientes.createCell(30); // AE
                cellGradoPresentanPendientes.setCellValue("X");
                cellGradoPresentanPendientes.setCellStyle(style);
                break;
            default:
                cellGradoPresentanPendientes = rowGradoPresentanPendientes.createCell(35); // AJ
                cellGradoPresentanPendientes.setCellValue("X");
                cellGradoPresentanPendientes.setCellStyle(style);
                break;
        }
        
        // Filas CuentaAreasForestales
        Row rowCuentaAreasForestales = sheet.getRow(257);
        Cell cellCuentaAreasForestales;
        if(seccionesVerificacion.getProteccionAreasAltoValor().getCuentaConAreaForestales().getRespuesta().equals("SI")){
            cellCuentaAreasForestales = rowCuentaAreasForestales.createCell(18); // S
            cellCuentaAreasForestales.setCellValue("X");
            cellCuentaAreasForestales.setCellStyle(style);
            
            // Filas TipoAreaForestal
            Cell cellTipoAreaForestal;
            switch (seccionesVerificacion.getProteccionAreasAltoValor().getCuentaConAreaForestales().getTipoAreaForestal()) {
                case "B. PRIMARIOS":
                    cellTipoAreaForestal = rowCuentaAreasForestales.createCell(30); // AE
                    cellTipoAreaForestal.setCellValue("X");
                    cellTipoAreaForestal.setCellStyle(style);
                    break;
                case "B. SECUNDARIOS":
                    cellTipoAreaForestal = rowCuentaAreasForestales.createCell(35); // AJ
                    cellTipoAreaForestal.setCellValue("X");
                    cellTipoAreaForestal.setCellStyle(style);
                    break;
                case "PLANTACIONES":
                    cellTipoAreaForestal = rowCuentaAreasForestales.createCell(40); // AO
                    cellTipoAreaForestal.setCellValue("X");
                    cellTipoAreaForestal.setCellStyle(style);
                    break;
                default:
                    cellTipoAreaForestal = rowCuentaAreasForestales.createCell(45); // AT
                    cellTipoAreaForestal.setCellValue("X");
                    cellTipoAreaForestal.setCellStyle(style);
                    break;
            }
        }
        else{
            cellCuentaAreasForestales = rowCuentaAreasForestales.createCell(20); // U
            cellCuentaAreasForestales.setCellValue("X");
            cellCuentaAreasForestales.setCellStyle(style);
        }
        
        // Filas 
        Row row_ = sheet.getRow(261);
        
        // Filas PlanesCorte
        Cell cellPlanesCorte;
        if(seccionesVerificacion.getProteccionAreasAltoValor().getRealizaPlanesCorteExtraccionMadera().equals("SI")){
            cellPlanesCorte = row_.createCell(18); // S
            cellPlanesCorte.setCellValue("X");
            cellPlanesCorte.setCellStyle(style);
        }
        else {
            cellPlanesCorte = row_.createCell(20); // U
            cellPlanesCorte.setCellValue("X");
            cellPlanesCorte.setCellStyle(style);
        }
        
        //Filas PresentaAnexo
        Cell cellPresentaAnexo;
        if(seccionesVerificacion.getProteccionAreasAltoValor().getPresentaAnexosAreasAltoValor().equals("SI")){
            cellPresentaAnexo = row_.createCell(31); // AF
            cellPresentaAnexo.setCellValue("X");
            cellPresentaAnexo.setCellStyle(style);
        }
        else {
            cellPresentaAnexo = row_.createCell(33); // AH
            cellPresentaAnexo.setCellValue("X");
            cellPresentaAnexo.setCellStyle(style);
        }
        
        //Filas PlanesDeforestacion
        Cell cellPlanesDeforestacion;
        if(seccionesVerificacion.getProteccionAreasAltoValor().getPresentaAnexosAreasAltoValor().equals("SI")){
            cellPlanesDeforestacion = row_.createCell(43); // AR
            cellPlanesDeforestacion.setCellValue("X");
            cellPlanesDeforestacion.setCellStyle(style);
        }
        else {
            cellPlanesDeforestacion = row_.createCell(45); // AT
            cellPlanesDeforestacion.setCellValue("X");
            cellPlanesDeforestacion.setCellStyle(style);
        }
        
        // Filas EspeciePeligroExtincion
        Row rowEspeciePeligroExtincion = sheet.getRow(263);
        Cell cellEspeciePeligroExtincion;
        if(seccionesVerificacion.getProteccionAreasAltoValor().getConoceEspeciePeligroExtincionEnFinca().getRespuesta().equals("SI")){
            cellEspeciePeligroExtincion = rowEspeciePeligroExtincion.createCell(18); // S
            cellEspeciePeligroExtincion.setCellValue("X");
            cellEspeciePeligroExtincion.setCellStyle(style);
            
            Cell cellCuales;
            switch (seccionesVerificacion.getProteccionAreasAltoValor().getConoceEspeciePeligroExtincionEnFinca().getCualesEspeciesPeligroExtincion()) {
                case "VEGETAL":
                    cellCuales = rowEspeciePeligroExtincion.createCell(35); // AJ
                    cellCuales.setCellValue("X");
                    cellCuales.setCellStyle(style);
                    break;
                case "ANIMAL":
                    cellCuales = rowEspeciePeligroExtincion.createCell(40); // AO
                    cellCuales.setCellValue("X");
                    cellCuales.setCellStyle(style);
                    break;
                case "AMBAS":
                    cellCuales = rowEspeciePeligroExtincion.createCell(45); // AT
                    cellCuales.setCellValue("X");
                    cellCuales.setCellStyle(style);
                    break;
                default:
                    break;
            }
            rowEspeciePeligroExtincion = sheet.getRow(265);
            cellCuales = rowEspeciePeligroExtincion.createCell(32); // AG
            cellCuales.setCellValue(seccionesVerificacion.getProteccionAreasAltoValor().getConoceEspeciePeligroExtincionEnFinca().getEspecifiqueCualesEspeciesPeligroExtincion());
            cellCuales.setCellStyle(style);
        }
        else{
            cellEspeciePeligroExtincion = rowEspeciePeligroExtincion.createCell(20); // U
            cellEspeciePeligroExtincion.setCellValue("X");
            cellEspeciePeligroExtincion.setCellStyle(style);
        }
        
        // Filas FincaAltoValor
        Row rowFincaAltoValor = sheet.getRow(269);
        Cell cellFincaAltoValor;
        if(seccionesVerificacion.getProteccionAreasAltoValor().getFincaConsideradaAltoValor().getRespuesta().equals("SI")){
            cellFincaAltoValor = rowFincaAltoValor.createCell(14); // O
            cellFincaAltoValor.setCellValue("X");
            cellFincaAltoValor.setCellStyle(style);
            
            if(seccionesVerificacion.getProteccionAreasAltoValor().getFincaConsideradaAltoValor().getTipoAltoValor().contains("AVC1")){
                cellFincaAltoValor = rowFincaAltoValor.createCell(20); // U
                cellFincaAltoValor.setCellValue("X");
                cellFincaAltoValor.setCellStyle(style);
            }
            if(seccionesVerificacion.getProteccionAreasAltoValor().getFincaConsideradaAltoValor().getTipoAltoValor().contains("AVC2")){
                cellFincaAltoValor = rowFincaAltoValor.createCell(25); // Z
                cellFincaAltoValor.setCellValue("X");
                cellFincaAltoValor.setCellStyle(style);
            }
            if(seccionesVerificacion.getProteccionAreasAltoValor().getFincaConsideradaAltoValor().getTipoAltoValor().contains("AVC3")){
                cellFincaAltoValor = rowFincaAltoValor.createCell(30); // AE
                cellFincaAltoValor.setCellValue("X");
                cellFincaAltoValor.setCellStyle(style);
            }
            if(seccionesVerificacion.getProteccionAreasAltoValor().getFincaConsideradaAltoValor().getTipoAltoValor().contains("AVC4")){
                cellFincaAltoValor = rowFincaAltoValor.createCell(35); // AJ
                cellFincaAltoValor.setCellValue("X");
                cellFincaAltoValor.setCellStyle(style);
            }
            if(seccionesVerificacion.getProteccionAreasAltoValor().getFincaConsideradaAltoValor().getTipoAltoValor().contains("AVC5")){
                cellFincaAltoValor = rowFincaAltoValor.createCell(40); // AO
                cellFincaAltoValor.setCellValue("X");
                cellFincaAltoValor.setCellStyle(style);
            }
            if(seccionesVerificacion.getProteccionAreasAltoValor().getFincaConsideradaAltoValor().getTipoAltoValor().contains("AVC6")){
                cellFincaAltoValor = rowFincaAltoValor.createCell(45); // AT
                cellFincaAltoValor.setCellValue("X");
                cellFincaAltoValor.setCellStyle(style);
            }
        }
        else{
            cellFincaAltoValor = rowFincaAltoValor.createCell(16); // Q
            cellFincaAltoValor.setCellValue("X");
            cellFincaAltoValor.setCellStyle(style);
        }
        
        // Filas DestinaCultivosDiferentes
        Row rowDestinaCultivosDiferentes = sheet.getRow(272);
        Cell cellDestinaCultivosDiferentes;
        switch (seccionesVerificacion.getDiversificacionIngresos().getUsoCultivoDiferenteCacao()) {
            case "VENTA":
                cellDestinaCultivosDiferentes = rowDestinaCultivosDiferentes.createCell(20); // U
                cellDestinaCultivosDiferentes.setCellValue("X");
                cellDestinaCultivosDiferentes.setCellStyle(style);
                break;
            case "CONSUMO":
                cellDestinaCultivosDiferentes = rowDestinaCultivosDiferentes.createCell(25); // Z
                cellDestinaCultivosDiferentes.setCellValue("X");
                cellDestinaCultivosDiferentes.setCellStyle(style);
                break;
            default:
                cellDestinaCultivosDiferentes = rowDestinaCultivosDiferentes.createCell(30); // AE
                cellDestinaCultivosDiferentes.setCellValue("X");
                cellDestinaCultivosDiferentes.setCellStyle(style);
                break;
        }
        
        // Filas OtraActividadDentroFinca
        Row rowOtraActividadDentroFinca = sheet.getRow(274);
        Cell cellOtraActividadDentroFinca;
        switch (seccionesVerificacion.getDiversificacionIngresos().getOtraActividadDentroFincaConIngreso()) {
            case "PORCICULTURA":
                cellOtraActividadDentroFinca = rowOtraActividadDentroFinca.createCell(25); // Z
                cellOtraActividadDentroFinca.setCellValue("X");
                cellOtraActividadDentroFinca.setCellStyle(style);
                break;
            case "PISCICULTURA":
                cellOtraActividadDentroFinca = rowOtraActividadDentroFinca.createCell(30); // AE
                cellOtraActividadDentroFinca.setCellValue("X");
                cellOtraActividadDentroFinca.setCellStyle(style);
                break;
            case "APICULTURA":
                cellOtraActividadDentroFinca = rowOtraActividadDentroFinca.createCell(35); // AJ
                cellOtraActividadDentroFinca.setCellValue("X");
                cellOtraActividadDentroFinca.setCellStyle(style);
                break;
            case "ELAB. PROD. ORGANICOS":
                cellOtraActividadDentroFinca = rowOtraActividadDentroFinca.createCell(40); // AO
                cellOtraActividadDentroFinca.setCellValue("X");
                cellOtraActividadDentroFinca.setCellStyle(style);
                break;
            default:
                cellOtraActividadDentroFinca = rowOtraActividadDentroFinca.createCell(45); // AT
                cellOtraActividadDentroFinca.setCellValue("X");
                cellOtraActividadDentroFinca.setCellStyle(style);
                break;
        }
        
        // Filas ImplementadoHuertosOrganicos
        Row rowImplementadoHuertosOrganicos = sheet.getRow(276);
        Cell cellImplementadoHuertosOrganicos;
        if(seccionesVerificacion.getDiversificacionIngresos().getHuertosOrganicosEnFinca().equals("SI")){
            cellImplementadoHuertosOrganicos = rowImplementadoHuertosOrganicos.createCell(23); // X
            cellImplementadoHuertosOrganicos.setCellValue("X");
            cellImplementadoHuertosOrganicos.setCellStyle(style);
        }
        else{
            cellImplementadoHuertosOrganicos = rowImplementadoHuertosOrganicos.createCell(25); // Z
            cellImplementadoHuertosOrganicos.setCellValue("X");
            cellImplementadoHuertosOrganicos.setCellStyle(style);
        }
        
        // Filas ActividadAdicionalFuera
        Row rowActividadAdicionalFuera = sheet.getRow(278);
        Cell cellActividadAdicionalFuera;
        if(seccionesVerificacion.getDiversificacionIngresos().getOtraActividadFueraFincaConIngreso().getRespuesta().equals("SI")){
            cellActividadAdicionalFuera = rowActividadAdicionalFuera.createCell(23); // X
            cellActividadAdicionalFuera.setCellValue("X");
            cellActividadAdicionalFuera.setCellStyle(style);
            
            cellActividadAdicionalFuera = rowActividadAdicionalFuera.createCell(32); // AG
            cellActividadAdicionalFuera.setCellValue(seccionesVerificacion.getDiversificacionIngresos().getOtraActividadFueraFincaConIngreso().getActividadFueraFincaConIngreso());
            cellActividadAdicionalFuera.setCellStyle(style);
            
        }
        else{
            cellActividadAdicionalFuera = rowActividadAdicionalFuera.createCell(25); // Z
            cellActividadAdicionalFuera.setCellValue("X");
            cellActividadAdicionalFuera.setCellStyle(style);
        }
        
        // Filas RealizaActividadAdicionalFuera
        Row rowRealizaActividadAdicionalFuera = sheet.getRow(280);
        Cell cellRealizaActividadAdicionalFuera;
        switch (seccionesVerificacion.getDiversificacionIngresos().getOtraActividadFueraFincaConIngreso().getRealizaActividadFueraFincaConIngreso()) {
            case "UNI. NEGOCIOS BIOFABRICAS":
                cellRealizaActividadAdicionalFuera = rowRealizaActividadAdicionalFuera.createCell(25); // Z
                cellRealizaActividadAdicionalFuera.setCellValue("X");
                cellRealizaActividadAdicionalFuera.setCellStyle(style);
                break;
            case "UNID. NEGOCIOS VIVEROS":
                cellRealizaActividadAdicionalFuera = rowRealizaActividadAdicionalFuera.createCell(35); // AJ
                cellRealizaActividadAdicionalFuera.setCellValue("X");
                cellRealizaActividadAdicionalFuera.setCellStyle(style);
                break;
            case "BRIGADAS REHABILITACION":
                cellRealizaActividadAdicionalFuera = rowRealizaActividadAdicionalFuera.createCell(45); // AT
                cellRealizaActividadAdicionalFuera.setCellValue("X");
                cellRealizaActividadAdicionalFuera.setCellStyle(style);
                break;
            default:
                break;
        }
        
    }   
    
    public void export(HttpServletResponse response){
        
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            
            writeDataRow();
            
            workbook.write(outputStream);
        
            outputStream.close();
            
        } catch (IOException ex) {
            System.out.println("No se pudo exportar el archivo");
        }
        
    }


}
