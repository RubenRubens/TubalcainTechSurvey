package com.example.survey.factories;

import com.example.survey.clases.ClaseResultado;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ResultadoFactory {

    private String textoXml;

    public ResultadoFactory(String textoXml) {
        this.textoXml = textoXml;
    }

    // Metodo modificado por Daniel
    public ClaseResultado obtenerResultado() throws Exception {
        Document document = convertStringToXMLDocument(textoXml);
        NodeList resultados = document.getElementsByTagName("resultado");
        String result = document.getDocumentElement().getNodeName() + "\n";
        for (int i = 0; i < resultados.getLength(); i++) {
            Node resultado = resultados.item(i);
            Element elementResultado = (Element) resultado;
            String categoria = elementResultado.getAttribute("categoria");
            result += "\nCategoria: " + categoria + "\n\n";

            NodeList tecnologias = elementResultado.getElementsByTagName("tecnologia");
            for (int j = 0; j < tecnologias.getLength(); j++) {
                Node tecnologia = tecnologias.item(j);
                Element elementTecnologia = (Element) tecnologia;
                String nombre = elementTecnologia.getAttribute("nombre");
                String respuestas = elementTecnologia.getAttribute("respuestas");
                String porcentaje = elementTecnologia.getAttribute("porcentaje");
                result += "\t\tTecnología:" + nombre + " \n\t\tRespuestas:" + respuestas + " \n\t\tPorcentaje:" + porcentaje + "\n\n";
            }
        }
        ClaseResultado resultadoEncuesta = new ClaseResultado(result);
        return resultadoEncuesta;
    }

    // Metodos implementados por Daniel
    private Document convertStringToXMLDocument(String textoXml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(textoXml)));
        return document;
    }

}
