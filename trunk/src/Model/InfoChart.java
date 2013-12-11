/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author dodan_000
 */
public class InfoChart {
    public String sql;
    public String title1;
    public String title2;
    public String title3;
    
    public InfoChart(String sql,String title1,String title2,String title3){
        this.sql=sql;
        this.title1=title1;
        this.title2=title2;
        this.title3=title3;
    }
}
