package com.elearning.generator;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.EventType;
import org.hibernate.generator.Generator;
import org.hibernate.id.IdentifierGenerator;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.EnumSet;

public class LearnerIdGenerator implements IdentifierGenerator {


    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        String prefix = "LN";
        String suffix = "Id";
        JdbcConnectionAccess connection = session.getJdbcConnectionAccess();

        try{
            Statement statement =  connection.obtainConnection().createStatement();

            ResultSet rs = statement.executeQuery("select count(learner_id) as Id from learner");

            if(rs.next()){
                int id = rs.getInt(1)+1;
                String generatedId = prefix+Integer.valueOf(id).toString()+suffix;
                System.out.println(generatedId);
                return generatedId;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
