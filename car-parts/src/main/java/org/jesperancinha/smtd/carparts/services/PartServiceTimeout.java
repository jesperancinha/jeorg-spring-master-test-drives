package org.jesperancinha.smtd.carparts.services;

import org.jesperancinha.smtd.carparts.model.jpa.Part;
import org.jesperancinha.smtd.carparts.repos.PartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(timeout = 1)
public class PartServiceTimeout {

    private PartRepository partRepository;

    public PartServiceTimeout(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Transactional(timeout = 100)
    public Part createPart(final Part part) {
        return partRepository.save(part);
    }

    public Part createPartTimeout(final Part part) {
        return partRepository.save(part);
    }

    @Transactional(timeout = 1,
            propagation = Propagation.REQUIRES_NEW)
    public Part createPartExtra(Part part) {
        return partRepository.save(part);
    }

    @Transactional(timeout = 100,
            propagation = Propagation.REQUIRES_NEW)
    public Part createPartMix(Part part) {
        final Part save1 = partRepository.save(part);
        return createPartExtra(save1);
    }
}
