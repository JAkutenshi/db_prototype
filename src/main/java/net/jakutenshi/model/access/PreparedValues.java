package net.jakutenshi.model.access;

import net.jakutenshi.model.sql.SQLEntity;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedValues<T extends SQLEntity> {
    PreparedStatement prepare(PreparedStatement st) throws SQLException;
}
