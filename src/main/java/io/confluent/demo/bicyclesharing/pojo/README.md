To register the exact same JSON Schema that was defined, inject the original .json schema
with the @Schema annotation above the class definition:

import io.confluent.kafka.schemaregistry.annotations.Schema;
@Schema(value="JSON SCHEMA GOES HERE",refs = {})

Then run `mvn compile -DskipGenPOJ`
