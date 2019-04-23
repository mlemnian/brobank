package net.brobank;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Converter(autoApply = true)
public class OffsetDateTimeAttributeConverter implements AttributeConverter<OffsetDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(OffsetDateTime offsetDateTime) {
        return Optional.ofNullable(offsetDateTime)
                .map(odt -> Timestamp.valueOf(odt.toLocalDateTime()))
                .orElse(null);
    }

    @Override
    public OffsetDateTime convertToEntityAttribute(Timestamp timestamp) {
        return Optional.ofNullable(timestamp)
                .map(ts -> OffsetDateTime.ofInstant(Instant.ofEpochMilli(ts.getTime()), ZoneOffset.UTC))
                .orElse(null);
    }
}