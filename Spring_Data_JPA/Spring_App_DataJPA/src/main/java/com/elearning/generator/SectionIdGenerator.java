package com.elearning.generator;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SectionIdGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {

        String prefix = "Section";
        JdbcConnectionAccess connection = session.getJdbcConnectionAccess();

        try {

            Statement statement=connection.obtainConnection().createStatement();

            ResultSet rs=statement.executeQuery("select count(section_id) as Id from section");

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
    return null;
    }
}
