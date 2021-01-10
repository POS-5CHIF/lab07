package at.michaelkoenig.lab0701.converter;

import at.michaelkoenig.lab0701.model.Sex;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Michael König
 */
@Component
public class SexConverter implements Converter<String, Sex> {
    @Override
    public Sex convert(String from) {
        int idx = Integer.parseInt(from);
        return Sex.values()[idx];
    }

}
