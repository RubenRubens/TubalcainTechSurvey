package com.example.survey.factories;

import com.example.survey.clases.ClaseResultado;
import com.example.survey.clases.ClaseTecnologia;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ResultadoFactory {

    private String textoXml;

    public ResultadoFactory(String textoXml) {
        this.textoXml = textoXml;
    }

    // Metodo modificado por Daniel
    public ArrayList<ClaseResultado> obtenerResultado() throws Exception {
        ArrayList<ClaseResultado> clasesResultados = new ArrayList<>();
        Document document = convertStringToXMLDocument(textoXml);
        NodeList resultados = document.getElementsByTagName("resultado");
        for (int i = 0; i < resultados.getLength(); i++) {
            Node resultado = resultados.item(i);
            Element elementResultado = (Element) resultado;
            String categoria = elementResultado.getAttribute("categoria");
            ClaseResultado claseResultado = new ClaseResultado(categoria);

            NodeList tecnologias = elementResultado.getElementsByTagName("tecnologia");
            for (int j = 0; j < tecnologias.getLength(); j++) {
                Node tecnologia = tecnologias.item(j);
                Element elementTecnologia = (Element) tecnologia;
                String nombre = elementTecnologia.getAttribute("nombre");
                int respuestas = Integer.valueOf(elementTecnologia.getAttribute("respuestas"));
                double porcentaje = Double.valueOf(elementTecnologia.getAttribute("porcentaje"));
                ClaseTecnologia claseTecnologia = new ClaseTecnologia(nombre, respuestas, porcentaje);
                claseResultado.addTecnologia(claseTecnologia);
            }
            clasesResultados.add(claseResultado);
        }
        return clasesResultados;
    }

    // Metodos implementados por Daniel
    private Document convertStringToXMLDocument(String textoXml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(textoXml)));
        return document;
    }

}
