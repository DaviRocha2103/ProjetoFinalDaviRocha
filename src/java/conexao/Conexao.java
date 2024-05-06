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
    private static String url = "jdbc:mysql://localhost:3306/dvskts";
    private static String usuario = "root";
    private static String senha = "";
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

