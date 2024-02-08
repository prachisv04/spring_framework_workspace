package com.elearning.generator;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LectureIdGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        String prefix = "lec";
        JdbcConnectionAccess connection = session.getJdbcConnectionAccess();

        try{
            Statement statement = connection.obtainConnection().createStatement();
            ResultSet rs = statement.executeQuery("select count(lecture_id) from lecture ");
            if(rs.next()){
                int id = rs.getInt(1)+1;
                String generatedId = prefix+Integer.valueOf(id).toString();
                return generatedId;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
