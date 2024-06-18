/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Senai
 */
public class Conexao {
    private static String url = "jdbc:mysql://db4free.net:3306/dvskts_1?user?useSSL=false";
    private static String usuario = "senai_davi_r1";
    private static String senha = "davi210306";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static java.sql.Connection conectar(){
        java.sql.Connection conec = null;
        try{
            Class.forName(DRIVER);
            conec = DriverManager.getConnection(url, usuario, senha);
        }catch(Exception e){ 
        }
        return conec;
    }
  }  

