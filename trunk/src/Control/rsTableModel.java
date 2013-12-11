package Control;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.*;

/**
 *
 * @author Hien
 */
public class rsTableModel extends AbstractTableModel {
      private  Vector colHeaders;        
      private  Vector tbData;    
      
      public rsTableModel(ResultSet rsData)  {
        ResultSetMetaData rsMeta;     
          try {
              rsMeta = rsData.getMetaData(); //-- Đọc MetaData của ResultSet
               int count = rsMeta.getColumnCount();                         //-- Xác định số Field trong ResultSet

        tbData = new Vector();
        colHeaders = new Vector(count);
                  //--- Lặp tương ứng với số phần tử của columnHeaders để lấy tên của từng cột trong bảng
        for (int i = 1; i <= count; i++) {
            colHeaders.addElement(rsMeta.getColumnName(i));
        }
           //--- Lặp từ Record đầu tiên đến cuối ResultSet để lấy dữ liệu và Add vào Table
        while (rsData.next()) {
            //--- Khai báo 1 Object Vector có tên là rowData để chứa dữ liệu đọc từ Table
            Vector dataRow = new Vector(count);
                        //-- Lặp dựa theo số cột của bảng để lấy thông tin của từng đối tượng bỏ vào trong dataRow
            for (int i = 1; i <= count; i++) {
                dataRow.addElement(rsData.getObject(i));
            }
            tbData.addElement(dataRow);
        }
          } catch (SQLException ex) {
              Logger.getLogger(rsTableModel.class.getName()).log(Level.SEVERE, null, ex);
          }
       
    }
    public int getColumnCount() {
          return colHeaders.size();
    }
    public int getRowCount() {
        return tbData.size();
    }
    
    public String getColumnName(int column) {
        return (String) (colHeaders.elementAt(column));
    }
    
    public Object getValueAt(int row, int column) {
        Vector rowData = (Vector) (tbData.elementAt(row));
        return rowData.elementAt(column);
    }
    
}
