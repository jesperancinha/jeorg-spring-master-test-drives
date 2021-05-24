package org.jesperancinha.smtd.carparts.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableCassandraRepositories
@Profile({"test", "prod"})
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        return Collections.singletonList(CreateKeyspaceSpecification.createKeyspace(getKeyspaceName())
                .ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true)
                .withSimpleReplication());
    }

    @Override
    protected List<String> getStartupScripts() {
        return Collections.singletonList("CREATE TABLE IF NOT EXISTS " + getKeyspaceName() + ".part(id int PRIMARY KEY, name text);");
    }


    @Override
    protected String getKeyspaceName() {
        return "carparts";
    }
}