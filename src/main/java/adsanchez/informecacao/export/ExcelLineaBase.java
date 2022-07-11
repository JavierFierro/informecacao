/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.export;

import adsanchez.informecacao.entity.Agricultor;
import adsanchez.informecacao.extras.NuevosClones;
import adsanchez.informecacao.extras.ViejosInjertados;
import adsanchez.informecacao.lineaBase.Miembro;
import adsanchez.informecacao.lineaBase.SeccionesLB;
import java.io.IOException;
import java.io.InputStream;
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
public class ExcelLineaBase {
    
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    
    private Agricultor agricultor;
    private SeccionesLB seccioneslb;
    
    public ExcelLineaBase(Agricultor agricultor, SeccionesLB seccioneslb){
                
        this.agricultor = agricultor;
        this.seccioneslb = seccioneslb;
        InputStream excelMonitoreo =  getClass().getClassLoader().getResourceAsStream("Linea Base.xlsx");
        
        try {
            workbook = (XSSFWorkbook) WorkbookFactory.create(excelMonitoreo);
        } catch (IOException | InvalidFormatException ex) {
            System.out.println("Formato Erroneo");
        } 
        sheet = workbook.getSheet("Linea Base");
    }
    
    private void writeDataRow(){
        
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(false);
        font.setFontHeight(9);
        style.setFont(font);
        
        
        CellStyle styleBordeCompleto = workbook.createCellStyle();
        styleBordeCompleto.setFont(font);
        styleBordeCompleto.setBorderBottom(CellStyle.BORDER_THIN);
        styleBordeCompleto.setBorderTop(CellStyle.BORDER_THIN);
        styleBordeCompleto.setBorderRight(CellStyle.BORDER_THIN);
        styleBordeCompleto.setBorderLeft(CellStyle.BORDER_THIN);
        
        
        CellStyle styleBordeAbajo = workbook.createCellStyle();
        styleBordeAbajo.setFont(font);
        styleBordeAbajo.setBorderBottom(CellStyle.BORDER_THIN);
        
        
        //Fila fecha
        String fecha = agricultor.getDatosPersonales().getFechaVisita();
        String[] fechaSplit = fecha.split("/");
        
        String dia = fechaSplit[0];
        String mes = fechaSplit[1];
        String anio = fechaSplit[2];
        
        Row rowFecha = sheet.getRow(2);
        Cell cellFecha = rowFecha.createCell(31); // AF
        cellFecha.setCellValue(dia);
        cellFecha.setCellStyle(styleBordeCompleto);
        
        cellFecha = rowFecha.createCell(33); // AH
        cellFecha.setCellValue(mes);
        cellFecha.setCellStyle(styleBordeCompleto);
        
        cellFecha = rowFecha.createCell(35); // AJ
        cellFecha.setCellValue(anio);
        cellFecha.setCellStyle(styleBordeCompleto);
        
        //Fila Tecnico
        Row rowTecnico = sheet.getRow(4);
        Cell cellTecnico = rowTecnico.createCell(31); //AF
        cellTecnico.setCellValue(agricultor.getDatosPersonales().getTecnico());
        cellTecnico.setCellStyle(styleBordeCompleto);
        
        // Fila de Cedula y Nombres Completos
        Row row = sheet.getRow(9);
        Cell cell = row.createCell(9); // J
        cell.setCellValue(agricultor.getDatosPersonales().getCedula());
        cell.setCellStyle(styleBordeCompleto);
        
        cell = row.createCell(20); // U
        cell.setCellValue(agricultor.getDatosPersonales().getNombre());
        cell.setCellStyle(styleBordeCompleto);
        
        // Fila de Cedula y Nombres Completos
        Row rowFechaNacimiento = sheet.getRow(11);
        fecha = agricultor.getDatosPersonales().getFechaNacimiento();
        fechaSplit = fecha.split("/");
        
        dia = fechaSplit[0];
        mes = fechaSplit[1];
        anio = fechaSplit[2];
        
        Cell cellFechaNacimiento = rowFechaNacimiento.createCell(12); // M
        cellFechaNacimiento.setCellValue(dia);
        cellFechaNacimiento.setCellStyle(styleBordeCompleto);
        
        cellFechaNacimiento = rowFechaNacimiento.createCell(14); // O
        cellFechaNacimiento.setCellValue(mes);
        cellFechaNacimiento.setCellStyle(styleBordeCompleto);
        
        cellFechaNacimiento = rowFechaNacimiento.createCell(16); // Q
        cellFechaNacimiento.setCellValue(anio);
        cellFechaNacimiento.setCellStyle(styleBordeCompleto);
        
        // Fila de Cedula y Nombres Completos
        Row rowGenero = sheet.getRow(11);
        Cell cellGenero;
        if(agricultor.getDatosPersonales().getGenero().equals("MASCULINO")){
            cellGenero = rowGenero.createCell(28); // AC
            cellGenero.setCellValue("X");
            cellGenero.setCellStyle(styleBordeCompleto);
        }
        else{
            cellGenero = rowGenero.createCell(32); // AG
            cellGenero.setCellValue("X");
            cellGenero.setCellStyle(styleBordeCompleto);
        }
        
        // Fila EstadoCivil
        Row rowEstadoCivil = sheet.getRow(13);
        Cell cellEstadoCivil;
        
        switch (agricultor.getDatosPersonales().getEstadoCivil()) {
            case "SOLTERO":
                cellEstadoCivil = rowEstadoCivil.createCell(12); // M
                cellEstadoCivil.setCellValue("X");
                cellEstadoCivil.setCellStyle(styleBordeCompleto);
                break;
            case "UNION LIBRE":
                cellEstadoCivil = rowEstadoCivil.createCell(16); // Q
                cellEstadoCivil.setCellValue("X");
                cellEstadoCivil.setCellStyle(styleBordeCompleto);
                break;
            case "SEPARADO/A":
                cellEstadoCivil = rowEstadoCivil.createCell(20); // U
                cellEstadoCivil.setCellValue("X");
                cellEstadoCivil.setCellStyle(styleBordeCompleto);
                break;
            case "CASADO/A":
                cellEstadoCivil = rowEstadoCivil.createCell(24); // Y
                cellEstadoCivil.setCellValue("X");
                cellEstadoCivil.setCellStyle(styleBordeCompleto);
                break;
            case "DIVORCIADO/A":
                cellEstadoCivil = rowEstadoCivil.createCell(28); // AC
                cellEstadoCivil.setCellValue("X");
                cellEstadoCivil.setCellStyle(styleBordeCompleto);
                break;
            case "VIUDO/A":
                cellEstadoCivil = rowEstadoCivil.createCell(32); // AG
                cellEstadoCivil.setCellValue("X");
                cellEstadoCivil.setCellStyle(styleBordeCompleto);
                break;
            default:
                break;
        }
        
        // Fila NivelEducacion
        Row rowNivelEducacion = sheet.getRow(15);
        Cell cellNivelEducacion;
        
        switch (agricultor.getDatosPersonales().getNivelEducacion()) {
            case "ANALFABETO":
                cellNivelEducacion = rowNivelEducacion.createCell(16); // Q
                cellNivelEducacion.setCellValue("X");
                cellNivelEducacion.setCellStyle(styleBordeCompleto);
                break;
            case "PRIMARIA":
                cellNivelEducacion = rowNivelEducacion.createCell(20); // U
                cellNivelEducacion.setCellValue("X");
                cellNivelEducacion.setCellStyle(styleBordeCompleto);
                break;
            case "SECUNDARIA":
                cellNivelEducacion = rowNivelEducacion.createCell(24); // Y
                cellNivelEducacion.setCellValue("X");
                cellNivelEducacion.setCellStyle(styleBordeCompleto);
                break;
            case "SUPERIOR":
                cellNivelEducacion = rowNivelEducacion.createCell(28); // AC
                cellNivelEducacion.setCellValue("X");
                cellNivelEducacion.setCellStyle(styleBordeCompleto);
                break;
            default:
                break;
        }
        
        // Fila Celulares
        Row rowCelulares = sheet.getRow(17);
        List<?> celulares = agricultor.getDatosPersonales().getCelulares();
        for(int i=0;i<celulares.size()-1;i++){
            if(!celulares.get(i).equals("")){
                
                Cell cellCelular1 = rowCelulares.createCell(9); // J
                Cell cellCelular2 = rowCelulares.createCell(26); // AA
                
                cellCelular1.setCellValue(celulares.get(i).toString());
                cellCelular1.setCellStyle(styleBordeCompleto);

                cellCelular2.setCellValue(celulares.get(celulares.size()-1).toString());
                cellCelular2.setCellStyle(styleBordeCompleto);
                
            }
        }
        
        // Fila TelfConvencional
        Row rowTelfConvencional = sheet.getRow(19);
        Cell cellTelfConvencional = rowTelfConvencional.createCell(28); // AC
        cellTelfConvencional.setCellValue(agricultor.getDatosPersonales().getTelefono());
        cellTelfConvencional.setCellStyle(styleBordeCompleto);

        // Fila PresentaDiscapacidad
        Row rowPresentaDiscapacidad = sheet.getRow(19);
        Cell cellPresentaDiscapacidad;
        if(agricultor.getDatosPersonales().getIsDiscapacitado().equals("SI")){
            cellPresentaDiscapacidad = rowPresentaDiscapacidad.createCell(34); // AI
            cellPresentaDiscapacidad.setCellValue("X");
            cellPresentaDiscapacidad.setCellStyle(styleBordeCompleto);
        }
        else{
            cellPresentaDiscapacidad = rowPresentaDiscapacidad.createCell(36); // AK
            cellPresentaDiscapacidad.setCellValue("X");
            cellPresentaDiscapacidad.setCellStyle(styleBordeCompleto);
        }
        
        // Fila Provincia
        Row rowProvincia = sheet.getRow(21);
        Cell cellProvincia = rowProvincia.createCell(9); // J
        cellProvincia.setCellValue(agricultor.getInformacionFinca().getProvincia());
        cellProvincia.setCellStyle(styleBordeCompleto);
        
        // Fila Parroquia
        Row rowParroquia = sheet.getRow(21);
        Cell cellParroquia = rowParroquia.createCell(26); // AA
        cellParroquia.setCellValue(agricultor.getInformacionFinca().getParroquia());
        cellParroquia.setCellStyle(styleBordeCompleto);
        
        // Fila Canton
        Row rowCanton = sheet.getRow(23);
        Cell cellCanton = rowCanton.createCell(9); // J
        cellCanton.setCellValue(agricultor.getInformacionFinca().getCanton());
        cellCanton.setCellStyle(styleBordeCompleto);
        
        // Fila Recinto
        Row rowRecinto = sheet.getRow(23);
        Cell cellRecinto = rowRecinto.createCell(26); // AA
        cellRecinto.setCellValue(agricultor.getInformacionFinca().getRecinto());
        cellRecinto.setCellStyle(styleBordeCompleto);
        
        // Fila NombreFinca
        Row rowNombreFinca = sheet.getRow(25);
        Cell cellNombreFinca = rowNombreFinca.createCell(13); // N
        cellNombreFinca.setCellValue(agricultor.getInformacionFinca().getNombreFinca());
        cellNombreFinca.setCellStyle(styleBordeCompleto);
        
        // Fila DescripcionDetalladaParaLlegarAFinca
        Row rowDescripcionDetalladaParaLlegarAFinca = sheet.getRow(27);
        Cell cellDescripcionDetalladaParaLlegarAFinca = rowDescripcionDetalladaParaLlegarAFinca.createCell(13); // N
        cellDescripcionDetalladaParaLlegarAFinca.setCellValue(agricultor.getInformacionFinca().getDescripcionLlegarFinca());
        styleBordeCompleto.setWrapText(true);
        cellDescripcionDetalladaParaLlegarAFinca.setCellStyle(styleBordeCompleto);
        styleBordeCompleto.setWrapText(false);
        
        // Fila DimensionTotalFinca
        Row rowDimensionTotalFinca = sheet.getRow(30);
        Cell cellDimensionTotalFinca = rowDimensionTotalFinca.createCell(13); // N
        cellDimensionTotalFinca.setCellValue(agricultor.getHectareaje().getDimensionTotalFinca());
        cellDimensionTotalFinca.setCellStyle(styleBordeCompleto);
        
        // Fila TerrenoEs
        Row rowTerrenoEs = sheet.getRow(30);
        Cell cellTerrenoEs;
        switch (agricultor.getHectareaje().getTerreno()) {
            case "PROPIO":
                cellTerrenoEs = rowTerrenoEs.createCell(28); // AC
                cellTerrenoEs.setCellValue("X");
                cellTerrenoEs.setCellStyle(styleBordeCompleto);
                break;
            case "ARRENDADO":
                cellTerrenoEs = rowTerrenoEs.createCell(32); // AG
                cellTerrenoEs.setCellValue("X");
                cellTerrenoEs.setCellStyle(styleBordeCompleto);
                break;
            default:
                cellTerrenoEs = rowTerrenoEs.createCell(36); // AK
                cellTerrenoEs.setCellValue("X");
                cellTerrenoEs.setCellStyle(styleBordeCompleto);
                break;
        }
        
        // Fila CultivoCacaoEs
        Row rowCultivoCacaoEs = sheet.getRow(32);
        Cell cellCultivoCacaoEs;
        if(agricultor.getHectareaje().getCultivoCacao().equals("MONOCULTIVO")){
            cellCultivoCacaoEs = rowCultivoCacaoEs.createCell(16); // Q
            cellCultivoCacaoEs.setCellValue("X");
            cellCultivoCacaoEs.setCellStyle(styleBordeCompleto);
        }
        else if(agricultor.getHectareaje().getCultivoCacao().equals("POLICULTIVO")){
            cellCultivoCacaoEs = rowCultivoCacaoEs.createCell(20); // U
            cellCultivoCacaoEs.setCellValue("X");
            cellCultivoCacaoEs.setCellStyle(styleBordeCompleto);
        }
        
        // Fila EstaAsociadoTiene
//        Row rowEstaAsociadoTiene = sheet.getRow(32);
//        Cell cellEstaAsociadoTiene;
        
        // Fila AreaNetaCacao
        Row rowAreaNetaCacao = sheet.getRow(38);
        Cell cellAreaNetaCacao = rowAreaNetaCacao.createCell(13); // N
        cellAreaNetaCacao.setCellValue(agricultor.getHectareaje().getAreaNetaCacao());
        cellAreaNetaCacao.setCellStyle(styleBordeCompleto);
        
        // Fila PlantasPorHectareas
        Row rowPlantasPorHectareas = sheet.getRow(38);
        Cell cellPlantasPorHectareas = rowPlantasPorHectareas.createCell(29); // AD
        cellPlantasPorHectareas.setCellValue(agricultor.getHectareaje().getPlantasXHectareas());
        cellPlantasPorHectareas.setCellStyle(styleBordeCompleto);
        
        // Fila DistanciaPlantas
        Row rowDistanciaPlantas = sheet.getRow(40);
        Cell cellDistanciaPlantas;
        switch (agricultor.getHectareaje().getPlantasXHectareas()) {
            case "3X3":
                cellDistanciaPlantas = rowDistanciaPlantas.createCell(16); // Q
                cellDistanciaPlantas.setCellValue("X");
                cellDistanciaPlantas.setCellStyle(styleBordeCompleto);
                break;
            case "3,5X3,5":
                cellDistanciaPlantas = rowDistanciaPlantas.createCell(20); // U
                cellDistanciaPlantas.setCellValue("X");
                cellDistanciaPlantas.setCellStyle(styleBordeCompleto);
                break;
            case "4X4":
                cellDistanciaPlantas = rowDistanciaPlantas.createCell(24); // Y
                cellDistanciaPlantas.setCellValue("X");
                cellDistanciaPlantas.setCellStyle(styleBordeCompleto);
                break;
            case "4,5X4,5":
                cellDistanciaPlantas = rowDistanciaPlantas.createCell(28); // AC
                cellDistanciaPlantas.setCellValue("X");
                cellDistanciaPlantas.setCellStyle(styleBordeCompleto);
                break;
            default:
                cellDistanciaPlantas = rowDistanciaPlantas.createCell(32); // AG
                cellDistanciaPlantas.setCellValue("X");
                cellDistanciaPlantas.setCellStyle(styleBordeCompleto);
                cellDistanciaPlantas = rowDistanciaPlantas.createCell(33); // AH
                cellDistanciaPlantas.setCellValue(agricultor.getHectareaje().getPlantasXHectareas());
                cellDistanciaPlantas.setCellStyle(styleBordeAbajo);
                break;
        }
        
        // Fila FincaSeEncuentra
        Row rowFincaSeEncuentra = sheet.getRow(42);
        Cell cellFincaSeEncuentra;
        
        switch (agricultor.getHectareaje().getTipoUbicacionZona()) {
            case "CERCA A ZONA PROTEGIDA":
                cellFincaSeEncuentra = rowFincaSeEncuentra.createCell(20); // U
                cellFincaSeEncuentra.setCellValue("X");
                cellFincaSeEncuentra.setCellStyle(styleBordeCompleto);
                break;
            case "EN ZONA DE AMORTIGUAMIENTO":
                cellFincaSeEncuentra = rowFincaSeEncuentra.createCell(28); // AC
                cellFincaSeEncuentra.setCellValue("X");
                cellFincaSeEncuentra.setCellStyle(styleBordeCompleto);
                break;
            case "DENTRO DE ZONA PROTEGIDA":
                cellFincaSeEncuentra = rowFincaSeEncuentra.createCell(36); // AK
                cellFincaSeEncuentra.setCellValue("X");
                cellFincaSeEncuentra.setCellStyle(styleBordeCompleto);
                break;
            default:
                break;
        }
        
        // Fila AreaTotalCCN
        Row rowArea = sheet.getRow(44);
        Cell cellAreaTotalCCN = rowArea.createCell(12); // M
        cellAreaTotalCCN.setCellValue(agricultor.getCacaoCNN().getAreaTotalCNN());
        cellAreaTotalCCN.setCellStyle(styleBordeCompleto);
        
        // Fila AreaEnProduccion
        Cell cellAreaEnProduccion = rowArea.createCell(24); // Y
        cellAreaEnProduccion.setCellValue(agricultor.getCacaoCNN().getAreaProduccion());
        cellAreaEnProduccion.setCellStyle(styleBordeCompleto);
        
        // Fila EdadCacaoProductivo
        Cell cellEdadCacaoProductivo = rowArea.createCell(35); // AJ
        cellEdadCacaoProductivo.setCellValue(agricultor.getCacaoCNN().getEdadCacaoProductivo());
        cellEdadCacaoProductivo.setCellStyle(styleBordeCompleto);
        
        // Fila AreaRecienSembrada
        Row rowAreaRecienSembrada = sheet.getRow(46);
        Cell cellAreaRecienSembrada = rowAreaRecienSembrada.createCell(24); // Y
        cellAreaRecienSembrada.setCellValue(agricultor.getCacaoCNN().getAreaRecienSembrada());
        cellAreaRecienSembrada.setCellStyle(styleBordeCompleto);
        
        // Fila EdadCacaoReciente
        Cell cellEdadCacaoReciente = rowAreaRecienSembrada.createCell(35); // AJ
        cellEdadCacaoReciente.setCellValue(agricultor.getCacaoCNN().getEdadCacaoReciente());
        cellEdadCacaoReciente.setCellStyle(styleBordeCompleto);
        
        // Fila ProduccionAnioAnterior
        Row rowProduccionAnioAnterior = sheet.getRow(48);
        Cell cellProduccionAnioAnterior = rowProduccionAnioAnterior.createCell(12); // M
        cellProduccionAnioAnterior.setCellValue(agricultor.getCacaoCNN().getProduccionAnioAnteriorCacaoCNN());
        cellProduccionAnioAnterior.setCellStyle(styleBordeCompleto);
        
        // Fila PrecioPromedio
        Cell cellPrecioPromedio = rowProduccionAnioAnterior.createCell(35); // AJ
        cellPrecioPromedio.setCellValue(agricultor.getCacaoCNN().getPrecioPromedio());
        cellPrecioPromedio.setCellStyle(styleBordeCompleto);
        
        // Fila AreaTotalNacional
        Row rowAreaTotalNacional = sheet.getRow(50);
        Cell cellAreaTotalNacional = rowAreaTotalNacional.createCell(12); // M
        cellAreaTotalNacional.setCellValue(agricultor.getCacaoNacional().getAreaTotalNacional());
        cellAreaTotalNacional.setCellStyle(styleBordeCompleto);
        
        // Fila AreaTotalNacionalViejo
        Row rowAreaTotalNacionalViejo = sheet.getRow(52);
        Cell cellAreaTotalNacionalViejo = rowAreaTotalNacionalViejo.createCell(12); // M
        cellAreaTotalNacionalViejo.setCellValue(agricultor.getCacaoNacional().getAreaTotalNacionalViejo());
        cellAreaTotalNacionalViejo.setCellStyle(styleBordeCompleto);
        
        // Fila EdadCacaoViejo
        Row rowEdadCacaoViejo = sheet.getRow(52);
        Cell cellEdadCacaoViejo = rowEdadCacaoViejo.createCell(35); // AJ
        cellEdadCacaoViejo.setCellValue(agricultor.getCacaoNacional().getEdadCacaoViejo());
        cellEdadCacaoViejo.setCellStyle(styleBordeCompleto);
        
        // Fila PresentaBrotesBasales
        Row rowPresentaBrotesBasales = sheet.getRow(54);
        Cell cellPresentaBrotesBasales = rowPresentaBrotesBasales.createCell(25); // Z
        cellPresentaBrotesBasales.setCellValue(agricultor.getCacaoNacional().getBrotesBasales());
        cellPresentaBrotesBasales.setCellStyle(styleBordeCompleto);
        
        // Fila PresentaArbolesElite
        Row rowPresentaArbolesElite = sheet.getRow(54);
        Cell cellPresentaArbolesElite = rowPresentaArbolesElite.createCell(36); // AK
        cellPresentaArbolesElite.setCellValue(agricultor.getCacaoNacional().getArbolesElite());
        cellPresentaArbolesElite.setCellStyle(styleBordeCompleto);
        
        // Fila HATotalViejoInjertado
        Row rowHATotalViejoInjertado = sheet.getRow(56);
        Cell cellHATotalViejoInjertado = rowHATotalViejoInjertado.createCell(25); // Z
        cellHATotalViejoInjertado.setCellValue(agricultor.getCacaoNacional().getAreaTotalViejoInjertado());
        cellHATotalViejoInjertado.setCellStyle(styleBordeCompleto);
        
        int llenados = 0;
        for(ViejosInjertados viejo : agricultor.getCacaoNacional().getViejosInjertados()){
            if(!viejo.getAreaViejoInjertado().equals("")){
                if(llenados == 1){
                    // Fila Viejo2
                    Row rowViejo2 = sheet.getRow(58);
                    Cell cellViejo2 = rowViejo2.createCell(24); // Y
                    cellViejo2.setCellValue(viejo.getAreaViejoInjertado());
                    cellViejo2.setCellStyle(styleBordeCompleto);

                    cellViejo2 = rowViejo2.createCell(35); // AJ
                    cellViejo2.setCellValue(viejo.getEdadViejoInjertado());
                    cellViejo2.setCellStyle(styleBordeCompleto);
                    llenados ++;
                }
                if(llenados == 0){
                    // Fila Viejo1
                    Row rowViejo1 = sheet.getRow(56);
                    Cell cellViejo1 = rowViejo1.createCell(24); // Y
                    cellViejo1.setCellValue(viejo.getAreaViejoInjertado());
                    cellViejo1.setCellStyle(styleBordeCompleto);

                    cellViejo1 = rowViejo1.createCell(35); // AJ
                    cellViejo1.setCellValue(viejo.getEdadViejoInjertado());
                    cellViejo1.setCellStyle(styleBordeCompleto);
                    llenados ++;
                }
            } 
        }
        
        // Fila HANuevosClones
        Row rowHANuevosClones = sheet.getRow(60);
        Cell cellHANuevosClones = rowHANuevosClones.createCell(25); // Z
        cellHANuevosClones.setCellValue(agricultor.getCacaoNacional().getAreaTotalNuevosClones());
        cellHANuevosClones.setCellStyle(styleBordeCompleto);
        
        llenados = 0;
        for(NuevosClones nuevos : agricultor.getCacaoNacional().getNuevosClones()){
            if(!nuevos.getAreaNuevosClones().equals("")){
                if(llenados == 2){
                    // Fila Viejo3
                    Row rowViejo3 = sheet.getRow(64);
                    Cell cellViejo3 = rowViejo3.createCell(24); // Y
                    cellViejo3.setCellValue(nuevos.getAreaNuevosClones());
                    cellViejo3.setCellStyle(styleBordeCompleto);

                    cellViejo3 = rowViejo3.createCell(35); // AJ
                    cellViejo3.setCellValue(nuevos.getEdadNuevosClones());
                    cellViejo3.setCellStyle(styleBordeCompleto);
                    llenados ++;
                }
                if(llenados == 1){
                    // Fila Viejo2
                    Row rowViejo2 = sheet.getRow(62);
                    Cell cellViejo2 = rowViejo2.createCell(24); // Y
                    cellViejo2.setCellValue(nuevos.getAreaNuevosClones());
                    cellViejo2.setCellStyle(styleBordeCompleto);

                    cellViejo2 = rowViejo2.createCell(35); // AJ
                    cellViejo2.setCellValue(nuevos.getEdadNuevosClones());
                    cellViejo2.setCellStyle(styleBordeCompleto);
                    llenados ++;
                }
                if(llenados == 0){
                    // Fila Nuevos1
                    Row rowNuevos1 = sheet.getRow(60);
                    Cell cellNuevos1 = rowNuevos1.createCell(24); // Y
                    cellNuevos1.setCellValue(nuevos.getAreaNuevosClones());
                    cellNuevos1.setCellStyle(styleBordeCompleto);

                    cellNuevos1 = rowNuevos1.createCell(35); // AJ
                    cellNuevos1.setCellValue(nuevos.getEdadNuevosClones());
                    cellNuevos1.setCellStyle(styleBordeCompleto);
                    llenados ++;
                }
            } 
        }
        
        // Fila ProduccionAnioAnteriorCacao
        Row rowProduccionAnioAnteriorCacao = sheet.getRow(66);
        Cell cellProduccionAnioAnteriorCacao = rowProduccionAnioAnteriorCacao.createCell(10); // M
        cellProduccionAnioAnteriorCacao.setCellValue(agricultor.getCacaoNacional().getProduccionAnioAnteriorCacaoNacional());
        cellProduccionAnioAnteriorCacao.setCellStyle(styleBordeCompleto);
        
        // Fila PrecioPromedioPorCacao
        Row rowPrecioPromedioPorCacao = sheet.getRow(66);
        Cell cellPrecioPromedioPorCacao = rowPrecioPromedioPorCacao.createCell(35); // AJ
        cellPrecioPromedioPorCacao.setCellValue(agricultor.getCacaoNacional().getPrecioPromedioXCacao());
        cellPrecioPromedioPorCacao.setCellStyle(styleBordeCompleto);
        
        // Fila UsoAnteriorAreaNueva
        Row rowUsoAnteriorAreaNueva = sheet.getRow(68);
        Cell cellUsoAnteriorAreaNueva;
        
        switch (agricultor.getCacaoNacionalNuevosClones().getUsoAnteriorAreaNueva()) {
            case "BOSQUE":
                cellUsoAnteriorAreaNueva = rowUsoAnteriorAreaNueva.createCell(16); // Q
                cellUsoAnteriorAreaNueva.setCellValue("X");
                cellUsoAnteriorAreaNueva.setCellStyle(styleBordeCompleto);
                break;
            case "PLANTACION":
                cellUsoAnteriorAreaNueva = rowUsoAnteriorAreaNueva.createCell(20); // U
                cellUsoAnteriorAreaNueva.setCellValue("X");
                cellUsoAnteriorAreaNueva.setCellStyle(styleBordeCompleto);
                break;
            case "HUERTA VIEJA":
                cellUsoAnteriorAreaNueva = rowUsoAnteriorAreaNueva.createCell(24); // Y
                cellUsoAnteriorAreaNueva.setCellValue("X");
                cellUsoAnteriorAreaNueva.setCellStyle(styleBordeCompleto);
                break;
            case "OTRO":
                cellUsoAnteriorAreaNueva = rowUsoAnteriorAreaNueva.createCell(28); // AC
                cellUsoAnteriorAreaNueva.setCellValue("X");
                cellUsoAnteriorAreaNueva.setCellStyle(styleBordeCompleto);
                // ERROR
//                cellUsoAnteriorAreaNueva = rowUsoAnteriorAreaNueva.createCell(29); // AD
//                cellUsoAnteriorAreaNueva.setCellValue(agricultor.getCacaoNacionalNuevosClones().get);
//                cellUsoAnteriorAreaNueva.setCellStyle(styleBordeCompleto);
                break;
            default:
                break;
        }
        
        // Fila QueVariedadTiene
        Row rowQueVariedadTiene = sheet.getRow(70);
        Row rowQueVariedadTiene2 = sheet.getRow(72);
        Cell cellQueVariedadTiene;
        
        switch (agricultor.getCacaoNacionalNuevosClones().getVariedadesSembradasCalificacion()) {
            case "103":
                cellQueVariedadTiene = rowQueVariedadTiene.createCell(12); // M
                cellQueVariedadTiene.setCellValue("X");
                cellQueVariedadTiene.setCellStyle(styleBordeCompleto);
                break;
            case "96":
                cellQueVariedadTiene = rowQueVariedadTiene.createCell(18); // S
                cellQueVariedadTiene.setCellValue("X");
                cellQueVariedadTiene.setCellStyle(styleBordeCompleto);
                break;
            case "95":
                cellQueVariedadTiene = rowQueVariedadTiene.createCell(24); // Y
                cellQueVariedadTiene.setCellValue("X");
                cellQueVariedadTiene.setCellStyle(styleBordeCompleto);
                break;
            case "800":
                cellQueVariedadTiene = rowQueVariedadTiene.createCell(30); // AE
                cellQueVariedadTiene.setCellValue("X");
                cellQueVariedadTiene.setCellStyle(styleBordeCompleto);
                break;
            case "801":
                cellQueVariedadTiene = rowQueVariedadTiene.createCell(36); // AK
                cellQueVariedadTiene.setCellValue("X");
                cellQueVariedadTiene.setCellStyle(styleBordeCompleto);
                break;
            case "":
                break;
            case "NO SABE":
                cellQueVariedadTiene = rowQueVariedadTiene2.createCell(30); // AE
                cellQueVariedadTiene.setCellValue("X");
                cellQueVariedadTiene.setCellStyle(styleBordeCompleto);
                break;
            default:
                cellQueVariedadTiene = rowQueVariedadTiene2.createCell(12); // M
                cellQueVariedadTiene.setCellValue("X");
                cellQueVariedadTiene.setCellStyle(styleBordeCompleto);
                
                cellQueVariedadTiene = rowQueVariedadTiene2.createCell(20); // U
                cellQueVariedadTiene.setCellValue(agricultor.getCacaoNacionalNuevosClones().getVariedadesSembradasCalificacion());
                cellQueVariedadTiene.setCellStyle(styleBordeAbajo);
                break;
        }
        
        // Fila VariedadesSembradas
        Row rowVariedadesSembradas = sheet.getRow(74);
        Cell cellVariedadesSembradas;
        if(agricultor.getCacaoNacionalNuevosClones().getVariedadesSembradasCalificacion().equals("POSITIVAS")){
            cellVariedadesSembradas = rowVariedadesSembradas.createCell(20); // U
            cellVariedadesSembradas.setCellValue("X");
            cellVariedadesSembradas.setCellStyle(styleBordeCompleto);
        }
        if(agricultor.getCacaoNacionalNuevosClones().getVariedadesSembradasCalificacion().equals("NEGATIVAS")){
            cellVariedadesSembradas = rowVariedadesSembradas.createCell(24); // Y
            cellVariedadesSembradas.setCellValue("X");
            cellVariedadesSembradas.setCellStyle(styleBordeCompleto);
        }
        
        // Fila AdaptacionACondiciones
        Row rowAdaptacionACondiciones = sheet.getRow(76);
        Cell cellAdaptacionACondiciones;
        switch (agricultor.getCacaoNacionalNuevosClones().getVariedadesSembradasCalificacion()) {
            case "NEUTRA":
                cellAdaptacionACondiciones = rowAdaptacionACondiciones.createCell(24); // Y
                cellAdaptacionACondiciones.setCellValue("X");
                cellAdaptacionACondiciones.setCellStyle(styleBordeCompleto);
                break;
            case "FAVORABLE":
                cellAdaptacionACondiciones = rowAdaptacionACondiciones.createCell(28); // AC
                cellAdaptacionACondiciones.setCellValue("X");
                cellAdaptacionACondiciones.setCellStyle(styleBordeCompleto);
                break;
            case "DESFAVORABLE":
                cellAdaptacionACondiciones = rowAdaptacionACondiciones.createCell(33); // AH
                cellAdaptacionACondiciones.setCellValue("X");
                cellAdaptacionACondiciones.setCellStyle(styleBordeCompleto);
                break;
            default:
                break;
        }
        
        // Fila Rendimiento
        Row rowRendimiento = sheet.getRow(78);
        Cell cellRendimiento;
        switch (agricultor.getCacaoNacionalNuevosClones().getPlantulasRendimiento()) {
            case "NEUTRA":
                cellRendimiento = rowRendimiento.createCell(24); // Y
                cellRendimiento.setCellValue("X");
                cellRendimiento.setCellStyle(styleBordeCompleto);
                break;
            case "FAVORABLE":
                cellRendimiento = rowRendimiento.createCell(28); // AC
                cellRendimiento.setCellValue("X");
                cellRendimiento.setCellStyle(styleBordeCompleto);
                break;
            case "DESFAVORABLE":
                cellRendimiento = rowRendimiento.createCell(33); // AH
                cellRendimiento.setCellValue("X");
                cellRendimiento.setCellStyle(styleBordeCompleto);
                break;
            default:
                break;
        }
        
        // Fila VigoPlanta
        Row rowVigoPlanta = sheet.getRow(80);
        Cell cellVigoPlanta;
        switch (agricultor.getCacaoNacionalNuevosClones().getPlantulasVigorPlanta()) {
            case "NEUTRA":
                cellVigoPlanta = rowVigoPlanta.createCell(24); // Y
                cellVigoPlanta.setCellValue("X");
                cellVigoPlanta.setCellStyle(styleBordeCompleto);
                break;
            case "FAVORABLE":
                cellVigoPlanta = rowVigoPlanta.createCell(28); // AC
                cellVigoPlanta.setCellValue("X");
                cellVigoPlanta.setCellStyle(styleBordeCompleto);
                break;
            case "DESFAVORABLE":
                cellVigoPlanta = rowVigoPlanta.createCell(33); // AH
                cellVigoPlanta.setCellValue("X");
                cellVigoPlanta.setCellStyle(styleBordeCompleto);
                break;
            default:
                break;
        }
        
        // Fila ResistenciaEnfermedades
        Row rowResistenciaEnfermedades = sheet.getRow(82);
        Cell cellResistenciaEnfermedades;
        switch (agricultor.getCacaoNacionalNuevosClones().getPlantulasVigorPlanta()) {
            case "NEUTRA":
                cellResistenciaEnfermedades = rowResistenciaEnfermedades.createCell(24); // Y
                cellResistenciaEnfermedades.setCellValue("X");
                cellResistenciaEnfermedades.setCellStyle(styleBordeCompleto);
                break;
            case "FAVORABLE":
                cellResistenciaEnfermedades = rowResistenciaEnfermedades.createCell(28); // AC
                cellResistenciaEnfermedades.setCellValue("X");
                cellResistenciaEnfermedades.setCellStyle(styleBordeCompleto);
                break;
            case "DESFAVORABLE":
                cellResistenciaEnfermedades = rowResistenciaEnfermedades.createCell(33); // AH
                cellResistenciaEnfermedades.setCellValue("X");
                cellResistenciaEnfermedades.setCellStyle(styleBordeCompleto);
                break;
            default:
                break;
        }
        
        // Fila NombreVivero
        Row rowNombreVivero = sheet.getRow(84);
        Cell cellNombreVivero = rowNombreVivero.createCell(13); // N
        cellNombreVivero.setCellValue(agricultor.getOrigenPlantas().getNombreVivero());
        cellNombreVivero.setCellStyle(styleBordeCompleto);
        
        // Fila UbicacionVivero
        Row rowUbicacionVivero = sheet.getRow(86);
        Cell cellUbicacionVivero = rowUbicacionVivero.createCell(13); // N
        cellUbicacionVivero.setCellValue(agricultor.getOrigenPlantas().getUbicacionVivero());
        cellUbicacionVivero.setCellStyle(styleBordeCompleto);
        
        // Fila QuienRealizaPropagacion
        Row rowQuienRealizaPropagacion = sheet.getRow(88);
        Cell cellQuienRealizaPropagacion;
        
        switch (agricultor.getOrigenPlantas().getEncargadoPropagacion()) {
            case "PRODUCTOR":
                cellQuienRealizaPropagacion = rowQuienRealizaPropagacion.createCell(16); // Q
                cellQuienRealizaPropagacion.setCellValue("X");
                cellQuienRealizaPropagacion.setCellStyle(styleBordeCompleto);
                break;
            case "FAMILIAR":
                cellQuienRealizaPropagacion = rowQuienRealizaPropagacion.createCell(20); // U
                cellQuienRealizaPropagacion.setCellValue("X");
                cellQuienRealizaPropagacion.setCellStyle(styleBordeCompleto);
                break;
            case "ASESOR EXT.":
                cellQuienRealizaPropagacion = rowQuienRealizaPropagacion.createCell(24); // Y
                cellQuienRealizaPropagacion.setCellValue("X");
                cellQuienRealizaPropagacion.setCellStyle(styleBordeCompleto);
                break;
            case "OTRO":
                cellQuienRealizaPropagacion = rowQuienRealizaPropagacion.createCell(28); // AC
                cellQuienRealizaPropagacion.setCellValue("X");
                cellQuienRealizaPropagacion.setCellStyle(styleBordeCompleto);
                
                // Base especificar otro
//                cellQuienRealizaPropagacion = rowQuienRealizaPropagacion.createCell(28); // AC
//                cellQuienRealizaPropagacion.setCellValue();
//                cellQuienRealizaPropagacion.setCellStyle(styleBordeCompleto);
                break;
            default:
                break;
        }
        
        // Fila TipoConocimiento
        Row rowTipoConocimiento = sheet.getRow(90);
        Cell cellTipoConocimiento;
        if(agricultor.getOrigenPlantas().getTipoConocimiento().equals("TECNICO")){
            cellTipoConocimiento = rowTipoConocimiento.createCell(16); // Q
            cellTipoConocimiento.setCellValue("X");
            cellTipoConocimiento.setCellStyle(styleBordeCompleto);
        }
        if(agricultor.getOrigenPlantas().getTipoConocimiento().equals("EMPIRICO")){
            cellTipoConocimiento = rowTipoConocimiento.createCell(20); // U
            cellTipoConocimiento.setCellValue("X");
            cellTipoConocimiento.setCellStyle(styleBordeCompleto);
        }
        
        // Fila EntidadQueDono
        Row rowEntidadQueDono = sheet.getRow(92);
        Cell cellEntidadQueDono = rowEntidadQueDono.createCell(14); // O
        cellEntidadQueDono.setCellValue(agricultor.getOrigenPlantas().getEntidadDonacion());
        cellEntidadQueDono.setCellStyle(styleBordeCompleto);
        
        // Fila CantidadPlantasRecibidos
        Row rowCantidadPlantasRecibidos = sheet.getRow(92);
        Cell cellCantidadPlantasRecibidos = rowCantidadPlantasRecibidos.createCell(31); // AF
        cellCantidadPlantasRecibidos.setCellValue(agricultor.getOrigenPlantas().getCantidadPlantasRecibidas());
        cellCantidadPlantasRecibidos.setCellStyle(styleBordeCompleto);
        
        
        // Fila MiembrosFamilia
        Row rowMiembrosFamilia;
        Cell cellMiembrosFamilia;
        int cell1 = 12;  // M
        int cell_1 = 13; // N
        int cell_2 = 15; // P
        for(Miembro miembro: seccioneslb.getInformacionFamilia().getMiembros()){
            rowMiembrosFamilia = sheet.getRow(100);
            cellMiembrosFamilia = rowMiembrosFamilia.createCell(cell1);
            cellMiembrosFamilia.setCellValue(miembro.getClasificacionMiembroFamiliar());
            cellMiembrosFamilia.setCellStyle(styleBordeCompleto);
            
            rowMiembrosFamilia = sheet.getRow(102);
            cellMiembrosFamilia = rowMiembrosFamilia.createCell(cell1);
            cellMiembrosFamilia.setCellValue(miembro.getEdad());
            cellMiembrosFamilia.setCellStyle(styleBordeCompleto);
            
            rowMiembrosFamilia = sheet.getRow(104);
            if(miembro.getGenero().equals("MASCULINO")){
                cellMiembrosFamilia = rowMiembrosFamilia.createCell(cell_1);
                cellMiembrosFamilia.setCellValue("X");
                cellMiembrosFamilia.setCellStyle(styleBordeCompleto);
            }
            else if(miembro.getGenero().equals("FEMENINO")){
                cellMiembrosFamilia = rowMiembrosFamilia.createCell(cell_2);
                cellMiembrosFamilia.setCellValue("X");
                cellMiembrosFamilia.setCellStyle(styleBordeCompleto);
            }
            
            rowMiembrosFamilia = sheet.getRow(106);
            if(miembro.getSeguridadSocial().equals("SI")){
                cellMiembrosFamilia = rowMiembrosFamilia.createCell(cell_1);
                cellMiembrosFamilia.setCellValue("X");
                cellMiembrosFamilia.setCellStyle(styleBordeCompleto);
            }
            else if(miembro.getSeguridadSocial().equals("NO")){
                cellMiembrosFamilia = rowMiembrosFamilia.createCell(cell_2);
                cellMiembrosFamilia.setCellValue("X");
                cellMiembrosFamilia.setCellStyle(styleBordeCompleto);
            }
            
            rowMiembrosFamilia = sheet.getRow(108);
            cellMiembrosFamilia = rowMiembrosFamilia.createCell(cell1);
            cellMiembrosFamilia.setCellValue(miembro.getNivelEducacion());
            cellMiembrosFamilia.setCellStyle(styleBordeCompleto);
            
            rowMiembrosFamilia = sheet.getRow(110);
            if(miembro.getLaboraEnFinca().equals("SI")){
                cellMiembrosFamilia = rowMiembrosFamilia.createCell(cell_1);
                cellMiembrosFamilia.setCellValue("X");
                cellMiembrosFamilia.setCellStyle(styleBordeCompleto);
                
                rowMiembrosFamilia = sheet.getRow(112);
                cellMiembrosFamilia = rowMiembrosFamilia.createCell(cell1);
                cellMiembrosFamilia.setCellValue(miembro.getLaborRealizado());
                cellMiembrosFamilia.setCellStyle(styleBordeCompleto);
            
                rowMiembrosFamilia = sheet.getRow(114);
                cellMiembrosFamilia = rowMiembrosFamilia.createCell(cell1);
                cellMiembrosFamilia.setCellValue(miembro.getHorasAlDiaTrabaja());
                cellMiembrosFamilia.setCellStyle(styleBordeCompleto);
            }
            else if(miembro.getLaboraEnFinca().equals("NO")){
                cellMiembrosFamilia = rowMiembrosFamilia.createCell(cell_2);
                cellMiembrosFamilia.setCellValue("X");
                cellMiembrosFamilia.setCellStyle(styleBordeCompleto);
            }
            
            rowMiembrosFamilia = sheet.getRow(116);
            if(miembro.getTieneOtraFuenteIngreso().equals("SI")){
                cellMiembrosFamilia = rowMiembrosFamilia.createCell(cell_1);
                cellMiembrosFamilia.setCellValue("X");
                cellMiembrosFamilia.setCellStyle(styleBordeCompleto);
                
                rowMiembrosFamilia = sheet.getRow(118);
                cellMiembrosFamilia = rowMiembrosFamilia.createCell(cell1);
                cellMiembrosFamilia.setCellValue(miembro.getSueldoIngresoMensual());
                cellMiembrosFamilia.setCellStyle(styleBordeCompleto);
            }
            else if(miembro.getTieneOtraFuenteIngreso().equals("NO")){
                cellMiembrosFamilia = rowMiembrosFamilia.createCell(cell_2);
                cellMiembrosFamilia.setCellValue("X");
                cellMiembrosFamilia.setCellStyle(styleBordeCompleto);
                
                rowMiembrosFamilia = sheet.getRow(118);
                cellMiembrosFamilia = rowMiembrosFamilia.createCell(cell1);
                cellMiembrosFamilia.setCellValue("N/A");
                cellMiembrosFamilia.setCellStyle(styleBordeCompleto);
            }
            
            
            
            //12 13 15
            //19 20 22
            //26 27 29
            //33 34 36
            cell1  += 7;
            cell_1 += 7;
            cell_2 += 7;
        }
        // Fila FamiliarDiscapacidad
        Row rowFamiliarDiscapacidad = sheet.getRow(120);
        Cell cellFamiliarDiscapacidad;
        if(seccioneslb.getInformacionFamilia().getFamiliarDiscapacitado().equals("SI")){
            cellFamiliarDiscapacidad = rowFamiliarDiscapacidad.createCell(16); // Q
            cellFamiliarDiscapacidad.setCellValue("X");
            cellFamiliarDiscapacidad.setCellStyle(styleBordeCompleto);
        }
        else{
            cellFamiliarDiscapacidad = rowFamiliarDiscapacidad.createCell(18); // S
            cellFamiliarDiscapacidad.setCellValue("X");
            cellFamiliarDiscapacidad.setCellStyle(styleBordeCompleto);
        }
        
        // Fila EsposaEntrevista
        Row rowEsposaEntrevista = sheet.getRow(120);
        Cell cellEsposaEntrevista;
        if(seccioneslb.getInformacionFamilia().getEsposaInvolucradaEntrevista().equals("SI")){
            cellEsposaEntrevista = rowEsposaEntrevista.createCell(34); // AI
            cellEsposaEntrevista.setCellValue("X");
            cellEsposaEntrevista.setCellStyle(styleBordeCompleto);
        }
        else if(seccioneslb.getInformacionFamilia().getEsposaInvolucradaEntrevista().equals("NO")){
            cellEsposaEntrevista = rowEsposaEntrevista.createCell(36); // AK
            cellEsposaEntrevista.setCellValue("X");
            cellEsposaEntrevista.setCellStyle(styleBordeCompleto);
        }
        
        // Fila EsposoIncluyeEsposa
        Row rowEsposoIncluyeEsposa = sheet.getRow(122);
        Cell cellEsposoIncluyeEsposa;
        if(seccioneslb.getInformacionFamilia().getEsposoIncluyeEsposaEntrevista().equals("SI")){
            cellEsposoIncluyeEsposa = rowEsposoIncluyeEsposa.createCell(34); // AI
            cellEsposoIncluyeEsposa.setCellValue("X");
            cellEsposoIncluyeEsposa.setCellStyle(styleBordeCompleto);
        }
        else if(seccioneslb.getInformacionFamilia().getEsposoIncluyeEsposaEntrevista().equals("NO")){
            cellEsposoIncluyeEsposa = rowEsposoIncluyeEsposa.createCell(36); // AK
            cellEsposoIncluyeEsposa.setCellValue("X");
            cellEsposoIncluyeEsposa.setCellStyle(styleBordeCompleto);
        }
        
        // Fila ConyugeIngresoAdicional
        Row rowConyugeIngresoAdicional = sheet.getRow(124);
        Cell cellConyugeIngresoAdicional;
        if(seccioneslb.getInformacionFamilia().getDeseoIngresoAdicionalConyuge().equals("SI")){
            cellConyugeIngresoAdicional = rowConyugeIngresoAdicional.createCell(20); // U
            cellConyugeIngresoAdicional.setCellValue("X");
            cellConyugeIngresoAdicional.setCellStyle(styleBordeCompleto);
        }
        else if(seccioneslb.getInformacionFamilia().getDeseoIngresoAdicionalConyuge().equals("NO")){
            cellConyugeIngresoAdicional = rowConyugeIngresoAdicional.createCell(22); // W
            cellConyugeIngresoAdicional.setCellValue("X");
            cellConyugeIngresoAdicional.setCellStyle(styleBordeCompleto);
        }
        // Fila ElaborarFertilizantesNaturales
        Row rowElaborarFertilizantesNaturales = sheet.getRow(127);
        Cell cellElaborarFertilizantesNaturales;
        if(seccioneslb.getPracticasAgricolas().getInteresElaborarFertilizanteNaturalOrganico().equals("SI")){
            cellElaborarFertilizantesNaturales = rowElaborarFertilizantesNaturales.createCell(28); // AC
            cellElaborarFertilizantesNaturales.setCellValue("X");
            cellElaborarFertilizantesNaturales.setCellStyle(styleBordeCompleto);
        }
        else{
            cellElaborarFertilizantesNaturales = rowElaborarFertilizantesNaturales.createCell(30); // AE
            cellElaborarFertilizantesNaturales.setCellValue("X");
            cellElaborarFertilizantesNaturales.setCellStyle(styleBordeCompleto);
        }
        
        // Fila PlagasAfectanCultivo
        Row rowPlagasAfectanCultivo = sheet.getRow(132);
        Cell cellPlagasAfectanCultivo;
        if(seccioneslb.getPracticasAgricolas().getPlagasAfectanCultivo().contains("COCHINILLA")){
            cellPlagasAfectanCultivo = rowPlagasAfectanCultivo.createCell(9); // J
            cellPlagasAfectanCultivo.setCellValue("X");
            cellPlagasAfectanCultivo.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPlagasAfectanCultivo().contains("XILEBORUS")){
            rowPlagasAfectanCultivo = sheet.getRow(134);
            cellPlagasAfectanCultivo = rowPlagasAfectanCultivo.createCell(9); // J
            cellPlagasAfectanCultivo.setCellValue("X");
            cellPlagasAfectanCultivo.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPlagasAfectanCultivo().contains("TRIPS")){
            rowPlagasAfectanCultivo = sheet.getRow(136);
            cellPlagasAfectanCultivo = rowPlagasAfectanCultivo.createCell(9); // J
            cellPlagasAfectanCultivo.setCellValue("X");
            cellPlagasAfectanCultivo.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPlagasAfectanCultivo().contains("CHINCHORRO")){
            rowPlagasAfectanCultivo = sheet.getRow(138);
            cellPlagasAfectanCultivo = rowPlagasAfectanCultivo.createCell(9); // J
            cellPlagasAfectanCultivo.setCellValue("X");
            cellPlagasAfectanCultivo.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPlagasAfectanCultivo().contains("HORMIGA")){
            rowPlagasAfectanCultivo = sheet.getRow(140);
            cellPlagasAfectanCultivo = rowPlagasAfectanCultivo.createCell(9); // J
            cellPlagasAfectanCultivo.setCellValue("X");
            cellPlagasAfectanCultivo.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPlagasAfectanCultivo().contains("OROZCO")){
            rowPlagasAfectanCultivo = sheet.getRow(142);
            cellPlagasAfectanCultivo = rowPlagasAfectanCultivo.createCell(9); // J
            cellPlagasAfectanCultivo.setCellValue("X");
            cellPlagasAfectanCultivo.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPlagasAfectanCultivo().contains("OTROS")){
            rowPlagasAfectanCultivo = sheet.getRow(144);
            cellPlagasAfectanCultivo = rowPlagasAfectanCultivo.createCell(9); // J
            cellPlagasAfectanCultivo.setCellValue("X");
            cellPlagasAfectanCultivo.setCellStyle(styleBordeCompleto);
        }
        
        // Fila EnfermedadesAfectanCultivo
        Row rowEnfermedadesAfectanCultivo = sheet.getRow(132);
        Cell cellEnfermedadesAfectanCultivo;
        if(seccioneslb.getPracticasAgricolas().getEnfermedadesAfectanCultivo().contains("PHYTOPHTORA")){
            cellEnfermedadesAfectanCultivo = rowEnfermedadesAfectanCultivo.createCell(17); // R
            cellEnfermedadesAfectanCultivo.setCellValue("X");
            cellEnfermedadesAfectanCultivo.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getEnfermedadesAfectanCultivo().contains("ESCOBA BRUJA")){
            rowEnfermedadesAfectanCultivo = sheet.getRow(134);
            cellEnfermedadesAfectanCultivo = rowEnfermedadesAfectanCultivo.createCell(17); // R
            cellEnfermedadesAfectanCultivo.setCellValue("X");
            cellEnfermedadesAfectanCultivo.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getEnfermedadesAfectanCultivo().contains("MONILLA")){
            rowEnfermedadesAfectanCultivo = sheet.getRow(136);
            cellEnfermedadesAfectanCultivo = rowEnfermedadesAfectanCultivo.createCell(17); // R
            cellEnfermedadesAfectanCultivo.setCellValue("X");
            cellEnfermedadesAfectanCultivo.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getEnfermedadesAfectanCultivo().contains("MAL DE MACHETE")){
            rowEnfermedadesAfectanCultivo = sheet.getRow(138);
            cellEnfermedadesAfectanCultivo = rowEnfermedadesAfectanCultivo.createCell(17); // R
            cellEnfermedadesAfectanCultivo.setCellValue("X");
            cellEnfermedadesAfectanCultivo.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getEnfermedadesAfectanCultivo().contains("OTROS")){
            rowEnfermedadesAfectanCultivo = sheet.getRow(140);
            cellEnfermedadesAfectanCultivo = rowEnfermedadesAfectanCultivo.createCell(17); // R
            cellEnfermedadesAfectanCultivo.setCellValue("X");
            cellEnfermedadesAfectanCultivo.setCellStyle(styleBordeCompleto);
        }
        
        // Fila ProductoQuimicoNaturalPlagas
        Row rowProductoQuimicoNaturalPlagas = sheet.getRow(131);
        Cell cellProductoQuimicoNaturalPlagas = rowProductoQuimicoNaturalPlagas.createCell(21); // V
        cellProductoQuimicoNaturalPlagas.setCellValue(seccioneslb.getPracticasAgricolas().getProductoParaPlagas());
        cellProductoQuimicoNaturalPlagas.setCellStyle(styleBordeCompleto);
        
        // Fila ProductoQuimicoNaturalEnfermedades
        Row rowProductoQuimicoNaturalEnfermedades = sheet.getRow(137);
        Cell cellProductoQuimicoNaturalEnfermedades = rowProductoQuimicoNaturalEnfermedades.createCell(21); // V
        cellProductoQuimicoNaturalEnfermedades.setCellValue(seccioneslb.getPracticasAgricolas().getProductoParaEnfermedades());
        cellProductoQuimicoNaturalEnfermedades.setCellStyle(styleBordeCompleto);
        
        // Fila LlevaRegistroMazorcas
        Row rowLlevaRegistroMazorcas = sheet.getRow(146);
        Cell cellLlevaRegistroMazorcas;
        if(seccioneslb.getPracticasAgricolas().getLlevaRegistroPerdidasMazorcasXMonilla().getRespuesta().equals("SI")){
            cellLlevaRegistroMazorcas = rowLlevaRegistroMazorcas.createCell(19); // T
            cellLlevaRegistroMazorcas.setCellValue("X");
            cellLlevaRegistroMazorcas.setCellStyle(styleBordeCompleto);
            
            cellLlevaRegistroMazorcas = rowLlevaRegistroMazorcas.createCell(29); // AD
            cellLlevaRegistroMazorcas.setCellValue(seccioneslb.getPracticasAgricolas().getLlevaRegistroPerdidasMazorcasXMonilla().getCantidadPerdidaMazorcas());
            cellLlevaRegistroMazorcas.setCellStyle(styleBordeCompleto);
        }
        else{
            cellLlevaRegistroMazorcas = rowLlevaRegistroMazorcas.createCell(21); // V
            cellLlevaRegistroMazorcas.setCellValue("X");
            cellLlevaRegistroMazorcas.setCellStyle(styleBordeCompleto);
            
            cellLlevaRegistroMazorcas = rowLlevaRegistroMazorcas.createCell(29); // AD
            cellLlevaRegistroMazorcas.setCellValue("N/A");
            cellLlevaRegistroMazorcas.setCellStyle(styleBordeCompleto);
        }
        
        // Fila PeriodoFertiliza
        Row rowPeriodoFertiliza = sheet.getRow(154);
        Cell cellPeriodoFertiliza;
        if(seccioneslb.getPracticasAgricolas().getPeriodoFertilizacion().contains("ENERO")){
            cellPeriodoFertiliza = rowPeriodoFertiliza.createCell(10); // K
            cellPeriodoFertiliza.setCellValue("X");
            cellPeriodoFertiliza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoFertilizacion().contains("FEBRERO")){
            rowPeriodoFertiliza = sheet.getRow(156);
            cellPeriodoFertiliza = rowPeriodoFertiliza.createCell(10); // K
            cellPeriodoFertiliza.setCellValue("X");
            cellPeriodoFertiliza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoFertilizacion().contains("MARZO")){
            rowPeriodoFertiliza = sheet.getRow(158);
            cellPeriodoFertiliza = rowPeriodoFertiliza.createCell(10); // K
            cellPeriodoFertiliza.setCellValue("X");
            cellPeriodoFertiliza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoFertilizacion().contains("ABRIL")){
            rowPeriodoFertiliza = sheet.getRow(160);
            cellPeriodoFertiliza = rowPeriodoFertiliza.createCell(10); // K
            cellPeriodoFertiliza.setCellValue("X");
            cellPeriodoFertiliza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoFertilizacion().contains("MAYO")){
            rowPeriodoFertiliza = sheet.getRow(162);
            cellPeriodoFertiliza = rowPeriodoFertiliza.createCell(10); // K
            cellPeriodoFertiliza.setCellValue("X");
            cellPeriodoFertiliza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoFertilizacion().contains("JUNIO")){
            rowPeriodoFertiliza = sheet.getRow(164);
            cellPeriodoFertiliza = rowPeriodoFertiliza.createCell(10); // K
            cellPeriodoFertiliza.setCellValue("X");
            cellPeriodoFertiliza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoFertilizacion().contains("JULIO")){
            rowPeriodoFertiliza = sheet.getRow(166);
            cellPeriodoFertiliza = rowPeriodoFertiliza.createCell(10); // K
            cellPeriodoFertiliza.setCellValue("X");
            cellPeriodoFertiliza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoFertilizacion().contains("AGOSTO")){
            rowPeriodoFertiliza = sheet.getRow(168);
            cellPeriodoFertiliza = rowPeriodoFertiliza.createCell(10); // K
            cellPeriodoFertiliza.setCellValue("X");
            cellPeriodoFertiliza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoFertilizacion().contains("SEPTIEMBRE")){
            rowPeriodoFertiliza = sheet.getRow(170);
            cellPeriodoFertiliza = rowPeriodoFertiliza.createCell(10); // K
            cellPeriodoFertiliza.setCellValue("X");
            cellPeriodoFertiliza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoFertilizacion().contains("OCTUBRE")){
            rowPeriodoFertiliza = sheet.getRow(172);
            cellPeriodoFertiliza = rowPeriodoFertiliza.createCell(10); // K
            cellPeriodoFertiliza.setCellValue("X");
            cellPeriodoFertiliza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoFertilizacion().contains("NOVIEMBRE")){
            rowPeriodoFertiliza = sheet.getRow(174);
            cellPeriodoFertiliza = rowPeriodoFertiliza.createCell(10); // K
            cellPeriodoFertiliza.setCellValue("X");
            cellPeriodoFertiliza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoFertilizacion().contains("DICIEMBRE")){
            rowPeriodoFertiliza = sheet.getRow(176);
            cellPeriodoFertiliza = rowPeriodoFertiliza.createCell(10); // K
            cellPeriodoFertiliza.setCellValue("X");
            cellPeriodoFertiliza.setCellStyle(styleBordeCompleto);
        }
        
        // Fila PeriodoPoda
        Row rowPeriodoPoda = sheet.getRow(154);
        Cell cellPeriodoPoda;
        if(seccioneslb.getPracticasAgricolas().getPeriodoPoda().contains("ENERO")){
            cellPeriodoPoda = rowPeriodoPoda.createCell(16); // Q
            cellPeriodoPoda.setCellValue("X");
            cellPeriodoPoda.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoPoda().contains("FEBRERO")){
            rowPeriodoPoda = sheet.getRow(156);
            cellPeriodoPoda = rowPeriodoPoda.createCell(16); // Q
            cellPeriodoPoda.setCellValue("X");
            cellPeriodoPoda.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoPoda().contains("MARZO")){
            rowPeriodoPoda = sheet.getRow(158);
            cellPeriodoPoda = rowPeriodoPoda.createCell(16); // Q
            cellPeriodoPoda.setCellValue("X");
            cellPeriodoPoda.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoPoda().contains("ABRIL")){
            rowPeriodoPoda = sheet.getRow(160);
            cellPeriodoPoda = rowPeriodoPoda.createCell(16); // Q
            cellPeriodoPoda.setCellValue("X");
            cellPeriodoPoda.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoPoda().contains("MAYO")){
            rowPeriodoPoda = sheet.getRow(162);
            cellPeriodoPoda = rowPeriodoPoda.createCell(16); // Q
            cellPeriodoPoda.setCellValue("X");
            cellPeriodoPoda.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoPoda().contains("JUNIO")){
            rowPeriodoPoda = sheet.getRow(164);
            cellPeriodoPoda = rowPeriodoPoda.createCell(16); // Q
            cellPeriodoPoda.setCellValue("X");
            cellPeriodoPoda.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoPoda().contains("JULIO")){
            rowPeriodoPoda = sheet.getRow(166);
            cellPeriodoPoda = rowPeriodoPoda.createCell(16); // Q
            cellPeriodoPoda.setCellValue("X");
            cellPeriodoPoda.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoPoda().contains("AGOSTO")){
            rowPeriodoPoda = sheet.getRow(168);
            cellPeriodoPoda = rowPeriodoPoda.createCell(16); // Q
            cellPeriodoPoda.setCellValue("X");
            cellPeriodoPoda.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoPoda().contains("SEPTIEMBRE")){
            rowPeriodoPoda = sheet.getRow(170);
            cellPeriodoPoda = rowPeriodoPoda.createCell(16); // Q
            cellPeriodoPoda.setCellValue("X");
            cellPeriodoPoda.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoPoda().contains("OCTUBRE")){
            rowPeriodoPoda = sheet.getRow(172);
            cellPeriodoPoda = rowPeriodoPoda.createCell(16); // Q
            cellPeriodoPoda.setCellValue("X");
            cellPeriodoPoda.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoPoda().contains("NOVIEMBRE")){
            rowPeriodoPoda = sheet.getRow(174);
            cellPeriodoPoda = rowPeriodoPoda.createCell(16); // Q
            cellPeriodoPoda.setCellValue("X");
            cellPeriodoPoda.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoPoda().contains("DICIEMBRE")){
            rowPeriodoPoda = sheet.getRow(176);
            cellPeriodoPoda = rowPeriodoPoda.createCell(16); // Q
            cellPeriodoPoda.setCellValue("X");
            cellPeriodoPoda.setCellStyle(styleBordeCompleto);
        }
        
        // Fila PeriodoMaleza
        Row rowPeriodoMaleza = sheet.getRow(154);
        Cell cellPeriodoMaleza;
        if(seccioneslb.getPracticasAgricolas().getPeriodoControlMaleza().contains("ENERO")){
            cellPeriodoMaleza = rowPeriodoMaleza.createCell(22); // W
            cellPeriodoMaleza.setCellValue("X");
            cellPeriodoMaleza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoControlMaleza().contains("FEBRERO")){
            rowPeriodoMaleza = sheet.getRow(156);
            cellPeriodoMaleza = rowPeriodoMaleza.createCell(22); // W
            cellPeriodoMaleza.setCellValue("X");
            cellPeriodoMaleza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoControlMaleza().contains("MARZO")){
            rowPeriodoMaleza = sheet.getRow(158);
            cellPeriodoMaleza = rowPeriodoMaleza.createCell(22); // W
            cellPeriodoMaleza.setCellValue("X");
            cellPeriodoMaleza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoControlMaleza().contains("ABRIL")){
            rowPeriodoMaleza = sheet.getRow(160);
            cellPeriodoMaleza = rowPeriodoMaleza.createCell(22); // W
            cellPeriodoMaleza.setCellValue("X");
            cellPeriodoMaleza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoControlMaleza().contains("MAYO")){
            rowPeriodoMaleza = sheet.getRow(162);
            cellPeriodoMaleza = rowPeriodoMaleza.createCell(22); // W
            cellPeriodoMaleza.setCellValue("X");
            cellPeriodoMaleza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoControlMaleza().contains("JUNIO")){
            rowPeriodoMaleza = sheet.getRow(164);
            cellPeriodoMaleza = rowPeriodoMaleza.createCell(22); // W
            cellPeriodoMaleza.setCellValue("X");
            cellPeriodoMaleza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoControlMaleza().contains("JULIO")){
            rowPeriodoMaleza = sheet.getRow(166);
            cellPeriodoMaleza = rowPeriodoMaleza.createCell(22); // W
            cellPeriodoMaleza.setCellValue("X");
            cellPeriodoMaleza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoControlMaleza().contains("AGOSTO")){
            rowPeriodoMaleza = sheet.getRow(168);
            cellPeriodoMaleza = rowPeriodoMaleza.createCell(22); // W
            cellPeriodoMaleza.setCellValue("X");
            cellPeriodoMaleza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoControlMaleza().contains("SEPTIEMBRE")){
            rowPeriodoMaleza = sheet.getRow(170);
            cellPeriodoMaleza = rowPeriodoMaleza.createCell(22); // W
            cellPeriodoMaleza.setCellValue("X");
            cellPeriodoMaleza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoControlMaleza().contains("OCTUBRE")){
            rowPeriodoMaleza = sheet.getRow(172);
            cellPeriodoMaleza = rowPeriodoMaleza.createCell(22); // W
            cellPeriodoMaleza.setCellValue("X");
            cellPeriodoMaleza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoControlMaleza().contains("NOVIEMBRE")){
            rowPeriodoMaleza = sheet.getRow(174);
            cellPeriodoMaleza = rowPeriodoMaleza.createCell(22); // W
            cellPeriodoMaleza.setCellValue("X");
            cellPeriodoMaleza.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoControlMaleza().contains("DICIEMBRE")){
            rowPeriodoMaleza = sheet.getRow(176);
            cellPeriodoMaleza = rowPeriodoMaleza.createCell(22); // W
            cellPeriodoMaleza.setCellValue("X");
            cellPeriodoMaleza.setCellStyle(styleBordeCompleto);
        }
        
        // Fila PeriodoMIPE
        Row rowPeriodoMIPE = sheet.getRow(154);
        Cell cellPeriodoMIPE;
        if(seccioneslb.getPracticasAgricolas().getPeriodoMIPE().contains("ENERO")){
            cellPeriodoMIPE = rowPeriodoMIPE.createCell(28); // AC
            cellPeriodoMIPE.setCellValue("X");
            cellPeriodoMIPE.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoMIPE().contains("FEBRERO")){
            rowPeriodoMIPE = sheet.getRow(156);
            cellPeriodoMIPE = rowPeriodoMIPE.createCell(28); // AC
            cellPeriodoMIPE.setCellValue("X");
            cellPeriodoMIPE.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoMIPE().contains("MARZO")){
            rowPeriodoMIPE = sheet.getRow(158);
            cellPeriodoMIPE = rowPeriodoMIPE.createCell(28); // AC
            cellPeriodoMIPE.setCellValue("X");
            cellPeriodoMIPE.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoMIPE().contains("ABRIL")){
            rowPeriodoMIPE = sheet.getRow(160);
            cellPeriodoMIPE = rowPeriodoMIPE.createCell(28); // AC
            cellPeriodoMIPE.setCellValue("X");
            cellPeriodoMIPE.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoMIPE().contains("MAYO")){
            rowPeriodoMIPE = sheet.getRow(162);
            cellPeriodoMIPE = rowPeriodoMIPE.createCell(28); // AC
            cellPeriodoMIPE.setCellValue("X");
            cellPeriodoMIPE.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoMIPE().contains("JUNIO")){
            rowPeriodoMIPE = sheet.getRow(164);
            cellPeriodoMIPE = rowPeriodoMIPE.createCell(28); // AC
            cellPeriodoMIPE.setCellValue("X");
            cellPeriodoMIPE.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoMIPE().contains("JULIO")){
            rowPeriodoMIPE = sheet.getRow(166);
            cellPeriodoMIPE = rowPeriodoMIPE.createCell(28); // AC
            cellPeriodoMIPE.setCellValue("X");
            cellPeriodoMIPE.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoMIPE().contains("AGOSTO")){
            rowPeriodoMIPE = sheet.getRow(168);
            cellPeriodoMIPE = rowPeriodoMIPE.createCell(28); // AC
            cellPeriodoMIPE.setCellValue("X");
            cellPeriodoMIPE.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoMIPE().contains("SEPTIEMBRE")){
            rowPeriodoMIPE = sheet.getRow(170);
            cellPeriodoMIPE = rowPeriodoMIPE.createCell(28); // AC
            cellPeriodoMIPE.setCellValue("X");
            cellPeriodoMIPE.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoMIPE().contains("OCTUBRE")){
            rowPeriodoMIPE = sheet.getRow(172);
            cellPeriodoMIPE = rowPeriodoMIPE.createCell(28); // AC
            cellPeriodoMIPE.setCellValue("X");
            cellPeriodoMIPE.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoMIPE().contains("NOVIEMBRE")){
            rowPeriodoMIPE = sheet.getRow(174);
            cellPeriodoMIPE = rowPeriodoMIPE.createCell(28); // AC
            cellPeriodoMIPE.setCellValue("X");
            cellPeriodoMIPE.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoMIPE().contains("DICIEMBRE")){
            rowPeriodoMIPE = sheet.getRow(176);
            cellPeriodoMIPE = rowPeriodoMIPE.createCell(28); // AC
            cellPeriodoMIPE.setCellValue("X");
            cellPeriodoMIPE.setCellStyle(styleBordeCompleto);
        }
        
        // Fila PeriodoCosecha
        Row rowPeriodoCosecha = sheet.getRow(154);
        Cell cellPeriodoCosecha;
        if(seccioneslb.getPracticasAgricolas().getPeriodoCosecha().contains("ENERO")){
            cellPeriodoCosecha = rowPeriodoCosecha.createCell(34); // AI
            cellPeriodoCosecha.setCellValue("X");
            cellPeriodoCosecha.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoCosecha().contains("FEBRERO")){
            rowPeriodoCosecha = sheet.getRow(156);
            cellPeriodoCosecha = rowPeriodoCosecha.createCell(34); // AI
            cellPeriodoCosecha.setCellValue("X");
            cellPeriodoCosecha.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoCosecha().contains("MARZO")){
            rowPeriodoCosecha = sheet.getRow(158);
            cellPeriodoCosecha = rowPeriodoCosecha.createCell(34); // AI
            cellPeriodoCosecha.setCellValue("X");
            cellPeriodoCosecha.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoCosecha().contains("ABRIL")){
            rowPeriodoCosecha = sheet.getRow(160);
            cellPeriodoCosecha = rowPeriodoCosecha.createCell(34); // AI
            cellPeriodoCosecha.setCellValue("X");
            cellPeriodoCosecha.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoCosecha().contains("MAYO")){
            rowPeriodoCosecha = sheet.getRow(162);
            cellPeriodoCosecha = rowPeriodoCosecha.createCell(34); // AI
            cellPeriodoCosecha.setCellValue("X");
            cellPeriodoCosecha.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoCosecha().contains("JUNIO")){
            rowPeriodoCosecha = sheet.getRow(164);
            cellPeriodoCosecha = rowPeriodoCosecha.createCell(34); // AI
            cellPeriodoCosecha.setCellValue("X");
            cellPeriodoCosecha.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoCosecha().contains("JULIO")){
            rowPeriodoCosecha = sheet.getRow(166);
            cellPeriodoCosecha = rowPeriodoCosecha.createCell(34); // AI
            cellPeriodoCosecha.setCellValue("X");
            cellPeriodoCosecha.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoCosecha().contains("AGOSTO")){
            rowPeriodoCosecha = sheet.getRow(168);
            cellPeriodoCosecha = rowPeriodoCosecha.createCell(34); // AI
            cellPeriodoCosecha.setCellValue("X");
            cellPeriodoCosecha.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoCosecha().contains("SEPTIEMBRE")){
            rowPeriodoCosecha = sheet.getRow(170);
            cellPeriodoCosecha = rowPeriodoCosecha.createCell(34); // AI
            cellPeriodoCosecha.setCellValue("X");
            cellPeriodoCosecha.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoCosecha().contains("OCTUBRE")){
            rowPeriodoCosecha = sheet.getRow(172);
            cellPeriodoCosecha = rowPeriodoCosecha.createCell(34); // AI
            cellPeriodoCosecha.setCellValue("X");
            cellPeriodoCosecha.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoCosecha().contains("NOVIEMBRE")){
            rowPeriodoCosecha = sheet.getRow(174);
            cellPeriodoCosecha = rowPeriodoCosecha.createCell(34); // AI
            cellPeriodoCosecha.setCellValue("X");
            cellPeriodoCosecha.setCellStyle(styleBordeCompleto);
        }
        if(seccioneslb.getPracticasAgricolas().getPeriodoCosecha().contains("DICIEMBRE")){
            rowPeriodoCosecha = sheet.getRow(176);
            cellPeriodoCosecha = rowPeriodoCosecha.createCell(34); // AI
            cellPeriodoCosecha.setCellValue("X");
            cellPeriodoCosecha.setCellStyle(styleBordeCompleto);
        }
        
        // Fila AccidentesLaboral
        Row rowAccidentesLaboral = sheet.getRow(178);
        Cell cellAccidentesLaboral;
        if(seccioneslb.getSaludSeguridad().getAccidentesLaboralesUltimoAnio().getRespuesta().equals("SI")){
            cellAccidentesLaboral = rowAccidentesLaboral.createCell(21); // V
            cellAccidentesLaboral.setCellValue("X");
            cellAccidentesLaboral.setCellStyle(styleBordeCompleto);
            
            Cell cellTipoAccidente;
            switch (seccioneslb.getSaludSeguridad().getAccidentesLaboralesUltimoAnio().getTipoAccidente()) {
                case "LEVES":
                    cellTipoAccidente = rowAccidentesLaboral.createCell(28); // AC
                    cellTipoAccidente.setCellValue("X");
                    cellTipoAccidente.setCellStyle(styleBordeCompleto);
                    break;
                case "GRAVES":
                    cellTipoAccidente = rowAccidentesLaboral.createCell(32); // AG
                    cellTipoAccidente.setCellValue("X");
                    cellTipoAccidente.setCellStyle(styleBordeCompleto);
                    break;
                case "MUY GRAVES":
                    cellTipoAccidente = rowAccidentesLaboral.createCell(36); // AK
                    cellTipoAccidente.setCellValue("X");
                    cellTipoAccidente.setCellStyle(styleBordeCompleto);
                    break;
                default:
                    break;
            }
            
        }
        else{
            cellAccidentesLaboral = rowAccidentesLaboral.createCell(23); // X
            cellAccidentesLaboral.setCellValue("X");
            cellAccidentesLaboral.setCellStyle(styleBordeCompleto);
        }
        
        // Fila EpisodioIntoxicacion
        Row rowEpisodioIntoxicacion = sheet.getRow(182);
        Cell cellEpisodioIntoxicacion;
        if(seccioneslb.getSaludSeguridad().getPeriodoIntoxicacionPresente().getRespuesta().equals("SI")){
            cellEpisodioIntoxicacion = rowEpisodioIntoxicacion.createCell(21); // V
            cellEpisodioIntoxicacion.setCellValue("X");
            cellEpisodioIntoxicacion.setCellStyle(styleBordeCompleto);
            
            rowEpisodioIntoxicacion = sheet.getRow(184);
            cellEpisodioIntoxicacion = rowEpisodioIntoxicacion.createCell(25); // Z
            cellEpisodioIntoxicacion.setCellValue(seccioneslb.getSaludSeguridad().getPeriodoIntoxicacionPresente().getProducto());
            cellEpisodioIntoxicacion.setCellStyle(styleBordeCompleto);
        }
        else{
            cellEpisodioIntoxicacion = rowEpisodioIntoxicacion.createCell(23); // X
            cellEpisodioIntoxicacion.setCellValue("X");
            cellEpisodioIntoxicacion.setCellStyle(styleBordeCompleto);
            
            rowEpisodioIntoxicacion = sheet.getRow(184);
            cellEpisodioIntoxicacion = rowEpisodioIntoxicacion.createCell(25); // Z
            cellEpisodioIntoxicacion.setCellValue("N/A");
            cellEpisodioIntoxicacion.setCellStyle(styleBordeCompleto);
        }
        
        // Fila CentroSaludCercano
        Row rowCentroSaludCercano = sheet.getRow(186);
        Cell cellCentroSaludCercano;
        if(seccioneslb.getSaludSeguridad().getCentroSaludCercano().equals("SI")){
            cellCentroSaludCercano = rowCentroSaludCercano.createCell(21); // V
            cellCentroSaludCercano.setCellValue("X");
            cellCentroSaludCercano.setCellStyle(styleBordeCompleto);
        }
        else{
            cellCentroSaludCercano = rowCentroSaludCercano.createCell(23); // X
            cellCentroSaludCercano.setCellValue("X");
            cellCentroSaludCercano.setCellStyle(styleBordeCompleto);
        }
        
        // Fila SusTumbasLasRealiza
        Row rowSusTumbasLasRealiza = sheet.getRow(190);
        Cell cellSusTumbasLasRealiza;
        
        switch (seccioneslb.getCosecha().getPeriodoCadaTumba()) {
            case "CADA 8 DIAS":
                cellSusTumbasLasRealiza = rowSusTumbasLasRealiza.createCell(16); // Q
                cellSusTumbasLasRealiza.setCellValue("X");
                cellSusTumbasLasRealiza.setCellStyle(styleBordeCompleto);
                break;
            case "CADA 15 DIAS":
                cellSusTumbasLasRealiza = rowSusTumbasLasRealiza.createCell(20); // U
                cellSusTumbasLasRealiza.setCellValue("X");
                cellSusTumbasLasRealiza.setCellStyle(styleBordeCompleto);
                break;
            case "CADA MES":
                cellSusTumbasLasRealiza = rowSusTumbasLasRealiza.createCell(24); // Y
                cellSusTumbasLasRealiza.setCellValue("X");
                cellSusTumbasLasRealiza.setCellStyle(styleBordeCompleto);
                break;
            default:
                break;
        }
        
        // Fila LatasDeCacaoFresco
        Row rowLatasDeCacaoFresco = sheet.getRow(192);
        Cell cellLatasDeCacaoFresco = rowLatasDeCacaoFresco.createCell(21); // V
        cellLatasDeCacaoFresco.setCellValue(seccioneslb.getCosecha().getLatasCacaoXTumba());
        cellLatasDeCacaoFresco.setCellStyle(styleBordeCompleto);
        
        // Fila RealizaEscurridizoPreSecado
        Row rowRealizaEscurridizoPreSecado = sheet.getRow(194);
        Cell cellRealizaEscurridizoPreSecado;
        if(seccioneslb.getCosecha().getRealizaEscurridoSecadoCCN51().equals("SI")){
            cellRealizaEscurridizoPreSecado = rowRealizaEscurridizoPreSecado.createCell(22); // W
            cellRealizaEscurridizoPreSecado.setCellValue("X");
            cellRealizaEscurridizoPreSecado.setCellStyle(styleBordeCompleto);
        }
        else{
            cellRealizaEscurridizoPreSecado = rowRealizaEscurridizoPreSecado.createCell(24); // Y
            cellRealizaEscurridizoPreSecado.setCellValue("X");
            cellRealizaEscurridizoPreSecado.setCellStyle(styleBordeCompleto);
        }
        
        // Fila CuantosDiasFermentaCacao
        Row rowCuantosDiasFermentaCacao = sheet.getRow(196);
        Cell cellCuantosDiasFermentaCacao = rowCuantosDiasFermentaCacao.createCell(21); // V
        cellCuantosDiasFermentaCacao.setCellValue(seccioneslb.getCosecha().getDiasFermentadoCacao());
        cellCuantosDiasFermentaCacao.setCellStyle(styleBordeCompleto);
        
        // Fila AlmacenaCacao
        Row rowAlmacenaCacao = sheet.getRow(200);
        Cell cellAlmacenaCacao;
        if(seccioneslb.getVenta().getAlmacenaCacaoDespSecado().getRespuesta().equals("SI")){
            cellAlmacenaCacao = rowAlmacenaCacao.createCell(18); // S
            cellAlmacenaCacao.setCellValue("X");
            cellAlmacenaCacao.setCellStyle(styleBordeCompleto);
            
            cellAlmacenaCacao = rowAlmacenaCacao.createCell(31); // AF
            cellAlmacenaCacao.setCellValue(seccioneslb.getVenta().getAlmacenaCacaoDespSecado().getTiempoAlmacenadoCacao());
            cellAlmacenaCacao.setCellStyle(styleBordeCompleto);
        }
        else{
            cellAlmacenaCacao = rowAlmacenaCacao.createCell(20); // U
            cellAlmacenaCacao.setCellValue("X");
            cellAlmacenaCacao.setCellStyle(styleBordeCompleto);
            
            cellAlmacenaCacao = rowAlmacenaCacao.createCell(31); // AF
            cellAlmacenaCacao.setCellValue("N/A");
            cellAlmacenaCacao.setCellStyle(styleBordeCompleto);
        }
        
        // Fila PropiedadTransporte
        Row rowPropiedadTransporte = sheet.getRow(202);
        Cell cellPropiedadTransporte;
        if(seccioneslb.getVenta().getPropiedadTransporte().equals("PROPIO")){
            cellPropiedadTransporte = rowPropiedadTransporte.createCell(16); // Q
            cellPropiedadTransporte.setCellValue("X");
            cellPropiedadTransporte.setCellStyle(styleBordeCompleto);
        }
        else if(seccioneslb.getVenta().getPropiedadTransporte().equals("FLETADO")){
            cellPropiedadTransporte = rowPropiedadTransporte.createCell(20); // U
            cellPropiedadTransporte.setCellValue("X");
            cellPropiedadTransporte.setCellStyle(styleBordeCompleto);
        }
        
        // Fila TipoTransporte
        Row rowTipoTransporte = sheet.getRow(204);
        Cell cellTipoTransporte;
        switch (seccioneslb.getVenta().getTipoTransporte()) {
            case "CHIVA":
                cellTipoTransporte = rowTipoTransporte.createCell(16); // Q
                cellTipoTransporte.setCellValue("X");
                cellTipoTransporte.setCellStyle(styleBordeCompleto);
                break;
            case "CAMIONETA":
                cellTipoTransporte = rowTipoTransporte.createCell(20); // U
                cellTipoTransporte.setCellValue("X");
                cellTipoTransporte.setCellStyle(styleBordeCompleto);
                break;
            case "MOTO":
                cellTipoTransporte = rowTipoTransporte.createCell(24); // Y
                cellTipoTransporte.setCellValue("X");
                cellTipoTransporte.setCellStyle(styleBordeCompleto);
                break;
            case "CAMION":
                cellTipoTransporte = rowTipoTransporte.createCell(28); // AC
                cellTipoTransporte.setCellValue("X");
                cellTipoTransporte.setCellStyle(styleBordeCompleto);
                break;
            case "OTROS":
                cellTipoTransporte = rowTipoTransporte.createCell(32); // AG
                cellTipoTransporte.setCellValue("X");
                cellTipoTransporte.setCellStyle(styleBordeCompleto);
                break;
            default:
                break;
        }
        
        // Fila RegistroCostosGastos
        Row rowRegistroCostosGastos = sheet.getRow(206);
        Cell cellRegistroCostosGastos;
        if(seccioneslb.getVenta().getRegistroFinancieroFinca().equals("SI")){
            cellRegistroCostosGastos = rowRegistroCostosGastos.createCell(28); // AC
            cellRegistroCostosGastos.setCellValue("X");
            cellRegistroCostosGastos.setCellStyle(styleBordeCompleto);
        }
        else{
            cellRegistroCostosGastos = rowRegistroCostosGastos.createCell(30); // AE
            cellRegistroCostosGastos.setCellValue("X");
            cellRegistroCostosGastos.setCellStyle(styleBordeCompleto);
        }
        
        // Fila ControlarResultadosFinca
        Row rowControlarResultadosFinca = sheet.getRow(208);
        Cell cellControlarResultadosFinca = rowControlarResultadosFinca.createCell(27); // AB
        cellControlarResultadosFinca.setCellValue(seccioneslb.getVenta().getTipoRegistrosFinancierosFinca());
        cellControlarResultadosFinca.setCellStyle(styleBordeCompleto);
        
        // Fila PerteneceOrganizacionPrograma
        Row rowPerteneceOrganizacionPrograma = sheet.getRow(211);
        Cell cellPerteneceOrganizacionPrograma;
        if(seccioneslb.getNivelAsociatividad().getPerteneceAsocProgrCertif().getRespuesta().equals("SI")){
            cellPerteneceOrganizacionPrograma = rowPerteneceOrganizacionPrograma.createCell(28); // AC
            cellPerteneceOrganizacionPrograma.setCellValue("X");
            cellPerteneceOrganizacionPrograma.setCellStyle(styleBordeCompleto);
            
            // Fila NombrePrograma
            Row rowNombrePrograma = sheet.getRow(213);
            Cell cellNombrePrograma = rowNombrePrograma.createCell(16); // Q
            cellNombrePrograma.setCellValue(seccioneslb.getNivelAsociatividad().getPerteneceAsocProgrCertif().getNombreAsociacion());
            cellNombrePrograma.setCellStyle(styleBordeCompleto);
            
            // Fila CuantosMiembros
            Row rowCuantosMiembros = sheet.getRow(215);
            Cell cellCuantosMiembros = rowCuantosMiembros.createCell(16); // Q
            cellCuantosMiembros.setCellValue(seccioneslb.getNivelAsociatividad().getPerteneceAsocProgrCertif().getCantidadMiembros());
            cellCuantosMiembros.setCellStyle(styleBordeCompleto);
        
            // Fila RecibeBeneficios
            Row rowRecibeBeneficios = sheet.getRow(217);
            Cell cellRecibeBeneficios;
            if(seccioneslb.getNivelAsociatividad().getPerteneceAsocProgrCertif().getRecibeBeneficios().equals("SI")){
                cellRecibeBeneficios = rowRecibeBeneficios.createCell(22); // W
                cellRecibeBeneficios.setCellValue("X");
                cellRecibeBeneficios.setCellStyle(styleBordeCompleto);
                
                // Fila Beneficios
                Row rowBeneficios = sheet.getRow(219);
                Cell cellBeneficios;
                if(seccioneslb.getNivelAsociatividad().getPerteneceAsocProgrCertif().getTiposBeneficios().getRespuesta().contains("ASIST. TÉCNICA") || seccioneslb.getNivelAsociatividad().getPerteneceAsocProgrCertif().getTiposBeneficios().getRespuesta().contains("ASIST. TECNICA")){
                    cellBeneficios = rowBeneficios.createCell(20); // U
                    cellBeneficios.setCellValue("X");
                    cellBeneficios.setCellStyle(styleBordeCompleto);
                }
                if(seccioneslb.getNivelAsociatividad().getPerteneceAsocProgrCertif().getTiposBeneficios().getRespuesta().contains("TRANSPORTE")){
                    cellBeneficios = rowBeneficios.createCell(28); // AC
                    cellBeneficios.setCellValue("X");
                    cellBeneficios.setCellStyle(styleBordeCompleto);
                }
                if(seccioneslb.getNivelAsociatividad().getPerteneceAsocProgrCertif().getTiposBeneficios().getRespuesta().contains("CAPACITACIÓN") || seccioneslb.getNivelAsociatividad().getPerteneceAsocProgrCertif().getTiposBeneficios().getRespuesta().contains("CAPACITACION")){
                    cellBeneficios = rowBeneficios.createCell(36); // AK
                    cellBeneficios.setCellValue("X");
                    cellBeneficios.setCellStyle(styleBordeCompleto);
                }
                if(seccioneslb.getNivelAsociatividad().getPerteneceAsocProgrCertif().getTiposBeneficios().getRespuesta().contains("PRECIO MEJORADO")){
                    rowBeneficios = sheet.getRow(221);
                    cellBeneficios = rowBeneficios.createCell(20); // U
                    cellBeneficios.setCellValue("X");
                    cellBeneficios.setCellStyle(styleBordeCompleto);
                }
                if(seccioneslb.getNivelAsociatividad().getPerteneceAsocProgrCertif().getTiposBeneficios().getRespuesta().contains("PRECIO")){
                    rowBeneficios = sheet.getRow(221);
                    cellBeneficios = rowBeneficios.createCell(28); // AC
                    cellBeneficios.setCellValue("X");
                    cellBeneficios.setCellStyle(styleBordeCompleto);
                }
                if(seccioneslb.getNivelAsociatividad().getPerteneceAsocProgrCertif().getTiposBeneficios().getRespuesta().contains("INSUMO")){
                    rowBeneficios = sheet.getRow(221);
                    cellBeneficios = rowBeneficios.createCell(36); // AK
                    cellBeneficios.setCellValue("X");
                    cellBeneficios.setCellStyle(styleBordeCompleto);
                }
                if(!"".equals(seccioneslb.getNivelAsociatividad().getPerteneceAsocProgrCertif().getTiposBeneficios().getOtroTiposBeneficios())){
                    rowBeneficios = sheet.getRow(223);
                    cellBeneficios = rowBeneficios.createCell(20); // U
                    cellBeneficios.setCellValue("X");
                    cellBeneficios.setCellStyle(styleBordeCompleto);
                }
            }
            else{
                cellRecibeBeneficios = rowRecibeBeneficios.createCell(24); // Y
                cellRecibeBeneficios.setCellValue("X");
                cellRecibeBeneficios.setCellStyle(styleBordeCompleto);
            }
        }
        else{
            cellPerteneceOrganizacionPrograma = rowPerteneceOrganizacionPrograma.createCell(30); // AE
            cellPerteneceOrganizacionPrograma.setCellValue("X");
            cellPerteneceOrganizacionPrograma.setCellStyle(styleBordeCompleto);
            
            // Fila NombrePrograma
            Row rowNombrePrograma = sheet.getRow(213);
            Cell cellNombrePrograma = rowNombrePrograma.createCell(16); // Q
            cellNombrePrograma.setCellValue("N/A");
            cellNombrePrograma.setCellStyle(styleBordeCompleto);
            
            // Fila CuantosMiembros
            Row rowCuantosMiembros = sheet.getRow(215);
            Cell cellCuantosMiembros = rowCuantosMiembros.createCell(27); // AB
            cellCuantosMiembros.setCellValue("N/A");
            cellCuantosMiembros.setCellStyle(styleBordeCompleto);
        }
        
        // Fila ContrataTrabajadores
        Row rowContrataTrabajadores = sheet.getRow(226);
        Cell cellContrataTrabajadores;
        if(seccioneslb.getCondicionesLaborales().getContrataTrabajadores().getRespuesta().equals("SI")){
            cellContrataTrabajadores = rowContrataTrabajadores.createCell(18); // S
            cellContrataTrabajadores.setCellValue("X");
            cellContrataTrabajadores.setCellStyle(styleBordeCompleto);
            
            cellContrataTrabajadores = rowContrataTrabajadores.createCell(31); // AF
            cellContrataTrabajadores.setCellValue(seccioneslb.getCondicionesLaborales().getContrataTrabajadores().getCantidadTrabajadores());
            cellContrataTrabajadores.setCellStyle(styleBordeCompleto);
            
            rowContrataTrabajadores = sheet.getRow(228);
            cellContrataTrabajadores = rowContrataTrabajadores.createCell(17); // R
            cellContrataTrabajadores.setCellValue(seccioneslb.getCondicionesLaborales().getAreaInicialContrato());
            cellContrataTrabajadores.setCellStyle(styleBordeCompleto);
            
            rowContrataTrabajadores = sheet.getRow(230);
            if(seccioneslb.getCondicionesLaborales().getTipoContratoTrabajo().equals("PERMANENTES")){
                cellContrataTrabajadores = rowContrataTrabajadores.createCell(20); // U
                cellContrataTrabajadores.setCellValue("X");
                cellContrataTrabajadores.setCellStyle(styleBordeCompleto);
            }
            else if(seccioneslb.getCondicionesLaborales().getTipoContratoTrabajo().equals("OCASIONALES")){
                cellContrataTrabajadores = rowContrataTrabajadores.createCell(24); // Y
                cellContrataTrabajadores.setCellValue("X");
                cellContrataTrabajadores.setCellStyle(styleBordeCompleto);
            }
            
            rowContrataTrabajadores = sheet.getRow(232);
            if(seccioneslb.getCondicionesLaborales().getContrataMenoresEdad().getRespuesta().equals("SI")){
                cellContrataTrabajadores = rowContrataTrabajadores.createCell(18); // S
                cellContrataTrabajadores.setCellValue("X");
                cellContrataTrabajadores.setCellStyle(styleBordeCompleto);
                
                rowContrataTrabajadores = sheet.getRow(234);
                if(seccioneslb.getCondicionesLaborales().getContrataMenoresEdad().getPoseePermiso().equals("SI")){
                    cellContrataTrabajadores = rowContrataTrabajadores.createCell(26); // AA
                    cellContrataTrabajadores.setCellValue("X");
                    cellContrataTrabajadores.setCellStyle(styleBordeCompleto);
                }
                else{
                    cellContrataTrabajadores = rowContrataTrabajadores.createCell(28); // AC
                    cellContrataTrabajadores.setCellValue("X");
                    cellContrataTrabajadores.setCellStyle(styleBordeCompleto);
                }
            }
            else{
                cellContrataTrabajadores = rowContrataTrabajadores.createCell(20); // U
                cellContrataTrabajadores.setCellValue("X");
                cellContrataTrabajadores.setCellStyle(styleBordeCompleto);
            }
            
            rowContrataTrabajadores = sheet.getRow(236);
            if(seccioneslb.getCondicionesLaborales().getBaseContratoAgricola().equals("SI")){
                cellContrataTrabajadores = rowContrataTrabajadores.createCell(34); // AI
                cellContrataTrabajadores.setCellValue("X");
                cellContrataTrabajadores.setCellStyle(styleBordeCompleto);
            }
            else{
                cellContrataTrabajadores = rowContrataTrabajadores.createCell(36); // AK
                cellContrataTrabajadores.setCellValue("X");
                cellContrataTrabajadores.setCellStyle(styleBordeCompleto);
            }
        }
        else{
            cellContrataTrabajadores = rowContrataTrabajadores.createCell(20); // U
            cellContrataTrabajadores.setCellValue("X");
            cellContrataTrabajadores.setCellStyle(styleBordeCompleto);
            
            cellContrataTrabajadores = rowContrataTrabajadores.createCell(31); // AF
            cellContrataTrabajadores.setCellValue("N/A");
            cellContrataTrabajadores.setCellStyle(styleBordeCompleto);
            
            rowContrataTrabajadores = sheet.getRow(228);
            cellContrataTrabajadores = rowContrataTrabajadores.createCell(17); // R
            cellContrataTrabajadores.setCellValue("N/A");
            cellContrataTrabajadores.setCellStyle(styleBordeCompleto);
        }
        
        // Fila CuentaEnergiaElectrica
        Row rowCuentaEnergiaElectrica = sheet.getRow(239);
        Cell cellCuentaEnergiaElectrica;
        if(seccioneslb.getServiciosBasicos().getEnergiaElectrica().equals("SI")){
            cellCuentaEnergiaElectrica = rowCuentaEnergiaElectrica.createCell(18); // S
            cellCuentaEnergiaElectrica.setCellValue("X");
            cellCuentaEnergiaElectrica.setCellStyle(styleBordeCompleto);
        }
        else{
            cellCuentaEnergiaElectrica = rowCuentaEnergiaElectrica.createCell(20); // U
            cellCuentaEnergiaElectrica.setCellValue("X");
            cellCuentaEnergiaElectrica.setCellStyle(styleBordeCompleto);
        }
        
        // Fila AguaParaConsumo
        Row rowAguaParaConsumo = sheet.getRow(241);
        Cell cellAguaParaConsumo;
        switch (seccioneslb.getServiciosBasicos().getTipoAguaConsumoFamiliar()) {
            case "POTABLE":
                cellAguaParaConsumo = rowAguaParaConsumo.createCell(20); // U
                cellAguaParaConsumo.setCellValue("X");
                cellAguaParaConsumo.setCellStyle(styleBordeCompleto);
                break;
            case "ENTUBADA":
                cellAguaParaConsumo = rowAguaParaConsumo.createCell(24); // Y
                cellAguaParaConsumo.setCellValue("X");
                cellAguaParaConsumo.setCellStyle(styleBordeCompleto);
                break;
            case "POZO":
                cellAguaParaConsumo = rowAguaParaConsumo.createCell(28); // AC
                cellAguaParaConsumo.setCellValue("X");
                cellAguaParaConsumo.setCellStyle(styleBordeCompleto);
                break;
            case "VERTIENTE NAT":
                cellAguaParaConsumo = rowAguaParaConsumo.createCell(32); // AG
                cellAguaParaConsumo.setCellValue("X");
                cellAguaParaConsumo.setCellStyle(styleBordeCompleto);
                break;
            case "LLUVIA":
                cellAguaParaConsumo = rowAguaParaConsumo.createCell(36); // AK
                cellAguaParaConsumo.setCellValue("X");
                cellAguaParaConsumo.setCellStyle(styleBordeCompleto);
                break;
            case "ESTERO":
                rowAguaParaConsumo = sheet.getRow(243);
                cellAguaParaConsumo = rowAguaParaConsumo.createCell(20); // U
                cellAguaParaConsumo.setCellValue("X");
                cellAguaParaConsumo.setCellStyle(styleBordeCompleto);
                break;
            case "RIO":
                rowAguaParaConsumo = sheet.getRow(243);
                cellAguaParaConsumo = rowAguaParaConsumo.createCell(24); // Y
                cellAguaParaConsumo.setCellValue("X");
                cellAguaParaConsumo.setCellStyle(styleBordeCompleto);
                break;
            case "OTRO":
                rowAguaParaConsumo = sheet.getRow(243);
                cellAguaParaConsumo = rowAguaParaConsumo.createCell(28); // AC
                cellAguaParaConsumo.setCellValue("X");
                cellAguaParaConsumo.setCellStyle(styleBordeCompleto);
                break;
            default:
                break;
        }
        
        // Fila ConocimientoManejoDesechos
        Row rowConocimientoManejoDesechos = sheet.getRow(245);
        Cell cellConocimientoManejoDesechos;
        if(seccioneslb.getConservacionRecursosDesechos().getConocimientoManejoDesechos().equals("SI")){
            cellConocimientoManejoDesechos = rowConocimientoManejoDesechos.createCell(22); // W
            cellConocimientoManejoDesechos.setCellValue("X");
            cellConocimientoManejoDesechos.setCellStyle(styleBordeCompleto);
        }
        else{
            cellConocimientoManejoDesechos = rowConocimientoManejoDesechos.createCell(24); // Y
            cellConocimientoManejoDesechos.setCellValue("X");
            cellConocimientoManejoDesechos.setCellStyle(styleBordeCompleto);
        }
        
        // Fila ProductoContamina
        Row rowProductoContamina = sheet.getRow(247);
        Cell cellProductoContamina;
        if(seccioneslb.getConservacionRecursosDesechos().getProductoContaminaEcosistema().getRespuesta().equals("SI")){
            cellProductoContamina = rowProductoContamina.createCell(22); // W
            cellProductoContamina.setCellValue("X");
            cellProductoContamina.setCellStyle(styleBordeCompleto);
            
            // Fila ViertenAguasNegras
            Row rowViertenAguasNegras = sheet.getRow(249);
            Cell cellViertenAguasNegras;
            if(seccioneslb.getConservacionRecursosDesechos().getProductoContaminaEcosistema().getUbicacionDesechosAguasNegras().contains("SERV. HIGIÉNICO") || seccioneslb.getConservacionRecursosDesechos().getProductoContaminaEcosistema().getUbicacionDesechosAguasNegras().contains("SERV. HIGIENICO")){
                cellViertenAguasNegras = rowViertenAguasNegras.createCell(28); // AC
                cellViertenAguasNegras.setCellValue("X");
                cellViertenAguasNegras.setCellStyle(styleBordeCompleto);
            }
            if(seccioneslb.getConservacionRecursosDesechos().getProductoContaminaEcosistema().getUbicacionDesechosAguasNegras().contains("LETRINA")){
                cellViertenAguasNegras = rowViertenAguasNegras.createCell(36); // AK
                cellViertenAguasNegras.setCellValue("X");
                cellViertenAguasNegras.setCellStyle(styleBordeCompleto);
            }
            if(seccioneslb.getConservacionRecursosDesechos().getProductoContaminaEcosistema().getUbicacionDesechosAguasNegras().contains("POZO SÉPTICO") || seccioneslb.getConservacionRecursosDesechos().getProductoContaminaEcosistema().getUbicacionDesechosAguasNegras().contains("POZO SEPTICO")){
                rowViertenAguasNegras = sheet.getRow(251);
                cellViertenAguasNegras = rowViertenAguasNegras.createCell(28); // AC
                cellViertenAguasNegras.setCellValue("X");
                cellViertenAguasNegras.setCellStyle(styleBordeCompleto);
            }
            if(seccioneslb.getConservacionRecursosDesechos().getProductoContaminaEcosistema().getUbicacionDesechosAguasNegras().contains("NINGUNO")){
                rowViertenAguasNegras = sheet.getRow(251);
                cellViertenAguasNegras = rowViertenAguasNegras.createCell(36); // AK
                cellViertenAguasNegras.setCellValue("X");
                cellViertenAguasNegras.setCellStyle(styleBordeCompleto);
            }
        }
        else{
            cellProductoContamina = rowProductoContamina.createCell(24); // Y
            cellProductoContamina.setCellValue("X");
            cellProductoContamina.setCellStyle(styleBordeCompleto);
        }
        
        // Fila ProductoArbolesSombrios
        Row rowProductoArbolesSombrios = sheet.getRow(253);
        Cell cellProductoArbolesSombrios;
        if(seccioneslb.getConservacionRecursosDesechos().getTieneArbolesSombrio().equals("SI")){
            cellProductoArbolesSombrios = rowProductoArbolesSombrios.createCell(22); // W
            cellProductoArbolesSombrios.setCellValue("X");
            cellProductoArbolesSombrios.setCellStyle(styleBordeCompleto);
        }
        else{
            cellProductoArbolesSombrios = rowProductoArbolesSombrios.createCell(24); // Y
            cellProductoArbolesSombrios.setCellValue("X");
            cellProductoArbolesSombrios.setCellStyle(styleBordeCompleto);
        }
        
        // Fila EspacioParaCultivo
        Row rowEspacioParaCultivo = sheet.getRow(255);
        Cell cellEspacioParaCultivo;
        if(seccioneslb.getConservacionRecursosDesechos().getCultivaVegetalesHortalizasFrutas().equals("SI")){
            cellEspacioParaCultivo = rowEspacioParaCultivo.createCell(34); // AI
            cellEspacioParaCultivo.setCellValue("X");
            cellEspacioParaCultivo.setCellStyle(styleBordeCompleto);
        }
        else{
            cellEspacioParaCultivo = rowEspacioParaCultivo.createCell(36); // AK
            cellEspacioParaCultivo.setCellValue("X");
            cellEspacioParaCultivo.setCellStyle(styleBordeCompleto);
        }
        
        // Fila CompraProductosLocales
        Row rowCompraProductosLocales = sheet.getRow(257);
        Cell cellCompraProductosLocales;
        if(seccioneslb.getConservacionRecursosDesechos().getCompraProductosMercadoLocales().getRespuesta().equals("SI")){
            cellCompraProductosLocales = rowCompraProductosLocales.createCell(22); // W
            cellCompraProductosLocales.setCellValue("X");
            cellCompraProductosLocales.setCellStyle(styleBordeCompleto);
            
            rowCompraProductosLocales = sheet.getRow(259);
            cellCompraProductosLocales = rowCompraProductosLocales.createCell(25); // Z
            cellCompraProductosLocales.setCellValue(seccioneslb.getConservacionRecursosDesechos().getCompraProductosMercadoLocales().getValorPromedioGastado());
            cellCompraProductosLocales.setCellStyle(styleBordeCompleto);
        }
        else{
            cellCompraProductosLocales = rowCompraProductosLocales.createCell(24); // Y
            cellCompraProductosLocales.setCellValue("X");
            cellCompraProductosLocales.setCellStyle(styleBordeCompleto);
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
