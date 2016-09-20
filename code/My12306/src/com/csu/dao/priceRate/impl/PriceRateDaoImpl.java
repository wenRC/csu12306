
package com.csu.dao.priceRate.impl;

import com.csu.dao.priceRate.PriceRateDao;
import com.csu.domain.priceRate.PriceRate;
import com.csu.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by sx on 2016/9/15.
 */
public class PriceRateDaoImpl implements PriceRateDao {
    private static String GET_PRICERATE = "select * from pricerate where tickettype = ?";
    private static String UPDATE_PRICERATE = "update pricerate set tickettype = ?,pricerate = ? where pricerateid = ?";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @Override
    public PriceRate getPriceRateByticketType(String ticketType) {
        PriceRate priceRate = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_PRICERATE);
            preparedStatement.setString(1,ticketType);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                priceRate = new PriceRate();
                priceRate.setPriceRateId(resultSet.getInt(1));
                priceRate.setTicketType(resultSet.getString(2));
                priceRate.setPriceRate(resultSet.getDouble(3));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return priceRate;
    }

    @Override
    public boolean updatePriceRate(PriceRate priceRate) {
        boolean result = false;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_PRICERATE);
            preparedStatement.setString(1,priceRate.getTicketType());
            preparedStatement.setDouble(2,priceRate.getPriceRate());
            preparedStatement.setInt(3,priceRate.getPriceRateId());
            result = preparedStatement.executeUpdate()==1;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return result;
    }
}
