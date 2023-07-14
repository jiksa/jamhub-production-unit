package sage.springcoder.jamhubproductionunit.web.service;

import org.springframework.http.ResponseEntity;
import sage.springcoder.jamhubproductionunit.web.model.JamDto;

import java.util.UUID;

public interface JamService {
    JamDto getJamById(UUID jamId);

    JamDto saveNewJam(JamDto jam);

    public void updateJam(UUID jamId, JamDto jam);

    void deleteById(UUID jamId);
}
