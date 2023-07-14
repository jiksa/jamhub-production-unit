package sage.springcoder.jamhubproductionunit.web.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sage.springcoder.jamhubproductionunit.web.model.JamDto;
import sage.springcoder.jamhubproductionunit.web.service.JamService;

import java.util.UUID;
@Service
@Slf4j
public class JamServiceImpl implements JamService {

    @Override
    public JamDto getJamById(UUID jamId) {
        return  JamDto.builder().jamId(jamId)
                .jamName("Red Delight")
                .jamFlavor("StrawBerry").build();
    }

    @Override
    public JamDto saveNewJam(JamDto jam) {
        return JamDto.builder().jamId(UUID.randomUUID())
                .jamName(jam.getJamName())
                .jamFlavor("StrawBerry").build();
    }

    @Override
    public void updateJam(UUID jamId, JamDto jam) {

    }

    @Override
    public void deleteById(UUID jamId) {
        log.debug("Deleting Jam..");
    }
}
