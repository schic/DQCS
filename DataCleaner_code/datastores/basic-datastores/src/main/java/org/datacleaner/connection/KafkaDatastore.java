/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Free Software Foundation, Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.datacleaner.connection;

import java.util.Collection;

import org.apache.metamodel.kafka.KafkaDataContext;
import org.apache.metamodel.util.HasName;

/**
 * Datastore class for Apache Kafka. Uses a Kafka 'bootstrap servers' connection string, a topic list and key+value
 * types to present the Kafka messages to the user as if they are records in a table.
 * Apache Kafka的数据存储类。使用Kafka'引导服务器'连接字符串，
 * 主题列表和键+值类型将Kafka消息呈现给用户，就好像它们是表中的记录一样。
 * 
 * @author davkrause
 */
public class KafkaDatastore extends UsageAwareDatastore<KafkaDataContext<?, ?>> {

    private static final long serialVersionUID = 1L;

    // present type as enum to make selection easy with combo box for user
    public enum KeyValueType implements HasName {
        
        STRING("String", String.class),
        BYTE_ARRAY("Byte array", byte[].class),
        INTEGER("Integer", Integer.class),
        LONG("Long", Long.class),
        DOUBLE("Double", Double.class);

        private final String name;
        private final Class<?> asClass;

        private KeyValueType(String name, Class<?> asClass) {
            this.name = name;
            this.asClass = asClass;
        }

        @Override
        public String getName() {
            return name;
        }

        public Class<?> asClass() {
            return asClass;
        }
    }

    private final String bootstrapServers;
    private final KeyValueType keyType;
    private final KeyValueType valueType;
    private final Collection<String> topics;

    public KafkaDatastore(String name, String bootstrapServers, Collection<String> topics, KeyValueType keyType,
            KeyValueType valueType) {
        super(name);
        this.bootstrapServers = bootstrapServers;
        this.topics = topics;
        this.keyType = keyType;
        this.valueType = valueType;
    }

    @Override
    public PerformanceCharacteristics getPerformanceCharacteristics() {
        return new PerformanceCharacteristicsImpl(true, false);
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected UsageAwareDatastoreConnection<KafkaDataContext<?, ?>> createDatastoreConnection() {
        final KafkaDataContext dataContext =
                new KafkaDataContext(keyType.asClass(), valueType.asClass(), bootstrapServers, topics);
        return new DatastoreConnectionImpl(dataContext, this);
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public Collection<String> getTopics() {
        return topics;
    }

    public KeyValueType getKeyType() {
        return keyType;
    }

    public KeyValueType getValueType() {
        return valueType;
    }
}
