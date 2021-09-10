/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.templetes;


/**
 *
 * @author Miguel_Ike
 */
public class Templates {
        
        public String plantillaM(){
            String s = "<!DOCTYPE html>\n" +
"<html>\n" +
"\n" +
"<head>\n" +
"    <title></title>\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"\n" +
"    <style type=\"text/css\" >\n" +
"       \n" +
"\n" +
"        .plantillaMiguel{\n" +
"            background-color: #ca97f3;\n" +
"        }\n" +
"\n" +
"        ul.plantillaMiguel{\n" +
"            list-style-type: none;\n" +
"            margin: 0;\n" +
"            padding: 0;\n" +
"            width: 300px;\n" +
"            \n" +
"        }\n" +
"\n" +
"        li a {\n" +
"            display: block;\n" +
"            color: #000;\n" +
"            padding: 8px 16px;\n" +
"            text-decoration: none;\n" +
"        }\n" +
"\n" +
"        /* Change the link color on hover */\n" +
"        li a:hover {\n" +
"            background-color: rgb(25, 148, 25);\n" +
"            ;\n" +
"            color: white;\n" +
"        }\n" +
"    </style>\n" +
"    <h1 style=\"text-align: center; color: rgb(19, 9, 9);\">SISTEMA FIRESTILL</h1>\n" +
"\n" +
"    <div>\n" +
"        <div>\n" +
"            <H3>GESTIONAR PROVEEDORES</H3>\n" +
"        </div>\n" +
"        <ul class=\"plantillaMiguel\">\n" +
"            <li><a\n" +
"                    href=\"mailto:grupo13sc@mail.ficct.uagrm.edu.bo?subject= Registrar Proveedor: nombre, nit, titular, direccion, email, nro_cuenta, banco, telefono, informacion, sucursal\">\n" +
"                    REGISTRAR PROVEEDOR</a>\n" +
"            </li>\n" +
"\n" +
"            <li><a\n" +
"                    href=\"mailto:grupo13sc@mail.ficct.uagrm.edu.bo?subject= Modificar Proveedor: id, nombre, nit, titular, direccion, email, nro_cuenta, banco, telefono, informacion, sucursal\">Modificar\n" +
"                    Proveedor</a>\n" +
"            </li>\n" +
"\n" +
"            <li><a href=\"mailto:grupo13sc@virtual.fcet.uagrm.edu.bo?subject= Eliminar Proveedor: id\">Eliminar\n" +
"                    Proveedor</a>\n" +
"            </li>\n" +
"\n" +
"            <li><a href=\"mailto:grupo13sc@virtual.fcet.uagrm.edu.bo?subject= Mostrar Proveedor: id\">Mostrar\n" +
"                    Proveedor</a>\n" +
"            </li>\n" +
"\n" +
"            <li><a href=\"mailto:grupo13sc@virtual.fcet.uagrm.edu.bo?subject= Listar Proveedor\">Listar\n" +
"                    Proveedor</a>\n" +
"            </li>\n" +
"        </ul>\n" +
"\n" +
"        <div>\n" +
"            <H3>GESTIONAR CATEGORIA</H3>\n" +
"        </div>\n" +
"        <ul>\n" +
"            <li><a\n" +
"                    href=\"mailto:grupo13sc@mail.ficct.uagrm.edu.bo?subject= Registrar Categoria: nombre, nit, titular, direccion, email, nro_cuenta, banco, telefono, informacion, sucursal\">\n" +
"                    REGISTRAR CATEGORIA</a>\n" +
"            </li>\n" +
"\n" +
"            <li><a\n" +
"                    href=\"mailto:grupo13sc@mail.ficct.uagrm.edu.bo?subject= Modificar Categoria: id, nombre, nit, titular, direccion, email, nro_cuenta, banco, telefono, informacion, sucursal\">Modificar\n" +
"                    CATEGORIA</a>\n" +
"            </li>\n" +
"\n" +
"            <li><a href=\"mailto:grupo13sc@virtual.fcet.uagrm.edu.bo?subject= Eliminar Categoria: id\">Eliminar\n" +
"                CATEGORIA</a>\n" +
"            </li>\n" +
"\n" +
"            <li><a href=\"mailto:grupo13sc@virtual.fcet.uagrm.edu.bo?subject= Mostrar Categoria: id\">Mostrar\n" +
"                CATEGORIA</a>\n" +
"            </li>\n" +
"<li><a href=\"mailto:grupo13sc@virtual.fcet.uagrm.edu.bo?subject= Listar Categoria\">Listar\n" +
"                CATEGORIA</a>\n" +
"            </li>\n" +
"        </ul>\n" +
"    </div>\n" +
"\n" +
"\n" +
"    <table style=\"text-align: center;\">\n" +
"        <tr>\n" +
"            <td>\n" +
"            </td>\n" +
"            <td style=\"height: 41.5px; width: 204px;\">&nbsp;\n" +
"                <a class=\"btnGestion\" href=\"mailto:grupo10sa@mail.ficct.uagrm.edu.bo?subject=AYUDA:;\">\n" +
"                    Ayuda\n" +
"                </a>\n" +
"            </td>\n" +
"\n" +
"        </tr>\n" +
"    </table>\n" +
"</body>\n" +
"\n" +
"</html>";
            
            return s;
        }
        public String generarHTML(String contenido){
            String html=getInicio()+contenido+getFin();
            return html;
        }
        private String getInicio(){
            String htmlInicio = "<!DOCTYPE html>\n" +
                            "<html>\n" +
                            "<head>\n" +
                            "	<title>Title of the document</title>\n" +
                            "\n" +
                            "<style type=\"text/css\">\n" +
                            "\n" +
                            "  table.tablaTecno{\n" +
                            "    border-spacing:1;\n" +
                            "    border-collapse:collapse;\n" +
                            "    background:#fff;\n" +
                            "    border-radius:10px;\n" +
                            "    overflow:hidden;\n" +
                            "    width:80%;\n" +
                            "    margin:0 auto;\n" +
                            "    position:relative;\n" +
                            "  }\n" +
                            "\n" +
                            "  td.tdcol1Tecno{\n" +
                            "    text-align: center;\n" +
                            "    width: 60px;\n" +
                            "  }\n" +
                            "\n" +
                            "  th.thcolxTecno{\n" +
                            "    text-align: left;\n" +
                            "  }\n" +
                            "\n" +
                            "  tr.trCamposTecno{\n" +
                            "    height:60px;\n" +
                            "    background:#36304a;\n" +
                            "    font-family:sans-serif;\n" +
                            "    font-size: 18px;\n" +
                            "    color: #fff;\n" +
                            "    line-height: 1.2;\n" +
                            "    font-weight: unset;\n" +
                            "  }\n" +
                            "\n" +
                            "  tr.trDatosTecno{\n" +
                            "    font-size: 15px;\n" +
                            "  }\n" +
                            "\n" +
                            "  tr.trDatosTecno:hover{\n" +
                            "    color:#555;background-color:#f5f5f5;cursor:pointer;\n" +
                            "  }\n" +
                            "\n" +
                            "\n" +
                            "</style>\n" +
                            "</head>\n" +
                            "\n" +
                            "<body>\n" +
                            "<div >\n" ;
            return htmlInicio;
        }
        
        private String getFin(){
            String htmlFin = "</div>\n" +
                    "</body>\n" +
                    "\n" +
                    "</html>";
            return htmlFin;
        }
        public String respuesta(Object contenido){
            
        
        return "";
    }

    public String generarMostrarHTML(String contenido){
            String incio = "<html lang=\"es\">\n" +
                    "<head>\n" +
                    "  <style type=\"text/css\">\n" +
                    "    .tecno_input {\n" +
                    "      width: 90%;\n" +
                    "      padding: 12px 20px;\n" +
                    "      margin: 10px 0px 20px;\n" +
                    "      border: 1px solid #ccc;\n" +
                    "      border-radius: 4px;\n" +
                    "      webkit-box-sizing: border-box;\n" +
                    "      -moz-box-sizing: border-box;\n" +
                    "      box-sizing: border-box;\n" +
                    "      background-color: #ffffff;\n" +
                    "    }\n" +
                    "\n" +
                    "    .tecno_recuadro {\n" +
                    "      border-radius: 5px;\n" +
                    "      background-color: #f2f2f2;\n" +
                    "      padding: 20px;\n" +
                    "    }\n" +
                    "\n" +
                    "    table.tablaTecno{\n" +
                    "      border-spacing:1px;\n" +
                    "      border-collapse:collapse;\n" +
                    "      background:#fff;\n" +
                    "      border-radius:10px;\n" +
                    "      overflow:hidden;\n" +
                    "      width:80%;\n" +
                    "      margin:0 auto;\n" +
                    "      position:relative;\n" +
                    "    }\n" +
                    "\n" +
                    "    td.tdcol1Tecno{\n" +
                    "      text-align: center;\n" +
                    "      width: 60px;\n" +
                    "    }\n" +
                    "\n" +
                    "    th.thcolxTecno{\n" +
                    "      text-align: left;\n" +
                    "    }\n" +
                    "\n" +
                    "    tr.trCamposTecno{\n" +
                    "      height:60px;\n" +
                    "      background:#36304a;\n" +
                    "      font-family:sans-serif;\n" +
                    "      font-size: 18px;\n" +
                    "      color: #fff;\n" +
                    "      line-height: 1.2;\n" +
                    "      font-weight: unset;\n" +
                    "    }\n" +
                    "\n" +
                    "    tr.trDatosTecno{\n" +
                    "      font-size: 15px;\n" +
                    "    }\n" +
                    "\n" +
                    "    tr.trDatosTecno:hover{\n" +
                    "      color:#555;background-color:#f5f5f5;cursor:pointer;\n" +
                    "    }\n" +
                    "\n" +
                    "  </style>\n" +
                    "</head>\n" +
                    "\n" +
                    "<body>";
            String fin = "</body>\n" +
                    "</html>";
            String html = incio + contenido + fin;
            return html;
    }

}
