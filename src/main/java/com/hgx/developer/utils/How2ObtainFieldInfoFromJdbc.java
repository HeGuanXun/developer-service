package com.hgx.developer.utils;
 
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import lombok.extern.slf4j.Slf4j;
 
import java.sql.*;
 
/**
 * 如何从jdbc中获取数据库建表语句信息(表字段名称/表字段类型/表字段注释信息/表字段长度等等)
 * 1，表字段名称
 * 2，表字段类型
 * 3，表字段注释信息
 */
@Slf4j
public class How2ObtainFieldInfoFromJdbc {
 
    private static Connection connection;
 
    public static void main(String[] args) {
 
        How2ObtainFieldInfoFromJdbc how2ObtainFieldInfoFromJdbc = new How2ObtainFieldInfoFromJdbc();
        // 第一种方式：执行sql语句获取 select * from user_pop_info where 1 = 2
        //how2ObtainFieldInfoFromJdbc.method1();
        // 第二种方式：执行sql语句获取 show create table user_pop_info
        how2ObtainFieldInfoFromJdbc.method2();
        // 第二种方式：直接从jdbc数据库连接Connection实例中获取
        how2ObtainFieldInfoFromJdbc.method3();
    }
 
    private void method1() {
 
        try{
 
            PreparedStatement preparedStatement = connection.prepareStatement("select * from capital_account where 1 = 2");
            ResultSetMetaData resultSetMetaData = preparedStatement.executeQuery().getMetaData();
 
            for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
 
                log.info("数据库实例名:{}", resultSetMetaData.getCatalogName(i + 1));
                log.info("表名:{}", resultSetMetaData.getTableName(i + 1));
                log.info("java类型:{}", resultSetMetaData.getColumnClassName(i + 1));
                log.info("数据库类型:{}", resultSetMetaData.getColumnTypeName(i + 1));
                log.info("字段名称:{}", resultSetMetaData.getColumnName(i + 1));
                log.info("字段长度:{}", resultSetMetaData.getColumnDisplaySize(i + 1));
                log.info("getColumnType:{}", resultSetMetaData.getColumnType(i + 1));
                log.info("getPrecision:{}", resultSetMetaData.getPrecision(i + 1));
                log.info("getScale:{}", resultSetMetaData.getScale(i + 1));
                log.info("getSchemaName:{}", resultSetMetaData.getSchemaName(i + 1));
                log.info("getScale:{}", resultSetMetaData.getScale(i + 1));
            }
        } catch (Exception e) {
            log.error("method1 error ", e);
        }
    }
 
    private void method2() {
 
        try{
 
            PreparedStatement preparedStatement2 = connection.prepareStatement("show create table capital_account");
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            while(resultSet2.next()) {
                String tableName = resultSet2.getString("Table");
                String createTable = resultSet2.getString("Create Table");
                String tableComment = createTable.split("COMMENT=")[1];
                String[] split = tableComment.split("'");
                log.info("tableName:{}", tableName);
                log.info("createTable:");
                System.out.println(createTable);
            }
        } catch (Exception e) {
            log.error("method2 error ", e);
        }
    }
 
    private void method3() {
 
        try{
 
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            // 获取所有表
            ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[]{"TABLE"});
            // 获取指定表
            ResultSet specificResultSet = databaseMetaData.getColumns(null, "%", "capital_account", "%");
 
            String columnName2;
            String columnType2;
            String comment2;
            while(specificResultSet.next()) {
 
                columnName2 = specificResultSet.getString("COLUMN_NAME");
                columnType2 = specificResultSet.getString("TYPE_NAME");
                comment2 = specificResultSet.getString("REMARKS");
                log.info("COLUMN_NAME:{}", columnName2);
                log.info("TYPE_NAME:{}", columnType2);
                log.info("REMARKS:{}", comment2);
            }
 
        } catch (Exception e) {
            log.error("method3 error ", e);
        }
    }
 
    static {
 
        try{
            // 数据源配置
            DataSourceConfig dataSourceConfig = new DataSourceConfig();
            dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/invoicing?serverTimezone=GMT%2b8&Unicode=true&characterEncoding=utf8");
            dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
            dataSourceConfig.setUsername("root");
            dataSourceConfig.setPassword("123456");
 
            connection = dataSourceConfig.getConn();
        } catch (Exception e) {
            log.error("autoCodeGeneratorProcess error ", e);
        }
 
    }
}