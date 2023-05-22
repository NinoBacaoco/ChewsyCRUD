    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package com.csit228g3.bacaoco.bacaoco_final_project;

    import com.csit228g3.bacaoco.bacaoco_final_project.MySQLConnection.Query;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.logging.Level;
    import java.util.logging.Logger;

    /**
     *
     * @author USER
     */
    public class DBHelper {
        public Query query;

        public DBHelper(){
            try {
                query = new MySQLConnection.Query();
            } catch (SQLException ex) {
                Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void addMealInfoRecords(int meal_number, String type, String title, String description) throws SQLException {
            
            String values = String.format("%d, '%s', '%s', '%s'", meal_number, type, title, description);
            query.update("INSERT INTO tblmealinfo (meal_number, type, title, description) values (" + values + ")");
        }

        public ResultSet getMealInfoRecords() throws SQLException{
            return query.execute("SELECT * FROM tblmealinfo");
        }
        
        public ResultSet getMealInfoByMealNumber(int meal_number) throws SQLException{
                return query.execute("SELECT * FROM tblmealinfo WHERE meal_number = " + meal_number);
        }
        
        public ResultSet getMealInfoByType(String type) throws SQLException{
            return query.execute("SELECT * FROM tblmealinfo WHERE type = '" + type + "'");
        }
        
        public ResultSet getMealInfoByTitle(String title) throws SQLException{
            return query.execute("SELECT * FROM tblmealinfo WHERE title = '" + title + "'");
        }
        
        public ResultSet getMealInfoByDescription(String desc) throws SQLException{
            return query.execute("SELECT * FROM tblmealinfo WHERE description = '" + desc + "'");
        }
        
        public void deleteMealInfoByMealNumber(int meal_number) throws SQLException{
            query.update("DELETE FROM tblmealinfo WHERE meal_number = " + meal_number);
        }
        
        public void editMealInfoByMealNumber(int meal_number, String type, String title, String description) throws SQLException {
            String sql = "UPDATE tblmealinfo SET type = '" + type + "', title = '" + title + "', description = '" + description + "' WHERE meal_number = " + meal_number;
            query.update(sql);
        
        }


        public void close() throws SQLException{
            query.close();
        }

        public static void main(String[] args){
            DBHelper dbHelper = new DBHelper();
        }
    }

