package org.openfact.models.db.connections.jpa.updater.liquibase.conn;

import liquibase.Liquibase;
import liquibase.exception.LiquibaseException;

import java.sql.Connection;

public interface LiquibaseConnectionProvider {

    Liquibase getLiquibase(Connection connection, String defaultSchema) throws LiquibaseException;

    Liquibase getLiquibaseForCustomUpdate(Connection connection, String defaultSchema, String changelogLocation, ClassLoader classloader, String changelogTableName) throws LiquibaseException;

}