package Control;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dodan_000
 */
import Model.InfoImportExport;
import Control.Database;
import GUI.StatisticsChartFrame;
import Model.InfoChart;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ImportExport {

    public ImportExport() {
    }

    private boolean insert_import(InfoImportExport infoIE) {
        ResultSet kq = null;
        int sohang = 0;
        String lenh = "insert into importing(id,date,value,note,imageURL,import_type_id,user_id)values";
        try {
            lenh += "(";
            lenh += "null" + ",";//cho nay thieu truong id
            lenh += "'" + infoIE.date + "',";
            lenh += infoIE.value + ",";
            lenh += "'" + infoIE.note + "',";
            lenh += "'" + infoIE.imageURL +"',";
            lenh += +infoIE.type_id + ",";
            lenh += +infoIE.user_id + ");";
            Database.stm.executeUpdate(lenh);
        } catch (Exception e) {
            System.err.println("Khong them duoc thong tin import");
            return false;
        }
        return true;
    }

    private boolean insert_export(InfoImportExport infoIE) {
        ResultSet kq = null;
        int sohang = 0;
        String lenh = "insert into exporting(id,date,value,note,imageURL,export_type_id,user_id)values";
        try {

            lenh += "(";
            lenh += "null" + ",";//cho nay thieu truong id
            lenh += "'" + infoIE.date + "',";
            lenh += infoIE.value + ",";
            lenh += "'" + infoIE.note + "',";
            lenh += "'" + infoIE.imageURL +"',";
            lenh += +infoIE.type_id + ",";
            lenh += +infoIE.user_id + ");";
            Database.stm.executeUpdate(lenh);
        } catch (Exception e) {
            System.err.println("Khong them duoc thong tin export");
            return false;
        }
        return true;
    }

    public boolean insert(InfoImportExport infoIE) {
        if (infoIE.isImport) {
            return insert_import(infoIE);
        } else {
            return insert_export(infoIE);
        }
    }
    //chen import hoac export tuy thuoc vao gia tri isImport

    private boolean update_import(int id, InfoImportExport infoIE) {
        try {
            String lenh = "update importing set ";
            lenh += "value=" + infoIE.value + ",";
            lenh += "date=" + "'" + infoIE.date + "'" + ",";
            lenh += "import_type_id=" + infoIE.type_id + ",";
            lenh += "note=" + "'" + infoIE.note + "'" + ",";
            lenh += "imageURL="+"'"+infoIE.imageURL+"'";
            //lenh+="user_id="+infoIE.user_id;
            lenh += " where id=" + id;
            lenh += ";";
            System.out.println(lenh);
            if (Database.stm.executeUpdate(lenh) > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.err.println("Khong cap nhat duoc thong tin import");
            return false;
        }


    }

    private boolean update_export(int id, InfoImportExport infoIE) {
        try {

            String lenh = "update exporting set ";
            lenh += "value=" + infoIE.value + ",";
            lenh += "date=" + "'" + infoIE.date + "'" + ",";
            lenh += "export_type_id=" + infoIE.type_id + ",";
            lenh += "note=" + "'" + infoIE.note + "'"+",";
            lenh += "imageURL="+"'"+infoIE.imageURL+"'";
            //lenh+="user_id="+infoIE.user_id;
            lenh += " where id=" + id;
            lenh += ";";
            System.out.println(lenh);
            if (Database.stm.executeUpdate(lenh) > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.err.println("Khong cap nhat duoc thong tin export");
            return false;
        }
    }

    public boolean update(int id, InfoImportExport infoIE) {
        if (infoIE.isImport) {
            return update_import(id, infoIE);
        } else {
            return update_export(id, infoIE);
        }
    }

    private boolean delete_import(int id) {
        try {
            String lenh = "delete from importing ";
            lenh += " where id=" + id;
            lenh += ";";

            Database.stm.executeUpdate(lenh);

        } catch (Exception e) {
            System.err.println("Khong xoa duoc thong tin import");
            return false;
        }

        return true;
    }

    private boolean delete_export(int id) {
        try {
            String lenh = "delete from exporting ";
            lenh += " where id=" + id;
            lenh += ";";

            Database.stm.executeUpdate(lenh);

        } catch (Exception e) {
            System.err.println("Khong xoa duoc thong tin export");
            return false;
        }

        return true;
    }

    public boolean delete(int id, boolean isImport) {
        if (isImport) {
            return delete_import(id);
        } else {
            return delete_export(id);
        }
    }

    public ArrayList getImportTypeList() {
        ArrayList<String> list = new ArrayList<String>();

        ResultSet rs;
        try {
            rs = Database.stm.executeQuery("select type from import_type");
            while (rs.next()) {
                list.add(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImportExport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList getExportTypeList() {
        ArrayList<String> list = new ArrayList<String>();

        ResultSet rs;
        try {
            rs = Database.stm.executeQuery("select type from Export_type");
            while (rs.next()) {
                list.add(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImportExport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    Privilege privilege = new Privilege();

    public ResultSet getData(int fromUserId, int toUserId, int type_id, boolean isImport) {
        String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "";
        ResultSet rs = null;
        Privilege p = new Privilege();
        ArrayList<Integer> list;

        if (isImport) {
            s1 = "import";
            s2 = "importing";
            list = p.getPrivilegeId(fromUserId, toUserId, 1);
        } else {
            s1 = "export";
            s2 = "exporting";
            list = p.getPrivilegeId(fromUserId, toUserId, 2);
        }

        //Loc theo quyen han
        if (fromUserId == toUserId || fromUserId == 1) {
            s3 = "";
        } else {
            for (int i : list) {
                s4 += list.get(i) + ",";
            }
            s4 += 0;
            s3 = " and " + s1 + "_type_id in(" + s4 + ")";
        }

        if (type_id == 0) {
            s5 = "";
        } else {
            s5 = " and " + s1 + "_type_id = " + type_id;
        }

        String sql = "select x.id,user.userName as UserName,x.date as Date," + s1 + "_type.type,x.value as Value,x.note as Note,x.imageURL"
                + " from (select * from " + s2 + " where user_id=" + toUserId + s3 + s5 + ")as x,user," + s1 + "_type"
                + " where x.user_id=user.id  and x." + s1 + "_type_id = " + s1 + "_type.id";
        System.out.println(sql);
        try {
            rs = Database.stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ImportExport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int getImportId(String type) {
        ResultSet rs = null;
        int id = 0;
        try {
            rs = Database.stm.executeQuery("select id from import_type where type='" + type+"';");
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException ex) {
            //
        }
        return id;
    }
    
    public String getImportType(int id){
        ResultSet rs = null;
        String type ="";
        try{
            rs = Database.stm.executeQuery("select type from import_type where id="+id);
            rs.next();
            type=rs.getString(1);
        }catch(SQLException ex){
            
        }
        return type;
    }
    public String getExportType(int id){
        ResultSet rs = null;
        String type ="";
        try{
            rs = Database.stm.executeQuery("select type from export_type where id="+id);
            rs.next();
            type=rs.getString(1);
        }catch(SQLException ex){
            
        }
        return type;
    }
    public int getExportId(String type) {
        ResultSet rs = null;
        int id = 0;
        System.out.println(type);
        try {
            rs = Database.stm.executeQuery("select id from export_type where type='" + type+"';");
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException ex) {
            
        }     
        return id;
    }
    
    public ArrayList<String> getImportExportListWithPrivilege(int fromUserId, int toUserId, boolean isImport) {
        if (fromUserId == toUserId) {
            return isImport ? this.getImportTypeList() : this.getExportTypeList();
        } else {
            ArrayList<String> list = new ArrayList<>();
            String s1 = "";
            if (isImport) {
                s1 = "import_type";
            } else {
                s1 = "export_type";
            }

            ResultSet rs = null;
            try {
                rs = Database.stm.executeQuery("select " + s1 + ".type from " + s1 + ", privilege where privilege.from_id=" + fromUserId + " and " + s1 + ".id=privilege.subType_id and privilege.to_id=" + toUserId + " group by privilege.subType_id");
                while (rs.next()) {
                    list.add(rs.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
        }
    }
    
    public String getStringSql(int fromUserId, int toUserId, int type_id, boolean isImport, String startDay, String endDay){
        String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "";
        Privilege p = new Privilege();
        ArrayList<Integer> list = new ArrayList<>();

        if (isImport) {
            s1 = "import";
            s2 = "importing";
            list = p.getPrivilegeId(fromUserId, toUserId, 1);
        } else {
            s1 = "export";
            s2 = "exporting";
            list = p.getPrivilegeId(fromUserId, toUserId, 2);
        }
        //Loc theo quyen han
        if (fromUserId == toUserId || fromUserId == 1) {
            s3 = "";
        } else {
            for (int i=0;i<list.size();i++) {
                s4 += list.get(i) + ",";
            }
            s4 += 0;
            s3 = " and " + s1 + "_type_id in(" + s4 + ")";
        }

        if (type_id == 0) {
            s5 = "";
        } else {
            s5 = " and " + s1 + "_type_id = " + type_id;
        }

        String sql = "select x.id,user.userName as UserName,x.date as Date," + s1 + "_type.type,x.value as Value,x.note as Note,x.imageURL"
                + " from (select * from " + s2 + " where user_id=" + toUserId + s3 + s5 + ")as x,user," + s1 + "_type"
                + " where x.user_id=user.id  and x." + s1 + "_type_id = " + s1 + "_type.id" + " and x.date between '"+startDay+"' and '"+endDay+"';";
        
        return sql;
    }
    
    
    private InfoChart getInfoChart(int userId,boolean isImport,int subType_id,int month,int year,int caseSQL){
        String sql = "", s1, s2, s3,s4;
        String title1 = "", title2 = "", title3 = "";
        
        if (isImport) {
            s1 = "importing";
            s2 = "import_type_id";
            s3 = "thu nhập";
            s4 = "import_type";
            
        } else {
            s1 = "exporting";
            s2 = "export_type_id";
            s3 = "chi tiêu";
            s4 = "export_type";         
        }
        
        switch (caseSQL) {
            case 0:
                sql = "select sum(value),year(date) from " + s1 + " where user_id=" + userId + " group by(year(date))";
                title1 = "";
                title2 = "Bảng thống kê " + s3 + " các năm";
                title3 = "";
                break;
            case 1:
                sql = "select sum(value),month(date) from " + s1 + " where user_id=" + userId + " and year(date)=" + year + " group by (month(date))";
                title1 = "T.";
                title2 = "Bảng thống kê " + s3 + " trong năm " + year;
                title3 = "";
                break;
            case 2:
                sql = "select sum(value),year(date) from " + s1 + " where user_id=" + userId + " and month(date)=" + month + " group by (year(date))";
                title1 = "";
                title2 = "Bảng thống kê " + s3 + " tháng " + month + " trong các năm";
                title3 = "";
                break;
            case 3:
                sql = "select x.sum,y.type from (select sum(value) sum," + s2  + " from "+s1+" where user_id=" + userId + " and month(date)=" + month + " and year(date)=" + year + " group by " + s2+") as x,"+s4+" as y where x."+s2+"=y.id";
                title1 = "";
                title2 = "Bảng thống kê " + s3 + " tháng " + month + " trong năm " + year;
                title3 = "";
                break;
            case 4:
                sql = "select sum(value),year(date) from " + s1 + " where user_id=" + userId + " and " + s2 + "=" + subType_id + " group by (year(date))";
                title1 = "";
                title2 = "Bảng thống kê " + s3 + " '" +  (isImport?getImportType(subType_id):getExportType(subType_id)) + "' trong các năm";
                title3 = "";
                break;
            case 5:
                sql = "select sum(value),month(date) from " + s1 + " where user_id=" + userId + " and " + s2 + "=" + subType_id + " and year(date)=" + year + " group by (month(date))";
                title1 = "T.";
                title2 = "Bảng thống kê " + s3 + " '" + (isImport?getImportType(subType_id):getExportType(subType_id)) + "' trong năm " + year;
                title3 = "";
                break;
            case 6:
                sql = "select sum(value),year(date) from " + s1 + " where user_id=" + userId + " and month(date)=" + month + " group by (year(date))";
                title1 = "";
                title2 = "Bảng thống kê " + s3 + " '" + (isImport?getImportType(subType_id):getExportType(subType_id)) + "' tháng " + month + " trong các năm";
                title3 = "";
                break;
            case 7:
                sql = "select sum(value),year(date) from " + s1 + " where user_id=" + userId + " and month(date)=" + month + " and year(date)=" + year;
                title1 = "";
                title2 = "Bảng thống kê " + s3 + " '" + (isImport?getImportType(subType_id):getExportType(subType_id)) + "' tháng " + month + " trong năm " + year;
                title3 = "";
                break;
        }        
        
        return (new InfoChart(sql,title1,title2,title3));
    }
    public JFreeChart getChart(int userId,boolean isImport,int subType_id,int month,int year,int caseSQL,int chartType){
        
        ResultSet rs;
        JFreeChart chart=null;    
        InfoChart infoChart = getInfoChart(userId, isImport, subType_id, month, year, caseSQL);
              
        try {
            rs = Database.stm.executeQuery(infoChart.sql);          
            
            if (chartType==1) {
                DefaultPieDataset pieDataset = new DefaultPieDataset();
                while (rs.next()) {
                    pieDataset.setValue(infoChart.title1 + rs.getString(2), rs.getInt(1));                           
                }
                chart = ChartFactory.createPieChart3D(infoChart.title2, pieDataset, true, true, true);
            }   
            if(chartType==2){
                DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
               
                while (rs.next()) {
                    categoryDataset.setValue(rs.getInt(1), "", infoChart.title1 + rs.getString(2));                   
                }
                chart = ChartFactory.createBarChart3D("", infoChart.title2, infoChart.title3, categoryDataset, PlotOrientation.VERTICAL, false, true, false);             
            }        
            
        } catch (SQLException ex) {
            Logger.getLogger(StatisticsChartFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chart;
    }
}
