package com.elearning.generator;

import com.github.javafaker.Faker;
import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.IdentityGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

public class AuthorIdGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {

        String prefix = "A";
        JdbcConnectionAccess connection = session.getJdbcConnectionAccess();

        try{
            Statement statement = connection.obtainConnection().createStatement();

            ResultSet rs = statement.executeQuery("select count(author_id) as Id from author");
            if(rs.next()){
                int genId = rs.getInt(1)+1;
                String generatedId = prefix+Integer.valueOf(genId).toString();
                System.out.println("Generated Id: " + generatedId);
                return generatedId;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
