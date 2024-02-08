package com.elearning.generator;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.Statement;

public class CourseIdGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {

        String prefix = "C";
        JdbcConnectionAccess connection = session.getJdbcConnectionAccess();

        try{
            Statement statement =  connection.obtainConnection().createStatement();

            ResultSet rs = statement.executeQuery("select count(course_id) as Id from course");

            if(rs.next()){
                int id = rs.getInt(1)+1;
                String generatedId = prefix+Integer.valueOf(id).toString();
                System.out.println(generatedId);
                return generatedId;
            }

        }catch (Exception e){

        }

        return null;
    }
}
