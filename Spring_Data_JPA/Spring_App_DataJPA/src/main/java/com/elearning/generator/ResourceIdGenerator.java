package com.elearning.generator;

import java.sql.*;
import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ResourceIdGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object)  throws HibernateException {

        String prefix = "R";
        JdbcConnectionAccess connection = session.getJdbcConnectionAccess();

        try {

            Statement statement=connection.obtainConnection().createStatement();

            ResultSet rs=statement.executeQuery("select count(resource_id) as Id from resource");

            if(rs.next())
            {
                int id=rs.getInt(1)+1;
                String generatedId = prefix +Integer.valueOf(id).toString();
                System.out.println("Generated Id: " + generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return "R9999";
    }
}
