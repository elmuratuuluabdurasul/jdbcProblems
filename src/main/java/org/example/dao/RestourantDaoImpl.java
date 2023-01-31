package org.example.dao;

import org.example.config.Configuration;
import org.example.model.Restourant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestourantDaoImpl implements RestourantDao{
    private  Connection connection = Configuration.getConnection();

    @Override
    public void createTable() {
        try(Statement statement = connection.createStatement()){
        statement.executeUpdate("create table restourants(" +
                "id serial," +
                "name varchar," +
                "address varchar," +
                "open_year varchar)");
    }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
private String sql = "insert into restourants(name, address,open_year) values (?,?,?)";
    @Override
    public void saveRestourant(Restourant restourant) {
        try(PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql)){
            preparedStatement.setString(1, restourant.getName());
            preparedStatement.setString(2,restourant.getAddress());
            preparedStatement.setString(3, restourant.getOpenYear());
            preparedStatement.executeQuery();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Restourant findById(Long id) {
        String sql = "select * from restourants where id = ?";
        Restourant restourant = new Restourant();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,id);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
            restourant.setId(resultSet.getLong("id"));
            restourant.setName(resultSet.getString(2));
            restourant.setAddress(resultSet.getString(3));
            restourant.setOpenYear(resultSet.getString(4));}
            resultSet.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return restourant;
    }

    @Override
    public List<Restourant> getAllRestourants() {
        List<Restourant> restourantLists = new ArrayList<>();

        String query = "select * from restourants";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Restourant restourant1 = new Restourant();
                restourant1.setId(resultSet.getLong(1));
                restourant1.setName(resultSet.getString(2));
                restourant1.setAddress(resultSet.getString(3));
                restourant1.setOpenYear(resultSet.getString(4));
                restourantLists.add(restourant1);
            }
            resultSet.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return restourantLists;
    }

    @Override
    public void updateRestourant(Long RestourantId, Restourant newRestourant) {
        String sql = "update restourants set name = ?, address = ?, open_year = ? where id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newRestourant.getName());
            preparedStatement.setString(2, newRestourant.getAddress());
            preparedStatement.setString(3, newRestourant.getOpenYear());
            preparedStatement.setLong(4, RestourantId);
            preparedStatement.executeUpdate();
            System.out.println("updated...");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteRestourants() {
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from restourants");
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
