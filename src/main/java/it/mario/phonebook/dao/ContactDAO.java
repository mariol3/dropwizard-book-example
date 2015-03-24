package it.mario.phonebook.dao;

import it.mario.phonebook.dao.mappers.ContactMapper;
import it.mario.phonebook.representations.Contact;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * Created by Mario Grimaldi <mario.grimaldi89@gmail.com> with <3
 */
public interface ContactDAO {

    @Mapper(ContactMapper.class)
    @SqlQuery("select * from contact where id = :id")
    Contact getContactById(@Bind("id") int id);

}
