package com.adapter.application.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSMRDBMethods {
    
    private String mCommon = "testval";
        
     /*
     Method		: readResultSet(String inSqlStmt,Connection inConnection)
     Brief 		: This method is used to read ResultSet
     Input param	: String inSqlStmt,Connection inConnection
     Input/output param	: Connection,ResultSet
     Return value	: ResultSet
     */
    public ResultSet readResultSet(String inSqlStmt, Connection inConnection) {
        Statement Statement = null;
        ResultSet RS = null;
        try {
            Statement = inConnection.createStatement();
            inSqlStmt = getDDLScript(inSqlStmt);
            RS = Statement.executeQuery(inSqlStmt);
        } catch (SQLException Exc) {
            Exc.printStackTrace();
        } finally {
            Statement = null;
            return RS;
        }
    }
    
     public void closeResultSet(ResultSet inResultSet) {
        try {
            if (inResultSet != null) {
                inResultSet.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     /*
     Method		: getDDLScript(String inSqlStmt)
     Brief 		: This method does some manipulation on the specified script and returns the processed string.
     Input param	: String inSqlStmt
     Input/output param	: String
     Return value	: String
     */
    private String getDDLScript(String inSqlStmt) {
        StringBuffer SB;
        Pattern Pat;
        Matcher Mat;
        String SqlVar = inSqlStmt;
        boolean bResult;
        if (SqlVar.indexOf("CSWMSQL_FINAL") >= 0) {
            Pat = Pattern.compile("CSWMSQL_FINAL");
            Mat = Pat.matcher(SqlVar);
            SB = new StringBuffer();
            bResult = Mat.find();
            while (bResult) {
                Mat.appendReplacement(SB, "'" + mCommon + "'");
                bResult = Mat.find();
            }
            Mat.appendTail(SB);
            SqlVar = SB.toString();
        }
        if (SqlVar.indexOf("CSWMSQL_LCASE") >= 0) {
            Pat = Pattern.compile("CSWMSQL_LCASE");
            Mat = Pat.matcher(SqlVar);
            SB = new StringBuffer();
            bResult = Mat.find();
            while (bResult) {
                Mat.appendReplacement(SB, "AES_ENCRYPT");
                bResult = Mat.find();
            }
            Mat.appendTail(SB);
            SqlVar = SB.toString();
        }
        if (SqlVar.indexOf("CSWMSQL_UCASE") >= 0) {
            Pat = Pattern.compile("CSWMSQL_UCASE");
            Mat = Pat.matcher(SqlVar);
            SB = new StringBuffer();
            bResult = Mat.find();
            while (bResult) {
                Mat.appendReplacement(SB, "AES_DECRYPT");
                bResult = Mat.find();
            }
            Mat.appendTail(SB);
            SqlVar = SB.toString();
        }
        SB = null;
        Pat = null;
        Mat = null;
        return SqlVar;
    }
}
