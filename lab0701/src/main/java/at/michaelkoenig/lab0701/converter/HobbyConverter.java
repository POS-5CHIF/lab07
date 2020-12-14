package at.michaelkoenig.lab0701.converter;

import at.michaelkoenig.lab0701.model.Hobby;
import at.michaelkoenig.lab0701.repo.HobbyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Michael König
 */
@Component
@RequiredArgsConstructor
public class HobbyConverter implements Converter<Integer, Hobby> {

    private final HobbyRepo hobbyRepo;

    @Override
    public Hobby convert(Integer id) {
        return hobbyRepo.findById(id).orElse(null);
    }

}
